/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controladores.battleController;
import RPGGame.Objetos.Habilidades;
import RPGGame.gameObjects;
import Interface.ExternalResources.ButtonColumn;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Tela que será exibida ao usuário quando selecionar a opção habilidades na tela de batalha
 *
 * @author Otávio
 */
public class habilidades extends javax.swing.JPanel {

    /**
     * Creates new form habilidades
     * @param framePai
     */
    public habilidades(JFrame framePai) {

        Action usarHabilidade = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                int modelRow = Integer.valueOf(e.getActionCommand());
                if(gameObjects.jogador.getEnergia() > Integer.valueOf(habilidadesTable.getModel().getValueAt(Integer.valueOf(e.getActionCommand()),3).toString()))
                    battleController.roundAtaqueHabilidade(modelRow, gameObjects.jogador, battleController.getMonstroBatalha());
                else
                    JOptionPane.showMessageDialog(null, "Você não tem energia para executar essa habilidade");
                framePai.dispose();
            }
        };
        
        initComponents();
        DefaultTableModel tableModel = (DefaultTableModel) habilidadesTable.getModel();
        for (Habilidades h : gameObjects.jogador.getClasse().getHabilidadesClasse()) {
            if (gameObjects.jogador.getNivel() >= h.getNivelMinimo()) {
                tableModel.addRow(new Object[]{h.getNomeHabilidade(), h.getDescricao(), h.getDano(), h.getGastoEnergia(), "Usar"});
            }
        }

        ButtonColumn buttonColumn = new ButtonColumn(habilidadesTable, usarHabilidade, 4);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        habilidadesTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 0));

        habilidadesTable.setBackground(new java.awt.Color(0, 0, 0));
        habilidadesTable.setForeground(new java.awt.Color(255, 255, 255));
        habilidadesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descrição", "Dano Base", "Energia Gasta", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        habilidadesTable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        habilidadesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(habilidadesTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable habilidadesTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
