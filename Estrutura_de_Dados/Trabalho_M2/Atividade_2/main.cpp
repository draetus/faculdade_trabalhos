#include <iostream>
#include <cstdlib>

#include "PriorityQueue.cpp"

using namespace std;

int main()
{
    const char *clr;
    PriorityQueue<int> pq;
    int option, data, priority;

    if (_WIN32)
        clr = "cls";
    else
        clr = "clear";

    do {

        do {
            cout << "\nChoose an option:\n";
            cout << "1 - Verify element's existence.\n";
            cout << "2 - Insert an element.\n";
            cout << "3 - Remove element.\n";
            cout << "4 - Print queue.\n";
            cout << "0 - Exit program.\n";
            cin >> option;
            system(clr);
        } while (option < 0 || option > 4);

        switch (option) {
        case 1:
            cout << "Enter the data: ";
            cin >> data;
            if (pq.elementExistence(data)) {
                cout << "The element exists.\n";
            }
            else {
                cout << "The element doesn't exist.\n";
            }
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 2:
            cout << "Enter the data: ";
            cin >> data;
            cout << "Enter the priority: ";
            cin >> priority;
            pq.insertElement(data, priority);
            cout << "Element inserted.";
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 3:
            if (pq.isEmpty()) {
                cout << "There are no elements to be deleted.\n";
            } else {
                pq.removeElement();
                cout << "An element was deleted.\n";
            }
            cin.ignore();
            cin.get();
            system(clr);
            break;
        case 4:
            pq.print();
            cin.ignore();
            cin.get();
            system(clr);
        }

    } while (option != 0);
    cout << "Program exited";

}
