<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "it.contrader.dto.ParkingplaceDTO"  import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Parkingplace Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Parkingplace Manager</title>

</head>
<body>
<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/parkingplace/getall">Parkingplaces</a> <a href="/parkingplace/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<ParkingplaceDTO> list = (List<ParkingplaceDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
			    <th></th>
				<th>Numberplace</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ParkingplaceDTO p : list) {
			%>
			<tr>
				<td><a href=/parkingplace/read?id=<%=p.getId()%>>
				</a></td>
				<td><%=p.getNumberplace()%></td>
				<td><a href="/parkingplace/preupdate?id=<%=p.getId()%>">Edit</a></td>
				
				<td><a href="/parkingplace/delete?id=<%=p.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>


<form id="floatright" action="/parkingplace/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Numberplace</label>
				</div>
				<div class="col-75">
					<input type="text" id="parkingplace" name="numberplace"
						placeholder="inserisci numberplace">
				</div>
				</div>
<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>