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
<title>ע��</title>
</head>
<body>
<form action="MailLogin" method="post">

<%
if(mail!=null){
%>
<div>���� <%=mail %> ��ûע��</div>
<%} %>
	���䣺<input type="text" name="mail"><a href="register.jsp">ע��</a><br>
	���룺<input type="text" name="password"><br>
	<input type="submit">
</form>
</body>
</html>