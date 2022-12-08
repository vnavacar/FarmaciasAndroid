package com.example.farmaciasandroid;


import android.graphics.Bitmap;

import java.util.Date;
public class Farmacia {

    private int id;
    private String titulo;

    private String telefono;
    private double latitud;
    private double longitud;


    public Farmacia(int id, String titulo, String telefono, double latitud, double longitud) {
        this.id = id;
        this.titulo = titulo;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public Farmacia(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public double getLatitud() {
        return latitud;
    }
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    public double getLongitud() {
        return longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

}