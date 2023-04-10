package com.mycompany.proyecto_fide_towerdefense;
public class NodoC {
    private Tropa dato;
    private NodoC atras;
    
    public NodoC(Tropa dato) {
        this.dato = dato;
        this.atras = null;
    }

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