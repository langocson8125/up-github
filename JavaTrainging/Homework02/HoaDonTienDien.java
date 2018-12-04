package Homework02;

public class HoaDonTienDien {
	private String maKhachHang;
	private String hoTen;
	private String ngayRaHoaDon; // dd/mm/yyyy
	private int soLuong;
	private float donGia;
	private float thanhTien;

	public HoaDonTienDien(String maKhachHang, String hoTen, String ngayRaHoaDon, int soLuong, float donGia) {
		this.maKhachHang 	= maKhachHang;
		this.hoTen 			= hoTen;
		this.ngayRaHoaDon 	= ngayRaHoaDon;
		this.soLuong 		= soLuong;
		this.donGia 		= donGia;
	}

	public HoaDonTienDien() {
		this.maKhachHang 	= null;
		this.hoTen 			= null;
		this.ngayRaHoaDon 	= null;
		this.soLuong 		= 0;
		this.donGia 		= 0.0f;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgayRaHoaDon() {
		return ngayRaHoaDon;
	}

	public void setNgayRaHoaDon(String ngayRaHoaDon) {
		this.ngayRaHoaDon = ngayRaHoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
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

	@Override
	public String toString() {
		return "HoaDonTienDien [maKhachHang=" + this.maKhachHang + ", hoTen=" + this.hoTen + ", ngayRaHoaDon=" + this.ngayRaHoaDon
				+ ", soLuong=" + this.soLuong + ", donGia=" + this.donGia + ", thanhTien=" + this.thanhTien + "]";
	}

}
