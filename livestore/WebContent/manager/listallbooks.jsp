<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list all books</title>
</head>
<body >

	<table frame="border" style="text-align:center">
		<tr>
			<td>Image</td>
			<td>Book Name</td>
			<td>Author</td>
			<td>Price </td>
			<td>Description</td>
			<td>Operator</td>
		</tr>
		<c:forEach var="book" items="${page.list }">
			<tr>
				<td><img src="${pageContext.request.contextPath }/images/${book.image}" width="100" height="100"></td>
				<td>${book.name }</td>
				<td>${book.author }</td>
				<td>${book.price }</td>
				<td>${book.description }</td>
				<td>
					<a href="#">Update</a>
					<a href="#">Delete</a>
				</td>
			</tr>
		</c:forEach>
		<tr><td colspan="2">
			
			now:${page.pagenum } page  &nbsp;&nbsp;
		<c:forEach var="i" begin="${page.startpage }" end="${page.endpage }">
				[<a href="${pageContext.request.contextPath }/BookServlet?method=listallbooks&pagenum=${i}">${i }</a>]
		</c:forEach>
		<c:choose>
		<c:when test="${page.pagenum - 1 >= 1}">
			<a href="${pageContext.request.contextPath }/BookServlet?method=listallbooks&pagenum=${page.pagenum-1}">prev</a>
	    </c:when>
		
	 
		</c:choose>
		<c:choose>
		<c:when test="${page.pagenum + 1 <= page.totalpage}">
			<a href="${pageContext.request.contextPath }/BookServlet?method=listallbooks&pagenum=${page.pagenum+1}">next</a>
	    </c:when>
		</c:choose>
		</td>	
		
		</tr>
	</table>
</body>
</html>