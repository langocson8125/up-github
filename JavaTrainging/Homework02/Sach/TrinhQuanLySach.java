package Homework02.Sach;

import java.util.*;

import Homework02.TienDien.HoaDonTienDienVietNam;

/*
 * Bài 2
 * Trình quản lý sách
 * Sách giáo khoa - Sách tham khảo
 */

public class TrinhQuanLySach {
	private List<SachGiaoKhoa> listSachGiaoKhoa = new ArrayList<SachGiaoKhoa>();
	private List<SachThamKhao> listSachThamKhao = new ArrayList<SachThamKhao>();
	
	public SachGiaoKhoa initSachGiaoKhoa() {
		System.out.println("Nhap thong tin sach giao khoa: ");
		Scanner sc = new Scanner(System.in);
		
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
		sc.nextLine();
		
		String tinhTrang;
		System.out.println("Nhap tinh trang:");
		tinhTrang = sc.nextLine();

		return new SachGiaoKhoa(maSach, ngayNhapSach, donGia, soLuong, nhaXuatBan, tinhTrang);
	}
	
	public SachThamKhao initSachThamKhao() {
		Scanner sc = new Scanner(System.in);
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
		sc.nextLine();
		
		float thue;
		System.out.println("Nhap thua:");
		thue = sc.nextFloat();

		return new SachThamKhao(maSach, ngayNhapSach, donGia, soLuong, nhaXuatBan, thue);
	}
	
	public boolean KiemTraTonTaiSachGiaoKhoa(SachGiaoKhoa obj) {
		if(listSachGiaoKhoa.contains(obj))
			return false;
		else 
			listSachGiaoKhoa.add(obj);
		return true;
	}
	
	public boolean KiemTraTonTaiSachThamKhao(SachThamKhao obj) {
		if(listSachThamKhao.contains(obj))
			return false;
		else 
			listSachThamKhao.add(obj);
		return true;
	}
	
	public void NhapSachGiaoKhoa() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			SachGiaoKhoa sachGiaoKhoa = this.initSachGiaoKhoa();
			
			if(this.KiemTraTonTaiSachGiaoKhoa(sachGiaoKhoa) == false) {
				System.out.println("Cuon sach nay da ton tai");
				System.out.println("Co muon nhap lai(Y/N):");
			}
			else {
				System.out.println("Co muon nhap tiep(Y/N):");
			}
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void NhapSachThamKhao() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			SachThamKhao sachThamKhao = this.initSachThamKhao();
			
			if(this.KiemTraTonTaiSachThamKhao(sachThamKhao) == false) {
				System.out.println("Cuon sach nay da ton tai");
				System.out.println("Co muon nhap lai(Y/N):");
			}
			else {
				System.out.println("Co muon nhap tiep(Y/N):");
			}
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public SachGiaoKhoa timSachGiaoKhoa(String maSach) {
        for (SachGiaoKhoa sachGK :  this.listSachGiaoKhoa) {
        	if(sachGK.getMaSach().equals(maSach)) {
        		return sachGK;
        	}
        }
        return null;
	}
	
	public boolean xoaSachGiaoKhoa(String maSach) {
		SachGiaoKhoa sachCanXoa = this.timSachGiaoKhoa(maSach);
		if(sachCanXoa != null && this.listSachGiaoKhoa.remove(sachCanXoa)) {
			return true;
		}
		return false;
	}
	
	public SachThamKhao timSachThamKhao(String maSach) {
        for (SachThamKhao sachTK :  this.listSachThamKhao) {
        	if(sachTK.getMaSach().equals(maSach)) {
        		return sachTK;
        	}
        }
        return null;
	}
	
	public boolean xoaSachThamKhao(String maSach) {
		SachThamKhao sachCanXoa = this.timSachThamKhao(maSach);
		if(sachCanXoa != null && this.listSachThamKhao.remove(sachCanXoa)) {
			return true;
		}
		return false;
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
