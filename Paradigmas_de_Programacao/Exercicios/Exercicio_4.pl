comprou(joao, honda).
comprou(joao, uno).
ano(honda, 2014).
ano(uno, 2015).
valor(honda, 20000).
valor(uno, 7000).

pode_vender(X,Y,Z):- comprou(X, Y), valor(Y, A), A<10000, ano(Y, B), Z<B+11.