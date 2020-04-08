<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PersonDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Person Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Person</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/person/getall">Persons</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	<div class="main">

		<%PersonDTO per = (PersonDTO) request.getSession().getAttribute("dto");%>


		<form id="floatleft" action="/person/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="fname">firstName</label>
				</div>
				<div class="col-75">
					<input type="text" id="fname" name="firstName"
						value=<%=per.getFirstName()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="surn">secondName</label>
				</div>
				<div class="col-75">
					<input type="text" id="surn" name="secondName"
						value=<%=per.getSecondName()%>>
				</div>
			</div>
			
				<input type="hidden" name="id" value=<%=per.getId() %>>
		
			<button type="submit">Edit</button>
	    
		</form>
	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>