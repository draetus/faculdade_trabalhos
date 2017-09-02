########################################################################################
# Atividade: Exercicio de Aquecimento 2
# Disciplina: Arquitetura e Organização de Computadores
# Programação em Linguagem de Montagem
# Grupo: Mauricio
# Este exercicio aborda o uso da instruções de desvio, aritmetica e da instrução syscall
########################################################################################

.data # Dados

.text # Codigo

main: 
	addi $s0, $zero, 0       # $s0 = 0
	
Loop:
	addi $v0, $zero, 1       # Codigo para Print Int
	add  $a0, $zero, $s0     # Int desejado movido ao registrador $a0
	syscall
	addi $s0, $s0, 1         # Incrementa $s0
	blt  $s0, 10 , Loop      # Compara o valor de $s0 com 10, se for menor vai para o Loop