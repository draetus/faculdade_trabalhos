from time import sleep
from Sensor import Sensor


class Microfone(Sensor):

    __microfone = True

    def __init__(self, dispensavel):
        super(Microfone, self).__init__(dispensavel)

    def captando(self):
        if (self.getLigado()):
            print("CAPTANDO SONS...")
            sleep(0.2)
