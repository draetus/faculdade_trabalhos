#include "Produto.h"
#include <stdio.h>

using namespace std;


ostream& operator<<(ofstream& out, Produto &produto){
    produto.grava(out);
    return out;
}

istream& operator>>(ifstream& in, Produto &produto){
    produto.recupera(in);
    return in;
}

Produto::Produto(int qtde, float preCust){
    this->qtde = qtde;
    this->preCust = preCust;
}

void Produto::set_nome(){
    cout << "Nome do produto: " << endl;
    setbuf(stdin, NULL);
    gets(this->nome);
}

void Produto::set_preCust(){
    float preCust;
    cout << "Preco custo: " << endl;
    cin >> preCust;
    this->preCust = preCust;
}

void Produto::set_qtde(){
    int qtde;
    cout << "Quantidade: " << endl;
    cin >> qtde;
    this->qtde = qtde;
}

string Produto::get_nome(){
    return this-> nome;
}

float Produto::get_preCust(){
    return this->preCust;
}

int Produto::get_qtde(){
    return this->qtde;
}

void Produto::mostra(){
    cout << "Produto: " << nome << endl;
    cout << "Quantidade: " << qtde << endl;
    cout << "Preco de custo: " << preCust << endl;

}

void Produto::grava(ofstream &file){
    file.write((char *)this, sizeof(Produto));
}

Produto Produto::recupera(ifstream &file){
    file.read((char *)this, sizeof(Produto));
}
