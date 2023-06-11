package com.example.lab7.controllers.seleccion;

import com.example.lab7.models.beans.seleccion.Estadio;
import com.example.lab7.models.beans.seleccion.Seleccion;
import com.example.lab7.models.daos.seleccion.EstadioDao;
import com.example.lab7.models.daos.seleccion.SeleccionDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CrearSeleccionServlet", value = {"/CrearSeleccionServlet","/creaSeleccion"})
public class CrearSeleccionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SeleccionDao seleccionDao = new SeleccionDao();
        EstadioDao estadioDao = new EstadioDao();
        //request.setAttribute("listaSeleccionFechas",seleccionDao.listarSeleccionesFechas());
        request.setAttribute("listaEstadio",estadioDao.listarEstadios());
        request.setAttribute("listaSeleccion",seleccionDao.listarSelecciones());
        request.getRequestDispatcher("nuevaSeleccion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String action = request.getParameter("p") == null ? "crear" : request.getParameter("p");
        SeleccionDao seleccionDao = new SeleccionDao();
        Seleccion seleccion = parseSeleccion(request);
        if(seleccion!=null){
            boolean centinela = false;
            //boolean prueba = true;
            for(Seleccion selec: seleccionDao.listarSelecciones()){
                if(selec.getNombre().equals(seleccion.getNombre())){
                    centinela = true;

                }
            }
            boolean prueba = seleccion.getNombre().isEmpty() || seleccion.getTecnico().isEmpty() || seleccion.getEstadio().getEstadios_idEstadios()==0;

            if(!centinela && !prueba){
                seleccionDao.crearSeleccion(seleccion);
                response.sendRedirect(request.getContextPath()+"/listaSelecciones");
            } else{
                response.sendRedirect(request.getContextPath()+"/creaSeleccion");
            }
        }
        else{
            response.sendRedirect(request.getContextPath()+"/creaSeleccion");
        }
        //response.sendRedirect(request.getContextPath() + "/listaSelecciones");
    }

    public Seleccion parseSeleccion(HttpServletRequest request) {
        Seleccion seleccion = new Seleccion();
        Estadio estadio2 = new Estadio();

        String nombre = request.getParameter("nombre");
        String tecnico = request.getParameter("tecnico");
        String estadio = request.getParameter("idEstadio");
        try {
            seleccion.setNombre(nombre);
            seleccion.setTecnico(tecnico);
            estadio2.setEstadios_idEstadios(Integer.parseInt(estadio));
            seleccion.setEstadio(estadio2);
            return seleccion;
        } catch (NumberFormatException e) {

        }
        return seleccion;
    }

}
