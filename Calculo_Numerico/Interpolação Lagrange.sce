//Interpolação Lagrange

clear
close
clc

x = [0; 0.2; 0.4; 0.5]
y = [0; 2.008; 4.064; 5.125]
p1 = 0.3
p2 = poly(0, 'p')


n = size(x,1)
L = zeros(n,1)

function [s] = main(p)
    for i=1 :(n)
        aux1 = 1
        aux2 = 1
        for j=1 : (n)
            if j<>i
                aux1 = aux1 * (p - x(j, 1))
                aux2 = aux2 * (x(i, 1) - x(j, 1))
            end
        end
        L(i, 1) = aux1/aux2
    end
    
    resultado = 0
    for i=1 :(n)
        resultado = resultado + (y(i,1) * L(i,1))
    end
    s = resultado
endfunction

resultado = main(p1)
polinomio = main(p2)

disp(y, "Y: ", x, "X: ")
disp(resultado, "Resultado: ", p1, "Ponto:")
disp(polinomio, "Polinomio: ")
