from Funcionario import Funcionario


class Gerente(Funcionario):

    __senha = ""

    def __init__(self, nome="", departamento="", salario=0, dataAdmissao="", rg=""):
        super().__init__(nome, departamento, salario, dataAdmissao, rg)

    def autenticaSenha(self, senha):
        return self.__senha == senha

    def setSenha(self, senha):
        self.__senha = senha

    def getBonificacao(self):
        return (self.getSalario() * 0.10) + 1000
