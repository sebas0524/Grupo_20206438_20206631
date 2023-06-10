package com.example.lab7.controllers.seleccion;

import com.example.lab7.models.beans.seleccion.Seleccion;
import com.example.lab7.models.daos.seleccion.SeleccionDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SeleccionServlet", value = {"/SeleccionServlet","/listaSelecciones"})
public class SeleccionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SeleccionDao seleccionDa = new SeleccionDao();
        request.setAttribute("listaSeleccion",seleccionDa.listarSelecciones());
        request.getRequestDispatcher("seleccion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
