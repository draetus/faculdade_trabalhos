from abc import ABC


class Funcionario(ABC):

    __nome = ""
    __departamento = ""
    __salario = 0
    __dataAdmissao = ""
    __rg = ""

    def __init__(self, nome="", departamento="", salario="", dataAdmissao="", rg=""):
        self.__nome = nome
        self.__departamento = departamento
        self.__salario = salario
        self.__dataAdmissao = dataAdmissao
        self.__rg = rg

    #def __hash__(self):

    #def equals(self):

    def imprimeDados(self):
        print("\nNome: " + str(self.getNome()))
        print("Departamento: " + str(self.getDepartamento()))
        print("Salário: " + str(self.getSalario()))
        print("Data de Admissão: " + str(self.getDataAdminissao()))
        print("RG: " + str(self.getRg()))

    def recebeAumento(self, aumento):
        self.salario += aumento

    def getGanhoAnual(self):
        return self.__salario * 12

    def getBonficacao(self):
        raise NotImplementedError()

    def getDepartamento(self):
        return self.__departamento

    def setDepartamento(self, departamento):
        self.__departamento = departamento

    def getSalario(self):
        return self.__salario

    def setSalario(self, salario):
        self.__salario = salario

    def getNome(self):
        return self.__nome

    def getDataAdminissao(self):
        return self.__dataAdmissao

    def getRg(self):
        return self.__rg
