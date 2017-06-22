#include <iostream>

using namespace std;

int main()
{
    int numero;
    cout<< "Informe um numero inteiro entre 1000 e 9999: ";
    cin>>numero;
    numero = numero/100;
    if((numero<10)or(numero>99))
    {
        cout<<"Numero invalido."<<endl;
    }
    else
    {
        if(numero%4==0)
        {
            cout<<"Eh multiplo de 4"<<endl;
        }
        else
        {
            cout<<"Nao eh multiplo de 4"<<endl;
        }
    }
    return 0;
}
