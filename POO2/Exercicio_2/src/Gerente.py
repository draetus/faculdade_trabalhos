from Funcionario import Funcionario

class Gerente(Funcionario):

    __senha = ""

    def __init__(self):
        super(Gerente, self).__init__()

    def __init__(self, nome, departamento, salario, dataAdmissao, rg):
        super(Gerente, self).__init__(nome, departamento, salario, dataAdmissao, rg)

    def autenticaSenha(senha):
        return self.__senha == senha

    def setSenha(senha):
        self.__senha = senha

    def getBonificacao():
        return (self.getSalario() * 0.10) + 1000
