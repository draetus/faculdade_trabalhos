#ifndef LISTAESTATICA_H_
#define LISTAESTATICA_H_

#include <iostream>

using namespace std;

class ListaEstatica {
    int numeroElementos;
    char elementos [100];
    int ocupados [100];
    void incrementaNumeroElementos();
    void decrementaNumeroElementos();
    int getNumeroElementos();
    char* getElementos();
    int* getOcupados();
public:
    ListaEstatica();
    bool verificaElemento(char elemento);
    bool verificaElementosLista(ListaEstatica listaEstatica);
    void inserirElemento(int elemento);
    void inserirElementosLista(ListaEstatica listaEstatica);
    void retirarElemento(int elemento);
    void mostraLista();
};

#endif /* LISTAESTATICA_H_ */
