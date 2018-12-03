package Homework02;

import java.util.*;

/*
 * Bài 3
 * Trình quản lý giao dich
 * Giao dịch tiền tệ - Giao dịch vàng
 */

public class TrinhQuanLyGiaoDich {
	private List<GiaoDichTienTe> listGiaoDichTienTe = new ArrayList<GiaoDichTienTe>();
	private List<GiaoDichVang> listGiaoDichVang = new ArrayList<GiaoDichVang>();
	private Scanner sc = new Scanner(System.in);

	public GiaoDichTienTe initGiaoDichTienTe() {
		System.out.println("Nhap thong tin giao dich tien te: ");
		
		String maGiaoDich;
		System.out.println("Nhap ma giao dich:");
		maGiaoDich = sc.nextLine();
		
		String ngayGiaoDich;
		System.out.println("Nhap ngay giao dich(dd/mm/yyyy):");
		ngayGiaoDich = sc.nextLine();
		
		float donGia;
		System.out.println("Nhap don gia:");
		donGia = sc.nextFloat();
		
		int soLuong;
		System.out.println("Nhap so luong:");
		soLuong = sc.nextInt();
		
		float tiGia;
		System.out.println("Nhap ti gia:");
		tiGia = sc.nextFloat();

		String loaiTienTe;
		System.out.println("Nhap loai vang");
		loaiTienTe = sc.nextLine();
		
		return new GiaoDichTienTe(maGiaoDich, ngayGiaoDich, donGia, soLuong, tiGia, loaiTienTe);
	}
	
	public GiaoDichVang initGiaoDichVang() {
		System.out.println("Nhap thong tin giao dich vang: ");
		
		String maGiaoDich;
		System.out.println("Nhap ma giao dich:");
		maGiaoDich = sc.nextLine();
		
		String ngayGiaoDich;
		System.out.println("Nhap ngay giao dich(dd/mm/yyyy):");
		ngayGiaoDich = sc.nextLine();
		
		float donGia;
		System.out.println("Nhap don gia:");
		donGia = sc.nextFloat();
		
		int soLuong;
		System.out.println("Nhap so luong:");
		soLuong = sc.nextInt();

		String loaiVang;
		System.out.println("Nhap loai vang");
		loaiVang = sc.nextLine();
		
		return new GiaoDichVang(maGiaoDich, ngayGiaoDich, donGia, soLuong, loaiVang);
	}
	
	public void NhapGiaoDichTienTe() {
		String choice;
		do {
			GiaoDichTienTe giaoDichTienTe = this.initGiaoDichTienTe();
			
			this.listGiaoDichTienTe.add(giaoDichTienTe);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void NhapGiaoDichVang() {
		String choice;
		do {
			GiaoDichVang giaoDichVang = this.initGiaoDichVang();
			
			this.listGiaoDichVang.add(giaoDichVang);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void XuatGiaoDichTienTe() {
		if(this.listGiaoDichTienTe.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (GiaoDichTienTe GDTT :  this.listGiaoDichTienTe) {
	        	System.out.println(GDTT.toString());
	        }
		}
	}
	
	public void XuatGiaoDichVang() {
		if(this.listGiaoDichVang.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (GiaoDichVang GDV :  this.listGiaoDichVang) {
	        	System.out.println(GDV.toString());
	        }
		}
	}
	
	public int TongSoLuongGiaoDichTienTe() {
		int result = 0;
		if(this.listGiaoDichTienTe.isEmpty() ) {
			return result;
		}
		else {
	        for (GiaoDichTienTe GDTT :  this.listGiaoDichTienTe) {
	        	result += GDTT.getSoLuong();
	        }
	        return result;
		}
	}
	
	public int TongSoLuongGiaoDichVang() {
		int result = 0;
		if(this.listGiaoDichVang.isEmpty() ) {
			return result;
		}
		else {
	        for (GiaoDichVang GDV :  this.listGiaoDichVang) {
	        	result += GDV.getSoLuong();
	        }
	        return result;
		}
	}
	
	public float trungBinhCongThanhTienGiaoDichTienTe() {
		float result = 0.0f;
		if(this.listGiaoDichTienTe.isEmpty() ) {
			return result;
		}
		else {
	        for (GiaoDichTienTe GDTT :  this.listGiaoDichTienTe) {
	        	result += GDTT.getThanhTien();
	        }
	        return result/(this.listGiaoDichTienTe.size());
		}
	}
	
	public float trungBinhCongThanhTienGiaoDichVang() {
		float result = 0.0f;
		if(this.listGiaoDichVang.isEmpty() ) {
			return result;
		}
		else {
	        for (GiaoDichVang GDV :  this.listGiaoDichVang) {
	        	result += GDV.getThanhTien();
	        }
	        return result/(this.listGiaoDichTienTe.size());
		}
	}
	
	public void XuatGiaoDichTienTeTren1Ty() {
		if(this.listGiaoDichTienTe.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			int countResult = 0;
	        for (GiaoDichTienTe GDTT :  this.listGiaoDichTienTe) {
	        	if(GDTT.getDonGia() > 1000000000) {
	        		countResult++;
	        		System.out.println(GDTT.toString());
	        	}
	        }
	        if(countResult == 0) {
	        	System.out.println("Khong co");
	        }
		}
	}
	
	public void XuatGiaoDichVangTren1Ty() {
		if(this.listGiaoDichVang.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			int countResult = 0;
	        for (GiaoDichVang GDV :  this.listGiaoDichVang) {
	        	if(GDV.getDonGia() > 1000000000) {
	        		countResult++;
	        		System.out.println(GDV.toString());
	        	}
	        }
	        if(countResult == 0) {
	        	System.out.println("Khong co");
	        }
		}
	}
}
