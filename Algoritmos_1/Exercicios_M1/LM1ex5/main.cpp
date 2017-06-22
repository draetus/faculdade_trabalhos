#include <iostream>

using namespace std;

int main()
{
    float percurso,consumo;
    char tipo;

    cout<<"Digite a distancia do percurso em quilometros: ";
    cin>>percurso;
    cout<<"Informe o tipo do carro: ";
    cin>>tipo;
    if(tipo=='A','a')
    {
        consumo = percurso/8;
    }
    else
    {
        if(tipo=='B','b')
        {
            consumo = percurso/9;
        }
        else
        {
            consumo = percurso/12;
        }
    }
    cout<<"Consumo total de gasolina: "<<consumo<<"Litros"<<endl;
    return 0;
}
