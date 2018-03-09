#include<stdlib.h>
#include<stdio.h>
#include <time.h> 

void insertion_sort (int arr[], int length){
	 	int j, temp;
		
	for (int i = 0; i < length; i++){
		j = i;
		
		while (j > 0 && arr[j] < arr[j-1]){
			  temp = arr[j];
			  arr[j] = arr[j-1];
			  arr[j-1] = temp;
			  j--;
			  }
		}
}


/*
void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d ", arr[i]);
    printf("n");
}
*/

int main()
{
    for (int k=0; k<100; k++)
    {
        int arr[10000];
        for (int i=0; i<10000; i++)
        {
            arr[i] = rand()%100;
        }
        int n = sizeof(arr)/sizeof(arr[0]);
        insertion_sort(arr, n);
        //printf("Sorted array: \n");
        //printArray(arr, n);
    } 
    return 0;
}
