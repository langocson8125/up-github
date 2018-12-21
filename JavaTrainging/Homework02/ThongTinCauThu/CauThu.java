package GiaiDe02;

import java.io.Serializable;

import Homework02.TienDien.HoaDonTienDienNuocNgoai;

public class CauThu {
	private int id;
	private String ten;
	private int namSinh;
	private String viTri;
	
	public CauThu(int id, String ten, int namSinh, String viTri) {
		this.id 		= id;
		this.ten 		= ten;
		this.namSinh 	= namSinh;
		this.viTri 		= viTri;
	}

	public CauThu() {
		this.id 		= 0;
		this.ten 		= null;
		this.namSinh 	= 0;
		this.viTri 		= null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	@Override
	public String toString() {
		return "id=" + this.id + ", ten=" + this.ten + ", namSinh=" + this.namSinh + ", viTri=" + this.viTri;
	}
}
