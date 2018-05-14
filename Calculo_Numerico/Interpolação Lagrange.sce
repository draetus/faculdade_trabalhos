//Interpolação Lagrange

clear
close
clc

x = [0; 0.2; 0.4; 0.5]
y = [0; 2.008; 4.064; 5.125]
p = 0.3


n = size(x,1)
L = zeros(n,1)

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

disp(y, "Y: ", x, "X: ")
disp(resultado, "Resultado: ", p, "Ponto:")
