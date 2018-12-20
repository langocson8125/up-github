package GiaiDe1;

public class Person {
	protected String hoTen;
	protected String ngaySinh;
	protected String diaChi;
	protected boolean gioiTinh;
	
	public Person(String hoTen, String ngaySinh, String diaChi, boolean gioiTinh) {
		this.hoTen 		= hoTen;
		this.ngaySinh 	= ngaySinh;
		this.diaChi 	= diaChi;
		this.gioiTinh 	= gioiTinh;
	}
	
	public Person() {
		this.hoTen 		= null;
		this.ngaySinh 	= null;
		this.diaChi 	= null;
		this.gioiTinh 	= true; // mac dinh la nam - boy
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public String toString() {
		return "Person [hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh
				+ ", getHoTen()=" + getHoTen() + ", getNgaySinh()=" + getNgaySinh() + ", getDiaChi()=" + getDiaChi()
				+ ", isGioiTinh()=" + isGioiTinh() + "]";
	}
}
