package Homework01;

import java.util.*;

public class CD_Manager {
	List<CD> danhSachCD = new ArrayList<CD>();
	private final int MAX_ITEMS = 50;
	
	public CD_Manager() {
		// TODO Auto-generated constructor stub
	}

	public void addCD(CD CDObject) {
		int maCD = CDObject.getMaCD();
		if(this.checkCDExist(maCD) == false) {
			if(this.checkFull() == false) {
				danhSachCD.add(CDObject);
			}
			else {
				System.out.println("Danh sach da full");
			}
		}
		else {
			System.out.println("Ma Cd da ton tai");
		}
	}
	
	public boolean checkFull() {
		if(danhSachCD.size() <= this.MAX_ITEMS) {
			return false;
		}
		return true;
	}
	
	public boolean checkCDExist(int maCD) {
        for (CD cd : this.danhSachCD) {
            if(cd.getMaCD() == maCD) {
            	return true;
            }
        }
        return false;
	}
	
	public boolean checkEmpty() {
		if(danhSachCD.size() == 0) {
			return true;
		}
		return false;
	}
	
	public int countCD() {
		int numberCD = 0;
		for(CD cd : this.danhSachCD) {
			numberCD += 1;
		}
		return numberCD;
	}
	
	public int tongGiaThanhCD() {
		int totalPrice = 0;
		for(CD cd : this.danhSachCD) {
			totalPrice += cd.getGiaThanh();
		}
		return totalPrice;
	}
	
	public void hienThiDanhSachCD() {
		if(this.checkEmpty() == false) {
	        for (CD cd : this.danhSachCD) {
	            System.out.println(cd.toString());
	        }
		}
		else {
			System.out.println("Danh sach rong");
		}
	}
	
	public CD initCDObject() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma CD: ");
		int maCD = sc.nextInt();
		System.out.println("Nhap tua CD:");
		String tuaCD = sc.next();
		System.out.println("Nhap ca sy: ");
		String caSy = sc.next();
		System.out.println("Nhap so bai hat:" );
		int soBaiHat = sc.nextInt();
		System.out.println("Nhap gia thanh: ");
		float giaThanh = sc.nextFloat();
		return new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
	}
	
	// theo gia thanh giam dan
	public void sapXepDanhSachCDTheoGiaThanh() {
		if(this.checkEmpty() == false) {
			Collections.sort(this.danhSachCD, new Comparator<CD>() {
	            @Override
	            public int compare(CD o1, CD o2) {
	                return (float)(o1.getGiaThanh()) < (float)(o2.getGiaThanh()) ? 1 : -1;
	            }
			});
		}
		else {
			System.out.println("Danh sach trong");
		}
	}
	
	// theo thu tu tang dan cua tua CD
	public void sapXepDanhSachCDTheoTuaCD() {
		if(this.checkEmpty() == false) {
			Collections.sort(this.danhSachCD, new Comparator<CD>() {
	            @Override
	            public int compare(CD o1, CD o2) {
	                return o1.getTuaCD().compareTo(o2.getTuaCD());
	            }
			});
		}
		else {
			System.out.println("Danh sach trong");
		}
	}
}
