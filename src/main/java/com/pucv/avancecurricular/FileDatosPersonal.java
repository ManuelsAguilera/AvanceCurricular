/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pucv.avancecurricular;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 *
 * @author magui
 * 
 * Esta clase esta hecha para cargar datos desde un csv con formato apropiado.
 * 
 */
public class FileDatosPersonal {
    private Scanner reader;
    private String path;
    
    public static void main(String[] args)  //Para testear
    {
        FileDatosPersonal F = new FileDatosPersonal("adssd");
        System.out.println("Ingrese: ");
        Scanner scan = new Scanner(System.in);
        System.out.println(scan.nextLine());
    }
    
   public FileDatosPersonal()
   {
       this.reader = null;
       this.path=null;
   }
    
   public FileDatosPersonal(String path)  
    {
        try {
        this.reader = new Scanner(new File(path));
        this.path = path;
        }
        catch (FileNotFoundException E){ //Si el path es invalido el siguiente codigo se ejecuta
            E.printStackTrace();
            System.out.println("Ingrese una ruta valida usando FileDatosPersonal.setPath('path to file')");
            this.reader = null;
            this.path = path;
        }
        
    }
   
   
   public void setPath(String Path)
   {
      try {
        this.reader = new Scanner(new File(path));
        this.path = path;
        }
        catch (FileNotFoundException E){
            E.printStackTrace();
            System.out.println("Ingrese una ruta valida usando FileDatosPersonal.setPath('path to file')");
            this.reader = null;
            this.path = path;
        } 
   }
   
   
   
   public boolean importarDatosPersonal(DatosPersonal datos)
   {
       
       
       return false;
   }
   
   public boolean importarDatosPersonal(DatosPersonal datos, String path)
   {
       this.setPath(path);
       return importarDatosPersonal(datos);
   }
   
    
}
