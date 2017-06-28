#include <iostream>
#include <cstring>
#include "Livro.h"

Livro::Livro(char* ISBN, char* titulo, char* autor, float preco)
{
    std::strcpy(this->ISBN,ISBN);
    std::strcpy(this->titulo,titulo);
    std::strcpy(this->autor,autor);
    this->preco = preco;
}

void Livro::setISBN(char* ISBN){std::strcpy(this->ISBN,ISBN);}
void Livro::settitulo(char* titulo){std::strcpy(this->titulo,titulo);}
void Livro::setautor(char* autor){std::strcpy(this->autor,autor);}
void Livro::setpreco(float preco){this->preco = preco;}
void Livro::setitempedido(ItemPedido *itempedido){this->itempedido = itempedido;}

char* Livro::getISBN(){return this->ISBN;}
char* Livro::gettitulo(){return this->titulo;}
char* Livro::getautor(){return this->autor;}
float Livro::getpreco(){return this->preco;}

void Livro::mostra()
{
    std::cout << "Titulo: " << this->titulo << std::endl;
    std::cout << "ISBN: " << this->ISBN << std::endl;
    std::cout << "Autor: " << this->autor << std::endl;
    std::cout << "Preco: " << this->preco  << " R$" << std::endl;
}

void Livro::grava(std::ofstream &outfile)
{
    outfile.write((char *)this, sizeof(Livro));
}

void Livro::recupera(std::ifstream &infile)
{
    infile.read((char *)this, sizeof(Livro));
}
