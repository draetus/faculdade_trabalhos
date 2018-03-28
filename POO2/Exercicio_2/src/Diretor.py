from Gerente import Gerente


class Diretor(Gerente):

    def __init__(self, nome="", departamento="", salario=0, dataAdmissao="", rg=""):
        super(Diretor, self).__init__(nome, departamento, salario, dataAdmissao, rg)

    def getBonificacao(self):
        return super().getBonificacao() + 1500
