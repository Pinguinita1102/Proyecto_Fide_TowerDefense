package com.mycompany.proyecto_fide_towerdefense;

public class MatrizB {
    private boolean ocupado;//Esta variable es para ver si una celda del camino se encuentra ocupada por eso esta en 
    //booleano
    private int jugador;//Esto es para saber a quien pertenece la tropa en ese caso si es del jugador 1 entonces se 
    //pone un 1 y si es del jugador 2 un 2
    //Y si esta vacia un 0
    
    public MatrizB() {
        ocupado = false;
        jugador = 0;
    }
    
    public void ColocarTropa(int jugador) {//Coloca la celda como ocupada y el numero del jugador
        ocupado = true;
        this.jugador = jugador;
    }
    
     public void desocupar() {//Vacia la celda
        ocupado = false;
        jugador = 0;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public int getJugador() {
        return jugador;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }
}