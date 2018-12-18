package Homework02.HoaDonThuePhong;

public class HoaDonTheoNgay extends HoaDonThuePhong{
	private int soNgay;
	
	public HoaDonTheoNgay() {
		super();
		this.soNgay = 0;
		this.setThanhTien(0.0f);
	}
	
	public HoaDonTheoNgay(String maHoaDon, String tenKhachHang, String maPhong, float donGia) {
		super(maHoaDon, tenKhachHang, maPhong, donGia);
	}

	@Override
	public String toString() {
		return "HoaDonTheoNgay [soNgay=" + this.soNgay + ", getMaHoaDon()=" + this.getMaHoaDon() + ", getNgayHoaDon()="
				+ this.getNgayHoaDon() + ", getTenKhachHang()=" + this.getTenKhachHang() + ", getMaPhong()=" + this.getMaPhong()
				+ ", getDonGia()=" + this.getDonGia() + ", getThanhTien()=" + this.getThanhTien() + "]";
	}

	public int getSoNgay() {
		return soNgay;
	}

	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	
}
