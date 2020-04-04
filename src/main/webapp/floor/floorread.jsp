<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FloorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Floors</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeadmin.jsp" >Home</a>
	<a class="active" href="FloorServlet?mode=floorlist">Floors</a>
	<a href="LogoutServlet" id="logout">LogOut</a>
</div>
<br>

<div class="main">
	<%FloorDTO floorDTO = (FloorDTO) request.getAttribute("fDTO"); %>
	
	<table>
		<tr>
			<th>Floor Number</th>			
		</tr>
		<tr>
			<td><%=floorDTO.getNumber_floor() %></td>
		</tr>
	</table>

<br>
<br>
</div>
<br>
<%@ include file="/css/footer.jsp"%>
</body>
</html>