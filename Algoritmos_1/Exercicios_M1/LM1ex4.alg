algoritmo "semnome"
// Função :
// Autor :
// Data : 12/09/2016
// Seção de Declarações 
var
preco_alimentacao, preco_bebida, preco_sobremesa, preco_total: real
alimentacao, bebida, sobremesa: inteiro
nome_alimentacao, nome_bebida, nome_sobremesa: caractere
inicio
// Seção de Comandos 
escreva("Informe um pedido de alimentacao: ")
leia(alimentacao)
escreva("Informe um pedido de bebida: ")
leia(bebida)
escreva("Informe um pedido de sobremesa: ")
leia(sobremesa)
se (alimentacao>4) ou (bebida<5)ou (bebida>6) ou (sobremesa<7) ou (sobremesa>9) entao
   escreva("Predido invalido")
senao
     se alimentacao = 1 entao
        nome_alimentacao <- "Hamburguer"
        preco_alimentacao <- 4.50
     senao
          se alimentacao = 2 entao
             nome_alimentacao <- "Cheeseburguer"
             preco_alimentacao <- 5.50
          senao
               se alimentacao <- 3 entao
                  nome_alimentacao <- "Cachorro quente"
                  preco_alimentacao <-4.00
               senao
                    se alimentacao = 4 entao
                       nome_alimentacao <- "Sanduiche"
                       preco_alimentacao <- 3.50
                    fimse
               fimse
          fimse
     fimse
     
     se bebida = 5 entao
         nome_bebida <- "Refrigerante"
         preco_bebida <- 1.00
     senao
          se bebida = 6 entao
              nome_bebida <- "Suco de laranja"
              preco_bebida <- 2.00
          fimse
      fimse
      se sobremesa = 7 entao
         nome_sobremesa <- "Milk Shake"
         preco_bebida <- 1.50
      senao
           se sobremesa = 8 entao
              nome_sobremesa <- "Sundae"
              preco_sobremesa <- 3.00
           senao
                se sobremesa = 9 entao
                   nome_sobremesa <- "Casquinha"
                   preco_sobremesa <- 1.00
                fimse
           fimse
      fimse
      preco_total <- preco_alimentacao + preco_bebida + preco_sobremesa
      escreval("Pedido de alimentacao: ", nome_alimentacao)
      escreval("Preco: ",preco_alimentacao)
      escreval("Pedido de bebida: ", nome_bebida)
      escreval("Preco: ", preco_bebida)
      escreval("Pedido de sobremesa: ",nome_sobremesa)
      escreval("Preco: ", preco_sobremesa)
      escreval ("Preco total a pagar: ", preco_total)

     
fimse





fimalgoritmo
