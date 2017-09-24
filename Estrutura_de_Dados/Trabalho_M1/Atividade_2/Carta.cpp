#include "Carta.h"

bool operator == (Carta &carta1, Carta &carta2) {
    return carta1.getValor() == carta2.getValor();
}

ostream& operator << (ostream &out, Carta &carta)
{
    cout << "\t" << carta.getValor() << "\t" << carta.getNaipe() << endl;
    return out;
}

Carta::Carta(){}

Carta::Carta(int valor, string naipe) {
    this->valor = valor;
    this->naipe = naipe;
}

int Carta::getValor() {
    return valor;
}

string Carta::getNaipe()
{
    return naipe;
}
