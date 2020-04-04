<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "it.contrader.dto.ParkingplaceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href= "../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Parkingplace</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class = "navbar">
<a href="homeadmin.jsp">Home</a>
<a class="active" href="ParkingplaceServlet?mode=parkingplacelist">Parkingplaces</a>
<a href="LogoutServlet" id="Logout">Logout</a>
</div>
<br>
<div class= "main">

<%ParkingplaceDTO u = (ParkingplaceDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ParkingplaceServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class ="row">
    <div class="col-25">
      <label for="parkingplace">Number</label>
    </div>
    <div class="col-75">
      <input type="text" id="parkingplce" name="numberplace" value=<%=u.getNumberplace()%>>
   		</div>
   	</div>
      <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>






