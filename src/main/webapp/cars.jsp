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
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/car/getall">Cars</a> <a href="/car/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
		List<CarDTO> list = (List<CarDTO>) request.getSession().getAttribute("list");
		System.out.println(list.get(1).toString());
		%>

		<br>

		<table>
			<tr>
			    <th>Model</th>
				<th>License</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (CarDTO c : list) {
				
			%>
			<tr>
				<td><a href="/car/read?id=<%=c.getModel()%>"> <%=c.getModel()%>
				</a></td>
				<td><%=c.getLicense()%></td>
			
				<td><a href="/car/preupdate?id=<%=c.getLicense()%>">Edit</a></td>


				<td><a href="/car/delete?id=<%=c.getLicense()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/car/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="car">Model</label>
				</div>
				<div class="col-75">
					<input type="text" id="car" name="model"
						placeholder="inserisci auto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="lic">License</label>
				</div>
				<div class="col-75">
					<input type="text" id="lic" name="license"
						placeholder="inserisci targa">
				</div>
			</div>
			
			<button type="submit">Insert</button>
			
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>