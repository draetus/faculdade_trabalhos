algoritmo "Ex5TrabFinal"

procedimento function(var a,b : inteiro)
var
   x,y : inteiro
inicio
      x <- a
      y <- b
      a <- x DIV y
      b <- x MOD y
fimprocedimento

var
   a, b : inteiro
inicio
      escreva("Forne�a o valor a: ")
      leia(a)
      escreva("Forne�a o valor b: ")
      leia(b)
      function(a,b)
      escreval("Valor da divisao: ",a)
      escreval("Valor do resto: ",b)
fimalgoritmo
