algoritmo "Ex3Lentregar"
var
numero: real
inicio
// Seção de Comandos 
escreva("Informe um numero intiero entre 1000 e 9999: ")
leia (numero)
numero <- numero/100
se (numero < 10) ou (numero > 99) entao
   escreval("Numero invalido")
senao
     se numero DIV 4 = 0 entao
        escreval("Eh multiplo de 4")
     senao
     escreval("Nao eh multiplo de 4")
     fimse
fimse
fimalgoritmo
