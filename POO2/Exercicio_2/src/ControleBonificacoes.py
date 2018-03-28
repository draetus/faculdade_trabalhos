class ControleBonificacoes(object):

    __totalBonificacoes = 0

    def registra(self, funcionario):
        self.__totalBonificacoes += funcionario.getBonficacao()

    def getTotalBonificacao(self):
        return self.__totalBonificacoes
