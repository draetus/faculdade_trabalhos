#include <iostream>

using namespace std;

int main()
{
    int i, n;
    float b[9], soma;
    soma = 0;
    do
    {
        cout << "Forneca o tamanho do vetor(em um numero par): ";
        cin >> n;
    }
    while (n % 2 != 0);
    cout << "Forneça os valores a seguir: ";
    for (i=0;i<=(n-1);i++)
    {
        cout << i+1 << " Termo: ";
        cin >> b[i];
    }
     for (i=0;i<=(n/2-1);i++)
     {
         soma = b[i] - b[n-1-i] + soma;
     }
     cout << endl << "Soma dos termos: " << soma << endl;
    return 1;
}
