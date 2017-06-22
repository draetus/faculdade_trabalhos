algoritmo "LM1ex5"
var
  percurso,consumo : real
  tipo : caracter
inicio
  escreva("Informe o percurso em quilometros: ")
  leia(percurso)
  escreva("Informe o tipo do carro: ")
  leia(tipo)
  escolha(tipo)
    caso "a","A"
      consumo <- percurso/8
    caso "b","B"
      consumo <- percurso/9
    caso "c","C"
      consumo <- percurso/12
  fimescolha
  escreva("Consumo estimado de combustivel: ",consumo," Litros")
fimalgoritmo
