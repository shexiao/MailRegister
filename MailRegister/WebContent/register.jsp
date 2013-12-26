<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>register</title>
</head>
<body>
<form action="MailRegister" method="post">
	
	邮箱：<input type="text" name="mail"><br>
	昵称：<input type="text" name="name"><br>
	密码：<input type="text" name="password" id="password"><br>
	重输密码：<input type="text" name="repeatPassword" id="repeatPassword"><div id="error"></div><br>
	<input type="submit">
</form>
<script type="text/javascript">
	
</script>
</body>
</html>