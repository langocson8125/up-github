package Homework02.HoaDonThuePhong;

import java.text.*;
import java.util.*;
import Homework02.*;

public class TrinhQuanLyHoaDonThuePhong {
	private List<HoaDonTheoNgay> listHoaDonTheoNgay	= new ArrayList<HoaDonTheoNgay>();
	private List<HoaDonTheoGio> listHoaDonTheoGio = new ArrayList<HoaDonTheoGio>();
	private Scanner sc = new Scanner(System.in);

	public HoaDonTheoNgay initHoaDonTheoNgay() {
		System.out.println("Nhap thong tin hoa don tien dien VN: ");
		
		String maGiaoDich;
		System.out.println("Nhap ma giao dich:");
		maGiaoDich = sc.nextLine();
		
		String hoTen;
		System.out.println("Nhap ma ho ten khach hang:");
		hoTen = sc.nextLine();
		
		String maPhong;
		System.out.println("Nhap ma phong:");
		maPhong = sc.nextLine();
		
		int donGia;
		System.out.println("Nhap so luong");
		donGia = sc.nextInt();
		
		return new HoaDonTheoNgay(maGiaoDich, hoTen, maPhong, donGia);
	}
	
	public HoaDonTheoGio initHoaDonTheoGio() {
		System.out.println("Nhap thong tin hoa don tien dien VN: ");
		
		String maGiaoDich;
		System.out.println("Nhap ma giao dich:");
		maGiaoDich = sc.nextLine();
		
		String hoTen;
		System.out.println("Nhap ma ho ten khach hang:");
		hoTen = sc.nextLine();
		
		String maPhong;
		System.out.println("Nhap ma phong:");
		maPhong = sc.nextLine();
		
		int donGia;
		System.out.println("Nhap so luong");
		donGia = sc.nextInt();
		
		return new HoaDonTheoGio(maGiaoDich, hoTen, maPhong, donGia);
	}
	
