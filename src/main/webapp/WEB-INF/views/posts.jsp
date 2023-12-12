<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--    pageEncoding="UTF-8"%>--%>
<%@page import="com.crud.board.BoardDAO, com.crud.board.BoardVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>free board</title>
<style>
#list {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#list td, #list th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align:center;
}
#list tr:nth-child(even){background-color: #f2f2f2;}
#list tr:hover {background-color: #ddd;}
#list th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #006bb3;
  color: white;
}
</style>
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?" + id);
		if(a) location.href='deleteok/' + id;
	}
</script>
</head>
<body>
<h1>자유게시판</h1>
<table id="list" width="90%">
<tr>
	<th>Id</th>
	<th>이름</th>
	<th>장소</th>
	<th>종류</th>
	<th>가격</th>
	<th>점수</th>
	<th>수정</th>
	<th>삭제</th>
</tr>
<c:forEach items="${posts}" var="u">
	<tr>
		<td><a href="view/${u.getSeq()}">${u.getSeq()}</a></td>
		<td><a href="view/${u.getSeq()}">${u.getName()}</a></td>
		<td>${u.getPlace()}</td>
		<td>${u.getType()}</td>
		<td>${u.getPrice()}</td>
		<td>${u.getRate()}</td>
		<td><a href="editform/${u.getSeq()}">Edit</a></td>
		<td><a href="javascript:delete_ok('${u.getSeq()}')">Delete</a></td>
	</tr>
</c:forEach>
	<a href="login/logout">로그아웃</a>
	<h3>환영합니다.${login.user_name}님</h3>
</table>
<br/><a href="addpostform">Add New Post</a>
</body>
</html>
