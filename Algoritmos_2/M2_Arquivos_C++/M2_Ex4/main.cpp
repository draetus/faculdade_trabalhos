#include <iostream>
#include <fstream>
#include <string>

int main()
{
    std::ifstream sourcefile;
    std::ofstream myfile;
    std::string nome;
    char c;
    int i;

    std::cout << "Digite o arquivo desejado:" << std::endl;
    std::getline(std::cin, nome);

    sourcefile.open(nome.c_str());

    for (i=nome.size()-1;i>0;i--)
    {
        if (nome.at(i) == '.')
        {
            break;
        }
        nome.at(i) = 'x';
    }

    myfile.open(nome.c_str());

    if(!sourcefile || !myfile)
    {
        std::cout << "Nao foi possivel abrir o arquivo" << std::endl;
        return 0;
    }

    while(sourcefile.get(c))
    {
        if (c != '/')
        {
            myfile << c;
        }
        else
        {
            sourcefile.get(c);
            if (c != '/' && c != '*')
            {
                myfile << '/' << c;
            }
            else
            {
                if  (c == '/')
                {
                    while(sourcefile.get() != '\n'){}
                    myfile << '\n';
                }
                else
                {
                    while (sourcefile.get(c))
                    {
                        if (c == '*')
                        {
                            sourcefile.get(c);
                            if (c == '/')
                            {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    return 1;
}
