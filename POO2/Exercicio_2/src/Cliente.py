
class Cliente(object):

    __nome = ""
    __sobrenome = ""
    __cpf = ""

    def __init__(self, nome, sobrenome, cpf):
        self.__nome = nome
        self.__sobrenome = sobrenome
        self.__cpf = cpf

    def getNome(self):
        return self.__nome

    def setNome(self, nome):
        self.__nome = nome

    def getSobrenome(self):
        return self.__sobrenome

    def setSobrenome(self, sobrenome):
        self.__sobrenome = sobrenome

    def getCPF(self):
        return self.__cpf
