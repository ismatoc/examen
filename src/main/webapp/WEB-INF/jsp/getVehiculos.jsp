<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Detalle Vehiculos</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
	<div class="container">
		<center><jsp:include page="menu.jsp" /></center>
		<div class="row">
			<div class="col-6 col-md-4"></div>
			<div class="col-6 col-md-4">    
		
		<h3 style="color: rgb(0, 4, 255); align-content: center;">Detalle Total</h3>
		<ul>
			<c:forEach var="listValue" items="${vehiculos}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>
	</div>
	</div>
	</div>
</body>
</html>