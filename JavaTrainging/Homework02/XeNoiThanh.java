package Homework02;

/*
 * Bài 1
 * Class con - Xe nội thành
 */

public class XeNoiThanh extends Xe {
	private int soTuyen;
	private int soKmDiDuoc;
	
	public XeNoiThanh() {
		super();
		this.soTuyen 	= 0;
		this.soKmDiDuoc	= 0;
	}
	
	public XeNoiThanh(String maXe, String hoTenTaiXe, String soXe, int soTuyen, int soKmDiDuoc, float doanhThu) {
		super(maXe, hoTenTaiXe, soXe, doanhThu);
		this.soTuyen 	= soTuyen;
		this.soKmDiDuoc	= soKmDiDuoc;
	}

	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	public int getSoKmDiDuoc() {
		return soKmDiDuoc;
	}

	public void setSoKmDiDuoc(int soKmDiDuoc) {
		this.soKmDiDuoc = soKmDiDuoc;
	}

	@Override
	public String toString() {
		return "ChuyenXeNoiThanh [soTuyen=" + this.soTuyen + ", soKmDiDuoc=" + this.soKmDiDuoc + ", getMaChuyenXe()="
				+ super.getMaXe() + ", getHoTenTaiXe()=" + super.getHoTenTaiXe() + ", getSoXe()=" + super.getSoXe()
				+ ", getDoanhThu()=" + super.getDoanhThu() + "]";
	}	

}
