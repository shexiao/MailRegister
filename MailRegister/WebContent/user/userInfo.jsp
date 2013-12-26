<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%
	String mail=null;
	String password=null;
	Cookie[] cookies=request.getCookies();
	for(Cookie cookie:cookies){
		if("mail".equals(cookie.getName())){
			mail=cookie.getValue();
		}
		if("password".equals(cookie.getName())){
			password=cookie.getValue();
		}
	}
	
	if(mail==null && password==null){
		response.sendRedirect("/MailRegister/index.jsp");
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>用户信息</title>
</head>
<body>
<%=mail %><br>
用户信息界面
</body>
</html>