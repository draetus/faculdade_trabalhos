#ifndef LISTA_H_INCLUDED
#define LISTA_H_INCLUDED

#include "Nodo.h"

template <typename T>
class Lista {
    Nodo<T> *head, *tail;
    int tamanho;
    void aumentaTamanho();
    void diminuiTamanho();
public:
    Lista<T>();
    ~Lista<T>();
    bool verificaElemento(T);
    void insereElemento(T, int);
    void removeElemento(int);
    void mostraLista();
    int getTamanho();
    T getElemento(int);

    Nodo<T>* getHead();
    void setHead(Nodo<T>*);
    Nodo<T>* getTail();
    void setTail(Nodo<T>*);
};

#endif // LISTA_H_INCLUDED
