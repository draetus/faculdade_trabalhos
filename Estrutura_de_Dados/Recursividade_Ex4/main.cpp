#include <iostream>
#include <ncurses.h>

using namespace std;


void lerescrever()
{
    char input;
    input = cin.get();
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
