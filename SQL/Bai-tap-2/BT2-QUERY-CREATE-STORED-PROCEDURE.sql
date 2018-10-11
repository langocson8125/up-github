-- Câu 4: Tạo các procedure sau:
-- 1. Lấy ra danh các khách hàng đã mua hàng trong ngày X, với X là tham số truyền vào.
CREATE PROC spLayDanhSachKhachHangNgayMuaHang
	@NgayMuaHang date
AS 
BEGIN
	SELECT K.TENKHACHHANG
	FROM KHACHHANG AS K, HOADON AS H
	WHERE K.MAKH = H.MAKH
	AND H.NGAY = @NgayMuaHang
END;

EXEC spLayDanhSachKhachHangNgayMuaHang '2016-05-12 00:00:00';

-- 2. Lấy ra danh sách khách hàng có tổng trị giá các đơn hàng lớn hơn X (X là tham số)
CREATE PROC spDanhSachKhachHangTongTriGia
	@GiaTriDonHang int
AS
BEGIN
	SELECT K.TENKHACHHANG, SUM(C.SL * C.GIABAN) AS GIATRIDONHANG
	FROM KHACHHANG AS K, HOADON AS H, CHITIETHOADON AS C
	WHERE K.MAKH = H.MAKH
	AND H.MAHD = C.MAHD
	GROUP BY K.TENKHACHHANG
	HAVING SUM(C.SL * C.GIABAN) > @GiaTriDonHang
END;

EXEC spDanhSachKhachHangTongTriGia 500000;

-- 3. Lấy ra danh sách X khách hàng có tổng trị giá các đơn hàng lớn nhất (X là tham số)
CREATE PROC spDanhSachKhachHangGiaTriLonNhat 
	@SoLuongKhachHang int
AS
BEGIN
	SELECT TOP (@SoLuongKhachHang) K.TENKHACHHANG, SUM(C.SL * C.GIABAN) AS GIATRIDONHANG
	FROM KHACHHANG AS K, HOADON AS H, CHITIETHOADON AS C
	WHERE K.MAKH = H.MAKH
	AND H.MAHD = C.MAHD
	GROUP BY K.TENKHACHHANG
	ORDER BY GIATRIDONHANG DESC
END;

EXEC spDanhSachKhachHangGiaTriLonNhat 2;

--	4. Lấy ra danh sách X mặt hàng có số lượng bán lớn nhất (X là tham số)

CREATE PROC spSoLuongMatHangBanLonNhat
	@SoLuongMatHang int
AS
BEGIN 
	SELECT TOP (@SoLuongMatHang) V.TENVT, SUM(C.SL) AS SL
	FROM CHITIETHOADON AS C, VATTU AS V
	WHERE C.MAVT = V.MAVT
	GROUP BY V.TENVT
	ORDER BY SL DESC
END;

EXEC spSoLuongMatHangBanLonNhat 2;

-- 5. Lấy ra danh sách X mặt hàng bán ra có lãi ít nhất (X là tham số)
CREATE PROC spMatHangLaiItNhat 
	@SoLuongMatHang int
AS 
BEGIN 
	SELECT TOP (@SoLuongMatHang) V.TENVT, SUM((C.GIABAN - V.GIAMUA) * C.SL) AS LX
	FROM CHITIETHOADON AS C, VATTU AS V
	WHERE C.MAVT = V.MAVT
	GROUP BY V.TENVT
	ORDER BY LX
END;

EXEC spMatHangLaiItNhat 3;

-- 6. Lấy ra danh sách X đơn hàng có tổng trị giá lớn nhất (X là tham số).
CREATE PROC spDanhSachDonHangGiaTriNhat
	@SoLuongDonHang int
AS
BEGIN
	SELECT TOP (@SoLuongDonHang) MAHD, SUM(SL * GIABAN) AS GT
	FROM CHITIETHOADON
	GROUP BY MAHD
	ORDER BY GT DESC
END;

EXEC spDanhSachDonHangGiaTriNhat 3;

-- 7. Tính giá trị cho cột khuyến mãi như sau: Khuyến mãi 5% nếu SL >100, 10% nếu SL>500
CREATE PROC spKhuyenMai		
AS
BEGIN
	UPDATE CHITIETHOADON 
	SET KHUYENMAI = 
		CASE 
			WHEN SL > 100 AND SL <= 500 THEN 5
			WHEN SL > 500 THEN 10
			WHEN SL <= 100 THEN 0
		END
END;
EXEC spKhuyenMai;
-- 8. Tính lại số lượng tồn cho tất cả các mặt hàng (SLTON = SLTON – tổng SL bán được).
CREATE PROC spCapNhatHangTon 
AS
BEGIN
	UPDATE VATTU
	SET SLTON = SLTON - TMP.SL
	FROM VATTU AS V, (SELECT MAVT, SUM(SL) AS SL FROM CHITIETHOADON GROUP BY MAVT) AS TMP
	WHERE V.MAVT = TMP.MAVT
END;
EXEC spCapNhatHangTon;
-- 9. Tính trị giá cho mỗi hóa đơn.
CREATE PROC spTriGiaHoaDon
AS
BEGIN
	SELECT MAHD, MAVT, SUM((SL * GIABAN) * ((100 - KHUYENMAI)/100)) AS TRIGIA
	FROM CHITIETHOADON
	GROUP BY MAHD;
END;
-- 10. Tạo ra table KH_VIP có cấu trúc giống với cấu trúc table KHACHHANG. Lưu các khách hàng
-- có tổng trị giá của tất cả các đơn hàng >=100.000.000 vào table KH_VIP.

