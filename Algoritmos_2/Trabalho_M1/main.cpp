#include <iostream>
#include "VeiculoPasseio.h"
#include "Veiculo.h"

using namespace std;

int main(){
   VeiculoPasseio v1;
   v1.set_peso(800);
   v1.set_velMax(250);
   v1.set_preco(80000);
   v1.set_cor("Amarelo");
   v1.set_modelo("Lamborghini Gallardo");
   v1.set_nCilim(5);
   v1.set_potencia(10000);
   cout << "Versao sem parametros: " << endl;
   v1.mostra();

   cout << endl;
   cout << endl;

   VeiculoPasseio v2(1200,300,120000,3,50000,"Vermelhao","Pagani Zonda");
   cout << "Versao com parametros: " << endl;
   v2.mostra();

   cout << endl;
   cout << endl;

   Veiculo *pv;
   pv = new VeiculoPasseio;
   pv -> set_peso(1900);
   pv -> set_velMax(270);
   pv -> set_preco(87000);
   ((VeiculoPasseio*)pv) -> set_cor("Roxo");
   ((VeiculoPasseio*)pv) -> set_modelo("Uno");
   pv -> set_nCilim(2);
   pv -> set_potencia(1000000);
   cout << "Versao com ponteiros: " << endl;
   pv -> mostra();

   return 0;
}
