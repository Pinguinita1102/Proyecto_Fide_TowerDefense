package com.mycompany.proyecto_fide_towerdefense;
public class Arquero extends Tropa{//El extends es para llamar a los atributos de Tropa a esta clase
    public Arquero(String jugador) {
        super("Arquero", jugador, 1.0,1);//El super es para llamar a el constructor del padre de 
        //arquero que seria Tropa()
        //Ese es el orden del constructor de Tropa() y el parametro jugador es dependiendo asi que ese se rellena 
        //con el dato de la celda
    }
    
    //Cualquier metodo especifico del arquero va en esta clase
}