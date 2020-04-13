<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "it.contrader.dto.ParkingplaceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Parkingplace Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Parkingplace</title>
</head>
<body>
<%@ include file ="./css/header.jsp"%>
<div class="navbar">
     <a href="/homeadmin.jsp">Home</a> <a class = "active"
          href="/parkingplace/getall">Parkingplaces</a> <a href = "/user/Logout" id = "Logout">Logout</a>
</div>
<br>
	<div class="main">
		<%
			ParkingplaceDTO p = (ParkingplaceDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>Numberplace</th>
				<th>IdFloor</th>
			</tr>
			<tr>
				<td><%p.getFloor().getId()%></td>
				<td><%=p.getNumberplace()%></td>	
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>
