package com.mycompany.proyecto_fide_towerdefense;
public class Castillo {
    private String jugador;
    private double vida;

    public Castillo(String jugador, double vida) {
        this.jugador = jugador;
        this.vida = vida;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    
    @Override
    public String toString() {
        
        return "\n^-^-^-^-^-^-^  \n"
                + "|    "+vida+"     |\n"
                + "|   Vida    |\n"
                + "|   "+jugador+"    |\n"
                + "-------------";
    }
}