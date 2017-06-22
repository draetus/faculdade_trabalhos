#include "Veiculo.h"
#include <iostream>

Veiculo::Veiculo(int peso, int velMax, float preco, int nCilim, int potencia){
     this-> peso = peso;
     this-> velMax = velMax;
     this-> preco = preco;
     this->motor.set_nCilim(nCilim);
     this->motor.set_potencia(potencia);
}

void Veiculo::set_peso(int peso){
    this->peso = peso;
}

void Veiculo::set_velMax(int velMax){
    this->velMax = velMax;
}

void Veiculo::set_preco(float preco){
    this->preco = preco;
}

int Veiculo::get_peso(){
    return peso;
}

int Veiculo::get_velMax(){
    return velMax;
}

float Veiculo::get_preco(){
    return preco;
}

void Veiculo::set_nCilim(int nCilim){
    motor.set_nCilim(nCilim);
}

void Veiculo::set_potencia(int potencia){
    motor.set_potencia(potencia);
}
