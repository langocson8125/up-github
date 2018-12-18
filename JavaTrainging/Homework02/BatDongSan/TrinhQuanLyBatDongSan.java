package Homework02.BatDongSan;

import java.util.*;
import java.text.*;

/*
 * Bài 4
 * Trình quản lý bất động sản
 * Giao dịch đất và Giao dịch nha
 */

public class TrinhQuanLyBatDongSan {
	private List<GiaoDichDat> listGiaoDichDat = new ArrayList<GiaoDichDat>();
	private List<GiaoDichNha> listGiaoDichNha = new ArrayList<GiaoDichNha>();
	private Scanner sc = new Scanner(System.in);
	
	public GiaoDichDat initGiaoDichDat() {
		System.out.println("Nhap thong tin giao dich dat: ");
		
		String maGiaoDich;
		System.out.println("Nhap ma giao dich:");
		maGiaoDich = sc.nextLine();
		
		String ngayGiaoDich;
		System.out.println("Nhap ngay giao dich(dd/mm/yyyy):");
		ngayGiaoDich = sc.nextLine();
		
		float donGia;
		System.out.println("Nhap don gia:");
		donGia = sc.nextFloat();

		String loaiDat;
		System.out.println("Nhap loai dat");
		loaiDat = sc.nextLine();
		sc.nextLine();
		int dienTich;
		System.out.println("Nhap dien tich");
		dienTich = sc.nextInt();
		
		return new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, loaiDat, dienTich);
	}

	public GiaoDichNha initGiaoDichNha() {
		System.out.println("Nhap thong tin giao dich dat: ");
		
		String maGiaoDich;
		System.out.println("Nhap ma giao dich:");
		maGiaoDich = sc.nextLine();
		
		String ngayGiaoDich;
		System.out.println("Nhap ngay giao dich(dd/mm/yyyy):");
		ngayGiaoDich = sc.nextLine();
		
		float donGia;
		System.out.println("Nhap don gia:");
		donGia = sc.nextFloat();

		int loaiNha;
		System.out.println("Nhap loai nha(1 - cao cap/0 - thuong)");
		loaiNha = sc.nextInt();
		
		String diaChi;
		System.out.println("Nhap dia chi:");
		diaChi = sc.nextLine();
		sc.nextLine();
		
		int dienTich;
		System.out.println("Nhap dien tich");
		dienTich = sc.nextInt();
		
		return new GiaoDichNha(maGiaoDich, ngayGiaoDich, donGia, loaiNha, diaChi, dienTich);
	}
	
	public void NhapGiaoDichDat() {
		String choice;
		do {
			GiaoDichDat giaoDichDat = this.initGiaoDichDat();
			
			this.listGiaoDichDat.add(giaoDichDat);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void NhapGiaoDichNha() {
		String choice;
		do {
			GiaoDichNha giaoDichNha = this.initGiaoDichNha();
			
			this.listGiaoDichNha.add(giaoDichNha);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void XuatGiaoDichDat() {
		if(this.listGiaoDichDat.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (GiaoDichDat GDD :  this.listGiaoDichDat) {
	        	System.out.println(GDD.toString());
	        }
		}
	}
	
	public void XuatGiaoDichNha() {
		if(this.listGiaoDichNha.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (GiaoDichNha GDN :  this.listGiaoDichNha) {
	        	System.out.println(GDN.toString());
	        }
		}
	}
	
	public int TongGiaoDichDat() {
		return this.listGiaoDichDat.size();
	}
	
	public int TongGiaoDichNha() {
		return this.listGiaoDichNha.size();
	}
	
	public float trungBinhCongThanhTienGiaoDichDat() {
		float result = 0.0f;
		if(this.listGiaoDichDat.isEmpty() ) {
			return result;
		}
		else {
	        for (GiaoDichDat GDD :  this.listGiaoDichDat) {
	        	result += GDD.getThanhTien();
	        }
	        return result/(this.listGiaoDichDat.size());
		}
	}
	
	@SuppressWarnings("deprecation")
	public void xuatGiaoDichDatTheoNgay() {
		if(this.listGiaoDichDat.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			
	        for (GiaoDichDat GDD :  this.listGiaoDichDat) {
			    String dateInString = GDD.getNgayGiaoDich();
			    
			    try {
			    	date = formatter.parse(dateInString);
			    	/*
			    	 * phương thức getYear() trả về hiệu của năm get được - 1900
			    	 * ví dụ năm 2013 thì phương thức getYear() trả về 2013-1900 = 113
			    	 * nên để lấy năm chỉnh xác ta cộng thêm 1900
			    	 */
			    	if(date.getMonth() == 9 && (date.getYear() + 1900) == 2013) {
			    		System.out.println(GDD.toString());
			    	}

			    } catch (ParseException e) { // catch error
			    	e.printStackTrace();
			    }
	        }
		}
	}
	
	@SuppressWarnings("deprecation")
	public void xuatGiaoDichNhaTheoNgay() {
		if(this.listGiaoDichNha.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			
	        for (GiaoDichNha GDN :  this.listGiaoDichNha) {
			    String dateInString = GDN.getNgayGiaoDich();
			    
			    try {
			    	date = formatter.parse(dateInString);
			    	/*
			    	 * phương thức getYear() trả về hiệu của năm get được - 1900
			    	 * ví dụ năm 2013 thì phương thức getYear() trả về 2013-1900 = 113
			    	 * nên để lấy năm chỉnh xác ta cộng thêm 1900
			    	 */
			    	if(date.getMonth() == 9 && (date.getYear() + 1900) == 2013) {
			    		System.out.println(GDN.toString());
			    	}

			    } catch (ParseException e) { // catch error
			    	e.printStackTrace();
			    }
	        }
		}
	}
}
