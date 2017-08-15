#include <iostream>

using namespace std;

void losango(int n, int x=0, bool revert=false)
{
    for (int i=0;i<n-x;i++)
        cout << " ";

    for (int i=0;i<x;i++)
        cout << i+1;

    for (int i=x;i>1;i--)
        cout << i-1;

    for (int i=0;i<n-x;i++)
        cout << " ";

    cout << endl;

    if (!revert)
    {
        if (x<n)
        {
            losango(n,x+1);
        }
        else
        {
            revert = true;
        }
    }
    if (revert)
    {
        if (x>0)
            losango(n,x-1,true);
    }
}


int main()
{
    int n;
    do
    {
        cout << "Forneça o tamanho: ";
        cin >> n;
    }
    while (n<1 || n>9);

    losango(n);

    return 0;
}
