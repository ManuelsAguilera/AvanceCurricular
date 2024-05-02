package com.pucv.avancecurricular.Logica;

/**
 * Clase Alumno, esta clase sirve de contenedor
 * de la información que conforma un alumno.
 * 
 * @author alfar
 */

public class Alumno {
    
    private String nombre;
    private String rut;

    private Malla malla;
    
    public Alumno() {
        this.nombre   = "";
        this.rut      = "";
        this.malla    = null;
    }
    
    /**
     * Constructor de la clase alumno.
     * 
     * @param nombre Nombre del alumno a crear.
     * @param rut Identificador unico del alumno.
     * @param malla La malla de la carrera que el alumno va a cursar.
     */
    
    public Alumno(String nombre, String rut, Malla malla) {
        this.nombre   = nombre;
        this.rut      = rut;
        this.malla    = malla;
    }
    
    /**
     * Metodo para conseguir la cantidad total de creditos obtenidos por el alumno.
     * 
     * @return devuelve la cantidad total de creditos obtenidos por el alumno.
     */
    
    public int calcularCreditosCursados() {
        int creditosCursados=0;
        for (Asignatura asignatura : malla.getListaAsignaturas()) {
            
            if (asignatura.getEstado())
                creditosCursados += asignatura.getCreditos();
        }
        
        return creditosCursados;
    }
    
    /**
     * Metodo para conseguir la cantidad total de créditos en la malla.
     * 
     * @return devuelve la cantidad total de créditos de la malla.
     */
    
    public int calcularCreditosMalla(){
        
        int creditosMalla = 0;
        for (Asignatura asignatura : malla.getListaAsignaturas()) {
            creditosMalla += asignatura.getCreditos();
        }
        
        return creditosMalla;
    }
    
    /**
     * Metodo para conseguir el nombre de un alumno.
     * 
     * @return Nombre del alumno.
     */
    
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para conseguir la malla de un alumno.
     * 
     * @return Malla del alumno.
     */
    
    public Malla getMalla() {
        return malla;
    }
    
    /**
     * Metodo para conseguir el RUT de un alumno.
     * 
     * @return RUT del alumno.
     */

    public String getRut() {
        return rut;
    }

    /**
     * Metodo para cambiar la malla de un alumno.
     * 
     * 
     * @param malla Nueva malla para el alumno.
     */

    public void setMalla(Malla malla) {
        this.malla = malla;
    }
    
    /**
     * Metodo para cambiar el nombre de un alumno.
     * 
     * 
     * @param nombre Nuevo nombre para el alumno.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo para cambiar el rut del alumno.
     * 
     * @param rut Nuevo rut del alumno.
     */

    public void setRut(String rut) {
        this.rut = rut;
    }
}