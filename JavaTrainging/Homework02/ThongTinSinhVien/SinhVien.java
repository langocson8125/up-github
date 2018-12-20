package GiaiDe1;

import java.io.Serializable;

public class SinhVien extends Person implements Serializable{
	private String maSinhVien;
	private String email;
	private float diemTongKet;
	
	public SinhVien(String hoTen, String ngaySinh, String diaChi, boolean gioiTinh, String maSinhVien, String email, float diemTongKet) {
		super(hoTen, ngaySinh, diaChi, gioiTinh);
		this.maSinhVien 	= maSinhVien;
		this.email 			= email;
		this.diemTongKet 	= diemTongKet;
	}
	
	public SinhVien() {
		super();
		this.maSinhVien 	= null;
		this.email 			= null;
		this.diemTongKet 	= 0.0f;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getDiemTongKet() {
		return diemTongKet;
	}

	public void setDiemTongKet(float diemTongKet) {
		this.diemTongKet = diemTongKet;
	}

	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", email=" + email + ", diemTongKet=" + diemTongKet + ", hoTen="
				+ hoTen + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh
				+ ", getMaSinhVien()=" + getMaSinhVien() + ", getEmail()=" + getEmail() + ", getDiemTongKet()="
				+ getDiemTongKet() + ", getHoTen()=" + getHoTen() + ", getNgaySinh()=" + getNgaySinh()
				+ ", getDiaChi()=" + getDiaChi() + ", isGioiTinh()=" + isGioiTinh() + "]";
	}
}
