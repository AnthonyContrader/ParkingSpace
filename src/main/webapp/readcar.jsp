<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="it.contrader.dto.CarDTO"%>
    
    
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Car Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">

<title>Read Car</title>
</head>
<body>
	<%@ include file="./css/header.jsp" %>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active" 
		href="/car/getall">Cars</a> <a href="/car/logout" id="logout">Logout></a>
	</div>
	
	<br>

	<div class="main">
		<%
			CarDTO c = (CarDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>Model</th>
				<th>License</th>
				
			</tr>
			<tr>
				<td><%=c.getModel()%></td>
				<td><%=c.getLicense()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
	

</body>
</html>