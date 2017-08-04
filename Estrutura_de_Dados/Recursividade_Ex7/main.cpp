#include <iostream>

using namespace std;

int calcProdEsc(int X[10],int Y[10],int n)
{
    n--;
    if (n==0)
    {
        return X[n]*Y[n];
    }
    return calcProdEsc(X,Y,n) + X[n]*Y[n];
}


int main()
{
    int n,X[10],Y[10];
    do
    {
        cout << "Forneça o tamanho dos vetores: ";
        cin >> n;
    }
    while(n<1 || n>10);
    cout << endl << "Forneça valores do vetor X" << endl;
    for (int i=0;i<n;i++)
    {
        cout << "Posicao " << i+1 << ": ";
        cin >> X[i];
    }
    cout << endl << "Forneça os valores do vetor Y: " << endl;
    for (int i=0;i<n;i++)
    {
        cout << "Posicao " << i+1 << ": ";
        cin >> Y[i];
    }
    cout << "O produto escalar dos vetores é: " << calcProdEsc(X,Y,n);
    return 0;
}
