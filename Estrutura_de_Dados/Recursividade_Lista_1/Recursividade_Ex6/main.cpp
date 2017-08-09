#include <iostream>
#include <math.h>

using namespace std;

int calcpol(int n,int x, int *a)
{
    if (n==0)
    {
        return a[n]*pow(x,n);
    }
    return calcpol(n-1,x,a) + a[n]*pow(x,n);
}


int main()
{
    int x,n=1;
    cout << "Digite o grau do polinomio: ";
    cin >> n;
    cout << "Forneca o valor de X: ";
    cin >> x;
    int a[n+1];
    cout << "Forneça os valores dos membros do polinomio: " << endl;
    for (int i=0;i<n+1;i++)
    {
        cout << "Posicao " << i+1 << ": ";
        cin >> a[i];
    }
    cout << "O valor do polinomio é: " << calcpol(n,x,a);
    return 0;
}
