package Homework02;

import java.util.*;

/*
 * Bài 2
 * Trình quản lý sách
 * Sách giáo khoa - Sách tham khảo
 */

public class TrinhQuanLySach {
	private List<SachGiaoKhoa> listSachGiaoKhoa = new ArrayList<SachGiaoKhoa>();
	private List<SachThamKhao> listSachThamKhao = new ArrayList<SachThamKhao>();
	private Scanner sc = new Scanner(System.in);

	public SachGiaoKhoa initSachGiaoKhoa() {
		System.out.println("Nhap thong tin sach giao khoa: ");
		
		String maSach;
		System.out.println("Nhap ma sach:");
		maSach = sc.nextLine();
		
		String ngayNhapSach;
		System.out.println("Nhap ngay nhap sach(dd/mm/yyyy):");
		ngayNhapSach = sc.nextLine();
		
		float donGia;
		System.out.println("Nhap don gia:");
		donGia = sc.nextFloat();
		
		int soLuong;
		System.out.println("Nhap so luong:");
		soLuong = sc.nextInt();
		
		String nhaXuatBan;
		System.out.println("Nhap nha xuat ban :");
		nhaXuatBan = sc.nextLine();
		
		String tinhTrang;
		System.out.println("Nhap tinh trang:");
		tinhTrang = sc.nextLine();

		return new SachGiaoKhoa(maSach, ngayNhapSach, donGia, soLuong, nhaXuatBan, tinhTrang);
	}
	
	public SachThamKhao initSachThamKhao() {
		System.out.println("Nhap thong tin sach tham khao: ");
		
		String maSach;
		System.out.println("Nhap ma sach:");
		maSach = sc.nextLine();
		
		String ngayNhapSach;
		System.out.println("Nhap ngay nhap sach(dd/mm/yyyy):");
		ngayNhapSach = sc.nextLine();
		
		float donGia;
		System.out.println("Nhap don gia:");
		donGia = sc.nextFloat();
		
		int soLuong;
		System.out.println("Nhap so luong:");
		soLuong = sc.nextInt();
		
		String nhaXuatBan;
		System.out.println("Nhap nha xuat ban :");
		nhaXuatBan = sc.nextLine();
		
		float thue;
		System.out.println("Nhap thua:");
		thue = sc.nextFloat();

		return new SachThamKhao(maSach, ngayNhapSach, donGia, soLuong, nhaXuatBan, thue);
	}
	
	public void NhapSachGiaoKhoa() {
		String choice;
		do {
			SachGiaoKhoa sachGiaoKhoa = this.initSachGiaoKhoa();
			
			this.listSachGiaoKhoa.add(sachGiaoKhoa);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void NhapSachThamKhao() {
		String choice;
		do {
			SachThamKhao sachThamKhao = this.initSachThamKhao();
			
			this.listSachThamKhao.add(sachThamKhao);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void XuatSachGiaoKhoa() {
		if(this.listSachGiaoKhoa.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (SachGiaoKhoa sachGK :  this.listSachGiaoKhoa) {
	        	System.out.println(sachGK.toString());
	        }
		}
	}
	
	public void XuatSachThamKhao() {
		if(this.listSachThamKhao.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (SachThamKhao sachTK :  this.listSachThamKhao) {
	        	System.out.println(sachTK.toString());
	        }
		}
	}
	
	public float TongThanhTienSachGiaoKhoa() {
		float thanhTien = 0.0f;
		if(this.listSachGiaoKhoa.isEmpty() ) {
			return thanhTien;
		}
		else {
	        for (SachGiaoKhoa sachGK :  this.listSachGiaoKhoa) {
	        	thanhTien += sachGK.getThanhTien();
	        }
	        return thanhTien;
		}
	}

	public float TongThanhTienSachThamKhao() {
		float thanhTien = 0.0f;
		if(this.listSachThamKhao.isEmpty() ) {
			return thanhTien;
		}
		else {
	        for (SachThamKhao sachTK :  this.listSachThamKhao) {
	        	thanhTien += sachTK.getThanhTien();
	        }
	        return thanhTien;
		}
	}
	
	public float trungBinhCongDonGiaSachGiaoKhoa() {
		float result = 0.0f;
		if(this.listSachGiaoKhoa.isEmpty() ) {
			return result;
		}
		else {
	        for (SachGiaoKhoa sachGK :  this.listSachGiaoKhoa) {
	        	result += sachGK.getDonGia();
	        }
	        return result/(this.listSachGiaoKhoa.size());
		}
	}
	
	public float trungBinhCongDonGiaSachThamKhao() {
		float result = 0.0f;
		if(this.listSachThamKhao.isEmpty() ) {
			return result;
		}
		else {
	        for (SachThamKhao sachTK :  this.listSachThamKhao) {
	        	result += sachTK.getDonGia();
	        }
	        return result/(this.listSachThamKhao.size());
		}
	}
	
	public void XuatSachGiaoKhoaTheoNhaXuatBan(String nhaXuatBan) {
		if(this.listSachGiaoKhoa.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			int countResult = 0;
	        for (SachGiaoKhoa sachGK :  this.listSachGiaoKhoa) {
	        	if(sachGK.getNhaXuatBan() == nhaXuatBan) {
	        		countResult++;
	        		System.out.println(sachGK.toString());
	        	}
	        }
	        if(countResult == 0) {
	        	System.out.println("Khong tim thay");
	        }
		}
	}
	
	public void XuatSachThamKhaoTheoNhaXuatBan(String nhaXuatBan) {
		if(this.listSachThamKhao.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			int countResult = 0;
	        for (SachThamKhao sachTK :  this.listSachThamKhao) {
	        	if(sachTK.getNhaXuatBan() == nhaXuatBan) {
	        		countResult++;
	        		System.out.println(sachTK.toString());
	        	}
	        }
	        if(countResult == 0) {
	        	System.out.println("Khong tim thay");
	        }
		}
	}
}
