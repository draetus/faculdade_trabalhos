algoritmo "Ex3TrabFinal"

funcao lernum() : inteiro
var
   valor : inteiro
inicio
      repita
            escreva("Valor: ")
            leia(valor)
      ate valor > 0
      retorne valor
fimfuncao

procedimento solucao(m,n : inteiro)
var
A : vetor[1..10,1..10] de real
B,aux,X : vetor[1..10] de real
result : logico
i , j : inteiro

inicio

result <- verdadeiro
escreval("Forne�a so valores da matriz A:")
para i de 1 ate m faca
     para j de 1 ate n faca
          escreva("Posi��o ",i," ",j,": ")
          leia(A[i,j])
     fimpara
fimpara
escreval("Forne�a os valores da matriz B(resultados): ")
para i de 1 ate m faca
     escreva("Posi��o ",i," ")
     leia (B[i])
fimpara
escreval("Forne�a os valores de X: ")
para i de 1 ate n faca
     escreva("X",i,": ")
     leia(X[i])
fimpara
para i de 1 ate m faca
     aux[i] <- 0
     para j de 1 ate n faca
          aux[i] <- aux[i] + A[i][j] * X[j]
     fimpara
fimpara
para i de 1 ate m faca
     se aux[i] = B[i] entao
        result <- falso
     fimse
fimpara
se result entao
   escreva("X � a solu��o")
senao
   escreva("X n�o � a solu��o")
fimse
fimprocedimento

var
m,n : inteiro
inicio
m <- lernum()
n <- lernum()
solucao(m,n)
fimalgoritmo
