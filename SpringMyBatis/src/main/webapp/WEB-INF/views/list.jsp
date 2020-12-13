<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
 integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Caveat&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<title>free board</title>
<style>
h1{
	background-color: #FFA500;
	padding: 5px;
	border-radius: 5px;
	width: 100%;
	margin: 5px;
	text-align: center;
	color: white;
	font-weight: bold;
}
body{
font-family: 'Caveat', 'Nanum Pen Script',cursive;
font-size:20px;
}
th, td{
text-align : center;
}
  table {
    border: 2px solid #444444;
    padding: 2px;
  }
  th, td {
  	padding: 2px;
    border: 2px solid #444444;
  }
  th{
  	background-color: #AFEEEE;
  }
</style>
</head>
<body>
<h1>노 트 북 구 매 사 이 트</h1>
<table id = "list" width="100%">
	<tr>
		<th>No</th>
		<th>제품명</th>
		<th>제조사</th>
		<th>가격</th>
		<th>상세스펙</th>
		<th>Regdate</th>
		<th>Detail</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	
	<c:forEach items="${list }" var="u">
		<tr>
			<td>${u.seq }</td>
			<td>${u.category }</td>
			<td>${u.title }</td>
			<td>${u.writer }</td>
			<td>${u.content }</td>
			<td>${u.regdate }</td>
			<td><a href="detail/${u.seq }">Detail</a></td>
			<td><a href="editform/${u.seq }">Edit</a></td>
			<td><a href="deleteok/${u.seq }">Delete</a></td>
		</tr>
	</c:forEach>
</table>

<br/><a href="add">Add New Product</a>
</body>
</html>