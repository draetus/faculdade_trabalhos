// C program for implementation of Bubble sort
#include<stdlib.h>
#include<stdio.h>
#include <time.h> 

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
 
// A function to implement bubble sort
void bubbleSort(int arr[], int n)
{
   int i, j;
   for (i = 0; i < n-1; i++)      
 
       // Last i elements are already in place   
       for (j = 0; j < n-i-1; j++) 
           if (arr[j] > arr[j+1])
              swap(&arr[j], &arr[j+1]);
}
 
// Driver program to test above functions
int main()
{
    for (int k=0; k<100; k++)
    {
        int arr[10000];
        for (int i=0; i<10000; i++)
        {
            arr[i] = rand();
        }
        int n = sizeof(arr)/sizeof(arr[0]);
        bubbleSort(arr, n);
    } 
    return 0;
}
