#include <iostream>

using namespace std;

int soma(int n=1000)
{
    if (n==5)
    {
        return 5;
    }
    return n+soma(aux);
}


int main()
{
    cout << soma(15);
    return 0;
}
