package com.pucv.avancecurricular;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/*
 * @author manu
 *
 * Esta clase accede a la informacion sobre la malla curricular de alumnos.
 * En un futuro podria ser implementado informacion sobre los profesores, o 
 * informacion de los alumnos desde las mallas o carreras.
 */

public class DatosPersonal {
    
    private HashMap<String, Alumno> mapaPersonal ;
    private TreeMap<String, Malla>  mallasDisp;
    
    public DatosPersonal() {
        mapaPersonal = new HashMap<String, Alumno>();
        mallasDisp   = new TreeMap<String, Malla>();
    }
    
    //Añade un alumno al HashMap, solo si es que se le puede asociar una malla a este.
    public boolean addAlumno(String nombre, String rut, String mallaId) {
        
        if (mallasDisp.isEmpty())
            return false; 
        
        Alumno newAlumno= new Alumno(nombre, rut, mallasDisp.get(mallaId));
        mapaPersonal.putIfAbsent(rut, newAlumno);
        
        return true;
    }
    
    public boolean addAlumno(Alumno alumno) {
        
        if (mallasDisp.isEmpty())
            return false; 
        
        
        mapaPersonal.putIfAbsent(alumno.getRut(), alumno);
        
        return true;
    }
    
    public Alumno getAlumno(String rut){
        
        if (!mapaPersonal.containsKey(rut))
                return null;
        
        return mapaPersonal.get(rut);
    }
    
    // Remueve el valor y key de el hashmap alumnos
    public boolean removeAlumno(String rut) {
        if (mapaPersonal.containsKey(rut))
            mapaPersonal.remove(rut); //if it exists it removes
        
        return true;
    }
    
    //Añade una instancia malla, a nuestro mapa de mallas asociandolo a un nombre
    //ej : "Ingenieria civil informatica 2020"::new Malla()
    public boolean addMalla(Malla malla) {
        mallasDisp.put(malla.getMallaId(),malla);
        
        return true;
    }
    public boolean addMalla(String mallaId) {
        mallasDisp.put(mallaId, new Malla(mallaId));
        
        return true;
    }
    
    //quita la malla del mapa, eliminando clave y valor.
    public boolean removeMalla(String mallaId) {
        if (!mallasDisp.containsKey(mallaId))
            return false;
        
        mallasDisp.remove(mallaId);
        return true;
    }
    
    //Devuelve un set de strings, con el nombre de las mallas
    public Set getMallas() {
        return mallasDisp.keySet();
    }
    
    public Malla getMalla(String mallaId) {
        return mallasDisp.get(mallaId);
    }
    //añade una asignatura a una de las mallas de plantilla
    public boolean addAsignatura(String mallaId, String ramo, String profesor, int creditos) {
        
        if (!mallasDisp.containsKey(mallaId))
            return false;
        
        Malla malla = mallasDisp.get(mallaId);
        malla.agregarAsignatura(new Asignatura(ramo, profesor, creditos));
        
        return true;
    }
    
    //marca una asignatura de un alumno como aprobado
    public void marcarAprobado(String rut, String nombreAsignatura){
        
        if(!mapaPersonal.containsKey(rut))
            return;
        
        Alumno alumno = mapaPersonal.get(rut);
        Malla malla = alumno.getMalla();
            
        for (Asignatura asignatura : malla.getListaAsignaturas()) {
            if (asignatura.getRamo().equals(nombreAsignatura)) {
                asignatura.marcarAprobada();
                    return;
            }
        }
        
    }
    
    //marca una asignatura de un alumno como reprobado
    public void marcarNoAprobado(String rut , String nombreAsignatura){
        
        if(!mapaPersonal.containsKey(rut))
            return;

        Alumno alumno = mapaPersonal.get(rut);
        Malla malla = alumno.getMalla();
        for (Asignatura asignatura : malla.getListaAsignaturas()) {
            if (asignatura.getRamo().equals(nombreAsignatura)) {
                asignatura.marcarAprobada();
                return;
            }
        }
    }

    public Collection<Alumno> getAlumnos() {
        return mapaPersonal.values();
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