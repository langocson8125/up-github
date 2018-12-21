package GiaiDe02;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class QuanLyCauThu {

	public CauThu initCauThu(int id, String ten, int namSinh, String viTri) {
		return new CauThu(id, ten, namSinh, viTri);
	}
	
	public void themCauThu(CauThu obj) throws IOException {
		this.writeFile(obj.toString());
	}
	
	private void writeFile(String str) throws IOException {
		FileWriter fw = new FileWriter("F:\\JAVA\\JAVA_TRAINING\\src\\GiaiDe02\\cauthu.dat", true);
		
		fw.write(str + "\r\n");
	 
		fw.close();
	}
	
	private CauThu convertLineDataToCauThu(String str) {
		String[] parts 	= str.split(",");
		int ID 			= Integer.parseInt(parts[0].split("=")[1]);
		String hoTen 	= parts[1].split("=")[1];
		int namSinh 	= Integer.parseInt(parts[2].split("=")[1]);
		String viTri 	= parts[3].split("=")[1];
		
		return new CauThu(ID, hoTen, namSinh, viTri);
	}
	
	public String timKiemCauThu(String hoTen) {
		if(hoTen .equals("") || hoTen.equals(null)) return null;
		try {
			List<String> allLines = Files.readAllLines(Paths.get("F:\\JAVA\\JAVA_TRAINING\\src\\GiaiDe02\\cauthu.dat"));
			for (String line : allLines) {
				CauThu CT = this.convertLineDataToCauThu(line);
				if(CT.getTen().equals(hoTen)) {
					return CT.toString();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
