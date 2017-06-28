#include <iostream>
#include <fstream>
#include "Cliente.h"
#include "Pedido.h"
#include "Livro.h"
#include "ItemPedido.h"
#include <stdlib.h>


int main(){
  int opc, opcao;
  std::vector<Cliente> clientes;
  std::vector<Pedido> pedidos;
  std::vector<ItemPedido> itempedidos;
  std::vector<Livro> livros;
  Livro novo_livro;
  Cliente novo_cliente;


  do{
      std::cout << "Bem - vindo ao sistema! O que deseja fazer?" << std::endl << std::endl;
      std::cout << "1 -  Cadastrar Cliente" << std::endl;
      std::cout << "2 -  Cadastrar Livro" << std::endl;
      std::cout << "3 -  Novo Pedido" << std::endl;
      std::cout << "4 -  Encomendar Livros" << std::endl;
      std::cout << "5 -  Relatorio de Clientes" << std::endl;
      std::cout << "6 -  Relatorio de Livros" << std::endl;
      std::cout << "7 -  Relatorio de Pedidos" << std::endl;
      std::cout << "8 -  Gravar Clientes" << std::endl;
      std::cout << "9 -  Gravar Livros" << std::endl;
      std::cout << "10 - Gravar Tudo" << std::endl;
      std::cout << "11 - Recuperar Cliente" << std::endl;
      std::cout << "12 - Recuperar Livro" << std::endl;
      std::cout << "13 - Recuperar Tudo" << std::endl;
      std::cout << "14 - Sair do Sistema" << std::endl;
      std::cin >> opc;
      system("cls");


      switch(opc){
         case 1:
            std::cin.ignore();
            novo_cliente.setnome();
            novo_cliente.setemail();
            novo_cliente.settelefone();
            novo_cliente.setcodigo();
            clientes.push_back(novo_cliente);
            system("cls");
            novo_cliente.mostra();
            std::cout << "Cliente cadastrado com sucesso!" << std::endl << std::endl;
            do
            {
                std::cout << "1 - Voltar ao menu principal: " << std::endl;
                std::cin >> opcao;
                system("cls");
            }
            while (opcao != 1);
            break;


         case 2:
            std::cin.ignore();
            novo_livro.settitulo();
            novo_livro.setautor();
            novo_livro.setpreco();
            std::cin.ignore();
            novo_livro.setISBN();
            livros.push_back(novo_livro);
            system("cls");
            novo_livro.mostra();
            std::cout << "Livro cadastrado com sucesso!" << std::endl << std::endl;
            do
            {
                std::cout << "1 - Voltar ao menu principal: ";
                std::cin >> opcao;
                system("cls");
            }
            while (opcao != 1);
            break;


         case 3:
             int i;
             bool achou=false;
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
                        achou=true;
                        break;
                    }
                }
                system("cls");
             }
             while(!achou);
             Pedido novo_pedido(clientes[i]);
             novo_pedido.setdata();
             novo_pedido.setnumero();
             system("cls");
             clientes[i].mostra();
             std::cout << "Pedido Criado com sucesso!" << std::endl;
             do
             {
                 std::cout << "1 - Voltar para o menu principal: " << std::endl;
                 std::cin >> opcao;
                 system("cls");
             }
             while (opcao != 1);
             break;
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
