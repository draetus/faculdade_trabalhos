#ifndef NODO_H_INCLUDED
#define NODO_H_INCLUDED

#include "Carta.h"

#include <iostream>

using namespace std;

template <typename T>
class Nodo {
    Nodo<T> *next;
    T data;
public:
    Nodo(T, Nodo<T>* = NULL);
    Nodo<T>* getNext();
    void setNext(Nodo<T>*);
    T getData();
};

#endif // NODO_H_INCLUDED
