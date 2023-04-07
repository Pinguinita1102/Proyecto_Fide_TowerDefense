
package com.mycompany.proyecto_fide_towerdefense;

/**
 *
 * @author valem
 */
public class Caballero extends Tropas{//El extends es para llamar a los atributos de Tropas a esta clase
    
    public Caballero(int jugador) {
        super("Caballero", jugador, 20, 100);//El super es para llamar a el constructor del padre de caballero que seria Tropa()
        //Ese es ek orden del constructor de Tropas() y el parametro jugador es dependiendo asi que ese se rellena con el dato de la celda
    }
    
    //Cualquier metodo especifico del caballero va en esta clase
    
}
