package AUX_componentes_MacarenaCuenca;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author macarena
 * 
 * Este ejemplo usa la vista Design para colocar los componentes, y el control de
 * eventos tambi�n se hace desde la vista Design (bot�n derecho - Events)
 *
 */

public class EjemploJColorChooser extends javax.swing.JFrame {

    private Color inicial; //color por defecto

    public EjemploJColorChooser() {
        initComponents();
        setFrame();
        inicial = this.jPanel1.getBackground();
    }

    private void setFrame(){
        this.setPreferredSize(new Dimension(500,500));
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EjemploJColorChooser");
        getContentPane().setLayout(new java.awt.BorderLayout(0, 10));

        jButton1.setText("Selecciona un color");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 87, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Color c = JColorChooser.showDialog(this, "Selecciona un color", inicial);
        if (c != null) { //se ha elegido un color
            this.jPanel1.setBackground(c);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EjemploJColorChooser().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
