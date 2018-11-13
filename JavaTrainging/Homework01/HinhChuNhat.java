package Homework01;
//Cau 1
public class HinhChuNhat {
	private int chieuDai;
	private int chieuRong;
	
	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}
	
	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}
	
	public int getChieuDai() {
		return this.chieuDai;
	}
	
	public int getChieuRong() {
		return this.chieuRong;
	}

	public String toString() {
		return "Dai: " + this.chieuDai + ", Rong: " + this.chieuRong + ", Chu vi: " + this.chuVi() + ", Dien tich: " + this.dienTich();
		
	}
	
	private int dienTich() {
		return this.chieuDai * this.chieuRong;
	}
	
	private int chuVi() {
		return (this.chieuDai + this.chieuRong)*2;
	}
}
