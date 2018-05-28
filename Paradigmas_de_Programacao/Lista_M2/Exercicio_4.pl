%Predicados dos slides

remover(X, [X | C], C).
remover(X, [Y | C], [Y | D]) :- remover(X, C, D).
inserir(X, L, L1) :- remover(X, L1, L).
tamanho([], 0).
tamanho([ _ | R], N) :- tamanho(R, N1), N is N1+1.
conc([], L, L). % concatenação
conc([X | L1], L2, [X | L3]) :- conc(L1, L2, L3).
inverter([], []). % inversão de lista
inverter([X | Y], Z) :- inverter(Y, Y1), conc(Y1, [X], Z).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Exercicio 4
%a)
lista_ate(1, [1]):- !.
lista_ate(N,L):- N1 is N-1, lista_ate(N1, L1), L = [N|L1].

%b)
lista_entre(N1, N1, [N1]):- !.
lista_entre(N1, N2, L):- N3 is N2-1, lista_entre(N1, N3, L1), L = [N2|L1].

%c)
soma_lista([], 0):- !.
soma_lista([X|L], Soma):- soma_lista(L, Soma1), Soma is X+Soma1.

%d)
par(N):- X is N mod 2, X =:= 0.

%e)
lista_pares(2, [2]):- !.
lista_pares(N, Y):- N > 2, par(N)-> N1 is N-1, lista_pares(N1, Y1), Y=[N|Y1] 
    ; N1 is N-1, lista_pares(N1, Y1),Y=Y1.
%lista_pares(N, Y):- N > 2, N1 is N-1, lista_pares(N1, Y1), par(N)->Y=[N|Y1] ; Y=Y1.
%Não entendi porque o de cima não funciona

%f)
ultimoElemento([Y|[]], Y):- !.
ultimoElemento([_|Lista], X):- ultimoElemento(Lista, X).

%g)
maiorElemento([Y|[]], Y):- !.
maiorElemento([Y|Lista], X):- maiorElemento(Lista, X1), Y>X1->X is Y
    ; maiorElemento(Lista, X2), X is X2.
%maiorElemento([Y|Lista], X):- maiorElemento(Lista, X1), Y>X1->X is Y; X is X1.
%Novamente não entendi porque o de cima não funciona

%h)
media(L, X):- soma_lista(L, X1), tamanho(L, X2), X is X1/X2.

%i)
posicao([],[],0):- !.
posicao([X1|X2],[Y1|Y2],A):- X1==Y1 -> posicao(X2,Y2,A1), A is A1+1 
    ; posicao(X2,Y2,A1), A is A1.
%posicao([X1|X2],[Y1|Y2],A):- posicao(X2,Y2,A1), X1==Y1 -> A is A1+1 ; A is A1.

checa_posicao(_,[],0):- !.
checa_posicao(X,[Y1|Y2],A):- X==Y1 -> checa_posicao(X, Y2, A1), A is A1+1 
    ; checa_posicao(X, Y2, A1), A is A1.
ambas_posicoes([], _, 0):- !.
ambas_posicoes([X1|X2],Y,A):- ambas_posicoes(X2, Y, A1), checa_posicao(X1, Y, A2), A is A1+A2.
escore(X,Y,A,B):- posicao(X,Y,A), ambas_posicoes(X,Y,B1), B is B1-A.

%j)
lista_igual([],[]).
lista_igual([X1|X2],[Y1|Y2]):- X1==Y1, lista_igual(X2, Y2).
palindromo(X):- inverter(X, Y), lista_igual(X, Y).