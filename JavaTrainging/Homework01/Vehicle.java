package Homework01;
//Cau 3
public class Vehicle {
	//  attributes
	private String tenChuXe;
	private String loaiXe;
	private int dungTich;
	private float triGia;
	private int thue;
	// methods
	//constructor
	
	public Vehicle(String tenChuXe, String loaiXe, int dungTich, float triGia) {
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}
	
	public String getTenChuXe() {
		return this.tenChuXe;
	}
	
	public String getLoaiXe() {
		return this.loaiXe;
	}
	
	public int getDungTich() {
		return this.dungTich;
	}
	
	public float getTriGia() {
		return this.triGia;
	}
	
	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}
	
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	
	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}
	
	public void setTriGia(float triGia) {
		this.triGia =triGia;
	}
	
	private float thuePhaiNop() {
		if(this.dungTich < 100) {
			this.thue = 1;
		}
		else if(this.dungTich >= 100 && this.dungTich <= 200){
			this.thue = 3;
		}
		else {
			this.thue = 5;
		}
		return (float)(this.triGia * (this.thue/100));
	}
	
	public void toStrings() {
		System.out.printf("%-20s%-20s%5d\t\t%10.2f\t\t%10.2f%n", this.tenChuXe, this.loaiXe, this.dungTich, this.triGia, this.thuePhaiNop());
	}
	
}
