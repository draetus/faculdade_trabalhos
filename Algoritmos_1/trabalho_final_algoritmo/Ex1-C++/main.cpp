#include <iostream>

int main()
{
    int valorn,i,j,cont;
    do
    {
        std::cout << "Digite o valor de n: ";
        std::cin >> valorn;
    } while ((valorn % 2 == 0) || (valorn > 10));

    int n[valorn][valorn], aux = valorn / 2;

    for (i=0; i<valorn; i++)
    {
        for (j=0; j<valorn; j++)
        {
            n[i][j] = 0;
        }
    }

    n[0][aux] = 1;
    cont = 1;
    i = 0;
    j = aux;

    do
    {
        i -= 1;
        j += 1;
        cont += 1;
        if ((i < 0) || (i > valorn - 1))
        {
            i = valorn - 1;
        }
        if ((j > valorn - 1) || (j < 0))
        {
            j = 0;
        }
        if (n[i][j] != 0)
        {
            i += 2;
            j -= 1;

            if (i > valorn - 1)
            {
                i = (i-valorn);
            }
            if (j < 0)
            {
                j = valorn - 1;
            }
        }
        n[i][j] = cont;
    } while (cont != valorn * valorn);
    for(i=0; i<valorn; i++)
    {
        for (j=0; j<valorn; j++)
        {
            std::cout << n[i][j] << " ";
        }
        std::cout << std::endl;
    }
    return 0;
}
