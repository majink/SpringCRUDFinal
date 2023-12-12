<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addpost" method="post">
<table>
<tr><td>이름:</td><td><input type="text" name="name"/></td></tr>
<tr><td>장소:</td><td><input type="text" name="place"/></td></tr>
    <tr><td>재료:</td><td><input type="text" name="ingredient"/></td></tr>
    <tr><td>점수:</td><td><input type="number" name="rate"/></td></tr>
    <tr><td>특징:</td><td><input type="text" name="feature"/></td></tr>
    <tr><td>가격:</td><td><input type="number" name="price"/></td></tr>

<tr><td><a href="posts">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>