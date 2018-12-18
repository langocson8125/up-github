package Homework02.GiaoDich;

/*
 * Bài 3
 * Class con Giao Dịch Vàng
 */

public class GiaoDichVang extends GiaoDich {
	private String loaiVang;

	public GiaoDichVang() {
		super();
		this.loaiVang = null;
		this.setThanhTien(0.0f);
	}
	
	public GiaoDichVang(String maGiaoDich, String ngayGiaoDich, float donGia, int soLuong, String loaiVang) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
		this.loaiVang 	= loaiVang;
		float thanhTien = donGia * soLuong;
		this.setThanhTien(thanhTien);
	}
	
	public String getLoaiVang() {
		return loaiVang;
	}

	public void setLoaiVang(String loaiVang) {
		this.loaiVang = loaiVang;
	}

	@Override
	public String toString() {
		return "GiaoDichVang [loaiVang=" + this.loaiVang + ", getMaGiaoDich()=" + this.getMaGiaoDich() + ", getNgayGiaoDich()="
				+ this.getNgayGiaoDich() + ", getDonGia()=" + this.getDonGia() + ", getSoLuong()=" + this.getSoLuong()
				+ ", getThanhTien()=" + this.getThanhTien() + "]";
	}
	
	
}
