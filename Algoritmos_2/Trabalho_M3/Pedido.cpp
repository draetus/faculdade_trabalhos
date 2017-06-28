#include "Pedido.h"
#include <iostream>
#include <cstring>

Pedido::Pedido(Cliente &cliente, int numero, char *data){
    this->cliente = &cliente;
    this->numero = numero;
    std::strcpy(this->data,data);
    this->cliente->addpedido(this);
}

void Pedido::setnumero(){
    std::cout << "Numero: " << std::endl;
    std::cin >> numero;
    std::cin.ignore();
}
void Pedido::setdata(){
    std::cout << "Data: " << std::endl;
    gets(data);
}
void Pedido::additem(ItemPedido *item){
    itens.push_back(item);
}

int Pedido::getnumero(){
    return numero;
}
char* Pedido::getdata(){
    return data;
}
Cliente* Pedido::getcliente(){
    return cliente;
}

float Pedido::calcularpreco()
{
    float result=0;
    for (int i=0;i<itens.size();i++)
    {
        result += itens[i]->getprecounitario();
    }
    return result;
}

void Pedido::mostra()
{
    std::cout << "Cliente Relacionado: " << cliente->getnome() << std::endl;
    std::cout << "Numero: " << numero << std::endl;
    std::cout << "Data: " << data << std::endl;
    std::cout << "Preco Total: " << calcularpreco() << " R$" << std::endl << std::endl;
    for (int i=0;i<itens.size();i++)
    {
        std::cout << std::endl << "---Item de Pedido " << i+1 << "---" << std::endl;
        itens[i]->mostra();
    }
}
