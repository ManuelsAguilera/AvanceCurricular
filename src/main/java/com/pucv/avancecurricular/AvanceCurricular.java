package com.pucv.avancecurricular;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author magui
 */

public class AvanceCurricular {
    
    private static final int SALIDA = 0;
    
    public static void main(String[] args) {
        
        int opcion;
        DatosPersonal datos = new DatosPersonal();
        Scanner scan=new Scanner(System.in);
        
        do{
            System.out.println("*********************************");
            System.out.println("*           Menu                *");
            System.out.println("*********************************");
            System.out.println("* 1.- Administrar mallas        *");
            System.out.println("* 2.- Agregar alumno            *");
            System.out.println("* 3.- Eliminar alumno           *");
            System.out.println("* 4.- Ver alumnos               *");
            System.out.println("* 5.- Administrar avance alumno.*");
            System.out.println("* 0.- Salir                     *");
            System.out.println("*********************************");
            
            opcion=scan.nextInt();
            
            switch(opcion){
                
            case 1:
                administrarMallas(scan,datos);
                break;
            case 2:
                if(anadirAlumno(scan,datos))
                    System.out.println("añadido con exito");  
                else
                    System.out.println("para agregar un alumno primero debe crearse una malla");
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
    
    private static void administrarAvance(Scanner scan, DatosPersonal datos, String rut){
        int opcion;
        
        do{
            System.out.println("*****************************************");
            System.out.println("*           Administrar Avance          *");
            System.out.println("*****************************************");
            System.out.println("* 1.- Marcar asignatura como aprobada.   *");
            System.out.println("* 2.- Marcar asignatura como no aprobada.*");
            System.out.println("* 3.- Ver asignaturas y su estado.       *");
            System.out.println("* 4.- Ver avance alumno.                 *");
            System.out.println("* 0.- Salida.                            *");
            System.out.println("******************************************");
            
            opcion = scan.nextInt();
            String inputString = "";
            
            switch(opcion){
            
            case 1:
                System.out.println("ingrese nombre asignatura");
                inputString = scan.next();;
                datos.marcarAprobado(rut, inputString);
                break;
            case 2:
                System.out.println("ingrese nombre asignatura");
                inputString = scan.next();
                datos.marcarNoAprobado(rut, inputString);
                break;
            case 3:
                verAvanceAlumno(datos, rut);
                break;
            case 4:
                datos.calcularAvance(rut);
                break;
            }
    
        }while (opcion!=SALIDA);
    }    
   
    private static void administrarMallas(Scanner scan, DatosPersonal datos)
    {
        int opcion;
        do{
            System.out.println("******************************");
            System.out.println("*           Mallas           *");
            System.out.println("******************************");
            System.out.println("* 1.- Agregar malla.         *");
            System.out.println("* 2.- Agregar asignaturas.   *");
            System.out.println("* 3.- Quitar malla.          *");
            System.out.println("* 4.- Ver mallas.            *");
            System.out.println("* 0.- Salir.                 *");
            System.out.println("******************************");
        
            opcion = scan.nextInt();
            String inputString = "";
            
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
    
    private static boolean anadirAlumno(Scanner scan, DatosPersonal datos){
        System.out.println("ingrese nombre del alumno");
        String nombre=scan.next();
        System.out.println("ingrese rut sin puntos y sin digito verificador del alumno");
        String rut=scan.next();
        System.out.println("ingrese el nombre o identificador de la malla");
        String mallaId = scan.next();
        int creditos = 0;
        
        return datos.addAlumno(nombre, rut,creditos, mallaId);
    }
    
    private static boolean anadirAsignatura(Scanner scan,DatosPersonal datos){
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
        System.out.println(datos.getMallas());
    }
    
    private static void verAvanceAlumno(DatosPersonal datos, String rut) {
        
        Malla malla = datos.getAlumno(rut).getMalla();
        
        for (Asignatura a : malla.getListaAsignaturas()) {
            System.out.print("Ramo: " + a.getRamo() + ", Creditos: " + a.getCreditos());
            
            if (a.getEstado())
                System.out.println(", Estado: Aprovado");
            else
                System.out.println(", Estado: No Aprovado");
                 
            System.out.println(", Profesor: " + a.getProfesor());
        }
    }
}

