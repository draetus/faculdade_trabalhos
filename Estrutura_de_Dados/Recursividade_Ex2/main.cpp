#include <iostream>

using namespace std;

int soma(int n)
{
    if (n==1)
    {
        return 1;
    }
    return n+soma(n-1);
}

void somaProcede(int n, int &resultado)
{
    if (n!=0)
    {
        somaProcede(n-1, resultado);
        resultado+=n;
    }
}

int main()
{
    int n,resultado=0;
    cout << "Digite o numero desejado para a soma de 1 a n: ";
    cin >> n;
    cout << "Funcao: " << soma(n) << endl;
    somaProcede(n, resultado);
    cout << "Procedimento: " << resultado << endl;
    return 0;
}
