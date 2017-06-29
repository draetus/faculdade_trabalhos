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
      std::cout << "8 -  Gravar Livros" << std::endl;
      std::cout << "9 -  Recuperar Livros" << std::endl;
      std::cout << "10 - Sair do Sistema" << std::endl;
      std::cin >> opc;
      std::cin.ignore();
      system("cls");
      /*system("clear");*/

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
                   /* system("clear");*/
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
                /*system("clear");*/
                novo_livro.mostra();
                std::cout << "Livro cadastrado com sucesso!" << std::endl << std::endl;
                do
                {
                    std::cout << "1 - Voltar ao menu principal: ";
                    std::cin >> opcao;
                    std::cin.ignore();
                    system("cls");
                    /*system("clear");*/
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
                     /*system("clear");*/
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
                    /*system("clear");*/
                }
                while(naoachou);
                ItemPedido novo_itempedido(pedidos[i]);

                do{
                    naoachou = true;
                    do
                    {
                        std::cout << "Livros Disponiveis: " << std::endl;
                        for (i=0;i<livros.size();i++){
                            if (livros[i].getdisponivel()){
                                std::cout << "Livro Numero: " << cont++ << std::endl;
                                livros[i].mostra();
                            }
                        }

                        std::cout << "Digite o Numero do livro que deseja comprar ou digite 0 para sair:";
                        std::cin >> cont;
                        std::cin.ignore();
                        cont--;

                        if (livros[cont].getdisponivel()){
                                naoachou = false;
                        }
                    }while(naoachou);
                    novo_itempedido.addlivro(livros[cont]);
                    novo_itempedido.mostra();
                    std::cout << "Livro Comprado com sucesso!" << std::endl;
                    do
                    {
                        std::cout << "1 - Voltar para o menu principal " << std::endl;
                        std::cin >> opcao;
                        system("cls");
                        /*system("clear");*/
                    }while (opcao<=1 || opcao>1);
                }while (opcao == 1);
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
                    /*system("clear");*/
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
                    /*system("clear");*/
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
                    /*system("clear");*/
                }
                while (opcao != 1);
                break;
            }

         case 8:
             {
                 std::ofstream outfile;
                 int i;
                 unsigned int tamanho;
                 char filename[100];

                 tamanho = livros.size();
                 std::cout << "Digite o nome do arquivo: ";
                 gets(filename);
                 outfile.open(filename, std::ios::binary);
                 if(!outfile)
                 {
                      std::cout << "Nao foi possivel criar o arquivo!" << std::endl;
                      break;
                 }
                 outfile.write((char *)&tamanho, sizeof(tamanho));
                 for (i=0;i<tamanho;i++)
                 {
                     livros[i].grava(outfile);
                 }
                 outfile.close();
                 std::cout << "Arquivo Salvo com sucesso!" << std::endl;
                 do
                 {
                     std::cout << "1 - Voltar para o menu principal: " << std::endl;
                     std::cin >> opcao;
                     system("cls");
                     /*system("clear");*/
                 }
                 while (opcao != 1);
                 break;
             }
        case 9:
            {
                 std::ifstream infile;
                 char filename[100];
                 int i;
                 unsigned int tamanho;

                 std::cout << "Digite o nome do arquivo: ";
                 gets(filename);
                 infile.open(filename, std::ios::binary);
                 if(!infile)
                 {
                      std::cout << "Nao foi possivel carregar o arquivo!" << std::endl;
                      break;
                 }

                 Livro novo_livro;
                 infile.read((char *)&tamanho, sizeof(tamanho));
                 //tamanho = 8;

                 if (tamanho>0)
                 {
                     for (i=0;i<tamanho;i++)
                     {
                        novo_livro.recupera(infile);
                        livros.push_back(novo_livro);
                     }
                 }
                 else
                 {
                     std::cout << "Nao a livros cadastrados!" << std::endl;
                     break;
                 }
                 std::cout << "Livros recuperados com sucesso!" << std::endl;
                 infile.close();
                 do
                 {
                     std::cout << "1 - Voltar para o menu principal: " << std::endl;
                     std::cin >> opcao;
                     system("cls");
                     /*system("clear");*/
                 }
                 while (opcao != 1);
                 break;
            }
     }
  }while(opc != 10);
return 0;
}
