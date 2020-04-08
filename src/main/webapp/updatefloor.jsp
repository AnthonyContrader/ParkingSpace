<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.FloorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Floor Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">

<title>Edit Floor</title>
</head>
<body>

	<%@ include file="./css/header.jsp" %>
	<div class="navbar">
		<a href="homeadmin.jsp">Home</a>
	</div>
	
	<div class="main">
		
		<% FloorDTO fDTO = (FloorDTO) request.getSession().getAttribute("dto_update"); %>
		
		<form id="floatcenter" action="/floor/update" method="post">
			<div class="row">
				<div class="col-75">
					<label for="num_floor">Number Floor</label>
						<div class="col-75">
								<input type="text" id="num_floor" name="number_floor" value=<%=fDTO.getNumberfloor()%>>
								<input type="hidden" id="id" name="id" value=<%=fDTO.getId()%>>
						</div>
				</div>
			</div>
			<button type="submit">Confirm Editing</button>
		</form>
		
	</div>
	<br>
	<%@ include file="./css/footer.jsp" %>
</body>
</html>