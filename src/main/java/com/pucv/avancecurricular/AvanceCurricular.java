/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pucv.avancecurricular;
import java.util.Scanner;
/**
 *
 * @author magui
 */
public class AvanceCurricular {

    public static void main(String[] args) {
        int opcion;
        Scanner scan=new Scanner(System.in);
        do{
            System.out.println("*****************************");
            System.out.println("*           menu            *");
            System.out.println("*****************************");
            System.out.println("* 1.-agregar alumno         *");
            System.out.println("* 2.-eliminar alumno        *");
            System.out.println("* 3.-ver alumnos            *");
            System.out.println("* 4.- ver progreso de alumno*");
            System.out.println("*5.-salir                   *");
            System.out.println("*****************************");
            opcion=scan.nextInt();
            switch(opcion){
                case 1:
                    //agregar metodos
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("ingrese una opcion correcta");
                
                
            }
            
        }while(opcion!=5);
        
    }
}
