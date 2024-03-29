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
    private String mallaId;
    private ArrayList<Asignatura> listaAsignaturas;
    
    public Malla(String id,ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
        this.mallaId = id;
    }
    public Malla(String id)
    {
        this.mallaId=id;
        this.listaAsignaturas = new ArrayList<Asignatura>();
    }

    public boolean isEmpty()
    {
        return listaAsignaturas.isEmpty();
    }
    
    
    
    
    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }
    
    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public void agregarAsignatura(Asignatura asignatura) {
        listaAsignaturas.add(asignatura);
    }
    
    
}
