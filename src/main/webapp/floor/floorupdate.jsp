<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FloorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Update Floors</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
	<div class="navbar">
		<a href="homeadmin.jsp">Home</a>
		<a class="active" href="FloorServlet?mode=floorlist">Floors</a>
		<a href="LogoutServlet" id="logout">LogOut</a>
	</div>
	<br>
	<div class="main">
	
		<% FloorDTO fDTO = (FloorDTO) request.getAttribute("fDTO"); %>
	
		<form id="floatleft" action="FloorServlet?mode=update&id=<%=fDTO.getId()%>" method="post">
			<div class="row">
			<div class="col-25">
				<label for="number_floor">Number Floor</label>
			</div>
			<div class="col-75">		
				<input type="text" id="number_floor" name="number_floor" value=<%=fDTO.getNumber_floor() %>>
			</div>
			</div>
			<button type="submit">Conferma Modifica</button>
		</form>
	
	</div>
	<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>