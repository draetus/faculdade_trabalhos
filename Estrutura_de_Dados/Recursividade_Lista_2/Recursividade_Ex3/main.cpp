#include <iostream>

using namespace std;

void gerarMatriz(int A[][10], int n, int linha=0)
{
    for (int i=0;i<n;i++)
    {
        A[linha][i] = i+1;
    }
    if (linha < n-1)
    {
        gerarMatriz(A, n, linha+1);
    }
}


int main()
{
    int A[10][10], n;
    do
    {
        cout << "Forneca o tamanho da matriz: ";
        cin >> n;
    }
    while (n<1 || n>10);
    gerarMatriz(A,n);
    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            cout << A[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}
