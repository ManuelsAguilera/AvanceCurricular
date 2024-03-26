/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucv.avancecurricular;

import java.util.ArrayList;

/**
 *
 * @author alfar
 */
public class Malla {
    private ArrayList<Asignatura> listaAsignaturas;
    
    public Malla(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }
    
    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public void agregarAsignatura(Asignatura asignatura) {
        if (listaAsignaturas == null) {
            listaAsignaturas = new ArrayList<>();
        }
        listaAsignaturas.add(asignatura);
    }
    
    
}
