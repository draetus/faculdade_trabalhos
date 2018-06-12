clear
close
clc

valor = 4.5
x = [%pi/4; %pi/2; 3*%pi/4; %pi; 5*%pi/4; 3*%pi/2; 7*%pi/4; 2*%pi]
y = [126; 159; 191; 178; 183; 179; 176; 149]

X = [size(x,1) sum(cos(x)); sum(cos(x)) sum(cos(x)^2)]
Y = [sum(y); sum(cos(x).*y)]

A = X\Y

a = A(1,1)
b = A(2,1)

resultado = a+b*cos(valor)
disp (resultado, "Resultado: ")
disp (b, "b: ", a, "a: ")
disp ("f(x) = a+b*cos(x)")
