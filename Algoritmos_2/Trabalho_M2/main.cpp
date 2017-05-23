#include <iostream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "Estoque.h"

using namespace std;

int main (){

   Estoque mystock;
   int opcao;

   do{
       cout << "::::::::::::::::::::::::::::::::MENU PRINCIPAL:::::::::::::::::::::::::::::::::" <<endl <<endl;
       cout << "Escolha a opcao desejada: " << endl << endl;
       cout << "(1) - Incluir Produto" << endl;
       cout << "(2) - Consultar" << endl;
       cout << "(3) - Relatorio" << endl;
       cout << "(4) - Gravar" << endl;
       cout << "(5) - Recuperar" << endl;
       cout << "(6) - Sair" << endl;
       do{
           cin >> opcao;
           if(opcao <1 || opcao >6){
              cout << "Opcao invalida! tente novamente!" << endl;
           }
       }while (opcao <1 || opcao>6);

       system("cls");

       switch(opcao){
       case 1:
           int opc;
           do{
              mystock.inclui_produto();
              cout << "1 - Voltar ao menu principal: ";
              cin >> opc;
           }while(opc != 1);
           break;
       case 2:
           do{
              mystock.consulta_produto();
              cout << "1 - Nova consulta, 2 - Voltar ao menu principal: ";
              cin >> opc;
           }while(opc != 2);
           break;

       case 3:
           do{
              mystock.relatorio();
              cout << "1 - Voltar ao menu principal: ";
              cin >> opc;
           }while(opc != 1);
           break;

       case 4:
           mystock.grava();
           break;

       case 5:
           do{
              mystock.recupera();
              cout << "1 - Voltar ao menu principal: ";
              cin >> opc;
           }while(opc != 1);
           break;
       }
       system("cls");
   }while (opcao != 6);
}
