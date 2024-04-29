package com.pucv.avancecurricular;

/*
 * @author matias
 */

import com.pucv.avancecurricular.vista.AvanceCurricularSwing;
import com.pucv.avancecurricular.Logica.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controlador implements MouseListener {
    
    private AvanceCurricularSwing vista;
    private DatosPersonal datos;
    
    Controlador(AvanceCurricularSwing vista) throws Exception{
        
        this.datos = new DatosPersonal();
        this.vista = vista;
        
        
        FileDatosPersonal.importarDatosPersonal(datos, ".alumnos.csv");  
        actualizarTablaAlumnos();
        
        this.vista.GetCsvCargarButton().addMouseListener(this);
        this.vista.GetCsvExpotarButton().addMouseListener(this);
        
        //Leer actualizador de vista general alumnos
        this.vista.getVistaAlumnoBtn().addMouseListener(this);
        this.vista.getAgregarAlumnoP().getAcceptButton().addMouseListener(this);
        this.vista.getVistaMallasP().getAcceptButton().addMouseListener(this);
        this.vista.setVisible(true);
    }
    
    public void importarAlCerrar() throws Exception
    {
        FileDatosPersonal.exportarDatosPersonal(datos,"./.");
    }
    public void mouseClicked(MouseEvent event){
        
        System.out.println("Click");
    }
    
    public void mousePressed(MouseEvent event){
        System.out.println("Press");
        
        if (event.getSource() == vista.GetCsvCargarButton()) {
            OnCargarCsv();
        } else if (event.getSource() == vista.GetCsvExpotarButton()){
            OnExportarCsv();
        }
        
        //Eventos de cada panel
       if (event.getSource() == vista.getVistaAlumnoBtn()) 
        {
            //Actualizar modelo de alumnos
            actualizarTablaAlumnos();
        }
       else if (event.getSource() == vista.getAgregarAlumnoP().getAcceptButton()){
           //boton de agregar un alumno
           
           agregarAlumnosEvent();
       }
       
       if (event.getSource() == vista.getVistaMallasP().getAcceptButton())
       {
           System.out.println("Error hallando source");
           actualizarTablaAsignaturas();
       }
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
    
    private void actualizarTablaAsignaturas()
    {
        System.out.println("Error en actualizar");
        String mallaId = vista.getVistaMallasP().getField();
        
        try {
        Object[][] asignaturas = datos.getRowsMallas(mallaId);
        vista.getVistaMallasP().cargarAsignaturas(asignaturas);
        }
        catch(EmptyTemplateException e)
        {
            JOptionPane.showMessageDialog(this.vista,"Verifica que exista la malla");
        }
        
        
        
        
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
    
    private void actualizarTablaAlumnos()
    {
        Object[][] content = datos.getRowsAlumnos();
            
        this.vista.updateModel(content);
    }
    private void agregarAlumnosEvent()
    {
        Object[] datosAlumno = vista.getAgregarAlumnoP().getFields();

        try{
        datos.addAlumno((String) datosAlumno[0],(String) datosAlumno[1],(String) datosAlumno[2]);
        }
        catch(EmptyTemplateException e)
        {
            JOptionPane.showMessageDialog(this.vista,"Intenta de nuevo, registrando una plantilla de malla");
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

