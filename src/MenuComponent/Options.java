/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuComponent;

import GUI.Parameter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author Truc Quyen
 */
public class Options extends javax.swing.JFrame {


    public Options() {
        initComponents();
//        Image im = null;
//        try {
//            im = ImageIO.read(getClass().getResource(Parameter.logo));
//        } catch (IOException ex) {
//
//        }
//        setIconImage(im);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new JProgressBar();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        brownJButton = new JButton();
        grayJButton = new JButton();
        greenJButton = new JButton();
        jLabel4 = new JLabel();
        yellowJButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(Parameter.path + "\\brownBoard.png").
                getImage().getScaledInstance(530, 530, Image.SCALE_SMOOTH));

        jPanel1.setBackground(new Color(255, 255, 153));

//        jLabel2.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\brownBoard.png")); // NOI18N
        jLabel2.setIcon(new ImageIcon(new ImageIcon(Parameter.brownBoard).
                getImage().getScaledInstance(530, 530, Image.SCALE_SMOOTH)));

        jLabel1.setIcon(new ImageIcon(new ImageIcon(Parameter.grayBoard).
                getImage().getScaledInstance(530, 530, Image.SCALE_SMOOTH))); // NOI18N

        jLabel3.setIcon(new ImageIcon(new ImageIcon(Parameter.greenBoard).
                getImage().getScaledInstance(530, 530, Image.SCALE_SMOOTH)));
        brownJButton.setText("Brown");
        brownJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                brownJButtonActionPerformed(evt);
            }
        });

        grayJButton.setText("Gray");
        grayJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                grayJButtonActionPerformed(evt);
            }
        });

        greenJButton.setText("Green");
        greenJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                greenJButtonActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new ImageIcon(new ImageIcon(Parameter.board).
                getImage().getScaledInstance(530, 530, Image.SCALE_SMOOTH))); // NOI18N

        yellowJButton.setText("Yellow");
        yellowJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                yellowJButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(brownJButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(grayJButton)
                                .addGap(93, 93, 93))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                .addGap(58, 58, 58))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(greenJButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(yellowJButton)
                                                .addGap(90, 90, 90))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(brownJButton))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(grayJButton)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(yellowJButton))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(greenJButton)))
                                .addContainerGap(200, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brownJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brownJButtonActionPerformed
        Parameter.board = Parameter.brownBoard;

    }//GEN-LAST:event_brownJButtonActionPerformed

    private void grayJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayJButtonActionPerformed
        Parameter.board = Parameter.grayBoard;
    }//GEN-LAST:event_grayJButtonActionPerformed

    private void greenJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenJButtonActionPerformed
        Parameter.board = Parameter.greenBoard;
    }//GEN-LAST:event_greenJButtonActionPerformed

    private void yellowJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowJButtonActionPerformed
        Parameter.board = Parameter.defaultBoard;
    }//GEN-LAST:event_yellowJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Options().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brownJButton;
    private javax.swing.JButton grayJButton;
    private javax.swing.JButton greenJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton yellowJButton;
    // End of variables declaration//GEN-END:variables
}