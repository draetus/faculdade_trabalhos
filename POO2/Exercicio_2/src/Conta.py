from abc import ABC
from Cliente import Cliente


class Conta(ABC):
    __contasCriadas = 1
    __numero = 0
    __saldo = 0
    __limite = 0
    __titular = Cliente

    def __init__(self, limite, titular):
        self.__numero = Conta.__contasCriadas
        self.__limite = limite
        self.__titular = titular
        Conta.__contasCriadas = Conta.__contasCriadas + 1

    def atualizaTaxa(self):
        raise NotImplementedError()

    def saca(self, valor):
        if self.__saldo >= valor and float(self.__saldo - valor) >= 0:
            self.__saldo = self.__saldo - valor
            return True
        return False

    def deposita(self, valor):
        if (self.__saldo + valor) <= self.__limite:
            self.__saldo += valor
            return True
        return False

    def transferePara(self, contaDestino, valor):
        if self.getSaldo() >= valor and contaDestino.getLimite() >= contaDestino.getSaldo() + valor:
            self.saca(valor)
            contaDestino.deposita(valor)
            return True
        return False

    def setNumero(self, numero):
        self.__numero = numero

    def getNumero(self):
        return self.__numero

    def getSaldo(self):
        return self.__saldo

    def setLimite(self, limite):
        self.__limite = limite

    def getLimite(self):
        return self.__limite

    def getContasCriadas(self):
        return Conta.__contasCriadas
