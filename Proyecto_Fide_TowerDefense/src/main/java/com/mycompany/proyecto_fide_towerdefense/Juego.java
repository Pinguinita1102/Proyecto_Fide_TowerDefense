package com.mycompany.proyecto_fide_towerdefense;
import java.util.Random;
import java.util.Scanner;

public class Juego {  
    Random random = new Random(); //Se importa la librería ramdom para obtener valores aleatorios
    int oleada; //Se inicializa la variable que va a almacenar el número de oleada en que se encuentre el juego
    Cola colaP1 = new Cola(); //Se crean las colas que almacenarán las tropas elegidas por cada jugador
    Cola colaCPU = new Cola(); //Se crean las colas que almacenarán las tropas elegidas por cada jugador

    Camino camino = new Camino(); //Se crea la matríz por dónde se desplazan las tropas
    
    public void inicio(){ //Método de inicio del juego
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
        
        delaySegundo(5000); //Se coloca un delay para que el jugador pueda leer las reglas
        System.out.println("\n\nINICIO DEL JUEGO\n");
        
        oleada = 1;
        while (camino.getCastilloP1().getVida() > 0 && camino.getCastilloCPU().getVida() > 0) { //Mientras que 
            //la vida de ambos castillos sea mayor que 0, se va a ejecutar el juego.
            camino.limpiarArreglo(); //Se llama al método que está en Camino, para limpiar la matríz
            selecciónDeTropas(); //Método dónde se seleccionan las tropas
            despliegue(); //Método dónde se despliegan las tropas en el tablero
        }
        //Mensaje de finalización del juego            
        System.out.println("Juego Finalizado");
        System.out.println();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
    }
        
    public void selecciónDeTropas(){ //Se seleccionan las tropas de cada jugador
        int contCamino0=0; //Estas tres variables sirven para cumplir ocn el requerimiento de 
        //que el CPU no puede desplegar más del 75% de sus tropas en un mismo camino
        int contCamino1=0;
        int contTotal=0;
        
        Scanner sn = new Scanner(System.in);
        int tipoDeTropa; //Guardaremos el tipo de tropa que elija el jugador
        int caminoS; //Guardaremos el camino que elija el jugador
        
        System.out.println("\nOleada #: "+ oleada +"\n\n");
        
        //Turno del CPU de elegir tropa y camino, de manera aleatoria
        for(int x=1; x <= oleada+3; x++){
            System.out.println("Selección de Tropa #: "+ (x) +"\n\n");
            System.out.println("El CPU va a elegir uno de los siguientes tipos de tropa\n\n");
            System.out.println("0- Mago");
            System.out.println("1- Caballero");
            System.out.println("2- Arquero\n\n");
            tipoDeTropa = getRndTropa();
            delaySegundo(2000);

            System.out.println("El CPU va a elegir uno de los caminos para desplegar la tropa\n\n");
            System.out.println("0- Camino Izquierdo");
            System.out.println("1- Caminio Derecho");
            
            caminoS = getRndCamino(contCamino0, contCamino1, contTotal);
            delaySegundo(2000);
            
            //Dependiendo de la trops seleccionada, se almacenan estos valores en la cola respectiva
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

            //Dependiendo de la trops seleccionada, se almacenan estos valores en la cola respectiva
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
        System.out.println(colaCPU.imprimir()); //Por un tema de control, se imprime la cola con las tropas elegidas
        System.out.println("Selección del P1");
        System.out.println(colaP1.imprimir()); //Por un tema de control, se imprime la cola con las tropas elegidas
        delaySegundo(10000); //Se coloca un delay para que el jugador pueda leer lo deplegado en pantalla
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
            if (porcC0 >= 0.75){//Si la cantidad de tropas desplegadas en un mismo camion excede 
                //el 75% se cambia al otro camino
                cam = 1;
                x++;
                z++;
            }
            else if(porcC1 >= 0.75){ //Si la cantidad de tropas desplegadas en un mismo camion excede 
                //el 75% se cambia al otro camino
                cam = 0;
                y++;
                z++;
            }
        }
        return cam;
    }
        
    public void despliegue() { //Se usa para pasar las tropas de la cola a la matríz e iniciar el combate
        while (camino.getCastilloP1().getVida() > 0 && camino.getCastilloCPU().getVida() > 0){ //Mientras que 
            //la vida de ambos castillos sea mayor que 0, se va a ejecutar el juego.
            for(int x=1; x <= oleada+3; x++){ //Se atiende la cola y se colcoa cada tropa en el camino seleccionado
                Tropa tP1 = colaP1.atiende().getDato();
                int cP1 = tP1.getCamino(); //Esta sería la columna en la que inicia

                //Dependiendo del camino y tipo de tropa seleccionada se dá uno de los siguientes 
                //escenarios se almacena en la coal del P1
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

                //Dependiendo del camino y tipo de tropa seleccionada se dá uno de los siguientes 
                //escenarios se almacena en la coal del P1
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

                camino.imprimir(); //Se imprime el camino
                delaySegundo(3000);
                System.out.println();
                camino.desplazamiento(); //Se ejecuta el método de desplazamiento
                delaySegundo(5000);
                
                
                //Si la vida de alguno de los dos castillos es 0 o menor, se imprime un mensaje que 
                //indica quién es el ganador dle juego
                if (camino.getCastilloP1().getVida() <= 0){
                    System.out.println("EL CASTILLO DEL P1 FUE DESTRUIDO, EL GANADOR ES CPU");
                    break;
                }
                else if (camino.getCastilloCPU().getVida() <= 0){
                    System.out.println("EL CASTILLO DEL CPU FUE DESTRUIDO, EL GANADOR ES P1 "
                            + "¡FELICITACIONES!\n");
                    break;
                }
            }
            
            //Si la vida de ambos castillos es superior a 0 se ejecuta una ronda más para el P1
            if(camino.getCastilloP1().getVida() > 0 && camino.getCastilloCPU().getVida() > 0){
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
                
                camino.imprimir(); //Se imprime el camino
                delaySegundo(3000);
                System.out.println();
                camino.desplazamiento(); //Se ejecuta el método de desplazamiento
                delaySegundo(3000);
            }
            break;
        }
        oleada++;        
    }
    
    public static void delaySegundo(int tiempo){ //Se usa para hacer los delays, recibe la cantidad 
        //de milisegundos por los que se ejecutará
        try{
            Thread.sleep(tiempo);
        }catch(InterruptedException e){}
    }
}