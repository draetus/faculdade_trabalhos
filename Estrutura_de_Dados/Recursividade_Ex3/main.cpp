#include <iostream>

using namespace std;

int soma(int n)
{
    if (n==5)
    {
        return 5;
    }
    return n+soma(n-5);
}


int main()
{
    cout << soma(15);
    return 0;
}
