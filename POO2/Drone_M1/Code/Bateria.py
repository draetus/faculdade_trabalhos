from time import sleep
from Sensor import Sensor


class Bateria(Sensor):

    __bateria = 100
    __LIMITEBATERIA = 100  # bateria cheia
    __autonomia = 0.0635  # consumo de bateria por segundos

    def __init__(self, dispensavel):
        super(Bateria, self).__init__(dispensavel)
        self.__ligado = True

    def abastecer(self):
        print("CARREGANDO BATERIA...")
        while (self.__bateria < self.__LIMITEBATERIA):
            if (self.__bateria + self.__autonomia * 100 > self.__LIMITEBATERIA):
                self.__bateria = self.__LIMITEBATERIA
            else:
                self.__bateria = self.__bateria + self.__autonomia * 100
            print("Bateria: ", "%.1f" % self.getBateria(), "%")
            sleep(0.2)
        print("BATERIA CHEIA!!")

    def getBateria(self):
        return self.__bateria

    def getAutonomia(self):
        return self.__autonomia

    def setAutonomia(self, autonomia):
        self.__autonomia = autonomia

    def getLimiteCombustive(self):
        return self.__limiteBateria

    def consumindoBateria(self):
        self.__bateria = self.__bateria - self.__autonomia
        if (self.__bateria < 0):
            self.__bateria = 0
