#include <iostream>
#include <math.h>

using namespace std;

int main()

{
    int j, i, n;
    float a[20], x[4], p[4];

    do
    {
        cout << "Forneca o valor de n: ";
        cin >> n;
    }
    while (n < 1 || n > 20);

    for (i = 0; i <= n; i++)
    {
        cout << i << "° valor: ";
        cin >> (a[i]);
    }

    cout << endl;

    for (i = 0; i <= 4; i++)
    {
        cout << i << "valor de x: ";
        cin >> (x[i]);
    }

    for (i = 0; i <= 4; i++)
    {
        p[i] = 0;
        for (j = n; j >= 0; j--)
        {
            p[i] = p[i] + a[j] * pow(x[i], j);
        }
        cout << endl;
        cout << i << "° valores:" << endl;
        cout << "P: " << p[i] << endl;
        cout << "X: " << x[i] << endl;
    }

    return 0;

}
