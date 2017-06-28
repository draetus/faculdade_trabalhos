#include <iostream>
#include <cstring>
#include "Livro.h"

Livro::Livro(char* ISBN, char* titulo, char* autor, float preco){
    std::strcpy(this->ISBN,ISBN);
    std::strcpy(this->titulo,titulo);
    std::strcpy(this->autor,autor);
    this->preco = preco;
    this->disponivel = true;
}

void Livro::setISBN(){
    std::cout << "ISBN do Livro: " << std::endl;
    gets(ISBN);
}
void Livro::settitulo(){
    std::cout << "Titudo do Livro: " << std::endl;
    gets(titulo);
}
void Livro::setautor(){
    std::cout << "Autor do Livro: " << std::endl;
    gets(autor);
}
void Livro::setpreco(){
    std::cout << "Preco do Livro: " << std::endl;
    std::cin >> preco;
    std::cin.ignore();
}
void Livro::setitempedido(ItemPedido *itempedido){
    this->itempedido = itempedido;
    this->disponivel = false;
}

char* Livro::getISBN(){
    return ISBN;
}
char* Livro::gettitulo(){
    return titulo;
}
char* Livro::getautor(){
    return autor;
}
float Livro::getpreco(){
    return preco;
}

bool Livro::getdisponivel(){
    return disponivel;
}

void Livro::mostra()
{
    std::cout << "Titulo: " << titulo << std::endl;
    std::cout << "ISBN: " << ISBN << std::endl;
    std::cout << "Autor: " << autor << std::endl;
    std::cout << "Preco: " << preco  << " R$" << std::endl;
}

void Livro::grava(std::ofstream &outfile)
{
    outfile.write((char *)this, sizeof(Livro));
}

void Livro::recupera(std::ifstream &infile)
{
    infile.read((char *)this, sizeof(Livro));
    this->disponivel = true;
}
