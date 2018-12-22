package GiaiDe4;

public class HangHoa {
	protected String ma;
	protected String ten;
	protected float gia;
	
	public HangHoa(String ma, String ten, float gia) {
		this.ma 	= ma;
		this.ten 	= ten;
		this.gia 	= gia;
	}
	
	public HangHoa() {
		this.ma 	= null;
		this.ten 	= null;
		this.gia 		= 0.0f;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return "HangHoa [ma=" + ma + ", ten=" + ten + ", gia=" + gia + "]";
	}
}
