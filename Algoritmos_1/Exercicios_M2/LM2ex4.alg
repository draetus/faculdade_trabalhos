algoritmo "LM2ex4"
var
i,n,j,aux,cont2 : inteiro
x,rep,cont : vetor[1..100] de inteiro
inicio
cont2 <- 0
cont[1] <- 0
repita
   escreva("Forneça o valor de n: ")                             //Lendo n
   leia(n)
ate (n < 101) e (n > 0)
para i de 1 ate n faca
   escreva(i," ° Termo: ")
   leia(x[i])
fimpara
para i de 1 ate n faca
   para j de 1 ate n faca
      se x[j] < x[i] entao                                       //Ordenando o vetor
         aux <- x[j]
         x[j] <- x[i]
         x[i] <- aux
      fimse
   fimpara
fimpara
i <- 0
repita
   i <- i + 1
   para j de i+1 ate n faca
      se x[j] = x[i] entao
         cont[cont2+1] <- cont[cont2+1] + 1                      //Criando vetor de repetições
         rep[cont2+1] <- x[i]
         i <- i + 1
      fimse
   fimpara
   se cont[cont2+1] > 0 entao
      cont2 <- cont2 + 1
   fimse
ate i = n
escreval("______________________")
escreval("Vetor organizado por ordem decrescente: ")
para i de 1 ate n faca
   escreval(i," ° Termo: ",x[i])                                 //Mostrando o vetor ordenado
fimpara
escreval("______________________")
escreval("Numeros repetidos: ")
para i de 1 ate cont2 faca
   escreval("Numero: ",rep[i]," Repetido: ",cont[i]," Vezes")    //Mostrando numeros repetidos
fimpara
fimalgoritmo
