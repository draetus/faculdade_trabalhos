#include "Pessoa.h"


Pessoa::Pessoa(std::string nome, int idade)
{
    this->nome = nome;
    this->idade = idade;
}


void Pessoa::setnome(std::string nome)
{
    this->nome = nome;
}

void Pessoa::setidade(int idade)
{
    this->idade = idade;
}

std::string Pessoa::getnome()
{
    return nome;
}

int Pessoa::getidade()
{
    return idade;
}

void Pessoa::mostra()
{
    std::cout << "Nome: " << this->nome << std::endl;
    std::cout << "Idade: " << this->idade << std::endl;
}
