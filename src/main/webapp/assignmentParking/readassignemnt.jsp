<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "it.contrader.dto.AssignmentParkingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read AssignmentParking</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="AssignmentParkingServlet?mode=assignmentParkinglist"></a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<br>

<div class="main">
<%AssignmentParkingDTO apd =(AssignmentParkingDTO) request.getAttribute("assignmentParkingDTO"); %>


<table>
    <tr>
        <th>idCar</th>
        <th>idPostoAuto</th>
    </tr>
    <tr>
        <td><%=apd.getIdCar() %></td>
        <td><%=apd.getIdPostiAuto() %></td>
    </tr>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>
