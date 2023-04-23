package com.mycompany.proyecto_fide_towerdefense;

public class Camino {
    private String[][] camino = new String[5][2];
    
    Castillo castilloP1 = new Castillo("P1",10);
    Castillo castilloCPU = new Castillo("CPU",10);

    public Castillo getCastilloP1() {
        return castilloP1;
    }

    public void setCastilloP1(Castillo castilloP1) {
        this.castilloP1 = castilloP1;
    }

    public Castillo getCastilloCPU() {
        return castilloCPU;
    }

    public void setCastilloCPU(Castillo castilloCPU) {
        this.castilloCPU = castilloCPU;
    }    
    
    /*Esta oarte todavia puede mejorarse lo hice de esta manera porque pense
    que no sabemos cuantas filas o columnas se necesiten entones no lo
    Inicialice con un valor en especifico */
    public Camino(int filas, int columnas) {
        camino = new String[filas][columnas];
    }
       
    public Camino(String[][] camino) {
        this.camino = camino;
    }
      
    public Camino() {
    }

    public void imprimir() {
        System.out.println("   TABLERO");
        System.out.print(castilloP1.toString() );
        for (int i = 0; i < 5; i++) {
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
        System.out.println( castilloCPU.toString());
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
    
    
    public void desplazamiento() {
        String tropaP1CI = null;
        String tropaP1CD = null;
        String tropaCPUCI = null;
        String tropaCPUCD = null;
        String ganadorCI = null;
        String ganadorCD = null;
        
        
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
        /*/else{
            System.out.println("Tropa DE CPU no encontrada");
        }/*/
        
        if (camino[0][0] != null){
            if (camino[4][0] != null){
                camino [1][0] = camino [0][0];
                camino [3][0] = camino [4][0];
                camino [2][0] = camino [1][0];
                ganadorCI = combate(tropaP1CI, tropaCPUCI);
            }
            else if (camino[4][0] == null){
                camino [1][0] = camino [0][0];
                camino [2][0] = camino [1][0];
                camino [3][0] = camino [2][0];
                camino [4][0] = camino [3][0];
                ganadorCI = combate(tropaP1CI, tropaCPUCI);
            }
        }
        else if (camino[0][0] == null ){
            if (camino[4][0] != null){
                camino [3][0] = camino [4][0];
                camino [2][0] = camino [3][0];
                camino [1][0] = camino [2][0];
                camino [0][0] = camino [1][0];
                ganadorCI = combate(tropaP1CI, tropaCPUCI);
            }
            else if (camino [4][0] == null){
                ganadorCI = combate(tropaP1CI, tropaCPUCI);
            }
        }
        
        
        if (camino[0][1] != null){
            if (camino[4][1] != null){
                camino [1][1] = camino [0][1];
                camino [3][1] = camino [4][1];
                camino [2][1] = camino [1][1];
                ganadorCD = combate(tropaP1CD, tropaCPUCD);
            }
            else if (camino[4][1] == null){
                camino [1][1] = camino [0][1];
                camino [2][1] = camino [1][1];
                camino [3][1] = camino [2][1];
                camino [4][1] = camino [3][1];
                ganadorCD = combate(tropaP1CD, tropaCPUCD);
            }
        }
        else if (camino[0][1] == null ){
            if (camino[4][1] != null){
                camino [3][1] = camino [4][1];
                camino [2][1] = camino [3][1];
                camino [1][1] = camino [2][1];
                camino [0][1] = camino [1][1];
                ganadorCD = combate(tropaP1CD, tropaCPUCD);
            }
            else if (camino [4][1] == null){
                ganadorCD = combate(tropaP1CD, tropaCPUCD);
            }
        }
        
        
        ataqueCastillo(ganadorCI);
        ataqueCastillo(ganadorCD);
        System.out.println("\n\n");
        System.out.println("Camino Izquierdo: "+ganadorCI +"\n");
        System.out.println("Camino Derecho: "+ganadorCD +"\n\n");
        System.out.println();
        imprimir();
        limpiarArreglo();
        
    }
    
    public String combate (String tP1, String tCPU){ //Tropa del jugador y tropa del CPU
        String g=null;
        
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
    
    public void ataqueCastillo(String v) {
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
    
    public void limpiarArreglo(){
        //Se limpia el arreglo
        for (int i = 0; i < 5; i++) { //Se mueve en las filas
            for (int j = 0; j < 2; j++) { //Se mueve en las columnas
                camino[i][j] = null;
            }
        }
    }
}