<%--
  Created by IntelliJ IDEA.
  User: sebas
  Date: 9/06/2023
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Nuevo Jugador"/>
</jsp:include>
<body>
<div class='container'>
    <jsp:include page="/navbar/navbar.jsp">
        <jsp:param name="page" value="jugadores"/>
    </jsp:include>
    <div class="container">
        <h1 class='mb-3'>Crear un nuevo trabajo</h1>
        <form method="POST" action="<%=request.getContextPath()%>/JugadorServlet">
            <div class="mb-3">
                <label for="idJugador">ID Jugador</label>
                <input type="text" class="form-control" name="idJugador" id="idJugador">
            </div>
            <div class="mb-3">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" name="nombre" id="nombre">
            </div>
            <div class="mb-3">
                <label for="edad">Edad</label>
                <input type="text" class="form-control" name="edad" id="edad">
            </div>
            <div class="mb-3">
                <label for="posicion">Posicion</label>
                <input type="text" class="form-control" name="posicion" id="posicion">
            </div>
            <div class="mb-3">
                <label for="club">Club</label>
                <input type="text" class="form-control" name="club" id="club">
            </div>
            <div class="form-group">
                <label for="seleccion">Selección</label>
                <select  name="seleccion" id="seleccion" class="form-control">
                    <% for (Jugador jugador : listaSelecciones) {%>
                    <option value="<%=%>"
                </select>
                <input type="text" class="form-control" name="seleccion" id="seleccion">
            </div>
            <a class="btn btn-danger" href="<%=request.getContextPath()%>/JobServlet">Cancelar</a>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>

</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>