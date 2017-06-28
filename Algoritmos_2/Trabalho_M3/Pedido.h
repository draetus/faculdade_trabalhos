#ifndef PEDIDO_H_INCLUDED
#define PEDIDO_H_INCLUDED

#include "Cliente.h"
#include "ItemPedido.h"

class Cliente;
class ItemPedido;

class Pedido
{
private:
    int numero;
    char data[100];
    Cliente* cliente;
    std::vector<ItemPedido*> itens;
public:
    Pedido(Cliente&,int = 0,char* = "");
    void setnumero();
    void setdata();
    void additem(ItemPedido*);
    int getnumero();
    char* getdata();
    Cliente* getcliente();
    float calcularpreco();
    void mostra();
};

#endif // PEDIDO_H_INCLUDED
