package Homework02;

/*
 * Bài 3
 * Class con Giao Dịch Tiền Tệ
 */

public class GiaoDichTienTe extends GiaoDich {
	private float 	tiGia;
	private String 	loaiTien;
	
	public GiaoDichTienTe() {
		super();
		this.tiGia 		= 0.0f;
		this.loaiTien 	= null;
		this.setThanhTien(0.0f);
	}
	
	public GiaoDichTienTe(String maGiaoDich, String ngayGiaoDich, float donGia, int soLuong, float tiGia, String loaiTien) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
		this.tiGia 		= tiGia;
		this.loaiTien 	= loaiTien;
		if(loaiTien == "USD" || loaiTien == "EURO") {
			float thanhTien = soLuong * donGia * tiGia;
			this.setThanhTien(thanhTien);
		}
		else if(loaiTien == "VN") {
			float thanhTien = soLuong * donGia;
			this.setThanhTien(thanhTien);
		}
		else {
			this.setThanhTien(0.0f);;
		}
	}

	public String getLoaiTien() {
		return loaiTien;
	}

	public void setLoaiTien(String loaiTien) {
		this.loaiTien = loaiTien;
	}

	public float getTiGia() {
		return tiGia;
	}

	public void setTiGia(float tiGia) {
		this.tiGia = tiGia;
	}
}
