########################################################################################
# Atividade: Avaliação 01 
# Disciplina: Arquitetura e Organização de Computadores
# Programação em Linguagem de Montagem
# Grupo: Mauricio
# Este exercicio aborda o uso da instrução syscall, da instrução add e dos registradores
########################################################################################

.data 


.text

addi $v0, $zero, 5  # Adiciona Codigo de Read int
syscall             # Chamada do sistema
add $a0, $zero, $v0 # Adiciona valor lido ao registrador
addi $v0, $zero, 1  # Adiciona codio de Print int
syscall             # Chamada do sistema