-- 3.01. Hiển thị tất cả các sinh viên theo thứ tự tăng của Tên, Họ theo mẫu sau: MASV, HOSV,
-- TENSV, NGAYSINH, HOCBONG
SELECT MASV, HOSV, TENSV, NGAYSINH, HOCBONG
FROM SINHVIEN
ORDER BY TENSV, HOSV  ASC;

-- 3.02. Hiển thị tất cả các sinh viên thuộc khoa Tin học theo thứ tự tăng của Tên, Họ theo mẫu sau:
-- MASV, HOSV, TENSV, NGAYSINH, HOCBONG
SELECT MASV, HOSV, TENSV, NGAYSINH, HOCBONG
FROM SINHVIEN
WHERE MAKH = 'TH'
ORDER BY TENSV, HOSV  ASC;

-- 3.03. Hiển thị tất cả các nữ sinh viên có học bổng theo thứ tự tăng của Tên, Họ theo mẫu sau:
-- MASV, HOSV, TENSV, NGAYSINH, HOCBONG.
SELECT MASV, HOSV, TENSV, NGAYSINH, HOCBONG
FROM SINHVIEN
WHERE NAM = 0
	AND HOCBONG > 0
ORDER BY TENSV, HOSV  ASC;

-- 3.04. Hiển thị tất cả các nam sinh viên học khoa anh văn và khoa tin học theo thứ tự tăng của Tên,
-- Họ theo mẫu sau: MASV, HOSV, TENSV, NGAYSINH, HOCBONG.
SELECT MASV, HOSV, TENSV, NGAYSINH, HOCBONG
FROM SINHVIEN
WHERE MAKH IN ('AV', 'TH')
	AND NAM = 1
ORDER BY TENSV, HOSV;

-- 3.05. Hiển thị tất cả các nam sinh viên theo thứ tự tăng của mã khoa theo mẫu sau: MAKH, MASV,
-- HOSV, TENSV, TUOI, HOCBONG.
SELECT MAKH, TENSV, HOSV, TENSV, (YEAR(GETDATE()) - YEAR(NGAYSINH)) AS TUOI , HOCBONG
FROM SINHVIEN
WHERE NAM = 1
ORDER BY MAKH;

-- 3.06. Hiển thị tất cả các nam sinh viên tuổi từ 18 đến 25 theo thứ tự tăng của mã khoa theo mẫu
-- sau: MAKH, MASV, HOSV, TENSV, TUOI, HOCBONG
SELECT MAKH, TENSV, HOSV, TENSV, (YEAR(GETDATE()) - YEAR(NGAYSINH)) AS TUOI , HOCBONG
FROM SINHVIEN
WHERE (YEAR(GETDATE()) - YEAR(NGAYSINH)) BETWEEN 18 AND 25
ORDER BY MAKH;

-- 3.07. Hiển thị tất cả các sinh viên học khoa Tin học , anh văn và có học bổng trên 120000 theo thứ
-- tự tăng của mã khoa theo mẫu sau: MAKH, MASV, HOSV, TENSV, TUOI, HOCBONG
SELECT MAKH, TENSV, HOSV, TENSV, (YEAR(GETDATE()) - YEAR(NGAYSINH)) AS TUOI , HOCBONG
FROM SINHVIEN
WHERE MAKH IN ('AV', 'TH')
	AND HOCBONG > 120000
ORDER BY MAKH;

-- 3.08. Hiển thị theo mẫu sau: MASV, HOSV, TENSV, MAMH, TENMH, DIEM, KETQUA
SELECT S.MASV, S.HOSV, S.TENSV, M.MAMH, M.TENMH, K.DIEM
FROM KETQUA AS K, MONHOC AS M, SINHVIEN AS S
WHERE K.MAMH = M.MAMH
	AND S.MASV = K.MASV
ORDER BY S.HOSV, S.TENSV ASC;

-- 3.09. Hiển thị theo mẫu sau: MASV, HOSV, TENSV, MAMH, TENMH, DIEM, KETQUA.
-- KETQUA là Đạt nếu điểm >= 5, là Rớt nếu điểm <5
SELECT S.MASV, S.HOSV, S.TENSV, M.MAMH, M.TENMH, K.DIEM, 
		CASE WHEN K.DIEM >= 5 THEN  'Đậu' ELSE 'Rớt' END AS KETQUA
FROM KETQUA AS K, MONHOC AS M, SINHVIEN AS S
WHERE K.MAMH = M.MAMH
	AND S.MASV = K.MASV
ORDER BY S.HOSV, S.TENSV ASC;

-- 3.10. Hiển thị theo mẫu sau: MASV, HOSV, TENSV, MAMH, TENMH, DIEM, KETQUA chỉ
-- những sinh viên có tên là LAN.
SELECT S.MASV, S.HOSV, S.TENSV, M.MAMH, M.TENMH, K.DIEM, 
		CASE WHEN K.DIEM >= 5 THEN  'Đậu' ELSE 'Rớt' END AS KETQUA
