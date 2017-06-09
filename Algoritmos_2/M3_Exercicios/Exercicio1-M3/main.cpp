#include <iostream>
#include "Familia.h"

using namespace std;

int main()
{
    Pessoa alguem("Joao", 19);
    Pessoa outroalguem;
    outroalguem.setidade(25);
    outroalguem.setnome("Marcelo");

    Familia family;
    family.adicionaMembro(alguem);
    family.adicionaMembro(outroalguem);
    family.mostra();
}
