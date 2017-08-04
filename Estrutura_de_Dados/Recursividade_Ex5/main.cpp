#include <iostream>

using namespace std;

void escrever(int n)
{
    if (n>1)
    {
        escrever(n-1);
    }

    if (n%2==0)
    {
        cout << n*n << " ";
    }
    else
    {
        cout << n << " ";
    }
}


int main()
{
    int n;
    cout << "Forneca quantos termos desejar: ";
    cin >> n;
    escrever(n);
    return 0;
}
