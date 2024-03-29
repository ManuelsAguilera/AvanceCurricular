/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucv.avancecurricular;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;




/**
 *
 * @author manu
 * Esta clase accede a la informacion sobre la malla curricular de alumnos.
 * En un futuro podria ser implementado informacion sobre los profesores, o 
 * informacion de los alumnos desde las mallas o carreras.
 * 
 * Posibles respuestas de error:
 *  0: Nada malo ha pasado
 *  1: No se puede añadir el objeto por x razon
 *  2: El objeto no se puede añadir porque no hay informacion
 * 
 * 
 * 
 * 
 * @parseRuta:
 * Nos avisa si fue ingresado correctamente la ruta de archivo
 * 
 * 
 */
public class DatosPersonal {
    
    private HashMap<String,Alumno> mapaPersonal ;
    private TreeMap<String,Malla> mallasDisp;
    

    
    public DatosPersonal()
    {
        mapaPersonal= new HashMap<String,Alumno>();
        mallasDisp = new TreeMap<String,Malla>();
        
    }
    
    public boolean addAlumno(String nombre,String rut,int creditos, String mallaId)
    {
        if (mallasDisp.isEmpty())
            return false; //El usuario no sabra porque pero bueno.
        
        
        Alumno newAlumno= new Alumno(nombre, rut, creditos,mallasDisp.get(mallaId));
        mapaPersonal.putIfAbsent(rut, newAlumno);
        return true;
    }
    
    public boolean removeAlumno(String rut)
    {
        if (mapaPersonal.containsKey(rut))
            mapaPersonal.remove(rut,null); //if it exists it removes
        return true;
    }
    
    public boolean addMalla(String mallaId)
    {
        mallasDisp.put(mallaId,new Malla(mallaId));
        return true;
    }
    
    public boolean removeMalla(String mallaId)
    {
        if (!mallasDisp.containsKey(mallaId))
            return false;
        
           
        mallasDisp.remove(mallaId);
        return true;
        
    }
    
    public Set getMallas()
    {
        return mallasDisp.keySet();
    }
    
    public boolean addAsignatura(String mallaId,String ramo, String profesor, int creditos)
    {
        if (!mallasDisp.containsKey(mallaId))
            return false;
        
        Malla malla = mallasDisp.get(mallaId);
        malla.agregarAsignatura(new Asignatura(ramo,profesor,creditos));
        return true;
        
    }
    
    public void mostrarAlumnos() {
        System.out.println("Lista de alumnos:");
        for (Alumno alumno : mapaPersonal.values()) {
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Créditos: " + alumno.getCreditos());
        }
        System.out.println("-----------------------------");
    }
    public void marcarAprobado(String rut,String nombreAsignatura){
        if(mapaPersonal.containsKey(rut)){
            Alumno alumno = mapaPersonal.get(rut);
            Malla malla = alumno.getMalla();
            for (Asignatura asignatura : malla.getListaAsignaturas()) {
                if (asignatura.getRamo().equals(nombreAsignatura)) {
                    asignatura.marcarAprobada();
                    return;
                }
            }
        }
        
    }
    
    public void marcarReprobado(String rut , String nombreAsignatura){
        if(mapaPersonal.containsKey(rut)){
            Alumno alumno = mapaPersonal.get(rut);
            Malla malla = alumno.getMalla();
            for (Asignatura asignatura : malla.getListaAsignaturas()) {
                if (asignatura.getRamo().equals(nombreAsignatura)) {
                    asignatura.marcarAprobada();
                    return;
                }
            }
        }    
    }
    public void calcularAvance(String rut){
        if (mapaPersonal.containsKey(rut)) {
            Alumno alumno = mapaPersonal.get(rut);
            int creditosCursados = alumno.calcularCreditosCursados();
            int creditosMalla = alumno.calcularCreditosMalla();
            System.out.println("El alumno " + alumno.getNombre() + " ha cursado " + creditosCursados + " créditos de " + creditosMalla + " créditos en su malla.");
        }
    }
    

    private Boolean parseRuta(String ruta) //TODO
    {
        return false;
    }
    
    public Boolean cargarDatos(String ruta)
    {
        return false;
    }
    
    
    
}
