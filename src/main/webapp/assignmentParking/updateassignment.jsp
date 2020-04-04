<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "it.contrader.dto.AssignmentParkingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit AssignmentParking</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="AssignmentParkingServlet?mode=assignmentParkinglist">Assegnazione</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<br>

<div class="main">
<%AssignmentParkingDTO apd =(AssignmentParkingDTO) request.getAttribute("assignmentParkingDTO"); %>
<form id="floatLeft" action="AssignmentParkingServlet?mode=update&id=<%=apd.getId() %>" method="post">

        <div class ="row">
        <div class="col-25">
            <label for="id_car">idCar</label>
        </div>
            <div class="col-75">
                <input type="text" id="id_car" name="id_car" value=<%=apd.getIdCar()%>>
            </div>
    </div>

    <div class="row">
        <div class="col-25">
            <label for="idPostoAuto">idPostoAuto</label>
        </div>
            <div class="col-75">
                <input type="text" id="idPostoAuto" name="idPostoAuto" value=<%=apd.getIdPostiAuto()%>>
            </div>
    </div>
    <button type="submit" >Edit</button>
</form>
</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>

     
