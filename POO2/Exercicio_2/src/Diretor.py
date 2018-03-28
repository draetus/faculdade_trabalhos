from Gerente import Gerente

class Diretor(Gerente):
    
    def __init__(self):
        super(Diretor, self).__init__()

    def __init__(self, nome, departamento, salario, dataAdmissao, rg):
        super(Diretor, self).__init__(nome,departamento, salario, dataAdmissao, rg)

    def getBonificacao():
        return super(Diretor, self).getBonificacao() + 1500
