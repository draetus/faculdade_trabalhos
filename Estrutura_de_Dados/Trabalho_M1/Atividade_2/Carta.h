#ifndef CARTA_H_INCLUDED
#define CARTA_H_INCLUDED

#include <iostream>

using namespace std;

class Carta {
    int valor;
    string naipe;
public:
    Carta();
    Carta(int, string);
    int getValor();
    string getNaipe();
    friend ostream& operator<<(ostream&,Carta&);
    friend bool operator == (Carta&,Carta&);
};

#endif // CARTA_H_INCLUDED
