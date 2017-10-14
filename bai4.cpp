#include "stdio.h"
#include "stdlib.h"
#include "math.h"

int giaiThua(int a){ //ham nay co chuc nang tinh giai thua
	int n = 1;
	for(int i = 1; i <= a; i++){
		n *= i;
	}
	return n;
}
int main(){
	int n;
	float EMuX = 1, x;
	printf("Nhap so nguyen n: ");
	scanf("%d",&n);
	printf("Nhap so thuc x: ");
	scanf("%f",&x);
	if(n < 1){
		printf("N > 1, vui long nhap lai");
	}
	else{
		for(int i = 1; i <= n; i++){
			EMuX += (pow(x,i))/giaiThua(i);
		}
	printf("Ket qua: %0.5f", EMuX);
	}
	return 0;
}
