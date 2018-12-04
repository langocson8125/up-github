package Homework02;

import java.text.*;
import java.util.*;

public class TrinhQuanLyHoaDonDien {
	private List<HoaDonTienDienVietNam> 	listHoaDonTienDienVietNam 	= new ArrayList<HoaDonTienDienVietNam>();
	private List<HoaDonTienDienNuocNgoai> 	listHoaDonTienDienNuocNgoai = new ArrayList<HoaDonTienDienNuocNgoai>();
	private Scanner sc = new Scanner(System.in);
	
	public HoaDonTienDienVietNam initHoaDonTienDienVietNam() {
		System.out.println("Nhap thong tin hoa don tien dien VN: ");
		
		String maGiaoDich;
		System.out.println("Nhap ma giao dich:");
		maGiaoDich = sc.nextLine();
		
		String hoTen;
		System.out.println("Nhap ma ho ten khach hang:");
		hoTen = sc.nextLine();
		
		String ngayRaHoaDon;
		System.out.println("Nhap ngay ra hoa don(dd/mm/yyyy):");
		ngayRaHoaDon = sc.nextLine();
		
		String doiTuongKhachHang;
		System.out.println("Nhap doi tuong khach hang:");
		doiTuongKhachHang = sc.nextLine();
		
		int soLuong;
		System.out.println("Nhap so luong");
		soLuong = sc.nextInt();
		
		float donGia;
		System.out.println("Nhap don gia");
		donGia = sc.nextFloat();
		
		int dinhMuc;
		System.out.println("Nhap dinh muc");
		dinhMuc = sc.nextInt();
		
		return new HoaDonTienDienVietNam(maGiaoDich, hoTen, ngayRaHoaDon, soLuong, donGia, doiTuongKhachHang, dinhMuc);
	}

	public HoaDonTienDienNuocNgoai initHoaDonTienDienNuocNgoai() {
		System.out.println("Nhap thong tin hoa don tien dien VN: ");
		
		String maGiaoDich;
		System.out.println("Nhap ma giao dich:");
		maGiaoDich = sc.nextLine();
		
		String hoTen;
		System.out.println("Nhap ma ho ten khach hang:");
		hoTen = sc.nextLine();
		
		String ngayRaHoaDon;
		System.out.println("Nhap ngay ra hoa don(dd/mm/yyyy):");
		ngayRaHoaDon = sc.nextLine();
		
		int soLuong;
		System.out.println("Nhap so luong");
		soLuong = sc.nextInt();
		
		float donGia;
		System.out.println("Nhap don gia");
		donGia = sc.nextFloat();
		
		String quocTich;
		System.out.println("Nhap quoc tich");
		quocTich = sc.nextLine();
		
		return new HoaDonTienDienNuocNgoai(maGiaoDich, hoTen, ngayRaHoaDon, soLuong, donGia, quocTich);
	}
	
	public void NhapHoaDonTienDienVietNam() {
		String choice;
		do {
			HoaDonTienDienVietNam hoaDonTienDienVietNam = this.initHoaDonTienDienVietNam();
			
			this.listHoaDonTienDienVietNam.add(hoaDonTienDienVietNam);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void NhapHoaDonTienDienNuocNgoai() {
		String choice;
		do {
			HoaDonTienDienNuocNgoai hoaDonTienDienNuocNgoai = this.initHoaDonTienDienNuocNgoai();
			
			this.listHoaDonTienDienNuocNgoai.add(hoaDonTienDienNuocNgoai);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
		}
		while(choice.equals("Y"));
	}
	
	public void XuatHoaDonTienDienVietNam() {
		if(this.listHoaDonTienDienVietNam.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (HoaDonTienDienVietNam HDTDVN :  this.listHoaDonTienDienVietNam) {
	        	System.out.println(HDTDVN.toString());
	        }
		}
	}
	
	public void XuatHoaDonTienDienNuocNgoai() {
		if(this.listHoaDonTienDienNuocNgoai.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (HoaDonTienDienNuocNgoai HDTDNN :  this.listHoaDonTienDienNuocNgoai) {
	        	System.out.println(HDTDNN.toString());
	        }
		}
	}
	
	public int TongHoaDonTienDienVietNam() {
		return this.listHoaDonTienDienVietNam.size();
	}
	
	public int TongHoaDonTienDienNuocNgoai() {
		return this.listHoaDonTienDienNuocNgoai.size();
	}
	
	public float trungBinhCongThanhTienHoaDonTienDienNuocNgoai() {
		float result = 0.0f;
		if(this.listHoaDonTienDienNuocNgoai.isEmpty() ) {
			return result;
		}
		else {
	        for (HoaDonTienDienNuocNgoai HDTDNN :  this.listHoaDonTienDienNuocNgoai) {
	        	result += HDTDNN.getThanhTien();
	        }
	        return result/(this.listHoaDonTienDienNuocNgoai.size());
		}
	}
	
	@SuppressWarnings("deprecation")
	public void xuatHoaDonTienDienVietNamTheoNgay() {
		if(this.listHoaDonTienDienVietNam.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			
	        for (HoaDonTienDienVietNam HDTDVN :  this.listHoaDonTienDienVietNam) {
			    String dateInString = HDTDVN.getNgayRaHoaDon();
			    
			    try {
			    	date = formatter.parse(dateInString);
			    	/*
			    	 * phương thức getYear() trả về hiệu của năm get được - 1900
			    	 * ví dụ năm 2013 thì phương thức getYear() trả về 2013-1900 = 113
			    	 * nên để lấy năm chỉnh xác ta cộng thêm 1900
			    	 */
			    	if(date.getMonth() == 9 && (date.getYear() + 1900) == 2013) {
			    		System.out.println(HDTDVN.toString());
			    	}

			    } catch (ParseException e) { // catch error
			    	e.printStackTrace();
			    }
	        }
		}
	}
	
	@SuppressWarnings("deprecation")
	public void xuatHoaDonTienDienNuocNgoaiTheoNgay() {
		if(this.listHoaDonTienDienNuocNgoai.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			
	        for (HoaDonTienDienNuocNgoai HDTDNN :  this.listHoaDonTienDienNuocNgoai) {
			    String dateInString = HDTDNN.getNgayRaHoaDon();
			    
			    try {
			    	date = formatter.parse(dateInString);
			    	/*
			    	 * phương thức getYear() trả về hiệu của năm get được - 1900
			    	 * ví dụ năm 2013 thì phương thức getYear() trả về 2013-1900 = 113
			    	 * nên để lấy năm chỉnh xác ta cộng thêm 1900
			    	 */
			    	if(date.getMonth() == 9 && (date.getYear() + 1900) == 2013) {
			    		System.out.println(HDTDNN.toString());
			    	}

			    } catch (ParseException e) { // catch error
			    	e.printStackTrace();
			    }
	        }
		}
	}
}
