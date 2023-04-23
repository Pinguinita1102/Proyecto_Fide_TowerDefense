package com.mycompany.proyecto_fide_towerdefense;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Proyecto_Fide_TowerDefense {
    
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) { //Mientras que salir sea falso, se ejecutará el juego
 
            //Mensaje de bienvenida
            System.out.println("Bienvenido a Tower Defense\n\n");
            System.out.println("1- Iniciar Partida");
            System.out.println("2- Salir");
 
            try { 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) { //Si la opción ingresada es 1 se ejecuta el juego
                    case 1:
                        System.out.println("Has seleccionado la opcion 1\n\n");
                        Juego juego = new Juego();
                        juego.inicio();
                        break;
                    case 2: //Si la opción es 2 se finaliza el juego
                        System.out.println("Saliendo del Juego\n\n");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo puedes insertar números entre 1 y 2\n\n");
                }
            } catch (InputMismatchException e) { //Recoge cualquier dato que no sean las opciones del menú
                System.out.println("Debes insertar un número\n\n");
                sn.next();
            }
        }
    }
}