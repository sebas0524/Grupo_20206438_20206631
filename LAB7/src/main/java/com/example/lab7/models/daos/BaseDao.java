package com.example.lab7.models.daos;
import java.sql.*;

public abstract class BaseDao {
    public Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/lab7";
        String user = "root";
        String pass = "123456";

        return DriverManager.getConnection(url,user,pass);
    }
}

