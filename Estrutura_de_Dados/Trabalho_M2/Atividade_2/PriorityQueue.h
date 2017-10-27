#ifndef PRIORITYQUEUE_H_INCLUDED
#define PRIORITYQUEUE_H_INCLUDED

#include "Node.cpp"

template <class T>
class PriorityQueue {
    Node<T> *head, *tail;
    int queueSize;
public:
    PriorityQueue();
    ~PriorityQueue();
    bool isEmpty();
    bool elementExistence(T data);
    void insertElement(T data, int priority);
    void removeElement();
    void print();
};

#endif // PRIORITYQUEUE_H_INCLUDED
