
package com.mycompany.proyecto_fide_towerdefense;

/**
 *
 * @author valem
 */
public class Castillo {
    private int vida;
    

    public Castillo(int vida) {
        this.vida = 100;
    }
    
    public void unaBaja(int cantidad){
        vida -= cantidad;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
    
    
}
