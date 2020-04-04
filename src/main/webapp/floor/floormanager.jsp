<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.List" import="it.contrader.dto.FloorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Floor Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
	<!-- I sezione di pagina -->
	<div class="navbar">
		<a href= "homeadmin.jsp">Home</a>
		<a class=active href="FloorServlet?mode=floorlist">Floors</a>
		<a href="LogoutServlet" id="logout">Logout</a>
	</div>
	
	<!-- II sezione MAIN di pagina -->	
	<div class="main">
		<%
			List<FloorDTO> floorlistDTO = (List<FloorDTO>) request.getAttribute("floorlist");
		%>
		<br>
		<br>
		<table>
			<tr>
				<th></th>
				<th>Floor Number</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		
			<% for (FloorDTO f : floorlistDTO){ %>   <!-- voglio riempire le celle con i dati proventienti dal cilo for su floorlist -->
		
			<tr>
				<td><a href=FloorServlet?mode=read&id=<%= f.getId() %>></a></td>
				<td>Piano<%=f.getNumber_floor() %></td>
				<td><a href=FloorServlet?mode=read&update=true&id=<%= f.getId() %>><font color="red">Edit</font> this Floor</a></td>
				<td><a href=FloorServlet?mode=delete&id=<%= f.getId() %>><font color="red">Delete</font> this Floor</a></td>
			</tr>
			<% 
				} 
			%>
		
		</table>
	
			<form id="floatright" action="FloorServlet?mode=insert" method="post">
				<!--III sezione di pagina IN MAIN  -->
				<div class="row">
					<!-- IV sezione in III in MAIN -->
					<div class="col-75">
				 		<label for="number_floor">Floor Number</label>
					</div>
					<div class="col-75">
						<input type="text" id="number_floor" name="number_floor" placeholder="Inserisci piano:">
					</div>
		
				</div>
				<button type="submit">Conferma Inserimento</button>
			</form>	
	
			</div>
		<br>
		<br>
<%@include file="../css/footer.jsp" %>
</body>
</html>




