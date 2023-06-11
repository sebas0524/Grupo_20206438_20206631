<%@ page import="com.example.lab7.models.beans.seleccion.Seleccion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab7.models.beans.seleccion.Estadio" %><%--
  Created by IntelliJ IDEA.
  User: Kots
  Date: 6/10/2023
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Estadio> listaEstadio = (ArrayList<Estadio>) request.getAttribute("listaEstadio");%>
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
    <h1 style="color:white;"  class='mb-3'>Registrar nueva seleccion</h1>
    <form method="POST" action="<%=request.getContextPath()%>/creaSeleccion">

      <div class="mb-3">
        <label style="color:white;" for="nombre">Nombre</label>
        <input type="text" class="form-control" name="nombre" id="nombre">
      </div>
      <div class="mb-3">
        <label style="color:white;" for="tecnico">Tecnico</label>
        <input type="text" class="form-control" name="tecnico" id="tecnico">
      </div>

        <label style="color:white;" for="idEstadio">Estadio</label>
        <select  name="idEstadio" id="idEstadio" class="form-control">
          <option value="0">Escoja un estadio</option>
          <% for (Estadio estadio : listaEstadio) {%>
          <option value="<%=estadio.getEstadios_idEstadios()%>"><%=estadio.getNombre()%>
          </option>
          <%}%>
        </select>
      <a class="btn btn-danger" href="<%=request.getContextPath()%>/listaSelecciones">Cancelar</a>
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