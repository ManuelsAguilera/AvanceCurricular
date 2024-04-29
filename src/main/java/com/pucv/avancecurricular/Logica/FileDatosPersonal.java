/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucv.avancecurricular.Logica;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


/**
 *
 * @author magui
 * 
 * Esta clase esta hecha para cargar datos desde un csv con formato apropiado.
 * 
 */
public class FileDatosPersonal {

    
   private FileDatosPersonal()  
    {
                
        
    }
   
   

   
   public static void exportarDatosPersonal(DatosPersonal datos,String ruta) throws UnsupportedEncodingException,FileNotFoundException{
        PrintWriter writer = null;

        writer = new PrintWriter(new File(ruta+"alumnos.csv"), "UTF-8");
        writer.println("Mallas");
        writer.println(" ");
        for(Malla act:datos.getMalla2()){
            writer.println(act.getMallaId());
            for(Asignatura a:act.getListaAsignaturas()){
                writer.println(a.getRamo()+","+a.getProfesor()+","+a.getCreditos());

            }
            writer.println(" ");
        }
        writer.println("alumnos");
        writer.println(" ");
        for(Alumno actA:datos.getAlumnos()){
            writer.print(actA.getRut()+","+actA.getNombre()+","+actA.getMalla().getMallaId());
            for(Asignatura asignaturas:actA.getMalla().getListaAsignaturas()){
                 writer.print(","+(asignaturas.isAprobada() ? "1" : "0"));

            }
            writer.println(" ");
        }
        writer.close();
        //a


    }
   
   public static void importarDatosPersonal(DatosPersonal datos, String csvFile) throws EmptyTemplateException {
        String line = "";
        String cvsSplitBy = ",";
        Malla currentMalla = null;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                
                String[] data = line.split(cvsSplitBy);
                if(line.contains("alumnos")){
                    continue;
                }
                
                if(line.contains("Mallas")){
                    continue;
                }
               
                if (data.length == 1 && !data[0].isEmpty()) {
                    currentMalla = new Malla(data[0]);
                    datos.addMalla(currentMalla);
                } 
                
                else if (currentMalla != null && data.length == 3) {
                    Asignatura asignatura = new Asignatura(data[0], data[1], Integer.parseInt(data[2]));
                    currentMalla.agregarAsignatura(asignatura);
                }
               
                else if (data.length > 3) {
                    Malla malla = datos.getMalla(data[2]);
                    Alumno alumno = new Alumno(data[1], data[0], malla);
                    datos.addAlumno(alumno);
                    
                
                    ArrayList<Asignatura> asignaturas = malla.getListaAsignaturas();
                    for (int i = 3; i < data.length; i++) {
                        if (data[i].equals("1")) {
                            asignaturas.get(i-3).marcarAprobada();
                        } else {
                            asignaturas.get(i-3).marcarReprobado();
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   

    
}
