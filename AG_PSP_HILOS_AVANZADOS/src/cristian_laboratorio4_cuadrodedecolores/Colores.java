package cristian_laboratorio4_cuadrodedecolores;

import javax.swing.*;


public class Colores extends JFrame {

     /** Creates new form Colores */
     public Colores() {
          initComponents();
          Paleta mezclas = new Paleta();
          Pintor p1 = new Pintor(jButton1, mezclas, 0);
          Pintor p2 = new Pintor(jButton2, mezclas, 1);
          Pintor p3 = new Pintor(jButton3, mezclas, 2);
          Pintor p4 = new Pintor(jButton4, mezclas, 3);
          p1.start();
          p2.start();
          p3.start();
          p4.start();

     }

@SuppressWarnings ("unchecked")
     private void initComponents() {
          jButton1 = new javax.swing.JButton();
          jButton2 = new javax.swing.JButton();
          jButton3 = new javax.swing.JButton();
          jButton4 = new javax.swing.JButton();
          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("Colores");
          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                          .addGap(52, 52, 52)
                          .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
                                  javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addGap(61, 61, 61)
                          .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
                                  javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                  64, Short.MAX_VALUE)
                          .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
                                  javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addGap(55, 55, 55)
                          .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
                                  javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addGap(60, 60, 60))
          );
          layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                          .addGap(68, 68, 68)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                          118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                          118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                          118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                  .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                          118, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addContainerGap(114, Short.MAX_VALUE))
          );
          setSize(new java.awt.Dimension(816, 338));
          setLocationRelativeTo(null);
          pack();
     }// </editorfold>

     /**
      * @param args the command line arguments
      */
     public static void main(String args[]) {
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new Colores().setVisible(true);
               }
          });
     }
// Variables declaration donot modify
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton4;
// End of variables declaration
}






