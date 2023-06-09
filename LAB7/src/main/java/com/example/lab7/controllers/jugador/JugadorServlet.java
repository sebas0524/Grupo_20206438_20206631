package com.example.lab7.controllers.jugador;

import com.example.lab7.models.daos.Jugador.JugadorDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "JugadorServlet", value = {"/JugadorServlet","/listaJugadores"})
public class JugadorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JugadorDao jugadorDao=new JugadorDao();
        request.setAttribute("listaJugador",jugadorDao.listarJugadores());
        request.getRequestDispatcher("listaJugadores.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
