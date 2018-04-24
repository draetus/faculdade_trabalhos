from time import sleep


class Vigilancia():

    def enviarMensagem(self):
        print("LIGANDO MODULO DE RADIO...")
        self.__modulo.getDrone().getRadio().ligar()
        sleep(0.5)
        print("ENVIANDO MENSAGEM AO SERVIDOR...")
        sleep(1.0)
        print("AGUARDANDO FORÇAS ESPECIAIS")
        sleep(2.0)

    def iniciarTransmissao(self):
        print("INICIANDO TRANSMISSAO...")
        self.__modulo.getDrone().getMicrofone().ligar()
        sleep(1.0)
        print("TRANSMISSAO INICIADA")
        sleep(0.5)
        self.__modulo.getDrone().getMicrofone().captando()
        print("BOOM BOOM TIRO TIRO MORTE MORTE BOOM TIRO")
        sleep(0.5)
        self.__modulo.getDrone().getMicrofone().captando()
        print("DONA MARIA, MÃE DE BANDIDO CHORANDO")
        sleep(0.5)
        print("TRANSMISSAO FINALIZADA")
        sleep(0.5)

    def setModulo(self, modulo):
        self.__modulo = modulo

    def seguro(self):
        if not (self.__modulo.getDrone().getMovimento().check() or self.__modulo.getDrone().getQuimico().check()):
            return True
        else:
            self.enviarMensagem()
            self.iniciarTransmissao()
            return False
