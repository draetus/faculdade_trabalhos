.data
  enterNum: 
.asciiz "Enter your number (base 10):  "
 printBaseTwo: 
.asciiz "The number in base 2 is:  "
 #-----------------------------------------------------------------------

.text
#Print out string, collect intger input
main: li $v0, 4
      la $a0, enterNum
      syscall
  li $v0, 5
  syscall
  move $t0, $v0


#create mask/print out the second string and prepare to print out binary
mask: 
  addi $t1, $zero, 1
  sll $t1, $t1, 31
  addi $t2, $zero, 32
  li $v0, 4
  la $a0, printBaseTwo
  syscall


 # compares mask to integer, starting at the most sig place
 # if the mask is zero, print out zero
 loop: 
  and $t3,$t0, $t1
  beq $t3, $zero, print
  add $t3, $zero, $zero
  addi $t3, $zero, 1
  j print


 print: 
      #prepares to print integer in $a0
  li $v0, 1

      # moves either 1 or 0 into $a0 to be printed
  move $a0, $t3
  syscall

      # shifts over right 1, getting closer to 0
  srl $t1, $t1, 1

      #lowers count
  addi $t2, $t2, -1

      #loop back to beginning if not finished printing binary Num
  bne $t2, $zero, loop
  beq $t2, $zero, exit
 exit: 
  li $v0, 10
  syscall