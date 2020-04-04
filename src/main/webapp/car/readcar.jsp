<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CarDTO" %>
    
<!-- dichiarazione -->
<!DOCTYPE html>

<html>

<!-- contenitore per metadati e si mette tra il tag html e body-->
<head>

<!-- Per visualizzare correttamente una pagina HTML, il browser deve sapere quale set di caratteri (codifica) utilizzare: -->
<meta charset="ISO-8859-1">

<title>Read Car</title>
</head>

<body>

<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="CarServlet?mode=carlist">Car</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<% CarDTO c = (CarDTO) request.getAttribute("dto");%>

<!-- fa una tabella -->
<table>
	<tr> 
		<th>Model</th>
		<th>License</th>

	</tr>
	<tr>
		<td><%=c.getModel()%></td>
		<td> <%=c.getLicense()%></td>
		
	</tr>	
</table>

<br>



</div>

<%@ include file="../css/footer.jsp" %>

</body>
</html>