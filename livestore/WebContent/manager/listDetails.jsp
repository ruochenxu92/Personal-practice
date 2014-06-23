<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List details order</title>
</head>
<body>
	<h2>Order Information</h2>
	<table>
	
		<tr>
			<td>Order Id</td>
			<td>Order time</td>
			<td>Order state</td>
			<td>Order price</td>
		<tr>
		<tr>
			<td>${order.id }</td>
			<td>${order.ordertime }</td>
			<td>${order.state==true?'Shipped':'UnShipped' }</td>
			<td>${order.price }</td>
		<tr>
	</table>
	
	<h2>client information</h2>
		<table>
			<tr>
			<td>client name</td>
			<td>client address</td>
			<td>client phone</td>
			<td>client email</td>
			</tr>
			
			<tr>
			<td>${order.user.username } </td>
			<td>${order.user.address }</td>
			<td>${order.user.phone }</td>
			<td>${order.user.email }</td>
			</tr>
		</table>
		
	<a href="${pageContext.request.contextPath }/ShipOrder?order_id=${order.id}">Shipping Now</a>
</body>
</html>