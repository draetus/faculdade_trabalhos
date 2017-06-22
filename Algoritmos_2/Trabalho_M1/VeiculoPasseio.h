#ifndef VEICULOPASSEIO_H_INCLUDED
#define VEICULOPASSEIO_H_INCLUDED

#include "Veiculo.h"
#include <string>

using namespace std;

class VeiculoPasseio : public Veiculo {
     private:
           string cor, modelo;
     public:
           VeiculoPasseio();
           VeiculoPasseio(int,int,float,int,int,string, string);
           void set_cor(string);
           void set_modelo(string);
           void mostra();

           string get_cor();
           string get_modelo();
};


#endif // VEICULOPASSEIO_H_INCLUDED
