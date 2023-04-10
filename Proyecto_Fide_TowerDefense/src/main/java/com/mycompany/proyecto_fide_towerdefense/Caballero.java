package com.mycompany.proyecto_fide_towerdefense;
public class Caballero extends Tropa{//El extends es para llamar a los atributos de Tropa a esta clase
    public Caballero(String jugador) {
        super("Caballero", jugador, 2.0, 1);//El super es para llamar a el constructor del padre de 
        //padre de caballero que seria Tropa()
        //Ese es el orden del constructor de Tropa() y el parametro jugador es dependiendo asi que ese se 
        //rellena con el dato de la celda
    }
    
    //Cualquier metodo especifico del caballero va en esta clase
}