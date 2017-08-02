#include <iostream>

using namespace std;

int soma(int n=1000)
{
    if (n==5)
    {
        return 5;
    }
    return n+soma(n-1);
}


int main()
{
    cout << soma(15);
    return 0;
}
