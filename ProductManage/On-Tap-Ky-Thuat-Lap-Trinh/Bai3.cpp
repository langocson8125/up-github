#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "time.h"
#include "ctype.h"

void InitArray(int *&a, int n){
	time_t t;
    srand((unsigned) time(&t));
    for(int i = 0; i < n; i++)
    	*(a + i) = rand() % 10;
}

int FindMax(int *array, int n, int i = 0, int Max = INT_MIN){
	if(i == n) return Max;
	if(*(array + i) > Max){
		Max = *(array + i);
		return FindMax(array, n, i+1, Max);
	}
	else return FindMax(array, n, i+1, Max);
}

int Sum(int *array, int n, int i = 0, int result = 0){
	if(i == n) return result;
	return Sum(array, n, i+1, result + *(array + i));
}
int main(){
	int n = 0;
	int *a;
	// khoi tao menu
	int choise;
	do{
		printf("Menu:\n");
		printf("Chon 1 de Nhap day so\n");
		printf("Chon 2 de Tim phan tu lon nhat\n");
		printf("Chon 3 de Tinh tong day\n");
		printf("Chon 4 de Ket thuc\n");
		scanf("%d", &choise);
		if(choise < 0 || choise > 4)
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
					a = (int *)malloc(n * sizeof(int *));
					InitArray(a, n);
					for(int i = 0; i < n; i++){
						printf("%4d", *(a+i));
					}
					break;
				case 2:
					if(n <= 0)
						printf("Mang rong\n");
					else
						printf("Gia tri lon nhat: %d\n", FindMax(a, n));
					break;
				case 3:
					if(n <= 0)
						printf("Mang rong\n");
					else
						printf("Tong cac so: %d\n", Sum(a, n));
					break;
				case 4:
					printf("Chuong trinh ket thuc");
					break;
			}
		}
	}
	while(choise != 4);
	return 0;
}
