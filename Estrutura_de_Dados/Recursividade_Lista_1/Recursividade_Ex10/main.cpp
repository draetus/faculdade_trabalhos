#include <iostream>

using namespace std;

bool conferir(int *X, int *Y,int n)
{
    if (n==1)
        return X[0]==Y[0];
    else
        return (X[n-1]==Y[n-1])&& conferir(X,Y,n-1);
}

int main()
{
    int X[10],Y[10],n;
    cout << "Digite o tamanho do vetor: ";
    cin >> n;
    cout << "Informe os valores do vetor X:" << endl;
    for (int i=0;i<n;i++)
    {
        cout << "Posicao" << i+1 << ": ";
        cin >> X[i];
    }
    cout << "Informe os valores do vetor Y:" << endl;
    for (int i=0;i<n;i++)
    {
        cout << "Posicao" << i+1 << ": ";
        cin >> Y[i];
    }
    if (conferir(X,Y,n))
    {
        cout << "Os vetores sao iguais!" << endl;
    }
    else
    {
        cout << "Os vetores sao diferentes!" << endl;
    }
    return 0;
}
