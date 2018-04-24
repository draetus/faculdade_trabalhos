from Sensor import Sensor


class Acelerometro(Sensor):

    __acelerometro = True

    def __init__(self, dispensavel):
        super(Acelerometro, self).__init__(dispensavel)

    def check(self):
        if(self.getAcioando()):
            print("CONDIÇÕES DE VOO: PERIGOSO")
            return True
        else:
            print("CONDIÇÕES DE VOO: OK")
            return False
