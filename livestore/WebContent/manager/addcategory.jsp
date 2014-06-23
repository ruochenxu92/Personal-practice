<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Category</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/CategoryServlet" method="get">
		<input type="hidden" name="method" value="add">
		 分类名称：<input type="text" name="name"><br>
		 分类描述：<textarea rows="5" cols="40" name="description">
		 </textarea><br>
		 <input type="submit" value="Add">
	</form>
</body>
</html>