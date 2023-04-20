package com.mycompany.proyecto_fide_towerdefense;

import java.util.Random;
import java.util.Scanner;

public class Juego {  
    Random random = new Random();
    int oleada;    
    Cola colaP1 = new Cola();
    Cola colaCPU = new Cola();

    Camino camino = new Camino();
    Celda celda = new Celda();
    
    
    
    public void inicio(){
        System.out.println("Reglas del Juego: \n"
                + "\t >> Tu objetivo es destruir el castillo de tu oponente y proteger el tuyo. Cada castillo tiene "
                + "10 puntos de vida.\n"
                + "\t >> Debes elegir entre los tres tipos de tropas disponibles: \n"
                + "\t \t - Mago: El mago le gana en combate a los caballeros. Su debilidad son los arqueros." 
                + "Contra el castillo genera 1.5 puntos de daño.\n"
                + "\t \t - Caballero: El caballero le gana en combate a los arqueros. Su debilidad son los magos." 
                + "Contra el castillo genera 2 puntos de daño.\n"
                + "\t \t - Arquero: El arquero le gana en combate a los magos. Su debilidad son los caballeros." 
                + " Contra el castillo genera 1 punto de daño.\n"
                + "\t >> La cantidad de tropas es limitada.\n"
                + "\t >> Hay dos caminos disponibles para llegar a los castillos. \n"
                + "\t >> El juego termina cuando alguno de los castillos es destruido completamente.\n\n");
        oleada = 1;
        selecciónDeTropas();
        combate();
    }
        
