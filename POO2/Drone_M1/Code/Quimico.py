from Sensor import Sensor


class Quimico(Sensor):

    __quimico = False

    def __init__(self, dispensavel):
        super(Quimico, self).__init__(dispensavel)

    def check(self):
        if(self.getAcioando()):
            self.__quimico = True
            return True
        else:
            self.__quimico = False
            return False
