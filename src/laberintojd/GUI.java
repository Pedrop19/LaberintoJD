/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laberintojd;

/**
 * Interfaz Grafica
 * @author manue
 */
public class GUI extends javax.swing.JFrame {

    private int contador = 0;
    private static Mapa m;
    private static Personaje harry;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pantalla = new javax.swing.JTextArea();
        avanzar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pantalla.setColumns(20);
        pantalla.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        pantalla.setRows(5);
        jScrollPane1.setViewportView(pantalla);

        avanzar.setText("Avanzar");
        avanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanzarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(avanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(avanzar)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void avanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzarActionPerformed
        try{
        harry.mover(m);
        contador++;
        pantalla.append("Turno: " + contador + " Salud: " + harry.getSalud() + "\n");

        pantalla.append(m.hayAdversidad() + "\n");

        if (contador % 9 == 0) {
            harry.setSalud(harry.getSalud() - 20);
        }
        pantalla.append(m.toString() + '\n');

        if (harry.getSalaActual() == m.getSalaFinal()) {
            pantalla.append("Harry ha ganado el juego :)" + "\n");
        }

        if (harry.getSalud() <= 0)
            pantalla.append("Game Over: Harry se murio");
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_avanzarActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
                m = new Mapa(4, 4);
                // Paredes
                m.aniadirPared(0, 4);
                m.aniadirPared(3, 7);
                m.aniadirPared(5, 6);
                m.aniadirPared(5, 9);
                m.aniadirPared(8, 9);
                m.aniadirPared(8, 12);
                m.aniadirPared(10, 11);
                m.aniadirPared(10, 14);
                m.aniadirPared(11, 15);
                // Adversidades
                m.nuevaAdversidad(new Viento("Viento Norte", 2));
                m.nuevaAdversidad(new Viento("Viento Sur", 13));
                m.nuevaAdversidad(new Dementor(6));
                m.nuevaAdversidad(new Dementor(10));
                harry = new Personaje(m);
                pantalla.append("COMIENZA LA BATALLA\n");
                pantalla.append("Turno: 0 Salud: " + harry.getSalud() + "\n");
                pantalla.append(m.toString() + "\n");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avanzar;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea pantalla;
    // End of variables declaration//GEN-END:variables
}