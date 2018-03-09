#include <iostream>

int fibonnaci(int n, int i=1, int previous=0, int now=1)
{
	if (n<1)
	return 0;

	if (n==1)
	return 1;

	if (i==n)
	return now;

	int temp=now;	
	now = now + previous;
	previous = temp;

	i++;
	fibonnaci(n,i,previous,now);
}




int main()
{
	int n = fibonnaci(7);
	std::cout << n;
}
