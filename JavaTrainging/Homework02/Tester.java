package Homework02;

/*
 * Tester 
 * Chú ý các import phía trên mỗi file nhé, ahihi!
 */

public class Tester {

	public static void main(String[] args) {
        testBatDongSan();
	}
	
	public static void testXe() {
		TrinhQuanLyXe qlXe = new TrinhQuanLyXe();
		qlXe.NhapChuyenXeNgoaiThanh();
		qlXe.XuaDanhSachXeNgoaiThanh();
		System.out.println("Doanh thu xe ngoai thanh: " + qlXe.DoanhThuXeNgoaiThanh());
	}

	public static void testBatDongSan() {
		TrinhQuanLyBatDongSan QLBDS = new TrinhQuanLyBatDongSan();
		QLBDS.NhapGiaoDichDat();
		QLBDS.xuatGiaoDichDatTheoNgay();
	}
}
