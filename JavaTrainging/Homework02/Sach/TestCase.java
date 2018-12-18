package Homework02.Sach;

public class TestCase {

	public static void main(String[] args) {
		// khởi tạo đối tượng Trình quản lý sách giáo khoa
		TrinhQuanLySach TQLS = new TrinhQuanLySach();
		
		// Nhâp SGK vào
		TQLS.NhapSachGiaoKhoa();
		
		// xóa SGK có mã sách là a1
		
		TQLS.xoaSachGiaoKhoa("a1");
		// Xuất ra danh sách SGK
		System.out.println("Danh sach SGK");
		TQLS.XuatSachGiaoKhoa();
		
		// Tính tổng thành tiền tất cả SGK
		System.out.println("Tong thanh tien SGK: " + TQLS.TongThanhTienSachGiaoKhoa());
		
		
		// Tính trung bình cộng đơn giá tất cả SGK
		System.out.println("Trung binh cong don gia SGK: " + TQLS.trungBinhCongDonGiaSachGiaoKhoa());
		
		
		// Xuất ra danh sách SGK do nhà xuất bản abcxyz
		System.out.println("Dach sach SGK do nha xuat ban Kim Dong");
		TQLS.XuatSachGiaoKhoaTheoNhaXuatBan("kim dong");
	}

}
