from Voo import Voo
from Reconhecimento import Reconhecimento
from Vigilancia import Vigilancia
from Abastecimento import Abastecimento


class Modulos(object):

    #__drone
    #__voo
    #__reconhecimento
    #__vigilancia
    #__abastecimento

    def __init__(self):
        self.__voo = Voo(-27.580731, -48.753591)
        self.__reconhecimento = Reconhecimento()
        self.__vigilancia = Vigilancia()
        self.__abastecimento = Abastecimento()

    def getVoo(self):
        return self.__voo

    def getReconhecimento(self):
        return self.__reconhecimento

    def getVigilancia(self):
        return self.__vigilancia

    def getAbastecimento(self):
        return self.__abastecimento

    def getDrone(self):
        return self.__drone

    def setDrone(self, drone):
        self.__drone = drone

    def setup(self):
        self.__voo.setModulo(self)
        self.__reconhecimento.setModulo(self)
        self.__vigilancia.setModulo(self)
        self.__abastecimento.setModulo(self)
