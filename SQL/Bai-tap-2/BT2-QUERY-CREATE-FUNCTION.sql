-- 1. Viết hàm tính doanh thu của năm, với năm là tham số truyền vào.
CREATE FUNCTION DoanhThuCuaNam (@InputYear INT)
RETURNS @ResultTable TABLE (
		DoanhThu INT
	)
AS 
BEGIN
	INSERT INTO @ResultTable 
		SELECT SUM(C.SL * C.GIABAN)
		FROM CHITIETHOADON AS C, HOADON AS H
		WHERE C.MAHD = H.MAHD
			AND YEAR(H.NGAY) = @InputYear
RETURN
END;
SELECT * FROM DoanhThuCuaNam(2016);

-- 2. Viết hàm tính doanh thu của tháng, với tháng là tham số truyền vào.
CREATE FUNCTION DoanhThuCuaThang (@InputMonth INT)
RETURNS @ResultTable TABLE (
		THANG INT,
		DoanhThu INT
	)
AS 
BEGIN
	INSERT INTO @ResultTable 
		SELECT MONTH(H.NGAY) AS THANG, SUM(C.SL * C.GIABAN) AS DOANHTHU
		FROM CHITIETHOADON AS C, HOADON AS H
		WHERE C.MAHD = H.MAHD
			AND MONTH(H.NGAY) = 5
		GROUP BY MONTH(H.NGAY)
RETURN
END;
SELECT * FROM DoanhThuCuaThang(2016);

-- 3. Viết hàm tính doanh thu của khách hàng với mã khách hàng là tham số truyền vào.
CREATE FUNCTION DoanhThuKhachHang (@MaKH VARCHAR(5))
RETURNS TABLE
AS RETURN (
	SELECT H.MAKH, SUM(C.SL * C.GIABAN) AS DOANHTHU
	FROM CHITIETHOADON AS C, HOADON AS H
	WHERE C.MAHD = H.MAHD
		AND H.MAKH = @MaKH
);

SELECT * FROM DoanhThuKhachHang('KH04');

-- 4. Viết hàm tính tổng số lượng bán được cho từng mặt hàng theo tháng với mã hàng và tháng nhập
-- vào, nếu tháng không nhập vào tức là tính tất cả các tháng.
CREATE FUNCTION DoanhThuMatHangTheoThang (@MaVT VARCHAR(5), @InputMonth INT)
RETURNS @ResultTable TABLE (
			MAVT VARCHAR(50),
			DOANHTHU INT
	)
AS
BEGIN
	IF @InputMonth IS NULL 
	BEGIN
		INSERT INTO @ResultTable 
		SELECT C.MAVT, SUM(C.SL * C.GIABAN) AS DOANHTHU
		FROM VATTU AS V, HOADON AS H, CHITIETHOADON AS C
		WHERE C.MAHD = H.MAHD
			AND C.MAVT = V.MAVT
			AND C.MAVT = @MaVT
		GROUP BY C.MAVT
	END
	ELSE 
	BEGIN
		INSERT INTO @ResultTable 
		SELECT C.MAVT, SUM(C.SL * C.GIABAN) AS DOANHTHU
		FROM VATTU AS V, HOADON AS H, CHITIETHOADON AS C
		WHERE C.MAHD = H.MAHD
			AND C.MAVT = V.MAVT
			AND MONTH(H.NGAY) = @InputMonth
			AND C.MAVT = @MaVT
		GROUP BY C.MAVT
	END
RETURN
END;
-- 5. Viết hàm tính lãi ((giá bán – giá mua ) * số lượng bán được) cho từng mặt hàng, với mã mặt
-- hàng là tham số truyền vào. Nếu mã mặt hàng không truyền vào thì tính cho tất cả các mặt hàng.
CREATE FUNCTION LaiXuatMatHang (@MaMH VARCHAR(5))
RETURNS @ResultTable TABLE (
	MaMH VARCHAR(5),
	LaiXuat INT
)
AS 
BEGIN
	IF @MaMH IS NULL 
	BEGIN
		INSERT INTO @ResultTable 
			SELECT C.MAVT, SUM((C.SL * (C.GIABAN - V.GIAMUA))) AS LAIXUAT
			FROM CHITIETHOADON AS C, VATTU AS V
			WHERE C.MAVT = V.MAVT
			GROUP BY C.MAVT
	END
	ELSE 
	BEGIN
		INSERT INTO @ResultTable 
			SELECT C.MAVT, SUM((C.SL * (C.GIABAN - V.GIAMUA))) AS LAIXUAT
			FROM CHITIETHOADON AS C, VATTU AS V
			WHERE C.MAVT = V.MAVT
			GROUP BY C.MAVT
			HAVING C.MAVT = @MaMH
	END
RETURN 
END;

