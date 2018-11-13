package Homework01;

import java.util.*;
//Cau 7
public class SinhVien2Manager {
	private final int MAX_ITEMS = 50;
	private List<SinhVien2> danhSachSinhVien = new ArrayList<SinhVien2>();

	public void initDanhSachSinhVien() {
		Scanner sc = new Scanner(System.in);
		int soSinhVien;
		System.out.println("Nhap so sinh vien: ");
		soSinhVien = sc.nextInt();
		for(int i = 0; i < soSinhVien; i++) {
			System.out.println("Nhap thong tin sinh vien thu: " + (i + 1));
			System.out.println("Nhap ma sinh vien:");
			int maSinhVien = sc.nextInt();
			System.out.println("Nhap ten sinh vien: ");
			String hoTen = sc.nextLine();
			sc.nextLine();
			System.out.println("Nhap dia chi: ");
			String diaChi = sc.nextLine();
			System.out.println("Nhap SDT: ");
			int SDT = sc.nextInt();
			danhSachSinhVien.add(new SinhVien2(maSinhVien, hoTen, diaChi, SDT));
		}
	}
	
	public void sortDanhSachSinhVien() {
		Collections.sort(this.danhSachSinhVien, new Comparator<SinhVien2>() {
            @Override
            public int compare(SinhVien2 o1, SinhVien2 o2) {
                return o1.getMaSinhVien() > o2.getMaSinhVien() ? 1 : -1;
            }
		});
	}
	
	public void showDanhSachSinhVien() {
        for (SinhVien2 sinhvien : this.danhSachSinhVien) {
            System.out.println(sinhvien.toString());
        }

	}
}
