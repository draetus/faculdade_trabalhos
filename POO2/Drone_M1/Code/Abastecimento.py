from time import sleep


class Abastecimento():

    def __init__(self):
        pass

    def calcularAutonomia(self):
        if (self.__modulo.getDrone().getBateria().getBateria() < 51):
            return self.__modulo.getDrone().getBateria().getBateria() / 0.017777778
        else:
            return
            (((self.__modulo.getDrone().getBateria().getBateria() - 50) / 0.0635) + 2812.499964844) / 60  # ((autonomia acima de 50) + (50 / 0.0177777778)) / 60

    def abastecer(self):
        if (self.__modulo.getVoo().getAltura() > 0):
            print("NAO É POSSIVEL ABASTECER A BATERIA SEM POUSAR!")
        else:
            self.__modulo.getDrone().getBateria().setAutonomia(0.0635)
            self.__modulo.getDrone().getBateria().abastecer()
            self.__modulo.getDrone().getQuimico().ligar()
            self.__modulo.getDrone().getMovimento().ligar()
            self.__modulo.getDrone().getAcelerometro().ligar()
            self.__modulo.getDrone().getProximidade().ligar()

    def sensorDispensavel(self):
        if (self.__modulo.getDrone().getBateria().getBateria() < 50 and
           (self.__modulo.getDrone().getQuimico().getLigado() or
           self.__modulo.getDrone().getMovimento().getLigado())):

            print("SENSORES DISPENSAVEIS SENDO DESATIVADOS... SO SERAO ATIVADOS NO PROXIMO REABASTECIMENTO")
            sleep(2.0)
            self.__modulo.getDrone().getQuimico().desligar()
            self.__modulo.getDrone().getMovimento().desligar()
            self.__modulo.getDrone().getBateria().setAutonomia(0.017777778)

    def setModulo(self, modulo):
        self.__modulo = modulo
