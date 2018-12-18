package Homework02.HoaDonThuePhong;

public class HoaDonTheoGio extends HoaDonThuePhong {
	private int soGio;
	
	public HoaDonTheoGio() {
		super();
		this.soGio = 0;
		this.setThanhTien(0.0f);
	}

	public HoaDonTheoGio(String maHoaDon, String tenKhachHang, String maPhong, float donGia) {
		super(maHoaDon, tenKhachHang, maPhong, donGia);
	}

	public int getSoGio() {
		return soGio;
	}

	public void setSoGio(int soGio) {
		this.soGio = soGio;
	}

	@Override
	public String toString() {
		return "HoaDonTheoGio [soGio=" + this.soGio + ", getMaHoaDon()=" + this.getMaHoaDon() + ", getNgayHoaDon()="
				+ this.getNgayHoaDon() + ", getTenKhachHang()=" + this.getTenKhachHang() + ", getMaPhong()=" + this.getMaPhong()
				+ ", getDonGia()=" + this.getDonGia() + ", getThanhTien()=" + this.getThanhTien() + "]";
	}
	
	
}
