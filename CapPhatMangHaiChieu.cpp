#include "stdio.h"
#include "stdlib.h"
#include "conio.h"
#include "math.h"
#include "limits.h"

//THAO TAC DE QUY VOI MANG HAI CHIEU CO SU DUNG CON TRO

void CapPhat(int **array, int dong, int cot){
	array = (int *)realloc(0, sizeof(int *) * dong);
	
	for(int i = 0; i < dong; i++){
		(array + i) = (int *)realloc(0, sizeof(int *) * cot);
	}
}

int main(){
	int dong, cot;
	do{
		printf("\nNhap so dong, so cot cua mang: ");
		scanf("%d %d", &dong, &cot);
		if(dong < 0 || cot < 0){
			printf("\nNhap sai, nhap lai.");
		}
	}
	while(dong < 0 || (dong > 0 && cot < 0));
	
	int **array;
	CapPhat(array, dong, cot);
	// giai phong mang a
	free(array);
	return 0;
}
