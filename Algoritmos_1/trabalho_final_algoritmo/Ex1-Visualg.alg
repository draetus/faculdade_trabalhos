algoritmo "Ex1TrabFinal"
var
   valorn,i,j,cont,aux : inteiro
   n : vetor[1..10,1..10] de inteiro
inicio
      repita
            escreva("Digite o valor de n: ")
            leia(valorn)
      ate (valorn MOD 2 <> 0) e (valorn < 11)
      aux <- valorn DIV 2 + 1
      para i de 1 ate valorn faca
           para j de 1 ate valorn faca
                n[i,j] <- 0
           fimpara
      fimpara
      n[1,aux] <- 1
      cont <- 1
      i <- 1
      j <- aux
      repita
            i <- i - 1
            j <- j + 1
            cont <- cont + 1
            se (i < 1) ou (i > valorn) entao
               i <- valorn
            fimse
            se (j > valorn) ou (j < 0) entao
               j <- 1
            fimse
            se n[i,j] <> 0 entao
               i <- i + 2
               j <- j - 1
               se i > valorn entao
                  i <- i - valorn
               fimse
               se j < 1 entao
                  j <- valorn
               fimse
            fimse
            n[i,j] <- cont
      ate cont = valorn * valorn
      para i de 1 ate valorn faca
           para j de 1 ate valorn faca
                escreva(n[i,j]," ")
           fimpara
           escreval
      fimpara
fimalgoritmo
