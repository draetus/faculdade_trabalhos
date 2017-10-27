#include "Deque.h"

Deque::Deque() {
    elementsQuantity = 0;
    right = 0;
    left = 1;
}

void Deque::pushRight(int data) {
    right++;
    if (right == dequeSize) {
        right = 0;
    }
    elements[right] = data;
    elementsQuantity++;
}

void Deque::pushLeft(int data) {
    left--;
    if (left == -1) {
        left = dequeSize - 1;
    }
    elements[left] = data;
    elementsQuantity++;
}

void Deque::popRight() {
    right--;
    if (right == -1) {
        right = dequeSize - 1;
    }
    elementsQuantity--;
}

void Deque::popLeft() {
    left++;
    if (left == dequeSize) {
        left = 0;
    }
    elementsQuantity--;
}

bool Deque::isEmpty() {
    return elementsQuantity == 0;
}

bool Deque::isFull() {
    return elementsQuantity == dequeSize;
}

bool Deque::elementExistence(int data) {
    int j = left;
    for (int i = 0; i < elementsQuantity; i++) {
        if (elements[j] == data) {
            return true;
        }
        j++;
        if (j == dequeSize) {
            j = 0;
        }
    }
    return false;
}

int Deque::getElementsQuantity() {
    return elementsQuantity;
}

int Deque::getRight() {
    return elements[right];
}

int Deque::getLeft() {
    return elements[left];
}

void Deque::print() {
    int j = left;
    cout << "Number of elements: " << elementsQuantity << endl;
    for (int i = 0; i < elementsQuantity; i++) {
        cout << elements[j] << " ";
        j++;
        if (j == dequeSize) {
            j = 0;
        }
    }
    cout << endl;
}