FROM KETQUA AS K, MONHOC AS M, SINHVIEN AS S
WHERE K.MAMH = M.MAMH
	AND S.MASV = K.MASV
	AND S.TENSV = 'LAN'
ORDER BY S.HOSV, S.TENSV ASC;

-- 3.11. Hiển thị theo mẫu sau: MASV, HOSV, TENSV, MAMH, TENMH, DIEM, KETQUA chỉ
-- những sinh có tên bắt đầu là L
SELECT S.MASV, S.HOSV, S.TENSV, M.MAMH, M.TENMH, K.DIEM, 
		CASE WHEN K.DIEM >= 5 THEN  'Đậu' ELSE 'Rớt' END AS KETQUA
FROM KETQUA AS K, MONHOC AS M, SINHVIEN AS S
WHERE K.MAMH = M.MAMH
	AND S.MASV = K.MASV
	AND SUBSTRING(S.TENSV, 1, 1) = 'L'
ORDER BY S.HOSV, S.TENSV ASC;

-- 3.12. Hiển thị theo mẫu sau: MASV, HOSV, TENSV, MAMH, TENMH, DIEM, KETQUA chỉ
-- những sinh viên có tên bắt đầu là H và T.
SELECT S.MASV, S.HOSV, S.TENSV, M.MAMH, M.TENMH, K.DIEM, 
		CASE WHEN K.DIEM >= 5 THEN  'Đậu' ELSE 'Rớt' END AS KETQUA
FROM KETQUA AS K, MONHOC AS M, SINHVIEN AS S
WHERE K.MAMH = M.MAMH
	AND S.MASV = K.MASV
	AND SUBSTRING(S.TENSV, 1, 1) IN ('H', 'T')
ORDER BY S.HOSV, S.TENSV ASC;

-- 3.13. Hiển thị điểm các sinh viên học khoa tin học và anh văn giảm dần theo điểm theo mẫu sau:
-- MAKH, MASV, HOSV, TENSV, MAMH, TENMH, DIEM.
SELECT S.MASV, S.HOSV, S.TENSV, M.MAMH, M.TENMH, K.DIEM
FROM KETQUA AS K, MONHOC AS M, SINHVIEN AS S
WHERE K.MAMH = M.MAMH
	AND S.MASV = K.MASV
	AND S.MAKH IN ('TH', 'AV')
ORDER BY K.DIEM DESC;

-- 3.14. Hiển thị các sinh viên theo thứ tự tăng của MAKH, kế đó theo thứ tự Nam trước Nữ sau theo
-- mẫu sau: MASV, HOSV, TENSV, PHAI, TUOI,MAKHOA, TENKH.
SELECT S.MASV, S.HOSV, S.NAM, S.TENSV, K.MAKHOA, K.TENKHOA
FROM KHOA AS K, SINHVIEN AS S
WHERE K.MAKHOA = S.MAKH
ORDER BY  K.MAKHOA ASC, S.NAM DESC;

-- 3.15. Hiển thị các sinh viên học khoa tin học có điểm >= 9 theo mẫu sau: MASV, HOSV, TENSV,
-- MAMH, TENMH, DIEM.
SELECT S.MASV, S.HOSV, S.TENSV, M.MAMH, M.TENMH, K.DIEM
FROM KETQUA AS K, MONHOC AS M, SINHVIEN AS S
WHERE K.MAMH = M.MAMH
	AND S.MASV = K.MASV
	AND S.MAKH = 'TH'
	AND K.DIEM >= 9;

-- 3.16. Tính tổng học bổng tất cả sinh viên
SELECT SUM(HOCBONG) AS TONGHOCBONG FROM SINHVIEN;

-- 3.17. Tính tổng học bổng, trung bình học bổng, học bổng lớn nhất, học bổng nhỏ nhất của tất cả các sinh viên.
SELECT SUM(HOCBONG) AS TONGHOCBONG,
		AVG(HOCBONG) AS TRUNGBINHHOCBONG,
		MAX(HOCBONG) AS HOCBONGLONNHAT,
		MIN(HOCBONG) AS HOCBONGNHONHAT
FROM SINHVIEN;

-- 3.18. Tính học bổng lớn nhất của khoa tin học.
SELECT MAX(HOCBONG) FROM SINHVIEN WHERE MAKH ='TH';

-- 3.19. Hiển thị sinh viên học khoa tin học có học bổng lớn nhất
SELECT TOP 1 * FROM SINHVIEN WHERE MAKH = 'TH' ORDER BY HOCBONG DESC;

-- 3.20. Cho biết tổng số sinh viên trong khoa tin học
SELECT COUNT(MASV)
FROM SINHVIEN
GROUP BY MAKH
HAVING MAKH = 'TH';










































































































