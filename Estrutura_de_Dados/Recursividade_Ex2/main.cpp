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
    int x=3,resultado;
    cout << soma(x) << endl;
    somaProcede(x, resultado);
    cout << resultado << endl;
    return 0;
}
