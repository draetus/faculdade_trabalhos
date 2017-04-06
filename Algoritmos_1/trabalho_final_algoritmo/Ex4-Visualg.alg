algoritmo "Ex4TrabFinal"

funcao regular(n : inteiro): inteiro
inicio
       repita
             se (n MOD 2 = 0) entao
                n <- n DIV 2
             senao
                  se (n MOD 3 = 0) entao
                     n <- n DIV 3
                  senao
                       se (n MOD 5 = 0) entao
                          n <- n DIV 5
                       senao
                       interrompa
                       fimse
                  fimse
             fimse
       ate ((n MOD 2 <> 0) e (n MOD 3 <> 0) e (n MOD 5 <> 0))
       se n = 1 entao
          retorne 1
       senao
          retorne 0
       fimse
fimfuncao

var
   numero : inteiro
inicio
      escreva("Digite um numero: ")
      leia(numero)
      se regular(numero) = 1 entao
         escreva("Numero é regular")
      senao
         escreva("Numero não é regular")
      fimse
fimalgoritmo
