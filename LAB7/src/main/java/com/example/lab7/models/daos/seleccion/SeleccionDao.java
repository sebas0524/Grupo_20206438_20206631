package com.example.lab7.models.daos.seleccion;

import com.example.lab7.controllers.seleccion.SeleccionServlet;
import com.example.lab7.models.beans.seleccion.Estadio;
import com.example.lab7.models.beans.seleccion.Partido;
import com.example.lab7.models.beans.seleccion.Seleccion;
import com.example.lab7.models.daos.BaseDao;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao {
    public ArrayList<Seleccion> listarSelecciones() {
        ArrayList<Seleccion> lista = new ArrayList<>();

        String sql = "select ( s.idSeleccion) as \"ID\" , s.nombre, s.tecnico, e.idEstadio, e.nombre as \"estadio\", concat(sl.nombre,\" vs \",sv.nombre) as \"Partido\",\n" +
                "\t\tp.idPartido,p.fecha,p.seleccionLocal,p.seleccionVisitante\n" +
                " from seleccion s\n" +
                "inner join estadio e on s.estadio_idEstadio = e.idEstadio\n" +
                "inner join partido p on p.seleccionLocal = s.idSeleccion or p.seleccionVisitante = s.idSeleccion\n" +
                "inner join seleccion sl on sl.idSeleccion = p.seleccionLocal\n" +
                "inner join seleccion sv on sv.idSeleccion = p.seleccionVisitante\n" +
                "where p.fecha = (\n" +
                "    select min(fecha) from partido\n" +
                "    where seleccionLocal = s.idSeleccion or seleccionVisitante = s.idSeleccion\n" +
                ");";
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


/*
    public ArrayList<Carrito> listarSelecciones(){
        ArrayList<Carrito> lista = new ArrayList<>();
        String sql = "select * from carrito c \n" +
                "inner join videojuegos v on v.idVideojuego = c.Videojuegos_idVideojuego\n" +
                "inner join videojuegoGeneral vg on v.idVideojuegoGeneral = vg.idVideojuegoGeneral\n" +
                "where Usuarios_idUsuario = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            //pstmt.setInt(1, Integer.parseInt(idUsuario));
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    Carrito carrito = new carrito();
                    Videojuegos game = new Videojuegos();
                    game.setIdVideojuego(resultSet.getInt(1));
                    game.setNombre(resultSet.getString("NombreVideojuego"));
                    game.setDescripcion(resultSet.getString("descripcion"));
                    game.setPrecio(resultSet.getDouble("precio"));
                    game.setImagen(resultSet.getString("imagen"));

                    Categoria categoria = new Categoria(resultSet.getInt("idCategoria"),resultSet.getString("cat.nombre"));
                    game.setCategoria(categoria);
                    Consola consola = new Consola(resultSet.getString("c.nombre"),resultSet.getInt("idConsola"));
                    game.setConsola(consola);
                    game.setIdEstadosVideojuego(resultSet.getInt("idEstadosVideojuego"));
                    game.setIdVideojuego(resultSet.getInt("idVideojuego"));




                    carrito.setVideojuegos_idVideojuego(resultSet.getInt(1));
                    carrito.setVideojuegos_idVideojuego(resultSet.getInt(2));
                    carrito.setCantidad(resultSet.getInt(3));

                    lista.add(game);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;

    }
*/

}
