package com.pucv.avancecurricular.Logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/*
 * Esta clase accede a la informacion sobre la malla curricular de alumnos.
 * En un futuro podria ser implementado informacion sobre los profesores, o 
 * informacion de los alumnos desde las mallas o carreras.
 *
 * @author manu
 */

public class DatosPersonal {
    
    private HashMap<String, Alumno> mapaPersonal ;
    private TreeMap<String, Malla>  mallasDisp;
    
    /**
     * Constructor de la clase DatosPersonal
     */
    
    public DatosPersonal() {
        mapaPersonal = new HashMap<String, Alumno>();
        mallasDisp   = new TreeMap<String, Malla>();
    }
    
    /**
     * Metodo que añade un alumno al HashMap, solo si es que se le puede asociar una malla a este.
     * 
     * @param nombre   Nombre del alumno.
     * @param rut      RUT del alumno.
     * @param mallaId  Nombre de la malla.
     * @return Devuelve true si la operación es exitosa.
     * @throws EmptyTemplateException 
     */
    
    public boolean addAlumno(String nombre, String rut, String mallaId) throws EmptyTemplateException{
        
        if (mallasDisp.isEmpty())
            throw new EmptyTemplateException();
        
        Alumno newAlumno= new Alumno(nombre, rut, mallasDisp.get(mallaId));
        mapaPersonal.putIfAbsent(rut, newAlumno);
        
        return true;
    }
    
    /**
     * Metodo que añade un alumno al HashMap, solo si es que se le puede asociar una malla a este.
     * 
     * @param alumno Alumno a insertar.
     * @return Devuelve true si la operación es exitosa.
     * @throws EmptyTemplateException 
     */
    
    public boolean addAlumno(Alumno alumno) throws EmptyTemplateException {
        
        if (mallasDisp.isEmpty())
            throw new EmptyTemplateException();
        
        
        mapaPersonal.putIfAbsent(alumno.getRut(), alumno);
        
        return true;
    }
    
    /**
     * Metodo para conseguir.
     * 
     * @param rut RUT del alumno.
     * @return Devuelve el alumno.
     * @throws EmptyCollectionException 
     */
    
    public Alumno getAlumno(String rut) throws EmptyCollectionException{
        
        if (!mapaPersonal.containsKey(rut))
                throw new EmptyCollectionException();
        
        return mapaPersonal.get(rut);
    }
    
    /**
     * Metodo para remover el valor y key de el hashmap alumnos
     * 
     * @param rut RUT del alumno a remover
     * @throws EmptyCollectionException 
     */
    
    public void removeAlumno(String rut) throws EmptyCollectionException {
        if (!mapaPersonal.containsKey(rut)) {
            throw new EmptyCollectionException();
        }
        
        mapaPersonal.remove(rut);
    }
    
    /**
     * Añade una instancia malla, a nuestro mapa de mallas asociandolo a un nombre.
     * Ejemplo: "Ingenieria civil informatica 2020"::new Malla.
     * 
     * @param malla Malla a añadir.
     * @return Devuelve true si la operación es existosa.
     */
    
    public boolean addMalla(Malla malla) {
        mallasDisp.put(malla.getMallaId(),malla);
        
        return true;
    }
    
    /**
     * Añade una malla por nombre de la misma.
     * 
     * @param mallaId Nombre de la malla
     * @return Devuelve true si la operación es existosa
     */
    
    public boolean addMalla(String mallaId) {
        mallasDisp.put(mallaId, new Malla(mallaId));
        
        return true;
    }
    
    /**
     * Metodo para quitar la malla del mapa, eliminando clave y valor.
     * 
     * @param mallaId Nombre de la malla.
     * @return Devuelve true si la operación es existosa
     * @throws EmptyTemplateException 
     */
    
    public boolean removeMalla(String mallaId) throws EmptyTemplateException {
        if (!mallasDisp.containsKey(mallaId))
            throw new EmptyTemplateException();
        
        mallasDisp.remove(mallaId);
        
        return true;
    }
    
    /**
     * Metodo que devuelve un set de strings, con el nombre de las mallas.
     * 
     * @return Retorna el set de mallas
     */
    
    public Set getMallas() {
        return mallasDisp.keySet();
    }
    
