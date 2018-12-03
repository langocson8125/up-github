package Homework02;

/*
 * Bài 3
 * Class Cha - Giao Dịch (Vàng-Tiền Tệ)
 */

public class GiaoDich {
	private String 	maGiaoDich;
	private String 	ngayGiaoDich;
	private float 	donGia;
	private int 	soLuong;
	private float 	thanhTien;
	
	public GiaoDich() {
		this.maGiaoDich 	= null;
		this.ngayGiaoDich 	= null;
		this.donGia 		= 0.0f;
		this.soLuong 		= 0;
	}
	
	public GiaoDich(String maGiaoDich, String ngayGiaoDich, float donGia, int soLuong) {
		this.maGiaoDich 	= maGiaoDich;
		this.ngayGiaoDich 	= ngayGiaoDich;
		this.donGia 		= donGia;
		this.soLuong 		= soLuong;
	}

	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public String getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public void setNgayGiaoDich(String ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
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

	public float getThanhTien() {
		return thanhTien;
	}
	
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "GiaoDich [maGiaoDich=" + this.maGiaoDich + ", ngayGiaoDich=" + this.ngayGiaoDich + ", donGia=" + this.donGia
				+ ", soLuong=" + this.soLuong + ", thanhTien=" + this.thanhTien + "]";
	}
	
}
