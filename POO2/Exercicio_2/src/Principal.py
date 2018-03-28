from Cliente import Cliente
from ContaPoupanca import ContaPoupanca
from ContaCorrente import ContaCorrente
from Gerente import Gerente
from Diretor import Diretor
from Presidente import Presidente

cl = Cliente("Breno", "Oliveira", "08552242664")
c = ContaCorrente(2000, cl)
print(c.deposita(1000))

cl1 = Cliente("Roide", "Jorgi", "123321123")
c1 = ContaCorrente(2000, cl1)
print(c1.deposita(1000))

f = Gerente("Breno", "TI", 3200, "18/03/2018", "08552242664")
f.imprimeDados()

f1 = Gerente("Breeeeeeeeeno", "TI", 5200, "18/03/2018", "08552242664")
f1.imprimeDados()

print("---------------------")

cc = ContaPoupanca(2000, cl)

cc.deposita(1000)
print(cc.getSaldo())
cc.atualizaTaxa(1)
print(cc.getSaldo())

d = Diretor("Materzao", "TI", 3200, "18/03/2018", "08552242664")
d.imprimeDados()
print(d.getBonificacao())
print(f.getBonificacao())

p = Presidente("Materzao REIREIREIREI", "TI", 3200, "18/03/2018", "08552242664")
print(p.getBonificacao())
