<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
 integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
 <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
  <link href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css" rel="stylesheet">
  <link href='https://fonts.googleapis.com/css?family=Alegreya Sans SC' rel='stylesheet'>
  <meta charset="UTF-8">
<title>Edit Form</title>
</head>
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
	font-family: "Alegreya Sans SC", 'Nanum Gothic', monospace;
	font-size:30px;
	padding: 20px;
}
th{
	text-align: center;
	background-color:#2E64FE;
	color:white;
	padding-right: 8px;
}

</style>
<body>
<h1>제품정보수정</h1>
<form method = "post" action="editok">
<input type="hidden" name="seq" value="${u.seq }"/>
<table>
	<tr>
		<td>제품명:</td>
		<td><input type="text" name="category" value="${u.category }"/></td>
	</tr>
	<tr>
		<td>제조사:</td>
		<td><input type="text" name="title" value="${u.title }"/></td>
	</tr>
	<tr>
		<td>가격:</td>
		<td><input type="text" name="writer" value="${u.writer }"/></td>
	</tr>
	<tr>
		<td>상세스펙:</td>
		<td><textarea cols="50" rows="5" name="content">${u.content }</textarea></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="수정완료" /></td>
	</tr>
</table>
</form>
</body>
</html>