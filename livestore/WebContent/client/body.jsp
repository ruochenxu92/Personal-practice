<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>body</title>
</head>
<body>
	
	<div id="content" style="text-align:center; width:840px">
	
		<div id="category" style="float: left;width: 200px;border: 1px solid red;text-align: left;height: 300px;margin-left: 250px" >
				Category:
				<ul>
				<li><a href="${pageContext.request.contextPath }/IndexServlet">All Books</a></li>
				
				<c:forEach var="c" items="${categories }">
					<li><a href="${pageContext.request.contextPath }/IndexServlet?method=sort&category_id=${c.id}">${c.name }</a></li>
				</c:forEach>
				</ul>
		</div>
		
		<div id="bookandpage" style="float:left;margin-left:40px">
			<div id="books" >
				<c:forEach var="book" items="${page.list }">
				<div class="image" style="float:left" >
					<img src="${pageContext.request.contextPath}/images/${book.image }" width="100" height="100">
				</div>
			
				<div class="bookinfo" style="float:left; text-align: left" >
					<ul>
						<li>${book.name}</li>
						<li>${book.author}</li>
						<li>${book.price}</li>
						<li>${book.description}</li>
						<li>
							<a href="${pageContext.request.contextPath }/BuyServlet?bookid=${book.id}">Buy</a>
						</li>
					</ul>
				</div>
				<div style="clear:both"></div>
				</c:forEach>
			</div>
			<div style="clear:both"></div>
			<div id="pages">
				<c:forEach var="i" begin="${page.startpage }" end="${page.endpage }">
					[<a href="${pageContext.request.contextPath }/IndexServlet?pagenum=${i}&method=${para.method}&category_id=${para.category_id}"> ${i }</a>]
				</c:forEach>
			</div>
		</div>
	
	</div>	
	
</body>
</html>