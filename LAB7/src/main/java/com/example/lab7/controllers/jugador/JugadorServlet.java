package com.example.lab7.controllers.jugador;

import com.example.lab7.models.beans.jugador.Jugador;
import com.example.lab7.models.beans.seleccion.Seleccion;
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
        String action=request.getParameter("a")==null ? "listarJugadores":request.getParameter("a");

        switch(action){
            case "listarJugadores":
            request.setAttribute("listaJugador",jugadorDao.listarJugadores());
            request.getRequestDispatcher("listaJugadores.jsp").forward(request,response);
                break;
            case "crearJugador":
                request.getRequestDispatcher("nuevoJugador.jsp").forward(request,response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JugadorDao jugadorDao=new JugadorDao();
        Jugador jugador =parseJugador(request);
        jugadorDao.crearJugador(jugador);
    }
    public Jugador parseJugador(HttpServletRequest request){
        Jugador jugador = new Jugador();
        Seleccion seleccion=new Seleccion();

        String idJugadorStr =request.getParameter("idJugador")!=null ? request.getParameter("idJugador") : "";
        String nombre=request.getParameter("nombre");
        String edadStr=request.getParameter("edad");
        String posicion=request.getParameter("posicion");
        String club=request.getParameter("club");
        String seleccion1=request.getParameter("seleccion");
        seleccion.setNombre(seleccion1);

        try{
            int idJugador=Integer.parseInt(idJugadorStr);
            int edad=Integer.parseInt(edadStr);
            jugador.setIdJugador(idJugador);
            jugador.setNombre(nombre);
            jugador.setEdad(edad);
            jugador.setPosicion(posicion);
            jugador.setClub(club);
            jugador.setSelecion(seleccion);

            return jugador;
        }catch (NumberFormatException e){

        }
        return jugador;


    }
}
