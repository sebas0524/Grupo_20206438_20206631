package com.example.lab7.models.beans.seleccion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Seleccion {
    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private Estadio estadio;
    private ArrayList<Partido> partido;
    private String partidoProximo;

    public ArrayList<Partido> getPartido() {
        return partido;
    }

    public void setPartido(ArrayList<Partido> partido) {
        this.partido = partido;
    }

    public String getPartidoProximo() {
        return partidoProximo;
    }

    public void setPartidoProximo(String partidoProximo) {
        this.partidoProximo = partidoProximo;
    }

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }
}
