#include "ItemPedido.h"
#include <iostream>

ItemPedido::ItemPedido(Pedido &pedido)
{
    this->quantidade = 0;
    this->pedido = &pedido;
    this->pedido->additem(this);
    this->precounitario = 0;
}

int ItemPedido::getquantidade(){
    return quantidade;
}
float ItemPedido::getprecounitario(){
    return precounitario;
}
void ItemPedido::addlivro(Livro &livro){
    this->livros.push_back(&livro);
    livro.setitempedido(this);
    this->precounitario += livro.getpreco();
    this->quantidade++;
}

void ItemPedido::mostra(){
    std::cout << "Quantidade: " << quantidade << std::endl;
    std::cout << "Preco Unitario: " << precounitario  << " R$" << std::endl;
    for (int i=0;i<livros.size();i++){
        std::cout << std::endl << "Livro " << i+1 << std::endl << std::endl;
        livros[i]->mostra();
    }
}
