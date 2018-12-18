package Homework02.XeKhach;

/*
 * Bài 1
 * Class con - Xe ngoại thành
 */

public class XeNgoaiThanh extends Xe {
	private String 	noiDen;
	private int 	soNgayDiDuoc;

	public XeNgoaiThanh() {
		super();
		this.noiDen 		= null;
		this.soNgayDiDuoc	= 0;
	}
	
	public XeNgoaiThanh(String maXe, String hoTenTaiXe, String soXe, String noiDen, int soNgayDiDuoc, float doanhThu) {
		super(maXe, hoTenTaiXe, soXe, doanhThu);
		this.noiDen 	= noiDen;
		this.soNgayDiDuoc	= soNgayDiDuoc;
	}

	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}

	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	@Override
	public String toString() {
		return "ChuyenXeNgoaiThanh [noiDen=" + this.noiDen + ", soNgayDiDuoc=" + this.soNgayDiDuoc + ", getMaChuyenXe()="
				+ super.getMaXe() + ", getHoTenTaiXe()=" + super.getHoTenTaiXe() + ", getSoXe()=" + super.getSoXe()
				+ ", getDoanhThu()=" + super.getDoanhThu() + "]";
	}

}
