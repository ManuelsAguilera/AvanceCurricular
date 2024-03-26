/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucv.avancecurricular;

/**
 *
 * @author alfar
 */
public class Asignatura {
    private String ramo;
    private String profesor;
    private int creditos;
    private Boolean estado;

    public Asignatura(String ramo, String profesor, int creditos, Boolean estado) {
        this.ramo = ramo;
        this.profesor = profesor;
        this.creditos = creditos;
        this.estado = estado;
    }

    public String getRamo() {
        return ramo;
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