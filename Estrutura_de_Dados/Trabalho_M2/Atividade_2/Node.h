#ifndef NODE_H_INCLUDED
#define NODE_H_INCLUDED

#include <iostream>

using namespace std;

template <class T>
class Node {
    Node *next, *prev;
    T data;
    int priority;
public:
    Node(T data, int priority);
    void setNext(Node<T> *next);
    Node<T>* getNext();
    void setPrev(Node<T> *prev);
    Node<T>* getPrev();
    T getData();
    int getPriority();
};

#endif // NODE_H_INCLUDED
