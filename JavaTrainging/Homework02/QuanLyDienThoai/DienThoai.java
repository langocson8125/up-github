package GiaiDe4;

public class DienThoai extends HangHoa{
	private String nhaSanXuat;
	private int dungLuong;
	private String mauSac;
	
	public DienThoai(String ma, String ten, float gia, String nhaSanXuat, int dungLuong, String mauSac) {
		super(ma, ten, gia);
		this.nhaSanXuat = nhaSanXuat;
		this.dungLuong 	= dungLuong;
		this.mauSac 	= mauSac;
	}
	
	public DienThoai() {
		super();
		this.nhaSanXuat = null;
		this.dungLuong 	= 0;
		this.mauSac 	= null;
	}

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public int getDungLuong() {
		return dungLuong;
	}

	public void setDungLuong(int dungLuong) {
		this.dungLuong = dungLuong;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	@Override
	public String toString() {
		return  "Ma=" + this.ma + ", Ten=" + this.ten + ", Gia=" + this.gia 
				+ ", NhaSanXuat=" + this.nhaSanXuat + ", DungLuong=" + this.dungLuong + ", MauSac=" + this.mauSac;
	}
}
