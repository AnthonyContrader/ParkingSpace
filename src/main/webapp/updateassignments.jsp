<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import= "it.contrader.dto.AssignmentParkingDTO"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Car Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">

<title>Edit Car</title>
</head>
<body>

<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/car/getall">Cars</a>
  <a href="/car/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%AssignmentParkingDTO apd = (AssignmentParkingDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/assignments/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="car">Car</label>
    </div>
    <div class="col-75">
      <input type="text" id="car" name="model" value=<%=apd.getCar()%>>
    </div>
    <div class="col-25">
      <label for="parkingplace">PostoAuto</label>
    </div>
    <div class="col-75">
      <input type="text" id="parkingplace" name="model" value=<%=apd.getPark()%>>
    </div>
  </div>
  <div class="row">
   
    	<input type="hidden" name="id" value =<%=apd.getId() %>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
	</div>
<br>
<%@ include file="./css/footer.jsp" %>	

</body>
</html>