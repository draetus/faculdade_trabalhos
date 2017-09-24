#include "Nodo.h"

template <typename T>
Nodo<T>::Nodo(T data, Nodo* next) {
    this -> data = data;
    this -> next = next;
}

template <typename T>
Nodo<T>* Nodo<T>::getNext() {
    return next;
}

template <typename T>
void Nodo<T>::setNext(Nodo<T>* next) {
    this -> next = next;
}

template <typename T>
T Nodo<T>::getData() {
    return data;
}

template class Nodo<float>;
template class Nodo<string>;
template class Nodo<int>;
template class Nodo<Carta>;
