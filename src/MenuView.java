import GUI.Parameter;
import MenuComponent.PlayerNames;

/**
 *
 * @author Truc Quyen
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuView() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        titleJLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        playervsplayerJButton = new javax.swing.JButton();
        playervspcJButton = new javax.swing.JButton();
        optionsJButton = new javax.swing.JButton();
        guideJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        titleJLabel.setFont(new java.awt.Font("Snap ITC", 1, 50)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(255, 51, 102));
        titleJLabel.setText("REVERSI");

        jLabel2.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_person_40px.png")); // NOI18N

        playervsplayerJButton.setBackground(new java.awt.Color(255, 153, 153));
        playervsplayerJButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        playervsplayerJButton.setForeground(new java.awt.Color(0, 0, 0));
        playervsplayerJButton.setText("Player vs Player");
        playervsplayerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playervsplayerJButtonActionPerformed(evt);
            }
        });

        playervspcJButton.setBackground(new java.awt.Color(255, 153, 153));
        playervspcJButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        playervspcJButton.setForeground(new java.awt.Color(0, 0, 0));
        playervspcJButton.setText("Player vs PC");

        optionsJButton.setBackground(new java.awt.Color(255, 153, 153));
        optionsJButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        optionsJButton.setForeground(new java.awt.Color(0, 0, 0));
        optionsJButton.setText("Options");
        optionsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsJButtonActionPerformed(evt);
            }
        });

        guideJButton.setBackground(new java.awt.Color(255, 153, 153));
        guideJButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guideJButton.setForeground(new java.awt.Color(0, 0, 0));
        guideJButton.setText("How to play?");
        guideJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guideJButtonActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_person_40px.png")); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_person_40px.png")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(Parameter.path+ "\\icons8_person_40px.png")); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_services_40px_2.png")); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_support_40px_9.png")); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_question_mark_40px.png")); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_question_mark_40px.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(guideJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(optionsJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playervspcJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playervsplayerJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(112, Short.MAX_VALUE)
                        .addComponent(titleJLabel)))
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(titleJLabel)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(playervsplayerJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(playervspcJButton)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(optionsJButton)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guideJButton)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playervsplayerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playervsplayerJButtonActionPerformed
        // TODO add your handling code here:
        PlayerNames playerNames = new PlayerNames();
    }//GEN-LAST:event_playervsplayerJButtonActionPerformed

    private void optionsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optionsJButtonActionPerformed

    private void guideJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guideJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guideJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guideJButton;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton optionsJButton;
    private javax.swing.JButton playervspcJButton;
    private javax.swing.JButton playervsplayerJButton;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
