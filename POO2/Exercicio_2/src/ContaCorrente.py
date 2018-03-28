from Conta import Conta

class ContaCorrente(Conta):

    def ContaCorrente(self, limite, cliente):
        super(ContaCorrente, self).__init__(limite, cliente)

    def atualizaTaxa(self):
        self.deposita((self.getSaldo() * taxa) * 2)

