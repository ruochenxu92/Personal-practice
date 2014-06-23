<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list cart</title>
</head>
<body  style="text-align:center">

	<h2>Shopping list</h2>
	<table frame="border" width="80%" >
		<tr>
			<td>Book Name</td>
			<td>Author</td>
			<td>Book Price</td>
			<td>Quantity</td>
			<td>Summary</td>		
			<td>
				Operator
			</td>
		</tr>
		<c:forEach var="me" items="${cart.map }">
			<tr>
				<td>${me.value.book.name }</td>
				<td>${me.value.book.author }</td>
				<td>${me.value.book.price }</td>
				<td>${me.value.quantity }</td>
				<td>${me.value.price }</td>	
								
				<td>
					<a href="${pageContext.request.contextPath }/DeleteCartItemsServlet?bookid=${me.key}">Delete</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">Total Price</td>
			<td> ${cart.price }</td>
		</tr>
		<tr>
			<td> <a href="${pageContext.request.contextPath }/OrderServlet">${user.username } Make an Order</a></td>
		</tr>		
	</table>
	
</body>
</html>