
package com.mycompany.proyecto_fide_towerdefense;

/**
 *
 * @author valem
 */
public class Mago extends Tropas{//El extends es para llamar a los atributos de Tropas a esta clase
    public Mago(int jugador) {
        super("Mago", jugador, 10, 50);//El super es para llamar a el constructor del padre de mago que seria Tropa()
    }//Ese es ek orden del constructor de Tropas() y el parametro jugador es dependiendo asi que ese se rellena con el dato de la celda
    
    //Cualquier metodo especifico del mago va en esta clase
}
