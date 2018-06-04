#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "time.h"
#include "ctype.h"

void TaoMang(int **&array, int n){
	time_t t;
    srand((unsigned) time(&t));
	array = (int **)malloc(n * sizeof(int *));
	
	for(int i = 0; i < n; i++){
		array[i] = (int *)malloc(n * sizeof(int));
		for(int j = 0; j < n; j++){
			*(array[i] + j) = rand() % 10;
		}
	}
}

void GiaiPhong(int **&array, int n){
	for(int i = 0; i < n; i++){
		free(array[i]);
	}
	free(array);
}

void InDuongCheoChinh(int **&array, int n){
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			if(j == i){
				printf("%d\t", *(array[i] + i));
			}
			else{
				printf("*\t");
			}
		}
		printf("\n");
	}
}

void XuatMang(int **array, int n){
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			printf("%4d", *(array[i] + j));
		}
		printf("\n");
	}	
}


int main(){
	int n;
	int **array;
	// khoi tao menu
	int choise;
	do{
		printf("\nMenu:\n");
		printf("Chon 1 de Nhap vao mot ma tran\n");
		printf("Chon 2 de In cac phan tu tren duong cheo chinh\n");
		printf("Chon 3 de Ket thuc\n");
		scanf("%d", &choise);
		if(choise < 0 || choise > 3)
			system("cls");
		else{
			switch(choise){
				case 1:
					do{
					    printf("\nNhap n: ");
						scanf("%d", &n);
						if(n < 0)
							printf("\nNhap sai, nhap lai!");
					}
					while(n < 0);
					TaoMang(array, n);
					break;
				case 2:
					if(n <= 0){
						printf("\nMang rong");
					}
					else{
						InDuongCheoChinh(array, n);
					}
					break;
				case 3:
					GiaiPhong(array, n);
					printf("Chuong trinh ket thuc");
					break;
			}
		}
	}
	while(choise != 3);
	return 0;
}
