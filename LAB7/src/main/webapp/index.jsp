
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Clasificatorias Sudamericanas Mundial 2026"/>
</jsp:include>
<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/navbar/navbar.jsp">
        <jsp:param name="page" value=""/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <h1 class='text-light'>Bienvenido, estos son los integrantes del grupo</h1>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>NOMBRE</th>
                <th>ROL</th>
                <th>CORREO</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>1
                </td>
                <td>Ricardo Bravo Wong
                </td>
                <td>tu chero
                </td>
                <td>a20206331@pucp.edu.pe
                </td>
            </tr>

            <tr>
                <td>2
                </td>
                <td>Tarmeño alias Paypal
                </td>
                <td>hijo
                </td>
                <td>diaz.oa@pucp.edu.pe
                </td>
            </tr>



            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
