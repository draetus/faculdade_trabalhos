#ifndef ITEMPEDIDO_H_INCLUDED
#define ITEMPEDIDO_H_INCLUDED

#include <vector>
#include "Pedido.h"
#include "Livro.h"

class Pedido;
class Livro;

class ItemPedido
{
private:
    float precounitario;
    int quantidade;
    Pedido* pedido;
    std::vector<Livro*> livros;
public:
    ItemPedido(Pedido&);
    int getquantidade();
    float getprecounitario();
    void addlivro(Livro&);
    void mostra();
};

#endif // ITEMPEDIDO_H_INCLUDED
