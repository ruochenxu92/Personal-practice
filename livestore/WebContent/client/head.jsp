<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX front End</title>
</head>
<body style="text-align:center">
	
	<h1>Online Book Store</h1>
	<br>
	
	
	<div>
	<a href="${pageContext.request.contextPath }/IndexServlet" target="body">index</a>
	<a href="">Look up Shopping Cart</a>
	<a href="">Look up Your Orders</a>
	</div>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${user == null}">
	<div style="float:right">
	<form action="${pageContext.request.contextPath }/LoginServlet" method="get">
		User Name:<input type="text" name="username">
		Password: <input type="password" name="password">
		<input type="submit" value="login">
		<button onclick="javascript: window.parent.body.location.href='${pageContext.request.contextPath}/client/register.jsp'">register</button>	
	</form>
	</div>
	</c:if>
	<c:if test="${ user != null}">
		Welcome, ${user.username }
		<a href="${pageContext.request.contextPath }/LogoutServlet">Logout</a>
	</c:if>
</body>
</html>