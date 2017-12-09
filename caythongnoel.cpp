#include "stdio.h"
#include "stdlib.h"

int main(){
	int h;
	scanf("%d", &h);
	for(int i = 1; i <= h; i++){ // lap tung dong 
		for(int j = 0; j < h - i ; j++){ // in khoang trang
			printf(".");
		}
		for(int k = 0; k < (i * 2) - 1 ; k++ ){ // in dau *
			printf("*");
		}
		printf("\n"); // xuong dong
	}
	for(int i = 2; i <= h; i++){ // lap tung dong 
		for(int j = 0; j < h - i ; j++){ // in khoang trang
			printf(".");
		}
		for(int k = 0; k < (i * 2) - 1 ; k++ ){ // in dau *
			printf("*");
		}
		printf("\n"); // xuong dong
	}
	return 0;
}
