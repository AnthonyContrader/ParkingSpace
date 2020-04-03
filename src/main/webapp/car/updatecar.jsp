<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CarDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Car</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="CarServlet?mode=carlist">Cars</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class= "main">

<%CarDTO c = (CarDTO) request.getAttribute("dto");%>

<form id="floatleft" action="CarServlet?mode=update&id=<%=c.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="car">Model</label>
    </div>
    <div class="col-75">
      <input type="text" id="car" name="model" value=<%=c.getModel()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="lic">License</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="lic" name="license" value=<%=c.getLicense()%>> 
    </div>
  </div>
  
   	
      <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>