package com.example.lab7.controllers.jugador;

import com.example.lab7.controllers.seleccion.SeleccionServlet;
import com.example.lab7.models.beans.jugador.Jugador;
import com.example.lab7.models.beans.seleccion.Seleccion;
import com.example.lab7.models.daos.Jugador.JugadorDao;
import com.example.lab7.models.daos.seleccion.SeleccionDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "JugadorServlet", value = {"/JugadorServlet","/listaJugadores"})
public class JugadorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JugadorDao jugadorDao=new JugadorDao();
        SeleccionDao seleccionDao=new SeleccionDao();
        String action=request.getParameter("a")==null ? "listarJugadores":request.getParameter("a");

        switch(action){
            case "listarJugadores":
            request.setAttribute("listaJugador",jugadorDao.listarJugadores());
            request.getRequestDispatcher("listaJugadores.jsp").forward(request,response);
                break;
            case "crearJugador":
                request.setAttribute("listaSelecciones",seleccionDao.listarSelecciones());
                request.getRequestDispatcher("nuevoJugador.jsp").forward(request,response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JugadorDao jugadorDao=new JugadorDao();
        Jugador jugador =parseJugador(request);
        //boolean prueba = jugador.getNombre().isEmpty() && jugador.getEdad()==0 && jugador.getPosicion().isEmpty() && jugador.getClub().isEmpty()&& jugador.getSelecion().getPartido().isEmpty();
        //boolean Antiprueba = jugador.getNombre()==(null) || jugador.getEdad()==0 || jugador.getPosicion().equals(null) || jugador.getClub().equals(null) || jugador.getSelecion().equals(null);

        //jugador!=null
        if(jugador!=null){
            boolean centinela=false;
            //boolean prueba = true;

            for(Jugador jugador1:jugadorDao.listarJugadores()  ){
                if((jugador.getNombre().equals(jugador1.getNombre())) && (jugador.getSelecion().getIdSeleccion() == jugador1.getSelecion().getIdSeleccion())){
                    centinela=true;

                }
            }
            boolean prueba = jugador.getNombre().isEmpty() || jugador.getEdad()==0 || jugador.getPosicion().isEmpty() || jugador.getClub().isEmpty()|| jugador.getSelecion().getIdSeleccion()==0;

            if(!centinela && !prueba){
                jugadorDao.crearJugador(jugador);
                response.sendRedirect(request.getContextPath() + "/JugadorServlet?a=listarJugadores");
            }else{
                response.sendRedirect(request.getContextPath() + "/JugadorServlet?a=crearJugador");
            }
        }
        else{
            response.sendRedirect(request.getContextPath() + "/JugadorServlet?a=crearJugador");
        }
    }
    public Jugador parseJugador(HttpServletRequest request){
        Jugador jugador = new Jugador();
        Seleccion seleccion=new Seleccion();

        //String idJugadorStr =request.getParameter("idJugador")!=null ? request.getParameter("idJugador") : "";
        String nombre=request.getParameter("nombre");
        String edadStr=request.getParameter("edad");
        String posicion=request.getParameter("posicion");
        String club=request.getParameter("club");
        String seleccion1=request.getParameter("seleccion");

        seleccion.setIdSeleccion(Integer.parseInt(seleccion1));

        try{
           // int idJugador=Integer.parseInt(idJugadorStr);
            int edad=Integer.parseInt(edadStr);
            //jugador.setIdJugador(idJugador);
            jugador.setNombre(nombre);
            jugador.setEdad(edad);
            jugador.setPosicion(posicion);
            jugador.setClub(club);
            jugador.setSelecion(seleccion);

            return jugador;
        }catch (NumberFormatException e){
            return null;
        }
    }
}
