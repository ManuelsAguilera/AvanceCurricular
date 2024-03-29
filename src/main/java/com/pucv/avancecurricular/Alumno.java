package com.pucv.avancecurricular;

/*
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
    public Alumno(String nombre, String rut, Malla malla) {
        this.nombre   = nombre;
        this.rut      = rut;
        this.malla    = malla;
    }
    public int calcularCreditosCursados() {
        int creditosCursados=0;
        for (Asignatura asignatura : malla.getListaAsignaturas()) {
            
            if (asignatura.getEstado())
                creditosCursados += asignatura.getCreditos();
        }
        
        return creditosCursados;
    }
    
    public int calcularCreditosMalla(){
        
        int creditosMalla = 0;
        for (Asignatura asignatura : malla.getListaAsignaturas()) {
            creditosMalla += asignatura.getCreditos();
        }
        
        return creditosMalla;
    }

    public String getNombre() {
        return nombre;
    }

    public Malla getMalla() {
        return malla;
    }

    public String getRut() {
        return rut;
    }

    

    public void setMalla(Malla malla) {
        this.malla = malla;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }


    
}
