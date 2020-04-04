<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.List" import ="it.contrader.dto.ParkingplaceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Parking Manager</title>
</head>
<%@ include file="../css/header.jsp" %>
<body>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="ParkingplaceServlet?mode=parkingplacelist">Parkingplaces</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class ="main">
<%
List<ParkingplaceDTO> list = (List<ParkingplaceDTO>) request.getAttribute("list");
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
			<td><a href=ParkingplaceServlet?mode=read&id=<%=p.getId()%>>

			</a></td>
			<td><%=p.getNumberplace()%></td>
			<td><a href=ParkingplaceServlet?mode=read&update=true&id=<%=p.getId()%>>Edit</a>
			</td>
			<td><a href=ParkingplaceServlet?mode=delete&id=<%=p.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ParkingplaceServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="parkingplace">Number</label>
    </div>
    <div class="col-75">
      <input type="text" id="parkingplace" name="numberplace" placeholder="inserisci numberplace">
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>


