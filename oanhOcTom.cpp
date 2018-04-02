#include "stdio.h"
#include "stdlib.h"
#include "conio.h"
#include "math.h"
#include "limits.h"

//THAO TAC DE QUY VOI MANG MOT CHIEU CO SU DUNG CON TRO

// nhap mang
void NhapMang(int *array, int n, int i = 0){
	if(i == n){
		return; // ket thuc
	}
	printf("Nhap vao a[%d]", i + 1);
	scanf("%d", array + i);
	NhapMang(array, n, i + 1);
}

// xuat mang
void XuatMang(int *array, int n, int i = 0){
	if(i == n){
		return; // ket thuc
	}
	printf("%4d", *(array + i));
	XuatMang(array, n,i + 1);
}

// tinh tong phan tu cua mang
int TinhTongMang(int *array, int n, int i = 0, int Tong = 0){
	if(i == n){
		return Tong; // ket thuc
	}
	return TinhTongMang(array, n, i + 1, Tong + *(array + i));
}

// tim phan tu nho nhat cua mang
int TimMin(int *array, int n, int i = 0, int Min = INT_MAX){
	if(i == n){
		return Min;
	}
	if(*(array + i) < Min){
		return TimMin(array, n, i + 1, *(array + i));
	}
	return TimMin(array, n, i + 1, Min);
}

// tim phan tu lon nhat cua mang
int TimMax(int *array, int n, int i = 0, int Max = INT_MIN){
	if(i == n){
		return Max;
	}
	if(*(array + i) > Max){
		return TimMax(array, n, i + 1, *(array + i));
	}
	return TimMax(array, n, i + 1, Max);
}

// dem so phan tu le cua mang
int DemSoPhanTuLe(int *array, int n, int i = 0, int countOdd = 0){
	if(i == n){
		return countOdd;
	}
	if(*(array + i) % 2 != 0){
		return DemSoPhanTuLe(array, n, i + 1, countOdd + 1);
	}
	return DemSoPhanTuLe(array, n, i + 1, countOdd);
}

// dem so phan tu chan cua mang
int DemSoPhanTuChan(int *array, int n, int i = 0, int countEven = 0){
	if(i == n){
		return countEven;
	}
	if(*(array + i) % 2 == 0){
		return DemSoPhanTuChan(array, n, i + 1, countEven + 1);
	}
	return DemSoPhanTuChan(array, n, i + 1, countEven);
}
// hoan vi phan tu
void HoanVi(int &a, int &b){
	int Tmp = a;
	a = b;
	b = Tmp;
}

// sap xep mang tang dan
void SapXepTangDan(int *array, int n, int i = 0){
	if(i == n - 1){
		return;
	}	
	for(int j = i + 1; j < n; j++){
		if(*(array + j) < *(array + i)){
			HoanVi(*(array + i), *(array + j)); // hoan vi phan tu
		}
	}
	SapXepTangDan(array, n, i + 1);
}

// sap xep mang giam dan
void SapXepGiamDan(int *array, int n, int i = 0){
	if(i == n - 1){
		return;
	}	
	for(int j = i + 1; j < n; j++){
		if(*(array + j) > *(array + i)){
			HoanVi(*(array + i), *(array + j)); // hoan vi phan tu
		}
	}
	SapXepGiamDan(array, n, i + 1);
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
	int *array = (int *)realloc(0, sizeof(int *) * n);
	
	NhapMang(array, n);
	
	SapXepGiamDan(array, n);
	
	XuatMang(array, n);
	// giai phong mang a
	free(array);
	return 0;
}
