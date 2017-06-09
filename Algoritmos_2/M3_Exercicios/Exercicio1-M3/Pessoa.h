#ifndef PESSOA_H_INCLUDED
#define PESSOA_H_INCLUDED

#include<iostream>

class Pessoa
{
private:
    std::string nome;
    int idade;
public:
    Pessoa(std::string="", int=0);
    void setnome(std::string);
    void setidade(int);
    std::string getnome();
    int getidade();
    void mostra();
};

#endif // PESSOA_H_INCLUDED
