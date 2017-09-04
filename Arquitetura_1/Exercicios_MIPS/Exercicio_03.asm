###############################################################################
# Exercício 03 - Patterson pag. 65
# Mostra a compilação de um comando de desvio condicional (if-then) simples
###############################################################################
# Trecho em C:
# if (i!=j)
#     f = g + h;
# f = f - i;      // também poderia ser escrito assim:  f -= i;
#
      .text   # segmento de código (programa)
main: 
      addi   $s0, $zero, 15   # inicializa $s0 em 15
      addi   $s1, $zero, 10   # inicializa $s1 em 10
      addi   $s2, $zero, 20   # inicializa $s2 em 20
      addi   $s3, $zero, 1    # inicializa $s3 em 1
      addi   $s4, $zero, 2    # inicializa $s4 em 2
      beq 	$s3, $s4, L1     # se i==j goto L1
      add 	$s0, $s1, $s2    # f = g + h
L1:   sub 	$s0, $s0, $s3    # f = f – i