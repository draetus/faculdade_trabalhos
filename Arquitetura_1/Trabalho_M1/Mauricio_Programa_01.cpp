// Disciplina: Arquitetura e Organizacao de Computadores
// Atividade: Avaliacao 01 - Programacao em Linguagem de Montagem
// Programa 01
// Grupo: - Mauricio

#include <iostream>

using namespace std;

int main()
{
    int Vetor_A[8], Vetor_B[8], tam, aux, i;

    cout << "Entre com o tamanho dos vetores (max. = 8): ";
    do
    {
        cin >> tam;
        if (tam<1 || tam>8)
        {
            cout << "Entrada invalida!!" << endl;
        }
    }
    while (tam<1 || tam>8);

    for (i=0;i<tam;i++)
    {
        cout << "Vetor_A[" << i << "]: ";
        cin >> Vetor_A[i];
    }

    for (int i=0;i<tam;i++)
    {
        cout << "Vetor_B[" << i << "]: ";
        cin >> Vetor_B[i];
    }

    for (int i=0;i<tam;i++)
    {
        aux = Vetor_A[i];
        Vetor_A[i] = Vetor_B[i];
        Vetor_B[i] = aux;
    }

    for (int i=0;i<tam;i++)
    {
        cout << "Vetor_A[" << i << "]: " << Vetor_A[i] << endl;
    }

    for (int i=0;i<tam;i++)
    {
        cout << "Vetor_B[" << i << "]: " << Vetor_B[i] << endl;
    }
    return 0;
}
