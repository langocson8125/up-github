#include "stdio.h"
#include "stdlib.h"

void getPrime(long long n, int &count, int arr[]){
	for(int i = 2; i <= n; i++){
		int tmp = 1;
		for(int j = 2; j < i; j++){
			if( i % j == 0){
				tmp = 0;
			}
		}
		if(tmp == 1){
			arr[count] = i;
			count++;			
		}
	}
}

void showResult(int n, int arr[], FILE *&fileOut){
	int i = 0;
	while(n != 1){
		if( n % arr[i] != 0){
			i++;
		}
		else n /= arr[i];
	}
	for(int j =0; j <= i; j++){
		fprintf(fileOut,"%d ",arr[j]);
	}
}
int main(){
	long long n;
	int arr[1000] , count = 0;
	
	FILE *fileIn;
	fileIn = fopen("INPUT.txt","r");
	fscanf(fileIn,"%d",&n);
	fclose(fileIn);
	
	FILE *fileOut;
	fileOut = fopen("OUTPUT.txt","w");
	getPrime(n,count,arr);
	showResult(n,arr,fileOut);
	fclose(fileOut);
	return 0;
}
