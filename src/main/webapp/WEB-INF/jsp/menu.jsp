<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <div class="row">
        <div class="col-6 col-md-2"></div>
            <div class="col-6 col-md-8">    
                <div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 10px;">
                    <nav class="navbar navbar-light bg-light">
                        <a class="btn btn-sm btn-outline-success" href="${pageContext.request.contextPath}/welcome">Inicio</a>
                        <a class="btn btn-sm btn-info" href="${pageContext.request.contextPath}/addNewVehiculo">Datos de validaci&oacute;n</a>
                        <a class="btn btn-sm btn-info" href="${pageContext.request.contextPath}/getVehiculos">Detalle Total</a>
                        <a class="btn btn-sm btn-info" href="${pageContext.request.contextPath}/acercade">Acerca de</a>
                        <a class="btn btn-sm btn-danger" style="color: white;" onclick="document.forms['logoutForm'].submit()">Salir</a>

                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    </form>

                    </nav>
                </div>

            </div>
        </div>
    </div>
</div>
