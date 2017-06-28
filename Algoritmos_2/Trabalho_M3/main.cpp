#include <iostream>
#include <fstream>
#include "Cliente.h"
#include "Pedido.h"
#include "Livro.h"
#include "ItemPedido.h"
#include <stdlib.h>
#include <stdio.h>
#include <fstream>



int main(){
  int opc, opcao;
  std::vector<Cliente> clientes;
  std::vector<Pedido> pedidos;
  std::vector<ItemPedido> itempedidos;
  std::vector<Livro> livros;


  do{
      std::cout << "Bem - vindo ao sistema! O que deseja fazer?" << std::endl << std::endl;
      std::cout << "1 -  Cadastrar Cliente" << std::endl;
      std::cout << "2 -  Cadastrar Livro" << std::endl;
      std::cout << "3 -  Novo Pedido" << std::endl;
      std::cout << "4 -  Encomendar Livros" << std::endl;
      std::cout << "5 -  Relatorio de Clientes" << std::endl;
      std::cout << "6 -  Relatorio de Livros" << std::endl;
      std::cout << "7 -  Relatorio de Pedidos" << std::endl;
      std::cout << "8 -  Gravar Tudo" << std::endl;
      std::cout << "9 -  Gravar Livros" << std::endl;
      std::cout << "10 - Gravar Clientes" << std::endl;
      std::cout << "11 - Recuperar Cliente" << std::endl;
      std::cout << "12 - Recuperar Livro" << std::endl;
      std::cout << "13 - Recuperar Tudo" << std::endl;
      std::cout << "14 - Sair do Sistema" << std::endl;
      std::cin >> opc;
      std::cin.ignore();
      system("cls");
      system("clear");/**/


      switch(opc){
         case 1:
            {
                Cliente novo_cliente;
                novo_cliente.setnome();
                novo_cliente.setemail();
                novo_cliente.settelefone();
                novo_cliente.setcodigo();
                clientes.push_back(novo_cliente);
                system("cls");
                system("clear");/**/
                novo_cliente.mostra();
                std::cout << "Cliente cadastrado com sucesso!" << std::endl << std::endl;
                do
                {
                    std::cout << "1 - Voltar ao menu principal: " << std::endl;
                    std::cin >> opcao;
                    system("cls");
                    system("clear");/**/
                }
                while (opcao != 1);
                break;
            }


         case 2:
            {
                Livro novo_livro;
                novo_livro.settitulo();
                novo_livro.setautor();
                novo_livro.setpreco();
                novo_livro.setISBN();
                livros.push_back(novo_livro);
                system("cls");
                system("clear");/**/
                novo_livro.mostra();
                std::cout << "Livro cadastrado com sucesso!" << std::endl << std::endl;
                do
                {
                    std::cout << "1 - Voltar ao menu principal: ";
                    std::cin >> opcao;
                    std::cin.ignore();
                    system("cls");
                    system("clear");/**/
                }
                while (opcao != 1);
                break;
            }


         case 3:
             {
                 int i;
                 bool naoachou=true;
                 std::cout << "Clientes Disponiveis: " << std::endl;
                 for (i=0;i<clientes.size();i++)
                 {
                     clientes[i].mostra();
                 }
                 do
                 {
                    std::cout << "Digite o codigo do cliente que deseja: ";
                    std::cin >> opcao;
                    std::cin.ignore();
                    for (i=0;i<clientes.size();i++)
                    {
                        if(clientes[i].getcodigo()==opcao)
                        {
                            naoachou=false;
                            break;
                        }
                    }
                    system("cls");
                    system("clear");/**/
                 }
                 while(naoachou);
                 Pedido novo_pedido(clientes[i]);
                 novo_pedido.setdata();
                 novo_pedido.setnumero();
                 system("cls");
                 system("clear");/**/
                 pedidos.push_back(novo_pedido);
                 clientes[i].mostra();
                 std::cout << "Pedido Criado com sucesso!" << std::endl;
                 do
                 {
                     std::cout << "1 - Voltar para o menu principal: " << std::endl;
                     std::cin >> opcao;
                     system("cls");
                     system("clear");/**/
                 }
                 while (opcao != 1);
                 break;
             }


         case 4:
            {
                int i,num,cont=0;
                bool naoachou=true;

                do
                {
                    std::cout << "Pedidos Disponiveis: " << std::endl;
                    for (i=0;i<pedidos.size();i++)
                    {
                        pedidos[i].mostra();
                    }

                    std::cout << "Digite o numero do pedido que deseja registrar a compra: ";
                    std::cin >> num;
                    std::cin.ignore();

                    for (i=0;i<pedidos.size();i++)
                    {
                        if (num == pedidos[i].getnumero())
                        {
                            naoachou = false;
                            break;
                        }
                    }
                    system("cls");
                    system("clear");/**/
                }
                while(naoachou);
                ItemPedido novo_itempedido(pedidos[i]);

                do
                {
                    naoachou = true;
                    do
                    {
                        std::cout << "Livros Disponiveis: " << std::endl;
                        for (i=0;i<livros.size();i++)
                        {
                            if (livros[i].getdisponivel())
                            {
                                cont = i+1;
                                std::cout << "Livro Numero: " << cont << std::endl;
                                livros[i].mostra();
                            }
                        }

                        std::cout << "Digite o Numero do livro que deseja comprar:";
                        std::cin >> cont;
                        std::cin.ignore();
                        cont--;

                        if (livros[cont].getdisponivel())
                        {
                                naoachou = false;
                                std::cout << "oloco";
                        }
                    }
                    while(naoachou);
                    novo_itempedido.addlivro(livros[cont]);
                    novo_itempedido.mostra();
                    std::cout << "Livro Comprado com sucesso!" << std::endl;
                    do
                    {
                        std::cout << "1 - Voltar para o menu principal " << std::endl;
                        std::cout << "2 - Comprar outro livro: " << std::endl;
                        std::cin >> opcao;
                        system("cls");
                        system("clear");/**/
                    }
                    while (opcao>2 || opcao<1);
                }
                while (opcao == 2);
                break;
            }


         case 5:
            {
                int i;
                do
                {
                    std::cout << "Total de Clientes: " << clientes.size() << std::endl << std::endl;
                    for (i=0;i<clientes.size();i++)
                    {
                        std::cout << "------Cliente " << i+1 << "------" << std::endl;
                        clientes[i].mostra();
                    }
                    std::cout << "1 - Voltar para o menu principal " << std::endl;
                    std::cin >> opcao;
                    system("cls");
                    system("clear");/**/
                }
                while (opcao != 1);
                break;
            }


         case 6:
            {
                int i;
                do
                {
                    std::cout << "Total de Livros: " << livros.size() << std::endl << std::endl;
                    for (i=0;i<livros.size();i++)
                    {
                        std::cout << "------Livro " << i+1 << "------" << std::endl;
                        livros[i].mostra();
                    }
                    std::cout << "1 - Voltar para o menu principal " << std::endl;
                    std::cin >> opcao;
                    system("cls");
                    system("clear");/**/
                }
                while (opcao != 1);
                break;
            }


         case 7:
            {
                int i;
                do
                {
                    std::cout << "Total de Pedidos: " << pedidos.size() << std::endl << std::endl;
                    for (i=0;i<pedidos.size();i++)
                    {
                        std::cout << "------Livro " << i+1 << "------" << std::endl;
                        pedidos[i].mostra();
                    }
                    std::cout << "1 - Voltar para o menu principal " << std::endl;
                    std::cin >> opcao;
                    system("cls");
                    system("clear");/**/
                }
                while (opcao != 1);
                break;
            }


         case 8:
             {
                 std::ofstream file;
                 char filename[100];
                 int tamanho,i;
                 tamanho = clientes.size();
                 std::cout << "Digite o nome do arquivo a ser salvo: ";
                 gets(filename);
                 file.open(filename, std::ios::binary);
                 file.write((char *)&tamanho, sizeof(tamanho));
                 for (i=0;i<tamanho;i++)
                 {
                     clientes[i].grava(file);
                 }
                 tamanho = livros.size();
                 file.write((char *)&tamanho, sizeof(tamanho));
                 for (i=0;i<tamanho;i++)
                 {
                     livros[i].grava(file);
                 }
                 file.close();
                 break;
             }


         case 9:
             {
                 std::ofstream file;
                 char filename[100];
                 int tamanho,i;
                 tamanho = livros.size();
                 std::cout << "Digite o nome do arquivo a ser salvo: ";
                 gets(filename);
                 file.open(filename, std::ios::binary);
                 file.write((char *)&tamanho, sizeof(tamanho));
                 for (i=0;i<tamanho;i++)
                 {
                     livros[i].grava(file);
                 }
                 file.close();
                 std::cout << "Arquivo Salvo com sucesso!";
                 break;
             }
         case 10:
             {
                 std::ofstream file;
                 char filename[100];
                 int tamanho,i;
                 tamanho = clientes.size();
                 std::cout << "Digite o nome do arquivo a ser salvo: ";
                 gets(filename);
                 file.open(filename, std::ios::binary);
                 file.write((char *)&tamanho, sizeof(tamanho));
                 for (i=0;i<tamanho;i++)
                 {
                     clientes[i].grava(file);
                 }
                 file.close();
                 break;
             }


     }
  }while(opc != 14);
/*
    int codigo=10;
    std::ofstream file;
    char filename[100] = "teste";
    file.open(filename, std::ios::binary);
    Cliente cliente1(15,"92758928","olocosko@hotmail.com","Ronaldo");
    Livro livro1("BBRG","A tranca da mulher careca","Cabrones",25.50);
    Livro livro2("BRGD","O careca sem cabelo","Mamonas",35.75);
    Pedido pedido1(cliente1,1,"15/02/1998");
    ItemPedido item1(pedido1);
    item1.addlivro(livro1);
    item1.addlivro(livro2);
    cliente1.mostra();
    cliente1.grava(file);
    livro1.grava(file);
    file.close();

    //para recuperar



    std::ifstream infile;
    Cliente cliente1;
    char filename[100] = "teste;
    infile.open(filename, std::ios::binary);
    cliente1.recupera(infile);
    Livro livro1;
    livro1.recupera(infile);
    cliente1.mostra();
    livro1.mostra();

*/
    return 0;
}
