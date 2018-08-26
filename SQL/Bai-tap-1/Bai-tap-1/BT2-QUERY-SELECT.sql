-- 1) Xuất ra tên tỉnh cùng với dân số của các tỉnh có diện tích >= 5,000 Km2
SELECT TENTINH, DANSO 
FROM TINH
WHERE DIENTICH >= 5000;

-- 2) Xuất ra tên tỉnh cùng với diện tích của các tỉnh thuộc miền Bắc
SELECT TENTINH, DANSO 
FROM TINH
WHERE MAMIEN = 'B';

-- 3) Xuất ra các Tên tỉnh có biên giới với LÀO
SELECT T.TENTINH
FROM TINH AS T, BIENGIOI AS B
WHERE T.MATINH = B.MATINH AND B.MANUOC = 'LAO';

-- 4) Trích ra danh sách các tỉnh có tên Thị xã trùng với tên Tỉnh.
SELECT TENTINH
FROM TINH
WHERE TENTINH = THIXA;

-- 5) Trích ra danh sách các Tỉnh có mật độ dân số (DANSO / DIENTICH) trên 500 ngƣời / Km2
SELECT TENTINH, (DANSO/DIENTICH) AS MATDO
FROM TINH
WHERE (DANSO/DIENTICH) > 500;

-- 6) Trích ra danh sách các tỉnh ở miền trung có dân số trên 1 triệu ngƣời.
SELECT TENTINH
FROM TINH
WHERE DANSO > 1000000 AND MAMIEN = 'T';

-- 7) Trích ra danh sách các Tỉnh có biên giới với nƣớc có thủ đô là ‘Viên Chăn’
SELECT T.TENTINH
FROM TINH AS T, BIENGIOI AS B, NUOC AS N
WHERE T.MATINH = B.MATINH 
AND B.MANUOC = N.MANUOC
AND N.THUDO = 'VIÊN CHAN';

-- 8) Cho biết diện tích trung bình của các tỉnh
SELECT AVG(DIENTICH) AS DIEN_TICH_TRUNG_BINH
FROM TINH;

-- 9) Cho biết các nuớc biên giới (Tên nƣớc, thủ đô) của các tỉnh miền Nam
SELECT DISTINCT N.TENNUOC, N.THUDO
FROM TINH AS T, BIENGIOI AS B, NUOC AS N
WHERE T.MATINH = B.MATINH 
AND B.MANUOC = N.MANUOC
AND T.MAMIEN = 'N';

-- 10) Cho biết mật độ dân số (DANSO / DIENTICH) cùng với tên tỉnh, thị xã của tất cả các tỉnh, TP.
SELECT TENTINH, THIXA, (DANSO/DIENTICH) AS MATDO
FROM TINH;

-- 11) Cho biết tên các tỉnh láng giềng của tỉnh Long An.
SELECT T.TENTINH
FROM TINH AS T, LANGGIENG AS L
WHERE T.MATINH = L.LG
AND L.MATINH = (SELECT MATINH FROM TINH WHERE TENTINH = 'LONG AN');

-- 12) Cho biết số lƣợng các tỉnh, TP giáp với CPC
SELECT COUNT(MATINH) AS SOLUONG 
FROM BIENGIOI
WHERE MANUOC = 'CPC';

-- 13) Trích ra danh sách các tỉnh ở miền nam (Mã tỉnh, tên tỉnh, thị xã) có trên 3 tỉnh láng giềng
SELECT DISTINCT T.MATINH, T.TENTINH, T.THIXA
FROM TINH AS T, LANGGIENG AS L
WHERE T.MATINH = L.MATINH
AND (SELECT COUNT(MATINH) FROM LANGGIENG WHERE T.MATINH = MATINH) > 3;

-- 14) Cho biết tên những tỉnh, TP có diện tích lớn nhất.
SELECT TENTINH, DIENTICH
FROM TINH
WHERE DIENTICH = (SELECT MAX(DIENTICH) FROM TINH);

-- 15) Cho biết 3 tỉnh, TP có mật độ DS đông nhất.
SELECT TOP 3 (DANSO/DIENTICH) AS MATDO, TENTINH FROM TINH  ORDER BY MATDO DESC;

-- 16) Trích ra danh sách các tỉnh (Mã tỉnh, Tên tỉnh) có diện tích nhỏ hơn ‘LONG AN’, nhƣng dân số đông hơn ‘LONG AN’
SELECT MATINH, TENTINH 
FROM TINH AS T, (SELECT DIENTICH, DANSO FROM TINH WHERE TENTINH = 'LONG AN') AS TMP
WHERE T.TENTINH <> 'LONG AN' AND T.DANSO > TMP.DANSO AND T.DIENTICH < TMP.DIENTICH;

-- 17) Cho biết tên những tỉnh, TP giáp với hai nƣớc biên giới khác nhau
SELECT T.TENTINH
FROM TINH AS T, (SELECT MATINH, COUNT(MANUOC) AS SO_NUOC_LANG_GIENG FROM BIENGIOI GROUP BY MATINH) AS TMP
WHERE T.MATINH = TMP.MATINH 
AND TMP.SO_NUOC_LANG_GIENG = 2;

-- 18) Trích ra danh sách những tỉnh không giáp với nƣớc nào. (Mã tỉnh, tên tỉnh)
SELECT MATINH, TENTINH
FROM TINH
WHERE MATINH NOT IN (SELECT MATINH FROM BIENGIOI GROUP BY MATINH);

