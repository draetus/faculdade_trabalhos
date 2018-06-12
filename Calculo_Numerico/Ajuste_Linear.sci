clear
close
clc

valor = 3
x = [1; 2; 3; 4; 5]
y = [15; 28.4; 45.3; 58.6; 77.4]

X = [size(x,1) sum(x); sum(x) sum(x^2)]
Y = [sum(y); sum(x.*y)]

A = X\Y

resultado = A(1,1)+A(2,1)*valor
disp (resultado, "Resultado: ")
disp (A, "A: ")
disp ("f(x) = a+b/x")
