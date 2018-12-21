package GiaiDe3;

public class Word{
	private int id;
	private String en;
	private String vi;
	
	
	public Word(int id, String en, String vi) {
		this.id = id;
		this.en = en;
		this.vi = vi;
	}

	public Word() {
		this.id = 0;
		this.en = null;
		this.vi = null;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEn() {
		return en;
	}


	public void setEn(String en) {
		this.en = en;
	}


	public String getVi() {
		return vi;
	}


	public void setVi(String vi) {
		this.vi = vi;
	}


	@Override
	public String toString() {
		return "[English: " + en + ", Vietnamese: " + vi + "]";
	}
	
	
}
