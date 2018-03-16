soma(X,Y,Z):- Z is X+Y.

maior(X,Y,Z):- X>Y, Z is X.
maior(X,Y,Z):- X<Y, Z is Y.

menor(X,Y,Z):- X<Y, Z is X.
menor(X,Y,Z):- X>Y, Z is Y.

par(X):- Z is X mod 2, Z =:= 0.

impar(X):- Z is X mod 2, Z =\= 0.