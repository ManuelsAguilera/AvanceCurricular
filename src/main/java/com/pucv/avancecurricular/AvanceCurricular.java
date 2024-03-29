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
    
    private static final int SALIDA = 0;
    
    public static void main(String[] args) {
        int opcion;
        
        
        DatosPersonal datos = new DatosPersonal();
        
        Scanner scan=new Scanner(System.in);
        do{
            
            System.out.println("*******************************");
            System.out.println("*           menu              *");
            System.out.println("*******************************");
            System.out.println("* 1.-administrar mallas       *");
            System.out.println("* 2.-agregar alumno           *");
            System.out.println("* 3.-eliminar alumno          *");
            System.out.println("* 4.-ver alumnos              *");
            System.out.println("* 5.-administrar avance alumno*");
            System.out.println("*0.-salir                     *");
            System.out.println("*******************************");
            opcion=scan.nextInt();
            switch(opcion){
                case 1:
                    administrarMallas(scan,datos);
                    break;
                case 2:
                    if(anadirAlumno(scan,datos)){
                        System.out.println("añadido con exito");  
                    }else{
                        System.out.println("para agregar un alumno primero debe crearse una malla");
                    }
                    break;
                case 3:
                    System.out.println("ingrese rut sin puntos y sin digito verificador del alumno");
                    break;
                case 4:
                    datos.mostrarAlumnos();
                    break;
                case 5:
                    System.out.println("ingrese rut del alumno ");
                    String rut = scan.next();
                    administrarAvance(scan,datos,rut);
                    
                    
                    break;
                default:
                    System.out.println("ingrese una opcion correcta");
                
                
            }
            
        }while(opcion!=SALIDA);
        
    }
    
    private static void administrarAvance(Scanner scan,DatosPersonal datos,String rut){
        int opcion;
        
        do{
            System.out.println("*****************************************");
            System.out.println("*           administrar avance          *");
            System.out.println("*****************************************");
            System.out.println("* 1.-marcar asignatura como aprobada    *");
            System.out.println("* 2.-marcar asignatura como no aprobada *");
            System.out.println("* 3.-ver asignaturas y su estado        *");
            System.out.println("* 4.-ver avance alumno                  *");
            System.out.println("* 0.-salida                             *");
            System.out.println("*****************************************");
            opcion=scan.nextInt();
            String inputString="";
            switch(opcion){
                case 1:
                    System.out.println("ingrese nombre asignatura");
                    inputString = scan.next();;
                    datos.marcarAprobado(rut,inputString);
                    break;
                case 2:
                    System.out.println("ingrese nombre asignatura");
                    inputString = scan.next();;
                    datos.marcarNoAprobado(rut, inputString);
                    break;
                case 3:
                    // falta ver asignaturas y su estado
                    break;
                case 4:
                    datos.calcularAvance(rut);
                    
                    break;
                    
            }
    
        }while (opcion!=SALIDA);
    }    
   
    
    private static void administrarMallas(Scanner scan,DatosPersonal datos)
    {
        int opcion;
        do{
        System.out.println("*****************************");
        System.out.println("*           mallas          *");
        System.out.println("*****************************");
        System.out.println("* 1.-agregar malla          *");
        System.out.println("* 2.-agregar asignaturas    *");
        System.out.println("* 3.-quitar malla     *");
        System.out.println("* 4.-ver mallas             *");
        System.out.println("*0.-salir                   *");
        System.out.println("*****************************");
        
        opcion=scan.nextInt();
        String inputString="";
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre o identificador de la nueva malla");
                    
                    inputString = scan.next();
                    
                    
                    datos.addMalla(inputString);
                    break;
                case 2:
                    if (!anadirAsignatura(scan,datos))
                        System.out.println("Hubo un error añadiendo la asignatura");
                    
                    break;
                case 3:
                    System.out.println("Ingrese nombre de malla a eliminar");
                    inputString = scan.next();
                    if (!datos.removeMalla(inputString))
                        System.out.println("la malla no existe");
                    break;
                case 4:
                    verMallas(datos);
                    break;
                default:
                    System.out.println("ingrese una opcion correcta");
                
                
            }
            
        }while(opcion!=SALIDA);
        
        
        
    }
    private static boolean anadirAlumno(Scanner scan,DatosPersonal datos){
        System.out.println("ingrese nombre del alumno");
        String nombre=scan.next();
        System.out.println("ingrese rut sin puntos y sin digito verificador del alumno");
        String rut=scan.next();
        System.out.println("ingrese el nombre o identificador de la malla");
        String mallaId = scan.next();
        int creditos=0;
        return datos.addAlumno(nombre, rut,creditos, mallaId);
        
        
    }
    
    private static boolean anadirAsignatura(Scanner scan,DatosPersonal datos)
    {
        System.out.println("Ingrese nombre de malla a seleccionar");
        String mallaId = scan.next();
        System.out.println("Ingrese nombre del ramo a agregar");
        String nombreRamo = scan.next();
        System.out.println("Ingrese nombre del profesor que dicta el ramo");
        String profesor = scan.next();
        System.out.println("Ingrese los creditos del ramo");
        int creditos = scan.nextInt();
        return datos.addAsignatura(mallaId, nombreRamo, profesor, creditos);
        
    }
    
    private static void verMallas(DatosPersonal datos)
    {
        System.out.println(datos.getMallas()); //Nose si se pondra complicado
    }
    
    
}
