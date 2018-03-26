#include "stdio.h"
#include "stdlib.h"
#include "conio.h"

/*
	ham tinh tong cac to tu 1-n
	tham so: n
	tra ve: ket qua sau khi tinh tong
*/
int TongCacSo(int n, int x = 1){
	if(n == 1){
		return x;
	}
	return TongCacSo(n - 1, x + n);
}

/*
	ham tinh tong binh phuong cac so tu 1-n
	tham so: n
	tra ve: ket qua sau khi tinh tong
*/
int TongBinhPhuong(int n, int x = 1){
	if(n == 1){
		return x;
	}
	return TongBinhPhuong(n - 1, x + n*n);
}

/*
	ham tinh tong cac phan so: 1 + 1/2 + ... + 1/n
	tham so: n
	tra ve: ket qua sau khi tinh tong
*/
float TongPhanSo(int n, float x = 1){
	if(n == 1){
		return x;
	}
	return TongPhanSo(n - 1, x + 1.0/n);
}

/*
	ham tinh giai thua cua n
	tham so: n - so can tinh
	tra ve: ket qua sau khi tinh giai thua
*/
int GiaiThua(int n, int x = 1){
	if(n == 1){
		return x;
	}
	return GiaiThua(n - 1, x * n);
}

/*
	ham tinh tong gia thua tu 1-n
	tham so: n
	tra ve: ket qua sau khi tinh tong
*/
int TongGiaiThua(int n, int x = 1){
	if(n == 1){
		return x;
	}
	return TongGiaiThua(n - 1, x + GiaiThua(n));
}

/*
	ham tim uoc chung lon nhat cua 2 so
	tham so: so thu nhat, so thu hai
	tra ve: uoc chung lon nhat cua hai so
*/
int UCLN(int a, int b){
	int highest;
	for(int i = 1; i <= a || i <= b; i++){
		if(a % i == 0 && b % i == 0){
			highest = i;
		}
	}
	return highest;
}

/*
	ham in ra cac phan tu cua mang
	tham so: n - so phan tu can xuat
*/
void XuatMang(int *a, int n){
	for(int i = 0; i < n; i++){
		printf("%4d", *(a + i));
	}
}

/*
	xuat ra n phan tu dau cua day Fibonacy
	tham so: n - so phan tu can xuat
*/
void Fibonacy(int *a, int n){
	*(a) = *(a + 1) = 1;
	for(int i = 2; i < n; i++){
    	*(a + i) = *(a + i - 1) + *(a + i - 2);
    }
    XuatMang(a, n);
}

int main(){
	// nhap gia tri n 
	int n;
	do{
		printf("Nhap n: ");
		scanf("%d", &n);
		if(n < 0){
			printf("\nNhap sai, nhap lai");
		}
	}
	while(n < 0);
	
	// cap phat dong so phan tu cua mang
	int *a = (int *)realloc(0,  n * sizeof(int *));
	Fibonacy(a, n);
	
	free(a);
	return 0;
}
