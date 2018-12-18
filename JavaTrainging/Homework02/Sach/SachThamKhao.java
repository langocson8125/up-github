package Homework02.Sach;

import java.io.Serializable;

import Homework02.TienDien.HoaDonTienDienVietNam;

/*
 * Bài 2
 * Class con Sách Tham Khảo
 */

public class SachThamKhao extends Sach implements Serializable{
	private float thue;
	
	public SachThamKhao() {
		super();
		this.thue = 0.0f;
	}
	
	public SachThamKhao(String maSach, String ngayNhap, float donGia, int soLuong, String nhaSanXuat, float thue) {
		super(maSach,ngayNhap, donGia, soLuong, nhaSanXuat);
		this.thue 		= thue;
		float thanhTien = ((soLuong + donGia) * thue) / 100;
		this.setThanhTien(thanhTien);
	}

	@Override
	public String toString() {
		return "SachThamKhao [thue=" + this.thue + ", getMaSach()=" + this.getMaSach() + ", getNgayNhap()=" + this.getNgayNhap()
				+ ", getDonGia()=" + this.getDonGia() + ", getSoLuong()=" + this.getSoLuong() + ", getNhaXuatBan()="
				+ this.getNhaXuatBan() + ", getThanhTien()=" + this.getThanhTien() + "]";
	}

	public float getThue() {
		return thue;
	}

	public void setThue(float thue) {
		this.thue = thue;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getMaSach().equalsIgnoreCase(((SachThamKhao)obj).getMaSach());
	}
	
}
