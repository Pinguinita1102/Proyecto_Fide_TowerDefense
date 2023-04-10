package com.mycompany.proyecto_fide_towerdefense;
public class Mago extends Tropa{//El extends es para llamar a los atributos de Tropa a esta clase
    public Mago(String jugador) {
        super("Mago", jugador, 1.5,1);//El super es para llamar a el constructor del padre de 
        //mago que seria Tropa()
        //Ese es el orden del constructor de Tropa() y el parametro jugador es dependiendo asi que ese se 
        //rellena con el dato de la celda
    }
    
    //Cualquier metodo especifico del mago va en esta clase
}