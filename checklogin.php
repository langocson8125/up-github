<?php
//KẾT NỐI DATABASE BẰNG MYSQLI PROCEDURAL
$connect= mysqli_connect('localhost','root','','langocsonwp') or die('Cannot connect DB');
mysqli_select_db($connect,'langocsonwp') or die('Cannot select DB');

$id = $_POST['id'];
$pass = $_POST['pass'];

$sql = "'SELECT * FROM news WHERE id='$id' and password='$pass'";

$result=mysqli_query($sql);
$count=mysqli_num_rows($result);

// nếu tài khoản trùng khớp thì sẽ trả về giá trị 1 cho biến $count
if($count==1){
	session_register($id);
	session_register($pass);
	header("location:login_success.php");
 
// Lúc này nó sẽ tự động gửi đến trang thông báo đăng nhập thành công
session_register("myusername");
session_register("mypassword");
header("location:login_success.php");
}
else {
echo "Sai tên đăng nhập hoặc mật khẩu";
}
?>
