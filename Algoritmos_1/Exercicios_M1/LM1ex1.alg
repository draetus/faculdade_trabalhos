algoritmo "LM1ex1"
var
p1,p2,p3,p4,mp,t1,t2,t3,t4,mt,mf : real
inicio
escreval("Informe as notas de prova: ")
leia(p1,p2,p3,p4)
escreval("Informe as notas de trabalho: ")
leia(t1,t2,t3,t4)
mp <- (p1+p2+p3+p4)/4
mt <- (t1+t2+t3+t4)/4
mf <- 0.8*mp+0.2*mt
se mf >= 6.0 entao
  escreva("Aprovado")
senao
  escreva("Reprovado")
fimse
fimalgoritmo
