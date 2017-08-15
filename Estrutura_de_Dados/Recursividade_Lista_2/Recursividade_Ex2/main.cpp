#include <iostream>

using namespace std;

int contar(char matriz[][10], int n, int linha, int coluna=0)
{

    if (matriz[linha][coluna] == matriz[linha][coluna+1])
    {
        if (coluna == n-2)
            return 1;
        else
            return 1 + contar(matriz, n, linha, coluna+1);
    }
    else
    {
        if (coluna == n-2)
            return 0;
        else
            return contar(matriz, n, linha, coluna+1);
    }
}

int main()
{
    char matriz[10][10];
    int n, linha;
    do
    {
        cout << "Forneça o tamanho da matriz:";
        cin >> n;
    }
    while (n<1 || n>10);

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            cout << "Digite a posição" << i+1 << " " << j+1 << ": ";
            cin >> matriz[i][j];
        }
    }
    do
    {
        cout << "Informe a linha desejada: ";
        cin >> linha;
    }
    while (linha<1 || linha>n);

    cout << contar(matriz, n, linha-1);
    return 0;
}
