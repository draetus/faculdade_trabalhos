#include <iostream>
#include <cstring>
#include <stdio.h>
#include "Cliente.h"

Cliente::Cliente(int codigo, char *telefone, char *email, char *nome){
    this->codigo = codigo;
    std::strcpy(this->telefone,telefone);
    std::strcpy(this->email,email);
    std::strcpy(this->nome,nome);
}

void Cliente::setcodigo(){
    std::cout << "Codigo do Cliente: " << std::endl;
    std::cin >> codigo;
    std::cin.ignore();
}
void Cliente::settelefone(){
    std::cout << "Telefone do Cliente: " << std::endl;
    gets(telefone);
}
void Cliente::setemail(){
    std::cout << "Email do Cliente: " << std::endl;
    gets(email);
}
void Cliente::setnome(){
    std::cout << "Nome do Cliente: " << std::endl;
    gets(nome);
}
void Cliente::addpedido(Pedido* pedido){
    this->pedidos.push_back(pedido);
}

int Cliente::getcodigo(){
    return codigo;
}
char* Cliente::gettelefone(){
    return telefone;
}
char* Cliente::getemail(){
    return email;
}
char* Cliente::getnome(){
    return nome;
}

void Cliente::mostra(){
    std::cout << "Nome: " << nome << std::endl;
    std::cout << "Codigo: " << codigo << std::endl;
    std::cout << "Email: " << email << std::endl;
    std::cout << "Telefone: " << telefone << std::endl << std::endl << std::endl;
    for (int i=0;i<pedidos.size();i++)
    {
        std::cout << "------Pedido " << i+1 << "------" << std::endl << std::endl;
        pedidos[i]->mostra();
    }
    std::cout << "*____________________________________*" << std::endl;
}
