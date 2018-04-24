from abc import ABC


class Sensor(ABC):
    __metaclass__ = ABC

    __ligado = True
    __DISPENSAVEL = False
    __acionado = False

    def __init__(self, dispensavel):
        self.__DISPENSAVEL = dispensavel

    def ligar(self):
        self.__ligado = True

    def desligar(self):
        self.__ligado = False

    def getLigado(self):
        return self.__ligado

    def getDispensavel(self):
        return self.__DISPENSAVEL

    def setAcionado(self, acionado):
        self.__acionado = acionado

    def getAcioando(self):
        return self.__acionado
