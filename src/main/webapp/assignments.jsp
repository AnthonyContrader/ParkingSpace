<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AssignmentParkingDTO" import="java.util.*"
    						  import="it.contrader.dto.CarDTO"
    						  import="it.contrader.dto.ParkingplaceDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">

<title>Assignments Manager</title>
</head>
<body>

	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/assignmentParking/getall">Assignments</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
		List<AssignmentParkingDTO> list = (List<AssignmentParkingDTO>) request.getSession().getAttribute("list");
		//System.out.println("size of assiList: "+ list.size());
		//List<CarDTO> carList            = (List<CarDTO>) request.getSession().getAttribute("carList");
		//System.out.println("size di carlist:" + carList.size());
    	//List<ParkingplaceDTO> pList     = (List<ParkingplaceDTO>) request.getAttribute("parkList");
    	//System.out.println("size of pp list: "+pList.size());
		%>

		<br>

		<table>
			<tr>
				<th>ID</th>
			    <th>car</th>
				<th>PostoAuto</th>
				<th>entryDate</th>
				<th>entryTime</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (AssignmentParkingDTO apd : list) {
				
			%>
			<tr>
				<td><a href="/assignmentParking/read?id=<%=apd.getId()%>"> <%=apd.getId()%></a></td>
				<td><%=apd.getCar().getLicense()%></td>
				<td><%=apd.getPark().getNumberplace()%></td>
				<td><%=apd.getEntryDate()%></td>
				<td><%=apd.getEntryTime()%></td>
				<td><a href="/assignmentParking/preupdate?id=<%=apd.getId()%>">Edit</a></td>


				<td><a href="/assignmentParking/delete?id=<%=apd.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>

<form id="floatright" action="/assignmentParking/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="car">Car</label>
				</div>
				<div class="col-75">
					<input type="text" id="car" name="license"
						placeholder="inserisci car">
				</div>
				<div class="col-25">
					<label for="id">Parkingplace</label>
				</div>
				<div class="col-75">
					<input type="text" id="id" name="numberplace"
						placeholder="inserisci numberplace">
				</div>
				
				</div>
                       <button type="submit">Insert</button>
</form>

		
		
		
		
		<%-- <form id="floatright" action="/assignmentParking/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="car">License</label>
				</div>
				<div class="col-75">
					<select id="car" name="License">
         				<%
         					for(CarDTO car: carList){
         						
         				%>
         					<option>value="<%=car.getLicense()%>"> <%=car.getLicense()%></option>
         				<%
         				    }
         				%>
                   </select> 
			
			<button type="submit">Insert</button>
			
		</form> --%>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>