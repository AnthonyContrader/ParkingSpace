<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    						  import="java.util.ArrayList"
                              import="it.contrader.dto.AssignmentParkingDTO"
                              import="it.contrader.dto.CarDTO"
                              import="it.contrader.dto.ParkingplaceDTO"%>
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
            List<AssignmentParkingDTO> aList = (List<AssignmentParkingDTO>) request.getAttribute("list");
        	List<CarDTO> carList             = (List<CarDTO>) request.getAttribute("listcar");
        	List<ParkingplaceDTO> pList             = (List<ParkingplaceDTO>) request.getAttribute("listparking");
        %>
<br>
     <table>
         <tr>
                <th>idCar</th>
                <th>idPosto</th>
                <th>entryDate</th>
                <th>entryTime</th>
                <th>totalPrice</th>
                <th></th>
                <th></th>
         </tr>
         <%
             for(AssignmentParkingDTO apd: aList) {
         %>
         <tr>
                 <td>
                     <a href=AssignmentParkingServlet?mode=read&id=<%=apd.getId()%>>
                     <%=apd.getIdCar()%></a>
                 </td>

                 <td><%=apd.getIdPostiAuto()%></td>
                 <td><%=apd.getEntryDate()%></td>
                 <td><%=apd.getEntryTime()%></td>
                 <td><%=apd.calculateTotalPrice()%></td>
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
            <label for="asseg">IdCar</label>
        </div>
         <div class="col-75">
        </div>
    
     
         <select id="asseg" name="idCar">
         
        <%
         	 List<Integer> one1 = new ArrayList<>();
             List<Integer> two1 = new ArrayList<>();
             List<Integer> tre1 = new ArrayList<>();
             for(CarDTO pp: carList) {
            	 one1.add(pp.getId());}
             for(AssignmentParkingDTO apd: aList){
           	     two1.add(apd.getIdCar());}
             one1.removeAll(two1); 
             for(int i=0;i<one1.size();i++) {
            	 tre1.add(one1.get(i));
             }
             System.out.println(tre1);
             for(int i=0;i<tre1.size();i++){
         %>
                 <option value="<%=tre1.get(i)%>"> <%=tre1.get(i)%>
                 </option>       
                  
         <%
              }
          %>       	
          </select> 
       
         
       </div> 
        <div class="col-25">
            <label for="asseg">IdPostoAuto</label>
        </div>
         <div class="col-75">
        </div>
    
     
         <select id="asseg" name="idPostoAuto">
         <%
         	 List<Integer> one = new ArrayList<>();
             List<Integer> two = new ArrayList<>();
             List<Integer> tre = new ArrayList<>();
             for(ParkingplaceDTO pp: pList) {
            	 one.add(pp.getId());}
             for(AssignmentParkingDTO apd: aList){
           	     two.add(apd.getIdPostiAuto());}
             one.removeAll(two); 
             for(int i=0;i<one.size();i++) {
            	 tre.add(one.get(i));
             }
             System.out.println(tre);
             for(int i=0;i<tre.size();i++){
         %>
                 <option value="<%=tre.get(i)%>"> <%=tre.get(i)%>
                 </option>       
                  
         <%
              }
          %>
                         	
          </select> 
          <button type="submit" >Insert</button>
</form>
</div>
<br>
<%@include file="../css/footer.jsp" %>
</body>
</html>
