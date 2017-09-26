#include <iostream>
#include "Fila.h"

using namespace std;

template<class T>
Fila<T>::Fila ()
{
    numeroElementos = 0;
    inicio = tamanho - 1;
    fim = tamanho - 1;
}

template<class T>
Fila<T>::~Fila ()
{
    numeroElementos = 0;
    inicio = tamanho - 1;
    fim = tamanho - 1;
}

template<class T>
bool Fila<T>::ehVazia()
{
    return numeroDeElementos() == 0;
}

template<class T>
bool Fila<T>::temEspaco()
{
    return numeroDeElementos() != tamanho;
}

template<class T>
int Fila<T>::numeroDeElementos()
{
    return numeroElementos;
}

template<class T>
bool Fila<T>::existeElemento(T elemento)
{
    int contador = 1;
    int posicao = inicio;
    while (contador <= numeroDeElementos())
    {
        posicao++;
        if (posicao > (tamanho - 1))
            posicao = 0;
        if (elementos[posicao] == elemento)
            return true;
        contador++;
    }
    return false;
}

template<class T>
bool Fila<T>::existePosicao(int posicao)
{
    return ((posicao >= 1) && (posicao <= numeroDeElementos()));
}

template<class T>
T Fila<T>::umElemento(int posicao)
{
    if ((inicio + posicao) <= (tamanho - 1))
        return elementos[inicio + posicao];
    else
        return elementos[posicao - tamanho + inicio];
}

template<class T>
int Fila<T>::primeiro()
{
    if (inicio < (tamanho - 1))
        return elementos[inicio + 1];
    else
        return elementos[0];
}

template<class T>
int Fila<T>::ultimo()
{
    return elementos[fim];
}

template<class T>
int Fila<T>::posicao(T elemento)
{
    int contador = 1;
    int posicao = inicio;
    while (contador <= numeroDeElementos())
    {
        posicao++;
        if (posicao > (tamanho - 1))
            posicao = 0;
        if (elementos[posicao] == elemento)
            return contador;
        contador++;
    }
}

template<class T>
void Fila<T>::insere(T elemento)
{
    fim++;
    if (fim > (tamanho - 1))
        fim = 0;
    elementos[fim] = elemento;
    numeroElementos++;
}

template<class T>
void Fila<T>::retira()
{
    inicio++;
    if (inicio > (tamanho - 1))
        inicio = 0;
    numeroElementos--;
}

template<class T>
void Fila<T>::mostra()
{
    int contador = 1;
    int posicao = inicio;
    while (contador <= numeroDeElementos())
    {
        posicao++;
        if (posicao > (tamanho - 1))
            posicao = 0;
        cout << elementos[posicao] << " ";
        contador++;
    }
}

template<class T>
bool Fila<T>::comparaFila(Fila<T> &fila)
{
    if (this->numeroElementos == 0 || fila.ehVazia())
    {
        return false;
    }

    bool eIgual;
    for(int i=1;i<=this->numeroElementos;i++)
    {
        eIgual = false;
        for (int j=1;j<=fila.numeroDeElementos();j++)
        {
            if (this->umElemento(i) == fila.umElemento(j))
            {
                eIgual = true;
                break;
            }
        }
        if (!eIgual)
        {
            return false;
        }
    }
    return true;
}
