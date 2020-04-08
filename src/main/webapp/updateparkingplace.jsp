<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="it.contrader.dto.ParkingplaceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Parkingplace</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/parkingplace/getall">Parkingplaces</a>
  <a href="/parkingplace/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ParkingplaceDTO p = (ParkingplaceDTO) request.getSession().getAttribute("dto");%>

<form id="floatleft" action="/parkingplace/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="parkingplace">Numberplace</label>
    </div>
    <div class="col-75">
      <input type="text" id="parkingplace" name="numberplace" value=<%=p.getNumberplace()%>>
    </div>
    <input type="hidden" name="id" value =<%=p.getId() %>>
  </div>
<button type ="submit">Edit</button>
</form>

</div>
<br>
<%@ include file = "./css/footer.jsp" %>
</body>
</html>