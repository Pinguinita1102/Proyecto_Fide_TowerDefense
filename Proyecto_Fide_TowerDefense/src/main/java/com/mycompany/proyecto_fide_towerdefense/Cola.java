package com.mycompany.proyecto_fide_towerdefense;
public class Cola {
    private NodoC frente;
    private NodoC ultimo;
    private int largo;

    public Cola() {
        this.frente = null;
        this.ultimo = null;
        this.largo = 0;
    }
    
    public void encola(NodoC nuevoNodoC) {
        if(frente == null) { //Significa que la cola está vacía
            frente = nuevoNodoC;
            ultimo = nuevoNodoC;
        }
        else {
            ultimo.setAtras(nuevoNodoC);
            ultimo=nuevoNodoC;
        }
        largo++;
    }
    
    public NodoC atiende(){
        NodoC aux = frente;
        if(frente != null) {
            frente=frente.getAtras();
            aux.setAtras(null);
            largo--;
        }
        return aux;
    }
    
    
    public String imprimir(){
        String s = "";
        NodoC aux = frente;
        while(aux != null) {
            s += aux.getDato().getNombre()+" ("+aux.getDato().getJugador()+")\n";
            aux = aux.getAtras();
        }
        return s;
    }    
}