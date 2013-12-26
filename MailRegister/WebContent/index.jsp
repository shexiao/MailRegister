<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%
	HttpSession httpSession=request.getSession();
	String mail=(String)httpSession.getAttribute("mail");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>注册</title>
</head>
<body>
<form action="MailLogin" method="post">

<%
if(mail!=null){
%>
<div>邮箱 <%=mail %> 还没注册</div>
<%} %>
	邮箱：<input type="text" name="mail"><a href="register.jsp">注册</a><br>
	密码：<input type="text" name="password"><br>
	<input type="submit">
</form>
</body>
</html>