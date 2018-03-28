class Banco(object):

    __funcionarios = []
    __cnpj = ""

    def setFuncionario(self, funcionario):
        self.__funcionarios.append(funcionario)

    def getFuncionario(self):
        self.__funcionarios

    def pertenceAoBanco(self, funcionario):
        if funcionario in self.__funcionarios:
            return True
        return False

