clear
close
clc

valor = 15
x = [1; 2; 3; 4; 5; ;6 ;7; 8; 9; 10; 11]
y = [1.7; 2.5; 3.8; 4.4; 4.9; 5.2; 5.5; 5.6; 5.8; 5.9; 6]

X = [size(x,1) sum(log(x)); sum(log(x)) sum(log(x)^2)]
Y = [sum(y); sum(log(x).*y)]

A = X\Y

a = A(2,1)
b = exp(A(1,1)/A(2,1))

resultado = a*log(b*valor)
disp (resultado, "Resultado: ")
disp (b, "b: ", a, "a: ")
disp ("f(x) = a*log(b*x)")
