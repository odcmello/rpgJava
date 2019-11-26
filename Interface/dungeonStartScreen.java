/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controladores.battleController;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Tela visual para início de uma dungeon (possibilidade de entrar, ou retornar para cidade)
 *
 * @author Otávio
 */
public class dungeonStartScreen extends javax.swing.JPanel {

    /**
     * Creates new form dungeonStartScreen
     */
    public dungeonStartScreen() {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();
        entrarDungeon = new javax.swing.JButton();
        sairDungeon = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        descricao.setBackground(new java.awt.Color(0, 0, 0));
        descricao.setColumns(20);
        descricao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        descricao.setForeground(new java.awt.Color(255, 255, 255));
        descricao.setLineWrap(true);
        descricao.setRows(2);
        descricao.setText("\"Você encontra uma antiga masmorra que parece inabitada há muitos anos. Parece que pode haver algo valioso dentro, mas também pode ser arriscado. Você deseja entrar?\"");
        jScrollPane2.setViewportView(descricao);

        entrarDungeon.setBackground(new java.awt.Color(0, 0, 0));
        entrarDungeon.setForeground(new java.awt.Color(255, 255, 255));
        entrarDungeon.setText("Explorar");
        entrarDungeon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarDungeonActionPerformed(evt);
            }
        });

        sairDungeon.setBackground(new java.awt.Color(0, 0, 0));
        sairDungeon.setForeground(new java.awt.Color(255, 255, 255));
        sairDungeon.setText("Retornar");
        sairDungeon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairDungeonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sairDungeon, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entrarDungeon, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entrarDungeon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sairDungeon)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sairDungeonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairDungeonActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        waitingScreen waitingScreen = new waitingScreen();
        frame.setContentPane(waitingScreen);
        frame.validate();
    }//GEN-LAST:event_sairDungeonActionPerformed

    private void entrarDungeonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarDungeonActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        battleController.defineNiveis();
        dungeonScreen dungeonScreen = new dungeonScreen();
        frame.setContentPane(dungeonScreen);
        frame.validate();
    }//GEN-LAST:event_entrarDungeonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descricao;
    private javax.swing.JButton entrarDungeon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton sairDungeon;
    // End of variables declaration//GEN-END:variables
}