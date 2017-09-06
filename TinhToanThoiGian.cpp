#include "stdio.h"
#include "stdlib.h"

int main(){
	int soGiayNhap, soGiay, soPhut, soGio;
	printf("Nhap so giay: ");
	scanf("%d",&soGiayNhap);
	soGiay = soGiayNhap % 60;
	soPhut = soGiayNhap / 60;
	soGio = soPhut / 60;
	soPhut = soPhut % 60;
	printf("Ket qua: %d giay = %d Gio %d Phut %d Giay",soGiayNhap, soGio, soPhut, soGiay);
	return 0;
}
