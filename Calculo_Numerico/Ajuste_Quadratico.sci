clear
close
clc

valor = 5
x = [1; 2; 3; 4; 5]
y = [15; 28.4; 45.3; 58.6; 77.4]

X = [size(x,1) sum(x) sum(x^2); sum(x) sum(x^2) sum(x^3); sum(x^2) sum(x^3) sum(x^4)]
Y = [sum(y); sum(y.*x); sum(y.*x^2)]

A = X\Y

resultado = A(1,1)+A(2,1)*valor+A(3,1)*valor^2
disp (resultado, "Resultado: ")
disp (A, "A: ")
disp ("f(x) = a+b/x")
