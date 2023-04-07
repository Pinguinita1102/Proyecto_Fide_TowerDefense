
package com.mycompany.proyecto_fide_towerdefense;

/**
 *
 * @author valem
 */
public class Tropas {
    private String tropa;//tropa
    private int jugador;
    private int danio;
    private int vida;

    public Tropas(String tropa, int jugador, int danio, int vida) {
        this.tropa = tropa;
        this.jugador = jugador;//El jugador que lo envio
        this.danio = danio;//El danio que hace esa tropa
        this.vida = vida;//La vida que le queda
    }

    public void moverT(Camino camino) {
        // mover la tropa por el camino, por medio del objeto camino se mueve a estos datos por la matriz (Camino)
    }

    public void hacerDanio(Castillo castillo) {
        castillo.unaBaja(danio);//De parámetro agarra un objeto Castillo y llama al método recibirAtaque() del castillo para causarle danio
    }

    public String getTropa() {
        return tropa;
    }

    public void setTropa(String tropa) {
        this.tropa = tropa;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
}
