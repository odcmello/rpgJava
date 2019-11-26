/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controladores.itemController;
import Interface.ExternalResources.ButtonColumn;
import RPGGame.Objetos.Buff;
import RPGGame.Objetos.Item;
import RPGGame.gameObjects;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Tela visual para a exibição dos itens que o jogador possuí em seu inventário
 *
 * @author Otávio
 */
public class inventarioScreen extends javax.swing.JPanel {

    /**
     * Creates new form inventarioScreen
     */
    public inventarioScreen() {
        Action inventarioItens = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                int modelRow = Integer.valueOf(e.getActionCommand());
                if (!itemInventario.getModel().getValueAt(modelRow, 2).toString().equalsIgnoreCase("Geral")) {
                    itemController.equiparItem(gameObjects.jogador.getItensJogador().get(modelRow));
                    JOptionPane.showMessageDialog(null, "Você equipou o item com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Você usou uma poção");

                    if (itemInventario.getModel().getValueAt(modelRow, 0).toString().equalsIgnoreCase("Poção de Vida")) {
                        gameObjects.jogador.recuperarVida();
                    } else {
                        gameObjects.jogador.recuperarEnergia();
                    }

                    ((DefaultTableModel) itemInventario.getModel()).removeRow(modelRow);
                }
            }
        };
        initComponents();
        DefaultTableModel tableModel = (DefaultTableModel) itemInventario.getModel();
        Iterator<Item> iterator = gameObjects.jogador.iterator();
        while (iterator.hasNext()) {
            Item i = iterator.next();
            String efeito = "";
            if (i.getBuff() != null) {
                for (Buff b : i.getBuff()) {
                    efeito = "+" + b.getBuff() + " " + b.getTipoBuff().getTipo() + " ";
                }
            }
            tableModel.addRow(new Object[]{i.getNomeItem(), i.getDescricaoItem(), i.getTipo(), i.getPrecoVenda(), efeito, "Usar"});
        }
        ButtonColumn buttonColumn = new ButtonColumn(itemInventario, inventarioItens, 5);
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
        itemInventario = new javax.swing.JTable();
        voltarCidade = new javax.swing.JButton();
        minhaFortuna = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        itemInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Item", "Descrição", "Tipo", "Preço de Venda", "Efeito", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        itemInventario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(itemInventario);

        voltarCidade.setBackground(new java.awt.Color(0, 0, 0));
        voltarCidade.setForeground(new java.awt.Color(255, 255, 255));
        voltarCidade.setText("Voltar para Cidade");
        voltarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarCidadeActionPerformed(evt);
            }
        });

        minhaFortuna.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        minhaFortuna.setForeground(new java.awt.Color(255, 255, 255));
        minhaFortuna.setText("Você possuí " + gameObjects.jogador.getDinheiro() + " moedas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(minhaFortuna, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltarCidade))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minhaFortuna)
                    .addComponent(voltarCidade))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void voltarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarCidadeActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        waitingScreen waiting = new waitingScreen();
        frame.setContentPane(waiting);
        frame.validate();
    }//GEN-LAST:event_voltarCidadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable itemInventario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minhaFortuna;
    private javax.swing.JButton voltarCidade;
    // End of variables declaration//GEN-END:variables
}