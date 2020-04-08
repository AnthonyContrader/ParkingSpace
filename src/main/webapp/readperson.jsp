<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PersonDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Person</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			PersonDTO per = (PersonDTO) request.getSession().getAttribute("dto");
		%>
		<table>
			<tr>
				<th>ID</th>
				<th>firstName</th>
				<th>secondName</th>
			</tr>
			<tr>
				<td><%=per.getId()%></td>
				<td><%=per.getFirstName()%></td>
				<td><%=per.getSecondName()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>
</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>