package Homework02;

public class HoaDonTienDienVietNam extends HoaDonTienDien {
	private String doiTuongKhachHang;
	private int dinhMuc;
	
	public HoaDonTienDienVietNam() {
		super();
		this.doiTuongKhachHang 	= null;
		this.dinhMuc			= 0;
		this.setThanhTien(0.0f);
	}

	public HoaDonTienDienVietNam(String maKhachHang, String hoTen, String ngayRaHoaDon, int soLuong, float donGia, String doiTuongKhachHang, int dinhMuc) {
		super(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia);
		this.doiTuongKhachHang 	= doiTuongKhachHang;
		this.dinhMuc			= dinhMuc;
		if(soLuong <= dinhMuc) {
			float thanhTien = soLuong * donGia;
			this.setThanhTien(thanhTien);
		}
		else {
			float thanhTien = (soLuong * donGia * dinhMuc) + ((soLuong - dinhMuc) * donGia * 2.5f);
			this.setThanhTien(thanhTien);
		}
	}

	public String getDoiTuongKhachHang() {
		return doiTuongKhachHang;
	}

	public void setDoiTuongKhachHang(String doiTuongKhachHang) {
		this.doiTuongKhachHang = doiTuongKhachHang;
	}

	public int getDinhMuc() {
		return dinhMuc;
	}

	public void setDinhMuc(int dinhMuc) {
		this.dinhMuc = dinhMuc;
	}

	@Override
	public String toString() {
		return "HoaDonTienDienVietNam [doiTuongKhachHang=" + this.doiTuongKhachHang + ", dinhMuc=" + this.dinhMuc
				+ ", getMaKhachHang()=" + this.getMaKhachHang() + ", getHoTen()=" + this.getHoTen() + ", getNgayRaHoaDon()="
				+ this.getNgayRaHoaDon() + ", getSoLuong()=" + this.getSoLuong() + ", getDonGia()=" + this.getDonGia()
				+ ", getThanhTien()=" + this.getThanhTien() + "]";
	}
	
	

}
