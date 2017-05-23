#include <iostream>
#include <fstream>
#include <string>

int main()
{
    char letra;
    std::string nome;
    int contChaves=0;
    std::ifstream file;

    std::cout << "\n Nome do arquivo a ser aberto: ";
    std::getline(cin,nome);

    file.open(nome.c_str())

    if (!file)
    {
        std::cout << "Nao foi possivel ler o arquivo";
        return 0;
    }

    while (file.get(letra))
    {
        if (letra=='{')
            {
                contChaves++;
            }
        else
            {
                if (letra=='}')
                {
                    contChaves--;
                }
            }
    }

    if (contChaves==0)
    {
        std::cout << "O numero de chaves esta correto"
    }
    else
    {
        std::cout << "O numero de chaves esta incorreto"
    }
    file.close()
    return 0;
    }
