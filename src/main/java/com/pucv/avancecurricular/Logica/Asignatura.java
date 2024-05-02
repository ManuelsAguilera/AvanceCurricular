package com.pucv.avancecurricular.Logica;

/**
 * Clase que sirve de contenedor de
 * la informacíon que conforma una asignatura,
 * a entendimientos de la aplicación.
 * 
 * @author alfar
 */

public class Asignatura {
    
    private String ramo;
    private String profesor;
    private int creditos;
    private Boolean estado;

    /**
     * Constructor de la clase Asignatura.
     * 
     * 
     * @param ramo Nombre de la asignatura.
     * @param profesor Nombre del profesor que hace la asignatura.
     * @param creditos Creditos que vale la asignatura.
     * @param estado Si esta aprobado o reprobado (true, false).
     */
    
    public Asignatura(String ramo, String profesor, int creditos, boolean estado) {
        this.ramo = ramo;
        this.profesor = profesor;
        this.creditos = creditos;
        this.estado = estado;
    }
    
    /**
     * Constructor de la clase Asignatura.
     * 
     * 
     * @param ramo Nombre de la asignatura.
     * @param profesor Nombre del profesor que hace la asignatura.
     * @param creditos Creditos que vale la asignatura.
     */
    
    public Asignatura(String ramo, String profesor, int creditos) {
        this.ramo     = ramo;
        this.profesor = profesor;
        this.creditos = creditos;
        this.estado   = false;
    }
    
    /**
     * Metodo para conseguir el ramo.
     * 
     * @return Nombre del ramo.
     */
    public String getRamo() {
        return ramo;
    }
    
    /**
     * Metodo para revisar si la asignatura esta aprobada.
     * 
     * @return true si la asignatura esta aprobada y false si la asignatura esta reprobada.
     */
    
    public boolean isAprobada(){
        return this.estado;
    }
    
    /**
     * Metodo para marcar la asignatura como aprobada.
     */
    public void marcarAprobada() {
        this.estado = true;
    }
    
    /**
     * Metodo para marcar la asignatura como reprobada.
     */
    
    public void marcarReprobado(){
        this.estado=false;
    }

    /**
     * Metodo para cambiar el nombre del ramo.
     * 
     * @param ramo Nombre del ramo.
     */
    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    /**
     * Obtiene el nombre del profesor que imparte la asignatura.
     * 
     * @return Nombre del profesor.
     */
    public String getProfesor() {
        return profesor;
    }

    /**
     * Establece el nombre del profesor que imparte la asignatura.
     * 
     * @param profesor Nombre del profesor.
     */
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    /**
     * Metodo para coseguir la cantidad de créditos que da la asignatura.
     * 
     * @return Cantidad de créditos.
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Metodo para cambiar la cantidad de créditos que da la asignatura.
     * 
     * @param creditos Cantidad de créditos.
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * Metodo para conseguir el estado de aprobación de la asignatura.
     * 
     * @return true si la asignatura está aprobada, false si está reprobada.
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * Metodo para cambiar el estado de aprobación de la asignatura.
     * 
     * @param estado true si la asignatura está aprobada, false si está reprobada.
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}