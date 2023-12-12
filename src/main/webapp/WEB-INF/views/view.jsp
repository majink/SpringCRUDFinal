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

<h1>View</h1>

<table>
<tr><td>이름:</td><td>${u.name}</td></tr>
 <tr><td>장소:</td><td>${u.place}</td></tr>
 <tr><td>종류:</td><td>${u.type}</td></tr>
 <tr><td>재료:</td><td>${u.ingredient}</td></tr>
 <tr><td>점수:</td><td>${u.rate}</td></tr>
 <tr><td>특징:</td><td>${u.feature}</td></tr>
 <tr><td>가격:</td><td>${u.price}원</td></tr>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>


</body>
</html>