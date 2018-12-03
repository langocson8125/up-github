package Homework02;

/*
 * Bài 1
 * Class cha - Xe
 */

public class Xe {
	private String 	maXe;
	private String 	hoTenTaiXe;
	private String 	soXe;
	private float 	doanhThu;
	
	public Xe() {
		this.maXe 		= null;
		this.hoTenTaiXe = null;
		this.soXe		= null;
		this.doanhThu	= 0.0f;
	}

	public Xe(String maXe, String hoTenTaiXe, String soXe, float doanhThu) {
		this.maXe 		= maXe;
		this.hoTenTaiXe	= hoTenTaiXe;
		this.soXe		= soXe;
		this.doanhThu	= doanhThu;
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}

	public void setHoTenTaiXe(String hoTenTaiXe) {
		this.hoTenTaiXe = hoTenTaiXe;
	}

	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		this.soXe = soXe;
	}

	public float getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(float doanhThu) {
		this.doanhThu = doanhThu;
	}
	
	@Override
	public String toString() {
		return "ChuyenXe [maChuyenXe=" + this.maXe + ", hoTenTaiXe=" + this.hoTenTaiXe + ", soXe=" + this.soXe + ", doanhThu="
				+ this.doanhThu + "]";
	}

}
