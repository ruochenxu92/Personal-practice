<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>look category</title>
</head>
<body>

	<table frame="border" >
		<tr>
			<td>Category Name</td>
			<td>Category Description</td>
			<td>Operator</td>
		</tr>
		
		<c:forEach var="c" items="${categories }">
			<tr>
			<td>	${c.name }</td>
			<td>${c.description }</td>
			<td>
				<a href="#">Modify</a>
				<a href="#">Delete</a>				
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>