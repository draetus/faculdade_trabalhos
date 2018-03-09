#include <iostream>

int fibonacci(int n)
{
	if (n<1)
	return 0;
	
	if (n==1)
	return 1;

	int previous=0;
	int now=1;
	for(int i=1; i<n; i++)
	{
		int temp = now;
		now = now + previous;
		previous = temp;
	}
	return now;
}


int main()
{
	for (int i=0; i<1000000; i++)
	{
		fibonacci(100);
	}
	return 0;
}
