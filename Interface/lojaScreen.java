/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controladores.itemController;
import Interface.ExternalResources.ButtonColumn;
import RPGGame.Objetos.Buff;
import RPGGame.Objetos.ItemLoja;
import RPGGame.gameObjects;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Tela visual para exibição da loja que disponibiliza diferentes itens de compra ao jogador
 *
 * @author Otávio
 */
public class lojaScreen extends javax.swing.JPanel {

    /**
     * Creates new form lojaScreen
     */
    public lojaScreen() {
        Action comprarItem = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                int modelRow = Integer.valueOf(e.getActionCommand());
                if (gameObjects.jogador.getDinheiro() >= Double.valueOf(itensVendiveis.getModel().getValueAt(modelRow, 3).toString())) {
                    itemController.comprarItem(gameObjects.itensCompráveis.get(modelRow));
                    minhaFortuna.setText("Você possuí " + gameObjects.jogador.getDinheiro() + " moedas");
                    JOptionPane.showMessageDialog(null, "Você comprou o item com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Você não tem dinheiro para comprar esse item!");
                }
            }
        };
        initComponents();
        DefaultTableModel tableModel = (DefaultTableModel) itensVendiveis.getModel();
        for (ItemLoja i : gameObjects.itensCompráveis) {
            String efeito = "";
            if (i.getItem().getBuff() != null) {
                for (Buff b : i.getItem().getBuff()) {
                    efeito = "+" + b.getBuff() + " " + b.getTipoBuff().getTipo() + " ";
                }
            }
            tableModel.addRow(new Object[]{i.getItem().getNomeItem(), i.getItem().getDescricaoItem(), i.getItem().getTipo(), i.getPrecoCompra(), efeito, "Comprar"});
        }
        ButtonColumn buttonColumn = new ButtonColumn(itensVendiveis, comprarItem, 5);
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
        itensVendiveis = new javax.swing.JTable();
        minhaFortuna = new javax.swing.JLabel();
        voltarCidade = new javax.swing.JButton();
        venderItens = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 0, 0));

        itensVendiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Item", "Descrição", "Tipo", "Preço do Item", "Efeito", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        itensVendiveis.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(itensVendiveis);

        minhaFortuna.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        minhaFortuna.setForeground(new java.awt.Color(255, 255, 255));
        minhaFortuna.setText("Você possuí " + gameObjects.jogador.getDinheiro() + " moedas");

        voltarCidade.setBackground(new java.awt.Color(0, 0, 0));
        voltarCidade.setForeground(new java.awt.Color(255, 255, 255));
        voltarCidade.setText("Voltar para Cidade");
        voltarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarCidadeActionPerformed(evt);
            }
        });

        venderItens.setBackground(new java.awt.Color(0, 0, 0));
        venderItens.setForeground(new java.awt.Color(255, 255, 255));
        venderItens.setText("Vender");
        venderItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderItensActionPerformed(evt);
            }
        });

        descricao.setBackground(new java.awt.Color(0, 0, 0));
        descricao.setColumns(20);
        descricao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        descricao.setForeground(new java.awt.Color(255, 255, 255));
        descricao.setLineWrap(true);
        descricao.setRows(2);
        descricao.setText("\"Você entra em uma loja antiga da cidade e é recebido por um homem que lhe oferece diferentes itens para batalhas.\"");
        jScrollPane2.setViewportView(descricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(minhaFortuna, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(venderItens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(voltarCidade)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minhaFortuna)
                    .addComponent(voltarCidade)
                    .addComponent(venderItens))
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void voltarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarCidadeActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        waitingScreen waiting = new waitingScreen();
        frame.setContentPane(waiting);
        frame.validate();
    }//GEN-LAST:event_voltarCidadeActionPerformed

    private void venderItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderItensActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        vendaScreen vendaScreen = new vendaScreen();
        frame.setContentPane(vendaScreen);
        frame.validate();
    }//GEN-LAST:event_venderItensActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descricao;
    private javax.swing.JTable itensVendiveis;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel minhaFortuna;
    private javax.swing.JButton venderItens;
    private javax.swing.JButton voltarCidade;
    // End of variables declaration//GEN-END:variables
}
