#include <stdio.h>
#include <stdlib.h>

struct infoSinhVien {
	char hoVaTen[50];
	char MSSV[10];
	struct monHoc {
		int toan;
		int ly;
		int hoa;
	}diemCacMon;
};
int main(){	
	int n = 5; //lop co 5 sinh vien
	struct infoSinhVien AT13M[30]; //khai bao mang kieu cau truc
	for(int i = 0; i < n; i++){
		#define sinhVien AT13M[i]
		printf("Nhap info SV%d",i+1);
		printf("\nHo va Ten:");
		gets(sinhVien.hoVaTen);
		printf("MSSV:");
		gets(sinhVien.MSSV);
		printf("Diem mon Toan Ly Hoa:");
		scanf("%d %d %d",&sinhVien.diemCacMon.toan,&sinhVien.diemCacMon.ly,&sinhVien.diemCacMon.hoa);
	}
	for(int i = 0; i< n; i++){
		#define sinhVien AT13M[i]
		printf("Thong tin sinh vien thu %d",i + 1);
		printf("\nHo vs Ten:%s ",sinhVien.hoVaTen);
		printf("\nMSSV: %s",sinhVien.MSSV);
		printf("Diem mon Toan:%d\tLy:%d\tHoa:%d",sinhVien.diemCacMon.toan,sinhVien.diemCacMon.ly,sinhVien.diemCacMon.hoa);
	}
	return 0;
}
