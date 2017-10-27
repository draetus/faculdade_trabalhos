#include <iostream>
#include <cstdlib>

#include "Deque.h"

using namespace std;

int main()
{
    const char *clr;
    Deque myDeque;
    int option, data;

    if (WIN32)
        clr = "cls";
    else
        clr = "clear";

    do {

        do {
            cout << "\nChoose an option:\n";
            cout << "1 - Insert an element at right.\n";
            cout << "2 - Insert an element at left.\n";
            cout << "3 - Remove an element from the right.\n";
            cout << "4 - Remove an element from the left.\n";
            cout << "5 - Check if the deque is empty.\n";
            cout << "6 - Check if the deque is full.\n";
            cout << "7 - Check an element existence.\n";
            cout << "8 - Get elements' quantity.\n";
            cout << "9 - Get rightmost element.\n";
            cout << "10 - Get leftmost element.\n";
            cout << "11 - Print deque.\n";
            cout << "0 - Exit program.\n";
            cin >> option;
            system(clr);
        } while (option < 0 || option > 11);

        cout << endl;

        switch (option) {
        case 1:
            if (myDeque.isFull()) {
                cout << "Deque is full.\n";
            } else {
                cout << "Enter the data: ";
                cin >> data;
                myDeque.pushRight(data);
                cout << "Data inserted in the right";
            }
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 2:
            if (myDeque.isFull()) {
                cout << "Deque is full.\n";
            } else {
                cout << "Enter the data: ";
                cin >> data;
                myDeque.pushLeft(data);
                cout << "Data inserted in the left";
            }
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 3:
            if (myDeque.isEmpty()) {
                cout << "There are no elements to be removed.\n";
            } else {
                myDeque.popRight();
                cout << "Element removed from the right";
            }
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 4:
            if (myDeque.isEmpty()) {
                cout << "There are no elements to be removed.\n";
            } else {
                myDeque.popLeft();
                cout << "Element removed from the left";
            }
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 5:
            if (myDeque.isEmpty()) {
                cout << "Deque is empty.\n";
            } else {
                cout << "Deque is not empty.\n";
            }
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 6:
            if (myDeque.isFull()) {
                cout << "Deque is full.\n";
            } else {
                cout << "Deque is not full.\n";
            }
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 7:
            cout << "Enter the data: ";
            cin >> data;
            if (myDeque.elementExistence(data)) {
                cout << "The element exists.\n";
            } else {
                cout << "The element does not exist.\n";
            }
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 8:
            cout << "Elements quantity: " << myDeque.getElementsQuantity() << endl;
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 9:
            cout << "Rightmost element: " << myDeque.getRight() << endl;
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 10:
            cout << "Leftmost element: " << myDeque.getLeft() << endl;
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 11:
            myDeque.print();
            cin.ignore();
            cin.get();
            system(clr);
            break;
        }

    } while (option != 0);
    cout << "Program exited";

}
