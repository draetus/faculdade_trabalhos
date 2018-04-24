from Sensor import Sensor


class Movimento(Sensor):

    __movimento = False

    def __init__(self, dispensavel):
        super(Movimento, self).__init__(dispensavel)

    def check(self):
        if(self.getAcioando()):
            self.__movimento = True
            return True
        else:
            self.__movimento = False
            return False
