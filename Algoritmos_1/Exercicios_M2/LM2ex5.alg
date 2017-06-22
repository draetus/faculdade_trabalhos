algoritmo "LM2ex5"
var
n,i,j : inteiro
a : vetor[0..20] de real
x,p : vetor[1..5] de real
inicio
repita
   escreva("Forneça o valor de n: ")
   leia(n)
ate (n < 21) e (n > 0)
para i de 0 ate n faca
   escreva("Termo de numero",i,": ")         //Coletando valores de i
   leia(a[i])
fimpara
para i de 1 ate 5 faca
   escreva("Forneça o ",i,"° Termo de x: ") //Coletando valores de x
   leia(x[i])
fimpara
escreval("______________________")
para i de 1 ate 5 faca
   p[i] <- 0
   para j de n ate 0 passo -1 faca
      p[i] <- p[i] + a[j]*x[i]^j
   fimpara
   escreval(i,"° Termo de P: ",p[i])
   escreval(i,"° Termo de X: ",x[i])
   escreval("______________________")
fimpara
fimalgoritmo
