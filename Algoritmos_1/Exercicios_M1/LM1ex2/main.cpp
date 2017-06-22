#include <iostream>

using namespace std;

int main()
{
    float saldo_medio,credito,credito_juros;
    cout<<"Informe o valor do saldo medio: ";
    cin>>saldo_medio;
    if(saldo_medio<=500)
    {
        credito = 0;
    }
    else
    {
        if(saldo_medio<=1000)
        {
            credito = saldo_medio*0.3;
        }
        else
        {
            if(saldo_medio<=3000)
            {
                credito = saldo_medio*0.4;
            }
            else
            {
                credito = saldo_medio*0.5;
            }
        }
    }
    credito_juros = credito-(credito*0.02);
    cout<<"Valor do credito: "<<credito_juros<<endl;
    return 0;
}
