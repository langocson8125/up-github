#include "stdio.h"
#include "stdlib.h"
#include "conio.h"
#include "time.h"

// hàm tạo mảng với các giá trị ngẫu nhiên
// tham số: mảng cần tham chiếu, số phần tử của mảng
// return: void
void TaoMang(int *&a, int n){
    time_t t;
	/* Khởi tạo trình tạo số ngẫu nhiên */
    srand((unsigned) time(&t));
	// gán giá trị ngẫu nhiên cho từng phần tử
    for(int i = 0; i < n; i++){
    	
    	*(a + i) = rand() % 10;
	/* tạo số ngẫu nhên từ 0 đến 50: rand() % 50 */
    	/* tạo số ngẫu nhên từ 1 đến 100: rand() % 100 + 1 */
    	/* tạo số ngẫu nhên từ 1998 đến 2018: rand() % 20 + 1998 */
	}
}

// hàm xuất mảng 
// tham số: mảng cần xuất, số phần tử của mảng
// return: void
void XuatMang(int *a, int n){
	for(int i = 0; i < n; i++){
		printf("%4d", *(a + i));
	}
}

// hàm tìm phần tử nhở nhất trong mảng
// tham số: mảng, số phần tử của mảng
// return: giá trị nhỏ nhất của mảng
int PhanTuNhoNhat(int *a, int n){
	int min = *(a); // gán giá trị nhỏ nhất là phần tử đầu của mảng
	for(int i = 1; i < n; i++){ // duyệt qua mảng
		if(*(a + i) < min){ // kiểm tra
			min = *(a + i);
		}
	}
	return min;
}

// hàm tìm phần tử lớn nhất trong mảng
// tham số: mảng, số phần tử của mảng
// return: giá trị lớn nhất của mảng
int PhanTuLonNhat(int *a, int n){
	int max = *(a); // gán giá trị lớn nhất là phần tử đầu tiên của mảng
	for(int i = 1; i < n; i++){ // duyệt qua mảng
		if(*(a + i) > max){ // kiểm tra
			max = *(a + i);
		}
	}
	return max;
}

// hàm kiểm tra sự tồn tại của phần tử trong mảng
// tham số: mảng, số phần tử của mảng, phần tử cần kiểm tra
// return: 1 nếu tốn tại hoặc 0 nếu ko tồn tại
int KiemTraPhanTu(int *a,int n, int element){
	for(int i = 0; i < n; i++){
		if(element == *(a + i)){
			return 1;
		}
	}	
	return 0;
}

// hàm tìm vị trí của phần tử trong mảng
// tham số: mảng, số phần tử của mảng, phần tử cần tìm
// return: vị trí của phần tử trong mảng, i = {0, 1, 2, 3, ...., n}
int ViTriPhanTu(int *a, int n, int element){
	for(int i = 0; i < n; i++){
		if(element == *(a + i)){
			return i;
		}
	}
}

// hàm kiểm tra mảng có tăng hay ko
// tham số: mảng, số phần tử của mảng
// return: 1 nếu mảng đó tăng hoặc 0 nếu mảng đó ko tăng
int KiemTraMangTang(int *a, int n){
	for(int i = 0; i < n; i++){
		if(*(a + i + 1) <= *(a + i)){
			return 0;
		}
	}
	return 1;
}

// hàm thêm phần tử vào vị trí đầu tiên trong mảng
// tham số: mảng, số phần tử của mảng, phần tử cần thêm
// return: void
void ThemPhanTuDauMang(int *&a, int &n, int PhanTuThem){
	realloc(a, (n + 1) * sizeof(int *)); // tăng ô nhớ của mảng lên 1 ô
	for(int i = n; i > 0; i--){ // thực hiện thêm
		*(a + i) = *(a + (i - 1));
	}
	*(a) = PhanTuThem; // gán giá trị cho phần tử đầu
	n++; 
}

// hàm thêm phần tử vào vị trí bất kì trong mảng
// tham số: mảng, số phần tử của mảng, vị trí cần thêm, phần tử cần thêm
// return: void
void ThemPhanTu(int *&a, int &n, int ViTriThem, int PhanTuThem){
	realloc(a, (n + 1) * sizeof(int *)); // tăng ô nhớ của mảng lên 1 ô
	for(int i = n; i >= ViTriThem; i--){ // thực hiện thêm
		*(a + i) = *(a + (i - 1));
	}
	*(a + (ViTriThem - 1)) = PhanTuThem; // gán giá trị cho vị trí cần thêm
	n++;
}

// hàm xóa phần tử của mảng
// tham số: mảng, số phần tử của mảng, vị trí cần xóa
// return: void
void XoaPhanTu(int *&a, int &n, int ViTriXoa){
	for(int i = ViTriXoa - 1; i < n - 1; i++){
		*(a + i) = *(a + (i + 1));
	}
	
	n--; 
	realloc(a, n * sizeof(int *)); // giảm ô nhớ của mảng lên 1 ô
}

// hàm thay thế phần tử của mảng
// tham số: mảng, số phần tử của mảng, phần tử cần thay, giá trị mới
// return: void
void ThayThePhanTu(int *&a, int n, int element, int replace){
	for(int i = 0; i < n; i++){ // thực hiện thay
		if(element == *(a + i)){
			*(a + i) = replace;
		}
	}	
}

// hàm lật ngược mảng
// tham số: mảng, số phần tử của mảng
// return: void
void ReverseArray(int *&a, int n){
	for(int i = 0; i < n / 2; i++){
		int tmp = *(a + i);
		*(a + i) = *(a + n - i - 1);
		*(a + n - i - 1) = tmp;
	}
}

int main(){
	int n;
	
	// thực hiện việc tạo số phần tử của mảng một cách ngẫu nhiên
	do{
		time_t t;
		/* khởi tạo trình tạo số ngẫu nhiên */
    		srand((unsigned) time(&t));
		n = rand() % 20; // 20 là số phần tử tối đa của mảng
	}
	while(n < 0);
	
	printf("Mang co %d phan tu: \n", n);	
	
	// cấp phát động số phần tử cho mảng
	int *a = (int *)malloc(n * sizeof(int *));
	
	TaoMang(a, n);
	XuatMang(a, n);
	
	// phần tử cần kiểm tra
	int element = 5;
	
	// kiểm tra sự tồn tại của phần tử
	if(KiemTraPhanTu(a, n, element) == 1){
		printf("\nVi tri phan tu: %d", ViTriPhanTu(a, n, element) + 1);
		// thay thế phần tử
		int replace = 4;
		ThayThePhanTu(a, n, element, replace);
	}
	
	// kiểm tra mảng tăng hay ko
	if(KiemTraMangTang(a, n) == 1){
		printf("\nMang tang nek");
	}
	// thêm phần tử vào đầu mảng
	ThemPhanTuDauMang(a, n, 10);
	// ThemPhanTu(a, n, 3, 10); // 3 là vị trí cần thêm
	printf("\nMang sau khi them phan tu:\n");
	XuatMang(a, n);
	
	// lật ngược mảng 
	ReverseArray(a, n);
	printf("\nMang sau khi lat nguoc:\n");
	XuatMang(a, n);
	
	// giải phóng các ô nhớ trong mảng
	free(a);
	
	return 0;
}
