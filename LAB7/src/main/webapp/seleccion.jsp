<%@ page import="com.example.lab7.models.beans.seleccion.Seleccion" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Kots
  Date: 6/9/2023
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  ArrayList<Seleccion> listaSeleccion = (ArrayList<Seleccion>) request.getAttribute("listaSeleccionFechas"); %>
<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Selecciones"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/navbar/navbar.jsp">
    <jsp:param name="page" value="seleccion"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="col-lg-6">
      <h1 class='text-light'>Selecciones del mundial</h1>
      <a type="button" class="btn btn-warning" href="<%=request.getContextPath()%>/creaSeleccion">Registra una nueva seleccion</a>
    </div>
  </div>
  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <th>#ID</th>
      <th>Nombre</th>
      <th>Tecnico</th>
      <th>Estadio</th>
      <th>Proximo partido</th>
      <th></th>
      </thead>
      <%
        for (Seleccion seleccion : listaSeleccion) {
      %>
      <tr>
        <td><%=seleccion.getIdSeleccion()%>
        </td>
        <td><%=seleccion.getNombre()%>
        </td>
        <td>
          <%=seleccion.getTecnico()%>
        </td>
        <td>
          <%=seleccion.getEstadio().getNombre()%>
        </td>
        <td>
          <%=seleccion.getPartidoProximo()%>
        </td>
        <td>
          <a><a type="button" class="btn btn-danger" href="<%=request.getContextPath()%>/listaSelecciones">eliminar</a></a>
        </td>
      </tr>
      <%
        }
      %>
    </table>
  </div>

</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>