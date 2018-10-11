INSERT INTO VATTU (MAVT, TENVT, DVT, GIAMUA, SLTON) VALUES
('VT01', 'Xi măng', 'Bao', 50000, 5000),
('VT02', 'Cát', 'Khối', 45000, 50000),
('VT03', 'Gạch ống', 'Viên', 120, 800000),
('VT04', 'Gạch', 'thẻ Viên', 110, 800000),
('VT05', 'Đá lớn', 'Khối', 25000, 100000),
('VT06', 'Đá nhỏ', 'Khối', 33000, 100000),
('VT07', 'Lam gió', 'Cái', 15000, 50000);

INSERT INTO KHACHHANG (MAKH, TENKHACHHANG, DIACHI, DT, EMAIL) VALUES
('KH01', 'Nguyễn Thị Bé', 'Tân Bình', 84575895, 'bnt@yahoo.com'),
('KH02', 'Lê Hoàng Nam', 'Bình Chánh', 98758987, 'namlehoang@abc.com.vn'),
('KH03', 'Trần Thị Chiêu', 'Tân Bình', 84557895, null),
('KH04', 'Mai Thị Quế Anh', 'Bình Chánh', null, 'maithique123@gmail.com'),
('KH05', 'Lê Văn Sang', 'Quận 10', null, 'sanglv@hcm.vnn.vn'),
('KH06', 'Trần Hoàng Khải', 'Tân Bình', 84557897, null);

INSERT INTO HOADON (MAHD, NGAY, MAKH) VALUES
('HD001', '2016-05-12', 'KH01'),
('HD002', '2016-05-25', 'KH02'),
('HD003', '2016-05-25', 'KH01'),
('HD004', '2016-05-25', 'KH04'),
('HD005', '2016-05-25', 'KH04'),
('HD006', '2016-06-02', 'KH03'),
('HD007', '2016-06-22', 'KH04'),
('HD008', '2016-06-25', 'KH03'),
('HD009', '2016-08-15', 'KH04'),
('HD010', '2016-09-30', 'KH01');

INSERT INTO CHITIETHOADON (MAHD, MAVT, SL, GIABAN) VALUES
('HD001', 'VT01', 5, 52000),
('HD001', 'VT05', 10, 30000),
('HD002', 'VT03', 10000, 150),
('HD003', 'VT02', 20, 55000),
('HD004', 'VT03', 50000, 150),
('HD004', 'VT04', 20000, 120),
('HD005', 'VT05', 10, 30000),
('HD005', 'VT06', 15, 35000),
('HD005', 'VT07', 20, 17000),
('HD006', 'VT04', 10000, 120),
('HD007', 'VT04', 20000, 125),
('HD008', 'VT01', 100, 55000),
('HD008', 'VT02', 20, 47000),
('HD009', 'VT02', 25, 48000),
('HD010', 'VT01', 25, 57000);