	public void NhapHoaDonTheoNgay() {
		String choice;
		do {
			HoaDonTheoNgay hoaDonTheoNgay = this.initHoaDonTheoNgay();
			
			this.listHoaDonTheoNgay.add(hoaDonTheoNgay);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void NhapHoaDonTheoGio() {
		String choice;
		do {
			HoaDonTheoGio hoaDonTheoGio = this.initHoaDonTheoGio();
			
			this.listHoaDonTheoGio.add(hoaDonTheoGio);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public int TongHoaDonThueTheoNgay() {
		return this.listHoaDonTheoNgay.size();
	}
	
	public int TongHoaDonThueTheoGio() {
		return this.listHoaDonTheoGio.size();
	}
	
	public void XuatHoaDonTheoNgay() throws ParseException {
		if(this.listHoaDonTheoNgay.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date currentTime = new Date();  
		    
	        for (HoaDonTheoNgay HDTN :  this.listHoaDonTheoNgay) {
	        	Date ngayTaoHoaDon = formatter.parse(HDTN.getNgayHoaDon());
	        	int totalHours = this.hourCalculator(ngayTaoHoaDon, currentTime);
	        	if(totalHours <= 30) {
	        		HDTN.setSoNgay(1);
	        		HDTN.setThanhTien(HDTN.getDonGia());
	        	}	
	        	else {	
	        		int soNgay = (int) Math.ceil(totalHours / 24);
	        		HDTN.setSoNgay(soNgay);
	        		HDTN.setThanhTien(HDTN.getDonGia() * soNgay);
	        	}
	        	System.out.println(HDTN.toString());
	        }
		}
	}
	
	public void XuatHoaDonTheoGio() throws ParseException {
		if(this.listHoaDonTheoGio.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date currentTime = new Date();  
		    
	        for (HoaDonTheoGio HDTG :  this.listHoaDonTheoGio) {
	        	Date ngayTaoHoaDon = formatter.parse(HDTG.getNgayHoaDon());
	        	int totalHours = this.hourCalculator(ngayTaoHoaDon, currentTime);
	        	if(totalHours < 30) {
	        		HDTG.setSoGio(totalHours);
		        	float thanhTien = HDTG.getSoGio() * HDTG.getDonGia();
		    	    HDTG.setThanhTien(thanhTien);
		    	    System.out.println(HDTG.toString());
	        	}
	        	else {
	        		HoaDonTheoNgay tmpHDTN = this.convertHDTGToHDTN(HDTG);
	        		this.listHoaDonTheoGio.remove(HDTG);
	        		this.listHoaDonTheoNgay.add(tmpHDTN);
	        	}
	        }
		}
	}
	
	
	public HoaDonTheoNgay convertHDTGToHDTN(HoaDonTheoGio HDTG) {
		String tmpMaHoaDon 		= HDTG.getMaHoaDon();
		String tmpNgayHoaDon 	= HDTG.getNgayHoaDon();
		String tmpTenKhachHang	= HDTG.getTenKhachHang();
		String tmpMaPhong 		= HDTG.getMaPhong();
		
		float donGia;
		System.out.println("Nhap don giao moi");
		donGia = sc.nextFloat();
		HoaDonTheoNgay HDTN = new HoaDonTheoNgay(tmpMaHoaDon, tmpTenKhachHang, tmpMaPhong, donGia); 
		HDTN.setNgayHoaDon(tmpNgayHoaDon);
		return HDTN;
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	private int hourCalculator(Date objDate1, Date objDate2) {
	    if(objDate2.getDate() - objDate1.getDate() > 0) {
	    	int totalHours = (objDate2.getDate() - objDate1.getDate()) * 24;
	    	totalHours += objDate2.getHours() - objDate1.getHours();
	    	return totalHours;
	    }
    	int totalHours = objDate2.getHours() - objDate1.getHours();
    	return totalHours;		
	}
	
	@SuppressWarnings("deprecation")
	public void xuatHoaDonThuePhongTheoNgay() {
		if(this.listHoaDonTheoNgay.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
		    Date currentTime = new Date();  
	        for (HoaDonTheoNgay HDTPTN :  this.listHoaDonTheoNgay) {
			    String dateInString = HDTPTN.getNgayHoaDon();
			    
			    try {
			    	date = formatter.parse(dateInString);
			    	/*
			    	 * phương thức getYear() trả về hiệu của năm get được - 1900
			    	 * ví dụ năm 2013 thì phương thức getYear() trả về 2013-1900 = 113
			    	 * nên để lấy năm chỉnh xác ta cộng thêm 1900
			    	 */
			    	if(date.getMonth() == 9 && (date.getYear() + 1900) == 2013) {
			        	Date ngayTaoHoaDon = formatter.parse(HDTPTN.getNgayHoaDon());
			        	int totalHours = this.hourCalculator(ngayTaoHoaDon, currentTime);
			        	if(totalHours <= 30) {
			        		HDTPTN.setSoNgay(1);
			        		HDTPTN.setThanhTien(HDTPTN.getDonGia());
			        	}	
			        	else {	
			        		int soNgay = (int) Math.ceil(totalHours / 24);
			        		HDTPTN.setSoNgay(soNgay);
			        		HDTPTN.setThanhTien(HDTPTN.getDonGia() * soNgay);
			        	}
			        	System.out.println(HDTPTN.toString());
			    	}

			    } catch (ParseException e) { // catch error
			    	e.printStackTrace();
			    }
	        }
		}
	}

	@SuppressWarnings("deprecation")
	public void xuatHoaDonThuePhongTheoGio() {
		if(this.listHoaDonTheoGio.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
		    Date currentTime = new Date();  
	        for (HoaDonTheoGio HDTPTG :  this.listHoaDonTheoGio) {
			    String dateInString = HDTPTG.getNgayHoaDon();
			    
			    try {
			    	date = formatter.parse(dateInString);
			    	/*
			    	 * phương thức getYear() trả về hiệu của năm get được - 1900
			    	 * ví dụ năm 2013 thì phương thức getYear() trả về 2013-1900 = 113
			    	 * nên để lấy năm chỉnh xác ta cộng thêm 1900
			    	 */
			    	if(date.getMonth() == 9 && (date.getYear() + 1900) == 2013) {
			        	Date ngayTaoHoaDon = formatter.parse(HDTPTG.getNgayHoaDon());
			        	int totalHours = this.hourCalculator(ngayTaoHoaDon, currentTime);
			        	if(totalHours < 30) {
			        		HDTPTG.setSoGio(totalHours);
				        	float thanhTien = HDTPTG.getSoGio() * HDTPTG.getDonGia();
				        	HDTPTG.setThanhTien(thanhTien);
				    	    System.out.println(HDTPTG.toString());
			        	}
			        	else {
			        		HoaDonTheoNgay tmpHDTN = this.convertHDTGToHDTN(HDTPTG);
			        		this.listHoaDonTheoGio.remove(HDTPTG);
			        		this.listHoaDonTheoNgay.add(tmpHDTN);
			        	}
			    	}

			    } catch (ParseException e) { // catch error
			    	e.printStackTrace();
			    }
	        }
		}
	}
}
