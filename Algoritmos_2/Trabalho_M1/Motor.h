#ifndef MOTOR_H_INCLUDED
#define MOTOR_H_INCLUDED
#include <iostream>
#include <string>

using namespace std;

class Motor
{
   private:
       int nCilim, potencia;

   public:
       Motor();
       Motor(int, int);
       void set_nCilim(int nCilim);
       void set_potencia(int potencia);
       void mostra();

       int get_nCilim();
       int get_potencia();

};








#endif // MOTOR_H_INCLUDED
