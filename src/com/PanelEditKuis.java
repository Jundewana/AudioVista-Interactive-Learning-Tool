/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author MUHAMMAD NAZLAN R
 */
public class PanelEditKuis extends javax.swing.JPanel {
    /**
     * Creates new form PanelTambahKuis
     */
    public PanelEditKuis() {
        initComponents();
//        init();
    }
    
    public void setPertanyaan(String pertanyaan) {
        txtAreaPertanyaan.setText(pertanyaan);
    }

    public void setJawabanA(String jawabanA) {
        txtJawabanA.setText(jawabanA);
    }

    public void setJawabanB(String jawabanB) {
        txtJawabanB.setText(jawabanB);
    }

    public void setValid(String valid) {
        comboBoxValid.setSelectedItem(valid);
    }

    public String getPertanyaan() {
        return txtAreaPertanyaan.getText();
    }

    public String getJawabanA() {
        return txtJawabanA.getText();
    }

    public String getJawabanB() {
        return txtJawabanB.getText();
    }

    public String getValid() {
        return (String) comboBoxValid.getSelectedItem();
    }
    
//    private void init(){
//        jLabel1.putClientProperty(FlatClientProperties.STYLE, ""
//        + "font : $h3.font");
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaPertanyaan = new javax.swing.JTextArea();
        labelPertanyaan = new javax.swing.JLabel();
        txtJawabanA = new javax.swing.JTextField();
        labelJawabanA = new javax.swing.JLabel();
        labelJawabanB = new javax.swing.JLabel();
        txtJawabanB = new javax.swing.JTextField();
        comboBoxValid = new javax.swing.JComboBox<>();
        labelValid = new javax.swing.JLabel();

        txtAreaPertanyaan.setColumns(20);
        txtAreaPertanyaan.setRows(5);
        txtAreaPertanyaan.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAreaPertanyaan);

        labelPertanyaan.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelPertanyaan.setText("Pertanyaan");

        txtJawabanA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJawabanAActionPerformed(evt);
            }
        });

        labelJawabanA.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelJawabanA.setText("Jawaban A");

        labelJawabanB.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelJawabanB.setText("Jawaban B");

        txtJawabanB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJawabanBActionPerformed(evt);
            }
        });

        comboBoxValid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RIGHT", "LEFT" }));

        labelValid.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelValid.setText("Valid");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelJawabanB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPertanyaan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJawabanA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxValid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtJawabanB)
                    .addComponent(txtJawabanA)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPertanyaan)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtJawabanA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJawabanA))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelJawabanB)
                    .addComponent(txtJawabanB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxValid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValid))
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtJawabanAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJawabanAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJawabanAActionPerformed

    private void txtJawabanBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJawabanBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJawabanBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxValid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelJawabanA;
    private javax.swing.JLabel labelJawabanB;
    private javax.swing.JLabel labelPertanyaan;
    private javax.swing.JLabel labelValid;
    private javax.swing.JTextArea txtAreaPertanyaan;
    private javax.swing.JTextField txtJawabanA;
    private javax.swing.JTextField txtJawabanB;
    // End of variables declaration//GEN-END:variables
}