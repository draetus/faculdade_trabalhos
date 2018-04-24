from Bateria import Bateria
from Microfone import Microfone
from Acelerometro import Acelerometro
from Proximidade import Proximidade
from Quimico import Quimico
from Movimento import Movimento
from Radio import Radio
from Modulos import Modulos


class Drone():

    __rotas = []
    __helices = 4
    __bateria = Bateria(False)
    __microfone = Microfone(True)
    __acelerometro = Acelerometro(False)
    __proximidade = Proximidade(False)
    __quimico = Quimico(True)
    __movimento = Movimento(True)
    __radio = Radio(True)

    def __init__(self):
        self.__modulo = Modulos()
        self.__modulo.setup()

    def getBateria(self):
        return self.__bateria

    def getMicrofone(self):
        return self.__microfone

    def getAcelerometro(self):
        return self.__acelerometro

    def getProximidade(self):
        return self.__proximidade

    def getQuimico(self):
        return self.__quimico

    def getMovimento(self):
        return self.__movimento

    def getRadio(self):
        return self.__radio

    def getVoo(self):
        return self.__voo

    def setRotas(self, latitude, longitude):
        self.__rotas.insert(self.__rotas.__len__(), [latitude, longitude])

    def setup(self):
        self.__modulo.setDrone(self)

    def run(self, i):
        if (i == -1):
            for i in range(1, 7):
                self.__modulo.getAbastecimento().abastecer()
                self.__modulo.getVoo().decolar()
                if(not self.getAcelerometro().check()):
                    if(self.getBateria().getLigado()):
                        self.__modulo.getVoo().irPara(self.__rotas[i][0], self.__rotas[i][1])
                else:
                    self.__modulo.getVoo().pousar()
                    break
                self.__modulo.getVoo().pousar()
        else:
            self.__modulo.getAbastecimento().abastecer()
            self.__modulo.getVoo().decolar()
            if(not self.getAcelerometro().check()):
                if(self.getBateria().getLigado()):
                    self.__modulo.getVoo().irPara(self.__rotas[i][0], self.__rotas[i][1])

            self.__modulo.getVoo().pousar()
