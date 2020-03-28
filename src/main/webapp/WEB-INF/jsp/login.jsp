<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login-Vikings S.A.</title>
 
    <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

</head>

<body>
<br><br><br><br><br><br><br><br><br><br><br>
<h1 style="text-align: center;">Vikings SA</h1>

<div class="container">
    <div class="row">
        <div class="col-6 col-md-4"></div>
        <div class="col-6 col-md-4">
            <form method="POST" action="${contextPath}/login" class="form-signin">
                <h2 class="form-heading" style="text-align: center;">Login</h2>

                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${msg}</span>
                    <input name="username" type="text" class="form-control" placeholder="Usuario"
                        autofocus="true"/>
                    <input name="password" type="password" class="form-control" placeholder="Contrase&ntilde;a"/>
                    <span>${errorMsg}</span>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
                </div>

            </form>
        </div>
        <div class="col-6 col-md-4"></div>
    </div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></body>
</html>
