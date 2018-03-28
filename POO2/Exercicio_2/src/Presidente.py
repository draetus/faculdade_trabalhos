from Funcionario import Funcionario

class Presidente(Funcionario):

    def __init__(self):
        super(Presidente, self).__init__()

    def __init__(self, nome, departamento, salario, dataAdmissao, rg):
        super(Presidente, self).__init__(nome, departamento, salario, dataAdmissao, rg)

    def getBonificacao():
        return (self.getSalario() * 0.10 ) + 10000
