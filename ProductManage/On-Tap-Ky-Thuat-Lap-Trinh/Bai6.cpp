#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "time.h"
#include "ctype.h"

struct Sach{
	int ma;
	char ten[100];
	char tacgia[100];
	int maNXB;
};

Sach TaoSach(){
	Sach sachDuocTao;
	printf("Nhap thong tin sach\n");	

	do{
		printf("Ma sach:");
		scanf("%d", &sachDuocTao.ma);
		if(sachDuocTao.ma <= 0){ 
			printf("\nNhap sai");
		}
	}
	while(sachDuocTao.ma <= 0);
	fflush(stdin);
	printf("Ten sach:");
	gets(sachDuocTao.ten);
	fflush(stdin);
	printf("Ten tac gia:");
	gets(sachDuocTao.tacgia);	
	fflush(stdin);
	
	do{
		printf("Ma NXB:");
		scanf("%d", &sachDuocTao.maNXB);
		if(sachDuocTao.maNXB <= 0){
			printf("\nNhap sai");
		}
	}
	while(sachDuocTao.maNXB <= 0);
	return sachDuocTao; 
}


void KhoiTaoDanhSach(Sach *&array, int n){
	for(int i = 0; i < n; i++){
		*(array + i) = TaoSach();
	}	
}

// hien thi danh sach dinh vien
void HienThiDanhSach(Sach *array, int n){
	printf("Danh sach cuon sach: \n");
	for(int i = 0; i < n; i++){
		printf("--------------------------------------------------------\n");
		printf("Ma: %d | ", (array + i)->ma);
		printf("Ten: %s | ", (array + i)->ten);
		printf("Tac gia: %s", (array + i)->tacgia);
		printf("Ma NXB: %d\n", (array + i)->maNXB);
	}	
}

void AddElement(Sach *&Array, int count, Sach element){
	realloc(Array, count * sizeof(Sach *));
	*(Array + count - 1) = element;
}

Sach * TimSachTheoNXB(Sach *array, int n, int search, int &soSachTimDuoc){
	int count = 0;
	Sach * tmpArray;
	tmpArray = (Sach *)malloc(1 * sizeof(Sach));
	if(n % 2 == 0){
		n = n / 2 - 1;
	}
	else{
		n = n / 2;
	}
	for(int i = 0; i <= n; i++){
		if ((i == (n - i - 1)) && ((array + i)->maNXB == search)){
			count++;
			AddElement(tmpArray, count, *(array + i));
		}
		else{
			if((array + i)->maNXB == search){
				count++;
				AddElement(tmpArray, count, *(array + i));
			}
			else if((array + n - 1 - i)->maNXB == search){
				count++;
				AddElement(tmpArray, count, *(array + n - 1 - i));
			}
		}
	}
	soSachTimDuoc = count;
	if(count <= 0){
		free(tmpArray);
		return NULL;
	}
	else{
		return tmpArray;
	}
}

int main(){
	Sach  *danhSach;
	int soSachTimDuoc = 0;
	int n;
	
	int choise;
	do{
		printf("Menu:\n");
		printf("Chon 1 de Tao danh muc sach\n");
		printf("Chon 2 de Hien thi cac sach cung nha xuat ban\n");
		printf("Chon 3 de Ket thuc\n");
		scanf("%d", &choise);
		if(choise < 0 || choise > 3){
			system("cls");
		}
		else{
			switch(choise){
				case 1:
					// tao danh sach
					do{
						printf("\nNhap so cuon sach: ");
						scanf("%d", &n);
						if(n < 0){
							printf("\nNhap sai!!!.\n");
						}
					}
					while(n <= 0);
					danhSach = (Sach *)malloc(n * sizeof(Sach));
					KhoiTaoDanhSach(danhSach, n);
					break;
				case 2:
					if(n > 0){
						printf("\nNhap ma NXB: ");
						int maNXB_cantim;
						scanf("%d", &maNXB_cantim);
						Sach *result = TimSachTheoNXB(danhSach, n, maNXB_cantim, soSachTimDuoc);
						if(result != NULL){
							HienThiDanhSach(result, soSachTimDuoc);
						}
					}
					else{
						printf("Khong co sinh vien nao\n");
					}
					break;
				case 3:
					printf("Chuong trinh ket thuc");
					break;
			}
		}
	}
	while(choise != 4);
	free(danhSach); // giai phong bo nho
	return 0;
}