    /**
     * Metodo que consigue una malla, por su nombre.
     * 
     * @param mallaId Nombre de la malla.
     * @return Malla con el nombre de parametro.
     * @throws EmptyTemplateException .
     */
    
    public Malla getMalla(String mallaId) throws EmptyTemplateException {
        if (!mallasDisp.containsKey(mallaId))
            throw new EmptyTemplateException();
        return mallasDisp.get(mallaId);
    }
    
    /**
     * Añade una asignatura a una de las mallas de plantilla.
     * 
     * @param mallaId Nombre de la malla.
     * @param ramo Nombre del ramo.
     * @param profesor Nombre del profesor.
     * @param creditos Cantidad de creditos que vale la asignatura.
     * @return Devuelve true si la operación es existosa.
     * @throws EmptyCollectionException 
     */
    
    public boolean addAsignatura(String mallaId, String ramo, String profesor, int creditos) throws EmptyCollectionException {
        
        if (!mallasDisp.containsKey(mallaId))
            throw new EmptyCollectionException();
        
        Malla malla = mallasDisp.get(mallaId);
        malla.agregarAsignatura(new Asignatura(ramo, profesor, creditos));
        
        return true;
    }
    
    /**
     * Remueve una asignatura
     * 
     * @param mallaId
     * @param asignatura
     * @return Devuelve true si la operación es existosa.
     * @throws EmptyCollectionException 
     */
    
    public boolean removeAsignatura(String mallaId, String asignatura) throws EmptyCollectionException {
        if (!mallasDisp.containsKey(mallaId))
            throw new EmptyCollectionException();
        
        Malla malla = mallasDisp.get(mallaId);
        Asignatura asigna=(Asignatura) malla.getAsignatura(asignatura);
        malla.eliminarAsignatura(asigna);
        
        return true;
    }
    
    /**
     * Metodo para marcar una asignatura de un alumno como aprobado.
     * 
     * @param rut RUT del alumno.
     * @param nombreAsignatura Nombre de la asignatura.
     * @throws EmptyCollectionException 
     */
    
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
    
    /**
     * Metodo para marcar  una asignatura de un alumno como reprobado.
     * 
     * @param rut RUT del alumno.
     * @param nombreAsignatura Nombre de la asignatura.
     * @throws EmptyCollectionException 
     */
    
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
    
    /**
     * Metodos para conseguir todos los alumnos.
     * 
     * @return Devuelve los valores de los alumnos.
     */
    
    public Collection<Alumno> getAlumnos() {
        return mapaPersonal.values();
    }
    
    /**
     * Metodos para conseguir todas las mallas.
     * 
     * @return Devuelve todos los valores mallas.
     */
    
    public Collection<Malla> getMalla2(){
        return mallasDisp.values();
    }
    
    /**
     * Metodo para consegir un matriz de alumnos.
     * 
     * @return Matriz de alumnos.
     */
    
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
    
    /**
     * Consigue los aluons por cada malla en forma de matriz
     * 
     * @param nombreMalla Nombre de la malla 
     * @return Retorna una matriz de alumnos 
     * @throws EmptyTemplateException 
     */
    public Object[][] getRowsAlumnosPorMalla(String nombreMalla) throws EmptyTemplateException {
        List<Alumno> alumnosEnMalla = new ArrayList<>();

        for (Alumno alumno : mapaPersonal.values()) {
            if (alumno.getMalla().getMallaId().equals(nombreMalla)) {
                alumnosEnMalla.add(alumno);
            }
        }

        Object[][] rowsAlumnos = new Object[alumnosEnMalla.size()][4];

        int index = 0;
        for (Alumno alumno : alumnosEnMalla) {
            rowsAlumnos[index][0] = alumno.getNombre();
            rowsAlumnos[index][1] = alumno.getRut();
            rowsAlumnos[index][2] = alumno.getMalla().getMallaId();
            rowsAlumnos[index][3] = alumno.calcularCreditosCursados();
            index++;
        }

        return rowsAlumnos;
    }
    
    /**
     * Metodo para conseguir una matiz de mallas
     * 
     * @param idMalla Nombre de la malla.
     * @return Devuelve una matriz de alumnos.
     * @throws EmptyTemplateException 
     */
    
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