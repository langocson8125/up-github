package Homework01;

public class CD {
	private  int maCD;
	private String tuaCD;
	private String caSy;
	private int soBaiHat;
	private float giaThanh;
	
	public CD(int maCD, String tuaCD, String caSy, int soBaiHat, float giaThanh) {
		this.maCD 		= maCD;
		this.tuaCD 		= tuaCD;
		this.caSy 		= caSy;
		this.soBaiHat 	= soBaiHat;
		this.giaThanh 	= giaThanh;
	}

	public int getMaCD() {
		return this.maCD;
	}
	
	public String getTuaCD() {
		return this.tuaCD;
	}
	
	public String getTenCasy() {
		return this.caSy;
	}
	
	public int getSoBaiHat() {
		return this.soBaiHat;
	}
	
	public float getGiaThanh() {
		return this.giaThanh;
	}
	
	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}
	
	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}
	
	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}
	
	public void setSoBaiHat(int soBaiHat) {
		this.soBaiHat = soBaiHat;
	}
	
	public void setGiaThanh(float giaThanh) {
		this.giaThanh = giaThanh;
	}
	
	public String toString() {
		return "Ma CD: " + this.maCD + ", Tua CD: " + this.tuaCD + ", Ca sy: " + this.caSy + ", So bai hat: " + this.soBaiHat + ", Gia thanh: " + this.giaThanh;
	}
}
