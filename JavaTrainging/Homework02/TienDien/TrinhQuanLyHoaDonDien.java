package Homework02.TienDien;

import java.text.*;
import java.util.*;
/*
 * Trình quản lý hóa đơn tiền điện
 */
public class TrinhQuanLyHoaDonDien {
	/*
	 * 2 thuộc tính list chứa các hóa đơn
	 * + hóa đơn tiền điện việt nam
	 * + hóa đơn tiền điện nước ngoài
	 */
	private List<HoaDonTienDienVietNam> 	listHoaDonTienDienVietNam 	= new ArrayList<HoaDonTienDienVietNam>();
	private List<HoaDonTienDienNuocNgoai> 	listHoaDonTienDienNuocNgoai = new ArrayList<HoaDonTienDienNuocNgoai>();

	/*
	 * phương thức khởi tạo hóa đơn tiền điện Việt Nam
	 * trả về đối tượng hóa đơn tiền điện việt nam
	 */
	HoaDonTienDienVietNam initHoaDonTienDienVietNam(String maKhachHang, String hoTen, String ngayRaHoaDon, int soLuong, float donGia, String doiTuongKhachHang, int dinhMuc) {
		return new HoaDonTienDienVietNam(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia, doiTuongKhachHang, dinhMuc);
	}

	/*
	 * phương thức khởi tạo hóa đơn tiền điện nước ngoài
	 * trả về hóa đơn tiền điện nước ngoài
	 */
	HoaDonTienDienNuocNgoai initHoaDonTienDienNuocNgoai(String maKhachHang, String hoTen, String ngayRaHoaDon, int soLuong, float donGia, String quocTich) {
		return new HoaDonTienDienNuocNgoai(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia, quocTich);
	}
	
	/*
	 * phương thức thêm hóa đơn tiền điện việt nam
	 * trước khi thêm có kiểm tra sự tộn tài
	 * trả về true nếu thêm thành công 
	 * trả về false nếu hóa đơn đã tồn tại và không thêm vào được
	 */
	public boolean NhapHoaDonTienDienVietNam(HoaDonTienDienVietNam obj) {
		if(listHoaDonTienDienVietNam.contains(obj))
			return false;
		else 
			listHoaDonTienDienVietNam.add(obj);
		return true;
	}
	
	/*
	 * phương thức thêm hóa đơn tiền điện nước ngoài
	 * trước khi thêm có kiểm tra sự tộn tài
	 * trả về true nếu thêm thành công 
	 * trả về false nếu hóa đơn đã tồn tại và không thêm vào được
	 */
	public boolean NhapHoaDonTienDienNuocNgoai(HoaDonTienDienNuocNgoai obj) {
		if(listHoaDonTienDienNuocNgoai.contains(obj))
			return false;
		else 
			listHoaDonTienDienNuocNgoai.add(obj);
		return true;
	}
	
	/*
	 * phương thức xuất danh sách hóa đơn tiền điện việt nam
	 * trả về chuỗi chứa danh sách các hóa đơn
	 */
	public String XuatHoaDonTienDienVietNam() {
		if(!this.listHoaDonTienDienVietNam.isEmpty() ) {
			String result = "";
	        for (HoaDonTienDienVietNam HDTDVN :  this.listHoaDonTienDienVietNam) {
	        	result += HDTDVN.toString();
	        }
	        return result;
		}
		return "Danh sách rỗng";
	}
	
	/*
	 * phương thức xuất danh sách hóa đơn tiền điện nước ngoài
	 * trả về chuỗi chứa danh sách các hóa đơn
	 */
	public String XuatHoaDonTienDienNuocNgoai() {
		if(!this.listHoaDonTienDienNuocNgoai.isEmpty() ) {
			String result = "";
	        for (HoaDonTienDienNuocNgoai HDTDNN :  this.listHoaDonTienDienNuocNgoai) {
	        	result += HDTDNN.toString();
	        }
	        return result;
		}
		return "Danh sách rỗng";
	}
	
	/*
	 * phương thức tính tổng số hóa đơn tiền điện việt nam
	 * trả về tổng số hóa đơn
	 */
	public int TongHoaDonTienDienVietNam() {
		return this.listHoaDonTienDienVietNam.size();
	}
	
	/*
	 * phương thức tính tổng số hóa đơn tiền điện nước ngoài
	 * trả về tổng số hóa đơn
	 */
	public int TongHoaDonTienDienNuocNgoai() {
		return this.listHoaDonTienDienNuocNgoai.size();
	}
	
