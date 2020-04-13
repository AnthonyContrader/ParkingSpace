<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CarDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">

<title>Car Manager</title>
</head>
<body>

	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/car/getall" > Cars</a>
	</div>
	<div class="main">
		<%
		List<CarDTO> carList = (List<CarDTO>) request.getSession().getAttribute("dto");
		//List<CarDTO> carList=(List<CarDTO>)request.getSession().getAttribute("dto");
		%>
		
			
			<!-- <div class="row">
				<div class="col-25">
					<label for="mod">Model</label>
				</div>
				<div class="col-25">
					<input type="text" id="mod" name="model"
						placeholder="inserisci modello">
				</div>
			</div>
			
			<button type="submit">Lista Auto</button> -->
		
		
		<table>
		<tr>
			    <th>Model</th>
				<th>License</th>
				<th></th>
				<th></th>
			</tr>
		<%
				//System.out.println("asjfanfsajasjfsafjasf");
			    //List<CarDTO> carList=(List<CarDTO>)request.getSession().getAttribute("dto");
				for (CarDTO c : carList) {
				
	    %>
			<tr>
				<td><a href="/car/read?id=<%=c.getModel()%>"> <%=c.getModel()%>
				</a></td>
				<td><%=c.getLicense()%></td>

			</tr>
			<%
				}
			%>
		</table>

 

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>