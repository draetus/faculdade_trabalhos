#include <iostream>

using namespace std;


void lerescrever()
{
    char input;
    cin >> input;
    if (input == '*')
    {
        return;
    }
    else
    {
        lerescrever();
    }
    cout << input;
}

int main()
{
    lerescrever();
    return 0;
}
