-- 1. Thực hiện việc kiểm tra các ràng buộc khóa ngoại


-- 2. Không cho phép CASCADE DELETE trong các ràng buộc khóa ngoại. Ví dụ không cho phép
-- xóa các HOADON nào có SOHD còn trong table CTHOADON.


-- 3. Không cho phép user nhập vào hai vật tư có cùng tên.


-- 4. Khi user đặt hàng thì KHUYENMAI là 5% nếu SL >100, 10% nếu SL >500.


-- 5. Chỉ cho phép mua các mặt hàng có số lượng tồn lớn hơn hoặc bằng số lượng cần mua và tính lại
-- số lượng tồn mỗi khi có đơn hàng.


-- 6. Không cho phép user xóa một lúc nhiều hơn một vật tư.


-- 7. Mỗi hóa đơn cho phép tối đa 5 mặt hàng.


-- 8. Mỗi hóa đơn có tổng trị giá tối đa 50.000.000.


-- 9. Không được phép bán hàng lỗ quá 50%.


-- 10. Chỉ bán mặt hàng GẠCH (các loại gạch) với số lượng là bội số của 100.