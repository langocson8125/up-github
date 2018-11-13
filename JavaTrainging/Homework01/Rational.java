package Homework01;
//Cau 5
public class Rational {
	private int numerator;
	private int denonminator;
	
	public Rational(int numerator, int denonminator) {
		if(denonminator > 0) {
			this.numerator 		= numerator;
			this.denonminator 	= denonminator;
			this.reduce();
		}
	}
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenonminator() {
		return this.denonminator;
	}
	
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	
	public void setDenonminator(int denonminator) {
		this.denonminator = denonminator;
	}
	
	public void reduce() {
		int UCLN = this.USCLN(this.numerator, this.denonminator);
		this.numerator 		/= UCLN;
		this.denonminator 	/= UCLN;
	}
	
    public int USCLN(int a, int b) {
        if (b == 0) return a;
        return USCLN(b, a % b);
    }
    
    public String toString() {
    	return this.numerator + "/" + this.denonminator;
    }
    
    public void reciprocal() {
    	int tmp 			= this.numerator;
    	this.numerator 		= this.denonminator;
    	this.denonminator 	= tmp;
    }
    
	public void add(int numerator, int denonminator) {
		if(denonminator > 0) {
			if(denonminator == this.denonminator) {
				this.numerator += numerator;
			}
			else {
				this.numerator = (this.numerator * denonminator + this.denonminator * numerator);
				this.denonminator *= denonminator;
			}
			this.reduce();
		}
	}
	
	public void subtract(int numerator, int denonminator) {
		if(denonminator > 0) {
			if(denonminator == this.denonminator) {
				this.numerator -= numerator;
			}
			else {
				this.numerator 		= (this.numerator * denonminator - this.denonminator * numerator);
				this.denonminator 	*= denonminator;
			}
			this.reduce();
		}
	}
	
	public void multiply(int numerator, int denonminator) {
		if(denonminator > 0) {
			this.numerator 		*= numerator;
			this.denonminator 	*= denonminator;
			this.reduce();
		}
	}
	
	public void devide(int numerator, int denonminator) {
		if(denonminator > 0) {
			this.numerator 		*= denonminator;
			this.denonminator 	*= numerator;
			this.reduce();
		}
	}
	
	public int compare(int numerator, int denonminator) {
		if(denonminator > 0) {
			if((float)(this.numerator / this.denonminator) > (float)(numerator/denonminator)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			return 0;
		}
	}
}
