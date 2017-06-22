algoritmo "LM1ex2"
var
  saldo_medio,credito,credito_juros : real
inicio
  escreva("Informe o valor do saldo médio: ")
  leia(saldo_medio)
  se saldo_medio<=500 entao
    credito <- 0
  senao
    se saldo_medio<=1000 entao
      credito <- saldo_medio*0.3
    senao
      se saldo_medio<=3000 entao
        credito <- saldo_medio*0.4
      senao
        credito <- saldo_medio*0.5
      fimse
    fimse
  fimse
  credito_juros <- credito - (credito*0.02)
  escreva("Valor do crédito: ",credito_juros)
fimalgoritmo
