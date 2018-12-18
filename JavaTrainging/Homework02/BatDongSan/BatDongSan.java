package Homework02.BatDongSan;

/*
 * Bài 4 
 * Class Cha - Bất Động Sản
 */
public class BatDongSan {
	private String 	maGiaoDich;
	private String 	ngayGiaoDich; //  format dd/mm/yyyy
	private float 	donGia;
	private float 	thanhTien;
	private int 	dienTich;
	
	public BatDongSan() {
		this.maGiaoDich 	= null;
		this.ngayGiaoDich 	= null;
		this.donGia 		= 0.0f;
		this.dienTich		= 0;
	}

	public BatDongSan(String maGiaoDich, String ngayGiaoDich, float donGia, int dienTich) {
		this.maGiaoDich 	= maGiaoDich;
		this.ngayGiaoDich 	= ngayGiaoDich;
		this.donGia 		= donGia;
		this.dienTich		= dienTich;
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

	public float getThanhTien() {
		return thanhTien;
	}
	
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	public int getDienTich() {
		return dienTich;
	}

	public void setDienTich(int dienTich) {
		this.dienTich = dienTich;
	}

	@Override
	public String toString() {
		return "BatDongSan [maGiaoDich=" + this.maGiaoDich + ", ngayGiaoDich=" + this.ngayGiaoDich + ", donGia=" + this.donGia
				+ ", thanhTien=" + this.thanhTien + "]";
	}
}
