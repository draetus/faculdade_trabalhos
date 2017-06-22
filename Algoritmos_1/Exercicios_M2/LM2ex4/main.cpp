#include <iostream>

using namespace std;

int main()
{ int i, n, j, aux, cont2;
  int x[100], rep[100], cont[100];

  cont2= 0;
  cont[1]= 0;
  n=101;

  do
  {
      cout<< "Forneca o valor de N: "<<endl;
      cin>>n;
  } while (n>100);
  for (i=1; i<=n; i++)
  {
      cout<<i<< "ºtermo: ";
      cin>>x[i];
  }
  for (i=1; i<=n; i++)
  {
      for (j=1; j<=n; j++)
      {
          if (x[j]<x[i])
          {
              aux = x[j];
              x[j] = x[i];
              x[i] = aux;
          }
      }
  }
  i = 0;
  do
  {
      i=i+1;
      for (j=i+1; j<=n; j++)
      {
          if (x[j]==x[i])
          {
              cont[cont2+1] = cont[cont2+1]+1;
              rep[cont2+1] = x[i];
              i= i+1;
          }
      }
      if (cont[cont2+1] > 0)
      {
          cont2 = cont2 +1;
      }
  }while (i==n);
  cout<< "_____________________"<<endl;
  cout<< "Vetor organizado por ordem decrescente: "<<endl;
  for (i=1; i<=n; i++)
  {
      cout<<i<<" ºtermo: "<<x[i]<<endl;
  }
  cout<< "_________________"<<endl;
  cout<<"Numeros repetidos: ";
  for (i=1; i<=cont2; i++)
  {
      cout<<"Numero: "<<rep[i]<<" Repetido: "<<cont[i]<<" vezes"<<endl;
  }
   return 0;
}
