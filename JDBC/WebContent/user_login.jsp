<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 
	if(session.getAttribute("user_id")!=null){
		response.sendRedirect("user_mypage.jsp");
	}

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user_login.jsp</title>
	</head>
	<body>
		<h2>로그인 연습</h2>
		<form action="user_login_ok" method="post">
			ID: <input type="text" name="id"><br>
			PW: <input type="password" name="pw"><br>
			<input type="submit" value="Log in">
		</form>
	</body>
</html>