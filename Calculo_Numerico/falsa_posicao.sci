clear
close

function [s] = f(x)
    s = x*log(x) - 1;
endfunction


a = 1;
b = 2;
e = 0.002;
k=1; //contador de iterações
x=(a*f(b) - b*f(a))/(f(b)-f(a));

while abs(b-a)>e & abs(f(x))>e
    
    if f(x) == 0
        break;
    elseif f(a)*f(x)>0
        a=x;
        else
            b=x;
    end
    x=(a*f(b) - b*f(a))/(f(b)-f(a));
    k=k+1;
end

disp("METODO FALSA POSICAO");
disp("X = ");
disp(x);
disp("Iteracoes = ");
disp(k);
