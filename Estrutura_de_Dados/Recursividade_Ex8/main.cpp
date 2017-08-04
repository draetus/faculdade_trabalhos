#include <iostream>
#include <stdio.h>
#include <cstring>

using namespace std;

char* inversor(char* cadeia,int i=0)
{
    if (i<strlen(cadeia))
    {
        int aux = strlen(cadeia) - 1 - i;
        char ch=cadeia[i];
        cadeia = inversor(cadeia,i+1);
        cadeia[aux] = ch;
    }
    return cadeia;
}

int main()
{
    char cadeia[100];
    cout << "Digite a cadeia de caracteres: ";
    gets(cadeia);
    cout << inversor(cadeia);
    return 0;
}
