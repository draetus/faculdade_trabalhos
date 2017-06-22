algoritmo "LM2ex2"
var
n,cont,i,cont2 : inteiro
vetora,vetorb,rep : vetor[1..100] de real
quantrep : vetor[1..100] de inteiro
inicio
cont <- 0
cont2 <- 0
repita
   escreva("Informe o valor de n: ")                           //ler valor de n
   leia(n)
ate (n < 101) e (n > 0)
escreval("Informe os valores do vetor de forma crescente: ")
repita                                                         //ler valores do vetor
   cont <- cont + 1
   quantrep[cont] <- 0
   escreva(cont, "° Vetor: ")
   leia(vetora[cont])                                          //necessario que seja de forma crescente
   se cont > 1 entao
      se vetora[cont] < vetora[cont-1] entao
         escreval("Valor invalido, Escreva de forma crescente!")
         cont <- cont-1
      senao
         se vetora[cont] = vetora[cont-1] entao
            se cont > 2 entao
               se vetora[cont-1] > vetora[cont-2] entao
                  cont2 <- cont2 + 1
                  rep[cont2] <- vetora[cont]                         //cada numero que se repete
                  quantrep[cont2] <- quantrep[cont2] + 1             //quantidade de vezes que se repete
               senao
                  quantrep[cont2] <- quantrep[cont2] + 1
               fimse
            senao
               cont2 <- cont2 + 1
               rep[cont2] <- vetora[cont]                            //cada numero que se repete
               quantrep[cont2] <- quantrep[cont2] + 1                //quantidade de vezes que se repete
            fimse
         fimse
      fimse
   fimse
ate cont = n
para i de 1 ate cont2 faca
   escreval("Numero: ",rep[i]," Repetido ",quantrep[i]," Vezes")     //informando numeros repetidos e quantidade de repetições
fimpara
vetorb[1] <- vetora[1]
cont <- 1
para i de 2 ate n faca
   se vetora[i] <> vetora[i-1] entao
      cont <- cont + 1
      vetorb[cont] <- vetora[i]
   fimse
fimpara
escreval("Vetor organizado sem elementos repetidos")
para i de 1 ate cont faca
  escreval(i, "° Termo: ",vetorb[i])
fimpara
fimalgoritmo
