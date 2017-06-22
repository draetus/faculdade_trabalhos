#ifndef VEICULO_H_INCLUDED
#define VEICULO_H_INCLUDED
#include <iostream>
#include "Motor.h"

class Veiculo{
    protected:
        int peso, velMax;
        float preco;
        Motor motor;
    public:
        Veiculo(int, int, float, int, int);
        void set_peso(int);
        void set_velMax(int);
        void set_preco(float);
        void set_nCilim(int);
        void set_potencia(int);
        virtual void mostra(){};

        int get_peso();
        int get_velMax();
        int get_nCilim();
        int get_potencia();
        float get_preco();

};


#endif // VEICULO_H_INCLUDED
