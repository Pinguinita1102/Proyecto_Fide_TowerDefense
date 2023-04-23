package com.mycompany.proyecto_fide_towerdefense;
import java.util.Random;
import java.util.Scanner;

public class Juego {  
    Random random = new Random();
    int oleada;    
    Cola colaP1 = new Cola();
    Cola colaCPU = new Cola();

    Camino camino = new Camino();
    
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
        while (camino.getCastilloP1().getVida() > 0 || camino.getCastilloCPU().getVida() > 0) {
            camino.limpiarArreglo();
            selecciónDeTropas();
            despliegue();
        }
        System.out.println("Juego Finalizado");
    }
        
    public void selecciónDeTropas(){
        int contCamino0=0;
        int contCamino1=0;
        int contTotal=0;
        
        Scanner sn = new Scanner(System.in);
        int tipoDeTropa; //Guardaremos el tipo de tropa que elija el jugador
        int caminoS; //Guardaremos el camino que elija el jugador
        
        System.out.println("Oleada #: "+ oleada +"\n\n");
        
        //Turno del CPU de elegir tropa y camino, de manera aleatoria
        for(int x=1; x <= oleada+3; x++){
            System.out.println("Selección de Tropa #: "+ (x) +"\n\n");
            System.out.println("El CPU va a elegir uno de los siguientes tipos de tropa\n\n");
            System.out.println("0- Mago");
            System.out.println("1- Caballero");
            System.out.println("2- Arquero\n\n");
            tipoDeTropa = getRndTropa();

            System.out.println("El CPU va a elegir uno de los caminos para desplegar la tropa\n\n");
            System.out.println("0- Camino Izquierdo");
            System.out.println("1- Caminio Derecho");
            
            
            caminoS = getRndCamino(contCamino0, contCamino1, contTotal);
            
            if (tipoDeTropa == 0){
                colaCPU.encola(new NodoC(new Tropa("Mago","CPU", 1.5, caminoS)));
                if(x <=3){
                    System.out.println("El CPU ha seleccionado la siguiente Tropa: Mago, Camino (0- Izquierdo, "
                            + "1- Derecho): "+ caminoS);
                    System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
                else {
                    System.out.println("El CPU ha seleccionado la siguiente Tropa: ???, Camino: ???");
                    //System.out.println("El CPU ha seleccionado la siguiente Tropa: Mago, Camino (0- Izquierdo, "
                            //+ "1- Derecho): "+ caminoS);
                    System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
            }
            else if (tipoDeTropa == 1){
                colaCPU.encola(new NodoC(new Tropa("Caballero","CPU", 2.0, caminoS)));
                 if(x <=3){
                     System.out.println("El CPU ha seleccionado la siguiente Tropa: Mago, Camino (0- Izquierdo, "
                            + "1- Derecho): "+ caminoS);
                     System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
                else {
                    System.out.println("El CPU ha seleccionado la siguiente Tropa: ???, Camino: ???");
                    //System.out.println("El CPU ha seleccionado la siguiente Tropa: Mago, Camino (0- Izquierdo, "
                    //        + "1- Derecho): "+ caminoS);
                    System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
            }
            else if (tipoDeTropa == 2){
                colaCPU.encola(new NodoC(new Tropa("Arquero","CPU", 1.0, caminoS)));
                if(x <=3){
                    System.out.println("El CPU ha seleccionado la siguiente Tropa: Mago, Camino (0- Izquierdo, "
                            + "1- Derecho): "+ caminoS);
                    System.out.println("==========================================================="
                            + "=========\n\n  ");
                }
                else {
                    System.out.println("El CPU ha seleccionado la siguiente Tropa: ???, Camino: ???");
                    //System.out.println("El CPU ha seleccionado la siguiente Tropa: Mago, Camino (0- Izquierdo, "
                    //        + "1- Derecho): "+ caminoS);
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
            System.out.println("0- Camino Izquierdo");
            System.out.println("1- Camino Derecho");
            caminoS = sn.nextInt();

            if (tipoDeTropa == 0){
                colaP1.encola(new NodoC(new Tropa("Mago","P1", 1.5, caminoS)));
                System.out.println("Tropa: Mago, Camino (0- Izquierdo, 1- Derecho): "+ caminoS);
                System.out.println("==========================================================="
                            + "=========\n\n  ");
            }
            else if (tipoDeTropa == 1){
                colaP1.encola(new NodoC(new Tropa("Caballero","P1", 2.0, caminoS)));
                System.out.println("Tropa: Caballero, Camino (0- Izquierdo, 1- Derecho): "+ caminoS);
                System.out.println("==========================================================="
                            + "=========\n\n  ");
            }
            else if (tipoDeTropa == 2){
                colaP1.encola(new NodoC(new Tropa("Arquero","P1", 1.0, caminoS)));
                System.out.println("Tropa: Arquero, Camino (0- Izquierdo, 1- Derecho): "+ caminoS);
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
        
    public void despliegue() {
        for(int x=1; x <= oleada+3; x++){
            Tropa tP1 = colaP1.atiende().getDato();
            int cP1 = tP1.getCamino(); //Esta sería la columna en la que inicia

            if (cP1 == 0) {
                if ("Mago".equals(tP1.getNombre())) {
                    String nombre = "P1/M";
                    camino.enviarDato(0, cP1, nombre);
                }
                else if ("Caballero".equals(tP1.getNombre())) {
                    String nombre = "P1/C";
                    camino.enviarDato(0, cP1, nombre);
                }
                else if ("Arquero".equals(tP1.getNombre())) {
                    String nombre = "P1/A";
                    camino.enviarDato(0, cP1, nombre);
                }
                else {
                    System.out.println("Tropa o camino no encontrado");
                }
            }

            else if (cP1 == 1) {
                if ("Mago".equals(tP1.getNombre())) {
                    String nombre = "P1/M";
                    camino.enviarDato(0, cP1, nombre);
                }
                else if ("Caballero".equals(tP1.getNombre())) {
                    String nombre = "P1/C";
                    camino.enviarDato(0, cP1, nombre);
                }
                else if ("Arquero".equals(tP1.getNombre())) {
                    String nombre = "P1/A";
                    camino.enviarDato(0, cP1, nombre);
                }
                else {
                    System.out.println("Tropa o camino no encontrado");
                }
            } 

            else {
                System.out.println("No se detecta camino asignado");
            }


            Tropa tCPU = colaCPU.atiende().getDato();
            int cCPU = tCPU.getCamino(); //Esta sería la columna en la que inicia

            if (cCPU == 0) {
                if ("Mago".equals(tCPU.getNombre())) {
                    String nombre = "CPU/M";
                    camino.enviarDato(4, cCPU, nombre);
                }
                else if ("Caballero".equals(tCPU.getNombre())) {
                    String nombre = "CPU/C";
                    camino.enviarDato(4, cCPU, nombre);
                }
                else if ("Arquero".equals(tCPU.getNombre())) {
                    String nombre = "CPU/A";
                    camino.enviarDato(4, cCPU, nombre);
                }
                else {
                    System.out.println("Tropa o camino no encontrado");
                }
            }

            else if (cCPU == 1) {
                if ("Mago".equals(tCPU.getNombre())) {
                    String nombre = "CPU/M";
                    camino.enviarDato(4, cCPU, nombre);
                }
                else if ("Caballero".equals(tCPU.getNombre())) {
                    String nombre = "CPU/C";
                    camino.enviarDato(4, cCPU, nombre);
                }
                else if ("Arquero".equals(tCPU.getNombre())) {
                    String nombre = "CPU/A";
                    camino.enviarDato(4, cCPU, nombre);
                }
                else {
                    System.out.println("Tropa o camino no encontrado");
                }
            }

            else {
                System.out.println("No se detecta camino asignado");
            }
            
            //camino.imprimir();
            System.out.println();
            camino.desplazamiento();
            
        }
        Tropa tP1 = colaP1.atiende().getDato();
            int cP1 = tP1.getCamino(); //Esta sería la columna en la que inicia

            if (cP1 == 0) {
                if ("Mago".equals(tP1.getNombre())) {
                    String nombre = "P1/M";
                    camino.enviarDato(0, cP1, nombre);
                }
                else if ("Caballero".equals(tP1.getNombre())) {
                    String nombre = "P1/C";
                    camino.enviarDato(0, cP1, nombre);
                }
                else if ("Arquero".equals(tP1.getNombre())) {
                    String nombre = "P1/A";
                    camino.enviarDato(0, cP1, nombre);
                }
                else {
                    System.out.println("Tropa o camino no encontrado");
                }
            }

            else if (cP1 == 1) {
                if ("Mago".equals(tP1.getNombre())) {
                    String nombre = "P1/M";
                    camino.enviarDato(0, cP1, nombre);
                }
                else if ("Caballero".equals(tP1.getNombre())) {
                    String nombre = "P1/C";
                    camino.enviarDato(0, cP1, nombre);
                }
                else if ("Arquero".equals(tP1.getNombre())) {
                    String nombre = "P1/A";
                    camino.enviarDato(0, cP1, nombre);
                }
                else {
                    System.out.println("Tropa o camino no encontrado");
                }
            } 

            else {
                System.out.println("No se detecta camino asignado");
            }
            //camino.imprimir();
            System.out.println();
            camino.desplazamiento();
            oleada++;
    }
}