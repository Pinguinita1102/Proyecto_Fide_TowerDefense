package com.mycompany.proyecto_fide_towerdefense;
public class Cola {//Atributos de la cola
    private NodoC frente;
    private NodoC ultimo;
    private int largo;

    public Cola() { //Constructor
        this.frente = null;
        this.ultimo = null;
        this.largo = 0;
    }
    
    //Métodos
    public void encola(NodoC nuevoNodoC) { //Agrega los nodos a la cola
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
    
    public NodoC atiende(){ //Va revisando los nodos de la cola y los elimina de ella
        NodoC aux = frente;
        if(frente != null) {
            frente=frente.getAtras();
            aux.setAtras(null);
            largo--;
        }
        return aux;
    }
    
    
    public String imprimir(){ //Método para imprimir la cola
        String s = "";
        NodoC aux = frente;
        while(aux != null) {
            s += aux.getDato().getNombre()+" ("+aux.getDato().getJugador()+")\n";
            aux = aux.getAtras();
        }
        return s;
    }    
}