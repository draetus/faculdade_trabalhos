#include <iostream>
#include <math.h>

using namespace std;

int main()
{
    int i, cont, j;
    float seno, x, vetorx[14], vetorf[14], vetorfinal[14];
    cont = -1;
    cout << "Forneca o valor de x em graus: ";
    cin >> x;
    x = x*3.14/180;
    for (i = 1; i<=30;i=i+2)
    {
        cont = cont + 1;
        vetorx[cont] = pow(x,i);
    }
    cont = -1;
    for (i = 1; i<=30; i=i+2)
    {
        cont = cont + 1;
        vetorf[cont] = 1;
        for (j = 1;j<=i;j++)
        {
            vetorf[cont] = vetorf[cont] * j;
        }
    }
    for (i = 0;i<=14;i=i+2)
    {
        vetorfinal[i] = vetorx[i] / vetorf[i];
    }
    for (i = 1;i<=13;i=i+2)
    {
        vetorfinal[i] = (vetorx[i]) / (-vetorf[i]);
    }
    seno = 0;
    cout << endl;
    for (i=0;i<=14;i++)
    {
        seno = seno + vetorfinal[i];
        cout << "Vetor de posicao " << i+1 << ": " << vetorfinal[i] << endl;
    }
    cout << endl << "Valor do seno: " << seno << endl;
    return 1;
}
