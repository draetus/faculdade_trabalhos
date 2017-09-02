########################################################################################
# Atividade: Exercicio de Aquecimento 3
# Disciplina: Arquitetura e Organização de Computadores
# Programação em Linguagem de Montagem
# Grupo: Mauricio
# Este exercicio aborda o uso de instruções de desvio, da instrução syscall, e de 
# intruções de acesso à memória(la, lw e sw)
########################################################################################

.data # Dados
	message1    : .asciiz "LEITURA DOS ELEMENTOS DO VETOR: \n"
	message2    : .asciiz "Entre com A["
	message3    : .asciiz "A["
	message_end : .asciiz "]: "
	quebra_linha: .asciiz "\n"
	vetorA      : .word 0,0,0,0,0,0,0,0

.text # Codigos
main:
	li $v0, 4           # Print string
	la $a0, message1
	syscall


	########## LEITURA DO VETOR ##########

	la $s0, vetorA      # Pegando endereço base do vetor
	li $s1, 0           # Iterador (i)
	
LoopLeitura:
	li $v0, 4           # Print string
	la $a0, message2
	syscall
	
	li $v0, 1           # Print int
	add $a0, $zero, $s1
	syscall
	
	li $v0, 4           # Print String
	la $a0, message_end
	syscall
	
	li $v0, 5           # Read int
	syscall
	sw $v0, ($s0)        # Salvando int lido no vetor
	
	addi $s1, $s1, 1    # Incrementando o iterador
	addi $s0, $s0, 4    # Mudando endereço
	blt $s1, 8, LoopLeitura


	########## IMPRESSAO DO VETOR ##########
	
	la $s0, vetorA      # Pegando endereço base do vetor
	li $s1, 0           # Iterador (i)
	li $s2, 0           # Valor int a ser impresso
	
LoopImpressao:
	li $v0, 4	    # Print string
	la $a0, message3
	syscall
	
	li $v0, 1
	add $a0, $zero, $s1
	syscall
	
	li $v0, 4	    # Print string
	la $a0, message_end
	syscall
	
	li $v0, 1
	lw $s2, ($s0)
	add $a0, $zero, $s2
	syscall
	
	li $v0, 4
	la $a0, quebra_linha
	syscall
	
	addi $s1, $s1, 1
	addi $s0, $s0, 4
	blt $s1, 8, LoopImpressao