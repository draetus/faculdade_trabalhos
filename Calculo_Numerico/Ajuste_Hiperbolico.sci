clear
close
clc

valor = 4.5
x = [1; 2; 3; 4; 5]
y = [0.2; 0.11; 0.08; 0.06; 0.05]

X = [size(x,1) sum(1./x); sum(1./x) sum(1./x^2)]
Y = [sum(y); sum((1./x).*y)]

A = X\Y

a = A(1,1)
b = A(2,1)

resultado = a*b/valor
disp (resultado, "Resultado: ")
disp (b, "b: ", a, "a: ")
disp ("f(x) = a+b/x")
