#ifndef CLIENTE_H_INCLUDED
#define CLIENTE_H_INCLUDED

#include <vector>
#include <fstream>
#include "Pedido.h"

class Pedido;

class Cliente{
private:
    int codigo;
    char nome[100],telefone[100],email[100];
    std::vector<Pedido*> pedidos;
public:
    Cliente(int = 0,char* = "", char* = "", char* = "");
    void setcodigo();
    void settelefone();
    void setemail();
    void setnome();
    void addpedido(Pedido*);
    int getcodigo();
    char* gettelefone();
    char* getemail();
    char* getnome();
    Pedido* getpedido();
    void mostra();
    void grava(std::ofstream &);
    void recupera(std::ifstream &);
};

#endif // CLIENTE_H_INCLUDED
