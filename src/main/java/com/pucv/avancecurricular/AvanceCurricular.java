package com.pucv.avancecurricular;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;


/*
 * @author magui
    Puede que este main, quede desactualizado
    por la implementacion de excepciones, ya que este menu
    depende del return boolean de ciertas funciones.
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
            System.out.println("* 3.- Ver alumnos               *");
            System.out.println("* 4.- Administrar avance alumno.*");
            System.out.println("* 5.- Cargar datos hardcoded    *");
            System.out.println("* 6.- cargar csv                *");
            System.out.println("* 7.- exportar csv              *");
            System.out.println("* 0.- Salir                     *");
            System.out.println("*********************************");
            
            opcion=scan.nextInt();
            try {
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
                System.out.println("Lista de alumnos:");
                for (Alumno alumno : datos.getAlumnos()) {
                    mostrarAlumno(alumno);
                }
                System.out.println("-----------------------------");

                break;
            case 4:
                System.out.println("ingrese rut del alumno ");
                String rut = scan.next();
                administrarAvance(scan,datos,rut);    
                break;
            case 5:
                System.out.println("Datos Cargados");
                cargarDatos(datos);
                break;
            case 6:
                leerDatosDesdeCSV(datos, "C:\\Users\\alfar\\Desktop\\proyecto avanzada\\leerMalla.csv");
                break;
            case 7:
                exportarCsv(datos);
                break;
            
            default:
                System.out.println("ingrese una opcion correcta");
            }
            }
            catch(EmptyCollectionException e)
            {
                System.out.println("Se intento acceder, o modificar datos inexistentes, intente de nuevo");
                continue;
            }
            catch(EmptyTemplateException e)
            {
                System.out.println("Se intento añadir una malla, sin haber hecho una plantilla");
                System.out.println("Intente agregandola en el menu de mallas");
                continue;
            }
            catch(Exception e)
            {
                System.out.println("Error desconocido saliendo del programa");
                e.printStackTrace();
                opcion=SALIDA;
            }
            
        }while(opcion!=SALIDA);   
    }
    
    private static void cargarDatos(DatosPersonal datos)
    {
        Malla mallaIng = new Malla("Ingenieria");
        mallaIng.agregarAsignatura("Mate1","Andrea",4,true);
        mallaIng.agregarAsignatura("Etica Cristiana","martina",2,true);
        mallaIng.agregarAsignatura("Intro Ing","Guillermo",5,true);
        mallaIng.agregarAsignatura("Progra avanz","Cubillos",4,false);
        datos.addMalla(mallaIng);
        Malla mallaDerecho = new Malla("Derecho");
        mallaIng.agregarAsignatura("Derecho romano","Felipe",5,false);
        mallaIng.agregarAsignatura("Historia","Javiera",2,false);
        mallaIng.agregarAsignatura("AntiMatematica","Paul",5,true);
        mallaIng.agregarAsignatura("Economia","Camilo",4,false);
        datos.addMalla(mallaDerecho);
        try{
        datos.addAlumno(new Alumno("Miguel","21556",mallaIng));
        datos.addAlumno(new Alumno("Martin","21600",mallaIng));
        datos.addAlumno(new Alumno("Alexandra","22444",mallaDerecho));
        datos.addAlumno(new Alumno("Andres","20777",mallaDerecho));
        datos.addAlumno(new Alumno("Juan","23441",mallaDerecho));
        datos.addAlumno(new Alumno("Juana","22556",mallaDerecho));
        }
        catch (EmptyTemplateException e)
        {
            System.out.println("No se pudieron generar mallas");
            
        }
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
            System.out.println("* 5.- Eliminar alumno.                   *");
            System.out.println("* 0.- Salida.                            *");
            System.out.println("******************************************");
            
            opcion = scan.nextInt();
            String inputString = "";
            
            try {
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
                Alumno alumno = datos.getAlumno(rut);

                int creditosCursados = alumno.calcularCreditosCursados();
                int creditosMalla = alumno.calcularCreditosMalla();
                System.out.println("El alumno " + alumno.getNombre() + " ha cursado " + creditosCursados + " creditos de " + creditosMalla + " creditos en su malla.");
                
                break;
            case 5:
                if (datos.removeAlumno(rut))
                {
                    System.out.println("Removido correctamente\nVolviendo menu principal..");
                    opcion=SALIDA;
                }
                else
                    System.out.println("No existe el alumno, o hubo un error en el ingreso");
            }
            }
            catch(EmptyCollectionException e)
            {
                System.out.println("No se encuentra la informacion pedida");
                continue;
            }
            catch(Exception e)
            {
                System.out.println("Encontrado un error desconocido\nCerrando Programa");
                e.printStackTrace();
                opcion=SALIDA;
            }
    
        }while (opcion!=SALIDA);
        
    }    
   
    private static void administrarMallas(Scanner scan, DatosPersonal datos) throws EmptyTemplateException,EmptyCollectionException
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
    
    private static boolean anadirAlumno(Scanner scan, DatosPersonal datos) throws EmptyTemplateException{
        
        System.out.println("ingrese nombre del alumno");
        String nombre=scan.next();
        System.out.println("ingrese rut sin puntos y sin digito verificador del alumno");
        String rut=scan.next();
        System.out.println("ingrese el nombre o identificador de la malla");
        String mallaId = scan.next();
        
        
        return datos.addAlumno(nombre, rut, mallaId);
        
        
        
    }
    
    private static boolean anadirAsignatura(Scanner scan,DatosPersonal datos) throws EmptyCollectionException{
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
    
    private static void verAvanceAlumno(DatosPersonal datos, String rut) throws EmptyCollectionException {
        
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
    
    private static void mostrarAlumno(Alumno alumno)
    {
        System.out.println("Nombre: " + alumno.getNombre());
        System.out.println("RUT: " + alumno.getRut());
        System.out.println("Créditos: " + alumno.calcularCreditosCursados());
    }
    
    private static void leerDatosDesdeCSV(DatosPersonal datos, String csvFile) throws EmptyTemplateException {
        String line = "";
        String cvsSplitBy = ",";
        Malla currentMalla = null;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                
                String[] data = line.split(cvsSplitBy);
                if(line.contains("alumnos")){
                    continue;
                }
                
                if(line.contains("Mallas")){
                    continue;
                }
               
                if (data.length == 1 && !data[0].isEmpty()) {
                    currentMalla = new Malla(data[0]);
                    datos.addMalla(currentMalla);
                } 
                
                else if (currentMalla != null && data.length == 3) {
                    Asignatura asignatura = new Asignatura(data[0], data[1], Integer.parseInt(data[2]));
                    currentMalla.agregarAsignatura(asignatura);
                }
               
                else if (data.length > 3) {
                    Malla malla = datos.getMalla(data[2]);
                    Alumno alumno = new Alumno(data[1], data[0], malla);
                    datos.addAlumno(alumno);
                    
                
                    ArrayList<Asignatura> asignaturas = malla.getListaAsignaturas();
                    for (int i = 3; i < data.length; i++) {
                        if (data[i].equals("1")) {
                            asignaturas.get(i-3).marcarAprobada();
                        } else {
                            asignaturas.get(i-3).marcarReprobado();
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void exportarCsv(DatosPersonal datos){
        PrintWriter writer = null;
        try{
            String ruta = System.getProperty("user.home") + "/Desktop/";
            writer = new PrintWriter(ruta+"alumnos.csv", "UTF-8");
            writer.println("Mallas");
            writer.println(" ");
            for(Malla act:datos.getMalla2()){
                writer.println(act.getMallaId());
                for(Asignatura a:act.getListaAsignaturas()){
                    writer.println(a.getRamo()+","+a.getProfesor()+","+a.getCreditos());
                    
                }
                writer.println(" ");
            }
            writer.println("alumnos");
            writer.println(" ");
            for(Alumno actA:datos.getAlumnos()){
                writer.print(actA.getRut()+","+actA.getNombre()+","+actA.getMalla().getMallaId());
                for(Asignatura asignaturas:actA.getMalla().getListaAsignaturas()){
                     writer.print(","+(asignaturas.isAprobada() ? "1" : "0"));
                    
                }
                writer.println(" ");
            }
            
        }catch(IOException e){
            
  
            System.out.println("Ocurrió un error al escribir el archivo CSV: " + e.getMessage());
        } finally {
            if(writer != null){
                writer.close();
            }      
        }
    }
}

