package com.mycompany.proyecto_fide_towerdefense;

public class Camino {
    private String[][] camino = new String[5][2]; //Se crea el array
    
    Castillo castilloP1 = new Castillo("P1",10); //Se inicializan los castillos
    Castillo castilloCPU = new Castillo("CPU",10); //Se inicializan los castillos

    public Castillo getCastilloP1() { //Constructor
        return castilloP1;
    }

    //Setters and Getters
    public void setCastilloP1(Castillo castilloP1) {
        this.castilloP1 = castilloP1;
    }

    public Castillo getCastilloCPU() {
        return castilloCPU;
    }

    public void setCastilloCPU(Castillo castilloCPU) {
        this.castilloCPU = castilloCPU;
    }    
    
    public Camino(int filas, int columnas) { //Se inicializa el array
        camino = new String[filas][columnas];
    }
       
    public Camino(String[][] camino) { //Constructor
        this.camino = camino;
    }
      
    public Camino() { //Constructor
    }

    public void imprimir() { //Imprime el array y los elementos que hayan en él
        System.out.println("   TABLERO");
        System.out.print(castilloP1.toString() ); //Imprime el castillo del jugadorP1
        for (int i = 0; i < 5; i++) { //Se mueve filas y columnas para imprimir todos los valores de la tabla
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    System.out.print("\n| ");
                }
                System.out.print(camino[i][j] + " ");
                System.out.print("| ");

                if (j == camino[i].length - 1) {
                    System.out.print("\n");
                }
            }
        }
        System.out.println( castilloCPU.toString()); //Imprime el castillo del CPU
        System.out.println();
        System.out.println("====================================================");
    }
    
    public String obtenerDato(int fila, int columna) {//Obtener valores especificos de la matriz por medio 
        //de los parametros de la ubicación
        return camino[fila][columna];
    }
    
    public void enviarDato(int fila, int columna, String valor) {//Enviar valores especificos a la matriz por medio de los 
        //parametros de la ubicaci'on
        camino[fila][columna] = valor;
    }
    
    
    public void desplazamiento() { //Recibe la tropa que el jugador haya seleccionado, la coloca en el tablero y 
        //según las reglas del juego avanza o es destruida
        
        //Se inicializan las variables que reciben las tropas en las diferentes posiciones
        String tropaP1CI = null;
        String tropaP1CD = null;
        String tropaCPUCI = null;
        String tropaCPUCD = null;
        String ganadorCI = null;
        String ganadorCD = null;
        
        
        //Se revisan las 4 posiciones inicales para obtener el valor de las tropas que haya en ellos
        if (camino[0][0] != null){
            tropaP1CI = camino[0][0];
        }
        else if (camino[0][1] != null) {
            tropaP1CD = camino[0][1];
        }
        else{
            System.out.println("Tropa DE P1 no encontrada");
        }
        
        if (camino[4][0] != null){
            tropaCPUCI = camino[4][0];
        }
        else if (camino[4][1] != null) {
            tropaCPUCD = camino[4][1];
        }
        
        //Se crean escenarios posibles según las posiciones que hayan en el tablero
        if (camino[0][0] != null){ //Si la posición 0,0 tiene una tropa
            if (camino[4][0] != null){ //Si la posición 4,0 tiene una tropa, avanzan hasta enfrentarse, hay un 
                //ganador y ataca el castillo del perdedor
                camino [1][0] = camino [0][0];
                camino [3][0] = camino [4][0];
                camino [2][0] = camino [1][0];
                ganadorCI = combate(tropaP1CI, tropaCPUCI);
            }
            else if (camino[4][0] == null){ //Si la posición 4,0 está vacía, avanza y ataca el castillo del CPU
                camino [1][0] = camino [0][0];
                camino [2][0] = camino [1][0];
                camino [3][0] = camino [2][0];
                camino [4][0] = camino [3][0];
                ganadorCI = combate(tropaP1CI, tropaCPUCI);
            }
        }
        else if (camino[0][0] == null ){ //Si la posición 0,0 está vacía
            if (camino[4][0] != null){ //Si la posición 4,0 tiene tropa, esta avanza y ataca el castillo del P1
                camino [3][0] = camino [4][0];
                camino [2][0] = camino [3][0];
                camino [1][0] = camino [2][0];
                camino [0][0] = camino [1][0];
                ganadorCI = combate(tropaP1CI, tropaCPUCI);
            }
            else if (camino [4][0] == null){ //Si ambas posiciones están vacías no hay combate
                ganadorCI = combate(tropaP1CI, tropaCPUCI);
            }
        }
        
        
        if (camino[0][1] != null){ //Si la posición 0,1 tiene una tropa
            if (camino[4][1] != null){ //Si la posición 4,1 tiene una tropa, avanzan hasta enfrentarse, hay un 
                //ganador y ataca el castillo del perdedor
                camino [1][1] = camino [0][1];
                camino [3][1] = camino [4][1];
                camino [2][1] = camino [1][1];
                ganadorCD = combate(tropaP1CD, tropaCPUCD);
            }
            else if (camino[4][1] == null){ //Si la posición 4,1 está vacía, avanza y ataca el castillo del CPU
                camino [1][1] = camino [0][1];
                camino [2][1] = camino [1][1];
                camino [3][1] = camino [2][1];
                camino [4][1] = camino [3][1];
                ganadorCD = combate(tropaP1CD, tropaCPUCD);
            }
        }
        else if (camino[0][1] == null ){ //Si la posición 0,1 está vacía
            if (camino[4][1] != null){ //Si la posición 4,1 tiene tropa, esta avanza y ataca el castillo del P1
                camino [3][1] = camino [4][1];
                camino [2][1] = camino [3][1];
                camino [1][1] = camino [2][1];
                camino [0][1] = camino [1][1];
                ganadorCD = combate(tropaP1CD, tropaCPUCD);
            }
            else if (camino [4][1] == null){ //Si ambas posiciones están vacías no hay combate
                ganadorCD = combate(tropaP1CD, tropaCPUCD);
            }
        }
        
        //En cada ronda, va a haber un combate y si de ese combate hay un ganador, este va a atacar el 
        //castillo del oponente
        ataqueCastillo(ganadorCI);
        ataqueCastillo(ganadorCD);
        System.out.println("\n\n");
        System.out.println("Camino Izquierdo: "+ganadorCI +"\n"); //Se imprime si hay un ganador en cada camino
        System.out.println("Camino Derecho: "+ganadorCD +"\n\n"); //Se imprime si hay un ganador en cada camino
        System.out.println();
        imprimir(); //Se imprime la tabla
        limpiarArreglo(); //Se vacía el arreglo para el nuevo combate
        
    }
    
    public String combate (String tP1, String tCPU){ //Tropa del jugador y tropa del CPU
        //En este método se define si hay un ganador de los combates, si ambas tropas se destruyen o 
        //si no hay combate y las tropas atacan directamente los castillos
        
        String g=null; //Variable para retornar el resultado del combate
        
        //Dependiendo de la tropa que haya en cada posición se va a dar uno de los siguientes escenarios
        if (tP1 == null){
            if (tCPU == null){
                g = "No hubo combate";
            }
            else if (tCPU.equals("CPU/C")){
                g = "No enfrenta oponente, CPU/C ataca directamente al castillo";
            }
            else if (tCPU.equals("CPU/A")){
                g = "No enfrenta oponente, CPU/A ataca directamente al castillo";
            }
            else if (tCPU.equals("CPU/M")){
                g = "No enfrenta oponente, CPU/M ataca directamente al castillo";
            }
        }
        
        else if (tP1.equals("P1/M")){
            if (tCPU == null){
                g = "No enfrenta oponente, P1/M ataca directamente al castillo";
            }
            else if (tCPU.equals("CPU/C")){
                g = "COMBATE: El Ganador es: P1/M";
            }
            else if (tCPU.equals("CPU/A")){
                g = "COMBATE: El Ganador es: CPU/A";
            }
            else if (tCPU.equals("CPU/M")){
                g = "Ambas tropas se eliminaron";
            }            
        }
        
        else if (tP1.equals("P1/C")){
            if (tCPU == null){
                g = "No enfrenta oponente, P1/C ataca directamente al castillo";
            }
            else if (tCPU.equals("CPU/A")){
                g = "COMBATE: El Ganador es: P1/C";
            }
            else if (tCPU.equals("CPU/M")){
                g = "COMBATE: El Ganador es: CPU/M";
            }
            else if (tCPU.equals("CPU/C")){
                g = "Ambas tropas se eliminaron";
            }            
        }
        
        else if (tP1.equals("P1/A")){
            if (tCPU == null){
                g = "No enfrenta oponente, P1/A ataca directamente al castillo";
            }
            else if (tCPU.equals("CPU/M")){
                g = "COMBATE: El Ganador es: P1/A";
            }
            else if (tCPU.equals("CPU/C")){
                g = "COMBATE: El Ganador es: CPU/C";
            }
            else if (tCPU.equals("CPU/A")){
                g = "Ambas tropas se eliminaron";
            }
        }
        return g;
    }
    
    public void ataqueCastillo(String v) { //Se recibe la tropa que haya llegado al final del camino, dependiendo del 
        //tipo de tropa el ataque al castillo va a ser más o menos poderoso
        
        //Dependiendo de la tropa que vaya a atacar se puede dar uno de los siguientes escenarios
        if (v.equals("No enfrenta oponente, CPU/C ataca directamente al castillo") 
                || v.equals("COMBATE: El Ganador es: CPU/C")){
            castilloP1.setVida(castilloP1.getVida() - 2.0);
        }
        else if (v.equals("No enfrenta oponente, CPU/A ataca directamente al castillo") 
                || v.equals("COMBATE: El Ganador es: CPU/A")){
            castilloP1.setVida(castilloP1.getVida() - 1.0);
        }
        else if (v.equals("No enfrenta oponente, CPU/M ataca directamente al castillo")
                || v.equals("COMBATE: El Ganador es: CPU/M")){
            castilloP1.setVida(castilloP1.getVida() - 1.5);
        }
        else if (v.equals("No enfrenta oponente, P1/M ataca directamente al castillo") 
                || v.equals("COMBATE: El Ganador es: P1/M")){
            castilloCPU.setVida(castilloCPU.getVida() - 1.5);
        }
        else if (v.equals("No enfrenta oponente, P1/C ataca directamente al castillo") 
                || v.equals("COMBATE: El Ganador es: P1/C")){
            castilloCPU.setVida(castilloCPU.getVida() - 2.0);
        }
        else if (v.equals("No enfrenta oponente, P1/A ataca directamente al castillo") 
                || v.equals("COMBATE: El Ganador es: P1/A")){
            castilloCPU.setVida(castilloCPU.getVida() - 1.0);
        }
    }
    
    public void limpiarArreglo(){ //Vacía la matríz, colocando null en cada espacio
        //Se limpia el arreglo, recorriendo sus filas y columnas
        for (int i = 0; i < 5; i++) { //Se mueve en las filas
            for (int j = 0; j < 2; j++) { //Se mueve en las columnas
                camino[i][j] = null;
            }
        }
    }
}