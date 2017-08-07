## Hướng dẫn sử dụng Backdoor Comdom
**Chức năng chính của con này là chờ lệnh để chụp màn hình và gửi về cho client**

### Ta sử dụng máy ảo Linux, cụ thể trong đây là Ubuntu

**Các bước thực hiện như sau: **
* 1.Tạo ra 2 cửa sổ lệnh terminal
* 2.Ta qui ước hai terminal có tên là A và B
* 3.Ở terminal A, ta dùng lệnh `gcc client.cpp -o client` để compile file client ra
* 4.Tương tự như terminal A, ở terminal B ta cũng dùng lệnh `gcc server.cpp -o server -pthread`
* 5.Trong lúc compile t có thể bỏ qua các thông báo Warning
* 6.Chạy file server ở terminal B bằng cách gõ lệnh `./server`, như vậy là server đã được khởi động và đang chờ lệnh từ client
* 7.Chạy file client ở terminal A bằng cách gõ lệnh `./client dia_chi_ip_cua_may_server`
* 8.Ở terminal A ta ghi bất cữ lệnh(command) nào cũng được :D, rồi Enter để gửi.
#### Lúc này ở phía server nhận được lệnh và thực hiện chụp màn hình và gửi về cho client.

### Thế là client đã nhận được file ảnh màn hình của client 
### Chúc mọi người nghiên cứu vui vẻ
