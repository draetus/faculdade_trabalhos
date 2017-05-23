#include <iostream>
#include <fstream>

int main()
{
    std::ifstream arquivo;
    std::string linha, nome;
    int cont=0;

    std::cout << "Escreva o nome do arquivo que deseja abrir: ";
    std::getline(std::cin, nome);
    arquivo.open(nome.c_str());

    if (!arquivo)
    {
        std::cout << "Nao foi possivel abrir o arquivo!";
        return 0;
    }

    arquivo.seekg(0, std::ios::beg);
    while (std::getline(arquivo,linha))
    {
        cont++;
        std::cout << linha << std::endl;
                if (cont%20==0)
        {
            std::cin.get();
        }
    }
}
