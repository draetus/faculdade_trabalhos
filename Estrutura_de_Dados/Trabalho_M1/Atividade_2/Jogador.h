#ifndef JOGADOR_H_INCLUDED
#define JOGADOR_H_INCLUDED

#include "Carta.h"
#include "Lista.h"

class Jogador {
    string nome;
    Lista<Carta> mao;
    int pontuacao;
    int azesModificados;
public:
    Jogador(string);
    void addCarta(Carta);
    Lista<Carta>& getMao();
    void mostraMao();
    void addPontuacao(int);
    int getPontuacao();
    string getNome();
    friend bool operator > (Jogador &jogador1, Jogador &jogador2);
};

#endif // JOGADOR_H_INCLUDED
