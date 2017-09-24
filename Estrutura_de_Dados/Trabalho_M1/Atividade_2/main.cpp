#include "Jogador.h"
#include "Lista.h"
#include "Nodo.h"
#include "Carta.h"
#include <stdlib.h>
#include <ctime>

void criaMonte (Lista<Carta> &monte) {
    string naipes[4] = {"paus", "espadas", "copas", "ouros"};
    for (int i = 0; i < 4; i++) {
        for (int j = 1; j < 14; j++) {
            Carta carta(j, naipes[i]);
            monte.insereElemento(carta, 1);
        }
    }
}

void mostraMesa (Jogador &usuario, Jogador &ia) {
    cout << "\nCartas dos jogadores:\n";
    cout << usuario.getNome() << ":" << endl;
    usuario.getMao().mostraLista();
    cout << "Score: " << usuario.getPontuacao();
    cout << endl << ia.getNome() << ":"<< endl;
    Carta carta = ia.getMao().getElemento(1);
    cout << carta;
}

int leMenu () {
    int opcao;
    do {
        cout << "\nSelecione:\n";
        cout << "1 - Hit\n";
        cout << "2 - Stay\n";
        cin >> opcao;
    } while (opcao < 1 || opcao > 2);
    return opcao;
}

Jogador* checaVencedor (Jogador &usuario, Jogador &ia) {
    if (usuario.getPontuacao() > 21) {
        return &ia;
    }
    else
    {
        if (ia.getPontuacao() > 21)
        {
            return &usuario;
        }
    }
    if (ia.getPontuacao() > 0) {
        if (usuario > ia) {
            return &usuario;
        }
        return &ia;
    }
    return NULL;
}

int main() {
    Lista<Carta> monte;
    criaMonte(monte);
    int randomAux = 0;

    string nomeJogador;
    cout << "Entre seu nome: ";

    cin >> nomeJogador;
    Jogador usuario(nomeJogador);
    Jogador ia("Ned");
    Lista<Carta> cartasInicio;
    int randomInt;
    Carta carta;


    for (int i=0;i<2;i++)
    {
        srand(time(0));
        randomInt = rand() % (52 - randomAux) + 1;
        carta = monte.getElemento(randomInt);
        usuario.addCarta(carta);
        monte.removeElemento(randomInt);
        randomAux++;
    }

    for (int i=0;i<2;i++)
    {
        srand(time(0));
        randomInt = rand() % (52 - randomAux) + 1;
        carta = monte.getElemento(randomInt);
        ia.addCarta(carta);
        monte.removeElemento(randomInt);
        randomAux++;
    }

    int opcao;
    Jogador *vencedor = NULL;
    randomAux = -1;

    do {
        if (opcao != 2)
        mostraMesa(usuario, ia);

        opcao = leMenu();
        switch(opcao)
        {
        case 1:
            randomAux++;
            srand(time(0));
            randomInt = rand() % (48 - randomAux) + 1;
            carta = monte.getElemento(randomInt);
            cout << "Carta Comprada: " << carta;
            usuario.addCarta(carta);
            monte.removeElemento(randomInt);
            break;

        case 2:
            while (ia.getPontuacao() < 17)
            {
                srand(time(0));
                randomInt = rand() % (48 - randomAux) + 1;
                carta = monte.getElemento(randomInt);
                ia.addCarta(carta);
                monte.removeElemento(randomInt);
                randomAux++;
                cout << "Ned comprou: " << carta;
            }
            break;

        default:
            cout << "Opcao invalida";
            break;
        }

        if (opcao == 2 || usuario.getPontuacao() >= 21)
        {
            vencedor = checaVencedor(usuario, ia);
        }

    } while(vencedor == NULL);

    cout << "\nMao final " << usuario.getNome() << ": \n";
    usuario.getMao().mostraLista();
    cout << "Score: " << usuario.getPontuacao() << endl;
    cout << "\nMao final Ned: \n";
    ia.getMao().mostraLista();
    cout << "Score: " << ia.getPontuacao() << endl;
    cout << endl << vencedor -> getNome() << " venceu com " << vencedor -> getPontuacao() << " pontos!" << endl;

    return 0;
}
