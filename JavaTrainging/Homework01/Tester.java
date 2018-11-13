package Homework01;
import java.text.*;
import java.util.*;

public class Tester {
	public static void main(String[] args) throws ParseException {
		// Cau 1
		//TestHinhChuNhat();
		// Cau 2
		//TestSinhVien();
		// Cau 3
		//testVehicle();
		// Cau 4
		//testAccount();
		// Cau 5
		//testRational();
		// Cau 6
		//testHangThucPham();
		// Cau 7
		//testSinhVien2();
		// cau 8
		testCDManager();
	}
	
	public static void TestHinhChuNhat() {
		HinhChuNhat HCN = new HinhChuNhat();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Chieu dai:");
		HCN.setChieuDai(sc.nextInt());
		System.out.println("Chieu rong:");
		HCN.setChieuRong(sc.nextInt());
		
		System.out.println(HCN.toString());
	}
	
	public static void TestSinhVien() {
		SinhVien SV1 = new SinhVien(1, "La Ngoc Son", 9, 10);
		SinhVien SV2 = new SinhVien(2, "Nguyen Nhu Ngoc", 8, 9);
		SinhVien SV3 = new SinhVien();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma sinh vien: ");
		SV3.setMaSinhVien(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhap ten sinh vien");
		SV3.setHoTen(sc.nextLine());
		System.out.println("Nhap diem ly thuyet");
		SV3.setDiemLyThuyet(sc.nextFloat()); 
		System.out.println("Nhap diem thuc hanh");
		SV3.setDiemThucHanh(sc.nextFloat());
		
		SV1.toStrings();
		SV2.toStrings();
		SV3.toStrings();
		
		sc.close();
	}
	
	public static void testVehicle() {
		int choose;
		Vehicle xe1 = null;
		Vehicle xe2 = null;
		Vehicle xe3 = null;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Chon chuc nang");
			System.out.println("1. Nhap thong tin va tao cac doi tuong");
			System.out.println("2. Xuat bang ke khai tien thue truoc ba cua cac xe");
			System.out.println("3. Thoat");
			System.out.println("----------------------------------------------------");
			choose = sc.nextInt();
			if(choose == 1) {
				System.out.println("Nhap thong tin xe 1");
				System.out.println("Nhap ten chu xe");
				sc.nextLine();
				String tenChuXe = sc.nextLine();
				System.out.println("Nhap loai xe");
				String loaiXe 	= sc.nextLine();
				System.out.println("Nhap dung tich xe");
				int dungTich	= sc.nextInt();
				System.out.println("Nhap gia tri xe");
				float triGia	= sc.nextFloat();
				xe1 = new Vehicle(tenChuXe, loaiXe, dungTich, triGia);
				
				System.out.println("Nhap thong tin xe 2");
				System.out.println("Nhap ten chu xe");
				sc.nextLine();
				tenChuXe 	= sc.nextLine();
				System.out.println("Nhap loai xe");
				loaiXe 		= sc.nextLine();
				System.out.println("Nhap dung tich xe");
				dungTich	= sc.nextInt();
				System.out.println("Nhap gia tri xe");
				triGia		= sc.nextFloat();
				xe2 = new Vehicle(tenChuXe, loaiXe, dungTich, triGia);
				
				System.out.println("Nhap thong tin xe 3");
				System.out.println("Nhap ten chu xe");
				sc.nextLine();
				tenChuXe 	= sc.nextLine();
				System.out.println("Nhap loai xe");
				loaiXe 		= sc.nextLine();
				System.out.println("Nhap dung tich xe");
				dungTich	= sc.nextInt();
				System.out.println("Nhap gia tri xe");
				triGia		= sc.nextFloat();
				xe3 = new Vehicle(tenChuXe, loaiXe, dungTich, triGia);
				
			}
			else if(choose == 2) {
				System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "Ten chu xe", "Loai xe", "Dung tich", "Tri gia", "Thue phai nop");
				xe1.toStrings();
				xe2.toStrings();
				xe3.toStrings();
			}
			else if(choose == 3) {
				System.out.println("Bye!!");
				break;
			}
			else {
				System.out.println("Xin loi, khong co chuc nang nay");
			}
			
		}
		while(choose > 0 || choose < 3);
		sc.close();
	}
	
	public static void testAccount() {
		Account myAccount = new Account();
		myAccount.setSoTaiKhoan(12345);
		myAccount.setTenTaiKhoan("Timo Bank");
		myAccount.setSoTienTrongTaiKhoan(123456789);
		System.out.println(myAccount.toString());
	}
	
	public static void testRational() {
		Rational myRational = new Rational(9, 15);
		System.out.println(myRational.toString());
		myRational.devide(7, 8);
		System.out.println(myRational.toString());
	}
	
	public static void testHangThucPham() throws ParseException {
		HangThucPham myThucPham = new HangThucPham(123, "rau qua", 100, "10-02-2017", "10-02-2018");
		System.out.println(myThucPham.toString());
	}
	
	public static void testSinhVien2() {
		SinhVien2Manager SVmanager= new SinhVien2Manager();
		SVmanager.initDanhSachSinhVien();
		SVmanager.sortDanhSachSinhVien();
		SVmanager.showDanhSachSinhVien();
	}
	
	
	public static void testCDManager() {	
		CD_Manager CDman = new CD_Manager();
		for(int i = 0; i < 3; i++) {
			CD myCD = CDman.initCDObject();
			CDman.addCD(myCD);
		}
		System.out.println("Tong so CD:" + CDman.countCD());
		System.out.println("Tong gia thanh cac CD:" + CDman.tongGiaThanhCD());
		
		CDman.sapXepDanhSachCDTheoGiaThanh();
		CDman.hienThiDanhSachCD();
		CDman.sapXepDanhSachCDTheoTuaCD();
		CDman.hienThiDanhSachCD();
	}
}
