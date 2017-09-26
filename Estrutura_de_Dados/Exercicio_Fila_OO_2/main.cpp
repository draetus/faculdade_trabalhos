#include <iostream>
#include "Fila.cpp"

using namespace std;

int main()
{
    Fila<int> fila1, fila2;
    fila1.insere(10);
    fila1.insere(15);
    fila2.insere(10);
    fila2.insere(15);
    cout << fila1.comparaFila(fila2);
    return 0;
}
