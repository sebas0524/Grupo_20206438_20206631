package com.example.lab7;

import java.io.*;
import java.util.ArrayList;

import com.example.lab7.models.daos.Jugador.JugadorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/hello-servlet",""})
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JugadorDao jugadorDao=new JugadorDao();
        request.setAttribute("indexJugador",jugadorDao.listarJugadores());
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}