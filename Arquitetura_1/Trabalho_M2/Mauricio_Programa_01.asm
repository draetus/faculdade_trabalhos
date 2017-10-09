# Disciplina: Arquitetura e Organizacao de Computadores
# Atividade: Avaliacao 03 - Programacao em Linguagem de Montagem
# Programa 01
# Grupo: - Mauricio

.data 	######################        DADOS        ######################

message1:	.asciiz "Primeiro numero: "
message2:	.asciiz	"Segundo numero: "
message3:	.asciiz	"Maximo divisor comum: "
error_message:	.asciiz "Numero invalido!!\n"

.text 	######################        CODIGO        ######################

main:
		j	numero1

error1:
		li	$v0, 4			#Print "Numero invalido"
		la	$a0, error_message
		syscall
		
numero1:		
		li	$v0, 4			#Print "Primeiro numero: "
		la 	$a0, message1
		syscall

		li 	$v0, 5			#Read int
		syscall
		blt	$v0, 1, error1		#Checa se valor e valido
		add	$s0, $zero, $v0		#Guarda valor de $v0 em $s0
		j	numero2

error2:
		li	$v0, 4			#Print "Numero invalido"
		la	$a0, error_message
		syscall
numero2:
		li	$v0, 4			#Print "Segundo numero: "
		la	$a0, message2
		syscall
	
		li	$v0, 5			#Read int
		syscall
		blt	$v0, 1, error2		#Checa se valor e valido
		add	$s1, $zero, $v0		#Guarda valor de $v0 em $s1
		
		add	$a0, $zero, $s0		#Transfere valor de $s0 para registrador de argumento $a0
		add	$a1, $zero, $s1		#Transfere valor de $s1 para registrador de argumento $a1
		jal	proc_mdc		#Chama procedimento proc_mdc
		add	$s2, $zero, $v0		#Guarda valor de $v0 em $s2
		
		li	$v0, 4			#Print "Maximo divisor comum: "
		la	$a0, message3
		syscall
		
		li	$v0, 1			#Print int
		add	$a0, $zero, $s2		#Passa valor de $s2 ao numero a ser printado
		syscall
		
		j	exit			#Exit program
		
	
proc_mdc:
		addi	$sp, $sp, -4		#Move ponteiro da pilha para uma posição abaixo
		sw	$s0, 0($sp)		#Empilha valor de $s0
		addi	$sp, $sp, -4		#Move ponteiro da pilha para uma posição abaixo
		sw	$s1, 0($sp)		#Empilha valor de $s1
		add	$s0, $zero, $a0		#Transfere valor do primeiro argumento ao registrador $s0
		add	$s1, $zero, $a1		#Transfere valor do segundo argumento ao registrador $s1
		
while:
		beq	$s0, $s1, end_while	#Se forem iguais o minimo multiplo comum ja foi achado
		bgt	$s0, $s1, if_greater	#se (X($s0) > Y($s1))
						#Se os outros testes falharem, X sera menor que Y
		
if_less:
		sub	$s1, $s1, $s0		# Y = Y - X
		j	while			#Continua o loop

if_greater:
		sub	$s0, $s0, $s1		# X = X - Y
		j 	while			#Continua o loop
			
end_while:
		add	$v0, $zero, $s0		#Move valor final para registrador de retorno
		lw	$s1, 0($sp)		#Recupera valor de $s1
		addi	$sp, $sp, 4		#Move ponteiro da pilha para uma posição acima
		lw	$s0, 0($sp)		#Recupera valor de $s0
		addi	$sp, $sp, 4		#Move ponteiro da pilha para uma posição acima
		jr	$ra			#Retorna do procedimento
		
exit:
