#include <iostream>
#include <fstream>


void lerarquivo()
{
    std::ifstream infile;
    std::string nome,linha;
    int i=0;

    std::cout << "Informe o nome do arquivo: ";
    std::getline(std::cin,nome);
    infile.open(nome.c_str());

    if (!infile)
    {
        std::cout << "Nao foi possivel abrir o arquivo" << std::endl;
        return;
    }
    infile.seekg(0,std::ios::end);
    std::cout << "O arquivo tem: " << infile.tellg() << " Bytes" << std::endl;
    infile.seekg(0);

    while (std::getline(infile, linha))
    {
        std::cout << ++i << " " << linha;
        std::cin.get();
    }
    infile.close();
    return;
}

void criararquivo()
{
    std::ifstream infile;
    std::ofstream outfile;
    std::string nome,linha;
    int i=0;

    std::cout << "Informe o nome do arquivo: ";
    std::getline(std::cin,nome);
    infile.open(nome.c_str());

    if (!infile)
    {
        std::cout << "Nao foi possivel abrir o arquivo" << std::endl;
        return;
    }
    infile.seekg(0,std::ios::end);
    std::cout << "O arquivo tem: " << infile.tellg() << " Bytes" << std::endl;
    infile.seekg(0);

    outfile.open("output.txt");

    if (!outfile)
    {
        std::cout << "Nao foi possivel abrir o arquivo" << std::endl;
        return;
    }

    while (std::getline(infile, linha))
    {
        outfile << ++i << " - " << linha << '\n';
    }

    std::cout << "Arquivo salvo com sucesso...";
    outfile.close();
    infile.close();

    return;
}

int main()
{
    std::cout << "Ler Arquivo:" << std::endl;
    lerarquivo();
    std::cout << "Copiar Arquivo: " << std::endl;
    criararquivo();
    return 1;
}
