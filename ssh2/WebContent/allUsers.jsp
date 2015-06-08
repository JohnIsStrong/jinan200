<%@page import="po.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>所有的用户：</h1>
	<%
		List<User> us=(List<User>)request.getAttribute("users");
		for(User u:us){
			out.print(u.getId()+","+u.getUname()+","+u.getAge());
			out.print("<br/>");
		}
	%>
	
</body>
</html>