#ifndef FAMILIA_H_INCLUDED
#define FAMILIA_H_INCLUDED

#include "Pessoa.h"
#include <vector>

class Familia
{
private:
    std::vector<Pessoa*> pessoas;
public:
    Familia();
    void adicionaMembro(Pessoa&);
    void mostra();
    int tamanho();
};


#endif // FAMILIA_H_INCLUDED
