# Disciplina: Arquitetura e Organizacao de Computadores
# Atividade: Avaliacao 01 - Programacao em Linguagem de Montagem
# Programa 01
# Grupo: - Mauricio

.data 	######################        DADOS        ######################

Vetor_A: 	.word 0,0,0,0,0,0,0,0
Vetor_B: 	.word 0,0,0,0,0,0,0,0

invalid_message:.asciiz "Valor invalido.\n"
quebra_linha:	.asciiz "\n"
message1: 	.asciiz "Entre com o tamanho do vetor (max. = 8): "
message2:	.asciiz "Vetor_A["
message3:	.asciiz "]: "
message4: 	.asciiz "Vetor_B["

.text 	######################        CODIGO        ######################

		j	main			#Inicia programa no main

invalid:	li 	$v0, 4			#Print "Valor invalido.\n"
		la 	$a0, invalid_message
		syscall
	
main:		li 	$v0, 4			#Print "Entre com o tamanho do vetor (max. = 8): "
		la 	$a0, message1
		syscall

		li 	$v0, 5			#Read int
		syscall
		blt 	$v0, 1, invalid		#Desvia para invalid se for menor que 1
		bgt	$v0, 8, invalid		#Desvia para invalid se for maior que 8
		add	$s0, $zero, $v0		#Salva tamanho do vetor lido para o registrador $s0
		
################################################################################################################################
################################################################################################################################

		la 	$t0, Vetor_A		#Pega endere�o base do Vetor A
		li 	$t1, 0			#Inicia iterador (i)
                 
for: 		li 	$v0, 4			#Print "Vetor_A["
		la	$a0, message2
		syscall
		
		li 	$v0, 1			#Print iterador (i)
		add	$a0, $zero, $t1
		syscall
		
		li 	$v0, 4			#Print "]: "
		la	$a0, message3
		syscall
		
		li 	$v0, 5			#Read int
		syscall
		
		sw 	$v0, ($t0)		#Salva valor lido no vetor
		
		addi 	$t0, $t0, 4		#Incrementa endere�o
		addi	$t1, $t1, 1		#Incrementa iterador
		blt 	$t1, $s0, for		#Checa se o iterador � menor que o tamanho do vetor estabelecido anteriormente
		
################################################################################################################################
################################################################################################################################  
                
		la 	$t0, Vetor_B		#Pega endere�o base do Vetor B
		li 	$t1, 0			#Inicia iterador (i)
                
for1:		li 	$v0, 4			#Print "Vetor_B["
		la	$a0, message4
		syscall
		
		li 	$v0, 1			#Print iterador (i)
		add	$a0, $zero, $t1
		syscall
		
		li 	$v0, 4			#Print "]: "
		la	$a0, message3
		syscall
		
		li 	$v0, 5			#Read int
		syscall
		
		sw 	$v0, ($t0)
		
		addi 	$t0, $t0, 4		#Incrementa endere�o
		addi	$t1, $t1, 1		#Incrementa iterador
		blt 	$t1, $s0, for1		#Checa se o iterador � menor que o tamanho do vetor estabelecido anteriormente
		
################################################################################################################################
################################################################################################################################

		la 	$t0, Vetor_A		#Pega endere�o base do Vetor A
		la 	$t1, Vetor_B		#Pega endere�o base do Vetor B
		li 	$t2, 0  		#Inicializa iterador com 0
		
for2:		lw 	$t3, ($t0)		# $t3 = Vetor_A[i]
		lw 	$t4, ($t1)		# $t4 = Vetor_B[i]	
		sw 	$t3, ($t1)		# Vetor_B[i] = $t3
		sw 	$t4, ($t0)		# Vetor_A[i] = $t4
		
		addi	$t0, $t0, 4		#Incrementa endere�o do Vetor A
		addi	$t1, $t1, 4		#Incrementa endere�o do Vetor B
		addi	$t2, $t2, 1		#Incrementa iterador
		
		blt 	$t2, $s0, for2		#Checa se o iterador � menor que o tamanho do vetor estabelicido anteriormente
		
################################################################################################################################
################################################################################################################################

		la 	$t0, Vetor_A		#Pega endere�o base do Vetor A
		li 	$t1, 0			#Inicia iterador (i)
                 
for3: 		li 	$v0, 4			#Print "Vetor_A["
		la	$a0, message2
		syscall
		
		li 	$v0, 1			#Print iterador (i)
		add	$a0, $zero, $t1
		syscall
		
		li 	$v0, 4			#Print "]: "
		la	$a0, message3
		syscall
		
		li 	$v0, 1			#Print Vetor_A[i]
		lw 	$a0, ($t0)
		syscall
		
		li 	$v0, 4			#Print "\n"
		la 	$a0, quebra_linha	
		syscall
		
		addi 	$t0, $t0, 4		#Incrementa endere�o
		addi	$t1, $t1, 1		#Incrementa iterador
		blt 	$t1, $s0, for3		#Checa se o iterador � menor que o tamanho do vetor estabelecido anteriormente
		
################################################################################################################################
################################################################################################################################

		la 	$t0, Vetor_B		#Pega endere�o base do Vetor A
		li 	$t1, 0			#Inicia iterador (i)
                 
for4: 		li 	$v0, 4			#Print "Vetor_B["
		la	$a0, message4
		syscall
		
		li 	$v0, 1			#Print iterador (i)
		add	$a0, $zero, $t1
		syscall
		
		li 	$v0, 4			#Print "]: "
		la	$a0, message3
		syscall
		
		li 	$v0, 1			#Print Vetor_B[i]
		lw 	$a0, ($t0)
		syscall
		
		li 	$v0, 4			#Print "\n"
		la 	$a0, quebra_linha	
		syscall
		
		addi 	$t0, $t0, 4		#Incrementa endere�o
		addi	$t1, $t1, 1		#Incrementa iterador
		blt 	$t1, $s0, for4		#Checa se o iterador � menor que o tamanho do vetor estabelecido anteriormente
