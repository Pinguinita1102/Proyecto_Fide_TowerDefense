package com.mycompany.proyecto_fide_towerdefense;

public class Tropa {//Atributos de la tropa
    private String nombre;//tropa
    private String jugador;
    private double danio;
    private int camino;

    public Tropa(String nombre, String jugador, double danio, int camino) { //Constructor lleno
        this.nombre = nombre; //El nombre de la tropa
        this.jugador = jugador;//El jugador que lo envio
        this.danio = danio;//El danio que hace esa tropa
        this.camino = camino; //El camino que elija el jugador
    }

    public Tropa(String nombre, String jugador) { //Constructor
        this.nombre = nombre;
        this.jugador = jugador;
    }

    public Tropa(String jugador) { //Constructor
        this.jugador = jugador;
    }
    
    public Tropa(){ //Constructor
    }
    
    //Setters and Getters
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

    public double getDanio() {
        return danio;
    }

    public void setDanio(double danio) {
        this.danio = danio;
    }

    public int getCamino() {
        return camino;
    }

    public void setCamino(int camino) {
        this.camino = camino;
    }
}