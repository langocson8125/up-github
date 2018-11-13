package Homework01;

import java.text.NumberFormat;
import java.util.Locale;

// Cau 4
public class Account {
	private long soTaiKhoan;
	private String tenTaiKhoan;
	private double soTienTrongTaiKhoan;
	private final static float LAI_XUAT = 0.035f;
	
	public Account() {
		this.soTaiKhoan 		 = 0;
		this.tenTaiKhoan 		 = "";
		this.soTienTrongTaiKhoan = 0;
	}
	
	public Account(long soTaiKhoan, String tenTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.soTienTrongTaiKhoan = 50;
	}
	
	public void setSoTaiKhoan(long soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}
	
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	
	public void setSoTienTrongTaiKhoan(double soTienTrongTaiKhoan) {
		this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
	}
	
	public long getSoTaiKhoan() {
		return this.soTaiKhoan;
	}
	
	public String getTenTaiKhoan() {
		return this.tenTaiKhoan;
	}
	
	public double getSoTienTrongTaiKhoan() {
		return this.soTienTrongTaiKhoan;
	}
	
	public String toString() {
	    // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
	    // đơn vị tiền tệ của Việt Nam là đồng
	    Locale localeVN = new Locale("vi", "VN");
	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return "So tai khoan: " + this.soTaiKhoan + ", Ten tai khoan: " + this.tenTaiKhoan + ", So tien trong tai khoan: " + currencyVN.format(this.soTienTrongTaiKhoan);
	}
	
	public double napTienTaiKhoan(double tienMuonNap) {
		if(tienMuonNap > 0) {
			this.soTienTrongTaiKhoan += tienMuonNap;
			return tienMuonNap;
		}
		return 0;
	}
	
	public double rutTienTaiKhoan(double tienMuonRut) {
		if(tienMuonRut > 0 && tienMuonRut <= this.soTienTrongTaiKhoan) {
			this.soTienTrongTaiKhoan -= tienMuonRut;
			return tienMuonRut;
		}
		return 0;
	}
	
	public double daoHan() {
		this.soTienTrongTaiKhoan += this.soTienTrongTaiKhoan * LAI_XUAT;
		return this.soTienTrongTaiKhoan;
	}
	
	public double chuyenKhoan(long soTaiKhoan, String tenTaiKhoan, double soTienCanChuyen) {
		if(soTienCanChuyen > 0 && soTienCanChuyen <= this.soTienTrongTaiKhoan) {
			this.soTienTrongTaiKhoan -= soTienCanChuyen;
			return soTienCanChuyen;
		}
		return 0;
	}
}
