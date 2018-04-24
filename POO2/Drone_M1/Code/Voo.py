from time import sleep


class Voo():

    __latitude = 0.0
    __longitude = 0.0
    __altura = 0.0
    __velocidade = 0.0

    def __init__(self, latitude, longitude):
        self.__latitude = latitude
        self.__longitude = longitude

    def irPara(self, latitudeDestino, longitudeDestino):

        latitude = self.getLatitude()
        longitude = self.getLongitude()
        while(self.getLatitude() != latitudeDestino or self.getLongitude() != longitudeDestino and
                self.__modulo.getDrone().getBateria().getBateria() > 0):

            if (self.__velocidade < 100):
                self.aumentarVelocidade()
                sleep(0.1)

            self.__decideRota(latitude, longitude, latitudeDestino, longitudeDestino)
            self.__modulo.getDrone().getBateria().consumindoBateria()
            self.__modulo.getAbastecimento().sensorDispensavel()
            print("POSICAO ATUAL: ", "%.7f" % self.getLatitude(), "%.7f" % self.getLongitude(), "           POSICAO DESTINO: ", "%.7f" % latitudeDestino, "%.7f" % longitudeDestino)
            sleep(0.005)
        print("CHEGOU AO PONTO")
        sleep(1.5)

        if (self.__modulo.getDrone().getBateria().getBateria() == 0):
            print("BATERIA ESGOTADA... QUEDA LIVRE INICIADA")
            while(self.getAltura() > 0):
                self.descer()
                sleep(0.1)

    def __deslocamento(self):
        return 0.000001 * self.getVelocidade()

    # Sobe drone ate 100 metros
    def subir(self):
        if(self.__altura < 100):
            self.__altura = self.__altura + 1
            #Print.mostraAltura(self.__altura)
            print("Altura aumentando: ", self.getAltura())
        else:
            print("Limite de altura alcancado!!!")
            #Print.limitealtura()

    # Desce drone ate 0 metros
    def descer(self):
        if(self.__altura > 0):
            self.__altura = self.__altura - 1
            #Print.mostraAltura(self.__altura)
            print("Altura diminuindo: ", self.getAltura())
        else:
            #Print.limitealtura()
            print("Chão alcançado")
            sleep(1.0)

    # Aumenta velocidade do drone ate 100 km/h
    def aumentarVelocidade(self):
        if(self.__velocidade < 100 and self.__altura >= 40):
            self.__velocidade = (self.__velocidade) + 5
            #Print.mostraVelocidade(self.__velocidade)
            print("Velocidade aumentando: ", self.getVelocidade())
        else:
            #Print.LimiteVelocidade()
            print("Velocidade maxima alcançada: ", self.getVelocidade())
            sleep(1.0)

    #Diminui velocidade do drone ate 0 Km/h
    def diminuirVelocidade(self):
        if(self.__velocidade > 0):
            self.__velocidade = self.__velocidade - 5
            #Print.mostraVelocidade(self.__velocidade)
            print("Diminuindo velocidade: ", self.getVelocidade())
            sleep(0.1)
        else:
            #Print.LimiteVelocidade()
            print("Limite minimo de velocidade alcançado: ", self.getVelocidade())
            sleep(0.5)

    def getAltura(self):
        return self.__altura

    def getVelocidade(self):
        return self.__velocidade

    def getLatitude(self):
        return self.__latitude

    def getLongitude(self):
        return self.__longitude

    def setLatitude(self, latitude):
        self.__latitude = latitude

    def setLongitude(self, longitude):
        self.__longitude = longitude

    def __decideRota(self, latitude, longitude, latitudeDestino, longitudeDestino):
        if(self.__modulo.getDrone().getProximidade().check()):
            while(self.__modulo.getDrone().getProximidade().check()):
                self.subir()
                self.__modulo.getDrone().getProximidade().setAcionado(int(input("Obstaculo 0-nao | 1-sim:  ")))
        if(latitude < latitudeDestino and longitude < longitudeDestino):
            self.__calculoRota1(latitudeDestino, longitudeDestino)
        elif(latitude > latitudeDestino and longitude > longitudeDestino):
            self.__calculoRota2(latitudeDestino, longitudeDestino)
        elif (latitude > latitudeDestino and longitude < longitudeDestino):
            self.__calculoRota3(latitudeDestino, longitudeDestino)
        elif (latitude < latitudeDestino and longitude > longitudeDestino):
            self.__calculoRota4(latitudeDestino, longitudeDestino)

    #Calcula Rota na direcao +x +y
    def __calculoRota1(self, latitudeDestino, longitudeDestino):
        x = self.__deslocamento()

        if (self.getLatitude() + x >= latitudeDestino):
            self.setLatitude(latitudeDestino)
        else:
            self.setLatitude(self.getLatitude() + x)

        if (self.getLongitude() + x >= longitudeDestino):
            self.setLongitude(longitudeDestino)
        else:
            self.setLongitude(self.getLongitude() + x)

    # Calcula Rota na direcao -x -y
    def __calculoRota2(self, latitudeDestino, longitudeDestino):
        x = self.__deslocamento()

        if (self.getLatitude() - x <= latitudeDestino):
            self.setLatitude(latitudeDestino)
        else:
            self.setLatitude(self.getLatitude() - x)

        if (self.getLongitude() - x <= longitudeDestino):
            self.setLongitude(longitudeDestino)
        else:
            self.setLongitude(self.getLongitude() - x)

    # Calcula Rota na direcao -x +y
    def __calculoRota3(self, latitudeDestino, longitudeDestino):
        x = self.__deslocamento()

        if (self.getLatitude() - x <= latitudeDestino):
            self.setLatitude(latitudeDestino)
        else:
            self.setLatitude(self.getLatitude() - x)

        if (self.getLongitude() + x >= longitudeDestino):
            self.setLongitude(longitudeDestino)
        else:
            self.setLongitude(self.getLongitude() + x)

    # Calcula Rota na direcao +x -y
    def __calculoRota4(self, latitudeDestino, longitudeDestino):
        x = self.__deslocamento()

        if (self.getLatitude() + x >= latitudeDestino):
            self.setLatitude(latitudeDestino)
        else:
            self.setLatitude(self.getLatitude() + x)

        if (self.getLongitude() - x <= longitudeDestino):
            self.setLongitude(longitudeDestino)
        else:
            self.setLongitude(self.getLongitude() - x)

    def setModulo(self, modulo):
        self.__modulo = modulo

    def decolar(self):
        if(self.getAltura() < 40 and self.__modulo.getDrone().getBateria().getLigado()):
            print("DECOLANDO...")
            while(self.getAltura() < 40):
                sleep(0.1)
                self.subir()
            print("DECOLAGEM EXECUTADA COM SUCESSO")
            sleep(1.0)

    def pousar(self):
        print("PARANDO VEICULO...")
        sleep(0.5)
        while (self.__velocidade > 0):
            self.diminuirVelocidade()
        print("VERIFICANDO SE LOCAL É SEGURO PARA POUSO")
        sleep(1.0)
        if (self.getAltura() > 0 and self.__modulo.getVigilancia().seguro()):
            print("POUSO INICIADO")
            while (self.getAltura() > 0):
                sleep(0.2)
                self.descer()
        else:
            print("NAO É SEGURO POUSAR NO LOCAL!! POUSO CANCELADO")
