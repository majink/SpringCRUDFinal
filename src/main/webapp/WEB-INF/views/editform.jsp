<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.crud.board.BoardDAO, com.crud.board.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%--<%--%>
<%--	BoardDAO boardDAO = new BoardDAO();--%>
<%--	String id=request.getParameter("id");	--%>
<%--	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));--%>
<%--%>--%>

<h1>Edit Form</h1>
<form action="editpost" method="post">
<input type="hidden" name="seq" value="${u.seq}"/>
<table>
<tr><td>이름:</td><td><input type="text" name="name" value="${u.name}"/></td></tr>
 <tr><td>장소:</td><td><input type="text" name="place" value="${u.place}" /></td></tr>
 <tr><td>이미지:</td><td><input type="text" name="img" value="${u.img}" /></td></tr>
 <tr><td>재료:</td><td><input type="text" name="ingredient" value="${u.ingredient}"/></td></tr>
 <tr><td>점수:</td><td><input type="number" name="rate" value="${u.rate}"/></td></tr>
 <tr><td>특징:</td><td><input type="text" name="feature" value="${u.feature}"/></td></tr>
 <tr><td>가격:</td><td><input type="number" name="price" value="${u.price}"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>