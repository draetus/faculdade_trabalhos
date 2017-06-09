#include "Familia.h"


Familia::Familia(){}

void Familia::adicionaMembro(Pessoa& membro)
{
    this->pessoas.push_back(&membro);
}

void Familia::mostra()
{
    for (int i=0;i<pessoas.size();i++)
    {
        pessoas[i]->mostra();
    }
}

int Familia::tamanho()
{
    return pessoas.size();
}
