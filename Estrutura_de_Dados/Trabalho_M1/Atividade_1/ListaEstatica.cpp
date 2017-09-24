#include "ListaEstatica.h"

ListaEstatica::ListaEstatica()
{
    numeroElementos = 0;
    for (int i=0;i<100;i++)
    {
        elementos[i] = NULL;
        ocupados[i] = 0;
    }
}

bool ListaEstatica::verificaElemento(char elemento) {
    for (int i = 0; i < getNumeroElementos(); i++) {
        if (getElementos()[i] == elemento) {
            return true;
        }
    }
    return false;
}

bool ListaEstatica::verificaElementosLista(ListaEstatica listaEstatica) {
    for (int i = 0; i < getNumeroElementos(); i++) {
        for (int j = 0; j < listaEstatica.getNumeroElementos(); j++) {
            if (getElementos()[i] == getElementos()[j]) {
                break;
            }
            if (j == listaEstatica.getNumeroElementos() - 1) {
                return false;
            }
        }
    }
    return true;
}

void ListaEstatica::inserirElemento(int elemento) {
    if (getNumeroElementos() == 100) {
        return;
    }
    for (int i = 0; i <= getNumeroElementos(); i++) {
        if (getOcupados()[i] == 0) {
            getElementos()[i] = elemento;
            getOcupados()[i] = 1;
            incrementaNumeroElementos();
            return;
        }
    }
}

void ListaEstatica::inserirElementosLista(ListaEstatica listaEstatica) {
    if (getNumeroElementos() + listaEstatica.getNumeroElementos() > 100) {
        return;
    }
    for (int i = 0; i < listaEstatica.getNumeroElementos(); i++) {
        inserirElemento(listaEstatica.getElementos()[i]);
    }
}

void ListaEstatica::retirarElemento(int elemento) {
    for (int i = 0; i < getNumeroElementos(); i++) {
        if (getElementos()[i] == elemento) {
            getOcupados()[i] = 0;
            return;
        }
    }
}

void ListaEstatica::mostraLista() {
    int cont = 0;
    for (int i = 0; i < getNumeroElementos(); i++) {
        if (getOcupados()[i] == 1) {
            cout << getElementos()[i] << " ";
            cont++;
        }
    }
    cout << endl << "Tamanho: " << cont << endl;
}

void ListaEstatica::incrementaNumeroElementos() {
    numeroElementos++;
}

void ListaEstatica::decrementaNumeroElementos() {
    numeroElementos--;
}

int ListaEstatica::getNumeroElementos() {
    return numeroElementos;
}

char* ListaEstatica::getElementos() {
    return elementos;
}

int* ListaEstatica::getOcupados() {
    return ocupados;
}
