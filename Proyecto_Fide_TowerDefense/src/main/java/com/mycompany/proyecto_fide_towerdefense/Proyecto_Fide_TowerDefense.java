package com.mycompany.proyecto_fide_towerdefense;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Proyecto_Fide_TowerDefense {
    
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("Bienvenido a Tower Defense\n\n");
            System.out.println("1- Iniciar Partida");
            System.out.println("2- Salir");
 
            try { 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1\n\n");
                        Juego juego = new Juego();
                        juego.inicio();
                        break;
                    case 2:
                        System.out.println("Saliendo del Juego\n\n");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo puedes insertar números entre 1 y 2\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número\n\n");
                sn.next();
            }
        }
    }
}