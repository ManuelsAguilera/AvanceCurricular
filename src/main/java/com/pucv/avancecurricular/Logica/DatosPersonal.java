package com.pucv.avancecurricular.Logica;

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
    public boolean addAlumno(String nombre, String rut, String mallaId) throws EmptyTemplateException{
        
        if (mallasDisp.isEmpty())
            throw new EmptyTemplateException();
        
        Alumno newAlumno= new Alumno(nombre, rut, mallasDisp.get(mallaId));
        mapaPersonal.putIfAbsent(rut, newAlumno);
        
        return true;
    }
    
    public boolean addAlumno(Alumno alumno) throws EmptyTemplateException {
        
        if (mallasDisp.isEmpty())
            throw new EmptyTemplateException();
        
        
        mapaPersonal.putIfAbsent(alumno.getRut(), alumno);
        
        return true;
    }
    
    public Alumno getAlumno(String rut) throws EmptyCollectionException{
        
        if (!mapaPersonal.containsKey(rut))
                throw new EmptyCollectionException();
        
        return mapaPersonal.get(rut);
    }
    
    // Remueve el valor y key de el hashmap alumnos
    public void removeAlumno(String rut) throws EmptyCollectionException {
    if (!mapaPersonal.containsKey(rut)) {
        throw new EmptyCollectionException();
    }
    mapaPersonal.remove(rut);
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
    public boolean removeMalla(String mallaId) throws EmptyTemplateException {
        if (!mallasDisp.containsKey(mallaId))
            throw new EmptyTemplateException();
        
        mallasDisp.remove(mallaId);
        
        return true;
    }
    
    //Devuelve un set de strings, con el nombre de las mallas
    public Set getMallas() {
        return mallasDisp.keySet();
    }
    
    public Malla getMalla(String mallaId) throws EmptyTemplateException {
        if (!mallasDisp.containsKey(mallaId))
            throw new EmptyTemplateException();
        return mallasDisp.get(mallaId);
    }
    //añade una asignatura a una de las mallas de plantilla
    public boolean addAsignatura(String mallaId, String ramo, String profesor, int creditos) throws EmptyCollectionException {
        
        if (!mallasDisp.containsKey(mallaId))
            throw new EmptyCollectionException();
        
        Malla malla = mallasDisp.get(mallaId);
        malla.agregarAsignatura(new Asignatura(ramo, profesor, creditos));
        
        return true;
    }
    
    //marca una asignatura de un alumno como aprobado
    public void marcarAprobado(String rut, String nombreAsignatura) throws EmptyCollectionException{
        
        if(!mapaPersonal.containsKey(rut))
            throw new EmptyCollectionException();
        
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
    public void marcarNoAprobado(String rut , String nombreAsignatura) throws EmptyCollectionException{
        
        if(!mapaPersonal.containsKey(rut))
            throw new EmptyCollectionException();

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
    
    public Collection<Malla> getMalla2(){
        return mallasDisp.values();
    }
    
    public Object[][] getRowsAlumnos() {
    Object[][] rowsAlumnos = new Object[mapaPersonal.size()][4]; // Inicializamos la matriz con el tamaño adecuado
    
    int index = 0;
    for (HashMap.Entry<String, Alumno> entry : mapaPersonal.entrySet()) {
        Alumno alumno = entry.getValue();
        rowsAlumnos[index][0] = alumno.getNombre();
        rowsAlumnos[index][1] = alumno.getRut();
        rowsAlumnos[index][2] = alumno.getMalla().getMallaId();
        rowsAlumnos[index][3] = alumno.calcularCreditosCursados();
        index++;
    }
    
    return rowsAlumnos;
}
    public Object[][] getRowsMallas(String idMalla) throws EmptyTemplateException
    {
        Malla malla = getMalla(idMalla);
        Object[][] rowsAsignaturas = new Object[malla.getListaAsignaturas().size()][3];
        
        int index=0;
        for (Asignatura asignatura: malla.getListaAsignaturas())
        {
            
            rowsAsignaturas[index][0] = asignatura.getRamo();
            rowsAsignaturas[index][1] = asignatura.getCreditos();
            rowsAsignaturas[index][2] = asignatura.getProfesor();
            index++;
        }
        return rowsAsignaturas;
    }

}