/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gna;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class GNA extends javax.swing.JFrame {
    
    private final Distribuicoes distribuicoes;
    private ArrayList<Double> randomNumbers;

    /**
     * Creates new form GNA
     */
    public GNA() {
        initComponents();
        distribuicoes = new Distribuicoes();
        randomNumbers = new ArrayList<>();
    }
    
    private void saveRandomNumbersToFile(String filename) {
        try {
            PrintWriter out = new PrintWriter(filename + ".txt");
            for (double randomNumber : randomNumbers) {
                out.println(new Double(randomNumber).toString());
            }
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Deu ruim");
        }
    }
    
    private void generateUniformRandom(double a,double b, int num) {
        randomNumbers.clear();
        for (int i = 0; i<num; i++) {
            randomNumbers.add(distribuicoes.uniforme(a, b));
        }
    }
    
    private void generateTriangularRandom(double a,double b, double moda, int num) {
        randomNumbers.clear();
        for (int i = 0; i<num; i++) {
            randomNumbers.add(distribuicoes.triangular(a, b, moda));
        }
    }
    
    private void generateExponencialRandom(double a, int num) {
        randomNumbers.clear();
        for (int i = 0; i<num; i++) {
            randomNumbers.add(distribuicoes.exponencial(a));
        }
    }
    
    private void generateNormalRandom(double media, double variancia, int num) {
        randomNumbers.clear();
        for (int i = 0; i<num; i++) {
            randomNumbers.add(distribuicoes.normal(media, variancia));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Uniforme");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Triangular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exponencial");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Normal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("UNIFORME");
        Double a = new Double(JOptionPane.showInputDialog(this, "Informe o atributo a"));
        Double b = new Double(JOptionPane.showInputDialog(this, "Informe o atributo b"));
        Integer num = new Integer(JOptionPane.showInputDialog(this, "Informe a quantidade de números"));
        generateUniformRandom(a, b, num);
        saveRandomNumbersToFile("numeros");
        JOptionPane.showMessageDialog(null, "Arquivo numeros.txt criado na pasta do projeto!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("TRIANGULAR");
        Double a = new Double(JOptionPane.showInputDialog(this, "Informe o atributo a"));
        Double b = new Double(JOptionPane.showInputDialog(this, "Informe o atributo b"));
        Double moda = new Double(JOptionPane.showInputDialog(this, "Informe o atributo moda"));
        Integer num = new Integer(JOptionPane.showInputDialog(this, "Informe a quantidade de números"));
        generateTriangularRandom(a, b, moda, num);
        saveRandomNumbersToFile("numeros");
        JOptionPane.showMessageDialog(null, "Arquivo numeros.txt criado na pasta do projeto!");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println("EXPONENCIAL");
        Double a = new Double(JOptionPane.showInputDialog(this, "Informe o atributo a"));
        Integer num = new Integer(JOptionPane.showInputDialog(this, "Informe a quantidade de números"));
        generateExponencialRandom(a, num);
        saveRandomNumbersToFile("numeros");
        JOptionPane.showMessageDialog(null, "Arquivo numeros.txt criado na pasta do projeto!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.out.println("NORMAL");
        Double media = new Double(JOptionPane.showInputDialog(this, "Informe o atributo media"));
        Double variancia = new Double(JOptionPane.showInputDialog(this, "Informe o atributo variancia"));
        Integer num = new Integer(JOptionPane.showInputDialog(this, "Informe a quantidade de números"));
        generateNormalRandom(media, variancia, num);
        saveRandomNumbersToFile("numeros");
        JOptionPane.showMessageDialog(null, "Arquivo numeros.txt criado na pasta do projeto!");
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(GNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GNA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
