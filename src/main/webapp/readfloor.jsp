<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FloorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">

<title>READ FLOOR</title>
</head>
<body>

	<%@include file="./css/header.jsp" %>
	<div>
		<a href="homeadmin.jsp">Home</a>
	</div>
	<br>
	
	<div class="main">
		
		<% FloorDTO fDTO = (FloorDTO) request.getSession().getAttribute("dto_read"); %>
		
		<table>
			<tr>
				<th></th>
				<th>Number Floor</th>
			</tr>
			
			<tr>
				<td><% fDTO.getNumberfloor(); %></td>
			</tr>
		</table>
		<br>
		<br>
		<br>
		
	</div>
	<%@ include file="./css/footer.jsp" %>
	
</body>
</html>