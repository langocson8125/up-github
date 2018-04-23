#include "stdio.h"
#include "stdlib.h"
#include "conio.h"
#include "time.h"
#include "limits.h"

void TaoMang(int *&a, int n){
	time_t t;
	/* Intializes random number generator */
    srand((unsigned) time(&t));
    for(int i = 0; i < n; i++){
    	/* generate random number between 0 and 50: rand() % 50*/
    	*(a + i) = rand() % 10;
    	/* if you wanna generate secret number between 1 and 100: rand() % 100 + 1*/
    	/* if you wanna generate secret number between 1998 and 2018: rand() % 20 + 1998*/
	}
}

void XuatMang(int *a, int n){
	for(int i = 0; i < n; i++){
		printf("%4d", *(a + i));
	}
}

int PhanTuNhoNhat(int *a, int n){
	int min = *(a);
	for(int i = 1; i < n; i++){
		if(*(a + i) < min){
			min = *(a + i);
		}
	}
	return min;
}

int PhanTuLonNhat(int *a, int n){
	int max = *(a);
	for(int i = 1; i < n; i++){
		if(*(a + i) > max){
			max = *(a + i);
		}
	}
	return max;
}

int KiemTraPhanTu(int *a,int n, int element){
	for(int i = 0; i < n; i++){
		if(element == *(a + i)){
			return 1;
		}
	}	
	return 0;
}

int ViTriPhanTu(int *a, int n, int element){
	for(int i = 0; i < n; i++){
		if(element == *(a + i)){
			return i;
		}
	}
}

int KiemTraMangTang(int *a, int n){
	for(int i = 0; i < n; i++){
		if(*(a + i + 1) <= *(a + i)){
			return 0;
		}
	}
	return 1;
}

// Them phan tu vao vi tri dau tien cua mang
void ThemPhanTuDauMang(int *&a, int &n, int PhanTuThem){
	realloc(a, (n + 1) * sizeof(int *)); // tang bo nho them 1 o
	for(int i = n; i > 0; i--){
		*(a + i) = *(a + (i - 1));
	}
	*(a) = PhanTuThem;
	n++; // tang kich thuoc cua mang len
}

// Them phan tu vao vi tri bat ki trong mang
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

// thay the phan tu
void ThayThePhanTu(int *&a, int n, int element, int replace){
	for(int i = 0; i < n; i++){
		if(element == *(a + i)){
			*(a + i) = replace;
		}
	}	
}

void ReverseArray(int *&a, int n){
	for(int i = 0; i < n / 2; i++){
		int tmp = *(a + i);
		*(a + i) = *(a + n - i - 1);
		*(a + n - i - 1) = tmp;
	}
}

int main(){
	int n;
	do{
		time_t t;
		/* Intializes random number generator */
    	srand((unsigned) time(&t));
		n = rand() % 10; // 20 la so phan tu toi da cua mang
	}
	while(n < 0);
	printf("Mang co %d phan tu: \n", n);	
	
	// cap phat so phan tu cua mang
	int *a = (int *)malloc(n * sizeof(int *));
	
	TaoMang(a, n);
	XuatMang(a, n);
	
	// phan tu can kiem tra
	int element = 5;
	
	if(KiemTraPhanTu(a, n, element) == 1){
		printf("\nVi tri phan tu: %d", ViTriPhanTu(a, n, element) + 1);
		// thay the phan tu
		int replace = 4;
		ThayThePhanTu(a, n, element, replace);
	}
	
	if(KiemTraMangTang(a, n) == 1){
		printf("\nMang tang nek");
	}
	
	ThemPhanTuDauMang(a, n, 10);
	// ThemPhanTu(a, n, 3, 10); // 3 la vi tri can them
	printf("\nMang sau khi them phan tu:\n");
	XuatMang(a, n);
	
	// lat nguoc mang
	ReverseArray(a, n);
	printf("\nMang sau khi lat nguoc:\n");
	XuatMang(a, n);
	
	// giai phong mang
	free(a);
	
	return 0;
}
