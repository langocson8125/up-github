#include "stdio.h"
#include "conio.h"
#include "stdlib.h"
#include "limits.h"

// Nhap mang
void NhapMang(int *a, int n){
	for(int i = 0; i < n; i++){
		printf("Nhap phan tu a[%d] ", i + 1);
		scanf("%d", a + i);
	}
}

// Xuat mang
void XuatMang(int *a, int n){
	for(int i = 0; i < n; i++){
		printf("%4d", *(a + i));
	}
}

// Lon nhat
int PhanTuLonNhat(int *a, int n){
	int Max = INT_MIN;
	for(int i = 0; i < n; i++){
		if(*(a + i) > Max){
			Max = *(a + i);
		}
	}
	return Max;
}

// Nho nhat
int PhanTuNhonNhat(int *a, int n){
	int Min = INT_MAX;
	for(int i = 0; i < n; i++){
		if(*(a + i) < Min){
			Min = *(a + i);
		}
	}
	return Min;
}

// kiem tra su ton tai cua phan tu
int KiemTraPhanTu(int *a, int n, int element){
	for(int i = 0; i < n; i++){
		if(*(a + i) == element){
			return 1;
		}
	}
	return 0;
}

// tim vi tri phan tu 
int TimViTriPhanTu(int *a, int n, int element){
	for(int i = 0; i < n; i++){
		if(*(a + i) == element){
			return i;
		}
	}
}

// kiem tra mang tang hay k
int KiemTraTang(int *a, int n){
	for(int i = 0; i < n; i++){
		if(*(a + i) > *(a + i + 1)){
			return 0;
		}
	}
	return 1;
}

int main(){
	int n;
	do{
		printf("\nNhap so phan tu cua mang: ");
		scanf("%d", &n);
		if(n < 0){
			printf("\nNhap sai, nhap lai.");
		}
	}
	while(n < 0);
	
	// cap phat so phan tu cua mang
	int *a = (int *)realloc(0,  n * sizeof(int *));
	
	NhapMang(a, n);
	printf("\nMang ban dau: ");
	XuatMang(a, n);
	
	// giai phong o nho
	free(a);
	return 0;
}
