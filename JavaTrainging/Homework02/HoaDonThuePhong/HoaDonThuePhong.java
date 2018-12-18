package Homework02.HoaDonThuePhong;
import java.text.*;  
import java.util.*; 

public class HoaDonThuePhong {
	private String maHoaDon;
	private String ngayHoaDon;
	private String tenKhachHang;
	private String maPhong;
	private float donGia;
	private float thanhTien;
	
	public HoaDonThuePhong() {
		this.maHoaDon 		= null;
		this.ngayHoaDon 	= null;
		this.tenKhachHang 	= null;
		this.maPhong 		= null;
		this.donGia 		= 0.0f;
	}

	public HoaDonThuePhong(String maHoaDon, String tenKhachHang, String maPhong, float donGia) {
		this.maHoaDon 		= maHoaDon;
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date 			= new Date();  
	    String ngayHoaDon 	= formatter.format(date);  
		this.ngayHoaDon 	= ngayHoaDon;
		this.tenKhachHang 	= tenKhachHang;
		this.maPhong 		= maPhong;
		this.donGia 		= donGia;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getNgayHoaDon() {
		return ngayHoaDon;
	}

	public void setNgayHoaDon(String ngayHoaDon) {
		this.ngayHoaDon = ngayHoaDon;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
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
		return "HoaDonThuePhong [maHoaDon=" + this.maHoaDon + ", ngayHoaDon=" + this.ngayHoaDon + ", tenKhachHang=" + this.tenKhachHang
				+ ", maPhong=" + this.maPhong + ", donGia=" + this.donGia + ", thanhTien=" + this.thanhTien + "]";
	}
	
	
}
