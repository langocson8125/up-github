package GiaiDe4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDienThoai {
	private List<DienThoai> listDienThoai;
	
	public QuanLyDienThoai() {
		this.listDienThoai = new ArrayList<>();
	}
	
	public DienThoai initDienThoai(String ma, String ten, float gia, String nhaSanXuat, int dungLuong, String mauSac) {
		return new DienThoai(ma, ten, gia, nhaSanXuat, dungLuong, mauSac);
	}
	
	public void themDienThoai(DienThoai obj) {
		this.listDienThoai.add(obj);
		System.out.println("Info: " + obj.toString());
	}
	
	public void saveData() throws IOException {
		FileWriter fw = new FileWriter("F:\\JAVA\\JAVA_TRAINING\\src\\GiaiDe4\\dienthoai.dat", true);
		for(DienThoai DT : this.listDienThoai) {
			fw.write(DT.toString()  + "\r\n");
		}
		fw.close();
	}
}
