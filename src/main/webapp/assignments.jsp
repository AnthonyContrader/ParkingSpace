<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AssignmentParkingDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">

<title>Assignments Manager</title>
</head>
<body>

	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/assignmentParking/getall">Assignments</a> <a href="/car/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
		List<AssignmentParkingDTO> list = (List<AssignmentParkingDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
			    <th>car</th>
				<th>PostoAuto</th>
				<th>entryDate</th>
				<th>entryTime</th>
			</tr>
			<%
				for (AssignmentParkingDTO apd : list) {
				
			%>
			<tr>
				<td><a href="/car/read?id=<%=apd.getId()%>"> <%=apd.getId()%>
				</a></td>
				<td><%=apd.getCar()%></td>
				<td><%=apd.getPark()%></td>
				<td><%=apd.getEntryDate()%></td>
				<td><%=apd.getEntryTime()%></td>
				<td><a href="/car/preupdate?id=<%=apd.getId()%>">Edit</a></td>


				<td><a href="/car/delete?id=<%=apd.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/assignmentParking/insert" method="post">
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