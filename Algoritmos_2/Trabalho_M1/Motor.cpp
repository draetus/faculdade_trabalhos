#include "Motor.h"
#include <iostream>

using namespace std;


Motor::Motor(){
    nCilim = 0;
    potencia = 0;
}

Motor::Motor(int nCilim, int potencia){
    this -> nCilim = nCilim;
    this -> potencia = potencia;
}

void Motor::set_nCilim(int nCilim){
    this -> nCilim = nCilim;
}

void Motor::set_potencia(int potencia){
    this -> potencia = potencia;
}

int Motor::get_nCilim(){
    return nCilim;
}

int Motor::get_potencia(){
    return potencia;
}

void Motor::mostra(){
    cout <<"A potencia eh: "<<potencia <<endl;
    cout <<"O numero de cilindros eh: "<<nCilim <<endl;
}
