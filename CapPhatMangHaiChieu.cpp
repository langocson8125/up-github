#include "stdio.h"
#include "stdlib.h"
#include "conio.h"
#include "math.h"
#include "limits.h"

//THAO TÁC ĐỆ QUY TRÊN MẢNG HAI CHIỀU CÓ SỬ DỤNG CON TRỎ
// Lỗi xảy ra: tràn bộ nhớ

// hàm cấp phát động mảng hai chiều
void CapPhat(int **array, int dong, int cot){
	array = (int **)realloc(0, sizeof(int *) * dong);
	// cấp phát số dòng (tương đương mỗi ô nhớ)
	
	for(int i = 0; i < dong; i++){ // cấp phát số cột
		array[i] = (int *)realloc(array[i], sizeof(int) * cot);
	}
}

int main(){
	int dong, cot; // input dòng và cột
	do{
		printf("\nNhap so dong, so cot cua mang: ");
		scanf("%d %d", &dong, &cot);
		printf("%d %d", dong, cot);
		if(dong < 0 || cot < 0){
			printf("\nNhap sai, nhap lai.");
		}
	}
	while(dong < 0 || (dong > 0 && cot < 0));
	
	// khai báo con trỏ cấp 2
	int **array;
	CapPhat(array, dong, cot);  // thực hiện hàm cấp phát
	
	// giải phóng mảng sau khi sử dụng
	free(array);
	return 0;
}