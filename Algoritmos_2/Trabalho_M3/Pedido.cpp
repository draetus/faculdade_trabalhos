#include "Pedido.h"
#include <iostream>
#include <cstring>

Pedido::Pedido(Cliente &cliente, int numero, char *data)
{
    this->cliente = &cliente;
    this->numero = numero;
    std::strcpy(this->data,data);
    this->cliente->addpedido(this);
}

void Pedido::setnumero(int numero){this->numero=numero;}
void Pedido::setdata(char *data){std::strcpy(this->data,data);}
void Pedido::additem(ItemPedido *item){this->itens.push_back(item);}

int Pedido::getnumero(){return this->numero;}
char* Pedido::getdata(){return this->data;}
Cliente* Pedido::getcliente(){return this->cliente;}

float Pedido::calcularpreco()
{
    float result=0;
    for (int i=0;i<this->itens.size();i++)
    {
        result += this->itens[i]->getprecounitario();
    }
    return result;
}

void Pedido::mostra()
{
    std::cout << "Cliente Relacionado: " << this->cliente->getnome() << std::endl;
    std::cout << "Numero: " << this->numero << std::endl;
    std::cout << "Data: " << this->data << std::endl;
    std::cout << "Preco Total: " << this->calcularpreco() << " R$" << std::endl << std::endl;
    for (int i=0;i<this->itens.size();i++)
    {
        std::cout << std::endl << "---Item de Pedido " << i+1 << "---" << std::endl;
        this->itens[i]->mostra();
    }
}
