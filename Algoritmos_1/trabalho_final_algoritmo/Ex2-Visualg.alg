algoritmo "Ex2TrabFinal"
procedimento escrever (n: inteiro)
inicio
escolha (n)
        caso 0
             escreval("Zero")
        caso 1
             escreval("Um")
        caso 2
             escreval("Dois")
        caso 3
             escreval("Três")
        caso 4
             escreval("Quatro")
        caso 5
             escreval("Cinco")
        caso 6
             escreval("Seis")
        caso 7
             escreval("Sete")
        caso 8
             escreval("Oito")
        caso 9
             escreval("Nove")
        caso 10
             escreval("Dez")
        outrocaso
             escreval("Numero invalido")
fimescolha
fimprocedimento

var
   n: inteiro
inicio
      escreva("Digite um numero de 1 a 10: ")
      leia(n)
      escrever(n)
fimalgoritmo
