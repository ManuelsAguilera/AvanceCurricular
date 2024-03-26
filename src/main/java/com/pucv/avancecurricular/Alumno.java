/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucv.avancecurricular;

/**
 *
 * @author alfar
 */
public class Alumno {
    private String nombre;
    private String rut;
    private int creditos;

    public Alumno(String nombre, String rut, int creditos) {
        this.nombre = nombre;
        this.rut = rut;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
}
