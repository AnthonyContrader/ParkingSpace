<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
                              import="it.contrader.dto.AssignmentParkingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AssignmentParking Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
        <a href="homeadmin.jsp"> Home </a>
        <a class="active" href="AssignmentParkingServlet?mode=assignmentParkingList">Assegnazione</a>
</div>

<div class="main">
        <%
            List<AssignmentParkingDTO> list = (List<AssignmentParkingDTO>) request.getAttribute("list");
        %>
<br>
     <table>
         <tr>
                <th>idCar</th>
                <th>idPosto</th>
                <th>entryDate</th>
                <th>entryTime</th>
                <th></th>
                <th></th>
         </tr>
         <%
             for(AssignmentParkingDTO apd: list) {
         %>
         <tr>
                 <td>
                     <a href=AssignmentParkingServlet?mode=read&id=<%=apd.getId()%>>
                     <%=apd.getIdCar()%></a>
                 </td>

                 <td><%=apd.getIdPostiAuto()%></td>
                 <td><%=apd.getEntryDate()%></td>
                 <td><%=apd.getEntryTime()%></td>

                 <td>
                     <a href=AssignmentParkingServlet?mode=read&update=true&id=<%=apd.getId()%>> Edit </a>
                         </td>

                         <td>
                             <a href=AssignmentParkingServlet?mode=delete&id=<%=apd.getId()%>> Delete </a>
                         </td>
         </tr>
         <%
             }
         %>
     </table>

<form id="floatright" action="AssignmentParkingServlet?mode=insert" method="post">
    <div class="row">
        <div class="col-25">
            <label for="asseg">Id Car</label>
        </div>
        <div class="col-75">
            <input type="text" id="asseg" name="id_car" placeholder="inserisci idCar">
        </div>
     </div>
     <div class="row">
    <div class="col-25">
     <label for="asseg">Id PostoAuto</label>
    </div>
    <div class="col-75">
      <input type="text" id="asseg" name="idPostoAuto" placeholder="inserisci idPostoAuto">
    </div>
  </div>
  <button type="submit" >Insert</button>
</form>


</div>
<br>
<%@include file="../css/footer.jsp" %>
</body>
</html>
