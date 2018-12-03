package Homework02;

/*
 * Bài 4 
 * Class con Giao Dịch Đất
 */
public class GiaoDichDat extends BatDongSan{
	private String loaiDat;
	
	public GiaoDichDat() {
		super();
		this.loaiDat = null;
		this.setThanhTien(0.0f);
	}

	public GiaoDichDat(String maGiaoDich, String ngayGiaoDich, float donGia, String loaiDat, int dienTich) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiDat = loaiDat;
		if(loaiDat == "B" || loaiDat == "C") {
			float thanhTien = dienTich * donGia;
			this.setThanhTien(thanhTien);
		}
		else if(loaiDat == "A") {
			float thanhTien = dienTich * donGia * 1.5f;
			this.setThanhTien(thanhTien);
		}
		else {
			this.setThanhTien(0.0f);
		}
	}

	public String getLoaiDat() {
		return loaiDat;
	}

	public void setLoaiDat(String loaiDat) {
		this.loaiDat = loaiDat;
	}

	@Override
	public String toString() {
		return "GiaoDichDat [loaiDat=" + this.loaiDat + ", getDienTich()=" + this.getDienTich() + ", getMaGiaoDich()=" + this.getMaGiaoDich()
				+ ", getNgayGiaoDich()=" + this.getNgayGiaoDich() + ", getDonGia()=" + this.getDonGia() + ", getThanhTien()="
				+ this.getThanhTien() + "]";
	}
	
}
