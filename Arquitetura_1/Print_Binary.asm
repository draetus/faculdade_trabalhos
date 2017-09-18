.data
message1: 	.asciiz 	"Enter your number (base 10): "
message2:	.asciiz 	"Binary: "

.text

main:
	li	$v0, 4			#Print "Enter your number (base 10):  "
	la	$a0, message1
	syscall
	
	li	$v0, 5			#Read int
	syscall
	add	$s0, $zero, $v0		#Saves integer in $s0
	
	addi	$s1, $zero, 1		#Creates bit mask
	sll	$s1, $s1, 31		#Moves bit to the last position (32 bits)
	li 	$t0, 32			#Loop's Controller
	
	li	$v0, 4			#Print "Binary: "
	la	$a0, message2
	syscall
	
loop:
	and 	$t1, $s0, $s1		#Gets response 0 or some other
	beq	$t1, $zero, print	#If it gets 0 then it straight out print
	addi	$t1, $zero, 1		#if not gets a 0, then $t1 = 1
	
print:
	li	$v0, 1			#Print int
	add	$a0, $zero, $t1		#The response of the and will be printed
	syscall
	
	srl	$s1, $s1, 1		#Moves the bit mask one to the right so it gets closer to 0
	addi	$t0, $t0, -1		#Decreases the loop counter
	bne	$t0, $zero, loop	#Branch to loop if $t0 is not equal to 0 ( = end of loop)