package com.example.practicarecyclerview;

import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    private String categoría;
    private String temporada;
    private double precioCompra;

    public Producto(String nombre, String categoría, String temporada, double precioCompra) {
        this.nombre = nombre;
        this.categoría = categoría;
        this.temporada = temporada;
        this.precioCompra = precioCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }
}
