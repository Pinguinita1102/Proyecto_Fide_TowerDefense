
package com.mycompany.proyecto_fide_towerdefense;

/**
 *
 * @author valem
 */
public class Arquero extends Tropas{//El extends es para llamar a los atributos de Tropas a esta clase
    
    public Arquero(int jugador) {
        super("Arquero", jugador, 15, 75);//El super es para llamar a el constructor del padre de arquero que seria Tropa()
    }//Ese es ek orden del constructor de Tropas() y el parametro jugador es dependiendo asi que ese se rellena con el dato de la celda
    
    //Cualquier metodo especifico del arquero va en esta clase
}
