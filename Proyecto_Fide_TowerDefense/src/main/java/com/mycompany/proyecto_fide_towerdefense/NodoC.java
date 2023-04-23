package com.mycompany.proyecto_fide_towerdefense;
public class NodoC {//Atributos
    private Tropa dato;
    private NodoC atras;
    
    public NodoC(Tropa dato) { //Constructor
        this.dato = dato;
        this.atras = null;
    }

    //Setters and Getters
    public Tropa getDato() {
        return dato;
    }

    public void setDato(Tropa dato) {
        this.dato = dato;
    }

    public NodoC getAtras() {
        return atras;
    }

    public void setAtras(NodoC atras) {
        this.atras = atras;
    }
}