<%@ page import="it.contrader.dto.PersonDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Person Managment">
<meta name="author"  content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Person Manager</title>
</head>

<body>
		<%@ include file="./css/header.jsp" %>
		
		<div class="navbar">
			<a href="/homeadmin.jsp">Home</a> <a class="active"
			   href="/person/getall">Persons</a>
		
		
		</div>
		<div class="main">
				<%
					List<PersonDTO> listPerson = (List<PersonDTO>) request.getSession().getAttribute("list");
				%>
			    <br>
			    
			    <table>
			    	<tr>
			    	    <th>FirstName</th>
			    	    <th>SecondName</th>
			    	    <th></th>
			    	    <th></th>
			    	</tr>
			    	<%
			    		for(PersonDTO per : listPerson){
			    	%>
			    	<tr>
			    		<td><a href="/person/read?id=<%=per.getId()%>"> <%=per.getFirstName() %></a></td>
			    		
			    		<td><%=per.getSecondName() %></td>
			    		
			    		<td><a href="/person/preupdate?id=<%=per.getId() %>">Edit</a></td>
			    		
			    		<td><a href="/person/delete?id=<%=per.getId() %>">Delete</a></td>
			        </tr>
			        <%
			    		}
			        %>
			    </table>
			    
			    
			    <form id="floatright"  action="/person/insert" method="post">
			    	<div class="row"></div>
			    		<div class="col-25">
			    			<label for="fname">firstName</label>
			    		</div>
			    		<div class="col-75">
			    			<input type="text" id="fname" name="firstName"
			    				   placeholder="inserisci firstName">
			    		</div>
			    
			    		<div class="row">
			    			<div class="col-25">
			    				<label for="sname">secondName</label>
			    			</div>
			    		</div>
			    		<div>
			    		<div class="col-25">
			    			<input type="text" id="sname" name="secondName" >
			    		</div>
			    				 
			    		</div>
			    		<button type="submit">Insert</button>
			    </form>
			<br>
	<%@ include file="./css/footer.jsp"%>


</body>
</html>