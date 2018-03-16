aluno(joao, paradigmas).
aluno(maria, paradigmas).
aluno(joel, lab2).
aluno(joel, estruturas).
frequenta(joao, feup).
frequenta(maria, feup).
frequenta(joel, ist).
professor(carlos, paradigmas).
professor(ana_paula, estruturas).
professor(pedro, lab2).
funcionario(pedro, ist).
funcionario(ana_paula, feup).
funcionario(carlos, feup).

ensina(X, Y):- professor(X, Z), aluno(Y, Z).

frequentado(X, Y):- frequenta(Y, X).
frequentado(X, Y):- funcionario(Y, X).

colega(X, Y):- frequenta(X, Z), frequenta(Y, Z), X \== Y.
colega(X, Y):- funcionario(X, Z), funcionario(Y, Z), X \== Y.