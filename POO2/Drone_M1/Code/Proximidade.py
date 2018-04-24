from Sensor import Sensor


class Proximidade(Sensor):

    __proximidade = False

    def __init__(self, dispensavel):
        super(Proximidade, self).__init__(dispensavel)

    def check(self):
        if(self.getAcioando()):
            self.__proximidade = True
            return True
        else:
            self.__proximidade = False
            return False
