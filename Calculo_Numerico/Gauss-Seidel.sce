//Método de Gauss-Seidel

clear 
close
clc

A=[10 2 1;1 5 1;2 3 10];
b=[7;-8;6];
x=[0.7;-1.6;0.6];
erro=0.05;

Ab=[A b] // Matriz Ampliada
n=size(A,1);

k=0; //contador de iterações

for i=1:n
    for j=i:n
        if i<>j
            if i<j 
                x(i,1)=(Ab(i,n+1)-Ab(i,j:n)*x(j:n,1));
            else
                x(i,1)=(Ab(i,n+1)-Ab(i,j:n)*x(j:n,1));
            end
        end
    end
end

//end

//for i=1:n
//    x(i,1)=(Ab(i,n+1)-Ab(i,(i+1:n))*x0((i+1:n),1)-Ab(i,(1:i-1))*x0(((1:i-1),1)))/Ab(i,i);
//end

//d=2*erro;
//while d>erro
//    for i=1:n
//        x(i,1)=(Ab(i,n+1)-Ab(i,(i+1:n))*x((i+1:n),1))/Ab(i,i);
//    end
//    d=norm(x1-x);
//    k=k+1;
//    x=x1;
//end
