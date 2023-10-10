<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입(user_join.jsp)</title>
	</head>
	<body>
		<h2>회원 가입 연습</h2>
		<form action="user_join_ok" method="post">
			id: <input type="text" name="id"><br>
			pw: <input type="password" name="pw"><br>
			이름: <input type="text" name="name"><br>
			전화번호:<br>
			<select name="phone1">
				<option>010</option>
				<option>011</option>
				<option>018</option>
			</select>
			- <input type="text" name="phone2"><br>
			<br>
			성별: 
			<input type="radio" name="gender" value='M'>남자
			<input type="radio" name="gender" value='F'>여자<br>
			<br>
			<input type="submit" value="가입">
		</form>
	</body>
</html>