#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "time.h"
#include "ctype.h"

int Chuyen10To2(int n){
	int result = 0;
	for(; n != 0;){
		result = result * 10 + n % 2;
		n = n/2;
	}
	
	int tmp = 0;
	for(; result != 0;){
		tmp = tmp * 10 + result % 10;
		result = result / 10;
	}	
	return tmp;
}

int Chuyen10To8(int n){
	int result = 0;
	for(; n != 0;){
		result = result * 10 + n % 8;
		n = n/8;
	}
	
	int tmp = 0;
	for(; result != 0;){
		tmp = tmp * 10 + result % 10;
		result = result / 10;
	}	
	return tmp;
}

int main(){
	int n;
	// khoi tao menu
	int choise;
	do{
		printf("\nMenu:\n");
		printf("Chon 1 de Nhap so nguyen duong (he 10)\n");
		printf("Chon 2 de Chuyen so vua nhap sang he 2\n");
		printf("Chon 3 de Chuyen so vua nhap sang he 8\n");
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
						if(n < 0 || n > 255)
							printf("\nNhap sai, nhap lai!");
					}
					while(n < 0 || n > 255);
					break;
				case 2:
					printf("%dDEC --> %dBIN", n, Chuyen10To2(n));
					break;
				case 3:
					printf("%dDEC --> %dOCT", n, Chuyen10To8(n));
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
