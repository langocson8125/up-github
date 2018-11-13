package Homework01;
//Cau 7
public class SinhVien2 {
	private int maSinhVien;
	private String hoTen;
	private String diaChi;
	private int soDienThoai;
	
	public SinhVien2() {
		this.maSinhVien 	= 0;
		this.hoTen 			= null;
		this.diaChi 		= null;
		this.soDienThoai 	= 0;
	}
	
	public SinhVien2(int maSinhVien, String hoTen, String diaChi, int soDienThoai) {
		this.maSinhVien 	= maSinhVien;
		this.hoTen 			= hoTen;
		this.diaChi 		= diaChi;
		this.soDienThoai 	= soDienThoai;
	}
	
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public void setSoDienThoai(int soDienThoai) {
		if(soDienThoai > 999999 && soDienThoai < 9999999) {
			this.soDienThoai = soDienThoai;
		}
	}
	
	public int getMaSinhVien() {
		return this.maSinhVien;
	}
	
	public String getHoTen() {
		return this.hoTen;
	}
	
	public String getDiaChi() {
		return this.diaChi;
	}
	
	public int getSoDienThoai() {
		return this.soDienThoai;
	}
	
	//override toString method
	public String toString() {
		return "Ma SV: " + this.maSinhVien + ", Ho ten: " + this.hoTen + ", Dia chi: " + this.diaChi + ", SDT: " + this.soDienThoai;
	}
}
