package com.example.lab7.models.beans.seleccion;

public class Estadio {
    private String nombre;
    private int estadios_idEstadios;


    public Estadio(int estadios_idEstadios,String nombre) {
        this.nombre = nombre;
        this.estadios_idEstadios = estadios_idEstadios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstadios_idEstadios() {
        return estadios_idEstadios;
    }

    public void setEstadios_idEstadios(int estadios_idEstadios) {
        this.estadios_idEstadios = estadios_idEstadios;
    }
}
