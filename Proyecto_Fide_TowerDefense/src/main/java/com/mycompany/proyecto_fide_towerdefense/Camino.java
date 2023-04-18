package com.mycompany.proyecto_fide_towerdefense;

public class Camino {
    private String[][] camino = new String[2][8];
    Castillo castilloP1 = new Castillo("P1",10);
    Castillo castilloCPU = new Castillo("CPU",10);
    
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
        System.out.println("\t\t\t\tTABLERO\t\t\t\t");
        System.out.println(castilloP1.toString() + "\t\t\t\t\t\t\t\t" + castilloCPU.toString());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    System.out.print("\n| ");
                }
                System.out.print(camino[i][j] + " ");
                System.out.print("| ");

                if (j == camino[i].length - 1) {
                    System.out.print("|\n");
                }
            }
            System.out.println();
            System.out.println("------------------------------------------");
        }
    }
    
    public String obtenerDato(int fila, int columna) {//Obtener valores especificos de la matriz por medio de los parametros de la ubicaci'on
        return camino[fila][columna];
    }
    
    public void enviarDato(int fila, int columna, String valor) {//Enviar valores especificos a la matriz por medio de los parametros de la ubicaci'on
        camino[fila][columna] = valor;
    }
    
    /*public void imprimir() {
    
        for (int i = 0; i < camino.length; i++) {
            for (int j = 0; j < camino[i].length; j++) {
                System.out.print(camino[i][j] + " ");
            }
            System.out.println();
        }
    }*/           
}