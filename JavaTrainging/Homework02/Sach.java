package Homework02;

/*
 * Bài 2
 * Class Cha - Sách
 */

public class Sach {
	private String 	maSach;
	private String 	ngayNhap;
	private float 	donGia;
	private int 	soLuong;
	private String 	nhaXuatBan;
	private float 	thanhTien;
	
	public Sach() {
		this.maSach 	= null;
		this.ngayNhap 	= null;
		this.donGia 	= 0.0f;
		this.soLuong 	= 0;
		this.nhaXuatBan = null;
	}

	public Sach(String maSach, String ngayNhap, float donGia, int soLuong, String nhaXuatBan) {
		this.maSach		= maSach;
		this.ngayNhap	= ngayNhap;
		this.donGia		= donGia;
		this.soLuong	= soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public float getThanhTien() {
		return thanhTien;
	}
	
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
}
