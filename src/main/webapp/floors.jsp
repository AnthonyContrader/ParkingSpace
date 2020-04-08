<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.FloorDTO" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FLOOR</title>
</head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Floor Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">

<body>
	<%@ include file="./css/header.jsp" %>
	
	<div class="navbar">
	
		<a href="/homeadmin.jsp">Home Admin</a>
		<a class="active" href="/floor/getall">Floor</a>
		
	</div>
	<div class="main">
	
		<% List<FloorDTO> floorDTOlist = (List<FloorDTO>) request.getSession().getAttribute("floorlist"); %>
		<br>
		
			<table>
				<tr>
					<th></th>
					<th>Number Floor</th>
				</tr>
			
				<%for (FloorDTO fDTO : floorDTOlist){ %>
					<tr>
						<td><a href="/floor/read?id=<%=fDTO.getId()%>"></a></td>	
						<td><%=fDTO.getNumberfloor()%></td>
						<td><a href="/floor/preupdate?id=<%=fDTO.getId()%>">Edit</a></td>
						<td><a href="/floor/delete?id=<%=fDTO.getId()%>">Delete</a></td>
					</tr>
				<% } %>
			
			</table>
	
		<form id="floatright" action="/floor/insert" method="post">
		
			<div class="row">
				<div class="col-75">
					<label for="number_floor">new Number Floor</label>
				</div>
				<div class="col-75">
					<input type="text" id="number_floor" name="number_floor" placeholder="insert here">
				</div>			
			</div>
		
			<button type="submit">Insert</button>
		
		</form>

	</div>	
	
<br>
	<%@ include file="./css/footer.jsp" %>
</body>
</html>