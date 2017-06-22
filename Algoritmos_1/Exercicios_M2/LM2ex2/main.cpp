#include <iostream>

using namespace std;

int main()
{
    int n, cont, i, cont2, quantrep[99];
    float vetora[99],vetorb[99],rep[99];
    cont = -1;
    cont2 = -1;
    do
    {
        cout << "Informe o valor de n: ";
        cin >> n;
    }
    while (n > 100 || n < 0);
    cout << "Informe os valores do vetor de forma crescente: " << endl;
    do
    {
        cont = cont + 1;
        quantrep[cont] = 0;
        cout << cont+1 << " Vetor: ";
        cin >> vetora[cont];
        if (cont > 0)
        {
            if (vetora[cont] < vetora[cont-1])
            {
                cout << "Valor Invalido, Escreva de forma crescente" << endl;
                cont = cont -1;
            }
            else
            {
                if (vetora[cont] == vetora[cont-1])
                {
                    if (cont > 1)
                    {
                        if (vetora[cont-1] > vetora[cont-2])
                        {
                            cont2 = cont2 + 1;
                            rep[cont2] = vetora[cont];
                            quantrep[cont2] = quantrep[cont2] + 1;
                        }
                        else
                        {
                            quantrep[cont2] = quantrep[cont2] + 1;
                        }
                    }
                    else
                    {
                        cont2 = cont2 + 1;
                        rep[cont2] = vetora[cont];
                        quantrep[cont2] = quantrep[cont2] + 1;
                    }
                }
            }
        }
    }
    while (cont != (n-1));
    cout << endl;
    for (i=0;i<=cont2;i++)
    {
        cout << "Numero: " << rep[i] << " Repetido " << quantrep[i] << " Vezes" << endl;
    }
    vetorb[0] = vetora[0];
    cont = 0;
    for (i=1;i<=(n-1);i++)
    {
        if (vetora[i] != vetora[i-1])
        {
            cont = cont + 1;
            vetorb[cont] = vetora[i];
        }
    }
    cout << endl << "Vetor organizado sem elementos repetidos" << endl;
    for (i=0;i<=cont;i++)
    {
        cout << i+1 << " Termo: " << vetorb[i] << endl;
    }
    return 1;
}
