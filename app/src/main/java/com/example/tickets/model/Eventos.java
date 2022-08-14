package com.example.tickets.model;

import java.util.Date;

public class Eventos {
    private int id;
    private String nombre;
    private String description;
    private String fecha;
    private Double precio;
    private String Lugar;
    private String image_url;
    private String ver_instagram;
    private String codigoqr;
    private Boolean evento_valido;

    public Boolean getEvento_valido() {
        return evento_valido;
    }

    public void setEvento_valido(Boolean evento_valido) {
        this.evento_valido = evento_valido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getVer_instagram() {
        return ver_instagram;
    }

    public void setVer_instagram(String ver_instagram) {
        this.ver_instagram = ver_instagram;
    }

    public String getCodigoqr() {
        return codigoqr;
    }

    public void setCodigoqr(String codigoqr) {
        this.codigoqr = codigoqr;
    }
}
