package com.example.lab7.models.daos.Jugador;

import com.example.lab7.models.beans.jugador.Jugador;
import com.example.lab7.models.beans.seleccion.Seleccion;
import com.example.lab7.models.daos.BaseDao;

import java.sql.*;
import java.util.ArrayList;

public class JugadorDao extends BaseDao {

    public ArrayList<Jugador> listarJugadores(){
        ArrayList<Jugador> lista=new ArrayList<>();
        String sql="SELECT idJugador, j.nombre, edad,posicion,club,s.nombre as \"seleccion\"  from jugador j\n" +
                "inner join seleccion s on j.sn_idSeleccion=s.idSeleccion\n";

        try(Connection connection=this.getConnection();
        Statement stmt= connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql)){

            while(resultSet.next()){
                Jugador jugador=new Jugador();
                jugador.setIdJugador(resultSet.getInt(1));
                jugador.setNombre(resultSet.getString(2));
                jugador.setEdad(resultSet.getInt(3));
                jugador.setPosicion(resultSet.getString(4));
                jugador.setClub(resultSet.getString(5));

                Seleccion seleccion=new Seleccion();
                //seleccion.setIdSeleccion(resultSet.getInt("s.idSeleccion"));
                seleccion.setNombre(resultSet.getString("seleccion"));
                //ESTA ES OTRA OPCION QUE SE PODRIA UTILIZAR.
                //Seleccion seleccion=new Seleccion(resultSet.getInt("s.idSeleccion"),resultSet.getString("s.nombre"));
                jugador.setSelecion(seleccion);

                lista.add(jugador);

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public void crearJugador(Jugador jugador){

        /*
        String sql=
        try(Connection connection=this.getConnection();
        PreparedStatement pstmt= connection.prepareStatement()){


        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
         */
    }
}
