package com.example.lab7;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/hello-servlet",""})
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //TourDao tourDao = new TourDao();
        //ArrayList<Tour> listaTours = tourDao.obtenerListaTours();
        RequestDispatcher view =request.getRequestDispatcher("index.jsp");
        view.forward(request,response);
    }

    public void destroy() {
    }
}