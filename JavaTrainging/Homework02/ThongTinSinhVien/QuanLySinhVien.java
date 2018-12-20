package GiaiDe1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuanLySinhVien {
	private List<SinhVien> listSinhVien;
	
	public QuanLySinhVien() {
		this.listSinhVien = new ArrayList<>();
	}

	public List<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(List<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}
	
	public void readFileData() {
		try {
			List<String> allLines = Files.readAllLines(Paths.get("F:\\JAVA\\JAVA_TRAINING\\src\\GiaiDe1\\sinhvien.dat"));
			for (String line : allLines) {
				this.listSinhVien.add(this.convertLineDataToSinhVienObject(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public  SinhVien convertLineDataToSinhVienObject(String lineData) {
		String[] parts = lineData.split("\\$");
		return new SinhVien(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3]), parts[4], parts[5], Float.valueOf(parts[6]));
	}
	
	public void ShowSinhVien() {
		if(!this.listSinhVien.isEmpty()) {
			for(SinhVien SV : listSinhVien) {
				System.out.println(SV.toString());
			}
		}
		else {
			System.out.println("Danh sach rong");
		}
	}

}
