package com.mycompany.proyecto_fide_towerdefense;
public class Celda {
    private String nombre;//tropa
    private String jugador;

    public Celda(String nombre, String jugador) {
        this.nombre = nombre;
        this.jugador = jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
}