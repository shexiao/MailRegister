<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
   
<%
String mail=(String)request.getAttribute("mail");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>用户首页</title>
</head>
<body>
<%=mail %> 用户登录成功
</body>
</html>