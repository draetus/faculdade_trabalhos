#include <iostream>

void escrever (int n)
{
    switch(n)
    {
        case 0:
            std::cout << "Zero" << std::endl;
            break;
        case 1:
            std::cout << "Um" << std::endl;
            break;
        case 2:
            std::cout << "Dois" << std::endl;
            break;
        case 3:
            std::cout << "Tres" << std::endl;
            break;
        case 4:
            std::cout << "Quatro" << std::endl;
            break;
        case 5:
            std::cout << "Cinco" << std::endl;
            break;
        case 6:
            std::cout << "Seis" << std::endl;
            break;
        case 7:
            std::cout << "Sete" << std::endl;
            break;
        case 8:
            std::cout << "Oito" << std::endl;
            break;
        case 9:
            std::cout << "Nove" << std::endl;
            break;
        case 10:
            std::cout << "Dez" << std::endl;
            break;
        default:
            std::cout << "Numero Invalido" << std::endl;
    }
}

int main()
{
    int n;

    std::cout << "Digite um numero de 1 a 10: ";
    std::cin >> n;
    escrever(n);
}
