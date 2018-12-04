package Homework02;

public class HoaDonTienDienNuocNgoai extends HoaDonTienDien {
	private String quocTich;
	
	public HoaDonTienDienNuocNgoai() {
		super();
		this.quocTich = null;
		this.setThanhTien(0.0f);
	}

	public HoaDonTienDienNuocNgoai(String maKhachHang, String hoTen, String ngayRaHoaDon, int soLuong, float donGia, String quocTich) {
		super(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia);
		this.quocTich = quocTich;
		this.setThanhTien(soLuong * donGia);
	}		

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	@Override
	public String toString() {
		return "HoaDonTienDienNuocNgoai [quocTich=" + this.quocTich + ", getMaKhachHang()=" + this.getMaKhachHang()
				+ ", getHoTen()=" + this.getHoTen() + ", getNgayRaHoaDon()=" + this.getNgayRaHoaDon() + ", getSoLuong()="
				+ this.getSoLuong() + ", getDonGia()=" + this.getDonGia() + ", getThanhTien()=" + this.getThanhTien() + "]";
	}

}
