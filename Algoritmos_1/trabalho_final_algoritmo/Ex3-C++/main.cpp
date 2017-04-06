#include <iostream>

void solucao (int m,int n)
{
    float A[m][n], X[n], B[m], aux[m];
    bool result = true;
    int i,j;
    std::cout << "Forneca os valores da matriz A: " << std::endl;
    for (i=0; i<m; i++)
    {
        for (j=0; j<n; j++)
        {
            std::cout << "Posicao " << i+1 << " " << j+1 << ": ";
            std::cin >> A[i][j];
        }
    }
    std::cout << "Forneca os valores da matriz B(resultados):" << std::endl;
    for (i=0; i<m; i++)
    {
        std::cout << "Posicao " << i+1 << " ";
        std::cin >> B[i];
    }
    std::cout << "Forneca os valores de X: " << std::endl;
    for (i=0; i<n; i++)
    {
        std::cout << "X" << i+1 << ": ";
        std::cin >> X[i];
    }
    for (i=0; i<m; i++)
    {
        aux [i] = 0;
        for (j=0; j<n; j++)
        {
            aux[i] += A[i][j] * X[j];
        }
    }
    for (i=0; i<m; i++)
    {
        if (aux[i] != B[i])
        {
            result = false;
            break;
        }
    }
    if (result)
    {
        std::cout << "X e a solucao";
    }
    else
    {
        std::cout << "X nao e a solucao";
    }
}

int lernum()
{
    int valor;
    do
    {
        std::cout << "Valor: ";
        std::cin >> valor;
    } while (valor < 0);
    return valor;
}

int main()
{
    int m,n;
    m = lernum();
    n = lernum();
    solucao(m,n);
}
