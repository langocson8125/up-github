package Homework01;

import java.util.*;
import java.text.*;
//Cau 6
public class HangThucPham {
	private final int maHang;
	private String tenHang;
	private float donGia;
	private String ngaySanXuat;
	private String hanSuDung;
	
	public HangThucPham(int maHang) {
		this.maHang 		= maHang;
		this.tenHang 		= null;
		this.donGia 		= 0;
	    this.ngaySanXuat 	= null;
	    this.hanSuDung 		= null;
	}
	
	public HangThucPham(int maHang, String tenHang, float donGia, String ngaySanXuat, String hanSuDung) throws ParseException {
		this.maHang			= maHang;
		this.tenHang		= tenHang;
		this.donGia			= donGia;
		try {
	        SimpleDateFormat sdf 	= new SimpleDateFormat("dd-MM-yyyy");
	        this.ngaySanXuat 		= ngaySanXuat;
	        Date date1 				= sdf.parse(ngaySanXuat);
	        Date date2 				= sdf.parse(hanSuDung);
	        if(date2.after(date1)) {
	        	this.hanSuDung 		= hanSuDung;
	        }
		} 
		catch(ParseException e) {
			  e.printStackTrace();
		}
	}
	
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public void setNgaySanXuat(String ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	
	public void setHanSuDung(String hanSuDung) {
		try {
	        SimpleDateFormat sdf 	= new SimpleDateFormat("dd-MM-yyyy");
	        Date date1 				= sdf.parse(this.ngaySanXuat);
	        Date date2 				= sdf.parse(hanSuDung);
	        if(date2.after(date1)) {
	        	this.hanSuDung 		= hanSuDung;
	        }
		} 
		catch(ParseException e) {
			  e.printStackTrace();
		}
	}
	
	public int getMaHang() {
		return this.maHang;
	}
	
	public String getTenHang() {
		return this.tenHang;
	}
	
	public float getDonGia() {
		return this.donGia;
	}
	
	public String getNgaySanXuat() {
		return this.ngaySanXuat;
	}
	
	public String getHanSuDung() {
		return this.hanSuDung;
	}
	
	public int kiemTraHetHan() {
		if(this.hanSuDung != null) {
			try {
		        SimpleDateFormat sdf 	= new SimpleDateFormat("dd-MM-yyyy");
		        Date tmpDateNow = new Date();
		        String dateFormatted = sdf.format(tmpDateNow);
		        Date date1 = sdf.parse(dateFormatted);
		        Date date2 = sdf.parse(this.hanSuDung);
		        if(date1.after(date2)) {
		        	return 1;
		        }
			} 
			catch(ParseException e) {
				  e.printStackTrace();
			}
		}
		return 0;
	}
	
	public String toString() {
		if(this.ngaySanXuat != null || this.hanSuDung != null) {
				String ngaySanXuat 	= this.ngaySanXuat.replace("-", "/");
				String hanSuDung 	= this.hanSuDung.replace("-", "/");
		        return "Ma hang: " + this.maHang + ", Ten hang: " + this.tenHang + ", Don gia: " + this.donGia + ", Ngay san xuat: " + ngaySanXuat + ", Han su dung: " + hanSuDung;
		}
		else {
			return "Chua co thong tin san pham";
		}
	}
}
