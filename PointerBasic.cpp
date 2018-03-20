#include "stdio.h"
#include "conio.h"
#include "stdlib.h"

// Nhập mảng
void NhapMang(int *a, int n){
	for(int i = 0; i < n; i++){
		printf("Nhap phan tu a[%d] ", i + 1);
		scanf("%d", a + i);
	}
}

// Xuất mảng
void XuatMang(int *a, int n){
	for(int i = 0; i < n; i++){
		printf("%4d", *(a + i));
	}
}

// Thêm phần tử vào mảng
void ThemPhanTu(int *&a, int &n, int ViTriThem, int PhanTuThem){
	realloc(a, (n + 1) * sizeof(int *)); // tăng thêm một ô nhớ
	for(int i = n; i >= ViTriThem; i--){
		*(a + i) = *(a + (i - 1));
	}
	*(a + (ViTriThem - 1)) = PhanTuThem;
	n++; // tăng kích thước của mảng lên
}

// Xóa phần tử 
void XoaPhanTu(int *&a, int &n, int ViTriXoa){
	for(int i = ViTriXoa - 1; i < n - 1; i++){
		*(a + i) = *(a + (i + 1));
	}
	n--; // giảm kích thước của mảng xuống
	realloc(a, n * sizeof(int *)); // giảm bộ nhớ xuống 1 ô
}

int main(){
	printf("------------------Them/xoa phan tu cua mang--------------------");
	int n;
	do{
		printf("\nNhap so phan tu cua mang: ");
		scanf("%d", &n);
		if(n < 0){
			printf("\nNhap sai, nhap lai.");
		}
	}
	while(n < 0);
	
	// Cấp phát số phần tử của mảng
	int *a = (int *)realloc(0,  n * sizeof(int *));
	
	NhapMang(a, n);
	printf("\nMang ban dau: ");
	XuatMang(a, n);
	
	printf("\n--------------------------------------------------------------");
	
	// ----------------- Thêm phần tử -----------------------
	int ViTriThem, PhanTuThem;
	
	// vị trí từ 1 --> n
	do{
		printf("\nNhap vao vi tri can them (%d ---> %d): ", 1, n);
		scanf("%d", &ViTriThem);
		if(ViTriThem < 0 || ViTriThem > n - 1){
			printf("\nNhap sai vi tri them , nhap lai.");
		}
	}
	while(ViTriThem < 0 || ViTriThem > n);
	
	printf("\nNhap phan tu can them: ");
	scanf("%d", &PhanTuThem);
	
	ThemPhanTu(a, n, ViTriThem, PhanTuThem);
	printf("\nMang sau khi them: ");
	XuatMang(a, n);
	
	printf("\n--------------------------------------------------------------");
	
	// -------------------- Xóa phần tử -----------------------
	int ViTriXoa;
	
	// vị trí từ 1 --> n
	do{
		printf("\nNhap vao vi tri can xoa (%d ---> %d): ", 1, n);
		scanf("%d", &ViTriXoa);
		if(ViTriXoa < 0 || ViTriXoa > n){
			printf("\nNhap sai vi tri xoa , nhap lai.");
		}
	}
	while(ViTriXoa < 0 || ViTriXoa > n);
		
	XoaPhanTu(a, n, ViTriXoa);
	printf("\nMang sau khi xoa: ");
	XuatMang(a, n);
	
	printf("%d", *(a + n)); 
	// --------------------- Giải phóng ô nhớ -----------------------
	free(a);
	return 0;
}
