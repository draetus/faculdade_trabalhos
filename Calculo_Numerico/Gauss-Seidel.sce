//Método de Gauss-Seidel

clear 
close
clc

A=[1,-1,1; 4,2,1; 0,0,1];
y=[4;-1;1];
n=size(A,1);

Ab=[A y] // Matriz Ampliada
disp("Matriz Ampliada Ab = ")
disp(Ab)

for j=1:(n-1)
    for i=(j+1):n
        m(i,j)=Ab(i,j)/Ab(j,j);
        Ab(i,:)=Ab(i,:)-m(i,j)*Ab(j,:);
    end
end

// Até aqui o algoritmo chega na matriz triangular superior
// Falta fazer a retro substituição


disp("Matriz Triangular Ab = ")
disp(Ab)

x=[];
x(n)=Ab(n,n+1)/Ab(n,n); // Resolve o último valor de x

for i=(n-1):-1:1
    x(i,1)=(Ab(i,n+1)-Ab(i,(i+1:n))*x((i+1:n),1))/Ab(i,i);
end

disp("Matriz solução do sistema x = ")
disp(x)
