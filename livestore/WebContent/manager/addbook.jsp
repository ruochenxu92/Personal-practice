<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Category</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/BookServlet?method=add" method="post" >
	<table frame="border" width="50%">
		<tr>
			<td>Book Name</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
	    <tr>
			<td>Author Name</td>
			<td>
				<input type="text" name="author">
			</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>
				<input type="text" name="price">
			</td>
		</tr>
		<tr>
			<td>image</td>
			<td>
				<input type="text" name="image">
			</td>
		</tr>
		<tr>
			<td>Description</td>
			<td>
				<textarea rows="5" cols="60" name="description"></textarea>
			</td>
		</tr>
		<tr>
			<td>Category</td>
			<td>
				<select id = "categories" name="category">
					<c:forEach var="c" items="${categories }">
						<option value="${c.id }">${c.name }</option>	
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
		<td>
			<input type="reset" value="reset">
		</td>
		<td>
			<input type="submit" value="Add Book">
		</td></tr>
	</table>
	
	</form>
	
</body>
</html>