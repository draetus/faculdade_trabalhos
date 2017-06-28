#include <iostream>
#include <fstream>
#include "Cliente.h"
#include "Pedido.h"
#include "Livro.h"
#include "ItemPedido.h"

int main()
{

    //para salvar


    /*int codigo=10;
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
    file.close();*/


    //para recuperar


    std::ifstream infile;
    Cliente cliente1;
    char filename[100] = "teste";
    infile.open(filename, std::ios::binary);
    cliente1.recupera(infile);
    Livro livro1;
    livro1.recupera(infile);
    cliente1.mostra();
    livro1.mostra();

    return 0;
}
