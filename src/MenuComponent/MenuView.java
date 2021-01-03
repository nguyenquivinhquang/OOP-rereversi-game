package MenuComponent;

import java.awt.*;

import GUI.*;

/**
 * @author Truc Quyen
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public static MenuView instance = null;
    private MenuView() {
        initComponents();
        setTitle("Reversi");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Parameter.logo));
        setVisible(true);
    }
    public int playerNamesClose = 0;

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
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        titleJLabel.setFont(new java.awt.Font("Snap ITC", 1, 50)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(255, 51, 102));
        titleJLabel.setText("REVERSI");

        jLabel2.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_computer_40px_1.png")); // NOI18N

        playervsplayerJButton.setBackground(new java.awt.Color(255, 153, 153));
        playervsplayerJButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        playervsplayerJButton.setForeground(new java.awt.Color(0, 0, 0));
        playervsplayerJButton.setText("Player vs Player");
        playervsplayerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playervsplayerJButtonActionPerformed(evt);
                System.out.println(1);
            }
        });

        playervspcJButton.setBackground(new java.awt.Color(255, 153, 153));
        playervspcJButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        playervspcJButton.setForeground(new java.awt.Color(0, 0, 0));
        playervspcJButton.setText("Player vs PC");
        playervspcJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playervspcJButtonActionPerformed(evt);
            }
        });


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

        jLabel5.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_person_40px.png")); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_services_40px_2.png")); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_support_40px_9.png")); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_question_mark_40px.png")); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(Parameter.path + "\\icons8_question_mark_40px.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(guideJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel8))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(optionsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel7))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(playervspcJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel2))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(playervsplayerJButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(titleJLabel)
                                                .addGap(6, 6, 6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(243, 243, 243)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(titleJLabel)
                                                .addGap(80, 80, 80)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(playervsplayerJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(playervspcJButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(64, 64, 64)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(optionsJButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(guideJButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(121, 121, 121))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playervsplayerJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        PlayerNames t = new PlayerNames();
        t.setVisible(true);


    }//GEN-LAST:event_playervsplayerJButtonActionPerformed


    public void actionGui() {
        if (playerNamesClose == 1) {
            Gui.newGamePlayerVsPlayer();
            setVisible(false);

        }
    }


    private void optionsJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Options options = new Options();

    }//GEN-LAST:event_optionsJButtonActionPerformed

    private void playervspcJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Parameter.player2 = "BOT";
        Parameter.player1 = "Player";
        this.setVisible(false);
        Gui.newGamePlayerVsBot();

    }//GEN-LAST:event_guideJButtonActionPerformed

    private void guideJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new Rules().setVisible(true);
    }//GEN-LAST:event_guideJButtonActionPerformed


    public static void main(String args[]) {
        MenuView.getInstance();
    }
    public static void getInstance() {
        if (instance == null) {
            instance = new MenuView();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guideJButton;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
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
