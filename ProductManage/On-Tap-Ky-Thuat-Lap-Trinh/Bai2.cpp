#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "time.h"
#include "ctype.h"

int KiemTraSoNguyenTo(int n){
	if(n == 2) return 1;
	for(int i = 2; i < n; i++)
		if(n % i == 0) return 0;
	return 1;
}

void SoNguyenToVongLap(int n){
	if(n > 2)
		for(int i = 2 ; i < n; i++)
			if(KiemTraSoNguyenTo(i) == 1)
				printf("%4d", i);
}

void SoNguyenToDeQuy(int n, int i = 2){
	if(n <= 2 || i == n) return;
	if(KiemTraSoNguyenTo(i) == 1){
		printf("%4d", i);
		SoNguyenToDeQuy(n, i+1);
	}
	else SoNguyenToDeQuy(n, i+1);
}

int main(){
	int n;
	// khoi tao menu
	int choise;
	do{
		printf("\nMenu:\n");
		printf("Chon 1 de Nhap so nguyen duong\n");
		printf("Chon 2 de Hien thi cac so nguyen to su dung vong lap\n");
		printf("Chon 3 de Hien thi cac so nguyen to su dung de quy\n");
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
					break;
				case 2:
					// so nguyen to bang vong lap
					SoNguyenToVongLap(n);
					break;
				case 3:
					// so nguyen to bang de quy
					SoNguyenToDeQuy(n);
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
