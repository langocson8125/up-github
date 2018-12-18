package Homework02.Sach;

/*
 * Bài 2
 * Class con Sách Giáo Khoa
 */

public class SachGiaoKhoa extends Sach {
	private String tinhTrang;
	
	public SachGiaoKhoa() {
		super();
		this.tinhTrang = null;
		this.setThanhTien(0.0f);
	}

	public SachGiaoKhoa(String maSach, String ngayNhap, float donGia, int soLuong, String nhaSanXuat, String tinhTrang) {
		super(maSach,ngayNhap, donGia, soLuong, nhaSanXuat);
		this.tinhTrang = tinhTrang;
		if(tinhTrang.equals("moi")) {
			float thanhTien = soLuong * donGia;
			this.setThanhTien(thanhTien);
		}
		else if(tinhTrang.equals("cu")) {
			float thanhTien = soLuong * donGia * 0.5f;
			this.setThanhTien(thanhTien);
		}
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "SachGiaoKhoa [tinhTrang=" + this.tinhTrang + ", getMaSach()=" + this.getMaSach() + ", getNgayNhap()="
				+ this.getNgayNhap() + ", getDonGia()=" + this.getDonGia() + ", getSoLuong()=" + this.getSoLuong()
				+ ", getNhaXuatBan()=" + this.getNhaXuatBan() + ", getThanhTien()=" + this.getThanhTien() + "]";
	}
}
