#include <iostream>

using namespace std;

bool conferir(int *X, int *Y,int n)
{
    n--;
    if (n == 0)
    {
        return X[n]==Y[n];
    }
    else
    {
        if (X[n]==Y[n])
        {
            return true*conferir(X,Y,n);
        }
        else
        {
            return false;
        }
    }
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
