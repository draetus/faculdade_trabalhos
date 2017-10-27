#include "Node.h"

template <class T>
Node<T>::Node(T data, int priority) {
    next = NULL;
    prev = NULL;
    this -> data = data;
    this -> priority = priority;
}

template <class T>
void Node<T>::setNext(Node<T> *next) {
    this -> next = next;
}

template <class T>
Node<T>* Node<T>::getNext() {
    return next;
}

template <class T>
void Node<T>::setPrev(Node<T> *prev) {
    this -> prev = prev;
}

template <class T>
Node<T>* Node<T>::getPrev() {
    return prev;
}

template <class T>
T Node<T>::getData() {
    return data;
}

template <class T>
int Node<T>::getPriority() {
    return priority;
}
