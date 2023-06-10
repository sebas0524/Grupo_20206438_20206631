package com.example.lab7.models.daos.seleccion;

import com.example.lab7.models.beans.seleccion.Estadio;
import com.example.lab7.models.beans.seleccion.Seleccion;
import com.example.lab7.models.daos.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EstadioDao extends BaseDao{


    public ArrayList<Estadio> listarEstadios() {
        ArrayList<Estadio> lista = new ArrayList<>();

        String sql = "select * from estadio;";
        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Estadio estadio = new Estadio(resultSet.getInt("idEstadio"),resultSet.getString("nombre"));
                lista.add(estadio);
            }

        } catch (SQLException e) {
            System.out.println("No se pudo conectar");
            throw new RuntimeException(e);
        }
        return lista;
    }

}
