<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list order</title>
</head>
<body style="text-align:center:">
	<table >
		<tr>
			<td>Order Num</td>
			<td>Name</td>
			<td>Order Time</td>
			<td>Order Price</td>
			<td>Order Status</td>
			<td>Operator</td>
		</tr>
		<c:forEach var="order" items="${orders}" >
		<tr>
			<td>${order.id }</td>
			<td>${order.user.username }</td>
			<td>${order.ordertime }</td>
			<td>${order.price }</td>
			<td>${order.state==true?'Shipped':'UnShipped' }</td>
			<td>
				<a href="${pageContext.request.contextPath }/OrderDetailedServlet?order_id=${order.id}">Look Details</a>
				<a href="">Update</a>
			</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>