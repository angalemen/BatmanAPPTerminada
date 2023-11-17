package com.example.apipokemon;

public class Batman {

   private String idJuego;

   private String nombreJuego;

   private double precioJuego;

   private String urlImagen;

   private String imagen;

    public Batman() {
    }

    public Batman(String idJuego, String nombreJuego, double precioJuego, String urlImagen, String imagen) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.precioJuego = precioJuego;
        this.urlImagen = urlImagen;
        this.imagen = imagen;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public double getPrecioJuego() {
        return precioJuego;
    }

    public void setPrecioJuego(double precioJuego) {
        this.precioJuego = precioJuego;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Batman{" +
                "idJuego='" + idJuego + '\'' +
                ", nombreJuego='" + nombreJuego + '\'' +
                ", precioJuego='" + precioJuego + '\'' +
                ", urlImagen='" + urlImagen + '\'' +
                '}';
    }
}
