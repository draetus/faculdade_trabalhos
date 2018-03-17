entrada(salada).
entrada(pão).
prato(peixe).
prato(carne).
prato(massa).
sobremesa(sorvete).
sobremesa(pudim).

refeicao(A,B,C):- entrada(A), prato(B), sobremesa(C).