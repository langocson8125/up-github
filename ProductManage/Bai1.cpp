#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "time.h"
#include "ctype.h"

// khoi tao doi tuong sinh vien
struct SinhVien{
	char name[255];
	int age;
	char className[5];
};

// detail
SinhVien TaoSinhVien(){
	SinhVien sinhVienDaTao;
	printf("Nhap thong tin sinh vien\n");
	fflush(stdin);
	printf("Ho va Ten:");
	gets(sinhVienDaTao.name);
	
	do{
		printf("Tuoi:");
		scanf("%d", &sinhVienDaTao.age);
		fflush(stdin);
		if(sinhVienDaTao.age <= 0){ // sinh vien phai tren 18 tuoi
			printf("\nNhap sai");
		}
	}
	while(sinhVienDaTao.age <= 0);

	printf("Lop:");
	gets(sinhVienDaTao.className);
	return sinhVienDaTao; // tra ve sinh vien do
}

// khoi tao danh sach sinh vien
void KhoiTaoDanhSachSinhVien(SinhVien *&array, int n){
	for(int i = 0; i < n; i++){
		*(array + i) = TaoSinhVien();
	}	
}

// hien thi danh sach dinh vien
void HienThiDanhSachSinhVien(SinhVien *array, int n){
	printf("Danh sach sinh vien\n");
	for(int i = 0; i < n; i++){
		printf("--------------------------------------------------------\n");
		printf("Ho va Ten: %s | ", (array + i)->name);
		printf("Tuoi: %d | ", (array + i)->age);
		printf("Lop: %s\n", (array + i)->className);
	}	
}

// tim sinh vien theo ten
SinhVien * TimSinhVienTheoTen(SinhVien *array, int n, char *search){
	for(int i = 0; i <= n/2; i++){	
		if(strcmp((array + i)->name, search) == 0){
			return (array + i);
		}
		else if(strcmp((array + n - 1 - i)->name, search) == 0){
			return (array + n - 1 - i);
		}
	}
	return NULL;
}

int main(){
	SinhVien *danhSachSinhVien;
	int n;
	
	// khoi tao menu
	int choise;
	do{
		printf("Menu:\n");
		printf("Chon 1 de Nhap danh sach sinh vien\n");
		printf("Chon 2 de Hien thi danh sach sinh vien\n");
		printf("Chon 3 de Tim kiem sinh vien theo ten\n");
		printf("Chon 4 de Ket thuc\n");
		scanf("%d", &choise);
		if(choise < 0 || choise > 4){
			system("cls");
		}
		else{
			switch(choise){
				case 1:
					// tao danh sach
					do{
						printf("\nNhap so sinh vien: ");
						scanf("%d", &n);
						if(n < 0){
							printf("\nNhap sai!!!.\n");
						}
					}
					while(n <= 0);
					danhSachSinhVien = (SinhVien *)malloc(n * sizeof(SinhVien));
					KhoiTaoDanhSachSinhVien(danhSachSinhVien, n);
					break;
				case 2:
					// hien thi danh sach
					if(n > 0){
						HienThiDanhSachSinhVien(danhSachSinhVien, n);
					}
					else{
						printf("Khong co sinh vien nao\n");
					}
					break;
				case 3:
					// tim kiem theo ten
					if(n > 0){
						char search[255];
						fflush(stdin);
						printf("Nhap ten can tim kiem:");
						gets(search);
						SinhVien *result = TimSinhVienTheoTen(danhSachSinhVien, n, search);
						// neu tim duoc thi hien thi sinh vien do ra
						if(result != NULL){
							HienThiDanhSachSinhVien(result, 1);
						}
					}
					else{
						printf("Khong co sinh vien nao\n");
					}
					break;
				case 4:
					printf("Chuong trinh ket thuc");
					break;
			}
		}
	}
	while(choise != 4);
	free(danhSachSinhVien); // giai phong bo nho
	return 0;
}
