#include <iostream>

using namespace std;

void torreHanoi(int haste1[],int haste2[],int haste3[], int n, int i=0)
{
    haste3[i] = haste1[n-i-1];
    if (i<n-1)
    {
        torreHanoi(haste1,haste2,haste3,n,i+1);
    }
    haste2[i] = haste3[n-i-1];
}


int main()
{
    int haste1[10] = {10,9,8,7,6,5,4,3,2,1}, haste2[10], haste3[10], n=10;
    torreHanoi(haste1,haste2,haste3,n);
    for (int i=0;i<n;i++)
    {
        cout << haste3[i] << " ";
    }
    return 0;
}
