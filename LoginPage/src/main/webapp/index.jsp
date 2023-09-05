<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.container{
display:flex;
}
</style>
<body>
<div class="container">
 <form action="hello" method="post">
 <label>Username:<input type="text" name="uname"></label>
 <label>Password:<input type="password" name="pass"></label>
 <button type="submit"></button>
 </form></div>
</body>
</html>
