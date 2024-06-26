package com.pucv.avancecurricular.Logica;
import java.util.ArrayList;

/*
 * @author alfar
 */

public class Malla {
    
    private String mallaId;
    private ArrayList<Asignatura> listaAsignaturas;
    
    public Malla(String id, ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
        this.mallaId = id;
    }
    public Malla(String id)
    {
        this.mallaId = id;
        this.listaAsignaturas = new ArrayList<Asignatura>();
    }

    public boolean isEmpty()
    {
        return listaAsignaturas.isEmpty();
    }

    public String getMallaId() {
        return mallaId;
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
    
    public void eliminarAsignatura(Asignatura asignatura) {
        listaAsignaturas.remove(asignatura);
    }
    
    public Asignatura getAsignatura(String asignatura){
        for(Asignatura asig:listaAsignaturas){
            if(asig.getRamo().equals(asignatura)){
                return asig;
            }
        }
        return null;   
    }
    public void agregarAsignatura(String ramo, String profesor, int creditos,boolean estado) {
        
        listaAsignaturas.add(new Asignatura(ramo,profesor,creditos,estado));
    }
}
