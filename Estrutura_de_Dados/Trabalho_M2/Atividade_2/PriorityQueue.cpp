#include "PriorityQueue.h"

template <class T>
PriorityQueue<T>::PriorityQueue() {
    head = NULL;
    tail = NULL;
    queueSize = 0;
}

template <class T>
PriorityQueue<T>::~PriorityQueue() {
    Node<T> *temp = head;
    while (temp != NULL) {
        head = head -> getNext();
        delete temp;
        temp = head;
    }
}

template <class T>
bool PriorityQueue<T>::isEmpty() {
    return queueSize == 0;
}

template <class T>
bool PriorityQueue<T>::elementExistence(T data) {
    Node<T> *temp = head;
    while (temp != NULL) {
        if (temp -> getData() == data) {
            return true;
        }
        temp = temp -> getNext();
    }
    return false;
}

// Inserts an element at the queue's end (tail).

template <class T>
void PriorityQueue<T>::insertElement(T data, int priority) {
    Node<T> *newNode = new Node<T>(data, priority);
    if (queueSize == 0) { //In case there is no elements in the queue
        head = newNode;
        tail = newNode;
        queueSize ++;
        return;
    }
    newNode -> setPrev(tail); //In case of at least one element in the queue
    tail -> setNext(newNode);
    tail = newNode;
    queueSize ++;
}

template <class T>
void PriorityQueue<T>::removeElement() {
    // It is checked IN MAIN if the list has no elements
    queueSize--;
    // First corner case (there is just one element)
    if (queueSize == 0) {
        delete head;
        head = NULL;
        tail = NULL;
        return;
    }
    Node<T> *temp = head;
    int highestPriority = temp -> getPriority();
    while (temp -> getNext() != NULL) { // Finds the element that has the highest priority
        temp = temp -> getNext();
        if (temp -> getPriority() > highestPriority) {
            highestPriority = temp -> getPriority();
        }
    }
    temp = head;
    while (true) { // Finds the first node, starting from head, that has the highest priority
        if (temp -> getPriority() == highestPriority) {
            break;
        }
        temp = temp -> getNext();
    }
    // Second corner case (the highest priority element is in the last position)
    if (temp == tail) {
        temp -> getPrev() -> setNext(NULL);
        tail = temp -> getPrev();
        delete temp;
        return;
    }
    // Third corner case (the highest priority element is in the first position)
    if (temp == head) {
        temp -> getNext() -> setPrev(NULL);
        head = temp -> getNext();
        delete temp;
        return;
    }
    temp -> getPrev() -> setNext(temp -> getNext());
    temp -> getNext() -> setPrev(temp -> getPrev());
    delete temp;
}

template <class T>
void PriorityQueue<T>::print() {
    Node<T> *temp = head;
    cout << "Queue size: " << queueSize << "\n\n";
    while (temp != NULL) {
        cout << "Data: " << temp -> getData() << " \tPriority: " << temp -> getPriority() << "\n";
        temp = temp -> getNext();
    }
}
