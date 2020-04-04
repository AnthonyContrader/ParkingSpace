<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.List"
    import= "it.contrader.dto.CarDTO"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Car Manager</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="CarServlet?mode=carlist">Cars</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<CarDTO> list = (List<CarDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		    <th></th>
			<th>Model</th>
			<th>License</th>
			<th></th>
			<th></th>
			
		</tr>
		<%
			for (CarDTO c : list) {
		%>
		<tr>
			<td><a href=CarServlet?mode=read&id=<%=c.getId()%>>
					
			</a></td>
			<td><%=c.getModel()%></td>
			<td><%=c.getLicense()%></td>
			
			<td><a href=CarServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CarServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="CarServlet?mode=insert" method="post">

  <div class="row">
    <div class="col-25">
      <label for="car">Model</label>
    </div>
    
    <div class="col-75">
      <input type="text" id="car" name="model" placeholder="inserisci modello">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="lic">License</label>
    </div>
    <div class="col-75">
      <input type="text" id="lic" name="license" placeholder="inserisci targa"> 
    </div>
  </div>
  

      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>


















</body>
</html>