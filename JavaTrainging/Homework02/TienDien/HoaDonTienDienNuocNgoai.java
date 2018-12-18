package Homework02.TienDien;

import java.io.Serializable;

public class HoaDonTienDienNuocNgoai extends HoaDonTienDien implements Serializable{
	private String quocTich;
	
	public HoaDonTienDienNuocNgoai() {
		super();
		this.quocTich = null;
		this.setThanhTien(0.0f);
	}

	public HoaDonTienDienNuocNgoai(String maKhachHang, String hoTen, String ngayRaHoaDon, int soLuong, float donGia, String quocTich) {
		super(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia);
		this.quocTich = quocTich;
		this.setThanhTien(soLuong * donGia);
	}		

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	@Override
	public String toString() {
		return "Ma khach hang: " + this.getMaKhachHang() + " - Ho ten: " + this.getHoTen() + " - Ngay ra hoa don: " + this.getNgayRaHoaDon()
			+ " - Don gia: " + this.getDonGia() + " - So luong: " + this.getSoLuong() + " - Quoc tich: " + this.getQuocTich() + " - Thanh tien: " + this.getThanhTien();
	}

	@Override
	public boolean equals(Object obj) {
		return this.getMaKhachHang().equalsIgnoreCase(((HoaDonTienDienNuocNgoai)obj).getMaKhachHang());
	}
}
