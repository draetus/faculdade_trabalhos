#include "ListaEstatica.h"
#include <vector>
#include <iostream>

using namespace std;

int main()
{
    vector<ListaEstatica *> listas;
    int opcao, opcao2;
    do
    {
        cout << "Escolhe uma opcao: " << endl;
        cout << "1 - Criar Lista" << endl;
        cout << "2 - Remover Lista" << endl;
        cout << "3 - Mostrar Listas" << endl;
        cout << "4 - Inserir Elemento" << endl;
        cout << "5 - Remover Elemento" << endl;
        cout << "6 - Sair" << endl;
        do
        {
            cin >> opcao;
        }
        while (opcao>6||opcao<1);

        switch(opcao)
        {
        case 1:
            {
                listas.push_back(new ListaEstatica());
                break;
            }

        case 2:
                cout << "DIGITE 0 PARA VOLTAR AO MENU PRINCIPAL" << endl;
                cout << "Qual lista você deseja destruir?" << endl;
                for (int i=0;i<listas.size();i++)
                {
                    cout << "Lista " << i+1 << ": " << endl;
                    listas.at(i)->mostraLista();
                }
                do
                {
                    cin >> opcao2;
                }
                while (opcao2<0||opcao2>listas.size());
                if (opcao2==0)
                {
                    break;
                }
                delete listas.at(opcao2-1);
                listas.erase(listas.begin()+opcao2-1);
                break;

        case 3:
            {
                cout << "DIGITE 0 PARA VOLTAR AO MENU PRINCIPAL" << endl;
                cout << "Mostrando Listas..." << endl;
                for (int i=0;i<listas.size();i++)
                {
                    cout << "Lista " << i+1 << ": " << endl;
                    listas.at(i)->mostraLista();
                    cout << endl;
                }
                cin.ignore();
                cin.get();
                break;
            }

        case 4:
            {
                char elemento;
                cout << "DIGITE 0 PARA VOLTAR AO MENU PRINCIPAL" << endl;
                cout << "Qual lista você deseja adicionar elemento?" << endl;
                for (int i=0;i<listas.size();i++)
                {
                    cout << "Lista " << i+1 << ": " << endl;
                    listas.at(i)->mostraLista();
                }
                do
                {
                    cin >> opcao2;
                }
                while (opcao2<0||opcao2>listas.size());
                if (opcao2==0)
                {
                    break;
                }
                cout << "Digite o elemento desejado: ";
                cin >> elemento;
                listas.at(opcao2-1)->inserirElemento(elemento);
                break;
            }

        case 5:
            {
                char elemento;
                cout << "DIGITE 0 PARA VOLTAR AO MENU PRINCIPAL" << endl;
                cout << "Qual lista você deseja remover elemento?" << endl;
                for (int i=0;i<listas.size();i++)
                {
                    cout << "Lista " << i+1 << ": " << endl;
                    listas.at(i)->mostraLista();
                }
                do
                {
                    cin >> opcao2;
                }
                while (opcao2<0||opcao2>listas.size());
                if (opcao2==0)
                {
                    break;
                }
                cout << "Lista:";
                listas.at(opcao2-1)->mostraLista();
                cout << "Escolha o elemento desejado para remover: ";
                cin >> elemento;
                listas.at(opcao2-1)->retirarElemento(elemento);
                break;
            }

        }
    }
    while (opcao != 6);
    return 0;
}
