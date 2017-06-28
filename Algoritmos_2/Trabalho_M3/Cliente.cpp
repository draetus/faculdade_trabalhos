#include <iostream>
#include <cstring>
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

void Cliente::grava(std::ofstream &outfile){
    int totalsize=pedidos.size();
    outfile.write((char *)&codigo, sizeof(codigo));
    outfile.write((char *)&nome, sizeof(nome));
    outfile.write((char *)&telefone, sizeof(telefone));
    outfile.write((char *)&email, sizeof(email));
    /*outfile.write((char *)&totalsize, sizeof(totalsize));
    for (int i=0;i<totalsize;i++)
    {
        outfile.write((char *)&pedidos[i], sizeof(pedidos[i]));
    }*/
}

void Cliente::recupera(std::ifstream &infile){
    int totalsize;
    Pedido* aux;
    infile.read((char *)&codigo, sizeof(codigo));
    infile.read((char *)&nome, sizeof(nome));
    infile.read((char *)&telefone, sizeof(telefone));
    infile.read((char *)&email, sizeof(email));
    /*infile.read((char *)&totalsize, sizeof(totalsize));
    for (int i=0;i<totalsize;i++)
    {
        infile.read((char *)&aux, sizeof(aux));
        this->addpedido(aux);
    }*/
    pedidos.clear();
}
