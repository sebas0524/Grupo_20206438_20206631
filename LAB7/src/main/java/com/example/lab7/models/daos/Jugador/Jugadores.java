package com.example.lab7.models.daos.Jugador;

import com.example.lab7.models.beans.jugador.Jugador;
import com.example.lab7.models.beans.seleccion.Seleccion;
import com.example.lab7.models.daos.BaseDao;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Jugadores extends BaseDao {

    public ArrayList<Jugador> listarJugadores(){
        ArrayList<Jugador> lista=new ArrayList<>();
        String sql="SELECT idJugador, j.nombre, edad,posicion,club,s.nombre from jugador j\n" +
                "inner join seleccion s on j.sn_idSeleccion=s.idSeleccion\n" +
                "where j.idJugador=? ;\n";

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
                jugador.setSelecion(resultSet.);

                Seleccion seleccion=new Seleccion();
                
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }




}
