clear
close
clc

valor = 4.5
x = [2.2; 2.7; 3.5; 4.1]
y = [65; 60; 53; 50]

X = [size(x,1) sum(log(x)); sum(log(x)) sum(log(x)^2)]
Y = [sum(log(y)); sum(log(x).*log(y))]

A = X\Y

a = exp(A(1,1))
b = A(2,1)

resultado = a*valor^b
disp (resultado, "Resultado: ")
disp (b, "b: ", a, "a: ")
disp ("f(x) = a*x^b")
