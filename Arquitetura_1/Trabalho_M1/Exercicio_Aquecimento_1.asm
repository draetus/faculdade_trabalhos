########################################################################################
# Atividade: Exercicio de Aquecimento 1 
# Disciplina: Arquitetura e Organização de Computadores
# Programação em Linguagem de Montagem
# Grupo: Mauricio
# Este exercicio aborda o uso da instrução syscall, da instrução add e dos registradores
########################################################################################

.data # Dados
	message1 : .asciiz "Entre com o valor de X: "
	message2 : .asciiz "Entre com o valor de Y: "
	message3 : .asciiz "A soma do valor entre X e Y e igual a: "

.text # Codigo
main:
	addi $v0, $zero, 4     # Codigo para Print String
	la $a0, message1       # Mensagem para o registrador $a0
	syscall
	
	addi $v0, $zero, 5     # Codigo para Read int
	syscall
	add $s0, $zero, $v0   # Salva resposta me um registrador
	
	addi $v0, $zero, 4     # Codigo para Print String
	la $a0, message2       # Mensagem para o registrador $a0
	syscall
	
	addi $v0, $zero, 5     # Codigo para Read int
	syscall
	add $s0, $s0, $v0      # Soma os dois valores recebidos e envia o resultado para o registrador $s0
	
	addi $v0, $zero, 4     # Codigo para Print String
	la $a0, message3       # Mensagem para o registrador $a0
	syscall
	
	addi $v0, $zero, 1     # Codigo para Print Int
	add $a0, $zero, $s0   # Coloca valor do resultado da soma em $a0
	syscall
