<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "it.contrader.dto.ParkingplaceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Parkingplace</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
<a href= "homeadmin.jsp">Home</a>
<a class="active" href="ParkingplaceServlet?mode=parkingplacelist">Parkingplaces</a>
<a href= "LogoutServlet" id="Logout">Logout</a>
</div>
<br>

<div class = "main">
<%ParkingplaceDTO u= (ParkingplaceDTO) request.getAttribute("dto"); %>


<table>
	<tr>
		<th>Numberplace</th>
	</tr>
<tr>
	<td><%=u.getNumberplace() %></td>
</tr>
</table>


<br>
<br>
<br>
<br>
<br>




</div>

<%@include file="../css/footer.jsp" %>
</body>
</html>