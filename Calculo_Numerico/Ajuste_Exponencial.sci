clear
close
clc

valor = 0.3
x = [-1; -0.7; -0.4; -0.1; 0.2; 0.5; 0.8; 1]
y = [36.547; 17.264; 8.155; 3.852; 1.82; 0.86; 0.406; 0.246]

X = [size(x,1) sum(x); sum(x) sum(x^2)]
Y = [sum(log(y)); sum(x.*log(y))]

A = X\Y

a = exp(A(1,1))
b = A(2,1)

resultado = a*exp(b*valor)
disp (resultado, "Resultado: ")
disp (b, "b: ", a, "a: ")
disp ("f(x) = a*exp^(b*x)")
