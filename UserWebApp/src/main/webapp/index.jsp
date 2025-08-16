<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Fill Your Details...</h2>

<%
String msg = (String)request.getAttribute("msg");
if(msg != null){
	out.print(msg);
}
%>

<form action="user" method="post">
<table>
<tr>
<td>Name :</td>
<td>
<input type="text" name="name">
</td>
</tr>

<tr>
<td>Email :</td>
<td>
<input type="text" name="email">
</td>
</tr>

<tr>
<td>Phone :</td>
<td>
<input type="text" name="phone">
</td>
</tr>

<tr>
<td>Name :</td>
<td>
<input type="submit" name="Submit">
</td>
</tr>

</table>
</form>
</body>
</html>