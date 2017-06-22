algoritmo "LM2ex1"
var
i, cont, j : inteiro
seno, x : real
vetorx,vetorf : vetor[1..15] de real
vetorfinal : vetor[1..15] de real
inicio
cont <- 0
escreva("Forneça o valor de x em graus: ")
leia(x)
x <- (x * pi / 180)
para i de 1 ate 30 passo 2 faca                 //valor do seno de x
   cont <- cont + 1
   vetorx[cont] <- x ^ i
fimpara
cont <- 0
para i de 1 ate 30 passo 2 faca                 //valor do fatorial
   cont <- cont + 1
   vetorf[cont] <- 1
   para j de 1 ate i faca
      vetorf[cont] <- vetorf[cont] * j
   fimpara
fimpara
para i de 1 ate 15 passo 2 faca                 //definindo valores positivos
   vetorfinal[i] <- vetorx[i] / vetorf[i]
fimpara
para i de 2 ate 14 passo 2 faca
   vetorfinal[i] <- (vetorx[i]) / (-vetorf[i])  //definindo valores negativos
fimpara
seno <- 0
escreval("______________________")
para i de 1 ate 15 faca
   seno <- seno + vetorfinal[i]
   escreval("Vetor de posição",i,": ",vetorfinal[i])
fimpara
escreval("______________________")              //Identação
escreval("Valor do seno: ",seno)
fimalgoritmo
