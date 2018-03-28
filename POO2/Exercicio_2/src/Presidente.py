from Funcionario import Funcionario


class Presidente(Funcionario):

    def __init__(self, nome="", departamento="", salario=0, dataAdmissao="", rg=""):
        super().__init__(nome, departamento, salario, dataAdmissao, rg)

    def getBonificacao(self):
        return (self.getSalario() * 0.10) + 10000
