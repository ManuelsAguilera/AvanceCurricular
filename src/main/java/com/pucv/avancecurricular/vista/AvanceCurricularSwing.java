/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pucv.avancecurricular.vista;
import com.pucv.avancecurricular.Logica.DatosPersonal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
//import java.awt.*;
/**
 *
 * @author alfar
 */
public class AvanceCurricularSwing extends javax.swing.JFrame {

    /**
     * Creates new form AvanceCurricularSwing
     */
    
    public AvanceCurricularSwing() {
        this.setTitle("Administrador de alumnos y mallas");
        initComponents();
        
    }
   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        label = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        PanelButtons = new javax.swing.JPanel();
        vistaGeneralAlumnos = new javax.swing.JButton();
        agregarAlumnos = new javax.swing.JButton();
        administrarAvanceAlumno = new javax.swing.JButton();
        agregarMalla = new javax.swing.JButton();
        editarMalla = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        optionsPane = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivoMenuButton = new javax.swing.JMenu();
        csvMenuItemExportar = new javax.swing.JMenuItem();
        csvMenuItemCargar = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Avance Curricular (GUI)");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        PanelButtons.setBackground(new java.awt.Color(0, 255, 0));
        PanelButtons.setForeground(new java.awt.Color(51, 51, 51));

        vistaGeneralAlumnos.setText("Vista general alumnos");
        vistaGeneralAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaGeneralAlumnosActionPerformed(evt);
            }
        });

        agregarAlumnos.setText("Agregar alumnos");
        agregarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAlumnosActionPerformed(evt);
            }
        });

        administrarAvanceAlumno.setText("Administrar avance alumno");
        administrarAvanceAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarAvanceAlumnoActionPerformed(evt);
            }
        });

        agregarMalla.setText("Agregar Malla");
        agregarMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMallaActionPerformed(evt);
            }
        });

        editarMalla.setText("Editar malla");
        editarMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarMallaActionPerformed(evt);
            }
        });

        jButton6.setText("Vista general de mallas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelButtonsLayout = new javax.swing.GroupLayout(PanelButtons);
        PanelButtons.setLayout(PanelButtonsLayout);
        PanelButtonsLayout.setHorizontalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarMalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarMalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(administrarAvanceAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarAlumnos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vistaGeneralAlumnos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelButtonsLayout.setVerticalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(vistaGeneralAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(administrarAvanceAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregarMalla, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarMalla, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(PanelButtons, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(PanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(PanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        archivoMenuButton.setText("Archivo");

        csvMenuItemExportar.setText("Exportar csv");
        csvMenuItemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csvMenuItemExportarActionPerformed(evt);
            }
        });
        archivoMenuButton.add(csvMenuItemExportar);

        csvMenuItemCargar.setText("Cargar csv");
        csvMenuItemCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csvMenuItemCargarActionPerformed(evt);
            }
        });
        archivoMenuButton.add(csvMenuItemCargar);

        jMenuBar1.add(archivoMenuButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(optionsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(optionsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        optionsPane.addTab("",(JPanel) new VistaAlumnosP());
        optionsPane.addTab("", (JPanel) new AgregarAlumnoP());
        optionsPane.addTab("", (JPanel) new AdministrarAvanceP());
        optionsPane.addTab("",(JPanel) new AgregarMallaP());
        optionsPane.addTab("",(JPanel) new EditarMallasP());
        optionsPane.addTab("", (JPanel) new VistaMallasP());

        optionsPane.setEnabledAt(0,false);
        optionsPane.setEnabledAt(1,false);
        optionsPane.setEnabledAt(2,false);
        optionsPane.setEnabledAt(3,false);
        optionsPane.setEnabledAt(4,false);
        optionsPane.setEnabledAt(5,false);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void csvMenuItemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csvMenuItemExportarActionPerformed

        
    }//GEN-LAST:event_csvMenuItemExportarActionPerformed

    private void csvMenuItemCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csvMenuItemCargarActionPerformed
      
    }//GEN-LAST:event_csvMenuItemCargarActionPerformed

    private void vistaGeneralAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaGeneralAlumnosActionPerformed
        optionsPane.setSelectedIndex(0);
    }//GEN-LAST:event_vistaGeneralAlumnosActionPerformed

    private void agregarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAlumnosActionPerformed
        optionsPane.setSelectedIndex(1);

    }//GEN-LAST:event_agregarAlumnosActionPerformed

    private void administrarAvanceAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarAvanceAlumnoActionPerformed
        optionsPane.setSelectedIndex(2);
    }//GEN-LAST:event_administrarAvanceAlumnoActionPerformed

    private void agregarMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarMallaActionPerformed
        // TODO add your handling code here:
        optionsPane.setSelectedIndex(3);
    }//GEN-LAST:event_agregarMallaActionPerformed

    private void editarMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarMallaActionPerformed
        // TODO add your handling code here:
        optionsPane.setSelectedIndex(4);
    }//GEN-LAST:event_editarMallaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        optionsPane.setSelectedIndex(5);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AvanceCurricularSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvanceCurricularSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvanceCurricularSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvanceCurricularSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AvanceCurricularSwing().setVisible(true);
            }
        });
    }
    
    public JMenuItem GetCsvCargarButton() {
        return csvMenuItemCargar;
    }
    
    public JMenuItem GetCsvExpotarButton() {
        return csvMenuItemExportar;
    }

    
    
    
    public JButton getVistaAlumnoBtn()
    {
        return vistaGeneralAlumnos;
    }
    
    public AgregarAlumnoP getAgregarAlumnoP()
    {
        return(AgregarAlumnoP) this.optionsPane.getComponent(1);
    }
    
    public AdministrarAvanceP getAdministrarAvanceP(){
        return (AdministrarAvanceP) this.optionsPane.getComponent(2);
    }
    public AgregarMallaP getAgregarMallaP()
    {
        return (AgregarMallaP) this.optionsPane.getComponent(3);
    }
    
    public EditarMallasP getEditarMallasP()
    {
        return (EditarMallasP) this.optionsPane.getComponent(4);
    }
    
    public VistaMallasP getVistaMallasP()
    {
        return (VistaMallasP) this.optionsPane.getComponent(5);
    }
    
    
    public void updateModel(Object[][] content)
    {
        VistaAlumnosP tableFrame = (VistaAlumnosP)this.optionsPane.getComponent(0);
        tableFrame.resetRows();
        for (Object[] row: content)
        {
            tableFrame.addRow(row);
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelButtons;
    private javax.swing.JButton administrarAvanceAlumno;
    private javax.swing.JButton agregarAlumnos;
    private javax.swing.JButton agregarMalla;
    private javax.swing.JMenu archivoMenuButton;
    private javax.swing.JMenuItem csvMenuItemCargar;
    private javax.swing.JMenuItem csvMenuItemExportar;
    private javax.swing.JButton editarMalla;
    private javax.swing.JButton jButton6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel label;
    private javax.swing.JTabbedPane optionsPane;
    private javax.swing.JButton vistaGeneralAlumnos;
    // End of variables declaration//GEN-END:variables

    

    //Getters:
    

}
