clear
close
clc

valor = 3
x = [1; 2; 3; 4; 5]
y = [15; 28.4; 45.3; 58.6; 77.4]

X = [size(x,1) sum(log(x)); sum(log(x)) sum(log(x)^2)]
Y = [sum(log(y)); sum(log(x).*log(y))]

A = X\Y

a = exp(A(1,1))
b = A(2,1)

resultado = a*valor^b
disp (resultado, "Resultado: ")
disp (b, "b: ", a, "a: ")
disp ("f(x) = a*x^b")
