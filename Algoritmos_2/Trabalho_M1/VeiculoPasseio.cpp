#include "Veiculo.h"
#include "VeiculoPasseio.h"
#include <string>
#include <iostream>


VeiculoPasseio::VeiculoPasseio() : Veiculo(0,0,0,0,0)
{
     this-> cor = "";
     this-> modelo = "";
}

VeiculoPasseio::VeiculoPasseio(int peso, int velMax, float preco, int nCilim, int potencia,string cor, string modelo) : Veiculo(peso,velMax,preco,nCilim,potencia){
     this->cor = cor;
     this->modelo = modelo;
}

void VeiculoPasseio::set_cor(string cor){
     this -> cor = cor;
}

void VeiculoPasseio::set_modelo(string modelo){
     this -> modelo = modelo;
}

string VeiculoPasseio::get_cor(){
     return cor;
}

string VeiculoPasseio::get_modelo(){
    return modelo;
}

void VeiculoPasseio::mostra(){
    cout << "Cor: "<<cor<<endl;
    cout << "Modelo: "<<modelo<<endl;
    cout << "Peso em Kg: "<<peso<<endl;
    cout << "Vel Maxima em KM/h: "<<velMax<<endl;
    cout << "Preco em R$: "<<preco <<endl;
    cout <<"A potencia eh: "<<motor.get_potencia() <<endl;
    cout <<"O numero de cilindros eh: "<<motor.get_nCilim() <<endl;
}
