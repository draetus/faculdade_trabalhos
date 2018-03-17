arco(a,b,3).
arco(a,d,5).
arco(a,c,4).
arco(b,d,2).
arco(c,d,4).
arco(d,e,2).
arco(e,f,2).
arco(c,f,5).

custo(U,V,L):- arco(U,V,L), !. % acesso direto
custo(U,V,L):- arco(V,U,L), !. % acesso direto invertido

custo(U,V,L):- arco(U,X,L1), custo(X,V,L2), L is L1+L2, !. % acesso indireto
custo(U,V,L):- arco(X,U,L1), custo(X,V,L2), L is L1+L2. % acesso indireto invertido