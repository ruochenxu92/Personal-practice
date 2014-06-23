<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Left Navigation</title>
</head>
<body style="text-align:center">

	<a href="">Categories Manage</a>
	<br>
	<a href="${pageContext.request.contextPath }/manager/addcategory.jsp" target="body">Add Category</a><br>
	<a href="${pageContext.request.contextPath }/CategoryServlet?method=listall" target="body">Look Category</a><br>
	
		
	<br><br><br>
	
	
	<a href="">Book Management</a><br>
	<a href="${pageContext.request.contextPath }/BookServlet?method=addUI" target="body">Add Book</a><br>
	<a href="${pageContext.request.contextPath }/BookServlet?method=listallbooks" target="body">Look Book</a><br>
	
		<br><br><br>
	
	<a href="">Orders Manage</a><br>
	<a href="${pageContext.request.contextPath }/ListOrderServlet?state=false" target="body">Look at not dealing order</a><br>
	<a href="${pageContext.request.contextPath }/ListOrderServlet?state=true" target="body">Look at delivered order</a><br>
	
		<br><br><br>
	
</body>
</html>