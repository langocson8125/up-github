package Homework02;

import java.util.*;

/*
 * Bài 1
 * Trình quản lý xe
 * Xe ngoại thành - Xe nội thành
 */

public class TrinhQuanLyXe {
	private List<XeNgoaiThanh> listXeNgoaiThanh = new ArrayList<XeNgoaiThanh>();
	private List<XeNoiThanh> listXeNoiThanh 	= new ArrayList<XeNoiThanh>();
	private Scanner sc = new Scanner(System.in);
	
	public XeNgoaiThanh initXeNgoaiThanh() {
		System.out.println("Nhap thong tin xe ngoai thanh: ");
		
		String maXe;
		System.out.println("Nhap ma xe:");
		maXe = sc.nextLine();
		
		String hoTenTaiXe;
		System.out.println("Nhap ho ten tai xe:");
		hoTenTaiXe = sc.nextLine();
		
		String soXe;
		System.out.println("Nhap so xe:");
		soXe = sc.nextLine();
		
		String noiDen;
		System.out.println("Nhap noi den:");
		noiDen = sc.nextLine();
		
		int soNgayDiDuoc;
		System.out.println("Nhap so ngay di duoc:");
		soNgayDiDuoc = sc.nextInt();
		
		float doanhThu;
		System.out.println("Nhap doanh thu:");
		doanhThu = sc.nextFloat();

		return new XeNgoaiThanh(maXe, hoTenTaiXe, soXe, noiDen, soNgayDiDuoc, doanhThu);
	}
	
	public XeNoiThanh initXeNoiThanh() {
		System.out.println("Nhap thong tin xe noi thanh: ");
		
		String maXe;
		System.out.println("Nhap ma xe:");
		maXe = sc.nextLine();
		
		String hoTenTaiXe;
		System.out.println("Nhap ho ten tai xe:");
		hoTenTaiXe = sc.nextLine();
		 
		String soXe;
		System.out.println("Nhap so xe:");
		soXe = sc.nextLine();
		
		int soTuyen;
		System.out.println("Nhap so tuyen:");
		soTuyen = sc.nextInt();
		
		int soKmDiDuoc;
		System.out.println("Nhap so KM di duoc:");
		soKmDiDuoc = sc.nextInt();
		
		float doanhThu;
		System.out.println("Nhap doanh thu:");
		doanhThu = sc.nextFloat();
		
		return new XeNoiThanh(maXe, hoTenTaiXe, soXe, soTuyen, soKmDiDuoc, doanhThu);
	}
	
	public void NhapChuyenXeNgoaiThanh() {
		String choice;
		do {
			XeNgoaiThanh xeNgoaiThanh = this.initXeNgoaiThanh();
			
			this.listXeNgoaiThanh.add(xeNgoaiThanh);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
			System.out.flush();
		}
		while(choice.equals("Y"));
	}

	public void NhapChuyenXeNoiThanh() {
		String choice;
		do {
			XeNoiThanh xeNoiThanh = this.initXeNoiThanh();
			
			this.listXeNoiThanh.add(xeNoiThanh);
			
			System.out.println("Co muon nhap tiep(Y/N):");
			choice = sc.next();
			System.out.flush();
		}
		while(choice.equals("Y"));
	}
	
	public void XuaDanhSachXeNgoaiThanh() {
		if(this.listXeNgoaiThanh.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (XeNgoaiThanh xeNT :  this.listXeNgoaiThanh) {
	        	System.out.println(xeNT.toString());
	        }
		}
	}

	public void XuaDanhSachXeNoiThanh() {
		if(this.listXeNoiThanh.isEmpty() ) {
			System.out.println("Danh sach rong");
		}
		else {
	        for (XeNoiThanh xeNT :  this.listXeNoiThanh) {
	        	System.out.println(xeNT.toString());
	        }
		}
	}
	
	public float DoanhThuXeNgoaiThanh() {
		float doanhThu = 0.0f;
		if(this.listXeNgoaiThanh.isEmpty() ) {
			return doanhThu;
		}
		else {
	        for (XeNgoaiThanh xeNT :  this.listXeNgoaiThanh) {
	        	doanhThu += xeNT.getDoanhThu();
	        }
	        return doanhThu;
		}
	}
	
	public float DoanhThuXeNoiThanh() {
		float doanhThu = 0.0f;
		if(this.listXeNoiThanh.isEmpty() ) {
			return doanhThu;
		}
		else {
	        for (XeNoiThanh xeNT :  this.listXeNoiThanh) {
	        	doanhThu += xeNT.getDoanhThu();
	        }
	        return doanhThu;
		}
	}
}
