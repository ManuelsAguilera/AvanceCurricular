package com.pucv.avancecurricular.Logica;

/*
 * @author alfar
 */

public class Asignatura {
    
    private String ramo;
    private String profesor;
    private int creditos;
    private Boolean estado;

    public Asignatura(String ramo, String profesor, int creditos, boolean estado) {
        this.ramo = ramo;
        this.profesor = profesor;
        this.creditos = creditos;
        this.estado = estado;
    }
    
    public Asignatura(String ramo, String profesor, int creditos) {
        this.ramo     = ramo;
        this.profesor = profesor;
        this.creditos = creditos;
        this.estado   = false;
    }

    public String getRamo() {
        return ramo;
    }
    public boolean isAprobada(){
        return this.estado;
    }
    public void marcarAprobada() {
        this.estado = true;
    }
    
    public void marcarReprobado(){
        this.estado=false;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