-- 19) Cho biết danh sách các miền cùng với các tỉnh, TP trong các miền đó 
-- (theo thứ tự từng miền, trong mỗi miền theo thứ tự tên tỉnh)
SELECT TENTINH, MAMIEN
FROM TINH
ORDER BY MAMIEN, TENTINH;

-- 20) Cho biết tên những tỉnh, TP có nhiều láng giềng nhất (chưa làm xong)
SELECT T.TENTINH, COUNT(L.LG) AS SO_LANG_GIENG
FROM TINH AS T, LANGGIENG AS L
WHERE T.MATINH = L.MATINH
GROUP BY T.TENTINH
HAVING COUNT(L.LG) = (SELECT MAX(TMP.NUM_NUOC)
FROM (SELECT MATINH, COUNT(LG) AS NUM_NUOC FROM LANGGIENG GROUP BY MATINH) AS TMP);

-- 21) Trích ra danh sách các tỉnh có dân số đông hơn gấp 2 lần dân số tỉnh ‘Quảng Trị’.
SELECT T.TENTINH, T.DANSO 
FROM TINH AS T, (SELECT DANSO FROM TINH WHERE TENTINH = 'QUẢNG TRỊ') AS TMP
WHERE TENTINH <> 'QUẢNG TRỊ'
AND T.DANSO > 2 * TMP.DANSO;

-- 22) Cho biết những tỉnh, TP có diện tích nhỏ hơn diện tích trung bình của tất cả tỉnh, TP.
SELECT TENTINH, DIENTICH
FROM TINH, (SELECT AVG(DIENTICH) AS AVG_DIENTICH FROM TINH) AS TMP
WHERE DIENTICH < TMP.AVG_DIENTICH;

-- 23) Cho biết Tổng số dân của từng miền (sắp theo thứ tự giảm dần của số dân)
SELECT M.TENMIEN, SUM(T.DANSO) AS TONG_DAN_SO
FROM TINH AS T, MIEN AS M
WHERE T.MAMIEN = M.MAMIEN
GROUP BY M.TENMIEN;

-- 24) Cho biết mật độ dân số của từng miền (sắp theo thứ tự giảm dần của mật độ)
SELECT M.TENMIEN, SUM(T.DANSO) AS TONG_DAN_SO
FROM TINH AS T, MIEN AS M
WHERE T.MAMIEN = M.MAMIEN
GROUP BY M.TENMIEN
ORDER BY TONG_DAN_SO DESC;

-- 25) Trích ra danh sách những tỉnh (Mã tỉnh, tên tỉnh, thị xã, mật độ) 
-- có mật độ dân số cao hơn mật độ dân số trung bình của cả nƣớc
SELECT MATINH, TENTINH, THIXA, (DANSO/DIENTICH) AS MATDO
FROM TINH, (SELECT AVG(DANSO/DIENTICH) AS MATDO FROM TINH) AS TMP
WHERE (DANSO/DIENTICH) > TMP.MATDO;

-- 26) Cho biết những tỉnh nào giáp với Campuchia và giáp với 3 tỉnh khác trở lên.
SELECT T.TENTINH, COUNT(L.LG) AS LG_TMP
FROM TINH AS T, LANGGIENG AS L, BIENGIOI AS B, NUOC AS N
WHERE L.MATINH = T.MATINH
AND B.MATINH = T.MATINH
AND B.MANUOC = N.MANUOC
AND N.TENNUOC = 'CAMPUCHIA'
GROUP BY T.TENTINH
HAVING COUNT(L.LG) >= 3;

-- 27) Cho biết tên những tỉnh giáp với các tỉnh ở miền Trung và không phải là miền Trung. (chưa làm xong)
SELECT T.TENTINH
FROM TINH AS T, LANGGIENG AS L
WHERE T.MATINH = L.LG
AND L.LG IN (SELECT T.MATINH
FROM TINH AS T, MIEN AS M
WHERE T.MAMIEN = M.MAMIEN
AND M.TENMIEN = 'TRUNG')
AND T.MAMIEN <> 'T';

--	28) Trích ra danh sách những tỉnh giáp với TPHCM nhƣng không giáp với Campuchia
SELECT DISTINCT T.TENTINH
FROM TINH AS T, LANGGIENG AS L, BIENGIOI AS B
WHERE T.MATINH = L.MATINH
AND L.LG = 'SG'
AND B.MANUOC <> 'CPC';

-- 29) Cho biết từ TPHCM có thể đi đến những tỉnh nào thông qua 1 tỉnh khác

SELECT T.TENTINH 
FROM TINH AS T, LANGGIENG AS L
WHERE T.MATINH = L.LG
AND L.MATINH IN (SELECT LG FROM LANGGIENG WHERE MATINH  ='SG')
AND L.LG <> 'SG';

-- 30) Cho biết từ Đắc Lắc có thể đi đến những nƣớc nào thông qua 1 tỉnh khác.
SELECT T.TENTINH 
FROM TINH AS T, LANGGIENG AS L, BIENGIOI AS B
WHERE T.MATINH = L.LG
AND B.MATINH = L.LG
AND B.MATINH IN (SELECT LG FROM LANGGIENG WHERE MATINH = 'DL')
AND L.MATINH <> 'DL'
AND B.MANUOC = 'CPC';
