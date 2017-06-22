algoritmo "LM2ex3"
var
i,n : inteiro
b : vetor[1..10] de real
soma : real
inicio
repita
escreva("Forneça o tamanho do vetor(em um numero par) : ")
leia(n)
ate n mod 2 = 0
escreval("Forneça os valores a seguir: ")
para i de 1 ate n faca
   escreva(i,"° Termo: ")
   leia(b[i])
fimpara
para i de 1 ate (n DIV 2) faca
   soma <- b[i]-b[n-i+1] + soma
fimpara
escreval("__________________________")
escreval("Soma dos termos: ",soma)
fimalgoritmo
