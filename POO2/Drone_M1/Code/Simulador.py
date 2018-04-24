from Drone import Drone


class Simulador():

    def __init__(self):
        self.__drone = Drone()
        self.__drone.setup()

    def __definindoRotas(self):
        self.__drone.setRotas(-27.580731, -48.753591)  # 1 Penitenciaria de Sao Pedro Alcantera
        self.__drone.setRotas(-27.649402, -48.696245)  # 2 colonia penal agricula de Palhoça
        self.__drone.setRotas(-27.577589, -48.526740)  # 3 Penitenciaria de Florianopolis
        self.__drone.setRotas(-27.580185, -48.526691)  # 4 Presidio masculino de florianopolis
        self.__drone.setRotas(-27.588129, -48.523043)  # 5 Presidio feminino de florianopolis
        self.__drone.setRotas(-27.577930, -48.527043)  # 6 Hospital de custodia e tratamento psiquiatrico (HCTP)
        self.__drone.setRotas(-27.588148, -48.523054)  # 7 casa do Albergado Florianopolis
        self.__drone.setRotas(-27.496380, -48.654360)  # 8 Presidio regional de Biguaçu
        self.__drone.setRotas(-27.271229, -48.681675)  # 9 Tijucas

    def __tempoRuim(self, condicao):

        self.__drone.getAcelerometro().setAcionado(condicao)

    def __rebeliao(self, condicao):
        self.__drone.getMovimento().setAcionado(condicao)

    def __pegandoFogo(self, condicao):
        self.__drone.getQuimico().setAcionado(condicao)

    def __obstaculo(self, condicao):
        self.__drone.getProximidade().setAcionado(condicao)

    def run(self):
        self.__definindoRotas()
        self.__drone.run(-1)

    def runSimulado(self):
        self.__definindoRotas()
        for i in range(1, 7):

            tempoRuim = int(input("Condiçcoes Do Tempo 0-Bom | 1-ruim:  "))
            while(tempoRuim < 0 or tempoRuim > 1):
                tempoRuim = int(input("Condiçcoes Do Tempo 0-Bom | 1-ruim:  "))

            rebeliao = int(input("Esta acontecendo Rebeliao 0-Não | 1-Sim:  "))
            while(rebeliao < 0 or rebeliao > 1):
                rebeliao = int(input("Esta acontecendo Rebeliao 0-Não | 1-Sim:  "))

            pegandoFogo = int(input("Esta Pegando Fogo 0-Não | 1-Sim:  "))
            while(pegandoFogo < 0 or pegandoFogo > 1):
                pegandoFogo = int(input("Esta Pegando Fogo 0-Não | 1-Sim:  "))

            obstaculo = int(input("Obstaculo 0-Não | 1-Sim:  "))
            while(obstaculo < 0 or obstaculo > 1):
                obstaculo = int(input("Obstaculo 0-Não | 1-Sim:  "))

            self.__tempoRuim(tempoRuim)
            self.__rebeliao(rebeliao)
            self.__pegandoFogo(pegandoFogo)
            self.__obstaculo(obstaculo)
            self.__drone.run(i)
            if(self.__drone.getAcelerometro().getAcioando()):
                break


print("Escolha a simulação desejada")
print("0 - Simulacao Automatica")
print("1 - Simulacao com interacao")

simulacao = int(input("Opcao Desejada: "))
while(simulacao < 0 or simulacao > 1):
    simulacao = int(input("Opcao Desejada: "))

x = Simulador()

if (simulacao == 0):
    x.run()
else:
    x.runSimulado()
