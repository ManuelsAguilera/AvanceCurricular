package com.pucv.avancecurricular;

/*
 * @author matias
 */

import com.pucv.avancecurricular.vista.AvanceCurricularSwing;
import com.pucv.avancecurricular.Logica.FileDatosPersonal;
import com.pucv.avancecurricular.Logica.DatosPersonal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controlador implements MouseListener {
    
    private AvanceCurricularSwing vista;
    private DatosPersonal datos;
    
    Controlador(AvanceCurricularSwing vista){
        
        datos = new DatosPersonal();
        
        this.vista = vista;
        this.vista.GetCsvCargarButton().addMouseListener(this);
        
        
        this.vista.setVisible(true);
    }
    
    public void mouseClicked(MouseEvent event){
        if (event.getSource() == vista.GetCsvCargarButton()) {
            System.out.println("1");
        } else if (event.getSource() == vista.GetCsvExpotarButton()){
            System.out.println("2");
        }
        
        System.out.println("Click");
    }
    
    public void mousePressed(MouseEvent event){
        System.out.println("Press");
    }
    
    public void mouseReleased(MouseEvent event){
        System.out.println("Realease");
    }
    
    public void mouseEntered(MouseEvent event){
        System.out.println("Enter");
    }
    
    public void mouseExited(MouseEvent event){
        System.out.println("Exit");
    }
    
    private void OnExportarCsv(){
        
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Carpeta Salida y nombre (*.csv)","csv");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Select Folder");
        
        int returnValue = fileChooser.showSaveDialog(null);
        
        String filePath = "";
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            //filePath = selectedFile.getAbsolutePath();
        }
        else {
            JOptionPane.showMessageDialog(this.vista,"Error con ruta de archivo");
            return;
        }
       
        try {
            exportarArchivo(filePath);
        }
        catch(FileNotFoundException e) //Revisar si es que no se esṕecifico archivo
        {
            try { exportarArchivo(filePath+"/alumnos.csv"); }
            //Si despues de agregar una ruta de archivo, sigue habiendo excepcion
            //retornar
            catch(FileNotFoundException _e)
            {
               JOptionPane.showMessageDialog(this.vista,"Error ruta del archivo");
            }
        }
    }
    
    private void exportarArchivo(String filePath) throws FileNotFoundException
    {
        try {
        System.out.println(filePath);
        FileDatosPersonal.exportarDatosPersonal(datos,filePath);
        
        }
        catch (UnsupportedEncodingException e)
        {
            JOptionPane.showMessageDialog(this.vista,"Error no se pudo hacer correctamente el encoding");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this.vista, "Error al cargar archivo");
        }
    }
    
    private void OnCargarCsv() {
        //Importar archivo
        
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Archivos de texto (*.csv)", "csv");
        fileChooser.setFileFilter(filter);
        
        
        int returnValue = fileChooser.showSaveDialog(null);
        
        String filePath = "";
        try {
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filePath = selectedFile.getAbsolutePath();
        }
        else
        {
            JOptionPane.showMessageDialog(this.vista,"Error al cargar el archivo");
            return;
        }
        
        FileDatosPersonal.importarDatosPersonal(datos,filePath);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this.vista, "Error al cargar archivo");
        }
    }
            
}

