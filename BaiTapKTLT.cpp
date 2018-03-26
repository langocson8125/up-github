#include "stdio.h"
#include "stdlib.h"
#include "conio.h"

/*
	hàm tính tổng các số từ 1 đến n
	tham số: n 
	trả về: kết quả sau khi tính tổng
*/
int TongCacSo(int n, int x = 1){
	if(n == 1){
		return x;
	}
	return TongCacSo(n - 1, x + n);
}

/*
	hàm tính tổng bình phương các số từ 1 đén n
	tham số: n
	trả về: kết quả sau khi tính tổng
*/
int TongBinhPhuong(int n, int x = 1){
	if(n == 1){
		return x;
	}
	return TongBinhPhuong(n - 1, x + n*n);
}

/*
	hàm tính tổng phân số: 1 + 1/2 + ... + 1/n
	tham số: n
	trả về: kết quả sau khi tính tổng
*/
float TongPhanSo(int n, float x = 1){
	if(n == 1){
		return x;
	}
	return TongPhanSo(n - 1, x + 1.0/n);
}

/*
	hàm tính giai thừa của n
	tham số: n
	trả về: kết quả sau khi tính giai thừa
*/
int GiaiThua(int n, int x = 1){
	if(n == 1){
		return x;
	}
	return GiaiThua(n - 1, x * n);
}

/*
	hàm tính tổng giai thừa của từ 1 đến n
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
	hàm tìm ước chung lớn nhất của 2 số
	tham số: số thứ nhất, số thứ hai
	trả về: ước chung lớn nhất của hai số
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
	hàm in ra các phần tử của mảng
	tham số: mảng cần in, số phần tử cần in
*/
void XuatMang(int *a, int n){
	for(int i = 0; i < n; i++){
		printf("%4d", *(a + i));
	}
}

/*
	xuất ra n phần tử đầu của dãy fibonacy
	tham số truyền vào: mảng chứa các số đó, số phần tử cần in ra
*/
void Fibonacy(int *a, int n){
	*(a) = *(a + 1) = 1;
	for(int i = 2; i < n; i++){
    	*(a + i) = *(a + i - 1) + *(a + i - 2);
    }
    XuatMang(a, n);
}

int main(){
	// nhập giá trị n
	int n;
	do{
		printf("Nhap n: ");
		scanf("%d", &n);
		if(n < 0){
			printf("\nNhap sai, nhap lai");
		}
	}
	while(n < 0);
	
	// cấp phát động số phần tử của mảng
	int *a = (int *)realloc(0,  n * sizeof(int *));
	Fibonacy(a, n);
	
	// giải phóng mảng
	free(a);
	return 0;
}
