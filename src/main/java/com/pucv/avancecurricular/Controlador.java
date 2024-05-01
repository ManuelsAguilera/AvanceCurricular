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
        this.vista.getAgregarMallaP().getAgregarBtn().addMouseListener(this);
        this.vista.getAgregarMallaP().getQuitarBtn().addMouseListener(this);
        this.vista.getVistaMallasP().getAcceptButton().addMouseListener(this);
        this.vista.getAdministrarAvanceP().getDeelButton().addMouseListener(this);
        this.vista.getAdministrarAvanceP().getMarcarAprobada().addMouseListener(this);
        this.vista.getAdministrarAvanceP().getMarcarNoAprobado().addMouseListener(this);
        this.vista.getAdministrarAvanceP().getVercred().addMouseListener(this);
        this.vista.getEditarMallasP().getAceptarElimninar().addMouseListener(this);
        this.vista.getEditarMallasP().getAddButton().addMouseListener(this);
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
       } else 
           if (event.getSource() == this.vista.getAgregarMallaP().getAgregarBtn()){
               //Los siguientes 2 if son acerca de agregar quitar mallas
               String mallaId = this.vista.getAgregarMallaP().getField();
               
               datos.addMalla(mallaId);
               JOptionPane.showMessageDialog(vista, "Añadido correctamente la malla "+mallaId, "Confirmacion", JOptionPane.PLAIN_MESSAGE);
           } else if (event.getSource() == this.vista.getAgregarMallaP().getQuitarBtn())
           {
               
               String mallaId = this.vista.getAgregarMallaP().getField();
               //Para quitar una plantilla
               String warningMsg = "¿Estas seguro?\nPerderas los datos de la malla ";
               warningMsg += "Pero los alumnos no perderan su malla asignada actualmente";
               int confirmation = JOptionPane.showConfirmDialog(this.vista,warningMsg);
               if (confirmation!=JOptionPane.YES_OPTION) //Si usuario no confirma
                   return;
               //sino
               try{
               datos.removeMalla(mallaId);
               }
               catch(EmptyTemplateException e)
               {
                   JOptionPane.showMessageDialog(this.vista,"Al parecer no existe la malla que deseas eliminar");
               }
           }
       
       if (event.getSource() == vista.getVistaMallasP().getAcceptButton())
       {
           System.out.println("Error hallando source");
           actualizarTablaAsignaturas();
       }
       if(event.getSource()==vista.getAdministrarAvanceP().getDeelButton())
       {
           deelAlumnoEvent();
           System.out.println("eliminado");
       }
       if(event.getSource()==vista.getAdministrarAvanceP().getMarcarNoAprobado()){  
            marcarNoAprobadoEvent();
       }
       if(event.getSource()==vista.getAdministrarAvanceP().getMarcarAprobada()){
           marcarAprobadoEvent();
       }
       if(event.getSource()==vista.getAdministrarAvanceP().getVercred()){
           verAvanceEvent();
       }
       if(event.getSource()==vista.getEditarMallasP().getAceptarElimninar()){
           eliminarAsignaturaEvent();
           
       }
       if(event.getSource()==vista.getEditarMallasP().getAddButton()){
           añadirAsignaturaEvent();
           
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
    
    private void filtradoTablaAlumnos(){
        Object[][] content = datos.getRowsAlumnos();
        this.vista.updateModel(content);
    }
    
    private void agregarAlumnosEvent()
    {
        Object[] datosAlumno = vista.getAgregarAlumnoP().getFields();

        try{
        datos.addAlumno((String) datosAlumno[0],(String) datosAlumno[1],(String) datosAlumno[2]);
        JOptionPane.showMessageDialog(vista, "Añadido correctamente al alumno "+(String)datosAlumno[0], "Confirmacion", JOptionPane.PLAIN_MESSAGE);
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
    
    private void deelAlumnoEvent()
    {
            String rut= vista.getAdministrarAvanceP().getRutfield();
            JOptionPane.showMessageDialog(this.vista,"Alumno eliminado con exito");
        try{
            datos.removeAlumno(rut);
        }catch(EmptyCollectionException e){
            JOptionPane.showMessageDialog(this.vista,"no se encontro alumno");
        }
    }
    
    private void marcarAprobadoEvent()
    {
        String rut= vista.getAdministrarAvanceP().getRutfield();
        String asignatura=vista.getAdministrarAvanceP().getAsignaturaAfield();
       try{
           datos.marcarAprobado(rut,asignatura);
           JOptionPane.showMessageDialog(this.vista,"marcada aprobada con exito");
           
       }catch(EmptyCollectionException e){
           JOptionPane.showMessageDialog(this.vista,"no se encontro asignatura o rut");
       }
    }
    
    private void marcarNoAprobadoEvent()
    {
        String rut= vista.getAdministrarAvanceP().getRutfield();
        String asignatura=vista.getAdministrarAvanceP().getNombreNoaprodado();
        JOptionPane.showMessageDialog(this.vista,"marcar no aprobado con exito");
       try{
           datos.marcarNoAprobado(rut,asignatura);
       }catch(EmptyCollectionException e){
           JOptionPane.showMessageDialog(this.vista,"no se encontro asignatura o rut");
       }
    }
    
    private void verAvanceEvent(){
        String rut= vista.getAdministrarAvanceP().getRutfield();
        try{
            Alumno alumno=(Alumno)datos.getAlumno(rut);
            int cred=alumno.calcularCreditosCursados();
            JOptionPane.showMessageDialog(this.vista,"creditos alumno:"+cred);
        }catch(EmptyCollectionException e){
            JOptionPane.showMessageDialog(this.vista,"no se encontro alumno");
        }  
    }
    private void eliminarAsignaturaEvent(){
        String malla=vista.getEditarMallasP().getNombreMalla();
        String asignatura=vista.getEditarMallasP().getNombreAñadir();  
        JOptionPane.showMessageDialog(this.vista,"asignatura eliminada");
        try{
            datos.removeAsignatura(malla, asignatura);
        }catch(EmptyCollectionException e){
            JOptionPane.showMessageDialog(this.vista,"error al eliminar");
        }
    }
    
    private void añadirAsignaturaEvent(){
        String malla=vista.getEditarMallasP().getNombreMalla();
        String asignatura=vista.getEditarMallasP().getNombreAñadir(); 
        String profesor=vista.getEditarMallasP().getNombreProfesor();
        int creditos=vista.getEditarMallasP().getCreditos();
        try{
            datos.addAsignatura(malla,asignatura,profesor,creditos);
            JOptionPane.showMessageDialog(this.vista,"asignatura añadida");
        }catch(EmptyCollectionException e){
            JOptionPane.showMessageDialog(this.vista,"error al añadir asignatura");
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

