<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
</head>
<body style="text-align:center">
	<form action="${pageContext.request.contextPath }/RegisterServlet" method="get">
		Username:<input type="text" name="username">
		Password:<input type="text" name="password">
		Address: <input type="text" name="address">
		Phone: <input type="text"  name="phone">
		Email: <input type="text" name="email"> 
		<input type="submit" value="register">
	</form>
</body>
</html>