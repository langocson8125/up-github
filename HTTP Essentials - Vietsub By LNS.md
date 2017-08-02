# HTTP Essentials - Vietsub By Lã Ngọc Sơn

![](http://i.imgur.com/3MwpkhP.png)
### Mục lục


#### [1.Chapter 01 Introduction - HTTP, the Internet, and the Web](#1)
* [1.2 Protocol Layers](#1.2)
* [1.3 Uniform Resource Indentifers (URI)](#1.3)

#### [2.Chapter 02- Vận hành HTTP - Clients $ Server sử dụng HTTP như thế nào](#2)
* [2.1 Clients và Server](#2.1)
* [2.2 Các phương thức User](#2.2)
* [2.3 Bí mật](#2.3)
* [2.4 Việc hợp tác giữa các server](#2.4)
* [2.5 Cockies và Việc duy trì trạng thái](#2.5)

#### [3.Chapter 03 HTTP Messages - Cú pháp của giao tiếp HTTP](#3)
* [3.1 Cấu trúc của thông báo HTTP](#3.1)
* [3.2 Các Trường Header](#3.2)
* [3.3 Status code](#3.3)

#### [4.Chapter 04 Bảo mật HTTP - Bổ sung sự xác minh và sự riêng tư](#4)
* [4.1 Web Authentication](#4.1)
* [4.2 Secure Sockets Layer (SSL)](#4.2)
* [4.3 Transport Layer Security](#4.3)

#### [5. Chapter 05 Tăng tốc HTTP - Cải tiến trải nghiệm của web user](#5)
* [5.1 Load Balancing](#5.1)
* [5.2 Advanced Caching](#5.2)
* [5.3 Các kỹ thuật tăng tốc khác](#5.3)

#### HẾT


>---------------------------------------------
<a name="1.2"></a>
## 1.2 Protocol Layers
Chúng ta cùng nhìn xem HTTP mesage truyền từ Web browser của bạn tới Web server như thế nào trên Internet.

![Ảnh minh họa 1.3](http://i.imgur.com/5IfCAXH.png)

![Ảnh minh họa 1.4](http://i.imgur.com/SDCSdSK.png)

<a name="1.3"></a>
## 1.3 Uniform Resource Indentifers (URI)

Rất có khả năng, bạn đã quen biết URI, hoặc `urls`. Nó là những địa chỉ chúng ta sử dụng để đặt tên cho Website; `http://langocson.com` là một ví dụ. Mặc dù, bạn có thể hơi bị bất ngờ, khi bạn thấy `http` có liên quan tới URI, hoặc `uris`. Không có sự khác nhau nhiều giữa hai khái niệm đó. Về mặt kỹ thuật, một `url` chỉ là một dạng của `uri`. Hai thuật ngữ này tương đương nhau. Cuốn sách này thường sử dụng `uri`. Nếu mỗi khi bạn thấy `uri`, bạn có 
thể dịch nó như là `url`, điều đó không ảnh hưởng gì.

Trong nhiều trường hợp, `uri` có thể chứa nhiều thông tin, và hiểu biết kĩ về cấu trúc `uri` thì hữu ích trong việc hiểu về các khía cạnh của HTTP. Ảnh minh họa 1.5 đưa ra một `uri` đơn giản với hầu hết các thuộc tính.

![Ảnh minh họa 1.5](http://i.imgur.com/E75cNn2.png)

|Thành phần|Dùng để|
|----------|-------|
|protocol| Xác định application protocol cần thiết cho việc truy cập tài nguyên, trong trường hợp này là HTTP|
|username|Nếu giao thức hỗ trợ usernames, nó cung cấp một username để truy cập tới tài nguyên; ví dụ ở đây có một username:"guest"|
|password|Password kết hợp với username,"secret" là một ví dụ|
|host|Hệ thống chứa tài nguyên; theo HTTP thì đây là Web server; ví dụ `www.ietf.org`|
|port|TCP port- application protocol dùng để truy cập tài nguyên; mỗi giao thức có một TCP port mặc định (với HTTP là port 80); nhưng nó có thể được ghi đè lên nếu khả thi|
|path|Tạm dịch là địa chỉ chưa file muốn truy suất|
|file|Là tài nguyền muốn truy suất|
|query| Thông tin bổ sung về tài nguyên hoặc client|
|fragment|Địa chỉ đặc biệt trong một tài nguyên|

# Chapter 02- Vận hành HTTP - Clients $ Server sử dụng HTTP như thế nào
<a name="2.1"></a>
## 2.1 Clients và Server

Như nhiều giao thức truyền tin khác, `http` tạo ra hai từ khóa phân biệt giữa hai thành phần truyền tin. Trong một vài sự trao đổi dữ liệu `http`, một hệ thống thừa nhận vai trò của clients trong khi một cái khác là server. Sự khác nhau này rất là quan trọng, bởi vì `http` yêu cầu client và server phải tuân theo quy tắc và quy trình khác nhau. Trong một Web session đơn giản, Web browser là một `http` client, trong khi hệ thống hosting đóng vai trò như một `http` server. Mặc dù hai hệ thống này cùng sử dụng giao thức `http`, chúng hiển nhiên có vai trò lớn và khác nhau trong sự giao tiếp đó. Chúng ta sẽ thấy trong mục này, client - người mà luôn luôn khởi đầu giao tiếp `http`, điều khiển một vài đặc trưng quan trọng của mục này, bao gồm sự kết nối `tcp` cơ bản, sự luôn phiên và đường truyền.

### 2.1.1 Khởi tạo một giao tiếp

Sự khác nhau rõ rệt nhất giữa http client và server là vai trò trong việc khởi đầu một giao tiếp. Chỉ có client mới có thể làm việc đó. Một server có thể chứa nhiều thông tin nó có thể cung cấp và nhiều hàm nó có thể thực hiện, nhưng nó làm những việc đó chỉ khi được yêu cầu để làm bởi một client. Một `http` client request, `http` server sẽ response.

Ảnh 2.1 đưa ra một sự trao đổi điển hình. Web browser, trong vai trò là một client, gửi một request tới Web server. Server sau đó gửi lại một response tới client đó. Một client có thể thực hiện nhiều hành động hơn dựa trên sự phản hồi của server, nhưng `http` xem xét hành động đó là một sự trao đổi dữ liệu hoàn toàn mới. Sự trao đổi dữ liệu mới đó, như các sự trao đổi dữ liệu `http`, bắt đầu với một request của client.

![Ảnh 2.1](http://i.imgur.com/H1PDC8i.png)

**Hình 2.1: Client bắt đầu một giao tiếp trao đổi dữ liệu bằng việc gửi một yêu cầu tới một server. Server phản hồi yêu cầu của client. Nó không tự tạo ra giao tiếp**

### 2.1.2 Kết nối

Giống như các application protocol mà sử dụng `tcp`, `http` yêu cầu một kết nối `tcp`. Bởi vì client có vai trò khởi tạo một giao tiếp `http`  , client cũng có trách nhiệm khởi tạo ra 1 kết nối `tcp`. Như ảnh minh họa 2.2 cho thấy, quy trình này yêu cầu sự trao đổi dữ liệu của 3 `tcp` message. `tcp` message được trình bày trong dòng chữ màu xám.
Sau sự trao đổi dữ liệu `tcp` ban đầu, client có thể gửi các `http` request của nó. Những request này được server phản hồi bằng các dòng chữ màu đen. Ảnh minh họa cũng cho thấy thông báo yêu cầu đóng một kết nối `tcp`. Server khởi tạo sự trao đổi dữ liệu này bởi vì nó biết khi nào nó có đủ các yêu cầu của client.

**Hình 2.2: Message đầu tiên, client gửi một SYN, "synchronize" flag. SYN chỉ ra rằng client muốn tạo ra một kết nối. Server phản hồi bằng việc thiết lập SYN và ACK ("acknowledge") flag và nó đã chấp nhận kết nối. Client hoàn thành việc tạo kết nối bằng việc gửi một TCP message chỉ với ACK flag. Ba message này thường được gọi là "three-way handshake". Việc đóng kết nối chỉ yêu cầu hai message. Cái đầu tiên chứa FIN ("finished") flag và cái thứ hai chứa cả bộ FIN và ACK flag.**

![Hình 2.2](http://i.imgur.com/oO2pgcC.png)

### 2.1.3 Persistence ( Kết nối không ngừng )

Phiên bản đầu tiên của HTTP yêu cầu client thiết lập một kết nối `tcp` riêng lẻ với mỗi request. Ví dụ trang Web, sự yêu cầu không đưa ra nhiều lỗi. Mặc dù vì các trang web ngày càng phát triển phức tạp và đồ họa hơn, việc tạo ra kết nối `tcp` bắt đầu có sự ảnh hưởng đáng kể đến hiệu năng Web. Bởi vì Web page có chứa nhiều object tách rời, và client phải tạo ra một `http` request riêng lẻ để lấy mỗi object đó. Ví dụ trang web trong hình 2.3, nó chứa hơn 20 object. Với phiên bản `http` trước, trình duyệt Web phả thiết lập hơn 20 kết nối riêng lẻ trước khi chúng có thể hiển thị lên trang.

![Ảnh 2.3](http://i.imgur.com/QTwt5sW.png) 

**Hình 2.3: Trang web phức tạp như thế này chứa nhiều object, mỗi object request một HTTP message trao đổi dữ liệu để nhận được. Trong ví dụ này, trang chính là một object, và mỗi yếu tố đồ họa là một object tách rời. Nhìn chung, một client phải tạo ra 20 yêu cầu HTTP tách rời trước khi nó có thể hiển thị lên trang web**

Phiên bản 1.1 của  giao thức `http`  triệt tiêu vấn đê đa kết nối `tcp` với một được điểm được biết đến đó là `persistence`.( Mặc dù persistence được giới thiệu trong phiên bản 1.0, không phải hầu hết các hệ thống có thể hỗ trộ nó; với phiên bản 1.1 nó được coi như là mặc định). Persistence cho phép một client tiếp tục sử dụng kết nối `tcp` sau khi các request ban đầu của nó được hoàn thành. Client tạo ra nhiều request mới trên cùng một kết nối. Ví dụ trong hình 2.4 .

![Ảnh 2.4](http://i.imgur.com/qaq3fZp.png)

**Hình 2.4: Với kết nối không ngừng, một client có thể tạo ra nhiều request HTTP qua một kết đối TCP đơn giản. Request đầu tiên trong step 4 - được server phản hồi trong step 5. Trong step 6, client tiếp tục việc đó bằng cách gửi tới server một request khác trên cùng một kết nối TCP. Máy chủ phản hồi tới request này trong step 7 và sau đó đóng kết nối TCP.**

Sự tiếp tục đó đòi hỏi sự hợp tác từ cả client và server. Client phải đưa ra quyết định để sử dụng kết nối một cách liên tục. Tuy nhiên, nó có thể làm được với điều kiện là server cho phép nó. Server không phải đóng kết nối TCP sau khi đầy đủ request từ client.

<a name="2.2"></a>
## 2.2 Các phương thức User

Giao thức `http` xác định 4 phương thức cơ bản -- `GET,POST,PUT & DELETE`. Ngoài ra còn có vài phương thức mới.

### 2.2.1 Web Page Retrieval - GET

Phương thức đơn giản nhất của `http`  là `GET`. Nó là việc client lấy một object từ server. Trên một Web, browser request một trang từ web server với một `GET`. Ví dụ, ấn vào đường dẫn ở giữa hình 2.7 sẽ buộc browser phải tạo ra một `GET` request tới server để request một trang web mới để hiện thị.

![Ảnh 2.7](http://i.imgur.com/3Q98RqZ.png)

Như hình 2.8 cho thấy, `GET` là là một sự trao đổi hai message đơn giản. Client khởi đầu bằng việc gửi 1 `GET` message tới máy chủ. Message nhận dạng object mà client đang request với một Uniform Resource Identifier (URI).
Nếu server có thể trả về object được request đó, nó sẽ thông qua 1 response. Như ảnh đó cho thấy, server biểu thị sự thành công đó bằng một appropriate status; `200 OK` là một status code cho một response thành công. Cùng với status code, server chứa những object trong response của nó. Nếu server không thể trả về object được request, nó có thể trả về nhiều loại status code khác nhau. Mục 3.3 sẽ chi tiết về các status code của HTTP.

![Ảnh 2.8](http://i.imgur.com/u4ThxMb.png)

**Ảnh 2.8: Một phản hồi tới một yêu cầu GET bằng việc trả về tài nguyên yêu cầu, thường là một trang mới. Trang mới là dữ liệu của response.**

### 2.2.2 Web form - POST

Trong khi `GET` buộc server gửi thông tin tới một client, phương thức `POST` gúp client gửi thông tin tới server. Web browser thường sử dụng phương thức `POST` để gửi form tới web server. Hình 2.9 cho thấy một ví dụ phổ biến của một form. Nó mà một trang Web mà cho phép người dùng tìm kiếm. Khi là người dùng ấn vào nút "Search", trình duyệt gửi 1 `POST` request tới server; request bao gồm thông tin mà user cung cấp trong form đó.

![Ảnh 2.9](http://i.imgur.com/5DEgIgw.png)

**Ảnh 2.9: Gửi một web form thường được trình duyệt gửi một POST request tới server. POST message chứa một form dữ liệu. Trong ví dụ này, dữ liệu POST sẽ bao gồm search term("HTTP"), phạm vi (All file), phần trăm kết quả của trang(25), và phương thức liên kết (FTP).**

Như hình 2.10 cho thấy, phương thức `POST` gần giống `GET`. Client gửi một `POST` message chứa thông tin nó mong muốn gửi tới server. Như `GET` message, một phần của `POST` message là một URI. Trong trường hợp này, `uri` nhận dạng object trên server mà có thể xử lý thông tin chứa trong đó. Trên web server, uri này thường là một chương hình hoặc một đoạn script.

![Ảnh 2.10](http://i.imgur.com/83Jh1ds.png)

**Hình 2.10: Một response của server từ POST request bằng việc trả về thông tin mới như là kết quả tìm kiếm. Thông tin này được gửi kèm dữ liệu trong phản hồi**
Cũng gống như phương thức `GET`, một server có thể trả về thông tin của nó như một phần của response. Thông tin này là một trang web để hiển thị, thường là một trang báo nhận ngững gì mà người dùng đã thêm vào; trong trường hợp này là một form tìm kiếm, trang web mới thường đưa ra kết quả tìm kiếm.

### 2.2.3 File Upload - PUT

Phương thức `PUT` giúp client gửi thông tin tới server. Nó hoàn toàn khác so với phương thức `POST`, mặc dù nhìn hình 2.11 thì cả hai trông có vẻ giống nhau. Với phương thức `POST`, client gửi một method, uri, và data. Server trả về một status code và dữ liệu một cách tùy chọn.

![Hình 2.11](http://i.imgur.com/CopaPua.png)

**Hình 2.11: Client có thể sử dụng yêu cầu PUT để gửi một object mới tới một server. URI là một phần của yêu cầu báo cho server biết nơi để put object.**

Sự khác nhau giữa `POST` và `PUT` là trong việc server thông dịch URI như thế nào. Với một `POST`, URI xác định một object trên server mà có thể xử lý dữ liệu chứa trong đó. Trái lại, với một `PUT`, URI xác định một object nơi mà server nên đặt dữ liệu vào. Trong khi một `POST URI` thường biểu hiện dưới dạng một chương trình hay một script, còn `PUT URI` thì thường là các path và tên cho một file. Hình 2.12 cho ta một ví dụ về hoạt động của phương thức `PUT`. Trên trang này user xác định địa chỉ gốc của file. Bằng việc ấn vào nút Upload, user yêu cầu browser gửi một `PUT` request tới server.

![Hình 2.12](http://i.imgur.com/Bjz8s1O.png)

**Hình 2.12: PUT request có thể được sử dụng để tải liên một file tới server.**

### 2.2.4 File Deletion - DELETE

Với phương thức `PUT` và `GET`, HTTP trở thành một giao thức phục vụ cho việc truyền tải file đơn thuần. Phương thức `DELETE` - chức năng của nó là giúp client xóa object từ server. Như hình 2.13 cho thấy, client gửi `DELETE` message cùng với URI của object mà server nên xóa. Server response với một status code và nhiều dữ liệu tùy chọn cho client.

![Ảnh 2.13](http://i.imgur.com/lYAYJbW.png)

**Ảnh 2.13: Phương thức DELETE cho phép một client xóa bỏ object từ server. URI xác định object để xóa.**
<a name="2.3"></a>
## 2.3 Bí mật :D
Ba giao thức tiếp theo, `TRACE`, `HEAD` và `OPTION`, hoạt động trong bí mật.n HTTP còn một một phương thức khác đó là `CONNECT`. Khó mà định nghĩa `CONNECT` làm việc như thế nào, ngoại trừ việc chỉ ra rằng nó có mục đích hỗ trợ việc trao đổi.(Sẽ thấy trong mục 2.4.3). Các tiện ích trong tương lai sẽ giúp định nghĩa `CONNECT` chi tiết hơn.

### 2.3.1 Capabilities - OPTIONS

Client sử dụng `OPTION` message để tìm ra những phương thức mà server hỗ trợ. Sự trao đổi dữ liệu này giống chuẩn request và response, như hình 2.4 minh họa. Nếu client chứa URI, server phản hồi với những tùy chọn liên quan tới object. Nếu client gửi một dấu *, như là URI, server sẽ trả về các tùy chọn phù hợp với tất cả các object.

Client có thể sử dụng `OPTION`message để xác định phiên bản của HTTP mà server hỗ trợ, hoặc trong trường hợp là một URI rõ ràng, một phương pháp mã hóa sẽ được server cung cấp cho object đó.

![Ảnh 2.14](http://i.imgur.com/IjFhD17.png)

**Ảnh 2.14: Client có thể sự dụng yêu cầu OPTION để tìm hiểu về một object đặc biệt hoặc về bản thân server. Server trả về các sự chọn lựa dữ liệu trên response.**

### 2.3.2 Message - HEAD

Phương thức `HEAD` gần giống phương thức `GET`, ngoại trừ là server không trả về object được yêu cầu. Như hình 2.15 cho thấy, server trả về một message nhưng không có dữ liệu. ( HEAD là viết rút gọn của "header", bởi vì server chỉ trả về thông báo header trong phản hồi). Client có thể sử dụng thông báo `HEAD` khi nó muốn xác thực các object có tồn tại, nhưng nó thực sự không cần truy xuất đến object. Ví dụ,  các chương trình xác thực link trong web page, có thể sử dụng thông báo `HEAD` để đảm bảo một liên kết dẫn đến object phù hợp mà không cần phải tốn băng thông mạng và tài nguyên server. Cache server cũng có thể sử dụng phương thức `HEAD`; nó giúp chúng thấy nếu một object thay đổi mà không nhất thiết phải truy xuất toàn bộ object.

![Ảnh 2.15](http://i.imgur.com/tAMwQdp.png)

**Ảnh 2.15: Yêu cầu HEAD tương tự phương thức GET, ngoại trừ là server không thực sự trả về object được yêu cầu, chỉ trả về HTTP headers.**

### 2.3.3 Path - TRACE
`TRACE` message giúp user cách để kiểm tra đường dẫn mạng tới server. Khi một server nhận một `TRACE`, nó phản hồi bằng cách copy `TRACE` message vào trong data cho response đó. Ví dụ trong hình 2.16.

![Hình 2.16](http://i.imgur.com/zqyvc8T.png)

`TRACE` message hữu ích hơn khi nhiều server cùng liên quan tới việc response tới một request. Ví dụ, một server trung gian có thể chấp nhận request từ client nhưng nó quay lại và gửi request đó tới server bổ sung. ( Proxy and cache server được đề cập đến trong mục mục tiếp theo, là ví dụ của các máy chủ trung gian). Khi có một server trung gian, `TRACE` làm việc như hình 2.17. Server trung gian chỉnh sửa request bằng việc thêm vào via-option trong thông báo. Via-option là một phần của message chuyển đến server, nó được sao chép vào dữ liệu response của server. Khi client nhận được response, nó có thể thấy via-option trong dữ liệu và nhận dạng những server trung gian trên đường dẫn. Mục 3.2.34 mô tả tiến trình đó một cách chi tiết.

![Ảnh 2.17](http://i.imgur.com/bjrlUsA.png)

**Ảnh 2.17: Yêu cầu TRACE cho phép client tìm ra đường dẫn của thông báo theo sau qua một mạng của các máy chủ trung gian.**
<a name="2.4"></a>
## 2.4 Việc hợp tác giữa các server

Ngoại trừ `TRACE` message, chương này không tập trung nhiều vào giao tiếp giữa một client và một server. Trong mục này, chúng ta sẽ thấy những cách khác nhau mà nhiều server có thể liên quan tới một giao tiếp trao đổi dữ liệu.
 
### 2.4.1 Các host ảo

Trong tất cả các bản nâng cấp, phiên bản 1.1 hỗ trợ trực tiếp cho các host ảo. Mặc dù giao thức thay đổi ít, nhưng đặc điểm đó là lợi ích chính cho WWW. Host ảo hỗ trợ nhắm đến yếu tố then chốt của cấu trúc Web  mà phiên bản 1.0 chưa làm được -  nhà cung cấp Web host.

![Ảnh 2.18](http://i.imgur.com/B3OyN9D.png)

**Hình 2.18: Virtual hositing cho phép nhiều địa chỉ trang web chia sẻ web server. Cấu hình này điển hình trong ISPs mà cung cấp web hosting cho doanh nghiệp nhỏ và các cá nhân.**

Vấn đề đối mặt một hosting chứa nhiều website là: khi một client request một webpage, làm sao để server biết cái site mà client muốn? Xem xét một request của client cho việc phản hồi web page tới "http://www.company1.com/news.html", tới một địa chỉ IP. Sau đó, như hình 2.19 cho thấy, nó tạo ta một kết nối TCP và gửi lệnh `GET` `news.html` tới địa chỉ đó. Chú ý, web server đó không tham gia vào giải quyết DNS, nên nó không biết host nào mà client dự tính liên hệ. Web server không có cách nào để biết cái "news.html" liên quan tới company1.com hay company2.com.

![Ảnh 2.19](http://i.imgur.com/QambNv3.png)

**Hình 2.19: Virtual host có thể gây khó cho web server trong việc quyết định trang nào mà client muốn truy cập tới. Trong trường hợp này, web server vật lý không biết địa chỉ web nào mà client yêu cầu bởi vì nó đã không tham gia vào việc trao đổi dữ liệu DNS mà đã vạch ra hostname tới địa chỉ IP của nó.**

Nhà cung cấp web hosting chỉ có 2 cách để giải quyết vấn đề. Họ có thể yêu cầu trang web phải sử dụng duy nhất URI cho tất cả các trang của web. Nên nếu company1.com nó một trang tên là "news1.html" trên trang quả nó, company2.com không thể sử dụng cái tên đó trên trang của nó. Cách khác, nhà cung cấp web hosting có thể gán địa chỉ ip riệng biệt đó cho mỗi site trên server của họ. Server kết thúc với rất nhiều địa chỉ IP, và các địa chỉ IP là các tài nguyên hiếm.

Với phiên bản 1.1 nhắm đến vấn đề của virtual host với sự bổ sung đơn giản vào request của client. Sự bổ sung này là `Host` header, nơi mà client phải thay thế host name của trang nó đang request. Như hình 2.20 cho thấy, server có thể dễ dàng xác định đúng site được yêu cầu và trả về tài nguyên phù hợp.

![Ảnh 2.20](http://i.imgur.com/riFZAlm.png)

**Ảnh 2.20: Đặc điểm của host trong phiên bản 1.1 cho phép client hoàn toàn nhận dạng được web site mà họ đang truy cập, nên virtual host web server có thể trả về đúng nội dung.**

### 2.4.2 Redirection - Sự chuyển hướng

Trong khi virtual host cho phép một server đơn hỗ trợ đa web site một cách dễ dàng, sự chuyển hướng đưa ra một cách để hỗ trợ **một trang web đơn để sử dụng đa server**. Sự chuyển hướng cho phép server chuyển hướng một client tới một uri khác cho một object. Hình 2.21 cho thấy tiến trình đó. Đầu tiên client request một object từ web server đầu tiên. Tuy nhiên, thay vì trả về object được yêu cầu, server trả lời với một status code `301 Moved`. Response cũng chỉ ra một URI mới cho object. Client nhận ra URI này, và trong step 3 nó tái tạo lại một request. Lần này `GET` request thành công, và server thứ hai trả về object thực sự.

![Ảnh 2.21](http://i.imgur.com/r0mqt7G.png)

**Hình 2.21: Một server chuyển hướng một client để báo cho client là object nó request được đặt ở một nơi nào đó. Trong step 2, khi mà client nhận một response 301 Moved, nó tìm kiếm một URI mới trong response message và tạo ra GET request mới cho URI đó.**

Chú ý rằng sự chuyển hướng không phải là xác định một host khác. Sự chuyển hướng được sử dụng để thông báo cho client biết về đường dẫn mới tới tài nguyên trên cùng một host. Cũng chú ý rằng có nhiều kỹ thuật tương tự. Ví dụ, server có thể trả lời request gốc bằng việc cung cấp một JavaScript object mà nó tự động chuyển hướng client tới một nơi đặt mới.

### 2.4.3 Proxies, Gateways,và Tunnels
Một cách khác mà HTTP server có thể tương tác với nhau là proxies, gateways và tunnels. Server mà client liên kết đầu tiên chuyển request tới server mới và sau đó chuyển trả lại client. Hình 2.22 cho thấy một proxy server trong hoạt động.

![Ảnh 2.22](http://i.imgur.com/E0hhbx3.png)
**Hình 2.22: Vị trí của một proxy server ở giữa client và server. Nó gửi request thay cho client và chuyển tiếp response từ máy chủ về client.**

Trong hình đó, đầu tiên client gửi HTTP request trực tiếp tới proxy server. Tuy nhiên, server đó không thể phản hồi tới client ngay lập tức. Thay vào đó, nó tái tạo một request tới server thứ hai, cái được dán nhãn là "origin server"(server gốc chứa object). GET request thứ hai có một URI giống hệt cái ban đầu; nó đơn thuần là được gửi tới một server mới. Server đó xử lý GET request thứ hai như thể nó đến từ một client và phản hồi nó với object được request. Proxy server sau đó có thông tin client request, và nó trả lại object đó tới client trong step 4.

Mặc dù hình 2.22 chỉ có 1 proxy, nhưng HTTP cho phép nhiều proxy tham gia. Các proxy từ một dây chuyền như hình 2.23, bàn giao request từ cái này tới cái kia cho tới khi object được request được tìm thấy. Sau đó các proxy truyền object đó trở lại client theo chiều ngược lại. Khi mỗi server xử lý một request, nó thêm các đặc trưng riêng vào `Via` header trong request. Lúc request đến server cuối cùng, `Via` header sẽ giữ lại path mang theo bởi request qua chuỗi server. Response theo sau cùng tiến trình, với mỗi hệ thống trung gian việc thêm vào đặc trưng riêng của nó trong `Via` header. (Chú ý hình 2.23 chỉ cho thấy một phần của `Via` header; để chi tiết hơn, xem mục 3.2.50).

![Ảnh 2.23](http://i.imgur.com/bUv06Vg.png)

**Hình 2.23: Proxy server tạo hoặc cập nhật Via option khi chuyển tiếp yêu cầu hoặc phản hồi.**

**Proxy server** thực hiện các chức năng quan trọng cho việc giao tiếp HTTP. Phổ biến nhất là việc hỗ trợ caching, mục 2.4.4 miêu tả chi tiết hết. Một sự hợp tác có thể chỉ dẫn cho tất cả các client nội bộ để truy cập internet công cộng, cho phép proxy server lọc các truy cập đó một cách phù hợp. Kiểu phương thức này thường là một phần của firewall. Proxy server cũng được sử dụng để cung cấp sự ẩn danh tới Web server, không cho khai thác thông tin client.

Nếu một proxy phục vụ cho nhiều server gốc, sau đó client phải chứa URI tuyệt đối trong request của nó. Nếu URI không đầy đủ, proxy sẽ không thể báo rằng server nào mà client muốn kết nối. Chương 5 mô tả các cơ cấu mà hệ thống quản trị có thể sử dụng để tự động cấu hình proxy server cho user của họ.

**Gateway** và **Tunnel** hoạt động gần giống proxy server; tuy nhiên, chúng có sự khác biệt riêng. Gateway hoạt động như là một điểm cuối của chuỗi server, nhưng chúng vẫn dựa vào các server khác để cung cấp tất cả hoặc một phần của object được yêu cầu. Trong nhiều trường hợp, gateway sử dụng một giao thức thay vì HTTP để truy cập project. Ví dụ trong hình 2.24, gateway sử dụng Structured Query Language để lấy thông tin từ một hệ thống quản lý dữ liệu.

![Ảnh 2.24](http://i.imgur.com/97NdO7m.png)

**Hình 2.24: Một gateway chấp nhận HTTP request và dịch chúng thành một định dạng khác điển hình như là SQL. Gateway cũng đảm bảo rằng các câu trả lời là một phản hồi HTTP phù hợp.**

Trong khi gateway hoạt động như một điểm cuối của một chuỗi server. Tunnle thì hoàn toàn đối nghịch. Như hình 2.25 minh họa, chúng liên qua rõ rệt với client gốc; client thậm chí không thể nhận thức được rằng một sự tồn tại của tunnel. Tunnel cung cấp các dịch vụ. Tuy nhiên, trong ví dụ của hình 2.25, tunnel tạo ra một kết nối an toàn để server thực, bổ sung sự an toàn giao tiếp giữa client và server. Chú ý rằng mặc dù HTTP 1.1 định nghĩa hoạt động của tunnel trong các thuật ngữ chung.

![Ảnh 2.25](http://i.imgur.com/a2Cd1Vg.png)

**Một tunnel cho phép một client giao tiếp trực tiếp với server. Trong ví dụ này, tunnel tạo ra một đường dẫn an toàn cho yêu cầu của client và phản hồi của server.**

### 2.4.4 Cache Servers

Cache server là một dạng đặc biệt của proxy server mà mục đích chính của nó là cải thiện hiệu năng của Web. Nó làm việc đó thông qua lưu trữ object được request bởi client và nếu object đó được request lại (có thể là cùng client hoặc là khác client), nó trả về object mà chúng lưu lại thay vì request object đó từ server gốc. Hình 2.26 và 2.27 cho thấy tiến trình đó.

![Ảnh 2.26](http://i.imgur.com/CJ8rpNp.png)

**Hình 2.26: Cache server là các proxy server mà chuyển các request và response. Ngoài ra, chúng giữ một bản sao của mỗi response chúng nhận được.**

Hình đầu tiên cho thấy một chuẩn vận hành proxy. Chìa khóa để một cache server vận hành là nó ghi nhớ lại object được request, thường thì bằng việc lưu lại một bản sao trên local disk hoặc trong bộ nhớ của nó.

![Ảnh 2.27](http://i.imgur.com/O2Cksog.png)

**Hình 2.27: Khi một client mới request một object giống vậy, cache serverr trả về bản sao của nó thay vì gửi request khác tương tự tới server gốc. Việc này làm tăng tốc độ phản hồi, và nó tiết kiệm băng thông cho kết nối Internet.**

Trong hình 2.27, một request của client mới giống object trong hình 2.26. Tuy nhiên lần này, cache server không cần kết nối tới serger gốc. Nó đơn giản trả về object đã được lưu từ  local disk hoặc memory của nó.

Cache server cải thiện hiệu năng của Web về cả 2 phần là client và server. Đối với client, chúng làm ngắn khoảng cách đến object cần thiết đến client. Như hình 2.26 và 2.27 minh họa, một cache server có thể được định điểm trên cùng mạng nội bộ như là client của nó. Mạng nội bộ thường có băng thông cao hơn so với mạng rộng Internet, và thời gian trao đổi tốn ít hơn.

Cache server cũng cải thiện hiệu năng bằng việc giảm tải trên server gốc. Khi một cache server trả về một object tới một client, sẽ có ít request làm phiền server gốc. Ít request hơn động nghĩa với việc rút ngắn thời gian xử lý và ít tốn tài nguyên bộ nhớ hơn đó là điều server gốc đòi hỏi, đồng thời đỡ tốn băng thông hơn cho việc kết nối một Internet.

Một trong những vấn đề phức tạp phải đối mặt là cache server biết được object đó được lưu bao lâu rồi. Như chúng ta sẽ được thấy trong mục 3.2, HTTP 1.1 bao gồm vài header chỉ để hỗ trợ cache server. Các header đó báo cache server rằng object đó có được lưu tạm hay không, nếu được, nó có thể lưu lại an toàn trong bao lâu. Mục 5.2 nghiên cứu sự vận hành của cache server chi tiết hơn, tập trung vào các mặt bên ngoài phạm vị của qui cách HTTP.

### 2.4.5 Đếm và giới hạn lượt truy cập

Mỗi khi một cache serrver trung gian xử lý request của client, server gốc có thể mất kiểm soát sự tương tác của nó với client. Về nhiều mặt đó là một lợi ích, điển hình như là cache server giảm tải cho server gốc và có thể cải thiện đáng kể hiệu năng của nó. Tuy nhiên cũng có nhiều bất tiện. Với nhiều Web site, có một cache deliver page tới client là một vấn đề đáng kể bởi vì nó đồng nghĩa với việc server gốc không biết user truy cập những nội dung thường xuyên như thế nào. Khi mà doang thu của trang web từ việc quảng cáo, việc đếm số lượt truy cập của user là rất quan trọng để tối ưu hóa doanh thu. Các nhà phát triển HTTP nhận ra vấn đề này và đưa vào  một kỹ thuật mà cho phép caching và tuy nhiên vẫn giúp server có thể đếm và giới hạn truy cập trang bằng cache server client. Kỹ thuật này là một tiện ích của HTTP; nó được dẫn chứng từ lại liệu `rfc 2777`.

Quy trình bắt đầu khi một proxy chèn một `Meter` header vào request message và gửi nó lên proxy tiếp theo. (Xem mục 3.2.25 để biết chi tiết hơn về header này). Step 2 và 3 của hình 2.28 cho thấy quy trình này. Bằng việc chèn header vào đây, proxy chỉ ra mong muốn của nó để response và giới hạn số lần nó trả về kết quả response từ cache.

![Ảnh 2.28](http://i.imgur.com/xgs8roC.png)
**Hình 2.28: Các proxy mà hỗ trợ việc đo lường thêm vào Meter header trong các request mà đi ngang qua chúng. Server yêu cầu việc đo lường đó trên object đặc biệt bằng việc thêm Meter header vào trong response.**

Server gốc response sự yêu cầu này bằng việc thêm vào `Meter` header vào trong response. Header này báo cho proxy biết để xử lý object với khía cạnh để response và giới hạn sử dụng.

Sau đó, khi một client khác request cùng một object, các proxy mà lưu bản sao đó sẽ cần thông qua bản sao đó với server gốc. Như hình 2.29 cho thấy, chúng cập nhật `Meter` header trong các request của chúng. Thông tin đo lường này là một bản báo cáo của số lần mục lưu trữ được cung cấp tới client.

![Ảnh 2.29](http://i.imgur.com/wauwARn.png)

**Hình 2.29: Các proxy đang đo lường một object báo cáo kết quả khi chúng gửi một yêu cầu mới tới server gốc liên quan đến object. Trong ví dụ, proxy B tạo ra một HEAD reuquest để đảm bảo rằng bản sao lữu trữ vẫn còn phù hợp. Nó chứa một Meter header trong request.**
<a name="2.5"></a>
## 2.5 Cockies và Việc duy trì trạng thái
Giao thức HTTP thường hoạt đông như thể là mỗi request của client độc lập với nhau. Server phản hồi tới các request một cách chặt chẽ theo đúng yêu cầu, mà không cần tham chiếu tới các request khác từ phía client. Phương thức hoạt động này được biết đến như là `stateless` bởi vì server không phải giữ các rãnh ghi trạng thái của client.

Bởi việc duy trì trạng thái yêu cầu tài nguyên server, phương thức stateless thì đáng để sử dụng. Tuy nhiên trong một vài ứng dụng, server cần giữ lại thông tin trạng thái về mỗi client. Ví dụ các user đăng nhâp thành công vào web, nên không cần phải đăng nhập lại nữa cho mỗi lần truy cập trạng khác nhau trên 1 site. Một server có thể tránh các sự bất tiện bằng cách ghi lại các trạng thái của client. Đầu tiền client request một page, server yêu cầu user phải đăng nhập. Tuy nhiên, khi người dùng tiếp tục duyệt site và bổ sung thêm  HTTP request, server nhớ lần đăng nhập thành công trước và không yêu cầu đăng nhập tiếp nữa.

### 2.5.1 Cockies

Việc duy trì trạng thái đòi hỏi một khả năng quan trọng: Server phải có khả năng kết hợp một HTTP request với những request khác. Ví dụ, server phải có thể thông báo rằng user mà đang request một trang mới thức tế học đã đăng nhập rồi, không phải một user khác nên không cần phải xác thực. Cơ chế này được HTTP định nghĩa trong việc duy thì trạng thái là `cockie`. Một server tạo ra cockie khi nó muốn ghi lại các trạng thái của client và nó trả về những cockie đó tới client bên trong các response. Khi client nhận được cockie, nó có thể chứa đựng cockie trong request tiếp theo từ cùng một server, như hình 2.30 minh họa. Client có thể tiếp tục chứa đựng cockie trong yêu cầu của nó cho tới khi cockie hết hạn hoặc  server không cho client sử dụng tiếp cockie nữa.

![Ảnh 2.30](http://i.imgur.com/asqET7r.png)

Không phải người sử dụng Web nào cũng thích việc HTTP hỗ trợ cockie.
Nhiều user truy cập state maintenance như là một sự xâm lược quyền riêng tư của họ. State maintenance cho phép Web site ghi lại các hành vi trinh duyệt của người dùng. Tuy nhiên, để sử dụng một cách thích hợp, state maintenance sẽ không nâng cao sự riêng tư liên quan đến hầu hết người dùng. Ví dụ, user ấn vào nút checkout của một trang bán hàng online, tất nhiên là Web site sẽ ghi lại việc thanh toán đó. Vấn đề nảy sinh khi Website sử dụng cockie để ghi lại các hành vi của user mà không loại trừ một ai. Ví dụ, một nhà quảng cáo trực tuyến có thể theo dõi hành vi của ta trên từng trang Web mà thiết lập quảng cáo. Nếu không có cockie, việc ghi lại này thì không hiệu nghiệm.

### 2.5.3 Các Thuộc Tính Cockie 

Cockie chứa đựng một chuỗi các thuộc tính được liệt kê trong bảng 2.1 . Server chọn các giá trị cho các thuộc tính được yêu cầu.

>**Bảng 2.1 Các thuộc tính Cockie**

|Thuộc tính|Status|Chú ý|
|----------|------|-----|
|**NAME**|Bắt buộc| Một cái tên tùy ý cho cockie, được gán bởi server|
|**Comment**|Tùy chọn|Một bình luận mà server thêm vào cockie; Client có thể kiểm tra commment của cockie mà họ nhận được, trong các trường hợp comment có thể được sử dụng để  giải thích việc server sử dụng cockie như thế nào, có thể làm yên lòng user khi có vấn đền riêng tư.|
|**CommentURL**|Tùy chọn|Một URL mà server cung cấp với một cockie; URL có thể giải thích thêm về việc server sử dụng cockie.|
|**Discard**|Tùy chọn|Chỉ dẫn cho client để loại bỏ cockie, user chỉ được sử dụng một lần. Thực ra là nó báo cho Web brwoser biết là không được lưu cockie trong ổ đĩa của user.|
|**Domain**|Tùy chọn|Domain (form DNS) cho mỗi cockie phù hợp; một server không thể chỉ định một domain khác với tên miền mà nó sở hữu.|
|**Max-Age**|Tùy chọn|Thời gian tồn tại của cockie, tính bằng giây|
|**Path**|Tùy chọn|URL trên server áp dụng cho mỗi cockie.|
|**Port**|Tùy chọn|Một danh sách các TCP port áp dụng cho mỗi cockie|
|**Secure**|Tùy chọn|Chỉ dẫn cho client chỉ trả về cockie cho request tiếp theo nếu các request đó đảm bảo an toàn; nó có thể được dùng cho các cockie mà không nên tiếp xúc với kẻ gian. Chú ý, HTTP không chỉ rõ nghĩa của từ "secure" trong bối cảnh này|
|**Version**|Bắt buộc|Phiên bản của HTTP state maintenance mà phù hợp với các cockie; phiên bản hiện tại là ver1.1|

### 2.5.3 Accepting Cockie

Khi một client nhận được một cockie, nó lưu các thuộc tính cấu tạo nên cockie. Mặt khác, nếu server bỏ qua vài thuộc tính tùy chọn, client sẽ cung cấp các giá trị mặc định. Bảng 2.2 liệt kê các giá trị mặc định mà client thêm vào cho các thuộc tính bị thiếu

>**Bảng 2.2 Các giá trị mặc định cho các thuộc tính của cockie**

|Thuộc tính|Gía trị mặc định nếu không có|
|----------|-----------------------------|
|**Discard**|Đưa giá trị thuộc tính `Max-Age` về mặc định|
|**Domain**|Tên miền của server mà cung cấp cockie gốc|
|**Max-Age**|Giữ cockie chỉ đến khi nào user session hiện tại được kích hoạt (không được lưu cockie vào ổ đĩa của user)|
|**Path**|URL cho mỗi cockie được trả về giá trị gốc, file được chỉ định bở URL đó|
|**Port**|Cockie chấp nhận các port (Chú ý nếu thuộc tính `Port` được đề cập trong cockie nhưng không có giá trị, sau đó client sẽ đặt giá trị của thuộc tính là port của yêu cầu ban đầu)|
|**Secure**|Cockie có thể được trả về với một request không an toàn|

Chú ý rằng một client không bao giờ được request để chấp nhận cockie. Ví dụ, các user có thể cấu hình Web browser để chấp nhận cockie hoặc không - như hình 2.33.

![Ảnh 2.33](http://i.imgur.com/7da13OE.png)

**Hình 2.33: Hầu hết các Web browser cho người dùng quản lý cockie và việc duy trì trạng thái. Bảng đó cho thấy một vài tùy chọn quyết định trình duyệt có được chấp nhận môt cockie hay không. Các trình duyệt khác phân biệt giữa cockie cố định(cái mà được lưu trong ổ đĩa PC) và cockie tạm thời mà browser xóa đi khi tắt ứng dụng.**

Dù là nột user mong muốn chấp nhận cockie, HTTP bắt buộc client từ chối cockie với mọi trường hợp. Cockie bị từ chối bởi client và bởi vậy sẽ không được bao gồm trong request tiếp theo. Bảng 2.3 liệt kê các điều kiện mà client phải từ chối cockie server. Chú ý là client xem xét các điều kiện đó sau khi nó chấp nhận các thuộc tính mặc định được nêu ra ở bảng 2.2 .

>**Bảng 2.3: Các qui tắc từ chối cockie**

|Các điều kiện để Client từ chối một cockie|
|------------------------------------------|
|Gía trị của thuộc tính `Path` không phải là một tiền tố của URL trong request của client.|
|Gía trị của thuộc tính `Domain` không có dấu chấm trong đó, nếu không giá trị sẽ là ".local".|
|Server mà trả về cockie không thuộc tên miền được xác định bởi thuộc tính `Domain`.|
|Máy chủ lưu trữ một thuộc tính `Domain`, nó có một dấu chấm trong đó.|
|Port trong request của client không được khai báo trong thuộc tính `Port` (nếu không thuộc tính `Port` sẽ bị thiếu).|

Cuối cùng, khi một client chấp nhận cockie, một cockie mới lấy những cockie được chấp nhận lúc trước có cùng các giá trị thuộc tính `NAME,Domain,Path`.


### 2.5.4 Việc trả về Cockie

Mỗi khi client chấp nhận một cockie và cung cấp các giá trị mặc định phù hợp, nó quyên định khi nào để trả về cockie tới một server trong request tiếp theo. Bảng 2.4 cho thấy các qui tắc mà client chứa đựng cockie trong request.

>**Bảng 2.4 Các qui tắc để trả về Cockie**

|Các điều kiện|
|-------------|
|Một domain cho request mới phải thuộc về domain được định rõ bởi thuộc tính Domain trong cockie|
|Port cho request mới phải nằm trong danh sách các port của thuộc tính Port trong cockie, nếu không thuộc tính Port sẽ bị thiếu ở Cockie|
|Path cho request mới phải trùng với thuộc tính Path trong cockie|
|Cockie không được hết hạn|

Khi client trả một cockie về server, nó chứa đựng các thuộc tính Domain, Path và Port nếu các thuộc tính đó được trình bày trong cockie gốc. Nó không chứa đựng các thuộc tính đó nếu chúng bị thiếu từ cockie gốc.
<a name="3"></a>
# Chapter 03
# HTTP Messages - Cú pháp của giao tiếp HTTP
<a name="3.1"></a>
## 3.1 Cấu trúc của thông báo HTTP

Như chúng ta đã thấy trong chương trước, HTTP là một giao thức giữa client/server; client tạo ra request và server phản hồi các request đó. Cấu trúc HTTP message phản ánh sự phân chia đó. Hai mục nhỏ sau xem xét lần lượt từng cái.

### 3.1.1 HTTP Request

Hình 3.1 cho thấy cấu trúc cơ bản của HTTP request. Mỗi request bắt đầu với một Request-line. Dòng này chỉ ra giao thức mà client đang request, tài nguyên mà giao thức đó chấp nhận, và phiên bản của HTTP mà client hỗ trợ. Request-line có thể được theo sau bởi một hoặc nhiều message header và mesage body. Một dòng trống ở giữa message header và message body.

![Hình 3.1](http://i.imgur.com/VCI183h.png)

**Hình 3.1: Một yêu cầu HTTP bắt đầu với một Request-line và có thể bao gồm header và body message. Header có thể mô thả giao tiếp chung, yêu cầu cụ thể, hoặc chứa đụng message body**

Dưới đây là một ví dụ:

![V1](http://i.imgur.com/D0u66AP.png)

Như hình 3.2 cho thấy, HTTP Request-line chứa ba mục riêng biệt. Đó là một method, một URI và một HTTP version, mỗi cái được cách nhau bởi một hoặc nhiều khoảng trống.

![Hình 3.2](http://i.imgur.com/h1koy0w.png)

**Hình 3.2: Một HTTP Request-line có một method, một URi, và một HTTP version**

Trong ví dụ trước method là một GET, nhưng như bảng 3.1 chi ra rằng, HTTP có tổng cộng 8 method khác nhau. Như bảng đó cũng chỉ ra là, HTTP server được yêu cầu chỉ hỗ trợ GET và HEAD method; tuy nhiên, nếu chúng hỗ trợ method HTTP khác, hỗ trợ đó phải bổ sung vào. Các method khác sẽ được bổ sung trong tương lai.

>**Bảng 3.1 HTTP methods**

|Method|Server Support|Use|
|------|--------------|---|
|CONNECT|Tùy chọn|Yêu cầu server(thường sử dụng proxy) để tạo ra một tunnel|
|DELETE|Tùy chọn|Yêu cầu server để xóa một tài nguyên rõ ràng|
|GET|Yêu cầu|Yêu cầu server trả về tài nguyên được yêu cầu|
|HEAD|Yêu cầu|Yêu cầu server trả lời response mà không trả về tài nguyên|
|OPTIONS|Tùy chọn|Yêu cầu server chỉ ra các tùy chọn mà nó hỗ trợ|
|POST|Tùy chọn|Yêu cầu server truyền message body tới tài nguyên được chỉ rõ|
|PUT|Tùy chọn|Yêu cầu server chấp nhận message body như là một tài nguyên có sẵn|
|TRACE|Tùy chọn|Yêu cầu server đơn giản chỉ phản hồi yêu cầu|

Phần tiếp theo trong Request-line là URI. Phần này cung cấp URI cho tài nguyên. Trong ví dụ, Request-Uri là /, chỉ ra một request cho tài nguyên gốc. Với các request mà **không yêu cầu các tài nguyên cụ thể**, client có thể sử dụng một dấu * cho URI.

Phần cuối cùng của Request-line là HTTP version. Trong ví dụ, HTTP version 1.1 chứa đựng dòng chữ `HTTP/1.1` cho mục này.

Sau Request-line, HTTP request có thế bao gồm một hoặc nhiều dòng của message header. Như hình 3.1, các message header có thể là general header; request header hoặc entity header. General header áp dụng cho giao tiếp HTTP chung; request header áp dụng cho các request rõ ràng, và một entity header áp dụng cho message body chứa trong request.

Một HTTP request luôn chứa đựng một dòng trống sau Reuqest-line và các header kèm theo. Nếu request chứa một message body, phần body theo sau một dòng trống. Dòng trống rất quan trọng vì nó cho phép server nhận dạng đoạn cuối của request.
    
### 3.1.2 HTTP Response

Như hình 3.3 chỉ rõ, HTTP response nhìn khá giống HTTP request. Nhưng chỉ có response mới có **Status-line** thay vì là **Request line**.

![Hình 3.3](http://i.imgur.com/N0kZG5T.png)

Ví dụ dưới đây cho thấy HTTP response thực sự, bắt đầu với một Status-line. Gần giống với Request-line, một Status-line chứa 3 phần tách rời bởi các khoảng trống mà hình 3.4 cho thấy. Dòng đó bắt đầu với phiên bản mới nhất của HTTP mà server hỗ trợ. Ví dụ, một HTTP 1.1 server nhận một request từ một client 1.0, có thể vẫn chỉ ra phiên bản 1.1 trong status-line. Mặt khác, nó có thể gửi client thông tin mà nó không hiểu.

![V2](http://i.imgur.com/IaE9b73.png)

![Hình 3.4](http://i.imgur.com/yq7W9BE.png)

Hai mục nhỏ phía sau Status-line là Status-code và Reason-Phrase. Status-code là một số có 3 chữ số chỉ ra kết quả của request. Status-code phổ biến nhất là 200 trong ví dụ trên. Gía trị đó chỉ ra rằng client request thành công. Chữ số đầu tiên của Status-code nhận biết dạng của kết quả và đưa ra một dấu hiệu của sự thành công; các kí tự sau được bổ sung để cung cấp chi tiết hơn. 

>**Bảng 3.2: HTTP Status code**

|Status code|Ý nghĩa|
|-----------|-------|
|100-199|Thông tin; server nhận request nhưng một kết quả cuối cùng thì chưa phù hợp|
|200-299|Thành công; server có áp dụng với các reuqest thành công|
|300-399|Chuyển hướng; Client nên chuyển hưởng request tới một server hoặc một resource khác|
|400-499|Lỗi client; request chứa 1 lỗi mà bị ngăn cản bởi server|
|500-599|Lỗi server; server thất bại trong việc thao tác với request mặc dù request đó phù hợp|

<a name="3.2"></a>
## 3.2 Các Trường Header

HTTP request và response có thể cùng chứa một hoặc nhiều message header. Message header bắt đầu với một trường tên và một dấu hai chấm (":"). Các thông tin bổ sung theo sau dấu hai chấm.

Một message header kết thúc khi dòng đó kết thúc. Nếu muồn bổ sung thêm thông tin thì chỉ cần xuống dòng và điền. Một ví dụ request từ mục trước có chứa một dòng tiếp tục cho `User-Agent` header.

![V3](http://i.imgur.com/2v5IFgP.png)

Nếu một message header có thể chứa đựng một chuỗi các trường giá trị, mỗi cái ngăn cách nhau bởi dấu phẩy.

Trước khi đào sâu vào từng trường header, bảng 3.3 tổng hợp các HTTP header. Được sắp xếp theo thứ tụ: General, Reuqest, Response, Entity.

>Bảng 3.3 Các trường HTTP Header

![Bảng 3.3](http://i.imgur.com/xTIIjGW.png)

### 3.2.1 Accept

`Accept` header là một header request, cho phép một client chỉ ra **kiểu nội dung** mà nó có thể chấp nhận trong message body của response server, cũng như sự ưu tiên của nó cho mỗi nội dung. Đây là một ví dụng cho `Accept` header mà client có thể chứa đựng trong request của nó.

```sh
Accept: text/plain; q=0.5, text/html,
text/x-dvi; q=0.8, text/x-c
```

Như bạn có thể thấy từ ví dụ đó, `Accept` header có thể chứa một danh sách nhiều dạng nội dung. Các dấu phẩy tách rời từng nội dung, và mỗi loại có thể chứa một "equality factor" tùy ý. Equality factor là một tham số của một dạng, và một dấu chấm phẩy ngăn cách nó ra. Ví dụ trước chỉ ra rằng client có thể chấp nhận bất cứ dạng nội dung dưới dấy.

* `text/plain; q=0.5`
* `text/html`
* `text/x-dvi; q=0.8`
* `text/x-c`

Mỗi dạng chứa một kiểu phụ và một kiểu chính, với một dấu gạch chéo ("/") chia đôi hai kiểu đó ra. Tất cả nội dung phải có một kiểu chính là `text`, nhưng khác nhau ở kiểu phụ. Client có thể sử dụng dấu * như là một đại diện cho một kiểu phụ hoặc cả hai kiểu. Ví dụ, dạng nổi dung `text/*` sẽ chỉ ra rằng client có thể chấp nhận bất cứ text content nào, và dạng nội dung `*/*` chỉ ra rằng client có thể chấp nhận bất cứ kiểu nội dung nào.

Equality factor là một số giữa 0 và 1. Nếu một dạng nội dung không có một Equality factor rõ ràng, nó ngầm hiểu là 1. `text/html` và `text/x-c` là một ví dụ, nó có Equality factor là 1. Nếu một server có thể trả về nhiều dạng nội dung cho một request, nó nên đặt số một cho equality factor cao nhất. Mức độ ưu tiên giảm dần từ 1 đến 0.

### 3.2.2 Accept-Charset

Client có thể chứa một `Accept-Charset` header trong các request để báo cho server biết các kiểu kí tự mã hóa mà nó phù hợp cho message body được trả về trong response. `Accept-Charset` header hoạt động gần giống `Accept` header (cùng chung `Accept` family). Client có thể chứa đựng một danh sách các bộ kí tự khác nhau, và chúng có thể chỉ ra một sự ưu tiên cho mỗi bộ ký tự bằng việc khai báo một equality factor. Nếu equality factor đó để trống thì server sẽ tự động ngầm hiểu giá trị là 1.

Giao thức HTTP xử lý `iso 8859-1` khác với các bộ ký tự khác. Nếu client không dứt khoát liệt kê các bộ ký tự đó và không dứt khoát gán nó cho một equality factor khác 1, server sẽ thừa nhận đó là client chấp nhận `iso 8859-1`.Chế độ này đảm bảo rằng `iso 8850-1` là bộ ký tự mặc định cho response.

Các phần của message sau đây cho thấy một client có thể chọn một chấp nhận một bộ ký tự đặc biệt như thế nào. Với một header, client chỉ ra rằng nó thích hợp với bộ ký tự Unicode nhưng nó sẽ nhấp nhận những cái khác (bao bồm cả iso 8859-1) với một với sự ưu tiên là 0.8

`Accept-Charser:unicode. *; q=0.8`

Internet Assigned Numbers Authority vẫn duy trì danh sách các bộ ký tự được định dạng. Tại thời điểm viết cuốn sách này, nó bao gồm 235 bộ ký tự khác nhau.

### 3.2.3 Accept-Encoding

`Accept-Encoding` header đưa ra cho client nhiều cách khác nhau để biểu thị những ưu tiên cho message body của response server. Ngoài content type và bộ ký tự, header này cho phép client request nội dung mã hóa cho response. Dạng header này giống các `Accept` header khác, một danh sách các kiễu mã hóa phù hợp, mỗi cái ứng với một equality factor.

```sh
Accept-Encoding: compress, gzip; q=0.9,
identity; q=0.8
```

### 3.2.4 Accept-Language

`Accept-Language` header là `Accept` cuối cùng trong chuối các `Accept` mà đưa ra cho client các cách để biểu thị sự ưu tiên cho response. (`Accept-Range` thì khác hoàn toàn.)

Header này cho phép client chỉ ra sự ưu tiên cho ngôn ngữ của message được trả về.

Để xác định các ngôn ngữ đặc biệt, client sử dụng một đa cấp bậc, với mỗi level được phân ly bở dấu gách nganh ("-"). Trong cái form phổ biến nhất của nó, level đầu tiên là 2 chữ viết tắt của chuẩn ngôn ngữ `iso 639`, và level thứ hai nếu được hiển thị thì nó là hai kỹ tự viết tắt của mã vùng `iso 3166`. Ví dụ, cái code `en`  biểu thị cho English và cái code `en-us` biểu thị ho American English. `Accept-Language` header hỗ trợ equality factor giống các `Accept` header khác, nên một client có thể chỉ ra sự ưu tiên giữa nhiều ngôn ngữ. Dưới đây là 1 ví dụ:

`Accept-Language: en-gb, en; q=0.8`

Chú ý rằng HTTP server không tự động tự đồng lùi về ngôn ngữ có bậc cao hơn. Ví dụ bên dưới, chỉ chấp nhận mỗi `en` English trong response và server sẽ không trả về một phiên bản trong `uk` English cho dù nó có sẵn.

`Accept-Language: en-us, *; q=0.0`

### 3.2.5 Accept-Ranges

Không giống như các `Accept` header khác, `Accept-Range` header là một header response; nó xuất hiện trong respone của server thay vì request của client. HTTP hiện tại giới hạn header này với 2 form. Form đầu tiên nằm ở ví dụ bên dưới cho phép một server chỉ ra rằng nó có thể chấp nhận phạm vị các request cho tài nguyên.

`Accept-Ranges: bytes`

Như chúng ta sẽ được thấy trong mục 3.2.29, client có thể tạo ra các request cho một giới hạn byte nhất định thay vì toàn bộ tài nguyên. Đặc điểm này rất có ích cho việc tải file. Nếu tải thất bại trước khi hoàn thành, client có thể sử dụng một phạm vi request để lấy các file chưa tải xong; nó không phải nhận lại toàn bộ file.

Nếu server không thể chấp nhận phạm vi request cho một tài nguyên, nó có thể chỉ ra với header dưới đây.

`Accept-Ranges: none`

Chú ý rằng server không bị yêu cầu để chứa một `Accept-Ranges` header, bất kể dù họ có chấp nhận phạm vi yêu cầu. Client cũng tự do tạo ra ranges request dù nó không nhận một `Accept-Ranges` header. Nếu client gặp vấn đề là gửi tới server không hỗ trợ, server đơn giản là sẽ gửi lại toàn bộ tài nguyên.

### 3.2.6 Age

`Age` header là một response header mà ước tính thời gian tồn tại của các tài nguyên liên quan. Cache server sử dụng giá trị này để đoán tài nguyên có còn hạn hay không và phải được làm mới từ server. Gía trị của `Age` header là số giây mà người gửi ước tính thời gian đã qua kể từ khi server gốc tạo ra hoặc tái tạo response đó.

Cách tốt nhất để hiểu `Age` header hoạt động như thế nào ta có ví dụ sau đây. Hình 3.5. Hình này cho thấy request ban đầu với một tài nguyên, và đi qua hai cache server trung gian trước khi đến server gốc.

Như hình đó cho thấy, server gốc chứa hai header quan trọng trong phản hồi của nó. Các header đó là `Date` - thời gian nó tạo ra phản hồi, và một `Cache-Control` header - chỉ ra maximum age. Trong ví dụ, server chỉ ra rằng response có thể được xem xét làm mới lên tới 600s.

![Hình 3.5](http://i.imgur.com/XW7y2RZ.png)

**Hình 3.5: Một server gốc có thể nhận ra maximum age cho bản sao cache mà nó trả về. Trong ví dụ này, server giới hạn việc caching 10 phút (600s).**

Tình huống xảy ra trong hình 3.6, nó xảy tra trong 10 phút, một client tạo một request cho cùng một tài nguyên. Cache server đầu tiên không có một bản sao của cache, nên nó truyền request tới cache thứ hai. Server đó trả về object với message header ở step 9 trong hình.

![Hình 3.6](http://i.imgur.com/3BMaJI3.png)

**Cache server có thể chỉ ra nó tin tưởng object có Age header trong bao lâu. Cache server ước tính object đó khoảng 599s.**

Vào lúc này cache server đầu tiên đưa ra một quyết định quan trọng: Cái object mà server thứ hai trả về có phù hợp hay không? Để trả lời cho cho câu hỏi đó, cache server đầu tiền tính toán một vài giá trị dựa trên các tham số trong bảng 3.4.

>**Bảng 3.4: Các tham số cho Cache Freshness Calculations**

|Tham số| Giải thích|
|-------|-----------|
|`age_value`|Gía trị trong Age header của response(step 9); ví dụ như :599.|
|`data_value`|Dữ liệu được gán cho tài nguyên bởi server gốc(step 4): ví dụ như 11 October 2000.|
|`now`|Thời gian hiện tại của cache sercer đầu tiên.|
|`request_time`|Thời gian mà cache tạo ra request(step8).|
|`response_time`|Thời gian mà response đến nơi.|

Bảng 3.5 cho thấy các bước trong việc tính toán. Chú ý rằng server thật sự dựa vào age của tài nguyên trên hai nguồn độc lập. Các bước trong bảng 3.5  đảm bảo rằng cache server chọn hai giá trị được bảo toàn nhất trong ước tính của nó, như vậy sẽ giảm khả năng trả về các tài nguyên cũ.

>**Bảng 3.5: Việc tính toán Freshness của một Cached Object**

|Step|Quy trình|
|----|---------|
|1|Tính toán age rõ ràng với sự khác nhau giữa response_time và date_value.|
|2|Ưóc tính age của tài nguyên với age cực đại từ bước 1 và Age header trong response.|
|3|Bổ sung sự khác nhau giữa response_time và request_time vào age được ước tính trong step 2.
|4|Bổ sung sự khác nhau giữa now và response time.|

Cache server sử dụng kết quả này như là age của tài nguyên. Nếu age thực tế vượt quá giá trị max-age của server gốc, server sẽ không sử dụng caches object cho response đó. Thay vào đó, nó tái tạo request tới server gốc.

Để tiếm tục ví dụ, giả sử rằng một giây trôi qua giữa thời gian mà cache tạo ra request ở step 8 và nhận response ở step 9. Tiếp tục giả sử rằng một giây bổ sung cho thời gian delay sau khi response đi và trước khi response xử lý nó. Trong trường hợp này, server tính toán age của object là 601 giây, nên server từ chối response. Như kết quả cho thấy, nó có thể bắt đầu tiền trình của hình 3.7, nơi nó tái tạo request.( Trong hình dưới, cache server đầu tiên bổ sung Cache-Control header của nó vào request ở step 10; bằng việc đặt max-age là 0 trong một phản hồi, cache server đầu tiên buộc cache server thứ hai tái tạo giá trị cache riêng của nó với server gốc.)

![Hình 3.7](http://i.imgur.com/ehW5Tv3.png)

**Hình 3.7: Khi age của cached object vượt quá giới hạn, cache server phải hỏi ý kiến server gốc cho một bản sao mới của hoặc tái thẩm định bản sao đang tồn tại. Ví dụ này, là một sự nối tiếp của hình 3.6, cache serer request một bản sao mới.**

Các đặc điểm kỹ thuật HTTP giới hạn giá trị Age header là 2 147 483 648 giây. Mỗi khi một giá trị age vượt quá giới hạn đó trong một sự tính toán của server, server sử dụng giá trị cực đại để thay thế.

### 3.2.7 Allow

`Allow` header nhận dạng các phương thức HTTP mà nó hỗ trợ. Header này liệt kê các phương thức đó. Ví dụ, đoạn text dưới đây chỉ ra rằng một tài nguyên hỗ trợ phương thức `GET,HEAD và PUT`.

Header này rất hữu ích khi server phải trả về một ` 405 Method Not Allowed` status. Client cũng có thể sử dụng header này khi nó gửi tài nguyên tới server với phương thúc `PUT`.

### 3.2.8 Authentication-Info

`Authentication-Info` header là một response header mà các server có thể chứa trong response thành công, và nó đưa ra cho client thông tin kèm theo về việc xác thực trao đổi. Để chi tiết hơn, xem mục 4.1 .

### 3.2.9 Authorization

Client sử dụng `Authorization` header để nhận dạng và xác thực client - hoặc các user - tới một server. Mục 4.1 sẽ cho chi tiết cho chúng ta hiểu hơn về nó.

### 3.2.10 Cache-Control

`Cache-Control` header là một header chính cho một vài chỉ thị khác nhau mà chỉ ra caching behaviour. Các chỉ thị này, trong đó có các tham số kết hợp với nó hoặc không, được phân chia bởi các dấu phẩy. Sau đây là ví dụ:

```
Cache-Control: max-age=3600, no-transform,
no-cache="Accept-Ranges"
```

Như các header khác, mỗi chỉ thị riêng lẻ có thể được sử dụng trong các request hoặc response. Bảng 3.6 liệt kê các chỉ thị HTTP cache-control.

>**Bảng 3.6: Chỉ thị Cache-Control**

![Bảng 3.6](http://i.imgur.com/HjP4wE0.png)

Chúng ta sẽ xem chi tiết từng chỉ thị.

`Cache-Control: max-age=3600`

Chỉ thị `Max-Age` xử lý hai mục đích chính. Đầu tiên, khi được sử dụng bởi một server, nó chỉ ra thời gian lớn nhất mà cache nên giữ lại tài nguyên trong cache của nó mà không cần gia hạn. Trong quy tắc này `max-age` giống `Expires` header. Nếu cả hai được đưa ra trong cùng một response, cache server nên bỏ qua `Expires` header. Quy tắc này cho phép server gốc nhận ra các hành vi khác nhau cho cache HTTPv1.0 so với cache HTTPv1.1, bởi vì cache server 1.0 sẽ không hiểu các chỉ thị `max-age`.

Chỉ thị `max-age` xử lý mục đích chính thứ hai khi client sử dụng nó. Khi client chứa chỉ thị này trong request của nó, client chỉ ra rằng nó muốn chấp nhận cached object không lớn hơn giá trị đề ra. Nếu một cache server có một entry mà "già" hơn age request của client, nó sẽ không trả về cached entry, dù là response gốc của server gốc chỉ ra entry vẫn phù hợp. Trong trường hợp đặc biệt, client có thể chỉ ra `max-age`= 0, server luôn luôn truyền request tới server gốc cho cho việc tái thẩm định của locally cached entry.

`Cache-Control: max-stale`

Với chỉ thị `max-stale`, một client có thể chỉ ra rằng nó muốn chấp nhận response mà chứa một cached object, dù là object đó hết hạn. Client có thể tùy chọn giới hạn thời gian hết hạn nó chuẩn bị để chấp nhận response trong bao lâu. Ví dụ một chỉ thị `max-stale=600,`, chỉ ra rằng client muốn chấp nhận responce lên tới 10 phút.

`Cache-Control: min-fresh=60`

Khi một client chứa chỉ thị `min-fresh` trong request của nó. Object nằm trong cache server phải đủ thời gian tồn tại đó thì mới chấp nhận. Ví dụ ở trên yêu cầu bất cứ bản sao nào cũng phải duy trì ít nhất trong vòng 60s và vậy nên 45s thì sẽ không phù hợp.

`Cache-Control: must-revalidate`

Chỉ thị `must-revalidate` cho phép server triệt tiêu đi việc sử dụng `max-stale` của các client. Khi một server chứa `max-revalidate` trong response, cache server nên bỏ qua chỉ thị `max-stale` trong các request của client sau này.

`Cache-Control: no-cache`

Chỉ thị `no-cache` có thể xuất hiện trong response hoặc request. Trong một request, chỉ thị này chỉ ra rằng client không chấp nhận cached response, các cache server trung gian phải truyền request tới server gốc. Chú ý rằng request này thì khác so với request chứa chỉ thị `max-age=0`. Trong trường hợp của mà request chứa `no-cache`, cacher server luôn luôn tìm và lấy ra response từ server gốc. Còn với `max-age=0`, cache server chỉ cần tái thẩm định các local cache với server gốc. Nếu server gốc chỉ ra rằng cached entry vẫn còn phù hợp, cache server có thể sử dụng nó như một response.

Khi server gốc chứa một chỉ thị `no-cache` trong response, nó báo cho cache server biết rằng không được sử dụng response cho response sau **nếu không tái thẩm định nó**. Qui định này không hoàn toàn cấm cache server từ việc caching response; nó chỉ đơn thuần là buộc chúng phải tái thẩm định một local cached copy với mỗi request.

Nếu một server gốc muốn hạn chế việc caching đối với các trường header hiện tại thay vì toàn bộ response, nó có thể làm việc đó bằng cách gọi tên các header đó trong chỉ thị này. Ví dụ, bằng việc chứa `no-cache="Accept-Ranges"` trong response của nó, server gốc báo cho cache server rằng chúng có thể cache response, nhưng chúng không chứa header `Accept-Ranges` trong response khi chúng trả lời các request sau với cached copy.

`Cache-Control: no-store`

Chỉ thị `no-store` có trong một request hoặc một repsonse. Chỉ thị này báo cho cache server biết là **không được lưu message** trong local storage, đặc biệt nếu nội dung có thể được lưu lại sau khi truyền dữ liệu.

`Cache-Control: no-transform`

Chỉ thị `no-transform` xuất hiện trong response hoặc request, báo cho cache server biết là không được thay đổi, chỉnh sửa định dạng của message body của response. Ví dụ các cache server không được chuyển một hình ảnh có độ phân giải cap thành phân giải thấp.

`Cache-Control: only-if-cached`

Với chỉ thị `only-if-cached`, một client yêu cầu cache server phàn hồi thành công chỉ khi chúng có object trong local cache của chúng. Đặc biệt, client yêu cầu cache không tải lại response hoặc tái thẩm định nó với server gốc. Hành động này có thể hữu ích trong môi trường mạng yếu nơi mà client cảm thấy sự trì hoãn trong việc kết nối tới server gốc thì không chấp nhận được. Nếu một cache server không thể trả lời request từ local cache của nó, nó sẽ trả về một `504 Gateway Timeout`.

`Cache-Control: private`

Chỉ thị `private` trong response chỉ ra rằng response được dành cho một user rõ ràng. Cache server lưu lại một bản sao cho response hoặc request sau này từ cùng một user, nhưng chúng không được trả về bản sao cached đó tới các user khác, dù là các user đó tạo ta các request giống nhau.

`Cache-Control: proxy-revalidate`

Chỉ thị `proxy-revalidate` báo là các cache server trung gian là chúng không trả về response cho các request sau này mà không cần tái thẩm định nó. Không giống như `must-revalidate`, tuy nhiên chỉ thị này cho phép client cache response và tái sử dụng cahed entry mà không cần thẩm định.

`Cache-Control: public`

Chỉ thị `public` là một sự đối lập của `private`. Một server chỉ ra rằng response của nó có thể được lưu tạm và trả về tới các user khác, dù là response sẽ bị hạn chế tới các server gốc hoặc thậm chí là non-cachable at all. Nếu một client cung cấp thông tin xác thực user, cache server xem xét response đó như là sự riêng tư đối vớ user đó. Nhưng nếu server phản hồi với một status là `301 Moved Permanently`, nó có thể sử dụng `public` cache control directive đề báo cho cache server biết để ghi đè các hành vi đó hoặc cache response.

`Cache-Control: s-maxage=1800`

Chỉ thị `s-maxage` hoạt động giống `max-age` trong response, ngoài trừ là nó chỉ áp dụng cho cache surving nhiều user. Với các cache server, `s-maxage` ghi đè lên cả `max-age` và `Expires` header. Cache server phản hồi tới cùng user nhiều lần, tuy nhiên có thể từ bỏ chỉ thị này.

### 3.2.11 Connection

Theo HTTP, header `Connection` cho phép người gửi message ( đối với request là client và response là server ) chỉ ra việc ủy quyền các header khác trong message không được gửi thêm. Xem xét ví dụ hình 3.8. Trong hình đó, client tạo ra một request hứa hai message header: `Upgrade` và `Connection`. Proxy server khi thấy header `Connection`, nó bỏ đi `Upgrade` header từ request trước khi gửi nó. Bởi vậy, `Connection` header chỉ ra các HTTP header được chuyển trong lần chuyển tiếp theo.

![Hình 3.8](http://i.imgur.com/yWPGMJB.png)

**Hình 3.8: Connection header chỉ ra các header HTTP khác nhau mà proxy server bỏ đi từ các message. Trong ví dụ này ,proxy không chứa Upgrade header khi nó gửi các GET request.**

Như mục 2.1.3 chú ý, với HTTP V1.1, kết nối liên tục là một chức năng mặc định. Khi một client mở một kết nối cho request, thì kết nối vẫn được duy trì tới server. Nhưng điều gì xảy ra nếu server không muốn duy trì kết nối?  Tất nhiên là nó có thể ngắt kết nối sau khi gửi lại response. Để báo cho client biết thì server kèm theo các header dưới đây vào trong response.

`Connection: close`

Header này báo cho client là server muốn đóng kết nối sau khi hoàn thành response của nó. Client nên chuẩn bị trước. Client cũng có thể chứa `Connection: close` trong request của nó. Trong trường hợp này, client đang cho phép server biết rằng nó muốn sử dụng một kết nối liên tục, đóng kết nối càng sớm càng tốt khi mà nó nhận được response. Chú ý rằng `Connection: close` không bị hạn chế cho request hoặc response đầu tiên trong một kết nối.  

Mục đích sử dụng chính thứ hai của `Connection` header là hỗ trợ các hệ thống cũ. Bởi vì sự duy trì không phải là hành động mặc định trước phiên bản 1.1. Các header đó chứa một `Connection: keep-alive`.

```sh
GET / HTTP/1.1
Keep-Alive: timeout=5
Connection: Keep-Alive

```

Server chấp nhận sử dụng kết nối duy trì bằng việc phản hồi với một `Connection: keep-alive` header.

```sh
HTTP/1.1 200 OK
Keep-Alive: timeout=5, max=120
Connection: Keep-Alive
Content-Type: text/html

<html>...
```

### 3.2.12 Content-Encoding

`Content-Encoding` header nhận dạng các ký tự đặc biệt là một phần có sẵn trong tài nguyên được chứa trong message body. Đi cùng với nó là `Content-Type` header, header này biết được định dạng của tài nguyên. Ví dụ, nếu một client request file manual.ps.gz, nó có thể nhận được một file trong response với message header sau. `Content-type` header nhận dạng object cuối là file PostScript, nhưng `Content-Encoding` header nhấn mạnh là file này được nén với phần mềm gzip.

```sh
HTTP/1.1 200 OK
Content-Type: application/postscript
Content-Encoding: gzip

```

HTTP nhận dạng 4 kiểu nội dung mã hóa khác nhau, tất cả được liệt kê trong bảng 3.7

>**Bảng 3.7: HTTP Content-Encoding**

|Identifier|Ý nghĩa|
|----------|-------|
|compress|Định dạng mã hóa được được tạo ra bởi chương trình UNIX|
|deflate|Định dạng mã hóa zlib xác định bởi RF 1950|
|gzip|Định dạng mã hóa tạo ra bởi chương trình gzip, giống như mô tả trong RFC 1952.|

Chú ý rằng `Conntent-Encoding` giống `Transfer-Encoding` nhưng cũng có vài cái khác. `Content-Encoding` là mã hóa dữ liệu còn `Transfer-Encoding` là mã hõa dữ liệu cho việc gửi nhận. Trong ví dụ dưới, dữ liệu được mã hóa kiểu `gzip, compress`, còn lúc gửi đi thì file mã hóa đó lại được mã hóa kiểu `chunked` để thuận tiện cho việc di chuyển.

```sh
Content-Encoding: gzip, compress
Transfer-Encoding: chunked
```

### 3.2.13 Content-Language

`Content-Language` header nhận dạng ngôn ngữ của tài nguyên kèm theo. Định dạng này giống `Accept-Language` header mô tả trong mục 3.2.4.

### 3.2.14 Content-Length

`Content-Length` header chỉ ra kích thước của mesage body tính bằng byte. `Content-Length` header thực sự là một trong vài cách khác nhau mà người nhận có thể xác định kích thước message từ định dạng Transfer-Encoding hoặc Content-Type, và nó có thể suy ra phần cuối của một message khi ngắt kết nối `TCP`

Bảng 3.8 liệt kê các quy tắc mà một người nhận sử dụng để xác định đoạn cuối của HTTP message theo thứ tự. Như các quy tắc chỉ ra rằng người gửi không chứa một `Content-Length` header nếu message là một response mà không chứa message body, hoặc nếu message body được mã hóa bằng cách sử dụng chunked.

>**Bảng 3.8: Qui tắc xác định đoạn cuối của một HTTP message**

|Thứ tự|Quy tắc|
|------|-------|
|1|Nếu response có chứa một status code mà không chứa message body sau đó message kết thúc tại dòng trống đầu tiên sau các trường header. Những nội dung message sau sẽ bị từ chối|
|2|Nếu `Transfer-Encoding` của message là chunked, sau đó message length được xác định bởi chunked format|
|3|Nếu `Content-Length` header được hiện ra, nó cung cấp kích thước của message|
|4|Nếu message có chứa một `Content-Type: multipart/byteranges`, định dạng kiểu truyền thông xác định đoạn cuối của message|
|5|Nếu server đóng kết nối, byte cuối cung được gửi là đoạn cuối của message|

### 3.2.15 Content-Location

`Content-Location` header cung cấp URI tương ứng với message body. Một server có thể tùy chọn để sử dụng header này nếu tài nguyên nó trả về dựa trên nhiều URI. Ví dụ, một server có nhiều ngôn ngữ dịch khác nhau, và nó có thể quyết định để trả về một phiên dịch đặc biệt dựa trên `Accept-Language` header trong request. Trong trường hợp này, `Content-Location` header có thể xác định object được dịch thay vì object gốc được request.

`Content-Location` hiếm khi được sử dụng. Nó bị từ chối bởi `Location` header - cái mà xuất hiện thường xuyên trong các trao đổi Web. Trong khi `Content-Location` header xác định URI của tài nguyên được trả về trong message body, `Location` header nhận dạng một URI cho tài nguyên được request; tài nguyên không phải là một phần của message body khi `Location` header xuất hiện.

### 3.2.16 Content-MD5
`Content-MD5` header cung cấp sự đảm bảo rằng một message body đến đích mà không bị chỉnh sửa. Gía trị của header này là kết quả của thuật toán md5. Thuật toán md5, chương bốn sẽ mô tả sâu hơn, giống một sự tổng kiểm tra, nhưng nó sử dụng cơ chế mã hóa để đưa ra kết quả tương đối bỏ qua các lỗi không thể xác định được.
Sau đây là việc một hệ thống tính toán kết quả cho header này bắt đầu với một trang `html` là một message body.

```sh
<HTML>
    <BODY>
        <P>Hello World!</P>
    </BODY>
</HTML>
```

Chạy thuật toán `md5` trên trang `html` dẫn đến một giá trị chuỗi nhị phân 128-bit. Ví dụ dưới đây cho thấy kết quả là 16 byte, mỗi cái là một ký hiệu hệ thập lục phân.

`B2 B3 59 59 1E 96 1C 6B 0F 46 8F E5 36 BC D9 20`

Bởi vì thuật toán md5 tạo ra một giá trị nhị phân, và các http header là text, và `Content-MD5` header sử dụng thuật toán base64 để chuyển mã nhị phân sang mã ASCII. Ví dụ kết quả của việc mã hóa base64.

`Content-MD5: srNZWR6WHGsPRo/lNrzZIA==`

Để thấy toàn bộ ngữ cảnh của `Content-MD5` header, sau đây một response đầy đủ từ server, chứa cả các HTTP header và message body.

```sh
HTTP/1.1 200 OK
Date: Sun, 08 Oct 2000 18:46:12 GMT
Server: Apache/1.3.6 (Unix)
Content-Type: text/html
Content-Length: 66
Content-MD5: srNZWR6WHGsPRo/lNrzZIA==

<HTML>
    <BODY>
        <P>Hello World!</P>
    </BODY>
</HTML>
```

`Content-MD5` header cung cấp một sự bảo vệ "nối đuôi nhau" của nội dung vì thế người nhận có thể loại bỏ các lỗi được đưa ra bởi network hoặc bằng việc can thiệp vào proxy server. Để đảm bảo hành động này, HTTP cấm tuyệt đối các server trung gian từ việc tạo hoặc chỉnh sửa `Content-MD5` header. Chỉ có server hoặc client có thể tạo header này.

### 3.2.17 Content-Range
Khi một server chỉ chứa một phần của tài nguyên trong message body của nó, `Content-Ranges` header xác định đó là phần nào. Đặc điểm này rất hữu ích cho việc tải file sau khi download bị hỏng. Để thấy tiến trình đó hoạt động như thế nào, xem xét hình 3.9. Trong hình đó, client request một object. Server bắt đầu trả về tài nguyên chứa 1234 byte thông tin. Tuy nhiên việc chuyển đó bị thất bị vì client chỉ nhận được 500 byte.

![Hình 3.9](http://i.imgur.com/U92iC1h.png)

**Hình 3.9: Khi vấn đề xảy ra, một client có thể không nhận được tất cả  object được request Trong ví dụ này, client request một object chứa 1234 byte nhưng việc chuyển bị hỏng vì chỉ có 500 byte được chuyển tới client.**

Tuy nhiên, trong response gốc, server chỉ ra rằng nó có thể chấp nhận các range request cho object. `Accept-Ranges` header chuyển thông tin đó. Do đó, khi client nhận ra rằng việc chuyển đó bị thất bại, nó không phải request tất cả các object lại nữa. Thay vào đó, như hình 3.10 cho thấy, nó chứa một `Ranges` header trong reuqest được tái tạo của nó.

![Hình 3.10](http://i.imgur.com/mnPRabT.png)

**Hình 3.10: Với Range header, một client có thể request chỉ một phần của object. Ví dụ này cho thấy client request phần còn lại của object.**

Với request ở bước 3, client có một `Range` header cho phép từ 500 byte trở lên. Nhưng khi server response thì nó xuất hện một `Content-Ranges` để giới hạn lại còn từ 500 đến 1233/1234 byte. Object trong hình có dung lượng 734 byte nên nó được chuyển tới client một cách thành công. Số 1234 là tổng kích thước của object. 734 là phần còn lại của object.

### 3.2.18 Content-Type

`Content-Type` header nhận dạng kiểu object mà message body chứa đựng. Các giá trị cho `Content-Type` header theo sau với cùng định type/subtype mà chúng ta thấy ở `Accept` header. Ngoài ra, ví dụ dưới đây cho thấy tài nguyên là một text file và nó sử dụng bộ kí tự `iso-8859-4`.

`Content-Type: text/plain; Charset=ISO-8859-4` 

### 3.2.19 Cockie

Nếu client muốn hỗ trợ http state management, nó cung cấp cockie mà nó nhận được từ server ở trong request sau này gửi tới server đó. Các cockie đó được vận chuyển trong một `Cockie` header. Ví dụ dưới đây cho thấy một cockie đơn, nhưng một client có thể chứa nhều cockie từ các server, trong những trường hợp nó có thể kết hợp tất cả trong một header hoặc sử dụng các header riêng lẻ.

```sh
Cookie: $Version="1"; NAME="VALUE";
$Path="/shopping"; $Domain="www.shop.com";
$Port="80"
```

Mỗi cockie bắt đầu bằng việc nhận dạng phiên bản HTTP state management mà client đang sử dụng; trong ví dụ này phiên bản hiện tại là 1. Phiên bản luôn luôn theo sau bởi tên của cockie và giá trị của nó. Chúng được set bởi server trong `Set-Cockie` hoặc `Set-Cockie1` header của nó, nhưng chú ý rằng server không thể sử dụng cockie name của `$Version`. Mặt khác, nó không thể nhận ra cockie trong một header. HTTP **không sử dụng** cockie NAME mà bắt đầu với ký tự $.

Các trường bổ sung mà theo sau cockie name và giá trị của nó là tùy chọn. Nếu được hiện thị,có thể là path, domain, và port của cockie.

### 3.2.20 Cockie2

Mặc dù nó cùng tên, nhưng mỗi quan hệ giữa `Cockie` và `Cockie2` header không giống như mỗi quan hệ giữa `Set-Cockie` và `Set-Cockie2` header. Trong khi `Set-Cockie2` được chỉnh sửa nhẹ từ phiên bản `Set-Cockie`, còn `Cockie2` với `Cockie` thì khác nhau hoàn toàn.

`Cockie2` header đơn thuần chỉ ra phiên bản của HTTP state management mà client hỗ trợ. Trong ví dụ sau, phiên bản hiện tại là 1.

`Cockie2: 1`

Client có thể chứa header này mỗi khi nó gửi một `Cockie` header. Điều đó báo cho server biết rằng nó có thể sử dụng `Set-Cockie2` header như là `Set-Cockie` header trong các response sau này. Client mà không hoàn toàn hỗ trợ `Set-Cockie2` thì sẽ bỏ qua `Cockie2` header, cho dù chúng có thể chứa `Cockie` header. Server sẽ không gửi client `Set-Cockie2` response.

### 3.2.21 Date

`Date` header chỉ ra thời gian mà hệ thống gửi message đó. Chú ý rằng các giá trị của `Date` áp dụng cho message, không cần thiết để tài nguyên nhận dạng hay chứa đựng nó trong message. `Last-Modified` header cung cấp thời gian của tài nguyên.

Với phiên bản HTTP v1.1, hệ thống được yêu cầu để sử dụng định dạng `rfc 1123` của giá trị thời gian.

`Date: Sun, 06 Nov 1994 08:49:37 GMT`

Để phù hợp với các cài đặt trước đây, HTTP v1.1 chấp nhận các ngày trong hai định dạng khác nhau. Định dạng đầu tiên trong ví dụ dưới đây, định nghĩa trong `rfc 850`. Chú ý rằng nó chỉ cung cấp số năm với hai chứ số, và ngày trong tuần là chuỗi đầy đủ.

`Date: Sunday, 06-Nov-94 08:49:37 GMT`

Một định dạng phổ biến khác. Đây là output của hàm asctime(), một phần của chuẩn thư viện ngôn ngữ C.

`Date: Sun Nov 6 08:49:47 1994`

HTTP yêu cầu server gốc phải chứa một `Date` header trong các response của nó, ngoại trừ 3 trường hợp sau đây. Nếu response status là một `100 Continue` hoặc `101 Switching Protocols`, server có thể bỏ qua `Date` header. Nếu response status chỉ ra một lỗi server và server không thể tạo ra ngày phù hợp, nó có thể bỏ qua `Date` header. Và cuối cùng, server mà không có đồng hồ chính xác sẽ không chứa một `Date` header.

### 3.2.22 ETag

`ETag` header giúp cho server nhận dạng tài nguyên, đặc biệt là cải thiện hiệu năng caching. Nếu không có `ETag` header, nó khó cho các cache để nhận ra các tài nguyên được request. Xem xét ví dụ sau, `url` http://www.yahooo.com/. Tài nguyên thực sự được trả về có thể đa dạng không dựa vào thời gian, nhưng theo vị trí địa lý thì user ở UK có thể thấy home page khác với user ở Pháp. Như hình 3.11 và 3.12 chúng minh.

Vấn đề này làm phức tạp sự tồn tại của Web cache, đặc biệt nếu chúng phải nhận dạng tài nguyên trong `url`. `ETag` header giải quyết vấn đề này bằng việc cung cấp một cách đơn giản để nhận dạng tài nguyên. Server gốc có thể gán cho tài nguyên một `ETag` - viết tắt của Entity Tag.

![Hình 3.11](http://i.imgur.com/DoucTXv.png)

**Hình 3.11: Web server có thể điều chỉnh nội dung của Web page để phù hợp với các user. Trong ví dụ này user được định vị là ở UK, nên server trả về nội dung cho địa phận này.**

![Hình 3.12](http://i.imgur.com/NkDgMxT.png)

**Hình 3.12: Một user ở Pháp request cùng URL có thể thấy nội dung khác, gây khó cho cache server.**

Một giá trị `ETag` có thể chứa các ký tự nhị phân bên trong bộ dấu "abc"; giá trị thực sự được tải lên server gốc. Sau đây là 1 ví dụ:

`ETag: "xyzzy"`

Weak ETag bắt đầy với w/ . Ví dụ:

`ETag: w/"xyzzy"`

### 3.2.23 Expect

Với `Expect` header, một client có thể báo cho server biết rằng nó mong đợi một hành động cụ thể. HTTP định nghĩa `Expect` như là một header có thể mở rộng, client mong muốn server trả về `100 Continue` status. Ví dụ:

`Expect: 100-continue`

Nếu một server nhận được một `Expect` header với cái mà nó không chấp nhận, nó phản hồi với một `417 Expectation Failed` status.

Khi client đang giao tiếp qua một chuỗi các proxy server, mỗi proxy trong chuỗi đó được mong muốn response `Expect`. Ngoài ra, proxy truyền `Expect` tới server tiếp theo mà không có chỉnh sửa.

### 3.2.24 Expires

`Expires` header chứa một thời gian mà tài nguyên không còn phù hợp. Cho đến lúc đó, cache giữ một bản sao của response và trả về bản sao đó trong response tới request sau này. Gía trị của header này là ngày, như ví dụ bên dưới, `Expire: 0` để chỉ ra rằng một tài nguyên không được cache.

`Expires: Thu, 01 Dec 1994 16:00:00 GMT`

Nếu một server không muốn cache tài nguyên, nó thiết lập giá trị của `Expire` header giống giá trị của `Date` header. Tuy nhiên thực tế thì hầu hết các server thiết lập `Expire` header là một thời điểm trong quá khứ. HTTP cũng cấp một server từ việc thiết lập giá trị của `Expire` header không vượt quá thời gian hiện tại 1 năm về tương lai.

Nhắc lại mục 3.2.10, một `Cache-Control max-age` ghi đè trực tiếp lên `Expire` header. Bởi vì HTTP đưa `Cache-Control` vào phiên bản 1.1 và các cài đặt trước đã hỗ trợ `Expire`, sự kết hợp của cả hai header này cho phép server xác định các thời hạn khác nhau với v1.1 và phiên bản trước 1.1 cache. Một server có thể làm vậy nếu các đặc điểm bổ sung phiên bản 1.1 cho phép nó mở rộng age của tài nguyên một cách an toàn.

### 3.2.25 From

 Client sử dụng `From` header để xác định User đã request. Gía trị của header này là một địa chỉ email. Bởi vì email tự nguyện gửi đi này tiết lộ email của các user nên bây giờ header này không còn tồn tại trong các request nữa.

### 3.2.26 Host

Với phiên bản 1.1 đưa vào `Host` header để giúp cho các nhà cung cấp Web hosting. Nếu không có `Host` header, các nhà cung cấp buộc phải sử dụng tài nguyên hosting không được hiệu quả. Như chúng ta sẽ thấy trong mục 2.4.1, vấn đề là nhà cung cấp muốn chạy nhiều web của các công ty trên cùng một hệ thống server vật lý. Nhưng ví dụ, nếu server hỗ trợ cả hai companya.com và companyb.com, thì server sẽ response tới các request như thế nào? Một client sẽ request một trang chủ của companya hay companyb.

```sh
GET / HTTP/1.1
Accept: */*
User-Agent: Mozilla/4.0
        (compatible; MSIE 5.5; Windows NT 5.0)

```

Nếu không có `Host` header, các nhà cung cấp buộc phải dành cho mỗi client một địa chỉ IP. Server có thể xác định response dựa trên địa chỉ IP của client mà đã gửi request. Thật không may, địa chỉ IP là hàng khan hiếm, và các nhà cung cấp sẽ không sử dụng chúng một cách phung phí. `Host` header giải quyết vấn đề này bằng việc cho phép một client chỉ ra `DNS` name cho mỗi tài nguyên mà nó request. Dưới đây là ví dụ: 

```sh
GET / HTTP/1.1
Accept: */*
User-Agent: Mozilla/4.0
(compatible; MSIE 5.5; Windows NT 5.0)
Host: www.companyA.com

```

Mặc dù nó hiếm khi được sử dụng, v1.1 cho phép một client xác định một `uri` đầy đủ trong request của nó. Trong các trường hợp, server bỏ qua giá trị củad `Host` header nếu một cái được hiện ra. Ví dụ, một server xử lý request dưới đây như là một request cho home page của CompanyB, mặc dù `Host` header chứa nội dung là `CompannyA`.

```sh
GET http://www.companyB.com/ HTTP/1.1
Accept: */*
User-Agent: Mozilla/4.0
(compatible; MSIE 5.5; Windows NT 5.0)
Host: www.companyA.com

```

### 3.2.27 If-Match

`If-Match` header thêm vào request của client điều kiện; server chấp nhận request chỉ khi điều kiện đúng. `If-Match` header liệt kê một hoặc nhiều Entit-Tag (ETag), và server xử lý request đó nếu tài nguyên khớp với một trong các Entity-Tag đó. Server không phải sử dụng giá trị weak Etag (mục 3.2.22) cho sự so sánh đó.

`If-Match` header có thể rất hữu ích khi client chỉnh sửa các tài nguyên được lưu trên server. Trong kiểu môi trường đó, `If-Match` ngăn cản sự xung đột có thể xảy ra khi nhiều user chỉnh sửa cùng một tài nguyên. Ví dụ, nhìn vào hành động đầu tiên trong chuỗi các hành động ở hình 3.13. Trong hình này, hai client khác nhau request một tài nguyên. Trong cả hai trường hợp, server trả về tài nguyên với một `ETag` header là `1234`.

![Hình 3.13](http://i.imgur.com/LHZygF9.png)

**Hình 3.13: Hai client khác nhau request cùng một object. Bởi vì object cùng giống nhau trong cùng response, server gán cho nó cùng giá trị ETag là 1234.**

Ví dụ tiếp theo trong hình 3.14. Client đầu tiên chỉnh sửa tài nguyên xong và gửi lại object được chỉnh sửa đó lên server bằng phương thức PUT. `If-Match` header báo cho server biết để xử lý request chỉ khi Etag của tài nguyên vẫn còn là 1234. Nếu tài nguyên vẫn chưa bị thay đổi thì server sẽ chấp nhận request. Tuy nhiên trong trường hợp này, tài nguyên đã bị thay đổi. Gía trị mới bị thay đổi bởi client nên server đã gán tài nguyên này với một ETag mới.

Một lúc sau, client thứ hai hoàn thành việc chỉnh sửa và chuẩn bị gửi lên server object mới được chỉnh sửa. Step 8 trong hình cho thấy, có cũng chứa một `If-Match` header. Tuy nhiên trong trường hợp này, 1234 không khớp với Etag mới của tài nguyên. Server từ chối request với một `412 Precondition Failed` status. 

![Hình 3.14](http://i.imgur.com/WS5GAJb.png)

**Hình 3.14: Client A trả về một object đã được chỉnh sửa trong step 5. Bởi vì object đã bị thay đổi, server gắn cho nó 1 ETag mới. Sau đó, khi client B có gắng update object ban đầu, server nhận ra sự xung đột và từ chối request đó.**

Client cũng có thể sử dụng một `If-Match` header với một dấu * cho ETag như ví dụ dưới đây. Trong trường hợp này, client yêu cầu server chấp nhận bất cứ request nào mặc kệ ETag. Một client có thể sử dụng tùy chọn này nếu nó muốn ngăn cản việc tạo Tag mới cho tài nguyên.

`If-Match: *`

### 3.2.28 If-Modified-Since

`If-Modified-Since` header cho phép client và proxy server sử dụng cache hiệu quả hơn. Nó yêu cầu một server response tới một request chỉ khi tài nguyên được thay đổi từ ngày được chỉ định. Hình 3.15 cho thấy một GET reuqest chuẩn mà truyền tới một proxy server. Yếu tố quan trong của response server là `Last-Modified` header, nó chỉ ra lần cuối cùng chỉnh sửa tài nguyên được request.

![Hình 3.15](http://i.imgur.com/behdb3m.png)

**Hình 3.15: Khi một server trả về một object, nó chỉ ra lần cuối mà object bị chỉnh sủa bằng cách xác đinh giá trị của Last-Modifed header.**

Tiếp tục ví dụ với hình 3.16. Một lúc sau client tạo ra một request khác cho cùng một tài nguyên. Proxy có chứa một bản sao của request trước trong bộ nhớ của nó, nên nó chèn `If-Modified-Since` header vào trong request trước khi truyền tới server gốc. Gía trị của header này giống thời gian `Last-Modifed` của server gốc. 

![Hình 3.16](http://i.imgur.com/4eOOB0E.png)

**Hình 3.16: Một proxy server có thế sử dụng If-Modified header để request một object chỉ khi nó bị thay đổi. Ví dụ, object chưa thay dổi, nên server trả về 304 Not Modified status.**

Trong ví dụ này, tài nguyên chưa thay đổi. Thay vì trả về toàn bộ object, server gốc phải hồi với một `304 Not Modified` status. Status này báo cho proxy server biết bản sao của object đó vẫn còn phù hợp, nên nó trả về bản sao cho client. Nếu bản sao đó lớn, bước này có thể lưu lại bằng thông mạng lớn và trì hoãn, bởi vì object không phải đi từ server gốc tới proxy một lần nữa.

Client sử dụng `If-Modified-Since` header không những dành cho request chuẩn, mà nó còn dành cho các request cục bộ với `Range` header. Nói chung trong trường hợp này `If-Modified-Since` header áp dụng cho cả một object chứ không để request một phần của object.

Nếu ngày trong một `If-Modified-Since` header không phù hợp , vì nó sai định dạng hoặc trễ hơn thời gian hiện tại của server, sau đó server bỏ qua header này và trả về tài nguyên.

Client sử dụng `If-Modifed-Since` header tính đến hai vấn đề với nhiều server được triển khai. Đầu tiên, các server so sánh giá trị `If-Modifed-Since` khớp hoàn toàn với giá trị `Last-Modified` của tài nguyên. Dù giá trị của `If-Modifed-Since` trễ hơn so với giá trị của `Last-Modified`, các server đó sẽ trả về đầy đủ object. Client mà muốn phù hợp với hành vi này thì sẽ chỉ sử dụng giá trị của `Last-Modified` header. Vấn đề thứ hai là đồng bộ hóa thời gian. Client phải nhận thức rằng server clock không phải lúc nào cũng đúng, chúng ta phải chịu sự không chính xác về thời gian và những sai sót của con người. Cách cuối cùng cho client thích nghi với các vấn đề là chỉ sử dụng giá trị `Last-Modified` header của server.

### 3.2.29 If-None-Match

`If-None-Match` header đối lập với `If-Match` header. Khi một client chứa `If-None-Match`, nó yêu cầu server hoàn thành request chỉ khi tài nguyên có ETag **khác với nó** trong header. Server có thể xem xét giá trị strong ETag cho tất cả request và giá trị weak ETag chỉ với phương thức `GET` và `HEAD`.

Với request `GET` và `HEAD`, `If-None-Match` header hoạt động như `If-Modified-Since`. Nếu server tìm thấy ETag cho tài nguyên mà giống với một cái bất kì được liệt kê trong danh sách của `If-None-Match` header, server sẽ trả về một `304 Not Modified` status. Nếu client chứa cả `If-None-Match` và một `If-Modified-Since` header trong request, `If-Modified-Since` header sẽ được ưu tiên. Nếu server tin tưởng tài nguyên mới hơn so với thời gian của `If-Modified-Since`, nó trả về toàn bộ tài nguyên mặc kệ `If-None-Match` header.

Trong tất cả các trường hợp, nếu request đưa ra các status khác với `2xx` và `304` mà `If-None-Match` header không hiện thị ra, server trả về status đó và bỏ qua `If-None-Match`.

Cũng như với `If-Match` header, `If-None-Match` cho phép một client sử dụng dấu * để trình bày các giá trị của ETag. Với ví dụ bên dưới, việc sử dụng đó yêu cầu server chấp nhận các request chỉ khi tài nguyên **không** thật sự tồn tại. Một client có thể sự dụng giá trị header này trong một `PUT` request nếu nó muốn chắc chắn và không ghi đè lên một object tồn tại.

`If-None-Match: *`

### 3.2.30 If-Range

`If-Range` header cải thiện hiệu năng cho client hoặc các proxy mà chứa một phần của object trong local cache của chúng. Nếu không có `If-Range`, client request hai sự trao đổi để lấy được bản sao mới của object mà bản sao đó đã được thay đổi. Hình 3.17 cho thấy việc trao đổi message khi chưa có `If-Range`.

Trong step 1, client request tài nguyên từ 500-1000 byte, nhưng ETag cho tài nguyên này vẫn là "1234". Khi server nhận ra rằng tài nguyên đã bị thay đổi, nó phản hồi với một `412 Precondition Failed` status. Client sau đó phải tạo ra một request mà để request cho một object mới.

![Hình 3.17](http://i.imgur.com/XihBtqf.png)

**Hình 3.17: Nếu không có If-Range header, một client có thể phải tạo thêm 2 request khi nó chứa một phần của object nhưng nó không còn phù hợp nữa. Request đầu tiên báo cho client biết rằng bản sao của nó không phù hợp, và request thứ hai lấy ra toàn bộ object mới.**

`If-Range` header cho phép một client kết hợp các request đó lại thành một, như hình 3.18 minh họa. Trong request của nó, client chứa một `If-Range` header và một `Range` header. Cả hai cái đó cùng báo cho server biết chỉ trả về range được request nếu ETag của tài nguyên vẫn là "1234", nếu không thì server trả về toàn bộ object. Trong ví dụ này, object bị thay đổi nên server trả về toàn bộ object với một `200 OK` reponse.

![Hình 3.18](http://i.imgur.com/UUt7GTz.png)

**Hình 3.18: If-Range header cho phép một client request một phần hoặc toàn bộ client, nếu phần đó không còn phù hợp, server sẽ trả về toàn bộ tài nguyên trong response.**

Với các server không sử dụng ETag, `If-Range` header là một định dạng tùy chọn. Thay vì một ETag cho giá trị của `If-Range`, client có thể sử dụng ngày. Trong các trường hợp đó, client yêu cầu server trả về range riêng nếu tài nguyên chưa bị thay đổi từ ngày được chỉ định đó. Hình 3.19 cho thấy việc client sử dụng tùy chọn này như thế nào.Trong hình đó, không giống như hai hình trước, tài nguyên chưa bị thay đổi, nên server chỉ trả về range được request.

![Hình 3.19](http://i.imgur.com/6VSGKxT.png)

**Hình 3.19: Client chỉ ra một ngày thay cho giá trị của ETag của If-Range header. Trong cả hai trường hợp, server trả về một object riêng chỉ khi một phần của client đang tồn tại vẫn phù hợp.**

`If-Range` header không sử dụng định dạng đặc biệt để phân biệt ETag với date trong If-Range. Nó là trách nhiệm của server là thông dịch header đó chinh xác. Bởi vì ETag được đính kèm trong dấu ngoặc kép còn date thì không, server có thể dễ dàng xác định.

### 3.2.31 If-Unmodified-Since

`If-Unmodified-Since` là một sự đối lập của `If-Modified-Since`. Nếu một client chứa `If-Unmodified-Since` trong request của nó, nó yêu cầu server chấp nhận request chỉ khi tài nguyên được tham chiếu không bị thay đổi **từ** ngày được chỉ định. Một client có thể sử dụng header này trong `PUT` request nếu nó muốn đảm bảo rằng không thành phần nào thay đổi tài nguyên trong khi client đang chỉnh sửa nó.

Giống như các `If-` header khác, server xem xét `If-Unmodified-Since` header chỉ khi request được trả về một `200 OK` status. Nếu điều kiện của `If-Unmodified-Since` không cố định, server sẽ trả về `412 Preconditon Failed` status.

### 3.2.32 Last-Modified

`Last-Modified` header cung cấp ngày mà tài nguyên lần cuối cùng được chỉnh sửa khi nào. Ví dụ dưới đây sẽ cho thấy, header này chủ yếu vì lợi ích cho proxy và client, bởi vì nó cho phép chúng định ngày cho một object được lưu trong local cache. Khi hệ thống cần lấy một bản sao mới của một object, nó có thể sự dụng date này, cùng với `If-Modified-Since` header, nó ngăn cản server gửi lại toàn bộ tài nguyên nếu nó không bị thay đổi. Hình 3.15 và 3.16 cho thấy sự vận hành này.

`Last-Modified: Tue, 15 Nov 1994 12:45:26 GMT`

### 3.2.33 Location

Server sử dụng `Location` header để chuyển hướng client tới một URUI mới cho một tài nguyên. `Location` header được sử dụng phổ biến với response có chứa `3xx` status code, nhưng server cũng có thể sử dụng `Locaction` header trong một `201 Created` response. Trong trường hợp đó, header báo cho client nó có thể lấy bản sao của tài nguyên mà nó mới gửi request tới server bằng phương thức `PUT`.

Hình 3.20 cho thấy hoạt động phổ biến của một `Location` header. Trong step 1, client gửi một GET request tới server a. Server đó không có tài nguyên , nhưng nó biết chỗ mà tài nguyên có thể được tìm thấy. Trong câu trả lời của nó, nó trả về một `302 Found`, và nó chứa một `Location` header. Gía trị của header này là một URI đầy đủ cho tài nguyên. Client có thể sử dung thông tin này để tái tạo một reuqest tới server được chỉ định, server b là server được chỉ định và nó trả về tài nguyên theo yêu cầu.

![Hình 3.20](http://i.imgur.com/B8NuQvI.png)

**Hình 3.20: Location header đưa ra cho client một uri cho một object. Nếu phù hợp, client request theo location đó. Trong ví dụ này, server A báo cho client biết là phải lấy tài nguyên ở server B.**

`Loaction` header thì rất khác so với `Content-Location` header, mặc dù có sự giống nhau trong tên gọi. Khi một server chứa một `Content-Location` header, nó báo cho client nơi mà tài nguyên được lấy ra; một `Location` header báo cho client biết chỗ một tài nguyên hiện tại đang được lưu trữ.

### 3.2.34 Max-Forward

`Max-Forward` header đi cùng với phương thức `OPTIONS` và `TRACE`, giúp client chữa các lỗi mà ngăn cản chúng nhận được các response từ server. Có hai loại vấn đề mà có thể là rất khó để chuẩn đoán được nếu không có `Max-Forward` header.

Hình 3.21 cho thấy tình huống khi một lỗi trung gian. Trong hình, proxy server b nhận request ở step 2, nhưng nó không thể chuyển request tới server gốc. Tình huống này làm khổ client. Client giao tiếp trực tiếp với proxy server a và nó thể xác nhận là proxy server vẫn hoạt động bình thường. Client cũng có thể xác nhận server hoặc động chính xác ( bằng việc gọi cho hỗ trợ kỹ thuậ server ). Tuy nhiên, bằng cách nào đó request không được gửi tới server.

![Hình 3.21](http://i.imgur.com/eZBKVnx.png)

**Hình 3.21: Nếu một proxy server thất bại trong việc chuyển request, client không thể nhận được bất cứ response nào.**

Vòng lặp request cũng ngăn không cho client nhận được response, nhưng nói chung nó làm hại tới mạng. Khi vòng lặp xuất hiện, các request tuần hoàn qua các proxy server vô hạn, buộc mạng và tài nguyên máy chủ lại. Hình 3.22 minh họa vấn đề này. Thay vì đến server gốc, request của client tiếp tục truyền qua 3 proxy server. Ví dụ, proxy a truyền cho proxy b, proxy b truyền cho proxy c rồi proxy c truyền cho proxy a, cứ như vậy truyền theo vòng tròn.

![Hình 3.22](http://i.imgur.com/DuKchI6.png)

**Hình 3.22: Vòng lặp có thể nảy sinh khi các proxy vận chuyển tuần hoàn qua nhau mà không chuyển đến server gốc. Đây là một lỗi khác ngăn cản client nhận được response.**

Trong các trường hợp của cả hai hình 3.21 và 3.22, client không bao giờ nhận được response cho request của nó, khi mà điều đó xảy ra, client có thể cầu viện phương thức `TRACE` cùng với `Max-Forward` và `Via` header.

`Max-Forward` giới hạn số hệ thống trung gian mà mỗi request truyền qua. Client ( thậm chí là proxy server ) set cho nó một giá trị ban đầu và các server sau nhận được request với giá trị của header đó giảm dần. Nếu một server trung gian nhận request với `Max-Forward` với giá trị là 0, nó không phải truyền request đi nữa. Nó phản hồi lại như thể nó là một server gốc.

Sau đây là việc mà client có thể phát hiện ra vòng lặp request như thế nào trong hình 3.22. Nó bắt đầu gửi một phương thức `TRACE` với một `Max-Forward` được set là 0. Như hình 3.23 cho thấy, proxy server đầu tiên thấy được giá trị của `Max-Forward` và phản hồi lại với một `200 OK`.

![Hình 3.23](http://i.imgur.com/XcQYoE4.png)

**Hình 3.23: Max-Forward header giới hạn số proxy server mà một request có thể truyền qua. Với giá trị là 0, nó không truyền đi xa hơn nữa. Proxy phản hồi lại như một server gốc.**

Khi client nhận một response từ proxy a, nó gửi một `TRACE` khác, lần này với một `Max-Forward` được set là 1. Hình 3.24 chứng minh việc xảy ra lần này. Proxy a chấp nhận request, giảm giá trị của `Max-Forward` header, và gửi nó tới server tiếp theo là proxy b. Như hình đó cho thấy, proxy a cũng chèn vào nó một `Via` header. Mục 3.2.50 sẽ mô tả chi tiết về header này. Mục đích chính của nó lần này là chú thích về proxy server mà nó truyền qua. Trong step 4, khi message đến server b, `Max-Forward` header ngăn cản server b gửi nó đi xa hơn nữa. Thay vào đó, proxy b trả về response cho client.

![Hình 3.24](http://i.imgur.com/VjxckoG.png)

**Hình 3.24: Khi proxy nhận được một request với Max-Forward là 0, nó phản hồi request đó cho client thay vì gửi nó tới server gốc. Trong ví dụ này, proxy B không gửi request mà phản hồi trực tiếp. Message body trong response là một bản sao của request mà proxy B nhận được.**

Hình 3.24 phá bỏ các quy tắc bình thường bằng việc hiện thị ra toàn bộ http message trong step 5 và 6. Các bước này cho thấy response từ proxy b khi nó trả về client. Khi client nhận được response ở step 6, nó đạt được thông tin quan trong về vấn đề này. Nó biết được sau proxy a là một proxy b.

Client tiếp tục tìm kiếm lỗi tiếp bằng cách tăng giá trị của `Max-Forward` lên 1 thành 3. Như thường lệ nó nhận response của step 20 trong hình 3.25. Và response này cho phép client nhận ra được vòng lặp. Từ `Via` header trong message body, client có thể thấy request đó được truyền qua proxy a hai lần, và do đó nó bị mắc kẹt trong vòng lặp.

Client có thể sử dụng tiến trình tương tự để nhận ra các lỗi của server trung gian. Nó bắt đầu mới một giá trị của `Max-Forwards` là 0 và giảm dần nó mỗi lần nó nhận một response từ `TRACE` request. Khi mà không có response nào đến, client biết là request thất bại.

![Hình 3.25](http://i.imgur.com/NfQOiRK.png)

**Hình 3.25: Max-Forward header có thể giới hạn vòng lặp cho một request. Mỗi proxy giảm dần giá trị của header khi truyền qua nó, cho đến khi giá trị bằng 0. Trong ví dụ này, Max-Forward là 0 khi request đến proxy A hai lần ( ở step 16 ). Proxy A phản hồ request thay vì gửi nó đi tiếp.**

### 3.2.35 Meter 

Giống như `Cache-Control` header chúng ta được thấy ở mục trước, `Meter` header hỗ trợ một vài tùy chọn khác nhau như là các chỉ thị. Caching proxy server và server gốc sử dụng các chỉ thị này để báo cáo lượt truy cập trang và để giới hạn caching của tài nguyên, mục 2.4.5 sẽ giải thích. Việc xử lý đo lường diễn ra trong 3 giai đoạn. Bảng 3.9 liệt kê các chỉ thị Meter riêng lẻ. 

>**Bảng 3.9: Các chỉ thị của Meter header**

|Chỉ thị|Short|Được sử dụng trong|Dùng để|
|-------|-----|------------------|-------|
|count=n/m|c=n/m|Request sau|Proxy server báo cáo sử dụng|
|do-report|d|Response|Server gốc yêu cầu proxy cung cấp báo cáo|
|dont-report|e|Response|Server gốc báo cho proxy không cần phải báo cáo|
|max-reuses=n|r=n|Response|Server gốc chỉ ra giới hạn cho các lượt truy cập trang bình thường|
|max-uses=n|u=n|Response|Server gốc chỉ ra giới hạn cho các lượt truy cập đặc biệt|
|timeout=n|t=n|Response|Server gốc chỉ ra thời gian cực đại giữa các báo cáo|
|will-report-and-limit|w|Reuqest trước|Proxy có thể hỡ trợ việc đo lường|
|wont-ask|n|Response|Server gốc chi ra rằng nó sẽ không yêu cầu đo lường cho một object|
|wont-limit|y|Request trước|Proxy hiểu được việc đo lường nhưng sẽ không giới hạn việc sử dụng|
|wont-report|x|Request trước|Proxy hiểu được việc đo lương như không phải báo cáo việc sử dụng|

Quy trình đo lường bắt đầu khi một request truyền qua một proxy server. Nếu proxy server muốn hỗ trợ việc đo lường, nó thêm một `Meter` header vào trong request. Trong header đó, proxy có thể xác định kiểu hỗ trợ mà nó cung cấp như là `will-report-and-limit, wont-limit,` hoặc `wont-report`. Nếu không có các chỉ thị đó, mặc đinh sẽ là cả `report và limit`. Proxy cũng phải thêm một `Connection: Meter` header vào trong request. Nếu proxy đồng ý với trường hợp mặc định ( hỗ trợ cả limit và report ), nó chỉ cần chứa `Connection: Meter` header ngụ ý là `Meter` header vẫn có tồn tại.

```sh

GET / HTTP/1.1
Via: proxy
Connection: Meter

```

Khi server phản hồi request này, nó cung cấp một sự điều khiển cho proxy mới một `Meter` header trong response. Header đó chứa một chuỗi các chỉ thị. Nó báo cho proxy biết là server muốn nhận các báo cáo kiểu `do-report` hay `dont-report`; nó xác định số lần lớn nhất mà proxy trả về reponse từ cache của nó (`max-uses` và `max-reuses`). và nó có thể xác định một sự giới hạn thời gian trước khi proxy gửi một báo cáo mới (`timeout=n`). Chú ý rằng, không giống như các giá trị của HTTP header, giá trị của `timeout` là phút, không phải giây. Trong ví dụ bên dưới, server gốc yêu cầu proxy cung cấp báo cáo ít nhất mỗi giờ một lần. Response cũng định rõ không giới hạn. Nếu server muốn báo cho proxy biết không được gửi cho nó thêm `Meter` header nữa, nó có thẻ sử dụng chỉ thị `wont-ask` trong `Meter` header của nó. 

```sh
HTTP/1.1 200 OK
Date: Sun, 08 Oct 2000 18:46:12 GMT
Meter: do-report, timeout=60
Connection: Meter

...
```

Khi proxy server thấy response của server và các cache massage body, nó bắt đầu đếm số lần nó trả về object từ cache của nó. Nó đếm số lượt truy cập cả  trang đặc biệt và trang bình thường. Các proxy xem xét response nơi mà chúng thực sự trả về các object là lượt truy cập trang đặc biệt (với một 200 OK status) và các response mà xác nhận bản sao được lưu trữ trước như là một lượt truy cập trang bình thường ( một 304 Mot Modified status ). Mỗi khi việc đếm đạt đến cực đại xác định bởi server, proxy tái tạo object với server gốc trước khi trả nó về client.

Nếu proxy server tiếp tục nhận được request cho một cached object, nó phải xác định khi nào gửi một báo cáo việc sử dụng tới server gốc. Proxy gửi báo cáo này mỗi khi nó phải gửi một `GET` hoặc `HEAD` tới server gốc, mỗi khi số lần giới hạn của server hết hạn hoặc mỗi khi proxy xóa cái object từ bộ nhớ cache của nó. Báo cáo bao gồm một `Meter` header với một chỉ thị `count`. Hai giá trị của `count` là số lần sử dụng và tái sử dụng. Ví dụ dưới đây báo cáo 934 lượt sử dụng và 201 lượt tái sử dụng.

```sh
GET / HTTP/1.1
Via: proxy
Meter: count=934/201
Connection: Meter

```

### 3.2.36 Pragma

`Pragma` header là kẻ đương nhiệm cho phiên bản trước của HTTP. Với phiên bản 1.1, chỉ có một định dạng cho header này; nó được mô tả trong ví dụ dưới đây.

`Pragma: no-cache`

Mục đích của header này là cách mà client chỉ ra rằng client không muốn các server trung gian trả về cache response. Thay vào đó , chúng yêu cầu các proxy gửi các request tới server gốc. Trong thực tế, nhiều server chứa `Pragma: no-cache` trong response của chúng như một cách để báo cho các server trung gian không được lưu response trong bộ nhớ cache của proxy. Tuy nhiên server bị cảnh báo không được thừa nhận rằng các server trung gian chấp nhận header này.  Một cách khác an toàn hơn cho server gốc mà không muốn response của nó bị cache thì hãy chứa một `Expires` header với một ngày trong quá khứ.

Ở một thời điểm nào đó trong tương lai, tất cả các hệ thống trung gian sẽ tương thích với phiên bản 1.1. Tại thời điểm này, server và client có thể cùng sử dụng `Cache-Control: no-cache` header.

### 3.2.37 Proxy-Authenicate (Xác thực proxy)

`Proxy-Authenticate` header cho phép các proxy server trung gian xác thực một client. Bằng việc chứa header này trong một response, proxy yêu cầu client tái tạo request nhưng phải chứa giấy phép quyền hạn của nó. Proxy server luôn phải chứa `Proxy-Authenticate` header trong response với một `407 Proxy Authenticate Required` status. `Proxy-Authenticate` giống `WWW-Authenticate`, ngoại trừ rằng nó được tạo ra bởi proxy server thay vì server gốc. Các chứng chỉ công nghệ của proxy và server gốc sẽ được miêu tả chi tiết trong mục 4.1.

### 3.2.38 Proxy-Authentication

Một client phản hồi tới request của proxy server cho sự xác thực bằng việc chứa một `Proxy-Authentication` khi nó tái tạo request. Mục 4.1 sẽ mô tả chi tiết hơn.

### 3.2.39 Range

`Range` header cho phép client request một phần của tài nguyên thay vì toàn bộ tài nguyên. Như chúng ta đã thấy trong mục 3.2.25, header này được viết với form dưới đây. Trong một request, header này yêu cầu 500 byte ( từ 500 đến 999 byte ) và hai byte cuối cùng của tài nguyên. Chú ý rằng số byte của HTTP 1.1 bắt đầu với số 0.

`Range: bytes 500-999, -2`

Với header đó, server trả về một status code là `206 Partial Content`. Server cũng chứa `Content-Range` header trong response của nó. Nếu server không thể trả về range được request thì nó có thể phản hồi toàn bộ tài nguyên kèm với một `200 OK` status code. Bởi qui tắc này và nhiều server có thể không hiểu `Range` header, client sẽ phải nhận toàn bộ tài nguyên.

### 3.2.40 Referer

`Referer` header ( người môi giới ) xuất hiện trong request của client nên server có thể xác định được nơi mà client nhận được uri trong request của nó. Trong ví dụ sau đây, nhìn vào Web pagee của hình 3.26. Đó là một trang chủ của the Internet Engineering Task Force, địa chỉ là http://www.ietf.org.

Chú ý rằng trang này chứa một link tới Web site cho the Internet Assigned Numbers Authorty (iana). Link xuất hiện ở góc dưới bên phải và một thẻ HTML cho link đó.
<a href="http://www.iana.org">IANA</a>

![Hình 3.26]()

**Hình 3.26: Khi một user truy cập vào một Web page link, chẳng hạn như link tới IANA, trình duyệt chứa địa chỉ web của trang đó, www.ietf.org trong request của nó.**

Nếu user click vào link, browser tạo ra một HTTP GET request tới www.eitf.org. Bởi vì link xuất hiện trên trang wwww.ietf.org, nên request sẽ liệt kê các trang của ietf trong `Referer` header. Sau đây là ví dụ thực sự của một HTTP GET request.

```sh
GET / HTTP/1.1
Referer: http://www.ietf.org/
Accept-Language: en-us
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/4.0 (compatible;
            MSIE 5.5; Windows NT 5.0)
Host: www.iana.org
Connection: Keep-Alive

```

### 3.2.41 Retry-After

Server sử dụng `Retry-After` header để báo cho client biết khi nào nó thử lại request của nó. Header có thể xác định ngày nên ví dụ dưới đây request một client đợi đến 1/1/2001 để tái tạo lại request.

`Retry-After: Sun, 31 Dec 2000 23:59:59 GMT`

Header cũng có thể chỉ ra số giây. Ví dụ dưới đây báo cho client biết nó phải đợi 2 phút trước tri thử lại.

`Retry-After: 120`

Server cũng có thể sử dụng header này với một `503 Service Unavailable` hoặc bất cứ response chứa status `3xx`.

### 3.2.42 Server

Với `Server` header, một HTTP server xác định phần mềm mà nó sử dụng để hoạt động HTTP. Header này là một phiên bản của `User-Agent` header (thấy trong mục 3.2.48). Ví dụ sau cho thấy các giá trị của `Server` header có thể tìm thấy được trên Web ngày nay.

`Server: Apache/1.3.6 (Unix) (Red Hat/Linux)`

```sh
Server: IBM-Planetwide/10.45
        Domino-Go-Webserver/4.6
```

`Server: Microsoft-IIS/5.0`

`Server: NaviServer/2.0 AOLserver/2.3.3`

`Server: Netscape-Enterprise/3.6 SP3`

`Server: Xitami`

### Set-Cockie2

`Set-Cockie2` header là một update nhẹ của `Set-Cockie` header từ phiên bản http 1.0 . Cả hai header này được sử dụng bởi server để chỉ ra HTTP state management với một client. (Xem mục 2.5) . Bằng việc chứa một `Set-Cockie2` header trong response của nó, một server cung cấp một state management cockie tới client, và nó yêu cầu client trả về cockie đó trong request sau này tới server.

Header bắt đầu bằng việc đưa ra tên và giá trị của cockie, và sau đó nó cung cấp các thuộc tính được liệt kê trong bảng 2.1 . Một ví dụ với tất cả các thuộc tính khả thi:

```sh
Set-Cookie2: NAME="VALUE";
Comment="Shopping Cart";
CommentURL="http://merchant.com/cookies.html";
Discard; Max-Age="300"; Path="/shopping";
Port="443"; Secure; Version="1"
```

Xem lại mục 2.5

### 3.2.44 TE

`TE` header báo cho một server biết kiểu Tranfer Encoding mà client có thể chấp nhận trong một response, và nó có thể chỉ ra các sự ưu tiên cho các kiểu tranfer encoding. Header này rất giống với `Accept-Encoding` header, ngoại trừ một điều là nó áp dụng cho tranfer encoding hơn là content encoding.

Định dạng của `TE` header rất giống với `Accept-Encoding` header. Gía trị của header là được ngăn cách nhau bởi dấu phẩy. Ví dụ sau đây chứa một header chỉ ra rằng client có thể chấp nhận kiểu tranfer encoding là gzip và deflate, nhưng nó ưu tiên gzip hơn bởi vì nó hứa tham số cao hơn. (1 > 0.9).

`TE: gzip, deflate;q=0.9`

Ngoài chuẩn Tranfer Encoding, `TE` header đưa ra một giá trị đặc biệt để xác định Transfer Encoding kiểu `chunked` với các trường trailer. Chú ý rằng client không cần liệt kê Transfer Encoding kiểu `chunked` trong `TE` header bởi vì tất cả các HTTP 1.1 client phải chấp nhận tranfer encoding kiểu `chunked`. Tuy nhiên, việc sử dụng trường trailer chunked encoding là tùy chọn, giá trị header này cho phép một client nói lên rằng nó hiểu được định dạng đó.

`TE: trailers`

### 3.2.45 Trailer

Client và server chứa `Trailer` header khi chúng sử dụng Transfer Encoding kiểu chunked cho message body. Header này liệt kê các header http khác xuất hiện sau mesage body. Nó báo cho người tiếp nhận các header nó mong đợi trong chunked tranfer encoding trailer. Có 3 trường header không thể xuất hiện trong chunked trailer: `Transfer-Encoding`, `Content-Length` và `Trailer`. 

Ví dụ sau đây cho thấy một response đơn giản với `Trailer` header. Response sử dụng Transfer Encoding kiểu `chunked` và `Trailer` header liệt kê các `Expires`. `Expires` header xuất hiện sau message body.

```sh
HTTP/1.1 200 OK
Date: Fri, 31 Dec 1999 23:59:59 GMT
Content-Type: text/plain
Transfer-Encoding: chunked
Trailer: Expires

1a
ABCDEFGHIJKLMNOPQRSTUVWXYZ
0
Expires: Sat, 01 Jan 2000 23:59:50 GMT

```

### 3.2.46 Transfer-Encoding

`Transfer-Encoding: chunked`

chunked transfer encoding để cải thiện hiệU năng của server. Server có thể gửi một response trong khi nó đang soạn thảo chúng; trái lại, nếu không có chunked encoding, nó buộc phải trì hoãn việc phản hồi cho đến khi toàn bộ message được hoàn thành.

Vấn đề nảy sinh vì server HTTP v1.1 phải chỉ ra kích thước của response message. Trước HTTP v1.1, server chỉ được gửi response và phải ngắt kết nối. Một client có thể  báo rằng nó nhận được toàn bộ response khi kết nối bị ngắt. Tuy nhiên với HTTP v1.1, việc duy trì kết nối là mặc định, và đóng kết nối sau mỗi response làm cho nó không còn khả thi nữa. Tuy vậy, client vẫn cần nhiều cách để biết được khi nào chúng nhận được tất cả message. `Content-Length` header là phương án đơn giản nhất đề giải quyết vấn đề này. Khi server chứa `Content-Length` header trong một response, client chỉ cần đếm số byte để biết được khi nào nó hoàn thành response.

Mặc dù đơn giản và dễ sử dụng, `Content-Length` header vẫn có vấn đề của nó. `Content-Length` header là một trong những phần đầu tiên của một response. Nhưng trước khi một server có thể tinh toán được giá trị của `Content-Length`, nó phải biết kích cỡ đầy đủ của message body. Sự hạn chế này đồng nghĩa với việc trước khi một server gửi một response, nó phải soạn đầy đủ message body và tính toán kích thước của nó. Khi message body lớn, và khi server tạo ra message thì làm giảm hiệu năng của server.

Với chunked transfer encoding, server chia message body ra thành một hoặc nhiều `chunk` (thùng0. Trong response của nó, server gửi từng `chunk` theo thứ tự lần lượt. Mỗi `chunk` đi kèm với một dòng chỉ kích thước của chunk dưới dạng mã hexa. `chunk` cuối cùng có kích thước là 0 byte. Sau đây là một ví dụ message body với ba `chunk`. ( Cái thứ ba có kích thước là byte, nên chỉ có hai cái đầu tiên chứa nội dung. ) Tổng cộng kích thước của message body là 26 byte. ( `chunk` đầu tiên là `1a` hoặc 16 byte và `chunk` thứ hai là `0a` hoặc 10 byte. ). 1a là chunk của ABCDEFGHIJKLMNOPQRSTUVWXYZ và 0a là chunk của 0123456789.

```sh
HTTP/1.1 200 OK
Date: Fri, 31 Dec 1999 23:59:59 GMT
Content-Type: text/plain
Transfer-Encoding: chunked

1a
ABCDEFGHIJKLMNOPQRSTUVWXYZ
0a
0123456789
0

```

Để so sánh, sau đây là một mà message body không có chunked sẽ như thế nào.

```sh
HTTP/1.1 200 OK
Date: Fri, 31 Dec 1999 23:59:59 GMT
Content-Type: text/plain
Content-Length: 36

ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789

```

### 3.2.47 Upgrade

`Upgrade` header cho phép một client và server tạo ra một nâng cấp tới một giao thức giao tiếp khác. Giao thức mới có thể là một phiên bản mới của HTTP hoặc là một giao thức khác toàn toàn như là Transport Layer Security. ( Mục 4.3.3 mô tả `tls` sử dụng `upgrade` như thế nào.) Client đề ra một upgrade giao thức bằng việc chứa một `Upgrade` header trong request của nó.
 
```sh
GET http://www.bank.com/acct.html?749394889300
HTTP/1.1
Host: www.bank.com
Upgrade: TLS/1.0
Connection: Upgrade

```

Server có thể phản hồi request này với một `101 Switching Protocols` status, và nó chứa  một `Upgrade` header trong response của nó.

```sh
HTTP/1.1 101 Switching Protocols
Upgrade: TLS/1.0, HTTP/1.1
Connection: Upgrade
```

Chú ý rằng cả request và response cùng chứa `Connection: upgrade` header. Header này phải luôn luôn xuất hiện khi `Upgrade` được sử dụng bởi vì mỗi bản nâng cấp chỉ áp dung giữa client và server đầu tiên. Nếu một server muốn nâng cấp việc giao tiếp của nó với server gốc, nó có thể sử dụng phương thức `CONNECT` để tạo ra một kết nối ảo với server đó và sau đó nâng cấp kết nối ảo đó.

Ví dụ cũng cho thấy rằng response chứa `101 Switching Protocol` liệt kệ một chuỗi các giao thức trong `Upgrade` header. Trong response đó, server chỉ ra rằng nó đang nâng cấp lên HTTP 1.1 qua TLS 1.0.

### 3.2.48 User-Agent

`User-Agent` header là một phiên bản client của `Server` header. Với `User-Agent`, một client nhận dạng được các cài đặt HTTP đang được sử dụng. Ví dụ, việc mà Netscape Navigator trên máy Macintosh của Apple nhận dạng chính nó.

`User-Agent: Mozilla/4.x (Macintosh)`

Web site http://browserwatch.internet.com đưa ra một danh sách các cài đặt của client khác nhau đang truy cập vào trang đó. Hiện tạI thì nó đưa ra 213 máy sử dụng IE, 65 máy sử dụng Netscape' Navigator và 510 http client khác.

### 3.2.49 Vary

Với `Vary` header, server gốc hướng dẫn thêm cho proxy serveer trong việc quản lý local cache của chúng. `Vary` header liệt kê các http header khác nhau , ngoại trừ `uri`, xác định tài nguyền mà server trả về trong response của nó. Ví dụ, các server gốc trả về các tài nguyên khác nhau dựa trên giá trị của `User-Agent` trong request của client. Ví dụ sau đây chứa một `Vary` header trong response của nó.

```sh
HTTP/1.1 200 OK
Date: Fri, 31 Dec 1999 23:59:59 GMT
Content-Type: text/html
Vary: User-Agent

...
```

Một proxy server sẽ biết được rằng nó có thể trả về một bản sao cache của response qua các request sau chỉ khi các request đó chứa cùng giá trị `User-Agent` như request tới server gốc. Một giá trị của `User-Agent` khác buộc cache phải tạo ra câu lệnh query lại với server.

### 3.2.50 Via

`Via` header đưa ra đường dẫn của một message khi nó đi qua một proxy server. HTTP yêu cầu một server trunng gian ghi tên mình vào một `Via` header trong mỗi request hoặc client trước khi chuyển nó đi. Một proxy có thể thêm hoặc tạo mới một `Via` header. Hình 3.27 cho thấy `Via` header tăng dần trong request từ client tới server.

![Hình 3.27](http://i.imgur.com/TISs06W.png)

**Hình 3.27: Via header ghi lại đường dẫn của một HTTP message khi nó đi qua một proxy server. Các server cũng chỉ ra phiên bản HTTP mà chúng chấp nhận.**

Proxy server đầu tiên tạo một `Via` header và thêm giá trị vào đó. 1.1 đứng trước tên server là phiên bản HTTP mà có hiệu lực khi server nhận được request Khi request truyền qua proxy b, proxy không thêm một `Via` header mới mà thêm tên và phiên bản của proxy b vào trong `Via` header đó.

Điều quan trọng là các proxy server tạo hoặc điều chỉnh `Via` header trước khi chúng thực hiện bất cứ tiến trình nào của message. Ví dụ, một proxy có thể nhận một `TRACE` request với một `Max-Forward` là 0, chỉ ra rằng proxy không thể chuyển request đi xa hơn nữa. Ví dụ như proxy b trong hình 3.28. Tuy nhiên, trước khi proxy b phản hồi `TRACE` request, nó phải chèn vào `Via` header. Sau khi làm vậy, nó tạo ra một response ở step 3. Nó phản hồi `TRACE` request thay cho server gốc.

![Hình 3.28](http://i.imgur.com/57ZfO6D.png)

### 3.2.51 Warning 

`Warning` header bổ sung thông tin về một response, thường là để cảnh báo user về các vấn đề của cache. Một `Warning` header chứa các cảnh báo riêng lẻ ngăn cách nhau bởi dấu phẩy.

```sh
Warning: 110 proxy.com "Response is stale"
Fri, 31 Dec 1999 23:59:59 GMT
```

Trường đầu tiên là một dòng code cảnh báo, và trường tiếp theo là xác nhận rằng server đã tạo ra cảnh báo. Một chuỗi ký tự được trích dẫn là một ngôn ngữ tự nhiên giải thích cho cảnh báo, phù hợp với user. Trường cuối cùng ( tùy chọn ) mang theo thời gian của cảnh báo.

Bảng 3.10 liệt kê các warning code

>**Bảng 3.10: HTTP 1.1 Warning code**

|Code|Giải thích|Ý nghĩa|
|----|----------|-------|
|110|Response is stale|Proxy trả về một object đã hết hạn trong response của nó|
|111|Revalidation failed|Proxy không xác thực rằng object vẫn còn phù hợp( vì nó không thể liên kết với server )|
|112|Disconnection operation|Proxy có tình bị mất kết nối mạng|
|113|Heuristic expiration|Proxy đoán là object vẫn còn phù hợp nhưng object đã quá 24 giờ|
|199|Miscellaneous warning|Một cảnh báo bất kỳ tùy ý|
|214|Transformation failed|Proxy chỉnh sửa object theo một cách nào đó ( có thể là thay đôi định dạng để tiết kiệm không gian lưu trữ cache )|
|299|Miscellaneous persistent warning|Một cảnh báo bất kỳ có thể tiếp tục lặp lại|

Khi một proxy nhận một `Warning` header với một ngày khác với `Date` header trong response, proxy sẽ xóa cảnh báo đó từ header. Nếu `Warning` header không chứa cảnh báo thì proxy cũng xóa cảnh báo đó đi. Hành động này đảm bảo cảnh báo không bị lan truyền một cách không phù hợp qua mạng của các cache server. Nếu không có nó, một object có thể mắc kẹt với một cảnh báo không phù hợp.

### 3.2.52 WWW-Authenticate

`WWW-Authenticate` header cho phép server gốc xác thực một client. Bằng việc chứa header này trong một response ( thường đi kèm với `401 Unauthorized ` status code ), server buộc client phải tái tạo lại request kèm theo một giấy phép quyền hạn. `WWW-Authenticate` sẽ được miêu tả chi tiết trong mục 4.1 .
<a name="3.3"></a>
## 3.3 Status code

Như chúng ta đã thấy trong nhiều ví dụ, một phần quan trọng của HTTP response là status code. Code này chỉ ra rằng một request của client đã thành công và cung cấp thông tin bổ sung về kết quả của request. Mỗi giá trị của status code là một số nguyên ba chữ số, và HTTP chia các status code dựa trên kí tự đầu tiên của các giá trị đó. Status code cung cấp thông tin (100-199), chỉ sử thành công(200-299), chuyển hướng một client(300-399), chỉ ra một lỗi của client(400-499) hoặc chỉ ra một lỗi của server(500-599). Trong mỗi phần như vậy, x00 status code là status chính của phần đó. Nếu client nhận được một giá trị của status code mà nó không hiểu, nó có thể xử lý một như là x00 status code. Ví dụ, một giá trị của status code là 237 (237 thì nó không hiểu là gì) sẽ được xử lý là 200. 

Bảng 3,11 cung cấp một danh sách đầy đủ của tất các status code của HTTP, chúng ta sẽ hiểu chi tiết các status code qua các mục nhỏ.

>**Bảng 3.11:  HTTP Status code**

|Nhóm|Code|Miêu tả|
|----|----|-------|
|**1xx**||**Information**|
||100|Continue|
||101|Switching Protocols|
|**2xx**||**Successful**|
||200|OK|
||201|Created|
||202|Accepted|
||203|Non-Authoritative Information|
||204|No Content|
||205|Reset Content|
||206|Partical|Content|
|**3xx**||**Redirection**|
||300|Multiple Choices|
||301|Moved Permanently|
||302|Found|
||303|See Other|
||304|Not Modified|
||305|Use Proxy|
||306|không được sử dụng|
||307|Temporary Redirect|
|**4xx**||**Client Error**|
||400|Bad Request|
||401|Unauthorized|
||402|Payment Required|
||403|Forbidden|
||404|Not Found|
||405|Method Not Allowed|
||406|Not Acceptable|
||407|Proxy Authentication Required|
||408|Request Timeout|
||409|Conflict|
||410|Gone|
||411|Length Required|
||412|Precondition Failed|
||413|Request Entity Too Large|
||414|Request-URI Too Long|
||415|Unsupported Media Type|
||416|Requested Range Not Satisfiable|
||417|Exppectation  Failed|
||418|Upgead Required|
|**5xx**||**Server Error**|
||500|Internal Server Error|
||501|Not Implemented|
||502|Bad Gateway|
||503|Service Unavailable|
||504|Gateway Timeout|
||505|Version Not Found|

### 3.3.1 Information(1xx)

Status code trong khoảng từ 100-199. Nó chỉ cho server cách để cung cấp các response tới client, mặc dù server chưa hoàn thành xong response.

`100 Continue`

`100 Continue` status code là một phần của tiến trình mà client kiểm tra server hoàn thành xong response chưa. Cái này rất quan trọng, ví dụ, nếu client có một message body lớn và nó muốn chắc chắn rằng server chấp nhận nó trước khi nó gặp vấn đề trong việc gửi nó. Có trường hợp là nó không phù hợp để gửi message body mà không biết server có thể nhận nó hay không.

Gỉa sử một client có một file lớn mà nó muốn `PUT` lên server. Client có thể sử dụng cơ chế tiếp tục này để tránh tiêu hao tài nguyên mạng. Để làm vậy, client bắt đầu request của nó với một http message body. Để kích hoạt sự tiếp tục, nó chứa `Expect: 100-continue` header trong message. Tuy nhiên, quan trọng là client không (chưa) gửi message body. Đó là step 1 trong hình 3.29.

![Hình 3.29](http://i.imgur.com/oDXxp3e.png)

**Hình 3.29: Client yêu cầu server chấp nhận request trước khi gửi toàn bộ message body. Expect header yêu cầu server ra hiệu cho sự chấp nhận đó bằng việc trả về một 100 status code. Khi client nhận được một 100 status code, nó tiếp gửi việc gửi phần còn lại của request.**

Nếu sau khi thấy các header của request, server chấp nhận request, server phản hồi với một `100 Continue` status code giống như step 2 trong hình. Response tạm thời này báo cho client biết để xử lý request của client và gửi phần còn lại của request trong step 3. Server hoàn tất việc trao đổi bằng việc trả về `200 OK` status code trong step 4.

Trong step 2, nếu server nhận ra rằng nó không thể chấp nhận request, nó phản hồi với một status code khác. Một server có thể yêu cầu sự thẩm đinh quyền ( đòi hỏi một `401 Unauthoried` response ) hoặc sau khi thấy giá trị của `Content-Length`, server có thể nhận ra rằng nó không có đủ không gian trong bộ nhớ để lưu trữ object (`413 Request Entity Too Large`).

Để đối phó với việc server không hỗ trợ hoàn toàn cơ chế tiếp tục này, các client gửi một `Expect: 100 continue` header để không phải đợi `100 Continue` response. Nếu server không phản hồi tại một thời điểm phù hợp, client tiến hành request của nó bằng mọi cách.

`101 Switching Protocols`

Server sử dụng `101 Switching Protocols` response để chấp nhận request của client để nâng cấp giao thức. Ví dụ trong hình 3.30, client request một nâng cấp cho TLS bằng việc chứa `Upgrade: TLS/1.0` header trong request của nó. Server chấp nhận nâng cấp trong step 2 với một `101 Switching Protocols` status code tạm thời, và trong step 3, việc trao đổi tiếp tục sử dụng giao thức mới. 

![Hình 3.30](http://i.imgur.com/UDicxCH.png)

**Hình 3.30: 101 status chỉ ra rằng người gửi có dự tính thay đổi giao thức. Client sử dụng giao thức mới khi nó nhận được 101 response.**

### 3.3.2 Successful (2xx)

Status code bắt đầu với số 2 chỉ sự thành công. Với các response này, server báo cho client biết là request của nó đã được nhận, hiểu và chấp nhận.

`200 OK`

Nó báo rằng request của client đã thành công. Dựa trên phương thức request, response chứa các thông tin bổ sung. Ví dụ, trong việc phản hồi thành công cho `GET` request, server chứa tài nguyên được request trong message body. Tuy nhiên, với `HEAD` request, server chỉ trả về response header, chứa các entity header mà áp dụng cho tài nguyên được request; message body bị bỏ qua.

`201 Created`

Server trả lời với một `201 Created` status code khi một request thành công cho việc tạo mới một tài nguyên. `Location` header trong response cung cấp một uri cho tài nguyên mới, nhưng server có thể chứa bản trình bày của một tài nguyên hoặc địa chỉ của nó trong message body.

`202 Accepted`

Với một `202 Accepted` status code, một server báo cho client biết rằng nó đã chấp nhận request, nhưng chưa hoàn thành nó. Một server gửi response này có thế chứa trong message body sự chỉ dẫn cho client biết được status cuối cùng của request. Ví dụ, nếu uri mà client có thể sử dụng để kiếm trả request status, server có thể chứa uri đó trong response.

`203 Non-Authoritative Information`

`203 Non-Authoritative Information` status code chỉ ra rằng các header của response có thể không phải là cuối cùng. Thay vào đó, chúng được tạo bởi các server trung gian. Tuy nhiên, message body vẫn phù hợp.

`204 No Content`

`204 No Content` status code chỉ ra rằng server đã chấp nhận request nhưng nó không cần phải trả về thông tin cho client trong response.

`205 Reset Content`

`205 Reset Content` status giống `204 No Content`. Trong cả hai trường hợp, response không chứa message body. Tuy nhiên, với một `205 Reset Content`, server chỉ client để reset lượt truy cập tài liệu mới mà tạo ra request. 

`206 Partial Content`

Server phản hồi tới một request cho một tập con của một tài nguyên ( một request với `Range` header ) sử dụng `206 Partial Content` status khi chúng chấp nhận request và chỉ trả về tập con được yêu cầu. Response cũng chứa `Content-Range` header để xác định phần nào của tài nguyên được hiện thị trong message của response.

### 3.3.3 Redirection (3xx)

Status code bắt đầu từ 300-399 báo cho client biết rằng nó cần có thêm hành động để hoàn thành request của nó. Server bắt client phải tái tạo lại request của nó, nhưng cho một uri khác. Nếu chỉ có một địa chỉ thay thế phù hợp, hoặc nếu server có một sự ưu tiên cho một địa chỉ đặc biệt trong các địa chỉ, server chứa uri cho `Location` header. Các location thay thế khác sẽ được liệt kê trong message body.

`300 Multiple Choices`

`300 Multiple Choices` status đưa ra cho client nhiều địa chỉ thay thế cho request. Server cung cấp các location thay thế đó trong message body của response, và nó chứa một `Location` header.

`301 Moved Permanently` 

Khi một uri của tài nguyên thay đổi vĩnh viễn, server phản hồi với một `301 Moved Permanently` status. Tất cả các 3xx status khác hiện ra các điều kiện tạm thời.

`302 Found`

`302 Found` status chỉ ra rằng tài nguyên được di chuyển tạm thới tới một location mới, và client tái tạo request của nó tới uri mới. Thực tế, nhiều client nhận một `302 Found` status sẽ gửi một GET request tới uri mới, cho dù request ban đầu sử dụng phương thức khác. Hành động này thực sự vi phạm đặc điểm HTTP. Với phiên bản 1.1, HTTP đưa ra `303 See Other` và `307 Temporary Redirect` status code để giải quyết vấn đề này.

`303 See Other`

`303 See Other` status giống như `302 Found` nhưng nó sử dụng phương thức POST. Sau khi client tạo POST request, response này báo cho nó biết nơi để lấy được tài nguyên. Bởi vậy, locaton được chỉ ra bởi `303 See Other` status không phải là location mới cho tài nguyên gốc. Nó chỉ tới một tài nguyên hoàn toàn mới.

`304 Not Modified` 

Nếu một request chứa một điều kiện ( ví dụ như `If-Match` hoặc `If-Modified-Since` header) và điều kiện đó không được đáp ứng, server phản hồi với một `304 Not Modified` status. Việc này bắt một client ( hoặc proxy server mà chuyển request ) sử dụng một bản sao cache của tài nguyên.

`305 Use Proxy`

`305 Use Proxy` status buộc client phải tái tạo lại request cho một proxy server. Chỉ server gốc tạo ra status này, và status chỉ áp dụng cho request ban đầu.

`307 Temporary Redirect` 

`307 Temporary Redirect` status giống `302 Found` status: Tài nguyên tạm thời được chuyển đến một location mới, và client tái tạo request. Client sử dụng cùng một phương thức request. Như chú ý ở trước, HTTP 1.1 thêm status code này bởi vì có nhiều client phản ứng không đúng với `302 Found` status.

### 3.3.3 Client Error (4xx)

Nếu server gặp phải một vấn đề với request của client, nó có thể sử dụng một trong các 4xx status code trong response của nó. Status code cung cấp nhiều thông tin về vấn đề mà server tìm ra ở client.

`400 Bad Request`

Chuẩn status code cho client error là `400 Bad Request`. Response này chỉ ra rằng server không hiểu request, bởi vì lỗi trong định dạng của nó. Client không tái tạo một request như cũ vì nó có thể bị từ chối một lần nữa.

`401 Unauthorized`

`401 Unauthorized` status code báo cho client biết rằng server yêu cầu xác minh của user trước khi cho phép truy cập vào tài nguyên. Server chứa một `WWW-Authenticate` header trong response của nó để hướng dẫn client kiểu xác minh mà nó yêu cầu. Như mục 4.1 giải thích, client tương tác với status này bằng việc tái tạo request với một `Authorization` header phù hợp.

`402 Payment Required`

Mặc dù HTTP xác định status code này, nó dành riêng cho việc sử dụng sau này. Tuy nhiên, nó không được rõ rằng, làm sao một clent tương tác để nhận nó.

`403 Forbidden` 

Một client mà nhận được một `403 Forbidden` status code có ý định truy cập tài nguyên nhưng không được mà bị cấm cản. Không giống như trường hợp của `401 Unauthorized` status code, không có `Authorization` header cho phép client truy cập. Server chú ý rằng việc trả về `403 Forbidden` response ngụ ý rằng tài nguyên được yêu cầu thực sự vẫn tồn tại. Nếu việc tiết lộ thông tin này không phù hợp, server có thể sử dụng `404 Not Found` status code thay vào đó.

`404 Not Found`

`404 Not Found` chỉ ra rằng tài nguyên được yêu cầu không tồn tại. Nó không đưa ra thông tin về điều kiện tạm thời hay cố định. Nếu một server muốn chỉ ra một điều kiện tạm thời, nó có thể sử dụng `410 Gone` status code thay vào đó.

`405 Method Not Allowed`

`405 Method Not Allowed` status báo cho client biết rằng cái phương thức mà nó sử dụng không được cho phép với tài nguyên được tham chiếu. Server chứa một `Allow` header trong response của nó để báo cho client biết phương thức nào có thể sử dụng được.

`406 Not Acceptable`

Khi một server trả về `406 Not Acceptable` status, giá trị của các header Accept không được chấp nhận . Message body của response chỉ ra các kí tự thực thể mà request có thể tạo ra. Status code này chỉ xuất hiện trong response tới request với `Accept, Accept-Charset, Accept-Encoding hoặc Accept-Language` header.

`407 Proxy Authentication Required`

`407 Proxy Authentication Required` báo cho một client biết rằng nó phải xác thực nó với một proxy server trước khi request của nó có thể được xử lý. Proxy server tạo ra response này chứa một `Proxy-Authenticate` header để hướng dẫn client bằng việc cung cấp một `Proxy-Authentication` header phù hợp trong request được tái tạo của nó.

`408 Request Timeout`

Với `408 Request Timeout` status, một server chỉ ra rằng nó hết giờ để chờ một request từ client.

`409 Conflict` (xung đột)

`409 Conflict` status chỉ ra rằng server không hoàn thành request bởi vì một sự xung đột với trạng thái hiện tại của tài nguyên. Ví dụ, sự xung đột này nảy sinh khi một `PUT` request chứa các thay đổi cho một tài nguyên mà xung đột với các thay đổi đã được chấp nhận bởi một bên thứ ba.

`410 Gone` 

`410 Gone` status chỉ ra rằng một tài nguyên không còn có sẵn nữa. Điều kiện này đã thay đổi vĩnh viễn.

`411 Length Required`

Khi một server trả về một `411 Length Required` status, nó từ chối chấp nhận request nếu client không tái tạo một request với `Content-Length` header phù hợp.

`412 Precondition Failed`

`412 Precondition Failed`  status chỉ ra rằng một trong các điều kiện mà client chứa trong request ( ví dụ là `If-Match` header ) của nó không được áp dụng.

`413 Request Entity Too Large`

`413 Request Entity Too Large` status chỉ ra rằng message body một request lớn hơn mức mà server có thể chấp nhận. Nếu server cho rằng điều kiện này là tạm thời thì nó sẽ chứa một `Retry-After` header trong response của nó.

`414 Request-URI Too Long`

Nếu một client chứa một `uri` trong request của nó mà dài hơn mức mà server có thể thông dịch, server phản hồi với một `414 Reuqest-URI Too Large` status.

`415 Unsupported Media Type`

Bằng việc trả về một `415 Unsupported Media Type` status, một server chỉ ra rằng nó không hiểu được dạng truyền tin trong message body của request.

`416 Requested Range Not Satisfiable`

Khi một client yêu cầu một giới hạn của một tài nguyên ( với `Range` header ) và giới hạn đó không phù hợp, server phản hồi với một `416 Requested Range Not Satisfiable` status.

`417 Expectation Failed`

Nếu một server không thể đáp ứng được sự mong đợi của client được truyền tải trong một `Expect` header của request, nó trả về một `417 Expectation Failed` status.

`426 Upgrade Required`

`426 Upgrade Required` status - server báo cho một client nó phải nâng cấp ứng dụng mà nó đang sử dụng cho request. Ví dụ, một server buộc client phải nâng cấp lên `TLS`, nó trả về status này cùng với một `Upgrade` header có giá trị là `tls` là ứng dụng mà nó muốn nâng cấp.

### 3.3.5 Server Error (5xx)

Trái ngược với 4xx status code -  cái mà liên quan đến Client Error, 5xx status code chỉ ra một vấn đề của Server.

`500 Internal Server Error`

`500 Internal Server Error` status là một chỉ thị chung của một vấn đề server. Lỗi này xuất hiện có thể là do một số sự cố nào đó xuất hiện trên server trang web bạn truy cập. Chẳng hạn như có quá nhiều người truy cập cùng một lúc, file .htaccess bị lỗi,... hoặc server không thể xác định vấn đề chính xác là gì.

`501 Not Implemented`

`501 Not Implemented` status chỉ ra rằng server không hỗ trợ phương thức của reqest cho các tài nguyên, không chỉ là tài nguyên được yêu cầu.

`502 Bad Gateway`

Nếu một proxy server nhận được một response không phù hợp từ server mà nó truyền request tới, nó phản hồi tới client với một `502 Bad Gateway` status.

`503 Service Unavailable`

`503 Service Unavailable` status chỉ ra rằng server tạm thời không thể đáp ứng được request, bởi bì server hiện tại đang quá tải hoặc đang được bảo trì. Server chứa một `Retry-After` header trong response của nó nếu nó đoán được vấn đề sẽ được giải thuyết sớm.

`504 Gateway Timeout`

Khi một proxy server hết thời gian đợi một response từ server khác, nó trả về một `504 Gateway Timeout` status tới client.

`505 Version Not Supported`

`505 Version Not Supported` status chỉ ra rằng server không hỗ trợ phiên bản HTTP được chỉ ra trong request của client.
<a name="4"></a>
# Chapter 04 Bảo mật HTTP - Bổ sung sự xác minh và sự riêng tư

Chương này chú trọng vào các cách để thêm bảo mật vào HTTP. Mục đầu tiên,Web Authentication, miêu tả chi tiết các thủ tục được xây dựng trong HTTP 1.1 . Mục thứ hai giới thiệu giao thức `ssl` (Secure Sockets Layer). Cách phổ biến nhất để cung cấp bảo mật trên Web, `ssl` là một giao thức tách rời mà bổ sung sử bảo mật vào nhiều ứng dụng. Tuy nhiên, nó được thiết kế đặc biệt cho HTTP. Giao thức `tls` (Transfer Layer Security) là một bản sửa đổi mới nhất của `ssl`. Nó rất giống `ssl`, nhưng nó chứa một ít đặc điểm cho các giao tiếp `http`. Cuối cùng, chương này có một cái nhìn sơ qua về Secure-http (shttp). Được phát triền cùng lúc với `ssl`, `shttp` xác định các sự mở rộng về bảo mật của http. `shttp` phần lớn đã được thay thế bởi `ssl`, nhưng một ít các đặc điểm vẫn còn tồn tại.
<a name="4.1"></a>
## 4.1 Web Authentication

User password là nổi tiếng là không an toàn, bởi vì user thường sử dụng các mấy khẩu dễ các kẻ khác đoạn được. User cũng ít quan tầm đến mật khẩu, sử dụng cùng một mật khẩu cho nhiều hệ thống, để password trên một sticky note gắn vào màn hình của họ, hoặc tiết lộ các password đó cho một đối tượng giả vờ là admin hoặc các nhân viên của hệ thống.

### 4.1.1 Basic Authentication (Sự xác minh cơ bản)

Hình thức bảo mật đơn giản nhất của http là Basic Authentication. Nó cho phép một Server request một username và password từ một client, và nó nhận ra client gửi thông tin đó tới server như thế nào. Hình 4.1 cho thấy tiến trình đó. Đầu tiên client gửi http request của nó như bình thường. Tuy nhiên, server phản hồi với một `401 Unauthorized` status code. Status code này báo cho client biết rằng nó phải cung cấp một username và password.

![Hình 4.1](http://i.imgur.com/P6pVfj3.png)

**Hình 4.1: Khi một server muốn một client xác minh user của nó, server trả về 401 status. Client sau đó tái tạo một request với thông tin phù hợp được chứa trong Authorization header.**

`401 Authorized` response chứa một `WWW-Authenticate` header và dạng của authenticate là basic.s

```sh
HTTP/1.1 401 Unauthorized
WWW-Authenticate: Basic
    realm="users@hundredacrewoods.com"

```

Server có thể chọn giá trị cho realm mà nó muốn, nhưng trong việc duyệt Web nó thường sử dụng giá trị mà user có thể hiểu được. Bởi vì Web browser hiển thị realm cho user khi yêu cầu username và password. Hình 4.2 cho thấy một browser truy vấn một user như thế nào. 

![Hình 4.2](http://i.imgur.com/jvofXES.png)

**Hình 4.2: Web browser yêu cầu sự xác minh cho user của nó với một của sổ pop-up. HTTP authorzation không phải là bộ phận của một Web page, không giống như bảo mật SSL ủy quyền server của hình 4.3. (Câu này không hiểu lắm)**

Một lần nữa, user cung cấp username và password, client tiếp tục giao tiếp trong step 3 của hình 4.1 . Trong step đó, nó tái tạo một request gốc. Tuy nhiên, lần này client chứa `Authorization` header trong request của nó. `Authorization` header chứa username và password mà user cung cấp.

Để cung cấp username và password, client gộp cả hai cái lại và ngăn cách nhau bởi dấu hai chấp (:), và mã hóa chúng theo dạng Base64. Bằng việc sử dụng dấu hai chấp để ngăn cách username với password, http ngăn không có username chứa password trong đó. (Hơn nữa là server muốn biết được user kết thúc và password bắt đầu chỗ nào.)

Mã hóa dạng Base64 là một cách để chuyển thành dữ liệu nhị phân và được sử dụng bình thường, các kí tự được hiện thị ra. Nó thể đính kèm email. Bằng việc mã hóa username và password dạng Base64, http cho phép password chứa các kí tự tùy ý. HTTP đánh mật một trong những hạn chế trong chuẩn mã hóa Base64. Mã hóa Base64 yêu cầu mooitj dong mới ít nhất 76 kí tự. Trong trường hợp này, nhãn quyền mã hóa phải nằm trên một dòng đơn của tesxt, không quan tậm đến độ dài. Sau đây là ví dụ:

```sh
GET /secret/honeypot.html HTTP/1.1
Authorization: Basic QwxhZGRpbjpvcGVuIHNlc2FtZQ==

```

Khi server thấy một username và password phù hợp, nó trả về object được yêu cầu. Hình 4.1 cho thấy điều đó trong step 4. 

Sau khi một client nhận lại được một object đang sử dụng Basic Authenticate, clien, client tiếp tục chứa `Authorization` header trong request tiếp theo cho cùng một `uri`. 

Một trong những vấn đề nổi trổ với Basic Authentication là username và password truyền qua mạng và bị lộ ra. Các phần tử xấu có thể giải mã lại username và password. Thậm chí thông tin đang được bảo mật không quan trong, quản trị server xem xét một ngữ cảnh bao quát hơn khi đưa ra quyết định sử dụng Basic Authentication. Ví dụ, nhiều user tái sử dụng cùng một username và password cho nhiều hệ thống khác nhau. Kẻ gian giải mã được một username và password từ một Web không bảo mật.

Để tránh sự thiếu sót của Basic Authentication, nhiều Web tạo một phần đăng nhập riêng của nó. Hình 4.3 cho thấy một ví dụ về Website. Ở đây user được yêu cầu username và password thông qua một Web form thay vì việc xác thực HTTP (authentication). Mặc dù HTTP được sử dụng để truyền tải form tới user thông qua phương thức `POST`, trả về response của user, http không thể tự biết được một quá trình xác thực đang hoạt động. Chú ý rằng cái icon móc khóa góc trong cùng bên trái. Nó chỉ ra rằng dữ liệu mà user gửi tới Web sẽ được mã hóa sử dụng các phương tiên của SSL hoặc TLS, cả hai cái này chúng ta sẽ gặp ở cuối chương. Với sử bảo vệ này username và password này không bị đánh cắp.

![Hình 4.3](http://i.imgur.com/FLMqqsb.png)

**Hình 4.3: Nhiều Web quản lý username và password thay vì dựa vào HTTP authentication. User nhập thông tin xác thực vào trang thông qua một chuẩn Webpage hơn mà một pop-up.**

### 4.1.2 Original Digest Authentication (Xác minh xử lý ban đầu)

Digest Authentication nắm được nhược điểm chính của Basic Authentication, mà cụ thể là các username và password dễ bị đánh cắp. Chúng ta sẽ tìm hiểu về Original Digest Authentication và Improved Digest Authentication

Digest Authentication sử dụng nguyên lý mã hóa đơn giản để tránh việc truyền password qua mạng. Client có thể chứng minh mình là "user thật".

Để chứng minh cho điều đó, client tạo ra một `message digest` sử dụng password và một giá trị được cung cấp bởi server. Sau đó chúng chuyển digest tới server Server xác thực password bằng việc nhân bản lại việc tính toán này. Nó có một giá trị được biết, gộp nó với password mà client sử dụng, và tính toán một message digest. Nếu sự tính toán của server khớp với cái của client, sercer tin tưởng rằng client biết chính xác password. Hình 4.4 minh họa quy trình đó.

![Hình 4.4](http://i.imgur.com/MC5nV4a.png)

**Hình 4.4: Cả client và server tính toán giá trị message digest(MD). Nếu cả hai kết quả khớp nhau thì cả hai có cùng khớp password.**

Với message digest, data của server được gộp với password rất quan trong đới với việc bảo mật chung. Quan trọng nhất là server phải chọn một giá trị dữ liệu khác nhau. Có khi kẻ gian có tại tái sử dụng một giá trị digest và mạo danh là client. (Nếu data và password không thay đổi, sau đó giá trị digest vẫn vậy.)

Server bắt đầu quy trình Digest Authentication với một `401 Unauthorized` response, cũng giống như với Basic Authentication. Tuy nhiên, giá trị của `WWW-Authenticate` header là Digest. Sau đây là ví dụ đơn giản.

```sh
HTTP/1.1 401 Unauthorized
WWW-Authenticate: Digest
    realm="users@hundredacrewoods.com",
    nonce="dcd98bc09f81043d3a8cb935ae393db90674"

```

Như ví dụ trên cho thấy, Digest Authentication yêu cầu nhiều tham số hơn là Basic Authentication. Digest Authentication cũng yêu cầu tham số `nonce`. (nonce giúp bảo vệ web khỏi các request với mục đích xấu). Gía trị của tham số này là **data mà client gộp với password của nó khi tạo digest**. Server thoải mái sử dụng giá trị này khi nó thấy hợp. Với `GET` request, nonce được bao gồm một timestamp và một message của digest chứa ba thứ sau: timestamp, `ETag` đang được request và một giá trị bí mật chỉ server mới có thể biết. Timestamp cho phép server gán cho nonce một sự tồn tại giới hạn; giá trị `ETag` ngăn kẻ gian khỏi việc xem lại một request của client để có thể truy cập tới một giá trị được cập nhật của object được request. Và giá trị đặc biệt đảm bảo rằng kẻ gian không thể đoán được giá trị của nonce trước. Phương pháp này cho phép client tái tạo các request mà không cần khởi tạo một `401 Unauthorized` response mới và kết quả tính toán lại các giá trị của digest. Bởi vì server có thể thấy được timestamp trong nonce, nó báo rằng nonce đã có được bao lâu và chấp nhận các request được lặp lại với một của sổ thời gian phù hợp. Với `POST` và `PUT` reuqest, http để nghị sử dụng nonce chỉ một lần để ngăn cản việc tái tạo request.

Các tham số `realm` và `nonce` là những thứ duy nhất Digest Authentication yêu cầu, nhưng http cho phép thêm một số ít các tham số trong response của server. Bảng 4.1 liệt kể tất cả các tham số được định nghĩa, cùng với nó là một lời giản thích ngắn gọn về cácH sử dụng. Chú ý rằng nhiều tham số chỉ áp dụng cho Improved Digest Authentication. Các sử dụng này được mô tả đầy đủ trong mục nhỏ dưới đây.

>**Bảng 4.1: Các tham số WWW-Authenticate**

|Tham số|Improved|Bắt buộc|Sử dụng|
|-------|--------|--------|-------|
|algorithm(thuật toán)|MD5-sess|Không|Chỉ ra thuật toán digest để sử dụng; MD5 (mặc định) hoặc MD5-sess; nếu nếu tham số qop thiếu thì tham số này có để trống hoặc là MD5.|
|domain|Không|Không|Một danh sách các URI (được ngăn cách nhau vởi khoảng cách) mà nhận dạng tài nguyên mà authentication này áp dụng.|
|nonce|Không|Có|Data được gộp với password trong khi tạo ra digest.|
|opaque|Không|Không|Một giá trị nhị phân được cung cấp bởi server mà client trả về, không được chỉ sửa với request của nó; có thể được sử dụng bởi server để gán trong quá trình xử lý request.|
|qop|Có|Không||
|realm|Không|Có|Một chuỗi ký tự được hiển thị để user nhận dạng username và password được cung cấp.|
|stale(hỏng)|Không|Không|Nếu giá trị là true, thì username và password được cung cấp vẫn còn phù hợp nhưng authentication request dựa trên một nonce mà server không còn xem là phù hợp; buộc client tính toán lại digest, sử dụng một nonce mới mà không cần truy vấn user với username và password.|

Khi client nhận được một Digest Authentication response, có tính toán messgae digest để thêm message tiếp theo của nó. Bảng 4.2 cho thấy quy trình của Original Digest Authentication, được sử dụng khi server bỏ qua một tham số `qop` từ response của nó. Trong ví dụ này, client đang giao tiếp với một server dựa trên một phiên bản củ hơn của http. Nếu tham số `qop` được hiện ra, bất kể giá trị nào của nó, các quy tắc của Improved Digest Authentication áp dụng.

>**Bảng 4.2: Sự tính toán của client đối với Digest Authentication**

|Step|Action|
|----|------|
|1|Tạo ra một chuỗi các kí tự bao gôm username, realm, và password, mỗi loại ngăn cách nhau bởi dấu hay chấm ":", ví dụ,`pooh:users@hundredacrewoods.com:honey` - đây gọi là chuỗi "A1".|
|2|Tính toán MD5 digest cho chuỗi kí tự A1 và hiện thị ra kết qua nhị phân 128 bit từ hệ thập lục phân 32 ký tự ASCII từ 0-9 và từ a-f.|
|3|Tạo ra một chuỗi ký tự thứ hai chứa các phương thức (ví dụ như GET, POST, PUT...)  và URI, được ngăn cách nhau bởi dấu hai chấm ":". Ví dụ `GET:/secret/honeypot.html`. (Đây gọi là chuỗi "A2").|
|4|Tính toán MD5 digest cho chuỗi ký tự A2 và hiện thị ra kết quả là bộ 32 ký tự ASCII.|
|5|Tạo ra một chuỗi ký tự bằng việc gộp kết quả từ step 2, nonce được cung cấp bởi server và  kết quả từ step 4, tất cả được ngăn cách nhau bởi dấu hai chấm ":".|
|6|Tính toán MD5 digest cho chuỗi ký tự nhận được từ step 5 và hiển thị kết quả là các ký tự 32 ASCII. Gía trí này là digest.

```sh
GET /secret/honeypot.html HTTP/1.1
Authorization: Digest username="pooh",
    realm="users@hundredacrewoods.com",
    nonce="dcd98bc09f81043d3a8cb935ae393db90674",
    uri="/secret/honeypot.html",
    response="dcd98bc09f81043d3a8cb935ae393db90674"

```

Request được tái tạo lặp lại `realm` và `nonce` từ server, và nó chứa username, uri đang được request và kết quả digest-là giá trị của tham số `response`. Các tham số này chỉ là những cái được yêu cầu trong response của client, nhưng http định nghĩa vài tham số tùy chọn. Bảng 4.3 cung cấp danh sách đó. Với `WWW-Authenticate, chú ý rằng các tham số chỉ phù hợp cho Improved Digest Authentication.`

>**Bảng 4.3: Các tham số Authorization**

|Tham số|Cải tiến|Yêu cầu|Sử dụng|
|-------|--------|-------|-------|
|olgorithm|MD5-sess|Không|xác định thuật toán digest được sử dụng: MD5(mặc định) hoặc MD5-sess; nếu không chứa tham số `qop`, tham số này phải để trống hoặc là MD5.|
|cnonce|Có |Không|Client phải chứa tham số này nếu server dứt khoát chỉ ra một tham số `qop`.|
|nc|Có|Có|Số lần client tạo ra một request với cùng giá trị nonce; điều này được thể hiện trong hệ thập lục phân và bắt đầu tại "00000001", chú ý rằng client chứa tham số này nếu server chỉ ra một tham số `qop`.|
|nonce|Không|Có|Gía trị nonce từ response ban đầu của server|
|opaque|Không|Không|Gía trị opaque được gửi bởi server|
|qop|Có|Không|Chất lượng của sự bảo vệ được sử dụng bởi client; nó chỉ có thể được trả về nếu server xác định một hoặc nhiều giá trị qop trong response ban đầu của nó, giá trị của client được chọn từ những cái mà server liệt kê ra.|
|realm|Không|Có|Lĩnh vực được xác định bởi server|
|response|Không|Có|Kết quả của tính toán digest.|
|uri|Không|Có|URI cho project mà clint đang request; chú ý rằng HTTP chỉ ra rằng các giá trị cho tham số này không được đính kèm trong dấu ngoặc kép "". mặc dù các ví dụ sử dụng dấu "".|
|username|Không|Có|Username của client.|

Khi server xác thực digest trong request của client, quá trình Simple Digest Authentication được hoàn thành. Tuy nhiên, có thêm các step tùy chọn. Nếu server chọn, nó bổ sung một header vào response của nó. Header đó là `Authentication-Info`. `Authentication-Info` header chỉ có trong Improved Digest Authentication, nên chúng ta sẽ tìm hiểu về nó trong mục 4.1.3. Tuy nhiên, một tham số có thể được sử dụng với Original Digest Authentication. Tham số đó là `nextnonce`, và nó giúp server báo cho client một giá trị nonce mới được sử dụng cho request sau.

>**Bảng 4.4: Các tham số của Authentication-Info**

|Tham số|Improved|Yêu cầu|Sử dụng|
|-------|--------|-------|-------|
|cnonce|Có|Không|Gía trị cnonce trong request của client; tham số này được hiện ra nếu một giá trj qop được được ghi rõ.|
|nc|Có|Không|Gía trị nc trong request của client; tham số này được hiện ra nếu giá trị qop được ghi rõ.|
|nextnonce|Không|Có|Một giá trị nonce mà server muốn client sử dụng trong request tiếp theo của nó.|
|qop|Có|Không|Chất lượng của sự bảo bệ được sử dụng bởi client.|
|rspauth|Có|Không|Kết quả việc tính toán digest của server; tham số này được hiện ra nếu giá trị qop được ghi rõ ràng.|

Như bảng trên chỉ ra rằng, `Authentication-Info` header yêu cầu một tham số `nextnonce`. Thật không may, mặc dù server sử dụng `nextnonce` với http 1.0, không được khuyến khích dùng ở phiên bản 1.1. Vấn đề là `nextnonce` giao thoa với pipelining. Pipelining cho phép một client tạo và gửi một request trước khi nó nhận một response từ request trước. 

Lợi ích chính của `nextnonce` là nó cho phép một server thay đổi giá trị nonce thường xuyên. Thường xuyên thay đổi giá trị của nonce để cái tiến bảo mật và ngăn chặn tấn công. Tuy nhiên, quy trình Improved Digest Authentication có giải pháp tốt hơn cho các vấn đề kia, và chúng được sử dụng thay cho `nextnonce`. 

### 4.1.3 Improved Digest Authentication
Các đặc điểm nâng cấp của Improved Digest Authentication: bảo vệ cho việc replay attack, hỗ trợ cho mutual authentication, bảo mật tốt hơn cho client, và bảo vệ toàn vẹn giao tiếp giữa client với server. Server và client phải đồng ý sử dụng các dịch vụ tùy chọn này. Bảng 4.5 liệt kê các dịch vụ bổ sung cho Improved Digest Authentication. Chúng ta sẽ bàn luận về từng cái trong các mục nhỏ sau.

>**Bảng 4.5: Các nâng cấp của Digest Authentication**

|Service|Cơ chế|
|-------|------|
|Replay protection|Một phần của Improved Digest Authentication|
|Mutual Authentication|Một phần của Improved Digest Authentication|
|Repeat Client Security|Được sử dụng nếu thuật toán là MD5-sess|
|Integrity Protection|Được sử dụng nếu qopp là auth-int|

Tuy nhiên, một yếu tố thông dụng với mỗi dịch vụ cải tiến, là trigger cho client biết liệu nó có sẵn sàng hay không. Trigger đó xuất hiện trong response đầu tiên của client, `401 Unauthorized`. Để chỉ ra sự hỗ trợ của nó cho Improved Digest Authentication, server chứa một chất lượng của sự bảo vệ, hoặc tham số qop. Giá trị của tham số không quan trọng, chỉ cần nó xuất hiện trong response của server.

```sh
HTTP/1.1 401 Unauthorized
WWW-Authenticate: Digest
    realm="users@hundredacrewoods.com",
    qop="auth",
    nonce="dcd98bc09f81043d3a8cb935ae393db90674"

```

Mặc dù tham số `qop` chỉ là một trong những dịch vụ nâng cao(integrity protection), chuẩn Digest Authentication đưa vào tất cả các đặc điểm authentication nâng cao cùng lúc. Các client mà nhận được tham số qop từ server có thể thừa nhận rằng nó có hỗ trợ Improved Digest Authentication.Tham số qop là một dấu hiện cho rằng server có thể hỗ trợ các dịch vụ của Improved Authentication.

Ngoài việc chỉ ra sự hỗ trợ cho Improved Authentication, giá trị tham số qop có thể xác định các dịch vụ bảo mật đặc biệt. Improved Digest Authentication xác định hai trường hợp: `auth` và `auth-int`. Trường hợp đầu tiên, `auth` chỉ ra authentication, trong khi `auth-int` chỉ ra authentication với integrity protection. Chúng ta sẽ đề cập về Integrity Protection ở mục 4.1.7. Server có thể chứa cả `auth` và `auth-int` trong message của nó. Điều đó báo cho client biết rằng nó hỗ trợ của hai cái và client chọn một cái để sử dụng cho việc bảo vệ. Bởi vì `auth-int` bảo mật khỏe hơn `auth`. Và client thường đưa ra lựa chọn là `auth-int`.

### 4.1.4 Chống lại Replay Attack

Một trong những dịch vụ quan trong của Improved Digest Authentication là sự bảo vệ chống lại replay attack. Ví dụ hình 4.5. Trong hình này, step 1 là một chuẩn request authentication từ client. Nó chứa header `Authorization` với một digest phù hợp. Tuy nhiên bởi vì message đấy được gửi thông qua mạng public, nội dung của nó không bí mật và kẻ gian thấy được request . Trong step 2, kẻ gian gửi cùng một request tới server. Trong thực tế, nó đang lặp lại một request. Không cần biết password của user, kẻ gian không thể tính toán một giá tị digest phù hợp. Tuy nhiên trong trường hợp này, kẻ gian không cần tính toán digest. Client đã làm điều đó trong request. Tấn công hoàn thành trong step 3. Trong step đó, server xác thực digest trong request, và trả về object được request.

![Hình 4.5](http://i.imgur.com/3XniQSP.png)

Mặc dù nó có vẻ là server đang hoạt động đúng ở đây bằng việc phản hồi về request của kẻ gian. Nếu không có dịch vụ chống lại replay attack, server thông thể phát hiện ra request của kẻ gian từ đâu, ví dụ, một user kiên nhận ấn vào nút "Refresh" hoặc "Reload" trên trình duyệt.

### 4.1.5 Mutual Authentication (Xác thực lẫn nhau)

Quy trình Original Digest Authentication giúp server xác thực client, nhưng nó không giúp client xác thực server. Improved Digest Authentication chứa sự xác thực của server với client trong quy trình bảo mật. Nếu một server chỉ ra rằng nó có hỗ trợ Improved Authentication bằng việc chứa một tham số qop trong toàn bộ response của nó, client phải sử dụng quy trình xác thực lẫn nhau.

Sự xác thực của server rất giống với client. Client gửi server data của nó. Server gộp data đó với password của user, tính toán một digest, và trả về digest đó cùng với object được yêu cầu. Sau đó client có thể xác thực digest trước khi chấp nhận object đó. Hình 4.6 minh họa cho điều này. Step chính là step 4. Ở đây server chứa tham số `Authentication-Info` chứng minh nó biết được password của user.

![Hình 4.6](http://i.imgur.com/ReJPRNJ.png)

**Hình 4.6: Với Improved Digest Authentication, một server có thể chứng minh rằng nó biết được password của client. Header Authentication-Info chứng minh điều đó. Dịch vụ này cung cấp sự bảo mật tốt hơn là việc trao đổi dữ liệu kiểu Basic Authentication - cái mà chỉ có client mới có thể chứng minh là nó biết được password.**

Server bắt đầu quy trình Mutual Authentication bằng việc chứa một tham số qop trong `401 Unauthorized` response của nó. Nếu client hỗ trợ Improved Digest Authentication,theo quy tắc nó phải bắt đầu xác thực của server.

```sh
HTTP/1.1 401 Unauthorized
WWW-Authenticate: Digest
    realm="users@hundredacrewoods.com",
    qop="auth",
    nonce="dcd98bc09f81043d3a8cb935ae393db90674"

```

Để bắt đầu sự xác thực của server, client thêm một thống số mà header `Authentication` trong request được tái tạo của nó. Tham số này là `cnonce`, viết tắt của từ "client nonce". Tham số `cnonce` có cùng định dạng với tham số `nonce` của server.

```sh
GET /secret/honeypot.html HTTP/1.1
Authorization: Digest username="pooh",
    realm="users@hundredacrewoods.com",
    qop=auth,
    nonce="dcd98bc09f81043d3a8cb935ae393db90674",
    nc=00000001,
    cnonce="32cfe192fd109232aa1b8fe09d18d5efe53",
    uri="/secret/honeypot.html",
    response="dcd98bc09f81043d3a8cb935ae393db90674"

```

Client cũng sử dụng Improved Digest Authentication để tính toán digest không khác mấy so với Original Digest Authentication. Không giống như các dịch vụ trước, client chứa giá trị của các tham số `nc, cnonce và qop` trong sự tính toán. Bảng 4.6 chỉ ra từng bước một. Chú ý rằng bảng 4.6 liệt kê các bước khi các phần không sử dụng sử bảo vệ cho repeat client và khi chúng không bắt đầu integrity protection.

>Bảng 4.6: **Sự tính toán được cái tiến của client**

|Step|Hoạt động|
|----|---------|
|1|Tạo ra một chuỗi các ký tự chứa username, realm, và password, mỗi cái được ngăn cách nhau bởi dấu hai chấm.(Chuỗi này gọi là chuỗi "A1").|
|2|Tính toán MD5 digest cho chuỗi ký tự đó và hiển thị kết quả dưới dạng mã thập lục phân với bộ ký tự 32 ASCII.|
|3|Tạo ra một chuỗi ký tự thứ hai chứa các phương thức và URI, và cũng được ngăn cách nhau bởi dấu hai chấm. Ví dụ: `GET:/secret/honeypot.html`.(Chuối này gọi là chuỗi "A2").|
|4|Tính toán MD5 digest cho chuỗi ký tự này và hiển thị kết quả dưới dạng các ký tự 32 ASCII.|
|5|Tạo ra một chuỗi ký tự bẳng cách gộp kết quả từ step 2, `nonce` được áp dung bởi server, giá trị `nc`, giá trị `cnonce` , giá trị `qop`, và kết quả trong step 4 và được ngăn cách nhau bằng dấu hai chấm.|
|6|Tính toán MD5 digest cho chuỗi ký tự này và hiện thị kết quả dưới dạng các ký tự 32 ASCII. Đây là giá trị cho digest.|

Server phải xác nhận rằng nó biết được password của user khi nó trả về response của nó. Để làm vậy, server sử dụng header `Authentication-Info`. Header lặp lại giá trị của các tham số `qop`, `cnonce`, và `nc` trong request của client và nó chứa tham số `rsauth` - đây là giá trị digest của server.

Server tính toán giá trị digest của nó sử dụng quy trình giống client, trừ một vài điều là: Server không chứa phương thức trong chuỗi A2. Bảng 4.7 nói chi tiết hơn.

>**Bảng 4.7: Sự tính toán được cái tiến của server**

|Step|Hoạt động|
|----|---------|
|1|Tạo ra một chuỗi ký tự chứa username, realm, và password, mối cái được ngắn cách bởi dấu hai chấm, ví dụ `pooh:users@hundredacrewoods.com:honey`, (Đây gọi là chuỗi "A1").|
|2|Tính toán MD5 digest cho chuỗi ký tự này và hiện thị kết quả dưới dạng mã thập lục phân với các ký tự 32 ASCII.|
|3|Tạo ra một chuỗi ký tự thứ hai chứa một dấu hai chấm theo sau là URI trong request của client. Ví dụ: `:/secret/honeypot.html`. (Đây gọi là chuỗi "A2").|\
|4|Tính toán MD5 digest cho chuỗi ký tự này và hiện thị kết quả dưới dạng các ký tự 32 ASCII.|
|5|Tạo ra một chuỗi ký tự bằng việc gộp kết quả từ step 2, giá trị `nonce`, giá trị `nc`, giá trị `cnonce`, giá trị `qop` và kết quả của step 4, tất cả được ngăn cách nhau bởi dấu hai chấm.|
|6|Tính toán MD5 digest cho chuỗi ký tự này và hiện thị kết quả dưới dạng các ký tự 32 ASCII. Đây là giá trị cho digest.|

### 4.1.6  Prottection For Frequent Client (bảo vệ cho client thường xuyên)

Trong khi Replay protection và Mutual authentication là các đặc điểm chính của Improved Digest Authentication, các dịch vụ nâng cao khác chỉ là tùy chọn. Các dịch vụ tùy chọn rất có giá trị và được sử dụng mỗi khi chúng sẵn sàng. Ví dụ điển hình là *Prottection For Frequent Client*. Chúng ta sử dụng thuật ngữ "frequent client" cho một HTTP client mà tạo ra nhiều request tới server. Vấn đề của Server là khi chúng càng tương tác với server, các password càng dễ bị tấn công.

Nguồn gốc của vấn đề này là phương thức client (và server) sử dụng để chuyển password thành các giá trị, được biết đến trong mã hóa là một *key* để bảo vệ dữ liệu. Trong ví dụ được mô tả trước, key là *A1, và nó là sự gộp lại của ba thứ là username, realm, và password. Ba cái này này không đổi khi client request lại cho một host. Mỗi request tới host sẽ sử dụng cùng key để bảo vệ thông tin xác thực.

Trong mã hóa, nhiều thông tin được bảo bệ với một key, key sẽ trở nên yếu hơn. Kẻ gian sẽ có nhiều dữ liệu để phân tích, và chúng càng có nhiều dữ liệu, chúng càng dễ phân tích. Nếu một client tiếp tục sử dụng cùng một key đủ dài, tất nhiên là kẻ gian sẽ có thể tìm ra được giá trị của nó.

Để chống lại kiểu phân tích này, Improved Digest Authentication đưa ra một tùy chọn là chỉnh sửa cách tạo ra key. Sự chỉnh sửa này là một key được theo đổi theo chu kỳ, dựa trên response từ server. Buộc client phải thay đổi key ngẫu nhiên, server ngăn kẻ gian lấy được dữ liệu với cùng một key, giúp client bảo vệ password tốt hơn.

Client sử dụng nó mỗi khi tham số `algorithm` xác định là `MD5-sess`. Thuật toán này trong response ban đầu của server, nó như thế này:

```sh
HTTP/1.1 401 Unauthorized
WWW-Authenticate: Digest
    realm="users@hundredacrewoods.com",
    qop="auth",
    algorithm=MD5-sess,
    nonce="dcd98bc09f81043d3a8cb935ae393db90674"
WWW-Authenticate: Digest
    realm="users@hundredacrewoods.com",
    qop="auth",
    algorithm=MD5,
    nonce="dcd98bc09f81043d3a8cb935ae393db90674"

```

Chú ý rằng ví dụ này server response thuật toán mã hóa có cả `MD5` và `MD5-sess`. Client sẽ bỏ qua `WWW-Authenticate` thứ hai và chấp nhận cái `WWW-Authenticate` thứ nhất. Client có thể hỗ trợ cả `MD5` và `MD5-sess`, nhiên nó luôn chọn `MD5-sess` để bảo mật tốt hơn.

Client chấp nhận một trong các thuật toán khi chúng tái tạo một request. Ví dụ sau đây cho thấy một client chấp nhận thuật toán `MD5-sess`.

```sh
GET /secret/honeypot.html HTTP/1.1
Authorization: Digest username="pooh",
realm="users@hundredacrewoods.com",
qop=auth,
algorithm=MD5-sess,
nonce="dcd98bc09f81043d3a8cb935ae393db90674",
nc=00000001,
cnonce="32cfe192fd109232aa1b8fe09d18d5efe53",
uri="/secret/honeypot.html",
response="dcd98bc09f81043d3a8cb935ae393db90674"
```

Khi `MD5-sess` được lựa chọn, bảng 4.8 đưa ra thuật toán mà client sử dụng để tính toán digest. Nó khác với các thuật toán ban đầu chỉ trong step 1.

>**Bảng 4.8: Việc tính toán Digest với thuật toán MD5-sess**

|Step|Hoạt động|
|----|---------|
|1a|Tạo ra một chuỗi các ký tự của username, realm, và password của user, giá trị `nonce` và giá trị `cnonce` được ngăn cách nhau bởi dấu hai chấm.|
|1b|Tính toán MD5 digest cho chuỗi ký tự này và hiển thị kết quả dưới dạng mã thập lục phần là các ký tự 32 ASCII. (Đây là chuỗi A1).|
|2|Tính toán MD5 digest cho chuỗi A1 và hiện thị kết quả dưới dạng mã thập lục phân với ký tự 32 ASCII.|
|3|Tạo ra một chuỗi các ký tự chứa phương thức và URI cho phương thức đó, ngăn cách nhau bởi dấu hai chấm. (Đây gọi là chuỗi A2)|
|4|Tính toán MD5 digest cho chuỗi ký tự A2 và hiện thị kết quả dưới dạng các ký tự 32 ASCII.|
|5|Tạo ra một chuỗi các ký tự bằng cách gộp kết quả từ step 2, `nonce` được áp dụng bởi server, giá trị `nc`, giá trị `cnonce`, giá trị `qop`, và kết quả từ step 4, tất cả được ngăn cách nhau bởi dấu hai chấm.|
|6|Tính toán MD5 digest cho chuỗi ký tự trong step 5 và hiển thị kết quả dưới dạng các ký tự 32 ASCII. Đây là giá trị cho digest.|

### 4.1.7 Integrity Protection 

Integrity Protection - nó không chỉ xác thực mỗi sự nhận dạng, mà nó còn xác thực thông tin mà nó gửi. 

Để hiểu được giá trị của dịch vụ này, xem xét ví dụ trong hình 4.7 và 4.8. Hình đầu tiên minh họa một chuẩn giao dịch tiền điện, và nó bắt đầu sau khi server gửi một ` WWW-Authenticate` response yêu cầu client xác thực. Client gửi lại request với một giao thức POST và nó chấp nhận response của server.

![Hình 4.7](http://i.imgur.com/rEAjjnb.png)

**Hình 4.7: Một client nghĩ rằng server đang nhận và phản hồi tới message của nó giống như trong hình. Tuy nhiên như hình 4.8 cho thấy có gì đó lạ lạ xảy ra.**

![Hình 4.8](http://i.imgur.com/lA0BVIP.png)

**Hình 4.8: Nếu không có Integrity protection, một kẻ gian có thể xâm nhập và chỉnh sửa nội dung một message của client.**

Hình 4.8 đưa ra ví dụ. Một kẻ gián nẳm ở giữa client và server, client và server đều không biết về nó. Kẻ gian giả làm server để tương tác với client, và nó giả làm client để tương tác với server. (Kiểu tấn công *man-in-the-middle*).

Chú ý việc kẻ gian tận dụng vị trí của nó như thế nào. Nó chấp nhận request của client và sau đó chỉnh sửa message body trước khi truyền nó tới server. User muốn thanh toán tiền điện nhưng thật không may số tiền đó đến tay kẻ gian trước. Phần xảo quyệt của tấn công là kẻ gian không chỉnh sửa `Authorization` header trong request của client. Khi server tính digest để xác thực client, nó tìm digest khớp với tham số `response` trong request.

Thật may mắn, điều đó được bảo vệ. Một thủ thuật trong việc tính toán digest. Nếu client chứa toàn bộ nội dung của message trong digest, sau đó quá trình digest sẽ bảo vệ nội dung đó giống như nó bảo vệ password của user. Nếu một kẻ gian chỉnh sửa dữ liệu, sau đó server tính toán digest (dựa trên dữ liệu bị chỉnh sửa) sẽ không khớp với digest trong `Authorization` header. Tất nhiên kẻ gian không thể điều chỉnh được giá trị vì kẻ gian không chiếm được password của user.

Để khởi động một Integrity Protection, server đề ra cho `qop` một giá trị là `auth-int`. Ví dụ dưới đây server có thể gộp giá trị `auth` với giá trị `auth-int` trong một header.

```sh
HTTP/1.1 401 Unauthorized
WWW-Authenticate: Digest
    realm="users@hundredacrewoods.com",
    qop="auth,auth-int",
    algorithm=MD5,
    nonce="dcd98bc09f81043d3a8cb935ae393db90674"

```

Khi client muốn sử dụng integrity protection, nó chứa toàn bộ phần thân của message của nó trong đầu vào của chức năng digest. 

>**Bảng 4.9: Sử tính toán digest của client cho Integrity Protection**

|Step|Hoạt động|
|----|---------|
|1|Tạo ra một chuỗi chứa username, realm, và password, mỗi cái được ngăn cách nhau bởi dấu hai chấm. Đây gọi là chuỗi "A1".|
|2|Tính toán MD5 digest cho chuỗ A2 và hiển thị kết quả dưới dạng mã thập lục phân với các ký tự 32 ASCII.|
|3|Tạo ra một chuỗi ký tự thứ ha chứa phương thức, URI và **toàn toàn phần body**, được ngăn cách nhau bởi dấu hai chấm.|
|4|Tính toán MD5 digest cho chuỗi ký tự này và hiển thị kết quả là các ký tự 32 ASCII.|
|5|Tạo ra một chuỗi bằng việc gộp kết quả từ step2, `nonce` áp dụng cho server, giá trị `nc`, giá trị `cnonce`, giá trị `qop`, và kết quả từ step 4, tất cả ngăn cách nhau bởi dấu hai chấm.|
|6|Tính toán MD5 digest cho chuỗi đó và hiện kết quả ra dưới dạng các ký tự 32 ASCII. Gía trị này là digest.|

Client chứa giá trị digest mới này trong request được tái tạo của nó, cùng với một giá trị `qop` phù hợp. Tham số `qop` chỉ ra rằng nó chấp nhận sự yêu cầu chứa Integrity protection của server.

```sh
GET /secret/honeypot.html HTTP/1.1
Authorization: Digest username="pooh",
    realm="users@hundredacrewoods.com",
    qop=auth-int,
    nonce="dcd98bc09f81043d3a8cb935ae393db90674",
    nc=00000001,
    cnonce="32cfe192fd109232aa1b8fe09d18d5efe53",
    uri="/secret/honeypot.html",
    response="dcd98bc09f81043d3a8cb935ae393db90674"

```

Khi client chấp nhận sử đề nghị để sử dụng Integrity Protection, server cũng làm tương tự như vậy. Vì thế, trong Digest cho response của nó, nó chứa toàn bộ body của response đó trong sự tính toán digest của nó. Nó chấm nhận integrity protection với giá trị `auth-int` của `qop`.

```sh
HTTP/1.1 200 OK
    Authentication-Info: qop=auth-int,
    rspauth="78d98bc09f81ba3d3a8cb935a9993db90674",
    cnonce="32cfe192fd109232aa1b8fe09d18d5efe53",
    nc=00000001

```

Bảng 4.10 miêu tả chi tiết sử tính toán digest này. Sự khác nhau là trong step 3, nơi mà server tính toán chuỗi A2. Chú ý rằng bảng này không chứa sự tính toán của frequent client protection.

>**Bảng 4.10: Sự tính toán Digest cho Integrity Protection**

|Step|Hoạt động|
|----|---------|
|1|Tạo ra một chuỗi ký tự chứa username, realm và password, được ngăn cách nhau bởi dấu hai chấm.|
|2|Tính toán MD5 digest cho chuỗi ký tự đó.|
|3|Tạo ra một chuỗi ký tự chứa một dấu hai chấm theo sau là URI request của client, theo sau bởi một dấu hai chấm khác và sau đó là **toàn bộ body** trước khi mã hóa nó.|
|4|Tính toán MD5 digest cho chuỗi ký tự này.|
|5|Tạo ra một chuỗi gộp kết quả từ step 2, giá trj `nonce`, giá trị `cnonce`, giá trị `qop`, và kết quả từ step 4, tất cả được ngăn cách bởi dấu hai chấm.|
6|Tính toán MD5 digest cho chuỗi ký tự trên và đây là digest.|

<a name="4.2"></a>
## 4.2 Secure Sockets Layer (SSL)

Tuy HTTP sở hữu các dịch vụ bảo mật quan trọng, nhưng chúng không cung cấp hoàn toàn bảo mật cho hệ thống truyền tin. Không có cách nào để mã hóa các message để bảo vệ các phần riêng tư. Đó là điều bất tiện nhất cho WWW. Web sử dụng Internet cộng đồng như là mạng của nó, và lưu lượng truyền tin trên mạng công cộng sẽ được public. Bởi vì các kẻ gian dễ dàng thấy được các message mà dy chuyền giữa client và server, việc mã hóa các message đó để kẻ gian không thể hiểu được mã hóa đó. Mặt khác, thông tin cá nhân hữu ích như là thẻ tín dụng có thể dễ dàng bị chặn lại giống như hình 4.9.

![Hình 4.9](http://i.imgur.com/ElxbCWY.png)

**Hình 4.9: Nếu không có SSL, một kẻ gian có thể ăn cắp thông tin bảo mật.**

May thay,  Web đã phát triển công nghệ để cung cấp sự bảo mật cần thiết cho lưu lượng truyền tin. Công nghệ đó không phải là sử cải tiến cho http mà là toàn bộ các giao thức tách rời như là Secure Sockets Layer (ssl). Ngày nay, ssl là sự bảo mật mạng phổ biến nhất trên thế giới.

Mục này cung cấp một sự giới thiệu ngắn về giao thứ SSL. Đầu tiên nó cho thấy mối liên hệ giữa ssl và các giao thức khác. Sau đó mục này sẽ giới thiệu về hệ mã hóa công khai, kỹ thuật mã hóa quyết định mà ssl dựa vào. Sau đó mục này giới thệu sự hoạt động của ssl.

### 4.2.1 SSL và các giao thức khác.

Là một giao thức riêng lẻ, ssl phù hợp với tất cả các ứng dụng mà sử dụng tcp để truyền truyền tin. Hình 4.10 cho thất vị trí của nó trong chuẩn các lớp giao thức.

Chú ý rằng trong chuẩn này http truyền tin trực tiếp với tcp thì ssl có dính dáng vào, http chỉ truyền tin với ssl, và tiếp tục là ssl truyền tin với tcp.

![Hình 4.10](http://i.imgur.com/alcGCUU.png)

**Hình 4.10: Giao thức SSL thêm vào giữa một ứng dụng như là http và TCP. TCP coi SSL như là một ứng dụng khác và http truyền tin với SSL.**

Trong các sự truyền tin, đặc biệt với Web, client quyết đinh việc sử dụng ssl hay không. Đối với trường hợp cụ thể của ssl gộp với http, một chuẩn sơ đồ uri "http:" chỉ ra một session an toàn. User nhập đầy đủ uri vào một web browser hoặc client có thể được chuyển hướng đến một session an toàn bởi một link. Hình 4.11 cho thấy IE cho thấy một trang an toàn. Chú ý rằng cái icon móc khóc ở góc bên dưới của tay phải.

Mặc dù sơ đồ uri cho phép đặc điểm ký thuật rõ ràng của một cổng tcp, http có một cổng mặc định là 443. Mỗi ứng dụng có hai cổng tcp mặc định để sử dụng đó là 80 không an toàn và 443 an toàn.

![Hình 4.11](http://i.imgur.com/vZETs9i.png)

**Hình 4.11: Icon móc khóa ở góc dưới bên phải của browser chỉ ra rằng session là bảo mật với SSL. Các browser khác sử dụng cùng một icon để chỉ ra sự truyền tin an toàn.**

### 4.2.2 Hệ mã hóa công khai  (Public Key Cryptography)

Hệ mã hóa công khai cái mà SSl dừa vào, giải quyết một vấn đề cơ bản mà tồn tại trong quy ước mã hóa: quản lý key. Với quy tắc mã hóa, các thành phần giao tiếp chia sẻ một giá giá trị bí mật đó là key. Trong các trường hợp của bảo mật http được bàn luận trong mục cuối cùng, key là password của user. Cả client và server cần biết được password trước khi ủy quyền hoặc một sử bảo vệ toàn vẹn.

Key được chia sẻ bởi các thành phần giao tiếp làm bộc lộ 1 vấn đề cho các hệ thống bảo mật. Các thành phần đó giao ước và trao đổi giá trị của key như thế nào. Nếu kẻ gian đợi để chặn sự truyền tin lại, chúng có thể chặn lại key. Và nếu một kẻ gian chiếm được key thì sau đó bảo mật trong truyền tin vô nghĩa.

Hệ mã hóa công khai giải quyến vấn đề này dựa trên hai key tách rời. Nếu một key được sử dụng để mã hóa thông tin, key còn lại dùng để giải mã nó. Các ký chia sẻ một sự liên hệ toán học phức tạp, nhưng nó không khả thi, chỉ biết một bên, để tìm ra hoặc tính toán cái còn lại.

Một trong các key có thể được tự do công khai. Ví dụ, một server có thể gửi một trong các key của nó, key đó là *public key*, mà client yêu cầu nó. Client nhận được key, sử dụng nó để mã hóa thông tn, và gửi thông tin được mã hóa tới server. Server sau đó sử dụng key khác của nó là *private key* để giải mã thông tin của client. Biết được public key thì ket gian không thể giải mã được thông tin bảo mật.

### 4.2.3 Hoạt động của SSL

Giao thức SSL đưa vào 3 dịch vụ bảo mật quan trong cho các ứng dụng sử dụng nó. Các dịch vụ đó là sự xác thực, tính toàn vẹn thông báo, và sự bảo mật. Các dịch vụ đó cung cấp các câu trả lời đáng tin cậy cho ba câu hỏi sau: "Tôi đang giao tiếp với ai", "Tôi có nhận được chính xác thông tin mà các bộ phận khác đã gửi", và "Chúng ta có đảm bảo rằng một bên thứ ba không thể nghe trộm cuộc giao tiếp".

Đặc biệt trên Web, có hai trường hợp phổ biến. Điển hình là các trang thương mại điện tử là trường hợp thứ nhất: ssl xác thực Web server và mã hóa và bảo vệ giao tiếp giữa browser và server. Các trang chuyện dụng là trường hợp thứ hai: ngoài việc xác thực server, các trang đó sử dụng ssl để xác thực cả client.

Trong cả hai trường hợp các bộ phận giao tiếp trao đổi một chuỗi (dãy) các ssl message trường khi chuyển thông tin http. Hình 4.13 cho thấy chuỗi các message chỉ dành cho sự xác thự server. 

![Hình 4.13](http://i.imgur.com/jDOJ8xQ.png)

**Hình 4.13: Tạo ra một SSL session cho lần đầu tiên yêu cầu trao đổi vài message. Trong step 1 client giới thiệu bản thân nó và khả năng của nó; server phản hồi trong step 2 bằng việc chọn các tham số cho session. Sau đó nó gửi cho client public key cetificate của nó trong step 3, và nó dừng sự trao đổi trong step 4. Với step 5, client nhặt 1 key bí mật cho session, mã hóa nó sử dụng public key của server. Chỉ khi server biết được private key của nó, chỉ có server có thể giải mã được key bí mật. Trong các bước còn lại, cả hai hệ thống kết thực cuộc đàm phán và kích hoạt sự bảo mật của session.**

Khi step 9 hoàn thành, các giao thức ứng dụng có thể bắt đầu trao đổi các message của chúng một cách an toàn. Client tuân theo thỏa thuận ssl với một GET hoặc POST request. Chú ý rằng ssl thêm các header của nó vào mỗi message của ứng dụng. Các header này chứa hai sự đồng bộ của hai bên và chúng cung cấp sử bảo mật toàn diện cho message. 

SSL là một cách hiệu quả để xác thực servre, và nó tạo ra một kênh giao tiếp an toàn giữa client và server. Tuy nhiên, nó không xác thực client. Điều đó bởi vì trong nhiều ứng dụng, ssl không cần phả xác thực client. Ví dụ, xem xét các ứng dụng thương mại điện tử. Trong một cuộc giao dịch phổ biến, khách hàng cung cấp thông tin thẻ tín dụng, và nó là một mã số thẻ phù hợp thông qua user. Các site khác yêu cầu user lựa chọn các username và password, sự gộp lại đó giúp còn người dễ quản lý hơn hệ mã hóa công khai. Trong môi trương như vậy thì sự mã hóa xác thực của client là không cần thiết.

>**Bảng 4.11: Các thỏa thuận SSL session cơ bản**

|Step|Hoạt động|
|----|---------|
|1|Client gửi server một Client Hello message. Trong message này client nhận dạng phiên bản của SSL mà nó hỗ trợ (phiên bản cuối cùng là 3.0) và nó đưa ra một chuỗi các các khả năng bảo mật; nó áp dụng cho giao tiếp. Các khả năng bảo mật này được biết đến là *Cipher Suites(Mật mã)*, và chúng nhận dạng các tham số mà chỉ ra thuật toán mã hóa và kích thước key mã hóa.|
|2|Server phản hồi với một Server Hello message. Trong message này, server lựa chọn cả phiên bản SSL và khả năng bảo mật cho giao tiếp. Server lựa chọn từ những cái được đưa ra bởi client đó.|
|3|Server gửi một Certificate message mà vận chuyển public key certificate của nó tới client. Chú ý rằng client có trách nhiệm đảm bảo rằng certificate này là phù hợp, nó được tao ra bởi một thuật toán đáng tin cậy, và nó nhận dạng server mà client hoặc user có ý định liên hệ.|
|4|Server phản hồi với một Server Hello Done message để chỉ ra rằng nó chứa các phần của thỏa thuận SSL.|
|5|Client gửi lại một Client Key Exchange message. Message này chứa key mã hóa mà sẽ được sử dụng để mã hóa giao tiếp. Key tự mã hóa bằng cách sử dụng public key của server. cho nên chỉ có server có thể giải mã và tìm ra key đó.|
|6|Client gửi một Change Cipher Spec message. Message này là một tín hiệu rằng client sẽ mã hóa  tất cả các giao tiếp sau này bằng việc sử dụng key mã hóa.|
|7|Clent gửi một Finished message, cái mà được mã hóa theo key mã hóa và thuật toán đã thỏa thuận. Server có thể giải mã thành công message này và đảm bảo rằng thỏa thuận đó thành công.|
|8|Server gửi Change Cipher Spec message của nó. Gíông với client, message này báo rằng các đặc điểm của message sẽ được mã hóa.|
|9|Server kết thúc thỏa thuận SSL vớ một Finished message, một lần nữa client giải mã thành công message này, nó đảm bảo rằng sử thỏa thuận đã thành công.|

Tuy nhiên, trong các cài đặt chuyên dụng, xác thực mã hóa có ích. Giao thức SSL hỗ trợ kiểu hoạt động này. Hình 4.14 cho thấy sự trao đổi message cho sự xác thực của client. Hình đó nổi bật lên các message đó. Bảng 4.12 miêu tả các step đó.

![Hình 4.14](http://i.imgur.com/oaRkYoj.png)

**Hình 4.14: Client cũng có thể sử dụng SSL để xác thực chính nó cho server. Server yêu cầu sử xác thực bằng việc gửi một Certificate request trong step 4. Client phản hồi request này trong step 6 và sau đó trong step 8, nó gử một message đặc biệt để xác nhận sử hiểu biết của nó private key tương ứng. Phần còn lại của sử trao đổi giống như hình 4.13.

>**Bảng 4.12: Các step bổ sung cho sự xác thực client**

|Step||Hoạt động|
|-----|---------|
|4|Serer gửi một Certificate Reuqest message sau khi gửi certificate của nó. Message này báo cho client biết rằng server muốn xác thực việc sử dụng SSL của client, và nó là sự khởi đầu cho sử xác thực SSL của client.|
|6|Client cung cấp public key certificate của nó trong Certificate message.|
|8|Client gửi một Certificate Verify message, trong đó nó mã hóa các thông tin biết được bằng việc sử dụng private key. Server có thể giải mã thông tin đó bằng cách sử dụng public key từ certificate của client. Giải mã thành công xác nhận rằng client thực sự có private key tương ứng với public key certificate.|

Có hai thứ quan trọng cần chú ý về việc sử dụng SSL của client. Đầu tiên, client phải có một public key certificate, và nó phải được server tin tưởng. 
Thường thì bản thân server tạo ra client certificate. Thứ hai, xác thực SSL client có khuynh hướng xác thực hệ thống có vai trò là cclient; nó không ảnh hưởng đến việc xác thực user của hệ thống đó. Bởi vì public key certificate rất phức tạp để con người có thể thuận tiện lưu trữ và nhớ, client dựa vào các hệ thống máy tính để lưu trữ và quản lý chúng, và các hệ thống máy tính rất dễ bị tấn công. Vì lý do này, các trang thương mại điện tử không sử dụng xác thực SSL client để xác thực các user.

Với các trang phục vụ cho hơn 1 triệu user, ssl có thể ảnh hưởng đến hiệu năng. Sử dụng sự dụng hỗ trợ http persistence, client có thể tạo ra nhiều request mà không cần thỏa thuận các tham số ssl. Tuy nhiên, giao thức SSL cũng cung cấp các dạng persistence - hữu ích cho các ứng dụng mà không hỗ trợ persistence. Với mỗi thỏa thuận, server có thể gắn một Sesson id. Khi client sau này muốn tái tạo lại các cuộc giao tiếp an toàn, có chứa một Session id trong Client Hello message. Nếu server đồng ý tái sử dụng các tham số được thỏa thuận trước, nó phản hồi với cùng Session id trong Server Hello. Hình 4.15 và bảng 4.13 miêu tả chi tiết.

![Hình 4.15](http://i.imgur.com/oyrC5E3.png)

**Hình 4.15: Nếu chúng tạ một SSL session trước, client và server có thẻ tái sử dụng các tham số của session đó và tránh được một thỏa thuận SSL. Client tiếp tục một session trong Hello message. Nếu server đồng ý, nó chấp nhận sự đề xuất đó trong phản hồi Hello của nó.

>**Bảng 4.13: Tiếp tục một SSL session được tạo từ trước**

|Step|Hoạt động|
|----|---------|
|1|Client gửi một Client Hello message chứa một SSL session id được tạo từ trước. Chú ý rằng client chứa một bộ đầy đủ các tham số mã hóa trong trường hợp server quyết định không tái sử dụng session.|
|2|Server phản hồi với một Server Hello message cũng chứa Session ID, chỉ ra rằng nó muốn và có thể tiếp tục SSL session.|
|3|Server sau đó gửi một Change Cipher Spec message. Message này báo hiệu sự tiếp tục lại của bảo mật session.|
|4|Server kết thúc phần thỏa thuận của nó bằng việc gửi một Finished message. Client giải mã message này để đảm bảo rằng sự tiếp tục lại session đã thành công.|
|5|Client gửi Change Cipher Spec message để chỉ ra rằng nó sẽ bắt đầu sử dụng các tham số session đã thỏa thuận.|
|6|Client kết thúc với một Finished message đã được mã hóa. Server giải mã message này để xác nhận rằng session được tiếp tục thành công.|
<a name="4.3"></a>
## 4.3 Transport Layer Security (TLS)

### 4.3.1 Sự khác nhau so với SSL

Ngoại trừ cái tên mới thì, `tls` thật sự không khác nhiều so với `ssl`. Thật vậy, nó là một phiên bản nhỏ. Các `tls` message chỉ ra phiên bản giao thức là 3.1 (Phiên bản cuối cùng của `ssl` là 3.0). 

`tls` chỉ có hai thay đối đáng kể với `ssl`. Đầu tiên, nó hầu như tăng gấp đôi số dạng error message; việc tăng này giúp nhận dạng và cô lập giữa các lỗi. Thứ hai, `tls` có sự thay đổi nhẹ trong sự phức tạp trong tính toán mã hóa để loại bỏ các lỗ hổng nhỏ.

### 4.3.2 Coltrol of the Protocol 

Sự thay đổi lớn nhất từ `ssl` sang `tls` là control of the protocol. Với `tls` sự điều khiển đó thuộc về một tổ chức tiêu chuẩn quốc tế - `ietf`, hơn là Netscape. `ietf` cung cấp một quá trình mở và dễ hiểu để thêm vào `tls`, đặc biệt là trong mật mã. Một mật mã định rõ các tham số mã hóa cả một giao tiếp an toàn, chứa các yếu tố như là thuật toán mã hóa và kích thước key. `ietf`  chấp nhận đề xuất tăng số mật mã được hỗ trợ bởi `tls`. 

### 4.3.3 Nâng cấp TLS trong một HTTP session

`ietf` cũng điều khiển http, có sự phối hợp hơn giữa hai giao thức. Một trong các vấn đề với `ssl` là nó yêu cầu một cổng `tcp` riêng biệt cho mỗi ứng dụng nó bảo mật. Đó là lý do tạ sao Web sử dụng cổng 80 cho chuẩn http và cổng 443 cho bảo mật http bằng `ssl`. Tuy nhiên, với `tls` nó có thể hỗ trợ cả có bảo mật và không bảo mật trong cùng một cổng. Điều này giúp tiết kiệm các cổng.

Để hỗ trợ một cổng đơn, hệ thống truyền tin bắt đầu kết nối http mà không cần bảo mật. Sau đó, trong khi kết nối vẫn còn hoạt động, chúng nâng cấp lên một session an toàn. Nâng cấp có thể được bắt đầu bởi client hoặc server. Client bắt đầu quá trình nâng cấp bằng việc chứa các header `Upgrade` và `Connection` trong message của nó như ví dụ dưới đây.

```
GET http://www.bank.com/acct.html?7493948 HTTP/1.1
Host: www.bank.com
Upgrade: TLS/1.0
Connection: Upgrade

```

Server phản hồi request này với một `101` status.

```
HTTP/1.1 101 Switching Protocols
Upgrade: TLS/1.0, HTTP/1.1
Connection: Upgrade

```

Sau sự trao đổi này, hai bộ phần thực hiện một đàm phán. Một khi đàm phán thành công, server phản hồi tới `GET` request ban đầu của client.

Một sự cố có thể xảy ra với nó là server có thể không muốn thực hiện request upgrade. Trong trường hợp đó, nó sẽ vẫn phản hồi tới GET request của client; tuy nhiên, response sẽ không được bảo mật bởi `tls`. Vì vậy, client chứa upgrade request trực tiếp trong mọt GET message. Thực ra là request upgrade của client lên `tls` lầ tùy chọn.

Để tránh điều đó, client request upgrade trước khi nó tạo ra một GET request. Client cũng làm vậy nếu GET message chưa dữ liệu mà cần giữ bí mật. Để nâng cấp trước khi gửi một GET hoặc POST request, client sử dụng OPTIONS message.

```
OPTIONS * HTTP/1.1
Host: www.bank.com
Upgrade: TLS/1.0
Connection: Upgrade

```

Server phản hồi chấp nhận hay không. Nếu server không nâng cấp lên `tls`, client kết thúc kết nối mà không phải gửi GET request.

Một server có thể chỉ ra rằng nó muốn nâng cấp lên `tls` trong các response `101` hoặc `426`. Nó chứa các header `Upgrade` và `Connection` trong response đó.

```
HTTP/1.1 200 OK
Upgrade: TLS/1.0, HTTP/1.1
Connection: Upgrade

```

Sự bắt đầu nâng cấp thật sự vẫn thuộc vào client, và client cũng sử dụng một trong hai kỹ thuật trên. Tuy nhiên, client biết trước rằng server có thể hỗ trợ nâng cấp `tls`.

Nếu server buộc client bắt đầu một nâng cấp, nó phản hồi với một `426 Upgrade Required` error status.

```
HTTP/1.1 426 Upgrade Required
Upgrade: TLS/1.0, HTTP/1.1
Connection: Upgrade
<HTML>
<BODY>
<P>Secure connection required. Please follow <A
HREF="https://www.bank.com/acct.html?749394889300"
>this link</A>.
</BODY>
</HTML>
```

Chú ý rằng message body chứa một trang html để mô tả vấn đề cho user và đưa ra cho user một link để click vào. Response `426` chứa tất cả các thứ đó để hỗ trọ Web browser mà không hiểu upgrade request.

Nếu client hiểu được upgrade request, nó bắt đầu nâng cấp như trên. Chú ý rằng client không bắt đầu ngay thỏa thuận `tls`.

Việc nâng cấp lên `tls` cũng hỗ trợ cho các proxy server. Nếu một client sử dụng cách được mô tả ở phía trên khi giao tiếp qua proxy, nó bảo mật giao tiếp với proxy đó. Một khi dữ liệu được truyền qua proxy đầu tiên, nó không còn được bảo mật bằng `tls` nữa. Bởi vì client muốn nâng cấp `tls` cho server chứ không phải các proxy trung gian, nó sử dụng một phương thúc `CONNECT` để tạo một tunnel cho host. Một khi tunnel được tạo, `tls` upgrade và thỏa thuận được xử lý.

## 4.4 Bảo mật HTTP

Bảo mật HTTP cung cấp các dịch vụ bảo mật giống với `ssl`: sự xác thực, bảo vệ toàn bộ cho message, và sự bảo mật. Tuy nhiên, không giống như `ssl`, bảo mật http có cùng cú pháp với http. Như ví dụ dưới đây cho thấy, giao thức sử dụng `Secure-HTTP` phiên bản 1.4, và phương thức chính là `SECURE`.

```
SECURE * Secure-HTTP/1.4
Content-Type: message/http
Content-Privacy-Domain: CMS

```

Secure HTTP có 4 header, và một vài tùy chọn bổ sung cho http message. Bảng 4.14 liệt kê các header của Secure HTTP; bảng 4.15 liệt kê các tùy chọn http mà không liên quan đến thỏa thuận mã hóa, và bảng 4.16 liệt kê các tùy chọn mà các bên sử dụng để thỏa thuận các tham số mã hóa.

>**Bảng 4.14: Các Header Secure HTTP**

|Header|Sử dụng|
|------|-------|
|Content-Privacy-Domain|Chỉ ra định dạng của thông tin mã hóa; CMS cho Cryptography Message Syntax của IETF hoặc MOSS cho MIME Object Security Services sử dụng email bảo mật.|
|Prearranged-Key-Info|Chỉ ra key mà được tạo ra trước giữa các bên; header này cho phép Secure HTTP hỗ trợ truyền thống, chia sẻ key mã hóa như là mã hóa public key.|
|Content-Type|Chỉ ra kiểu nội dung được bảo vệ bởi Secure HTTP; tất cả các Secure HTTP Messagecos content-type là `message/http`.|
|MAC-Info|Chứa một mã xác thực message cho message, được sử dụng để cung cấp sự bảo vệ toàn diện message.|

>**Bảng 4.15: Các tùy chọn HTTP cho Secure HTTP**

|Tùy chọn|Sử dụng|
|Key-Assign|Gán một ký hiệu nhận dạng cho một key mã hóa.|
|Encryption-Identiy|Nhận dạng thành phần (party) mà một message mã hóa cho.|
|Certificate-Info|Nhận dạng một public key certificate|
|Nonce|Chứa một giá trị random dùng để xác nhận nội dung message và cải tiến bảo mật|
|Nonce-Echo|Trả về một giá trị nonce được cùng cấp lúc trước.|

>**Bảng 4.16: Các thỏa thuận mã hóa Secure HTTP**

|Tùy chọn|Sử dụng|
|--------|-------|
|SHTTP-Cryptopts|Chứa các tùy chọn mã hóa chung|
|SHTTP-Privacy-Domains|Chỉ ra địng dạng của thông tin mã hóa;CMS cho Cryptography Message Syntax của IETF hoặc MOSS cho MIME Object Security Services sử dụng email bảo mật.|
|SHTTP-Certificate-Types|Nhận dạng public key certificate.|
|SHTTP-Key-Exchange-Algorithms|Nhận dạng một thuật toán mã hóa sử dụng để trao đổi key|
|SHTTP-Signature-Algorithm|Nhận dạng môt thuật toán mã hóa sử dụng để ký tên điện tử các message|
|SHTTP-Message-Digest-Algorithms|Nhận dạng một thuật toán mã hóa sử dụng để tính toán digest của message.|
|SHTTP-Symmetric-Content-Algorithms|Nhận dạng một thuật toán mã hóa sử dụng để mã hóa nội dung message.|
|SHTTP-Symmetric-Header-Algorithms|Nhận dạng một thuật toán mã hóa sử dụng để mã hóa các header.|
|SHTTP-Privacy-Enhancements|Liệt kê các nâng cấp riêng tư sử dụng cho một message.|
|Your-Key-Pattern|Nhận dạng một key mã hóa đang sử dụng một cú pháp mô phỏng chung.|

Bởi vì Secure HTTP sử dụng cùng cú pháp với http, tuy nhiên, Secure HTTP không yêu cầu một cổng tcp mặc định cho nó. Secure HTTP và các http message cùng sử dụng chung một cổng, mặc định là 80.
<a name="5"></a>
# Chapter 05 Tăng tốc HTTP - Cải tiến trải nghiệm của web user

Không lâu sau khi Web đầu tiên xuất hiện trên Internet, các kỹ sư bắt đầu tìm cách làm cho nó nhanh hơn. Như là load balancing, advanced caching, ssl acceleration và tpc multiplexing. Chương này miêu tả chi tiết về các kỹ thuật bên các các công nghệ tăng tốc đó.

Hai công nghệ được sử dụng rộng rãi nhất để tăng tốc http là load balancing và caching, và hai chủ để này là hai chủ đề chính của chương này. Tuy nhiên, mục nhỏ cuối cùng miêu ra các công nghệ bổ sung cho việc cải thiện hiệu năng của Web - tcp multiplexing à ssl acceleration.
<a name="5.1"></a>
## 5.1 Load Balancing

Cho phép các Web server khác nhau hoạt động như là một Web site đơn. Khi các công nghệ Web phát triển thì load balancing cũng tự phát triển phức tạp và năng động hơn. Mục nhỏ này xem sét ba khía cạnh chính của load balacing. Đầu tiên là địa chỉ của các server được cân bằng. Tiếp theo chúng ta xem cách mà có thể chỉ dẫn client tới một server phù hợp. Mục cuối cùng miêu tả việc load balancing chọn server phù hợp cho một request.

### 5.1.1 Locating Server

Cấu hình load balancing đơn giản nhất đặt nhiều server ngay cạnh nhau, như hình 5.1. Các HTTP request từ Internet được chỉ dẫn tới một trong các server này.  Ngay cả trong cấu hình đơn giản này, load balancing mang lại lợi ích đáng kể. Khi mà lưu lượng như cầu tăng, cá quản trị site thêm vào nhiều server hơn. Các server mới giảm tải cho các server đang tồn tại, cải thiện hiệu năng của server và trải nghiệm của user. Load balancing nâng cao độ tin cậy của một site, đặc biệt nếu các server phân bố có thể tự động xử lý các hệ thống lỗi(Nếu một server bị hỏng thì nó chuyển qua server khác). Và thậm chí việc thêm hoặc xóa các server yêu cầu cấu hính thử công, load balancing giúp bảo trì các máy chủ bị hỏng định kì.

![Hình 5.1](http://i.imgur.com/eJZbfk6.png)

**Hình 5.1 Local load balancing phân phối các request giữa nhiều máy chủ. Tất cả hiệu năng của Website từ tổng các server.**

Local load balancing tập trung vào các Web server, và hầu hết các lợi ích đó đều nhắm đến các server (Tất nhiên sử cải tiến hiệu năng server cũng cải thiện trải nghiệm của user, nên các client có thể có lợi gián tiếp từ các load balancing.). Tuy nhiên một dạng khác của local load balancing cung cấp lợi ích trực tiếp cho các Web client. Đó là global load balancing.

Như hình 5.2 cho thấy, với global load balancing, nhiều Web server phân bố xung quanh Internet; không giống như  local load balancing, server không chia sẻ cùng cơ sở vật chất và hạ tầng.

![Hình 5.2](http://i.imgur.com/sxh43OW.png)

**Hình 5.2: Global load balancing đặt các server ở các địa chỉ khác nhau xung quan Internet. Ngoài việc gộp hiệu năng của nhiều server trong một site, kiến trúc này cho phép client giao tiếp với server gần nhất**

Lợi ích chính của global load balancing là nó cho phép client tương tác trực tiếp với một server gần nhất. Các user ở châu âu có thể lấy được nội dung tử các server ở châu âu, trong khi các client ở Thái bình dương giao tiếp với các server trong cùng khu vực. Để nâng cao tầm quan trọng của việc tối ưu hóa này, xem xét các giới hạn vật lý cơ bản. Tốc độ cáp quang trễ 100 mili giây cho lưu lượng truyền qua Ấn độ dương. Nó chỉ tốn 60 mili giây để chuyển Wev page qua đường truyền `isdn`; và với `adsl` thì tốn 10 mili giaya`. Tóm lại, việc chuyển nội dung tới một user có thể ảnh hưởng đến trải nghiệm của user.

Global load balancing giúp cả server và client đều có lợi. Bằng việc phân bố các server quan Internet, Web site giảm băng thông. Global load balancing đưa đến một site luôn sẵn sàng. Với global load balancing, nếu một server bị hỏng thì vẫn còn server khác hoạt động thay.

### 5.1.2 Phân bố các reuqest

Khi một web site tạo ra nhiều server cho load balancing, sau đó các site đó phả phân bố các request giữa các server. Các cách này chứa DNS response, các chuyển hướng http, và lưu lượng giao nhau.

Các đơn gian nhất là sử dụng DNS. Giao thức DNS dịch phần host name của url thành một địa chỉ IP. Để gửi các reuqest tới các Web server khác nhau, DNS server cần phần hồi với các địa chỉ IP khác nhau. Như hình 5.3, trong cấu hình này load balancer hành động trực tiếp như là một DNS server: các DNS request để balancer, và nó phản hồi lại với một địa chỉ IP cho request đó.

![Hình 5.3](http://i.imgur.com/Wvxg8Zo.png)

**Hình 5.3: Một hệ thống global load balancing hoạt động như là một DNS cho một site. Nó có thể xác nhận địa chỉ IP trong DNS response dựa trên địa chỉ của request.**

Cách khác để chuyển hướng là sử dụng http. Load balancer hoạt động như một Web server. Tuy nhiên, thay vì trả về các page, server phản hồi tới các reuqest với các http message mà chỉ client tới một server mới. Hình 5.4 cho thấy hoạt động đó. Các load balancer thường trả về `302` status code, với header `Location: ` chỉ ra một Web server thực sự cho client.

![Hình 5.4](http://i.imgur.com/L3fYmyE.png)

**Một hệ thống global load balancing cũng có thể hoạt động như là một HTTP server chính cho một site. Nó sử dụng sự chuyển hướng HTTP để dẫn client tới Wev site thực sự.**

Global load balancer có thể sử dụng cả DNS response và sự chuyển hướng HTTP để phân bố các request tới các Web server khác nhau. Một kỹ thuật thứ 3 là traffice interception, chỉ có tác dụng với local load balancing. Trafice interception yêu cầu load balancer để được đặt giữa Internet và Web server như hình 5.5 cho thấy.

![Hình 5.5](http://i.imgur.com/gX8hoSk.png)

**Hình 5.5: Traffic interception hay được gọi là layer 4 hoặc 7 switching. Các request truyền qua load balancer được chuyển trực tiếp tới một server phù hợp**

Bởi vì tất cả các HTTP request truyền qua load balancer, nó hoàn toàn kiểm soát được các đích đến đó. Traffice interception chiếm nhu cầu lớn hơn trong load balancer. Nhưng cới DNS hoặc sự chuyển hướng HTTP thì cái này bị bỏ qua. Khi nó gửi một request tới một server phù hợp, laod balancer không giữ lại các request hoặc session của nó. Tuy nhiên, với traffice interception, load balancer đóng giả làm Web server. Để không gây nhầm lẫn cho client, load balancer phải tiếp tục giả làm web server trong thời gian của session. Và trong trường hợp giao tiếp bị mã hóa bởi ssl, load balancer phải theo dõi hoạt động qua nhiều http session.

### 5.1.3 Xác định một Target Server

Load balancer đầu tiên sử dụng một thuật toán round-robin để chuyển các request. Với round-roobin, request đầu tiên được gửi tới host 2; request tiếp theo được gửi host b, và tiếp tục. Tiến trình qua tất cả server và sau đó bắt đầu lại ở server a. Cách này rất dễ thực hiện với DNS dựa vào sử chuyển hướng. Hầu hết các DNS server có thể được cấu hình để sử dụng thuật toán round-roobin trong việc trả về địa chỉ IP. 

Với thuật toán round-robin, load balancer không cần xem xét các Web server hay việc request của các clien. Nó chỉ cần nhớ sự chuyển hướng cuối cùng với cái mà nó đã phản hồi.Tuy nhiên, cách này cũng có nhưng hạn chế của nó. Round-robin không ghi lại và vì thế không biết được trạng thái của mỗi server. Nếu một server không thể kết nối Internet, load balancer không biết gửi cho client cái gì. Round-robin chỉ hiệu quả nếu mỗi request chiến một phần trên server. Nếu các request yêu cầu nhiều tài nguyên server hơn thì một round roobin load balancer gửi một số lượng lớn các request đó tới một server, xử lý nó không đúng.

Các load balancer càng phát triển, đặc biệt là các local load balancer sử dụng traffice interception, có thể quan tâm đến Web server mà chúng hỗ trợ. Bởi vì các balancer thấy tất cả các request và response từ Web server, đó là một vị trí tốt để đánh giá mỗi server và điều chỉnh các sự chuyển hướng phù hợp. Bảng 5.1 liệt kê các nhân tố mà một traffic interception load balancer xem xét việc xác định target server.

>**Bảng 5.1: Giám sát Web server helth**

|Factor|Approach|
|------|--------|
|Passive Monitoring|Load balancer đo lưu lượng từ server đế ước tính tải trọng và helth.|
|Active Request|Load balancer tạo ra các request của nó cho các server định kỳ; các request này có thể là một Internet Control Message Protocol (ICMP) echo request(ping) hoặc một giả vờ là một request cho một Web page thực sự.|
|Network Monitoring|Load balancer sử dụng một chuẩn giao thức quản lý mạng như là Simple Management Protocol(SMP) để đạt được số liệu thống kê hiệu năng cho mỗi server.|
|System Monitoring|Load balancer sử dụng môt gia thức đo đạc hệ thống để lấy được số liệu thống kê hiệu năng cho mỗi server.|

Bởi vì global load balaner quản lý một bộ phân phối của các web server nên chúng có cơ hội hơn để phân bố lưu lượng. Ngòa việc duy trì thông tin và việc giám sát trạng thái của các Web server, một global load balancer xem xét client trong việc đưa xác định target của request. Thật vậy, nó sẽ giúp tìm server hợp lý nhất cho client. Hình 5.6 mổ tả quá trình đó. 

![Hình 5.6](http://i.imgur.com/u5cLNC4.png)

Request đi tới global load balancer, nó hoạt động như một Web server ảo cho một Web site. Trong step 2, global giao tiếp với local load balancer. Không có chuẩn giao tiếp nào trong step 2. Đó là các probe request để yêu cầu các local load balancer đo khoảng cách tới client. Hình 5.6 chỉ cho thấy hoạt động của local hên trái, bên phải thì cũng tương tự vậy. Trong step 3, client sử dụng một ICMP echo request và step 4 trả về một response ICMP. Local báo cáo kết quả tới global. Từ các response đó global xác định server tốt nhất cho client và gửi về chi client một response `302 Found` trong step 6. Client xem xét response đó và tiến hành truy cập tới server trong step 7.
<a name="5.2"></a>
## 5.2 Advanced Caching

Caching là một trong những cách phổ biến nhất để cải thiện hiệu năng HTTP. Mục nhỏ đầu tiên đưa ra ba cách khác nhau để thực hiện caching. Mục tiếp theo miêu tả công nghệ then chốt mà hỗ trợ các sự thực hiện đó.

### 5.2.1 Implementation Caching

Internet chứa nhiều thành phần tham gia-cá nhân, doanh nghiệp, Web site, nhà cung cấp dịch vụ, và nhiều thứ khác- hầu hết đều nhận được lợi từ caching. Mỗi thành phần sẽ có một cách hỗ trợ caching khác nhau. Các sự thực thi dựa trên các header http và các tùy chọn mà chương 3 mô tả, nhưng khác nhau về địa chỉ của các cache server và công nghệ bổ sung hỗ trợ các server đó. Bảng 5.2 tóm tắt các phương pháp đó; mỗi cái sẽ được miêu tả chi tiết trong phần còn lại của mục này.

>**Bảng 5.2: Implementation caching**

|Implementation|Lợi ích|Các công nghệ|
|--------------|-------|-------------|
|Proxy Caches|Các doanh nghiệp giảm băng thông được yêu cầu cho các kết nối Internet và cải thiện hiệu năng cho user|PAC, WPAD|
|Transparent Caches|Nhà cung cấp dịch vụ Internet giảm băng thông được yêu cầu cho các nhà cung cấp kết nối internet và cải thiện hiệu năng cho khách hàng|WCCP, NECP|
|Reverse Proxy Caches|Các web site giảm việc tải trên các web server và cải thiện hiệu năng cho user|ICP, HTCP, CARP|

Cách đơn giản dễ thự hiện nhất là proxy cache server. Proxy cache phổ biến nhất trong các doanh nghiệp và các tổ chức khác mà kết nối tới nhiều user trên Internet. Như hình 5.7 cho thấy, tổ chức triển khai proxy cache như là gateway vào kết nối Internet.

![Hình 5.7](http://i.imgur.com/FvBVZFr.png)

**Hình 5.7: Các tổ chức với các kết nối Internet có thể điều hành các proxy cache server của họ để cải thiện hiệu năng cho user của họ và để giảm băng thông mà kết nối Internet cần.**

Để khai thác proxy cache server, các user trong tổ chức chỉ dẫn cho các Web browser sử dụng proxy cho việc truy cập Internet. Tất các các Web browser phổ biến có khả năng nhận dạng một proxy server, hình 5.8 cho thấy màn hình cấu hình của IE.

![Hình 5.8](http://i.imgur.com/jm0EaTp.png)

**Hình 5.8: Các user cấu hình web browser để gửi các request tới một proxy server**

Được cấu hình đúng cách, các browser sẽ gửi http request tới proxy server. Nếu proxy chứa nội dung đã được lưu trước đó, như hình 5.9, nó sẽ trả về http response phù hợp cho client ngay lập tức.

![Hình 5.9](http://i.imgur.com/dvMR2bg.png)

**Hình 5.9: Nếu một proxy server có một bản sao tài nguyên trong local cache của nó, nó có thể phản hồi trực tiếp tới client mà không cần giao tiếp với server gốc.**

Chú ý rằng proxy cache servevr có thể trả về http respose phù hợp mà không cần gử lưu lượng qua Internet. Cách này không chỉ tiết kệm tiền của các tổ chức bằng việc giảm băng thông yêu cầu cho một kết nối Internet, nó còn cải thiện hiệu năng của user. Proxy cache có thể phản hồi tới user ngay lập tức, mà không có sự trì hoãn trong giao tiếp qua Internet.

Một trong các thách thức liên quan đến đến việc triển khai một proxy cache server là cấu hình phù hợp cho các web browser. Các browser cho phép các tổ chức cấu hình các dịch vụ proxy và phân bố các phiên bản được cấu hình trước trong tổ chức. Tuy nhiên, cấu hình trước không phải luôn luôn đơn giản và các user tải browser phiên bản mới nhất trực tiếp qua Internet một cách nhanh chóng. Một cách nữa dễ hiểu hơn dựa vào script Proxy Auro Configuration (pac) và Web Proxy Auto-Discovery Protocol(wpad). Một pac script là một file JavaScipt đơn giản với cấu hình giao thức đơn giản và wpad là một giao thức truyền tin đơn giản mà cho phép các browser tự động tìm ra và truy cập pac script lưu trên một mạng. Các mục nhỏ sau mô tả từng cái chi tiết.

Các nhà cung cấp dịch vụ internet (ISPS) có thể nhận ra lợi ích từ http caching. Hình 5.10 cho thấy một sự triển khai cache server; chú ý rằng cacher server nằm trên mạng của ISP thay vì của một tổ chức. Hình đó cũng cho thấy một kết nối Internet cho một doanh nghiệp hoặc các tổ chức khác làm nổi bật sự khác nhau giữa hình 5.7.

![Hình 5.10](http://i.imgur.com/ydXJ1JF.png)

**Hình 5.10: Các cache server "trong suốt" được quản lý bởi ISP thay vì các tổ chức user. Điều này tránh việc buộc các user phải cấu hình các browser với thông tin proxy server.**

Sự khác biệt nhất giữa hình 5.10 và hình 5.17 là dạng của cache server. Thay vì một proxy cache server, ISPS sử dụng các cache server "trong suốt". Lý do cho sự khác biệt đó là gánh nặng tổ chức. Không giống như một doanh nghiệp hay tổ chức, ISPS không thể dễ dàng ủy thác tất cả các cầu hình của Web user cấu hình proxy phù hợp trong các browser này. Hơn nữa, các PAC script (Proxy Auto Configuration) và giao thức wpad chỉ có tác dụng trong một mạng đơn, nên ISPS không thể có lợi từ việc sử dụng này.

Cache server "trog suốt" bù đắp cho những hạn chế đó. Như cái tên đã hàm ý, trong suốt nghĩa là user không thể nhìn thấy được. Web browser không cần các cấu hình đặc bệt để sử dụng cache trong suốt; đơn giản chúng truy cập từ xa các Web site. Key để vận hành cache trong suốt là sự hợp tác gữa router của ISPS và cache server. Như hình 5.11 cho thấy, mỗi truy cập router liên tục kiểm tra lưu lượng từ khách hàng của ISP, tìm kiếm các HTTP message. Khi router nhận ra một http message, nó gửi message tới cache serrver trong suốt. Nếu cache server có một bản sao nội dung nó cần, có phản hồi ngay lập tức như hình 5.11. Nếu không thì nó gửi request tới server gốc.

![Hình 5.11](http://i.imgur.com/3dWWwwz.png)

**Hình 5.11: Để bắt các request của user chuyển tới một cache server trong suốt, một router(switch) phải chuyển các request đó tới cache.**

Để có được hiệu quả cao cần có sự phối hợp giữa router và cache server. Web Cache Communication Protocol được quyền của Cisco (WCCP) là một cách cho sử phối hợp này; Network Element Control Protocol (NECP) mà một cái mới nhưng vẫn cùng chức năng.

Kiểu thứ ba của cache là reverse proxy cache, chuyền quyền kiểm soát tới các Web site. Các Web site không chỉ dựa trên các user và ISPS để cải thiện http caching. Reverse proxy caching cho phép các Web site kiểm soát các cache của chúng, độc lập với các user và ISPS.

Hình 5.12 cho thấy điều này. Web site hoặc một nhà cung cấp dịch vụ đóng vai trò là một Web site triển khai một mạng của reverse proxy cache server qua internet. Mạng càng rộng, thì chúng càng xa server gốc.

![Hình 5.12](http://i.imgur.com/iE1AOjy.png)

**Hình 5.12: Các Web site hoặc nhà cung cấp Web hosting triển khai một mạng của reverse proxy cache server qua Internet.**

Một khi cache server được đặt đúng vị trí, user có thể nhận được nội dung Web site trực tiếp từ cache gần nhất. Như hình 5.13 cho thấy, các user khác nhau giao tiếp với các cache server khác nhau, dựa trên vị trí của nó trên Internet.

![Hình 5.13](http://i.imgur.com/QC1wNkw.png)

**Hình 5.13: Với một mạng của reverse proxy cache server đặt đúng chỗ, một Web site user kết nối tới server gần nhất. Vì cache serverr càng gần client, chúng càng phản hồi nhanh. Các cache server cũng giảm gánh nặng cho server gốc, và chúng giảm cả băng thông.**

Chúng ta chú ý rằng global load balancer dựa trên nhiều Web site với Web serrver đầy đủ tính năng, trong khi reverse proxy server thiết bị đặc biệt cho caching. Các Web site cũng hỗ trợ global balancing điều hành bởi các tổ chức và nhà cung cấp Web hosting; mặc khác, reverse proxy cache chỉ có tác dụng nếu chúng được đặt trên mạng Internet của các nhà cung cấp.

Một khía cạnh của reverse proxy caching mà tạo ta sự khác biệt với các caching khác: nó dựa trên một mạng lưới các cache server. Thật vậy, càng nhiều server trong mạng lưới đó, reverse proxy cache càng trở nên có tác dụng.

Mạng lưới cache server cho phép nhiều caching phức tạp. Trong một sự triển khai cô lập, nếu cacher server không có bản sao cho request đó, nó chuyển tới serer gốc. Tuy nhên, một mạng lưới đưa ra các tùy chọn mới. Thay vì gánh bặng của server gốc cho nội dung mới, chúng truyền request tới các các cache server xung quanh nó.

Cisco cung cấp các chức năng như là một chuẩn giao thức như là Internet Cache Protocol (ICP) và Hyper Text Caching Protocol (HTCP).

### 5.2.2 Proxy Auto Configuraton Scripts

Một trong các vấn đề lớn xảy ra khi triển khai các proxy server là việc cấu hình các browser của user cho phù hợp. Hình 5.8 cho thấy một hộp thoại chuẩn cho IE. Thiết lập này đủ phức tạo cho user tìm kiếm và hiểu nó, nhưng hãy tưởng tượng những khó khăn nếu một cài đặt yêu cầu các thiết lập nâng cao. Hình 5.14 cho thấy điều đó.

![Hình 5.8]()

**Hình 5.8: Các user cấu hình Wev browser để gửi request tới proxy server thay vì tới trực tiếp qua Internet.**

![Hình 5.14](http://i.imgur.com/RjROUnR.png)

**Hình 5.14: Việc cấu hình có vẻ phức tạp.**

Để hỗ trợ các user từ việc cấu hình thủ công các thiết lập proxy, và giúp admin dễ dàng xác định cấu hình proxy hơn, Netscape tạo ra một khái niệm là Proxy Auto Configuration (pac) script. Các browser khác đều hỗ trojwj pac script. 

Định dạng pac là một file chứa JavaScript code. File có thể chứa nhiều hàm và biến, nhưng nó phải chứa hàm FindProxyfoURL(). Borowser sẽ gọi hàm này ra với hai tham số, url và host, trước khi nó lấy ra url. Tham số url chứa url mà browser muốn lấy ra, và tham số host chứa host name từ url đó.

Hàm FìnProxyfoURL() trả về một chuối đơn trong đó chứa các phương thức. Bảng 5.3 liệt kê. Chuỗi này tách các phương thức bằng dấu phẩy. Nếu chuỗi này trống, browser sẽ kết nối trực tiếp với server.

>**Bảng 5.3: Các tùy chọn PAC Retrieval**

|Các tùy chọn|Nghĩa|
|------------|-----|
|DIRECT|Kết nối tới host trực tiếp mà không sử dụng một proxy|
|PROXY host:port|Kết nối tới một proxy được chỉ định|
|SOCKS host:port|Nhận một URL từ SOCK server được chỉ định|

Một ví dụ về file pac ở bên dưới, trả về tên của một proxy server cho url.

```
function FindProxyForURL(url, host)
{
return "PROXY proxy.hundredacrewoods.com:8080";
}
```

Định dạng pac còn định nghĩa vài hàm nữa mà browser cung cấp. Các hàm này được liệt kê trong bảng 5.4 cung cấp tiện ích.

>**Bảng 5.4: Các hàm hỗ trợ của PAC**

|Hàm|Sử dụng|
|---|-------|
|isPlainHostName()|Chỉ ra nếu một host name không phải là một domain name.|
|dnsDonaminIs()|Chỉ ra nếu domain của một host name là một domain được chỉ định.|
|localHostOrDomainIs()|Chỉ ra nếu một host name giống với local name hoặc domain name.|
|isResolvable()|Chỉ ra nếu một host name được chuyển thành một địa chỉ IP.|
|isInNet()|Chỉ ra nếu một host name hoặc địa chỉ IP thuộc về mạng được chỉ định.|
|dsnRsolve()|Chuyển một host name thành một địa chỉ IP.|
|myIpAddress()|Trả về một địa chỉ IP của client browser.|
|dnsDomainLevelIs()|Chỉ ra level trong phân cấp DNS của một host name.|
|shExpMatch()|Chỉ ra nếu một chuỗi khớp với một biểu thức shell xác định.|
|weekdayRange()|Chỉ ra nếu ngày hiện tại trong giới hạn ngày trong tuần.|
|dateRange()|Chỉ ra nếu ngày hiện tại trong giới hạn xác định.|
|timeRange()|Chỉ ra nếu ngày hiện tại trong thời gian xác định.|

Ví dụ dưới đây về việc sử dụng các hàm hỗ trợ. 

```
function FindProxyForURL(url, host)
{
    if (isPlainHostName(host) ||
        dnsDomainIs(host, ".hundredacrewoods.com"))
        return "DIRECT";
    else
        return
        "PROXY proxy.hundredacrewoods.com:8080";
}
```

Một khi admin mạng tạo ra một pac script, các user cấu hình browser để để định vị và nhận lấy script từ một server trên mạng. Browser cho phép các user xác định địa chỉ của pac script qua một url, như hình 5.15 cho thấy.

![Hình 5.15](http://i.imgur.com/CCiGXjs.png)

**Hình 5.15: Để đơn giản hóa cấu hình proxy server, user có thể yêu cầu browser tự động nhận lấy cái thiết lập cấu hình proxy từ một mạng server. Hộp thoại này báo cho browser nơi để tìm ra PAC script của nó.**

### 5.2.3 Web Proxy Auto-Discovery

Các script Proxy Auto Configuration cho phép các quản trị viên mạng che đi sự phức tạp của cấu hình proxy từ các user như hình 5.15, nhưng các user đó vẫn phải cấu hình trình duyệt của họ với url cho pac script. Để đơn giản hóa cấu hình proxy hơn nữa, các browser mới hỗ trợ công ngệ được biết đến là Proxy Auto-Discovery (wpad). Với wpad, các browser tìm ra địa chỉ của các pac script một cách tự động mà không cần cấu hình của user.

Mặc dù nó thường được gọi là giao thức, wpad không phải là một giao thức giao tiếp tách rờ. Nó là một bộ quy tắc cho việc sử dụng các giao thức hiện tại. Mỗi giao thức này cung cấp một địa chỉ pac script; wpad xác định một thử tục nhất quán và rõ ràng cho việc sử dụng chúng.

>**Bảng 5.5: Các quy tắc của Web Proxy Auto-Discovery**

|Step|Sử dụng|Thủ tục|
|----|-------|-------|
|1|Bắt buộc|Kiểm tra một địa chỉ PAC (code tùy chọn 252) trong một Dynamic Host Configuration Protocol(DHCP) message.|
|2|Tùy chọn|Truy vấn cho một địa chỉ PAC sử dụng Server Locaton Protocol (SLP).|
|3|Bắt buộc|Truy vấn Domain Name System (DNS) cho bản ghi address(A) cho wpad.target.domain.name.com, nơi target.domain.name.com là tên domain của client.|
|4|Tùy chọn|Truy vấn DNS cho bản ghi server(SVR) cho  target.domain.name.com|
|5|Tùy chọn|Truy vấn DNS cho giản ghi text(TXT) cho  target.domain.name.com|
|6||Bỏ đi thành phần bên trái ngoài cùng và lặp lại step 3-6, tiếp tục cho đến khi tên miền đặt đến cái tên ngắn nhất.|

Khi một client có được địa chỉ của pac scipt của nó sử dụng thủ tục wpad, thông tin chưa hoàn chỉnh. Ví dụ, DNS có thể trả về một host name hoặc address, nhưng nó không thể cung cấp một giao thức, port hay path. Để hoàn thiện thông tin bị mất, wpad clien sử dung các giá trị từ bảng 5.6

>**Bảng 5.6: Các giá trị mặc định cho địa chỉ PAC từ WPAD**

|Thành phần|Gía trị mặc định(Nếu không được nhận qua WPAD)|
|----------|----------------------------------------------|
|Protocol|http|
|Host|No mặc định; được lấy từ thủ tục WPAD.|
|Port|80|
|Path|/wpad.dat|

Một khi client tạo ra url hoàn chỉnh cho PAC script của nó, nó nhận lại pac script và cấu hình proxy một cách phù hợp. Trong quá trình nhận lại, client có thể nhận lại nhiều http header, ví dụ như chứa expiration time cho pac script. Client nên tôn trọng tất cả các http header mà phù hợp với pac script. Ví dụ, nếu script hết hạn, client nên khởi động lại toàn bộ quá trình wpad. Nó không chỉ đơn giản là tái sử dụng pac url được tìm ra trước đây.

Phiên bản mới nhất của các browser mặc định sủ dụng wpad để tìm ra cấu hình proxy. Hình 5.16 cho thấy điều đó.

![Hình 5.16](http://i.imgur.com/gkrjBuQ.png)

**Hình 5.16: Web browser hiện đại có thể tự động tìm ra các thiết lập cấu hình proxy. Hộp thoại cho phép user bật hoặc tắt Web Proxy Auto-Discovery.**

### 5.2.4 Web Cache Communicaton Protocol

Web Cache Communicaton Protocol (wccp) là một giao thức quan trọng cho việc hỗ trợ caching trong suốt. Các hệ thống Cisco phát triển wccp như một cách để các router hiểu được sử tồn tại của các cache server và hiểu được việc chuyển hướng các http request tới các cache đó như thế nào.

Hình 5.17 cho thấy môi trường nơi mà wccp hoạt động.Các nhà cung cấp dịch vụ internet triển khai một hoặc nhiều cache server trên cùng mạng với các router. Các router cung cấp kết nối tới các khách hàng của ISP, và các http request từ các client truyền qua các router. Tất nhiên, mục đích chính của các router là tìm ra các http request và chuyển hướng chúng tới các cache server. Router và cache server có thể sử dụng WPAD.

![Hình 5.17](http://i.imgur.com/nZj8QF6.png)

>**Bảng 5.7 tổng hợp ba dạng của message mà WCCP định nghĩa**

|Message|Sử dụng|
|-------|-------|
|WCCP_HERE_I_AM|Một cache server gửi message này tới một router để xác thực nó với router|
|WCCP_I_SEE_YOU|Router thừa nhận sự hiện diện của một cache server với message này; nó cung cấp cấu hình WCCP hiện tại.|
|WCCP_ASSIGN_BUCKETS|Một cache server báo cho router biết chuyển hướng lưu lượng http như thế nào, chỉ ra mỗi cache server nhận được bao nhiêu.( trong cùng một chu kỳ.)|

Qúa trình phối hợp bắt đầu khi một cache server gửi một wccp_here_i_am message  tới một router. Router phản hồi với một wccp_i_see_you message, và cache server xác nhận giao tiếp bằng cách gửi một wccp_here_i_am message. Hình 5.18 mô tả quá trình này. Message thứ ba quan trọng bởi vì nó xác nhận rằng không chỉ server gửi message tới router mà nó còn nhận các message từ router. Server xác nhận điều này bằng cách cập nhật một trường trong wccp_here_i_am của nó để phản hồi thông tin từ  wccp_i_see_you mà nó nhận được.

![Hình 5.18](http://i.imgur.com/fah9xlS.png)

**Hình 5.18: Cache server báo cho router là nó vẫn đang hoạt động và router phản hồi lại với wccp_i_see_you**

Các cache server tiếp tục gửi wccp_here_i_am message cho dù router đã nhận ra chúng. Router sử dụng các message đó để xác định nếu một cache server vẫn còn hoạt động. Nếu cache server không nhận được một wccp_here_i_am message trong một thời gian, router xem như cache server đó ko còn dùng được nữa.

![Hình 5.19](http://i.imgur.com/WpD94bC.png)

**Hình 5.19: Một cache server báo cho router biết phân chia các request qua các cache như thế nào Router biết được sự gán này trong WCCP message tới các cache server.**

Một khi router biết được sự tham gia của các cache server, các server đó có thể báo cho router làm sao để chuyển hướng lưu lượng http. Một cache server làm điều đó với một wccp_assign_buckets message, hình 5.19 minh họa. wccp_i_see_you message từ router xác nhận việc gán bằng cách chứa một bảng chuyển hướng rõ ràng. Mặc dù các router chấp nhận wccp_assign_buckets từ cache server, nói chung chỉ có server kiểm soát sự chuyển hướng. Như hình 5.19 mô tả, router xác nhận sự chuyển hướng với các wccp_i_see_you message tới tất cả các server. (Server ở trong trường hợp này là cache server).

Một khi sự chuyển hướng đoạt động, router chặn tất cả lưu lượng tới port 80. Nó tình toán một hash trên một địa chỉ IP đích, kết quả nằm trong khoảng từ 0 dến 255. Dựa vào giá trị này và wccp_assign_bucket message từ cache server, router xác định lưu lượng một cache server. Cách khác, wccp_assign-buckets message chỉ ra rằng lưu lượng với một giá trị hash không được chuyển hướng nhưng được chuyển đến một đích đến thực sự. Lưu lượng mà được chuyển hướng được đóng gói theo Generic Routing Encapsulation (gre) sử dụng số giao thức 883e(mã thập lục phân). wccp_assign_buckets phân bố ngẫu nhiên lưu lượng tới bộ các cache server.

### 5.2.5 Network Element Control Protocol

Network Element Control Protocol giúp các cache server giao tiếp với các router, các switch, và các yếu tố mạng khác. 

Khác biệt đáng kể giữa necp và wccp là mecp cho phép các cache server chỉ ra lưu lượng nào được chuyển hướng. Server xác định giao thức ( thường là tcp hoặc udp) và cổng đích đến. Ngược lại, wccp luôn luôn chuyển hướng lưu lượng tới cổng 80.

NECP cho phép các server chỉ rõ những ngoại lệ, lưu lượng mà không được chuyển hướng, cho dù nó khớp với request chuyển hướng. Các cache server nhận ra các ngoại lệ bằng sử gộp lại của tài nguyên lưu lượng ( bằng địa chỉ IP hoặc mặt nạ mạng), đích đến, giao thức, và port.

Nâng cấp cuối cùng thật sự quan trọng; necp chứa các cơ chế để bảo mật giao tiếp giữa các network element và các cache server. Đặc biệt, tất cả các message giữa hai hệ thống chứa chứng chỉ xác thực dựa trên một giá trị đặc biệt (như là password) được chia sẻ bởi server và network element. Các cơ chế này ngăn ngừa kẻ giản hijacking giao tiếp bằng việc chuyển hướng lưu lượng. 

Không giống như wccp, necp hỗ trợ các network element cùng với các router, đặc biệt là switch. Như hình 5.20 cho thấy, các cache server nằm gần các network element.

![Hình 5.20](http://i.imgur.com/SUMTjpz.png)

**Hình 5.20: Các network element ở đây là các switch hay csac network access server(cùng ý nghĩa). Giao thức phối hợp cùng với các cache server.**

Khi một cache server bắt đầu hoạt động, nó tạo ra một kết nối tcp với network element và gửi một necp_init message, như hình 5.21. Network element phản hồi với một necp_int_ack. Các hệ thống duy trì kết nối tcp; chung sử dụng cho các trao đổi message sau này.

![Hình 5.21](http://i.imgur.com/v2ZqKI6.png)

**Hình 5.21: Các cache serveer giới thiệu chúng tới các network element với một trao đổi NECP_INIT. Cache server bắt đầu trao đổi dữ liệu trong step 1 và network element nhận ra được nó trong step 2.**

necp xác định một tổng cộng 16 message khác nhau được liệt kê trong bảng 5.9. Các message này được sử dụng theo cặp.

>**Bảng 5.9: MECP Messages**

|Message|Sử dụng|
|-------|-------|
|NECT_INIT|Một server chỉ ra một network element đang hoạt động.|
|NECP_INIT_ACK|Một network element thừa nhận sự khởi đọng của một server.|
|NECP_KEEPALIVE|Hệ thống truy vấn các hệ thống khác xem còn hoạt động hay không.|
|NECP_KEEPALIVE_ACK| Một hệ thống phản hồi tới việc truy vấn đó.|
|NECP_START|Một server yêu cầu một network element bắt đầu chuyển lưu lượng tới nó.|
|NECP_START_ACK| Một network element thừa nhận request chuyển tiếp.|
|NECP_STOP| Một server yêu cầu một network element ngưng chuyển lưu lượng.|
|NECP_STOP_ACK| Một network element thừa nhận một request của server cho việc ngưng chuyển tiếp.|
|NECP_EXCEPTION_ADD|Một server xác định một ngoại lệ cho việc chuyển tiếp lưu lượng.|
|NECP_EXCEPTION_ADD_ACK| Một network element thừa nhận ngoại lệ đó.|
|NECP_EXCEPTIO_DEL| Một server xóa một ngoại lệ cho việc chuyển tiếp lưu lượng.
|NECP_EXCEPTION_DEL_ACK| Một network element thừa nhận việc xóa đi đó.|
|NECP_EXCEPTION_RESET| Một server yêu cầu xóa tất cả các ngoại lệ chuyển tiếp lưu lượng xác định bởi server.|
|NECP_EXCEPTION_RESET_ACK| Một network element thừa nhận việc xóa trên.|
|NECP_EXCEPTION_QUERY|Một server yêu cầu xem tất cả các ngoại lệ chuyển tiếp lưu lượng.|
|NECP_EXCEPTION_RESP| Một network element trả về tất cả các ngoại lệ chuyển tiếp lưu lượng.|

Để bảo đảm mọi thứ đều hoạt động, cả hai hệ thổng gửi necp_keepalive message định kỳ cho nhau. Một hệ thống nhận được message này trả lời với một necp_keepalive_ack, một trong hai hệ thống có thể bắt đầu sử trao đổi này, hình 5.22 cho thấy network element bắt đầu sự trao đổi.

![Hình 5.22](http://i.imgur.com/bVZg6uv.png)

**Hình 5.22: Các hệ thống NECP duy trì kết nối TCP bằng cách gửi MECP_KEEPALIVE định kỳ; sự trao đổi này cũng đảm bảo mọi thứ đều hoạt đồng bình thường.**

Với mỗi necp_keepalive message, người gửi (ở đây là các hệ thống) có thể chứa một danh sách bộ giao thức và port. Nhờ đó, người gửi yêu cầu các server đồng cấp báo cáo tình trạng của các dịch vụ. Ví dụ, một truy vấn cho tình trạng của tcp port 80 sẽ yêu cầu một cache server cho tình trạng của dịch vụ http của nó. Một hệ thống được truy vấn phản hồi trong necp_keepalive message. Đặc tả necp hiện tại chỉ xác định một tiêu chuẩn chung, một số nằm giữa 0 và 100 cho mỗi dịch vụ. 

![Ví dụ](http://i.imgur.com/5rfCL0h.png)

Một khi hai hệ thống tạo ra một kết nối và trao đổi các message khởi tạo, server có thể yêu cầu network element bắt đầu chuyển hướng lưu lượng tới nó. Server làm điều đó với necp_start message, và network element thừa nhận với một necp_start_ack message như hình 5.23 minh họa.

![Hình 5.23](http://i.imgur.com/tmG3wJv.png)

**Hình 5.23: NECP_START message chứa một danh sách các dịch vụ mà network element bắt đầu chuyển hướng tới cache server. Với tất cả các NECP message, hệ thống nhận ( trong trường hợp này là cá network element ) thừa nhận với một response.**

necp_start message chứa một danh sách các dịch vụ mà network element mà network element bắt đầu chuyển hướng tới cache server. Các dịch vụ được định dạng bởi protocol identifier (tpc hoặc udp) port đích. Cache server cũng chỉ ra một phương thức chuyển tiếp cho mỗi dịch vụ. Các tùy chọn chứa layer 2 forwarding (nơi mà các packet  được chuyển trực tiếp tới server) Generic Routing Encapsulation ( cùng một cách được sử dụng bởi wccp) hoặc layer 3 forwarding ( nơi mà network element thay đổi địa chỉ IP của các packet bằng IP của các server). 

necp_stop message tạm dừng chuyển hướng lưu lượng. Network element thừa nhận message này bằng việc trả về một necp_stop_ack message.

Network element không chuyển hướng các lưu lượng loại trừ tới cache server nhưng thay vào đó nó gửi trực tiếp tới đích đến cụ thể.

Để báo cho network element về một loại trừ, một server gửi cho nó một necp_exception_add message, và network element phản hồi với một necp_excepton_add_ack message . Hình 5.24 minh họa điều này. Một message có thể liệt kê vài loại trừ, mỗi cái được xác định bởi các tham số mà bảng 5.10 liệt kê.

![Hình 5.24](http://i.imgur.com/glh3URn.png)

**Hình 5.24:  Cache serer có thể liệt kê các loại trừ cho các dịch vụ chuyển hướng trong NECP_EXCEPTION_ADD message. Network element ngừng chuyển hướng cho những ngoại lệ này.**

>**Bảng 5.10: Các tham số của mỗi loại trừ**

|Tham số|Ý nghĩa|
|-------|-------|
|Scope Advisory|Chỉ ra ngoại lệ này chỉ áp dụng cho lưu lượng mà được chuyển đến server này hay ngoại lệ áp dụng cho tất cả lưu lượng mà truyền qua network element; Ví dụ, network element có thê bỏ qua một phạm vị toàn cục nếu server không tin tưởng vào cache server.|
|TTL| Khoảng thời gian(tính bằng giây) mà loại trừ được cho là phù hợp; nếu khoảng thời gian này trôi qua mà không có sự cập nhật từ server, network element coi như loại trừ đó hết hạn.
|Source IP Address|Tài nguyên địa chỉ IP cho lưu lượng loại trừ.|
|Source Address Netmark|Một mark chỉ ra các bit trong source address IP liên quan đến lưu lượng loại trừ.(Ví dụ, một source address 192.168.0.0 và netmark 255.255.0.0 có nghĩa là các packet với một source address là 192.168.x.x, x là các giá trị được coi là lưu lượng ngoại lệ).|
|Destination IP Address|Đích đển địa chỉ IP cho lưu lượng ngoại lệ.|
|Destination Address Netmark|Một mark chỉ ra các bit trong đích đến IP address liên quan đến lưu lương ngoại lệ.|
|Protocol Identifier|Nhận dạng giao thức cho lưu lượng ngoại lệ, thường là UDP hoặc TCP.|
|Destination Port Number|Số cổng của đích đến cho lưu lượng ngoại lệ( ví dụ 80 cho HTTP ).|

Server xóa đi các loại trừ bằng việc gửi necp_exception_del message tới network element. Một network element thừa nhận điều này với một  necp_excepton_del_ack message. Một server cũng có thể xóa tất cả các ngoại lệ trong một necp_exception-reset message và network element thừa nhận điều này với một necpexception_reset_ack.

Server cũng có thể truy vấn một network element để tìm ra loại trừ nào mà network element "có hiệu lực". Message làm việc đó là necp_exception_query và response của network element được chứa trong một necp_exception_resp.

Trong message truy vấn server tinh chỉnh bộ các ngoại lệ bằng cách xác định các tham số ngoại lệ, cũng như địa chỉ IP của server mà khởi tạo ra ngoại lệ. Nếu một server bỏ qua địa chỉ của "người" tạo ra ngoại lệ, hoặc nếu nó xác định mổ địa chỉ khác với cái của nó, server có thể tìm ra các ngoại lệ được cài đặt bởi các cache server khác.

Một đặc điểm quan trọng của tất cả các request mà server tạo thành các network element là ảnh hưởng của chúng đến các phiên lưu lượng hiện có. Các request bắt đầu hay kết thúc việc chuyển hoặc thêm hoặc xóa các ngoại lệ, không ảnh hưởng đến các phiên đã hoặc đang tiến hành. Ví dụ, nếu một client bắt đầu http session với một đích đến thực sự, một request của cache server để nhận lưu lượng http được chuyển hướng sẽ không ảnh hướng đến session của client đó. Các session mới bắt đầu bởi client này (hoặc client khác) sẽ được được chuyển đi đúng cách nhưng các session đang tồn tại tiếp tục không thay đổi.

Việc này tạo ra 2 tác động tới network element và các cache server. Đầu tiên, network element theo dõi các user session mà truyền qua chúng. Yêu cầu này tạo ra một gánh nặng cho network element. Thứ hai, một cache server không nên đột ngột dừng hoạt động này. Cách khác tốt hơn là server ngưng hỗ trợ các session trong tương lại và chỉ hỗ trợ các session đạng tồn tại cho đến khi nó kết thúc - cung cấp dịch vụ tốt hơn cho user.

Có lẽ khía cạnh quan trọng nhất của necp là việc hỗ trợ bảo mật của nó. Với necp, các cache server và network element thương lượng việc sử dụng các chứng thực trên tất cả các message mà chúng trao đổi. Thủ thục chứng thực dựa trên một giá trị bí mật mà network element và cache server chia sẻ. Nó là mật khẩu của network element mà một cache server phải biết trước khi message của nó được chấp nhận bởi network element.

Hình 5.25 mô tả quá trình này. Khi một network element nhận một message chứng thực, nó thực hiện cùng các tính toán mật mã digest. Nếu kết quả không khớp thì message bị từ chối.

![Hình 5.25](http://i.imgur.com/nbkQOqi.png)

**Hình 5.25: Để ngăn các thành phần nguy hiểm kiểm soát một network element ( và "hijacking" session truyền qua nó), network elemnt và các cache server của nó chia sẻ một password bí mật. Tất cả các hệ thống gộp password này với NECP message để tạo ra mật mã digest.**

### 5.2.6 Internet Cache Protocol

Đã từ lâu chúng ta tìm hiểu các giao thức mà các cache server sử dụng để giao tiếp với các client và các với các network element như là các router. Tương tự là việc các cache server giao tiếp với nhau như thế nào. Chuyện gì sẽ xảy ra khi một client request một object mà cache server không có bản sao trong bộ nhớ. Tất nhiên, cache server request object từ server gốc, nhưng điều đó không phải là một cách tối ưu. Nó có thể request từ các cache server gần đó để có được object, và việc request  nó từ cache server đó sẽ nhanh hơn là server gốc. Tuy nhiên, một cache server phải trả lời hai câu hỏi trước khi nó có thể tận dụng ưu điểm này. Đầu tiên, làm sao nó biết được server nào có bản sao object đó? Thứ hai, nếu nhiều server có bản sao đó, làm sao nó có thể xác định cái nào gần nhất?. Internet Cache Protocol (ICP) sẽ cung cấp câu trả lời cho hai câu hỏi trên.

Internet Cache Server là một giao thức đơn giản. Nó được thiết kế đặc biệt cho việc triển khai như hình 5.26. Trong hình đó, http GET request của user di chuyển đến cache server a. Server đó không có obejct, nên nó đồng thời gửi 3 message. Nó gửi các truy vấn ICP tới mỗi cache server nó, và nó gửi một icp echo message tới Web server.

![Hình 5.26](http://i.imgur.com/UCpBUtc.png)

**Hình 5.26: Một cache server  sử dụng Internet Cache Protocol để truy vấn các cache server khác. Đồng thời, nó gửi một echo message tới server gốc.**

Khi các cache server và server gốc nhận các icp message này, chúng phản hồi như hình 5.27. Response đầu tiên từ Cache Server b. Response đó chỉ ra rằng Server b không có bản sao object. Response tiếp theo, từ Cache Server c, chỉ ra rằng Server c có bản sao object. Response cuối cùng từ server gốc.

![Hình 5.27](http://i.imgur.com/PUE61ig.png)

**Hình 5.27: Các cache server phản hồi tới các truy vấn ICP với một sự xác nhận về tồn tại của các bản sao object. Server gốc phản hồi tới echo request ( bởi vì nó luôn có bản sao của object). Trong ví dụ này, cache server B phản hồi đầu tiên nhưng nó chỉ ra một cache miss. Cache server C là phản hồi tiếp theo, và nó có bản sao của object.**

Với các response này, Cache Server a biết rằng Server c có bản sao của object và Server c có thể phản hồi nhanh hơn server gốc. Vì thế, Server a muốn có object nhanh nhất thì lấy từ Server c. Như hình 5.28 cho thấy, Server a làm điều đó và trả về object được request cho client.

![Hình 5.28](http://i.imgur.com/gXBIOUL.png)

Một trong các giả thuyết quan trong nhất bên cạnh ecp là truy vấn icp troa đổi rất nhanh. Mặt khác, thời gian sẽ được tiết kiệm. Vì lý do đó, các icp message ngắn, đơn giản, và được thực hiện trong các tham số udp thay vì kết nối tcp.

Bảng 5.11 liệt kê các dạng icp message và cách sử dụng. ICP là giao thức đơn giản và không phức tạp trong cách hoạt động của nó. Một tính năng bổ sung mà không rõ ràng trong bản là thơi gian thực hiện hết một vòng. (Là thời gian từ rúc client gửi message cho đến khi nó nhận được object, không bao gồm thời gian nhận đầy đủ dữ liệu). Khi một cache server gửi một truy vấn icp, nó yêu cầu các người phản hồi báo cáo thời gian thực hiện hết một vòng tới server gốc. Gía trị này cho phép việc request của server ước tính khoảng thời gian cần thiết cho các server nhận được object mà chúng không có bản sao trong bộ nhớ.

![Round-trip time](http://i.imgur.com/I167u0l.png)

>**Bảng 5.11: Các ICP message**

|Dạng|Sử dụng|
|----|-------|
|Query|Hỏi nếu "người nhận" có bản sao của object, xác định bởi một URL, trong bộ nhớ của nó; message này cũng chứa địa chỉ IP của người request ban đầu(HTTP client) và một chỉ dẫn cho biết người gửi muốn nhận toàn bộ object được request trong ICP response.|
|Hit|Một response khả thi cho một truy vấn; người gửi có bản sao của object.|
|Hit/Object|Không chỉ người gửi có bản sao object được request, nó còn bao gồm object trong response.|
|Miss|Một response không khả thi cho một truy vấn; người gửi không có bản sao của object.|
|Miss/No Fetch|Người gửi không có bản sao object được request và người nhận không tìm nó.|
|Denied|Người gửi không muốn cung cấp object được yêu cầu.|
|Error|Người gửi không hiểu một truy vấn nó nhận được.|
|Echo|Một ICP message giả mà được gửi bởi UDP echo port của một hệ thống mà không hiểu ICP; có hai phiên bản của mesage này, một cái dành cho server gốc và cái còn lại dành cho các cache server.|

### 5.2.7 Hypet Text Caching Protocol

HTCP giải quết một số thiếu sót của ICP, và nó bổ sung thêm vài chức năng. Với HTCP, các cache server có thể thăm dò nội dung của các cache server khác để tìm ra nếu một object được lấy ra nhanh hơn là lấy từ server gốc. Không giống như ICP, HTCP cho phép server gửi chứa một bản sao của tất cả các http header trong request ban đầu của client, nên các server phản hồi có thể xác định chính xác hơn nếu bản sao của nó phù hợp với client. Ngoài ra, htcp cho phép các cache server giám sát nội dung của nhau; với đặc điểm này chúng báo khi một "hàng xóm" bổ sung các object mới, chỉ sửa hoặc xóa. Thông qua HTCP, các server cũng có thể chỉnh sửa nội dung của các cache server khác, bổ sung hoặc xóa. Bởi vì htcp được sử dụng để chỉnh sửa nội dung của một local cache server, các message của nó chứa các thông tin xác thực để xác nhận danh tính người gửi.

Bảng 5.12 liệt kê các dạng khác nhau của htcp message. Trái ngược với ICP, HTCP không chiaw các ACK(acknowledge) message. Mỗi message chứa một flag mà chỉ ra nó là response hay request.

>**Bảng 5.12: Các HTCP message**

|Dạng|Sử dụng|
|----|-------|
|NOP|No operation (Không hoạt động), mặc dù, mặc dù điều này có thể được sử dụng để thăm dò round-trip time giữa các server.|
|TST|Test, sử dụng để xác định nếu một object có trong local cache server.|
|MON|Monitor, sử dụng để ghi lại các hoạt động trong một local cache server; một MON request chỉ ra một monitoring session.|
|SET|Gửi thông tin về một object tới một cache server, ví dụ chứa cache được cập nhật hoặc các header thời hạn.|
|CLR|Clear, chỉ dẫn một server để xóa một object từ  local cache của nó.|

Trao đổi Test giống như truy vấn của ICP. Như hình 5.29 cho thấy, một cache server bắt đầu quá trình khi object không có trong local cache của nó. Server đó gửi đồng thời các TST request tới tất cả các "hàng xóm" của nó, chứa cả object được yêu cầu và các http header trong request gốc của client. Trong ví dụ của hình này, server b trả lời với một tst response chỉ ra rằng object không có trong local cache của nó, trong khi TST message của server c chỉ ra rằng nó có bản sao. Với thông tin này, cache server a có thể gửi http request tới server c để request object.

![Hình 5.29](http://i.imgur.com/BcrNIZ0.png)

**Hình 5.29: Một cache server gửi các HTCP TST message tới các cache server khác để định vị một tài nguyên gần nhất cho một object được request.**|

HTCP TST response không chỉ cho biết liệu người gửi có bản sao của object hay không; mà nó còn cung cấp thông tin về object. Đáng chú ý nhất là, response cho biết http method, uri, version và các header sử dụng để request object, cũng như các http header được chứa trong response của server gốc. TST response cũng chứa các thông tin cache đặc biệt được liệt kê trong bảng 5.13.

>**Bảng 5.13: Cache Information HTTP cung cấp**

|Item|Ý nghĩa|
|----|-------|
|Cache-Vary|Nội dung của một object xác thực dựa trên giá trị các head http.|
|Cache-Location|Các cache server được chỉ ra chứa một bản sao của object này.|
|Cache-Policy|Object không thể cache hoặc share giữa các cache server, hoặc nội dung của nó thay đổi dựa trên HTTP cockie.|
|Cache-Flags|Server không biết tất cả các HTTP response header mà áp dụng cho object.|
|Cache-Expiry|Object hết hạn tại một thời điểm nhất định|
|Cache-MD5|Kiểm tra mật mã của nội dung object.|
|Cache-to-Origin|Thời gian round-trip tới server gốc.|

Một tính năng đặc biệt là cho phép cache server giám sát nội dung dung của local cache của server. Ví dụ, một cache server mà xa so với server gốc, có thể giám sát các các cache server khác. Local cache server nếu đạt giữa các cache server và server gốc có thể giám sát tất cả request của các object. Các cache server ở xa có thể gửi các HTCP MON  để giám sát object.

Hình 5.30 cho thấy điều này. Qúa trình bắt đầy khi server ở xa gửi một HTCP MON request tới local cache server. Request này xác định một kênh thông qua local cache server để thông báo cho các cache server ở xa biết các thay đổi về nội dung cache. MON request chứa một khoảng thời gian cho kênh. Nếu cache server ở xa không làm mới lại kênh (với MON request khác) trong thời gian đó, việc cập nhật cache từ local server sẽ bị ngưng lại.

![Hình 5.30](http://i.imgur.com/nwMgl2t.png)

**Hình 5.30: HTCP cho phép một cache server giám sát các nội dụng của các cache server khác. Nếu nội dung trên local cache server thay đổi, nó gửi MON response tới cache server ở xa.**

Một khi kênh được tạo ra, local cache server gửi một MON response tới server ở xa mỗi khi nội dung bị thay đổi. Mỗi MON response chứa thời gian còn lại của kênh. Bảng 5.14 liệt kê nội dung bên trong MON response.

>**Bảng 5.14: HTCP MON Response**

|Trường|Ý nghĩa|
|------|-------|
|TIME|Kênh giám sát duy trì trong thời gian bao nhiêu giây.|
|ACTION|Kênh mà có trong local cache. 0 Một object được thêm vào cache. 1 Một object được làm mới lại. 2 Một object được thay thế. 3 Một object bị xóa đi.|
|REASON|Lý do cho các kênh. 0 Lý do không xác định. 1 Client truy vấn(lấy ra) object. 2 Client truy vấn object mà không được cho phép. 3 Cache server truy vấn trước object. 4 Object hết hạn, theo header của nó. 5 Object đã được thanh lọc để tiết kiệm không gian cache.|
|IDENTITY|Object trong local cache mà thay đổi. 'METHOD' phương thức HTTP sử dụng để truy cập object. 'URI' URI của object. 'VERSION' Phiên bản http sử dụng để truy cập object. 'REQ-HDRS' Các http header chứa trong request cho object. 'RESP-HDRS' Các header chứa trong response cho object. 'ENTITY-HDRS' Các header áp dụng cho object. 'CACHE'HDRS' Cache thông tin về object.| 

Trao đổi HTCP MON cho phép một cache server yêu cầu các cập nhật từ các cache server khác. Giao thức cũng hoạt động ngược lại. Không cần lời mời, các cache server có thể báo cho các server khác để chỉnh sửa cache. Các message tới các server đó là `set` các `clr`. Như hình 5.31 cho thấy, thậm chí cả server gốc cũng hỗ trợ cập nhật các cache server. Các set và clr message là các công cụ mà server gốc sử dụng để làm điều đó. Ví dụ, ột set message cập nhật các header mà tương ứng với một object chứa thời hạn của nó. Một clr message yêu cầu cache server xóa object từ bộ nhớ cache.

![Hình 5.31](http://i.imgur.com/1dIiWbN.png)

**Hình 5.31: Server gốc có thể sử dụng HTCP để chủ động cập nhật các cache server, ví dụ, báo cho chúng biết khi nào các header HTTP tương ứng với các object bị thay đổi.**

Bởi vì các set và clr message cho phép một hệ thống bên ngoài chỉnh sửa nội dung của một cache server, điều quan trọng là có thể xác minh danh tính của hệ thống mà gửi các message đó. Để xác minh điều đó, htcp có một cơ chế để xác thực danh tính hệ thống. Cách này giống với NECP. Các hệ thống giao tiếp đầu tiên phải chia sẻ một giá trị bí mật. Một hệ thống gửi bổ sung nội dung của message vào một key bí mật, tính toán một mật mã digest. Hệ thống nhận tiến hành cùng sự tính toán đó và đảm bảo rằng kết quả digest khớp nhau. Nếu không khớp, hệ thống nhật từ chối message.

### 5.2.8 Cache Array Routing Protocol

Một giao thức khác có thể nâng cấp hiệu năng của http caching là Cache Array Routing Protocol (CARP). Giao thức này cho phép một tập hợp các cache server điều phối nội dung cache để sử dụng các tài nguyên cache hiệu quả hơn. Môi trường đặc biệt cho CARP, trong hình 5.32, hơi khác so với các cầu hình mà chúng ta từng thấy trước đây. Môi trường này giả định một tập hợp các cache server cùng nằm chung với nhau và được gọi là trang trại server. Hình đó cho thấy một trang trại server nằm bên cạnh một proxy server; các nguyên tác tương tự áp dụng cho một trang trị cache server được triển khai phía sau một cache trong suốt trên cơ sở của ISP(Internet Service Provider).

Nếu trang trị cache server hoạt động hiệu quả nhất, không có object nào được lưu trong nhiều hơn một cache server. Ngoài ra, hệ thống mà như là cổng vào trang trại server(proxy server trong hình 5.32) sẽ biết được cache server nào có object . Cache Array Routing Protocol làm cả hai việc này.

![Hình 5.32](http://i.imgur.com/NZkLcXX.png)

**Hình 5.32: CARP đưa ra một bộ qui tắc mà điều phối hoạt động của tập hợp các cache server, đặc biệt là tránh việc dư thừa cache.**

Thật thú vị, CARP không phải là một giao thức giao tiếp. Không có thông tin nào được trao đổi giữa cổng vào (proxy server) và các cache server hoặc giữa các cache server. Thay vào đó, CARP là một bộ các qui tắc cho cổng vào để làm theo. Các qui tắc chứa một file cấu hình mảng và một thuật toán định tuyến. File cấu hình báo cho cổng vào (proxy server) cache server nào có sẵn (phù hợp), và thuật toán định tuyến  báo cho cổng vào cache server được truy vấn. cho một object.

Chú ý rằng các cache server không tự làm gì để hỗ trợ CARP. Chúng chỉ hoạt động như các server thông thường. Khi một request cho một object không có trong local cache, server sẽ lấy nó và sau đó bổ sung vào cache. CARP quan trọng nhất là thuật toán định tuyến. Cổng vào (proxy server) sử dụng nó để tìm ra chính xác cache server cho object. Các request cả client sau này cho một object sẽ được chuyển đến cache server đã lấy ra object đó.

Cổng vào (proxy server) đọc file cấu hình CARP khi nó bắt đầu hoạt động. File chứa các thông tin toàn cục được liệt kê trong bảng 5.15 và một danh sách các cache server.

>**Bảng 5.15: Thông tin toàn cục trong cấu hình CARP**

|Trường|Sử dụng|
|------|-------|
|Version|Phiên bản hiện tại của CARP là 1.0|
|ArrayEnabled|Cho biết liệu CARP có hoạt động trên server không.|
|ConfigID|Một số đặc biệt được sử dụng để ghi lại các phiên bản khác nhau của file cấu hình.|
|ArrayName|Tên cho một mảng cấu hình.|
|ListTTL|Số giây mà mảng cấu hình này được cho là phù hợp; cổng vào (proxy server) làm mới cấu hình của nó (có thể qua mạng) khi hết hạn.|

Bảng 5.16 liệt kê tất cả thông tin mà file chứa về các cache server, nhưng các tham số quan trọng là danh tính server và một giá trị gọi là Load Factor. Load Factor quan trọng vì nó ảnh hưởng đến thuật toán. Các cache server có load factor cao hơn sẽ được ưa chuộng hơn là các cache server có load factor thấp. Ví dụ, một admin đang cấu hình một trang trị CARP server gán các load factor cho các cache server này với bộ nhớ các cache lớn hơn và vi xử lý nhanh hơn.

>**Bảng 5.16: Thông tin Cache Server trong File Cấu hình CARP**

|Trường|Sử dụng|
|------|-------|
|Name|Tên miền của cache server.|
|IP Address|Địa chỉ IP của cache server.|
|Port|TCP port mà cache server đang lắng nghe.|
|Table URL|URL từ các file các hình có thế được lấy ra.|
|Agent String|Nhà cung cấp và phiên bản của cache server.|
|Statetime|Số giây mà cache server đã hoạt động ở trạng thái hiện tại của nó.|
|Status|Một dấu hiệu cho biết liệu cache server có thể xử lý các request.|
|Load Factor|Server có thể chịu được bao nhiêu tải (load).|
|Cache Size|Kích thước(tính bằng MB) của bộ nhớ cache của server này.|

Bảng 5.17 chi tiết các thuật toán định tuyến CARP. Chú ý rằng step 1 và 2 thực hiện trước khi cổng vào (proxy server) bắt đầu chuyển hướng các http request; chúng không được tính lại với môi request mới.

>**Bảng 5.17: Thuật toán định tuyến CARP của cổng vào(proxy server)**

|Step|Hoạt động|
|----|---------|
|1|Chuyển tất cả các tên của các cache server thành chữ thường.|
|2|Tính toán một giá trị hash cho mỗi tên của cache server.|
|3|Khi một HTTP request chuyển đến, chuyển tất các URL thành chữ thường.|
|4|Tính toán một gía trị hash cho URL|
|5|Gộp giá trị hash của URL với giá trị hash của mỗi cache server, di chuyển kết quả cho load factor của mỗi server.|
|6|Chuyển hướng request tới cache server "tốt nhất".|


<a name="5.3"></a>
## 5.3 Các kỹ thuật tăng tốc khác

Trong khi load balancing và caching là hai kỹ thuật phổ biến nhất cho việc tăng tốc hiệu năng HTTP, các Web site còn cung cấp kỹ thuật tăng tốc khác. Hai cách hiệu quả nhất là SSL processing và TCP multiplexing. 

### 5.3.1 SSL Processing

Như mục 4.2 đã giải thích, Secure Sockets Layer (SSL) là kỹ thuật phổ biến nhất cho bảo mật HTTP session. Thật không may, SSL dựa trên các thuật toán mã hóa phức tạp và tính toán các thuật toán đó là một gánh nặng lớn cho các Web Server. Ví dụ, nó yêu cầu một tài nguyên bộ xử lý hơn 1000 lần để thực hiện tính toán SSL để trả về object được request.  Một Web server an toàn nhận ra rằng nó đang làm nhiều quy trình mã hóa để trả về các Web page.

Để giai quyết sự mất công bằng này, các nhà cung cấp đã tạo ra phần cứng đặc biệt có thể thực hiện việc tính toán mã hóa nhanh hơn là phần mềm. Các phần cứng này có thế chứa trong các card rời, trong các module đặc biệt mà ghép nối thông qua SCSI howajc Ethernet, hoặc được đóng gói như các hệ thống mạng riêng biệt. Trong tất cả các trường hợp, phần cứng thực hiện tính toán SSL, giảm bớt gánh nặng cho Web server.

Hình 5.33 so sánh một cấu hình Web server đơn giản với một hệ thống mạng với một hệ thống mạng riêng biệt hoạt động như một bộ xử lý SSL. Phần trên cùng của hình là web server có cấu hình đơn giản thực hiện cả hai quá trình SSL và HTTP. Trái lại, phần ở dưới bức hình cho thấy sự bổ xung bộ xử lý SSL. Thiết bị này thực hiện quá trình SSL. Sau khi xử lý, thiết bị truyền qua với kết nối HTTP và truyền tới server. Tới server tồi thì nó không yêu cầu xử lý SSL nữa. Bộ xử lý SSL làm những gì tốt nhất-tính toán mã hóa- trong khi Web server chỉ có việc là phản hồi các HTTP request.

![Hình 5.33]()

### 5.3.2 TCP Multiplexing

TCP Multiplexing sẽ thực hiện tốt hơn so với hiệu năng của SSL. Hình 5.34 có 3 client mà web server hỗ trợ. Để làm điều đó, nó quản lý 3 kết nối TCP và 3 kết nối HTTP.

![Hình 5.34](http://i.imgur.com/ngZ0yRY.png)

**Hình 5.34: Server phải chịu áp lực là mỗi client là một kết nối tcp.**

Việc quản lý các kết nối TCP, đặc biệt là với các HTTP request đơn thuần, có thể coi là 1 gánh nặng lớn cho Web server. Nhắc lại mục 2.12, mặc dù nó luôn luôn tạo ra 5 message để tạo ra và kết thúc một lết nối TCP, một GET http và 200 OK message có thể được vận chuyển chỉ trong 2 message. Trong trường hợp tệ nhất, một Web server có thể tốn ít hơn 30% thời gian hỗ trợ http.

Bộ xử lý TCP có một cách để cải thiện điều này. Giống như bộ xử lý SSL, một bộ xử lý TCP tự chèn nó vào giữa Internet và Web server. Như hình 5.35 cho thấy, bỗ xử lý TCP quản lý tất các các kết nối TCP tới client trong khi việc truyền các http message của client tới Web server chỉ qua một kết nối TCP đơn. Bộ xử lý TCP tận dụng kết nối liên tục và pipelining (đường ống) của HTTP.
    
![Hình 5.35](http://i.imgur.com/ZXVzUwB.png)

**Hình 5.35: Bộ xử lý TCP quản lý các kết nối riêng với các client và một kết nối TCP đơn với Web server**

Bộ xử lý TCP không hiệu quả trong mọi tình huống. Chúng hoạt động tốt nhất với các Web site hỗ trợ nhiều client, nơi mà mỗi client tạo ra các HTTP request đơn giản. Nếu Web server hỗ trợ ít client hoặc nếu client có khuynh hướng là chứa các tương tác phức tạp hoặc dài với server, thì bộ xử lý TCP không còn hiệu quả. Ngoài ra, bộ xử lý TCP có khả năng xử lý nhanh hơn Web server, hoặc nó có thể hỗ trợ đồng thời nhiều kết nối TCP hơn là Web server.

#HẾT - CHÚC CÁC BẠN THÀNH CÔNG
