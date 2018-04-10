#include "stdio.h"
#include "conio.h"
#include "stdlib.h"

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

// Them phan tu vao mang
void ThemPhanTu(int *&a, int &n, int ViTriThem, int PhanTuThem){
	realloc(a, (n + 1) * sizeof(int *)); // tang bo nho them 1 o
	for(int i = n; i >= ViTriThem; i--){
		*(a + i) = *(a + (i - 1));
	}
	*(a + (ViTriThem - 1)) = PhanTuThem;
	n++; // tang kich thuoc cua mang len
}

// Xoa phan tu khoi mang
void XoaPhanTu(int *&a, int &n, int ViTriXoa){
	for(int i = ViTriXoa - 1; i < n - 1; i++){
		*(a + i) = *(a + (i + 1));
	}
	
	n--; // giam kich thuoc cua mang xuong
	realloc(a, n * sizeof(int *)); // giam bo nho them 1 o
}

int main(){
	printf("------------------ Them/xoa phan tu cua mang --------------------");
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
	
	free(a);
	return 0;
}