	/*
	 * phương thức tính trung bình cộng thành tiền của tổng số hóa đơn tiền điện việt nam
	 * trả về 1 số kiểu float là trung bình cộng thành tiền
	 */
	public float trungBinhCongThanhTienHoaDonTienDienVietNam() {
		float result = 0.0f;
		if(this.listHoaDonTienDienVietNam.isEmpty() ) {
			return result;
		}
		else {
	        for (HoaDonTienDienVietNam HDTDVN :  this.listHoaDonTienDienVietNam) {
	        	result += HDTDVN.getThanhTien();
	        }
	        return result/(this.TongHoaDonTienDienVietNam());
		}
	}
	
	/*
	 * phương thức tính trung bình cộng thành tiền của tổng số hóa đơn tiền điện nước ngoài
	 * trả về 1 số kiểu float là trung bình cộng thành tiền
	 */
	public float trungBinhCongThanhTienHoaDonTienDienNuocNgoai() {
		float result = 0.0f;
		if(this.listHoaDonTienDienNuocNgoai.isEmpty() ) {
			return result;
		}
		else {
	        for (HoaDonTienDienNuocNgoai HDTDNN :  this.listHoaDonTienDienNuocNgoai) {
	        	result += HDTDNN.getThanhTien();
	        }
	        return result/(this.TongHoaDonTienDienNuocNgoai());
		}
	}
	
	/*
	 * xuất danh sách hóa đơn tiền điện việt nam tháng 9/2013
	 * trả về chuỗi chứa danh sách các hóa đơn
	 */
	@SuppressWarnings("deprecation")
	public String xuatHoaDonTienDienVietNamTheoNgay() {
		if(!this.listHoaDonTienDienVietNam.isEmpty() ) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			String result = "";
			
	        for (HoaDonTienDienVietNam HDTDVN :  this.listHoaDonTienDienVietNam) {
			    String dateInString = HDTDVN.getNgayRaHoaDon();
			    
			    try {
			    	date = formatter.parse(dateInString);
			    	/*
			    	 * phương thức getYear() trả về hiệu của năm get được - 1900
			    	 * ví dụ năm 2013 thì phương thức getYear() trả về 2013-1900 = 113
			    	 * nên để lấy năm chỉnh xác ta cộng thêm 1900
			    	 */
			    	if(date.getMonth() == 9 && (date.getYear() + 1900) == 2013) {
			    		result += HDTDVN.toString();
			    	}

			    } catch (ParseException e) { // catch error
			    	e.printStackTrace();
			    }
	        }
		}
		return "Danh sách rông";
	}
	
	/*
	 * xuất danh sách hóa đơn tiền điện nước ngoài tháng 9/2013
	 * trả về chuỗi chứa danh sách các hóa đơn
	 */
	@SuppressWarnings("deprecation")
	public String xuatHoaDonTienDienNuocNgoaiTheoNgay() {
		if(!this.listHoaDonTienDienNuocNgoai.isEmpty() ) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			String result = "";
			
	        for (HoaDonTienDienNuocNgoai HDTDNN :  this.listHoaDonTienDienNuocNgoai) {
			    String dateInString = HDTDNN.getNgayRaHoaDon();
			    
			    try {
			    	date = formatter.parse(dateInString);
			    	/*
			    	 * phương thức getYear() trả về hiệu của năm get được - 1900
			    	 * ví dụ năm 2013 thì phương thức getYear() trả về 2013-1900 = 113
			    	 * nên để lấy năm chỉnh xác ta cộng thêm 1900
			    	 */
			    	if(date.getMonth() == 9 && (date.getYear() + 1900) == 2013) {
			    		result += HDTDNN.toString();
			    	}

			    } catch (ParseException e) { // catch error
			    	e.printStackTrace();
			    }
	        }
		}
		return "Danh sách rỗng";
	}
	
	
	/*
	 * các setter và getter
	 */
	public List<HoaDonTienDienVietNam> getListHoaDonTienDienVietNam() {
		return listHoaDonTienDienVietNam;
	}

	public void setListHoaDonTienDienVietNam(List<HoaDonTienDienVietNam> listHoaDonTienDienVietNam) {
		this.listHoaDonTienDienVietNam = listHoaDonTienDienVietNam;
	}

	public List<HoaDonTienDienNuocNgoai> getListHoaDonTienDienNuocNgoai() {
		return listHoaDonTienDienNuocNgoai;
	}

	public void setListHoaDonTienDienNuocNgoai(List<HoaDonTienDienNuocNgoai> listHoaDonTienDienNuocNgoai) {
		this.listHoaDonTienDienNuocNgoai = listHoaDonTienDienNuocNgoai;
	}
}
