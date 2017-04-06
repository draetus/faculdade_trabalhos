#include <iostream>
#include <stdio.h>

void funcao(int &a, int &b)
{
    int x = a, y = b;
    a = x / y;
    b = x % y;
}

int main()
{
    int a,b;
    std::cout << "Forneca o valor a: ";
    std::cin >> a;
    std::cout << "Forneca o valor b: ";
    std::cin >> b;
    funcao(a,b);
    std::cout << "Valor da divisao: " << a << std::endl;
    std::cout << "Valor do resto: " << b << std::endl;
}
