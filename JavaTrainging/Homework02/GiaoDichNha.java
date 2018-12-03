package Homework02;

/*
 * Bài 4 
 * Class con Giao Dịch Nhà
 */

public class GiaoDichNha extends BatDongSan{
	private int 	loaiNha; // 1 - caocap, 0 - thuong
	private String 	diaChi;
	
	public GiaoDichNha() {
		super();
		this.loaiNha 	= 0;
		this.diaChi 	= null;
		this.setThanhTien(0.0f);
	}

	public GiaoDichNha(String maGiaoDich, String ngayGiaoDich, float donGia, int loaiNha, String diaChi, int dienTich) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiNha 	= loaiNha;
		this.diaChi 	= diaChi;
		if(loaiNha == 1) {
			float thanhTien = dienTich * donGia;
			this.setThanhTien(thanhTien);
		}
		else if(loaiNha == 0) {
			float thanhTien = ((dienTich * donGia) * 90) / 100;
			this.setThanhTien(thanhTien);
		}
	}

	public int getLoaiNha() {
		return loaiNha;
	}

	public void setLoaiNha(int loaiNha) {
		this.loaiNha = loaiNha;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "GiaoDichNha [loaiNha=" + this.loaiNha + ", diaChi=" + this.diaChi + ", getMaGiaoDich()=" + this.getMaGiaoDich()
				+ ", getNgayGiaoDich()=" + this.getNgayGiaoDich() + ", getDonGia()=" + this.getDonGia() + ", getThanhTien()="
				+ this.getThanhTien() + ", getDienTich()=" + this.getDienTich() + "]";
	}

}
