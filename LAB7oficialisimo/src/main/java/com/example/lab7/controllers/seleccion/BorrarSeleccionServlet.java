package com.example.lab7.controllers.seleccion;

import com.example.lab7.models.beans.jugador.Jugador;
import com.example.lab7.models.beans.seleccion.Seleccion;
import com.example.lab7.models.daos.Jugador.JugadorDao;
import com.example.lab7.models.daos.seleccion.SeleccionDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BorrarSeleccionServlet", value = "/BorrarSeleccionServlet")
public class BorrarSeleccionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SeleccionDao seleccionDao = new SeleccionDao();
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        boolean tienePartido = false;

        for (Seleccion seleccionLista : seleccionDao.listaSeleccionPartido()) {
            if (seleccionLista.getIdSeleccion() == id) {
                tienePartido = seleccionLista.getIdPartido()!=0;

            }
        }
        if (tienePartido) {
            response.sendRedirect(request.getContextPath() + "/listaSelecciones");

        } else {
            JugadorDao jugadorDao = new JugadorDao();
            boolean tieneJugador = false;
            for (Jugador jugador : jugadorDao.listarJugadores()) {
                if (jugador.getSelecion().getIdSeleccion() == id) {
                    tieneJugador = true;
                }
            }
            if(tieneJugador){
                jugadorDao.borrarJugador(idStr);
                seleccionDao.borrarSeleccion(idStr);
                response.sendRedirect(request.getContextPath() + "/listaSelecciones");
            }else{
                seleccionDao.borrarSeleccion(idStr);
                response.sendRedirect(request.getContextPath() + "/listaSelecciones");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
