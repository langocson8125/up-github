CREATE TABLE KHOA (
	MAKHOA CHAR(2) PRIMARY KEY NOT NULL,
	TENKHOA CHAR(15) NOT NULL
);

CREATE TABLE MONHOC(
	MAMH CHAR(2) PRIMARY KEY NOT NULL,
	TENMH CHAR(25) NOT NULL,
	SOTIET INTEGER NOT NULL
);

CREATE TABLE SINHVIEN(
	MASV CHAR(3) PRIMARY KEY NOT NULL,
	HOSV CHAR(25) NOT NULL,
	TENSV CHAR(7) NOT NULL,
	NAM	BIT NOT NULL,
	NGAYSINH DATETIME NOT NULL,
	NOISINH CHAR(15) NOT NULL,
	DIACHI CHAR(30) NOT NULL,
	QUAN CHAR(2) NOT NULL,
	MAKH CHAR(2) NOT NULL,
	HOCBONG INTEGER DEFAULT 0,
	LYLICH NTEXT DEFAULT NULL
);

CREATE TABLE KETQUA(
	MASV CHAR(3) FOREIGN KEY REFERENCES SINHVIEN(MASV) NOT NULL,
	MAMH CHAR(2) FOREIGN KEY REFERENCES MONHOC(MAMH) NOT NULL,
	DIEM FLOAT
);

INSERT INTO KHOA (MAKHOA, TENKHOA) 
VALUES
('AV', N'Anh Văn'),
('TH', N'Tin Học'),
('TR', N'Triết'),
('VL', N'Vật Lý');

INSERT INTO MONHOC(MAMH, TENMH, SOTIET)
VALUES
('01', N'CƠ SỞ DỮ LIỆU', '60'),
('02', N'TRÍ TUỆ NHÂN ĐẠO', '45'),
('03', N'TRUYỀN TIN', '45'),
('04', N'ĐỒ HỌA', '45'),
('05', N'VĂN PHẠM', '90'),
('06', N'ĐÀM THOẠI', '120'),
('07', N'VẬT LÝ NGUYÊN TỬ', '60'),
('08', N'VẬT LÝ ĐỊA CẦU', '45'),
('09', N'TRIẾT HỌC ĐÔNG PHƯƠNG', '45'),
('10', N'TRIẾT HỌC TÂY PHƯƠNG', '45');

INSERT INTO SINHVIEN(MASV, HOSV, TENSV, NAM, NGAYSINH, NOISINH, DIACHI, QUAN, MAKH, HOCBONG, LYLICH)
VALUES
('A01', N'Nguyện thị', N'Hai', 0, '1977/02/23', N'Sài Gòn', N'12 Bis Võ văn Tần', 'Q3', 'TH', 10000, N'Sinh viên khá'),
('A02', N'Trần Văn', N'Chính', 1, '1977/12/24', N'Sài Gòn', N'34 Nguyễn Bỉnh Khiêm', 'Q1', 'TH', '1300', NULL),
('A03', N'Lưu Thị Bạch', N'Yến', 0, '1977/02/21', N'Hà Nội', N'757 Pastuer', 'Q3', 'TH', 14000, NULL),
('A04', N'Trần Anh', N'Tuần', 1, '1977/08/12', N'Long An', N'12 Điện Biên Phủ', 'BT', 'AV', 80000, NULL),
('A05', N'Trần Thanh', N'Triều', 1, '1977/01/02', N'Hà Nội', N'3 Nguyễn Thiện Thuật', 'Q3', 'AV', 80000, NULL),
('A06', N'Nguyễn Văn', N'Chính', 1, '1977/01/01', N'Sài Gòn', N'5 Nguyễn Văn Cừ', 'Q5', 'AV', 12000, NULL),
('B01', N'Trần Thanh', N'Mai', 1, '1977/12/20', N'Bến Tre', N'567 Hai Bà Trương', 'Q1', 'TH', 0, NULL),
('B02', N'Trần Thị Thu', N'Thủy', 1, '1977/02/13', N'Sài Gòn', N'400/3 An Lạc', 'BC', 'TH', 0, NULL),
('B03', N'Trần Thị', N'Thanh', 0, '1977/12/31', N'Sài Gòn', N'103 Nguyễn Thị Minh Khai', N'BT', 'AV', 0, NULL),
('B04', N'Trần Xuân', N'Diệu', 1, '1977/12/20', N'Sài Gòn', N'10 Nguyễn Hiệp', 'Q1', 'AV', 14000, NULL),
('C01', N'Hoàng Xuân', N'Quý', 1, '1975/10/20', N'Đaklak', N'56/8 Hoàng Hoa Thám', 'BT', 'AV', 0, NULL);

INSERT INTO KETQUA(MASV, MAMH, DIEM)
VALUES
('A06', '06', 8),
('B01', '01', 7),
('B01', '03', 3),
('B02', '02', 6),
('B02', '04', 10),
('B03', '01', 7),
('B03', '03', 6),
('B04', '05', 3),
('B04', '06', 4),
('A01', '01', 2),
('A01', '03', 9),
('A02', '01', 7.5),
('A02', '03', 10),
('A02', '05', 9),
('A02', '06', 6.5),
('A03', '01', 5),
('A03', '03', 3),
('A04', '05', 10),
('A04', '05', 10)

