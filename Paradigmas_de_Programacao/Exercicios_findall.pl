filme(f1, 'X-Men: Primeira Classe', 2011, 'Matthew Vaughn', usa).
filme(f2, 'Diários de motocicleta', 2004, 'Walter Salles', br).
filme(f3, 'O Palhaço', 2011, 'Selton Mello', br).
filme(f4, 'Lisbela e o Prisioneira', 2003, 'Guel Arraes', br).
filme(f5, 'O Filme da Minha Vida', 2017, 'Selton Mello', br). 

pais(usa, 'United States of America').
pais(br, 'Brasil'). 

dvd(d1, f1, est1).
dvd(d2, f2, est2).
dvd(d3, f3, est3).
dvd(d4, f4, est1).
OAOAOAdvd(d6, f1, est2).
dvd(d7, f2, est3).
dvd(d8, f3, est1).
dvd(d9, f4, est2). 

cliente(c1, 'Bia', '3333-3112').
cliente(c2, 'Zeca', '3245-1099').
cliente(c3, 'Marcos', '3323-0685').
cliente(c4, 'Bianca', '3333-4391').
cliente(c5, 'Alice', '3251-7439').
cliente(c6, 'Monica', '3212-3271'). 

locacao(c1, d1, '2018-04-07').
locacao(c1, d2, '2018-04-07').
locacao(c2, d9, '2018-04-10').
locacao(c3, d8, '2018-04-11').
locacao(c4, d8, '2018-04-12').
locacao(c5, d2, '2018-04-12').
locacao(c6, d6, '2018-04-12').
locacao(c1, d6, '2018-04-13').
locacao(c6, d2, '2018-04-14').
locacao(c3, d2, '2018-04-14').
locacao(c3, d6, '2018-04-14').
locacao(c5, d1, '2018-04-15'). 

p1:- findall(Titulo, filme(_,Titulo,_,'Selton Mello',_), R),
sort(R,Nomes),write(Nomes).

p2:- findall(Titulo,(pais(Sigla,'Brasil'),filme(_,Titulo,_,_,Sigla)), R),
sort(R,Nomes), write(Nomes). 

p3:- findall(filme(T,D),(pais(Cod,'Brasil'),filme(_,T,A,D,Cod),A=<2010),R),
sort(R,Nomes), write(Nomes).

p4:- findall(T, (filme(_, T, 2011, _, _)) ,R), 
    sort(R, Nomes), write(Nomes).

p5:- findall(IdDvd, (pais(C,'Brasil'), filme(Idf,_,_,_,C), dvd(IdDvd, Idf, _)), R),
    sort(R,Nomes), write(Nomes).

p6:- findall(IdDvd, (pais(C,'Brasil'), filme(Idf,_,_,_,C), dvd(IdDvd, Idf, est2)), R),
    sort(R,Nomes), write(Nomes).

p7:- findall(D, (dvd(_,F,est1), filme(F, _, _, D, _)), R), 
    sort(R,Nomes), write(Nomes).

p8:- findall(Filme, (filme(Id, Filme, _, _, _), not(dvd(_, Id, _))), R),
    sort(R,Nomes), write(Nomes).
