gerou(maria,jose).
gerou(joao, ana).
gerou(jose, iris).
gerou(joao, jose).
gerou(jose, julia).
gerou(jose, amanda).
gerou(iris, jorge).
gerou(julia, raquel).
gerou(alice, julia).
gerou(alice, amanda).
gerou(alice, iris).
masculino(joao).
masculino(jorge).
masculino(jose).
feminino(maria).
feminino(julia).
feminino(ana).
feminino(iris).
feminino(alice).

filho(Y, X):- masculino(Y), gerou(X, Y).
mae(X, Y):- feminino(X), gerou(X, Y).
avo(X, Z):- masculino(X), gerou(X, Y), gerou(Y, Z).
irma(X, Y):- feminino(X), gerou(Z, X), gerou(Z, Y), X\==Y.

irmao(X, Y):- masculino(X), gerou(Z, X), gerou(Z, Y), X\==Y.

antepassado(X, Z):- gerou(X, Z).
antepassado(X, Z):- gerou(X, Y), antepassado(Y, Z).

pai(X, Y):- masculino(X), gerou(X, Y).
filha(Y, X):- feminino(Y), gerou(X, Y).
tio(X, Y):- masculino(X), gerou(Z, Y), irmao(X, Z).
tia(X, Y):- feminino(X), gerou(Z, Y), irma(X,Z).
primo(X, Y):- masculino(X), tio(Z, X), gerou(Z, Y).
primo(X, Y):- masculino(X), tia(Z, X), gerou(Z, Y).
prima(X, Y):- feminino(X), tio(Z, X), gerou(Z, Y).
prima(X, Y):- feminino(X), tia(Z, X), gerou(Z, Y).