    public void selecciónDeTropas(){
        int contCamino0=0;
        int contCamino1=0;
        int contTotal=0;
        
        Scanner sn = new Scanner(System.in);
        int tipoDeTropa; //Guardaremos el tipo de tropa que elija el jugador
        int caminoS; //Guardaremos el camino que elija el jugador
        
        //Turno del CPU de elegir tropa y camino, de manera aleatoria
        for(int x=1; x <= oleada+3; x++){
            System.out.println("Selección de Tropa #: "+ (x) +"\n\n");
            System.out.println("El CPU va a elegir uno de los siguientes tipos de tropa\n\n");
            System.out.println("0- Mago");
            System.out.println("1- Caballero");
            System.out.println("2- Arquero\n\n");
            tipoDeTropa = getRndTropa();

            System.out.println("El CPU va a elegir uno de los caminos para desplegar la tropa\n\n");
            System.out.println("0- Camino Superior");
            System.out.println("1- Caminio Inferior");
            
            
            //caminoS = getRndCamino();
            caminoS = getRndCamino(contCamino0, contCamino1, contTotal);
            
            if (tipoDeTropa == 0){
                colaCPU.encola(new NodoC(new Tropa("Mago","CPU", 1.5, caminoS)));
                if(x <=3){
                    System.out.println("El CPU ha seleccionado la siguiente Tropa: Mago, Camino (0- Superior, "
                            + "1- Inferior): "+ caminoS);
                    System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
                else {
                    System.out.println("El CPU ha seleccionado la siguiente Tropa: ???, Camino: ???");
                    //System.out.println("El CPU ha seleccionado la siguiente Tropa: Mago, Camino (0- Superior, "
                    //        + "1- Inferior): "+ caminoS);
                    System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
            }
            else if (tipoDeTropa == 1){
                colaCPU.encola(new NodoC(new Tropa("Caballero","CPU", 2.0, caminoS)));
                 if(x <=3){
                     System.out.println("El CPU ha seleccinado la siguiente Tropa: Caballero, Camino (0- Superior, "
                             + "1- Inferior): "+ caminoS);
                     System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
                else {
                    System.out.println("El CPU ha seleccionado la siguiente Tropa: ???, Camino: ???");
                    //System.out.println("El CPU ha seleccinado la siguiente Tropa: Caballero, Camino (0- Superior, "
                    //         + "1- Inferior): "+ caminoS);
                    System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
            }
            else if (tipoDeTropa == 2){
                colaCPU.encola(new NodoC(new Tropa("Arquero","CPU", 1.0, caminoS)));
                if(x <=3){
                    System.out.println("El CPU ha seleccinado la siguiente Tropa: Arquero, Camino (0- Superior, "
                             + "1- Inferior): "+ caminoS);
                    System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
                else {
                    System.out.println("El CPU ha seleccionado la siguiente Tropa: ???, Camino: ???");
                    //System.out.println("El CPU ha seleccinado la siguiente Tropa: Arquero, Camino (0- Superior, "
                    //         + "1- Inferior): "+ caminoS);
                    System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
            }
            else {
                System.out.println("No ingresaste un número válido");
            }
        }
        
        //Es el turno del jugador de escoger su tropa y el camino
        for (int x=1; x <= oleada+4; x++){
            System.out.println("Selección de Tropa #: "+ (x) +"\n\n");
            System.out.println("Elije uno de los siguientes tipos de tropa\n\n");
            System.out.println("0- Mago");
            System.out.println("1- Caballero");
            System.out.println("2- Arquero\n\n");
            tipoDeTropa = sn.nextInt();

            System.out.println("Elije uno de los caminos para desplegar la tropa\n\n");
            System.out.println("0- Camino Superior");
            System.out.println("1- Caminio Inferior");
            caminoS = sn.nextInt();

            if (tipoDeTropa == 0){
                colaP1.encola(new NodoC(new Tropa("Mago","P1", 1.5, caminoS)));
                System.out.println("Tropa: Mago, Camino (0- Superior, 1- Inferior): "+ caminoS);
                System.out.println("==========================================================="
                            + "=========\n\n  ");
            }
            else if (tipoDeTropa == 1){
                colaP1.encola(new NodoC(new Tropa("Caballero","P1", 2.0, caminoS)));
                System.out.println("Tropa: Caballero, Camino (0- Superior, 1- Inferior): "+ caminoS);
                System.out.println("==========================================================="
                            + "=========\n\n  ");
            }
            else if (tipoDeTropa == 2){
                colaP1.encola(new NodoC(new Tropa("Arquero","P1", 1.0, caminoS)));
                System.out.println("Tropa: Arquero, Camino (0- Superior, 1- Inferior): "+ caminoS);
                System.out.println("==========================================================="
                            + "=========\n\n  ");
            }
            else {
                System.out.println("No ingresaste un número válido");
            }
        }
        
        System.out.println("Selección del CPU");
        System.out.println(colaCPU.imprimir());
        System.out.println("Selección del P1");
        System.out.println(colaP1.imprimir());

        
    }
    
    private int getRndTropa(){ //Se genera un número aleatorio ente 0 y 2, para las tropas del CPU
        int trop = random.nextInt(3);
        return trop;
    }
    
    /*/private int getRndCamino(){
        int cam = random.nextInt(2);
        return cam;
    }/*/
    
    private int getRndCamino(int x, int y, int z){ //Se genera un número aleatorio entre 0 y 1, para el camino del CPU
        // x: contCamino0, y: contCamino1, z: contTotal
        int cam;
        
        if (z <=2){
            cam = random.nextInt(2);
        }
        else {
            cam = random.nextInt(2);
            double porcC0 = (x/z);
            double porcC1 = (y/z);
            if (porcC0 >= 0.75){
                cam = 1;
                x++;
                z++;
            }
            else if(porcC1 >= 0.75){
                cam = 0;
                y++;
                z++;
            }
        }
        return cam;
    }
    
    /*/private int validacionCamino() {
            
            if (ca == 0 ){
                contCamino0++;
                contTotal++;
            }
            else if(ca ==1){
                contCamino1++;
                contTotal++;
            }
            
            if ((contCamino0 / contTotal) <= 0.75){
                ca = 0;
                contCamino0++;
                contTotal++;
            }
            else if ((contCamino1 / contTotal) >= 0.75){
                ca = 1;
                contCamino1++;
                contTotal++;
            }
            return ca;
    }/*/
        
    public void combate() {
        
        
        int cP1 = colaP1.atiende().getDato().getCamino();
        int cCPU = colaCPU.atiende().getDato().getCamino();

        //Esta ser'ia la fila en la que inicia
        if (cP1 == 0) {
            if ("Mago".equals(colaP1.atiende().getDato().getNombre())) {
                String nombre = "P1/M";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(0, 0, nombre);
            }
            else if ("Caballero".equals(colaP1.atiende().getDato().getNombre())) {
                String nombre = "P1/C";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(0, 1, nombre);
            }
            else{
                String nombre = "P1/A";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(0, 2, nombre);
            }
            //String nombre = colaP1.atiende().getDato().getNombre();
            //Tropa nuevaCelda = new Tropa(nombre);
            //camino.enviarDato(0, 0, nuevaCelda);
            //String jugador = colaP1.atiende().getDato().getJugador();
            //nuevaCelda = new Tropa(jugador);
            //camino.enviarDato(0, 0, nuevaCelda);
            //camino[0][0].setNombre(colaP1.atiende().getDato().getNombre());
            //camino[0][0].setJugador(colaP1.atiende().getDato().getJugador());
            
        } else if (cP1 == 1) {
            if ("Mago".equals(colaP1.atiende().getDato().getNombre())) {
                String nombre = "P1/M";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(1, 0, nombre);
            }
            else if ("Caballero".equals(colaP1.atiende().getDato().getNombre())) {
                String nombre = "P1/C";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(1, 1, nombre);
            }
            else{
                String nombre = "P1/A";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(1, 2, nombre);
            }
            //String nombre = colaP1.atiende().getDato().getNombre();
            //Tropa nuevaCelda = new Tropa(nombre);
            //camino.enviarDato(1, 0, nuevaCelda);
            //String jugador = colaP1.atiende().getDato().getJugador();
            //nuevaCelda = new Tropa(jugador);
            //camino.enviarDato(1, 0, nuevaCelda);
            //camino[1][0].setNombre(colaP1.atiende().getDato().getNombre());
            //camino[1][0].setJugador(colaP1.atiende().getDato().getJugador());
        } else {
            System.out.println("No se detecta camino asignado");
        }
        //System.out.print(castilloP1);
        camino.imprimir();
        //System.out.print(castilloCPU);
        System.out.println();
        /*for (int x = 0; x < camino.length; x++) {
            for (int y = 0; y < camino[x].length; y++) {
                System.out.print(camino[x][y]);
            }
            System.out.print(castilloCPU);
            System.out.println();
        }*/

        if (cCPU == 1) {
            if ("Mago".equals(colaCPU.atiende().getDato().getNombre())) {
                String nombre = "CPU/M";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(0, 7, nombre);
            }
            else if ("Caballero".equals(colaCPU.atiende().getDato().getNombre())) {
                String nombre = "CPU/C";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(0, 6, nombre);
            }
            else{
                String nombre = "CPU/A";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(0, 5, nombre);
            }
            //String nombre = colaCPU.atiende().getDato().getNombre();
            //Tropa nuevaCelda = new Tropa(nombre);
            //camino.enviarDato(0, 8, nuevaCelda);
            //String jugador = colaCPU.atiende().getDato().getJugador();
            //nuevaCelda = new Tropa(jugador);
            //camino.enviarDato(0, 8, nuevaCelda);
            //camino[0][8].setNombre(colaCPU.atiende().getDato().getNombre());
            //camino[0][8].setJugador(colaCPU.atiende().getDato().getJugador());
            
        } else if (cCPU == 2) {
            if ("Mago".equals(colaCPU.atiende().getDato().getNombre())) {
                String nombre = "CPU/M";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(1, 7, nombre);
            }
            else if ("Caballero".equals(colaCPU.atiende().getDato().getNombre())) {
                String nombre = "CPU/C";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(1, 6, nombre);
            }
            else{//Arquero
                String nombre = "CPU/A";
                //Celda nuevaCelda = new Celda(nombre);
                camino.enviarDato(1, 5, nombre);
            }
            //String nombre = colaCPU.atiende().getDato().getNombre();
            //Tropa nuevaCelda = new Tropa(nombre);
            //camino.enviarDato(0, 8, nuevaCelda);
            //String jugador = colaCPU.atiende().getDato().getJugador();
            //nuevaCelda = new Tropa(jugador);
            //camino.enviarDato(0, 8, nuevaCelda);
            //camino[1][8].setNombre(colaCPU.atiende().getDato().getNombre());
            //camino[1][8].setJugador(colaCPU.atiende().getDato().getJugador());
        } else {
            System.out.println("No se detecta camino asignado");
        }
        //System.out.print(castilloP1);
        camino.imprimir();
        //System.out.print(castilloCPU);
        System.out.println();
        
        /*for (int x = 0; x < camino.length; x++) {
            for (int y = 0; y < camino[x].length; y++) {
                System.out.print(camino[x][y]);
            }
            System.out.print(castilloCPU);
            System.out.println();
        }*/
    }

}