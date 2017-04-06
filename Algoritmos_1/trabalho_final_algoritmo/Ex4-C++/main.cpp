#include <iostream>

using namespace std;



int EhRegular(int numero)

{

    int iterador = 0;

    int cont = 0;

    int resto = 0;

    int resultado = numero;

    int primos[4] = {2,3,5,7};

    while (resultado != 1) {

        for (cont = 0; cont<4; cont++){

            resto = resultado % primos[cont];

            if (resto == 0 && primos[cont]<7 ){

               resultado = resultado/primos[cont];

               cout<< "Passos - resultado da div: "<< resultado<<" divisor:"<<primos[cont] <<endl;

               break;

            }else{

                if (primos[cont]>=7){

                cout<< "Numero N�O REGULAR" <<endl;

                return 0;

                }

            }

        }

        if (resultado == numero){

            cout<< "Numero N�O REGULAR" <<endl;

            return 0;

        }

    }

    cout<< "Numero REGULAR" <<endl;

    return resultado;

}



int main()

{

    int numero = 0;

    int contador = 0;

    while (contador < 10){

        cout<< "Insira um valor: "<<endl;

        cin >> numero;

        cout << EhRegular(numero) << endl;

        contador++;

    }

    return 0;

}
