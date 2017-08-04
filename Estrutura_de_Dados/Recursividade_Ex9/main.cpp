#include <iostream>

using namespace std;

void verificar(int *X, int y, int n, int i=0)
{
    if (X[i]==y)
    {
        cout << "Valor encontrado" << endl;
    }
    else
    {
        if (i<n-1)
        {
            verificar(X,y,n,i+1);
        }
        else
        {
            cout << "Valor nao encontrado";
        }
    }
}


int main()
{
    int n,y,X[10];
    do
    {
        cout << "Forneca o tamanho do vetor: ";
        cin >> n;
    }
    while (n<1 || n>10);

    cout << "Forneca os valores do vetor" << endl;
    for (int i=0;i<n;i++)
    {
        cout << "Posicao" << i+1 << ": ";
        cin >> X[i];
    }
    cout << "Qual numero deseja verificar: ";
    cin >> y;
    verificar(X,y,n);
    return 0;
}
