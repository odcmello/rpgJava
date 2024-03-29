/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import RPGGame.gameObjects;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Tela visual para espera do usuário (Tela principal, enquanto o usuário está na cidade)
 *
 * @author Otávio
 */
public class waitingScreen extends javax.swing.JPanel {

    /**
     * Creates new form waitingScreen
     */
    public waitingScreen() {
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

        treinamento = new javax.swing.JButton();
        explorar = new javax.swing.JButton();
        inventario = new javax.swing.JButton();
        nome = new javax.swing.JLabel();
        xp = new javax.swing.JProgressBar();
        Nivel = new javax.swing.JLabel();
        HPBAR = new javax.swing.JProgressBar();
        HP = new javax.swing.JLabel();
        egbar = new javax.swing.JProgressBar();
        EG = new javax.swing.JLabel();
        lojaButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        treinamento.setBackground(new java.awt.Color(0, 0, 0));
        treinamento.setForeground(new java.awt.Color(255, 255, 255));
        treinamento.setText("Treinar");
        treinamento.setFocusPainted(false);
        treinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treinamentoActionPerformed(evt);
            }
        });

        explorar.setBackground(new java.awt.Color(0, 0, 0));
        explorar.setForeground(new java.awt.Color(255, 255, 255));
        explorar.setText("Explorar");
        explorar.setFocusPainted(false);
        explorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explorarActionPerformed(evt);
            }
        });

        inventario.setBackground(new java.awt.Color(0, 0, 0));
        inventario.setForeground(new java.awt.Color(255, 255, 255));
        inventario.setText("Inventário");
        inventario.setFocusPainted(false);
        inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioActionPerformed(evt);
            }
        });

        nome.setForeground(new java.awt.Color(255, 255, 255));
        nome.setText(gameObjects.jogador.getNome());

        xp.setMinimum(0);
        xp.setMaximum(gameObjects.jogador.getNivel() * 500);
        xp.setValue(gameObjects.jogador.getExperiencia());

        Nivel.setForeground(new java.awt.Color(255, 255, 255));
        Nivel.setText("Nível " + Integer.toString(gameObjects.jogador.getNivel()));

        HPBAR.setMinimum(0);
        HPBAR.setMaximum(gameObjects.jogador.getVidaMaxima());
        HPBAR.setValue(gameObjects.jogador.getVida());

        HP.setForeground(new java.awt.Color(255, 255, 255));
        HP.setText("HP");

        egbar.setMinimum(0);
        egbar.setMaximum(gameObjects.jogador.getEnergiaMaxima());
        egbar.setValue(gameObjects.jogador.getEnergia());

        EG.setForeground(new java.awt.Color(255, 255, 255));
        EG.setText("EG");

        lojaButton.setBackground(new java.awt.Color(0, 0, 0));
        lojaButton.setForeground(new java.awt.Color(255, 255, 255));
        lojaButton.setText("Loja");
        lojaButton.setFocusPainted(false);
        lojaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lojaButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cityMain.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HP, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(xp, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(HPBAR, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(EG, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(egbar, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(explorar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(treinamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lojaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(118, 118, 118))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(treinamento)
                    .addComponent(inventario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(explorar)
                    .addComponent(lojaButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nome)
                        .addComponent(Nivel))
                    .addComponent(xp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HPBAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HP)
                    .addComponent(egbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EG))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void treinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treinamentoActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        battleScreen battleScreen = new battleScreen(frame);
        battleScreen.startBattle(frame);
        frame.setContentPane(battleScreen);
        frame.validate();
    }//GEN-LAST:event_treinamentoActionPerformed

    private void explorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explorarActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        dungeonStartScreen dungeonStartScreen = new dungeonStartScreen();
        frame.setContentPane(dungeonStartScreen);
        frame.validate();
    }//GEN-LAST:event_explorarActionPerformed

    private void inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        inventarioScreen inventarioScreen = new inventarioScreen();
        frame.setContentPane(inventarioScreen);
        frame.validate();
    }//GEN-LAST:event_inventarioActionPerformed

    private void lojaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lojaButtonActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        lojaScreen lojaScreen = new lojaScreen();
        frame.setContentPane(lojaScreen);
        frame.validate();
    }//GEN-LAST:event_lojaButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EG;
    private javax.swing.JLabel HP;
    private javax.swing.JProgressBar HPBAR;
    private javax.swing.JLabel Nivel;
    private javax.swing.JProgressBar egbar;
    private javax.swing.JButton explorar;
    private javax.swing.JButton inventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lojaButton;
    private javax.swing.JLabel nome;
    private javax.swing.JButton treinamento;
    private javax.swing.JProgressBar xp;
    // End of variables declaration//GEN-END:variables
}
