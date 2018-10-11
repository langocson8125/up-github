-- Câu 3: Tạo các view sau:
 -- 1. Hiển thị danh sách các khách hàng có địa chỉ là “Tân Bình” gồm mã khách hàng, tên khách
 -- hàng, địa chỉ, điện thoại, và địa chỉ E-mail.
 CREATE VIEW [CAU 3.1] AS
 SELECT MAKH, TENKHACHHANG, DIACHI, DT, EMAIL
 FROM KHACHHANG;
 -- 2. Hiển thị danh sách các khách hàng gồm các thông tin mã khách hàng, tên khách hàng, địa chỉ và
 -- địa chỉ E-mail của những khách hàng chưa có số điện thoại
 CREATE VIEW [CAU 3.2] AS
 SELECT MAKH, TENKHACHHANG, DIACHI, DT, EMAIL
 FROM KHACHHANG
 WHERE DT IS NULL;

 -- 3. Hiển thị danh sách các khách hàng chưa có số điện thoại và cũng chưa có địa chỉ Email gồm mã
 -- khách hàng, tên khách hàng, địa chỉ
 CREATE VIEW [CAU 3.3] AS
 SELECT MAKH, TENKHACHHANG, DIACHI, DT, EMAIL
 FROM KHACHHANG
 WHERE DT IS NULL
 AND EMAIL IS NULL;
 
 -- 4. Hiển thị danh sách các khách hàng đã có số điện thoại và địa chỉ E-mail gồm mã khách hàng, tên
 -- khách hàng, địa chỉ, điện thoại, và địa chỉ E-mail
 CREATE VIEW [CAU 3.4] AS
 SELECT MAKH, TENKHACHHANG, DIACHI, DT, EMAIL
 FROM KHACHHANG
 WHERE DT IS NOT NULL
 AND EMAIL IS NOT NULL;
 
 -- 9. Lấy ra các thông tin gồm Mã hóa đơn, ngày lập hóa đơn, tên khách hàng, địa chỉ khách hàng và
 -- số điện thoại
 CREATE VIEW [CAU 3.6] AS
 SELECT H.MAHD, H.NGAY, K.TENKHACHHANG, K.DIACHI, K.DT
 FROM KHACHHANG AS K, HOADON AS H
 WHERE K.MAKH = H.MAKH