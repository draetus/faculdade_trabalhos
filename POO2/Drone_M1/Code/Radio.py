from time import sleep
from Sensor import Sensor


class Radio(Sensor):

    def __init__(self, dispensavel):
        super(Radio, self).__init__(dispensavel)

    def enviarMensagem(self):
        if (self.__ligado):
            sleep(0.5)
            print("MENSAGEM ENVIADA COM SUCESSO...")
            sleep(0.5)
