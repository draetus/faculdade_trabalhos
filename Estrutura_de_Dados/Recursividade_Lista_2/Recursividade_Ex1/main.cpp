#include <iostream>
#include <math.h>

using namespace std;

int fatorial(int n)
{
    if (n<2)
    {
        return 1;
    }
    return n*fatorial(n-1);
}


double coseno(float x, int n, int i=0)
{
    n--;
    if (n==0)
    {
        return 1;
    }
    if (n*2%4==0)
    {
        return pow(x,n*2)/fatorial(n*2) + coseno(x,n);
    }
    else
    {
        return -pow(x,n*2)/fatorial(n*2) + coseno(x,n);
    }
}


int main()
{
    float x;
    int n;
    cout << "Forneça o grau desejado: ";
    cin >> x;
    cout << "Forneça quantos termos: ";
    cin >> n;
    cout << "Coseno: " << coseno(x,n);
    return 0;
}
