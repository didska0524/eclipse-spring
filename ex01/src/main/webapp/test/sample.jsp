<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form method="get" action="/sample/ex04.do">
		<p>Name : <input type="text" name="userName"></p>
		<p>Age : <input type="text" name="userAge"></p>
		<p>hobby : <input type="checkbox" name="hobby" value="1">hobby1<br/>
		<input type="checkbox" name="hobby" value="2">hobby2<br/>
		<input type="checkbox" name="hobby" value="3">hobby3</p>
		<p>date : <input type="date" name="regDate"></p>
		<p>Page : <input type="number" name="page"></p>
		<input type="submit" />
		</form>
	</body>
</html>