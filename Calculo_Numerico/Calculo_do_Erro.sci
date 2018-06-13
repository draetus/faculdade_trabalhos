clear
close
clc

X = [1; 2; 3; 4; 5]
Y = [15; 28.4; 45.3; 58.6; 77.4]

function [s] = minimo_quadrado(x, y)
    X = [size(x,1) sum(x); sum(x) sum(x^2)]
    Y = [sum(y); sum(x.*y)]
    s = X\Y
endfunction

function [s] = logaritmico(x, y)
    A = minimo_quadrado(log(x), y)
    a = A(2,1)
    b = exp(A(1,1)/A(2,1))
    s = a*log(b.*x)
endfunction

function [s] = hiperbolico(x, y)
    A = minimo_quadrado(1./x, y)
    a = A(1,1)
    b = A(2,1)
    s = a*b./x
endfunction

function [s] = trigonometrico(x, y)
    A = minimo_quadrado(cos(x), y)
    a = A(1,1)
    b = A(2,1)
    s = a+b*cos(x)
endfunction

function [s] = linear(x, y)
    A = minimo_quadrado(x, y)
    s = A(1,1) + A(2,1).*x
endfunction

function [s] = quadratico(x, y)
    X = [size(x,1) sum(x) sum(x^2); sum(x) sum(x^2) sum(x^3); sum(x^2) sum(x^3) sum(x^4)]
    Y = [sum(y); sum(y.*x); sum(y.*x^2)]
    A = X\Y
    s = A(1,1) + A(2,1).*x + A(3,1).*x^2
endfunction

function [s] = potencial(x, y)
    A = minimo_quadrado(log(x), log(y))
    a = exp(A(1,1))
    b = A(2,1)
    s = a.*x^b
endfunction

function [s] = exponencial(x, y)
    A = minimo_quadrado(x, log(y))
    a = exp(A(1,1))
    b = A(2,1)
    s = a*exp(b.*x)
endfunction

function [s] = calculaErro(y, y1)
    s = abs((y-y1)./y)
endfunction

function printall()
    linear = linear(X, Y)
    quadratico = quadratico(X, Y)
    potencial = potencial(X, Y)
    exponencial = exponencial(X, Y)
    logaritmico = logaritmico(X, Y)
    hiperbolico = hiperbolico(X, Y)
    trigonometrico = trigonometrico(X, Y)
    
    linearErro = calculaErro(Y, linear)
    quadraticoErro = calculaErro(Y, quadratico)
    potencialErro = calculaErro(Y, potencial)
    exponencialErro = calculaErro(Y, exponencial)
    logaritmicoErro = calculaErro(Y, logaritmico)
    hiperbolicoErro = calculaErro(Y, hiperbolico)
    trigonometricoErro = calculaErro(Y, trigonometrico)
    
    minimum = min([max(linearErro) max(quadraticoErro) max(potencialErro) max(exponencialErro) max(logaritmicoErro) max(hiperbolicoErro) max(trigonometricoErro)])
    
    allResults = [linearErro quadraticoErro potencialErro exponencialErro]
    maximum = [max(linearErro) max(quadraticoErro) max(potencialErro) max(exponencialErro)]
    disp("Linear   Quadratico   Potencial   Exponencial")
    disp(allResults)
    disp("Valores Maximos: ")
    disp(maximum)
    allResults = [logaritmicoErro hiperbolicoErro trigonometricoErro]
    maximum = [max(logaritmicoErro) max(hiperbolicoErro) max(trigonometricoErro)]
    disp("Logaritmico Hiperbolico Trigonometrico")
    disp(allResults)
    disp("Valores Maximos: ")
    disp(maximum)
    disp("Valor Minimo de Erro:")
    disp(minimum)
endfunction

printall
