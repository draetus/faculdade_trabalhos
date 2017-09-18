// Disciplina: Arquitetura e Organizacao de Computadores
// Atividade: Avaliacao 01 - Programacao em Linguagem de Montagem
// Programa 01
// Grupo: - Mauricio
#include <iostream>

using namespace std;

int main()
{
    int presenca[16][32];           //Matriz simbolizando presença dos alunos
    int aula;                       //Dia que será escolhido pelo usuario
    int aluno;                      //Aluno que será escolhido pelo usuario
    int registro;                   //Tipo de registro escolhido pelo usuario; presença = 1, ausência = 0
    while(true)
    {
        do                          //Le qual aula o usuario deseja
        {
            cout << "Entre com o numero da aula (de 0 a 15): ";
            cin >> aula;
        }
        while (aula < 0 || aula> 15);

        do                          //Le qual aluno o usuario deseja
        {
            cout << "Entre com o ńumero do aluno (de 0 a 31): ";
            cin >> aluno;
        }
        while(aluno < 0 || aluno > 31);

        do                          //Le o tipo de registro escolhido
        {
            cout << "Entre com o tipo do registro (presenca = 1;ausencia = 0): ";
            cin >> registro;
        }
        while (registro < 0 || registro > 1);

        presenca[aula][aluno] = registro; //Atribui Falta=0 ou Presença=1 para o aluno na aula escolhida
    }
    return 0;
}
