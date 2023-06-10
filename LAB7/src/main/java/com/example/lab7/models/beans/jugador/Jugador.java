package com.example.lab7.models.beans.jugador;

import com.example.lab7.models.beans.seleccion.Seleccion;

public class Jugador {
    private int idJugador;
    private String nombre;
    private int edad;
    private String posicion;
    private String club;
    private Seleccion seleccion;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Seleccion getSelecion() {
        return seleccion;
    }

    public void setSelecion(Seleccion selecion) {
        this.seleccion = selecion;
    }
}
