#include <iostream>

using namespace std;

int main()
{
    char opcao_comida,opcao_bebida,opcao_sobremesa;
    string nome_comida,nome_bebida,nome_sobremesa;
    float preco_comida,preco_bebida,preco_sobremesa,preco_total;
    cout<<"Informe o pedido de comida: ";
    cin>>opcao_comida;
    cout<<"Informe o pedido de bebida: ";
    cin>>opcao_bebida;
    cout<<"Informe o pedido de sobremesa: ";
    cin>>opcao_sobremesa;
    if(((opcao_comida == '1')or(opcao_comida == '2')or(opcao_comida == '3')or(opcao_comida == '4'))and((opcao_bebida == '5')or(opcao_bebida == '6'))and((opcao_sobremesa == '7')or(opcao_sobremesa == '8')or(opcao_sobremesa == '9')))
    {
        switch(opcao_comida)
        {
    case '1' :
        nome_comida = "Hamburguer";
        preco_comida = 4.5;
        break;
    case '2' :
        nome_comida = "Cheeseburguer";
        preco_comida = 5.5;
        break;
    case '3' :
        nome_comida = "Cachorro Quente";
        preco_comida = 4.0;
        break;
    case '4' :
        nome_comida = "Sanduiche";
        preco_comida = 3.5;
        break;
        }
        switch(opcao_bebida)
        {
    case '5' :
        nome_bebida = "Refrigerante";
        preco_bebida = 1.0;
        break;
    case '6' :
        nome_bebida = "Suco de laranja";
        preco_bebida = 2.0;
        break;
        }
        switch(opcao_sobremesa)
        {
    case '7' :
        nome_sobremesa="Milk shake";
        preco_sobremesa = 1.5;
        break;
    case '8' :
        nome_sobremesa="Sundae";
        preco_sobremesa = 3.0;
        break;
    case '9' :
        nome_sobremesa ="Casquinha";
        preco_sobremesa = 1.0;
        break;
        }
        preco_total = preco_bebida+preco_comida+preco_sobremesa;
        cout<<endl<<nome_comida<<": "<<preco_comida<<"R$"<<endl;
        cout<<nome_bebida<<": "<<preco_bebida<<"R$"<<endl;
        cout<<nome_sobremesa<<": "<<preco_sobremesa<<"R$"<<endl;
        cout<<endl<<"Preco total a pagar: "<<preco_total<<"R$"<<endl;
    }
    else
    {
        cout<<"Pedido Invalido";
    }
    return 0;
}
