package com.example.lab7.models.daos.seleccion;

import com.example.lab7.controllers.seleccion.SeleccionServlet;
import com.example.lab7.models.beans.seleccion.Estadio;
import com.example.lab7.models.beans.seleccion.Partido;
import com.example.lab7.models.beans.seleccion.Seleccion;
import com.example.lab7.models.daos.BaseDao;
import com.mysql.cj.jdbc.ConnectionImpl;
import jakarta.servlet.http.Part;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao {
    public ArrayList<Seleccion> listarSelecciones() {
        ArrayList<Seleccion> lista = new ArrayList<>();

        String sql = "select s.idSeleccion as \"ID\", s.nombre, s.tecnico, e.idEstadio, e.nombre as \"estadio\",\n" +
                "       concat(sl.nombre, \" vs \", sv.nombre) as \"Partido\", p.idPartido, p.fecha, p.seleccionLocal, p.seleccionVisitante\n" +
                "from seleccion s\n" +
                "inner join estadio e on s.estadio_idEstadio = e.idEstadio\n" +
                "left join partido p on p.seleccionLocal = s.idSeleccion or p.seleccionVisitante = s.idSeleccion\n" +
                "left join seleccion sl on sl.idSeleccion = p.seleccionLocal\n" +
                "left join seleccion sv on sv.idSeleccion = p.seleccionVisitante\n" +
                "where p.fecha = (select MIN(fecha) from partido\n" +
                "                 where seleccionLocal = s.idSeleccion or seleccionVisitante = s.idSeleccion)\n" +
                "                 or not exists (select 1 from partido p2\n" +
                "                                where p2.seleccionLocal = s.idSeleccion or p2.seleccionVisitante = s.idSeleccion);";
        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(resultSet.getInt("ID"));
                seleccion.setNombre(resultSet.getString("nombre"));
                seleccion.setTecnico(resultSet.getString("tecnico"));

                Estadio estadio = new Estadio(resultSet.getInt("idEstadio"),resultSet.getString("estadio"));
                seleccion.setEstadio(estadio);
/*
                Partido partido = new Partido(resultSet.getInt("idPartido"),resultSet.getDate("fecha"),
                        resultSet.getInt("seleccionLocal"),resultSet.getInt("seleccionVisitante"));*/
                //ArrayList<Partido> listaPartidos = new ArrayList<>();
                //listaPartidos.add(partido);
                seleccion.setPartidoProximo(resultSet.getString("Partido"));
                lista.add(seleccion);
            }

        } catch (SQLException e) {
            System.out.println("No se pudo conectar");
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void crearSeleccion(Seleccion seleccion){
        String sql = "insert into seleccion ( nombre, tecnico, estadio_idEstadio) \n" +
                "values (?,?,?);";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1,seleccion.getNombre());
            pstmt.setString(2,seleccion.getTecnico());
            pstmt.setInt(3,seleccion.getEstadio().getEstadios_idEstadios());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Seleccion> listaSeleccionPartido(){
        ArrayList<Seleccion> listaPartidos = new ArrayList<>();
        String sql="select ( s.idSeleccion) as \"ID\" , s.nombre, s.tecnico, e.idEstadio, e.nombre as \"estadio\", concat(sl.nombre,\" vs \",sv.nombre) as \"Partido\",\n" +
                "\t\tp.idPartido,p.fecha,p.seleccionLocal,p.seleccionVisitante\n" +
                " from seleccion s\n" +
                "inner join estadio e on s.estadio_idEstadio = e.idEstadio\n" +
                "inner join partido p on p.seleccionLocal = s.idSeleccion or p.seleccionVisitante = s.idSeleccion\n" +
                "inner join seleccion sl on sl.idSeleccion = p.seleccionLocal\n" +
                "inner join seleccion sv on sv.idSeleccion = p.seleccionVisitante order by s.nombre";
        try(Connection connection=getConnection();
            Statement stmt=connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while(resultSet.next()){
                Seleccion seleccion= new Seleccion();

                /*ArrayList<Partido> listaPartidosXSeleccion= new ArrayList<>();
                Partido partido = new Partido();
                partido.setIdPartido(resultSet.getInt("idPartido"));
                listaPartidosXSeleccion.add(partido);
                if(resultSet.getInt(1)==idSeleccion){
                    Seleccion seleccion= new Seleccion();
                    Partido partido2 = new Partido();
                    partido2.setIdPartido(resultSet.getInt("idPartido"));
                    listaPartidosXSeleccion.add(partido2);
                }
                else{
                    Seleccion seleccion= new Seleccion();
                }*/

                seleccion.setIdSeleccion(resultSet.getInt(1));
                seleccion.setNombre(resultSet.getString("nombre"));
                seleccion.setTecnico(resultSet.getString(3));
                seleccion.setIdPartido(resultSet.getInt("idPartido"));
                Estadio estadio= new Estadio();
                estadio.setNombre(resultSet.getString("estadio"));
                seleccion.setEstadio(estadio);
                listaPartidos.add(seleccion);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaPartidos;
    }
    public void borrarSeleccion(String idSeleccion){
        String sql="DELETE FROM seleccion WHERE idSeleccion=?";
        try(Connection connection=this.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql)){

            pstmt.setString(1,idSeleccion);
            pstmt.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
