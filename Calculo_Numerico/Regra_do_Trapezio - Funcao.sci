clear
close
clc

function [s] = f(x)
    s = 3*x+2
endfunction

fb = 1
fa = 0
n = 4

x = zeros(n+1, 1)
y = zeros(n+1, 1)
x1 = poly(0, 'x')

//CALCULO DO RESULTADO (I)

h = (fb-fa)/n
x(1,1) = fa
for i=2:(n+1)
    x(i,1) = x(i-1,1)+h
end
for i=1:(n+1)
    y(i,1) = f(x(i,1))
end

h = x(2,1) - x(1,1)
I = h/2*y(1,1)
for (i=2:(n))
    I = I + h/2*y(i,1)*2
end
I = I + h/2*y(n+1,1)

disp(I, "Resultado:")

//CALCULO DO ERRO (ET)

fx = f(x1)
fxI = derivat(fx)
fxII = derivat(fxI)

disp(fx, "Funcao: ")
disp(fxI, "Derivada Primeira: ")
disp(fxII, "Derivada Segunda: ")
