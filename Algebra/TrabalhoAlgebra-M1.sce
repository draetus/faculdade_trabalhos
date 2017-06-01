loadmatfile("matriz.txt")

//Funcao que calcula a linha com maior numero de zeros
nlin = 0
cont2 = 0
for i = 1:4
    cont = 0
    for j = 1:4
        if matriz(i,j) == 0 then
            cont = cont + 1
        end
    end
    if cont > cont2 then
        nlin = i
        cont2 = cont
        for j = 1:4
            linha(1,j) = matriz(i,j)
        end
    end
end

//Caso não houver zero em nenhuma linha é escolhida a primeira linha
if nlin == 0 then
    nlin = 1
    for j = 1:4
        linha(1,j) = matriz(1,j)
    end
end

//Funções que calculam as matrizes que se formam pelo uso do método do Laplace

//Caso a linha com maior numero de zeros seja a primeira
if nlin == 1 then
    for i = 1:3
        for j = 1:3
            matriza(i,j) = matriz(i+1,j+1)
            if j == 1 then
                matrizb(i,j) = matriz(i+1,j)
            else
                matrizb(i,j) = matriz(i+1,j+1)
            end
            if j == 3 then
                matrizc(i,j) = matriz(i+1,j+1)
            else
                matrizc(i,j) = matriz(i+1,j)
            end
            matrizd(i,j) = matriz(i+1,j)
        end
    end
end

//Caso a linha com maior numero de zeros seja a segunda
if nlin == 2 then
    for i = 1:3
        for j = 1:3
            if i == 1 then
                matriza(i,j) = matriz(i,j+1)
                if j == 1 then
                    matrizb(i,j) = matriz(i,j)
                else
                    matrizb(i,j) = matriz(i,j+1)
                end
                if j == 3 then
                    matrizc(i,j) = matriz(i,j+1)
                else
                    matrizc(i,j) = matriz(i,j)
                end
                matrizd(i,j) = matriz(i,j)
            else
                matriza(i,j) = matriz(i+1,j+1)
                if j == 1 then
                    matrizb(i,j) = matriz(i+1,j)
                else
                    matrizb(i,j) = matriz(i+1,j+1)
                end
                if j == 3 then
                    matrizc(i,j) = matriz(i+1,j+1)
                else
                    matrizc(i,j) = matriz(i+1,j)
                end
                matrizd(i,j) = matriz(i+1,j)
            end
        end
    end
end

//Caso a linha com maior numero de zeros seja a terceira
if nlin == 3 then
    for i = 1:3
        for j = 1:3
            if i == 3 then
               matriza(i,j) = matriz(i+1,j+1)
                if j == 1 then
                    matrizb(i,j) = matriz(i+1,j)
                else
                    matrizb(i,j) = matriz(i+1,j+1)
                end
                if j == 3 then
                    matrizc(i,j) = matriz(i+1,j+1)
                else
                    matrizc(i,j) = matriz(i+1,j)
                end
                matrizd(i,j) = matriz(i+1,j)
            else
                matriza(i,j) = matriz(i,j+1)
                if j == 1 then
                    matrizb(i,j) = matriz(i,j)
                else
                    matrizb(i,j) = matriz(i,j+1)
                end
                if j == 3 then
                    matrizc(i,j) = matriz(i,j+1)
                else
                    matrizc(i,j) = matriz(i,j)
                end
                matrizd(i,j) = matriz(i,j)
             end
        end
    end
end

//Caso a linha com maior numeros de zeros seja a quarta
if nlin == 4 then
    for i = 1:3
        for j = 1:3
            matriza(i,j) = matriz(i,j+1)
            if j == 1 then
                matrizb(i,j) = matriz(i,j)
            else
                matrizb(i,j) = matriz(i,j+1)
            end
            if j == 3 then
                matrizc(i,j) = matriz(i,j+1)
            else
                matrizc(i,j) = matriz(i,j)
            end
            matrizd(i,j) = matriz(i,j)
        end
    end
end

soma = 0
 
//Atribuindo determinantes a um vetor
determinantes(1,1) = det(matriza)
determinantes(1,2) = det(matrizb)
determinantes(1,3) = det(matrizc)
determinantes(1,4) = det(matrizd)

//Calculo do Determinante pelo metodo Laplace
for j = 1:4
    if modulo(nlin+j,2) <> 0 then
        determinantes(1,j) = determinantes(1,j) * -1
    end
    soma = soma + determinantes(1,j)*matriz(nlin,j)
end

//Calculo do determinantes por comando Scilab
scilab = det(matriz)

//Apresentação de dados
disp(linha,"Linha escolhida: ")
disp(nlin,"Numero da linha: ")
disp(soma,"Determinantes da matriz pelo metodo do Laplace: ")
disp(scilab,"Determinante calculado por comando scilab: ")
