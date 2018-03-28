from Conta import Conta

class ContaPoupanca(Conta):

    def ContaPoupanca(self, limite, cliente):
        super(ContaPoupanca, self).__init__(limite,cliente)

    def  atualizaTaxa(self, taxa):
        self.deposita((self.getSaldo() * taxa) * 3)


