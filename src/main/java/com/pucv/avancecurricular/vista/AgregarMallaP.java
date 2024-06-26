/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pucv.avancecurricular.vista;

import javax.swing.JButton;


/**
 *
 * @author manu
 */
public class AgregarMallaP extends javax.swing.JPanel {

    /**
     * Creates new form AgregarMallaP
     */
    public AgregarMallaP() {
        initComponents();
    }
    
    public JButton getAgregarBtn()
    {
        return agregarMalla;
    }
    
    public JButton getQuitarBtn()
    {
        return quitarMalla;
    }
    
    public String getField()
    {
        return mallaField.getText();
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
        quitarMalla = new javax.swing.JButton();
        mallaField = new javax.swing.JTextField();
        agregarMalla = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("Nombre de la malla a crear");

        quitarMalla.setText("quitar malla");
        quitarMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarMallaActionPerformed(evt);
            }
        });

        mallaField.setText("nombre malla");
        mallaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mallaFieldActionPerformed(evt);
            }
        });

        agregarMalla.setText("agregar malla");
        agregarMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMallaActionPerformed(evt);
            }
        });

        jLabel2.setText("Para añadir asignaturas y quitarlas, ir a editar malla");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(mallaField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(agregarMalla)
                .addGap(18, 18, 18)
                .addComponent(quitarMalla)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mallaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitarMalla)
                    .addComponent(agregarMalla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void quitarMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarMallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quitarMallaActionPerformed

    private void mallaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mallaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mallaFieldActionPerformed

    private void agregarMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarMallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarMallaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarMalla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField mallaField;
    private javax.swing.JButton quitarMalla;
    // End of variables declaration//GEN-END:variables
}
