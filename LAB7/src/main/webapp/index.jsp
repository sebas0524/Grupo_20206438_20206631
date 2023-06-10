<%@ page import="com.example.lab7.models.beans.jugador.Jugador" %>
<%@ page import="java.util.ArrayList" %>


<!--Colocar como value: nombre de la presente página -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  ArrayList<Jugador> listaJugador = (ArrayList<Jugador>) request.getAttribute("indexJugador"); %>
<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de Jugadores"/>
</jsp:include>
<body>
<div class='container'>
    <jsp:include page="/navbar/navbar.jsp">
        <jsp:param name="page" value=""/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista de Jugadores</h1>
            <a type="button" class="btn btn-warning" href="<%=request.getContextPath()%>/">Crear Nueva Playlist</a>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <th>#ID</th>
            <th>Nombre</th>
            <th>Edad</th>
            <th>Posicion</th>
            <th>Club</th>
            <th>Seleccion</th>
            <th></th>
            </thead>
            <%
                for (Jugador jugador : listaJugador) {
            %>
            <tr>
                <td><%=jugador.getIdJugador()%>
                </td>
                <td><%=jugador.getNombre()%>
                </td>
                <td>
                    <%=jugador.getEdad()%>
                </td>
                <td>
                    <%=jugador.getPosicion()%>
                </td>
                <td>
                    <%=jugador.getClub()%>
                </td>
                <td>
                    <%=jugador.getSelecion().getNombre()%>
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