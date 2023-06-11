package com.example.lab7.models.beans.seleccion;

import java.sql.Date;

public class Partido {
    private int idPartido;
    private Date fecha;
    private int seleccionLocal;
    private int seleccionVisitante;

    public Partido() {

    }
    public Partido(int idPartido, Date fecha, int seleccionLocal, int seleccionVisitante) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.seleccionLocal = seleccionLocal;
        this.seleccionVisitante = seleccionVisitante;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getSeleccionLocal() {
        return seleccionLocal;
    }

    public void setSeleccionLocal(int seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public int getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public void setSeleccionVisitante(int seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }
}
