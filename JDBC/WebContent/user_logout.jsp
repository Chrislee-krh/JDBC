<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

session.invalidate();
response.sendRedirect("user_login.jsp");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!--  <a href="user_login.jsp">로그인 페이지로 이동</a>-->
	</body>
</html>