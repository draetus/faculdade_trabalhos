# Disciplina: Arquitetura e Organizacao de Computadores
# Atividade: Avaliacao 01 - Programacao em Linguagem de Montagem
# Programa 01
# Grupo: - Mauricio

.data 	######################        DADOS        ######################

presenca:	.word	0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF,0xFFFFFFFF
message1:	.asciiz	"Entre com o numero da aula (de 0 a 15):"
message2:	.asciiz	"Entre com o numero do aluno (de 0 a 31):"
message3:	.asciiz	"Entre com o tipo do registro (presenca = 1; ausencia = 0):"
invalid:	.asciiz "Valor Invalido.\n"
message4:	.asciiz	"Dado Modificado: "
quebra_linha:	.asciiz "\n"

.text 	######################        CODIGO        ######################

while:
		j	while1
		
		
invalid1:
		li 	$v0, 4			#Print "Valor invalido.\n"
		la	$a0, invalid
		syscall
while1:
		li 	$v0, 4			#Print "Entre com o numero da aula (de 0 a 15):"
		la 	$a0, message1
		syscall
		
		li 	$v0, 5			#Read int
		syscall
		blt 	$v0, 0, invalid1	#Desvia para invalid1 se for menor que 0
		bgt	$v0, 15, invalid1	#Desvia para invalid1 se for maior que 15
		
		sll	$v0, $v0, 2
		la 	$s0, presenca($v0)	#Somando endereco recebido com endereco base de presenca, conseguindo o endereco desejado no vetor
		j 	while2
		

invalid2:
		li 	$v0, 4			#Print "Valor invalido.\n"
		la	$a0, invalid
		syscall
while2:
		li 	$v0, 4			#Print "Entre com o numero do aluno (de 0 a 31):"
		la 	$a0, message2
		syscall
		
		li 	$v0, 5			#Read int
		syscall
		blt 	$v0, 0, invalid2	#Desvia para invalid2 se for menor que 0
		bgt	$v0, 31, invalid2	#Desvia para invalid2 se for maior que 31
		
		addi	$s1, $zero, 1		#Carrega valor base da mascara
		sllv	$s1, $s1, $v0		#Move para esquerda o tanto especificado pelo usuario
		j 	while3
		
		
invalid3:
		li 	$v0, 4			#Print "Valor invalido.\n"
		la	$a0, invalid
		syscall
while3:
		li 	$v0, 4			#Print "Entre com o tipo do registro (presenca = 1; ausencia = 0):"
		la 	$a0, message3
		syscall
		
		li 	$v0, 5			#Read int
		syscall
		beq	$v0, 1, casopresenca	#Desvia para casopresenca se for igual a 1
		beq	$v0, 0, casoausencia	#Desvia para casoausencia se for igual a 0
		j	invalid3		#Desvia para invalid3 caso valor lido nao seja nem 1 nem 0
		
casopresenca:
		lw 	$t0, ($s0)		#Carrega valor do vetor para registrador $t0
		or 	$t0, $t0, $s1		#Aplica or para registrar presenca
		sw	$t0, ($s0)		#Salva de volta no vetor
		j	print

casoausencia:
		lw 	$t0, ($s0)		#Carrega valor do vetor para registrador $t0
		xori 	$s1, $s1, 0xFFFFFFFF	#Aplica xor com 1 para inverter os bits
		and 	$t0, $t0, $s1		#Aplica and para registrar ausencia
		sw	$t0, ($s0)		#Salva valor no vetor
		j	print
		
print:
		li	$v0, 4			#Print "Binario: "
		la	$a0, message4
		syscall
		
		li	$v0, 35			#Print Posiçao do vetor em binario
		add	$a0, $t0, $zero
		syscall
		
		li 	$v0, 4			#Print '\n'
		la 	$a0, quebra_linha
		syscall
		j 	while
