<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de Validacion</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>

<body>
	<div class="container">
		<center><jsp:include page="menu.jsp" /></center>
		<div class="row">
			<div class="col-6 col-md-4"></div>
			<div class="col-6 col-md-4">   
	<h3 style="color: red;">Agregar Vehiculo</h3>

	<div id="addVehiculo">
		<form:form action="/addNewVehiculo" method="post"
			modelAttribute="veh">
			<p>
				<label>Marca</label>
				<form:input path="marca" />
			</p>
			<p>
				<label>Modelo</label>
				<form:input path="modelo" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>

</div>
</div>
</div>
</body>
</html>
