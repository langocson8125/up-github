package Homework01;
//Cau 2
public class SinhVien {
	private int maSinhVien;
	private String hoTen;
	private float diemLyThuyet;
	private float diemThucHanh;
	
	public SinhVien() {
		this.maSinhVien 	= 0;
		this.hoTen 			= "";
		this.diemLyThuyet 	= 0;
		this.diemThucHanh 	= 0;
	}
	
	public SinhVien(int maSinhVien, String hoTen, float diemLyThuyet, float diemThucHanh) {
		this.maSinhVien 	= maSinhVien;
		this.hoTen 			= hoTen;
		this.diemLyThuyet 	= diemLyThuyet;
		this.diemThucHanh 	= diemThucHanh;
	}
	
	public int getMaSinhVien() {
		return this.maSinhVien;
	}
	
	public String getHoTen() {
		return this.hoTen;
	}
	
	public float getDiemLyThuyet() {
		return this.diemLyThuyet;
	}
	
	public float getDiemThucHanh() {
		return this.diemThucHanh;
	}
	
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public void setDiemLyThuyet(float diemLyThuyet) {
		this.diemLyThuyet = diemLyThuyet;
	}
	
	public void setDiemThucHanh(float diemThucHanh) {
		this.diemThucHanh = diemThucHanh;
	}
	
	public float diemTrungBinh() {
		return (this.diemLyThuyet + this.diemThucHanh) / 2;
	}
	
	public void toStrings() {
		System.out.printf("MSSV: %d, Ho ten: %-20s, Diem ly thuyet: %5.2f, Diem thuc hanh: %5.2f%n", this.maSinhVien, this.hoTen, this.diemLyThuyet, this.diemThucHanh);
	}
}
