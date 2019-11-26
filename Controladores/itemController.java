/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import RPGGame.Objetos.Buff;
import RPGGame.Objetos.Item;
import RPGGame.Objetos.ItemLoja;
import RPGGame.gameObjects;

/**
 * Classe para controle de ações relacionadas a itens do jogo
 *
 * @author Otávio
 */
public class itemController {

    /**
     * Adiciona o item ao inventário do jogador e remove o dinheiro que foi gasto para comprá-lo
     *
     * @param i Item comprado pelo jogador na loja
     */
    public static void comprarItem(ItemLoja i) {
        gameObjects.jogador.setDinheiro(gameObjects.jogador.getDinheiro() - i.getPrecoCompra());
        gameObjects.jogador.addItensJogador(i.getItem());
    }

    /**
     * Vende o item definido pelo jogador, removendo ele do seu inventário e adicionando o dinheiro
     * pela venda realizada
     *
     * @param i Item do inventário do jogador que foi vendido
     */
    public static void venderItem(Item i) {
        gameObjects.jogador.setDinheiro(gameObjects.jogador.getDinheiro() + i.getPrecoVenda());
        gameObjects.jogador.removeItensJogador(i);
    }

    /**
     * Equipa item dentro do inventário do jogador e adiciona os respectivos buffs relacionados
     * a esse item, removendo buffs de itens anteriores, caso estivessem equipados.
     *
     * @param i Item do inventário do jogador que será equipado
     */
    public static void equiparItem(Item i) {
        switch (i.getTipo()) {
            case "Armadura":
                removeAllBuffs(gameObjects.jogador.getEquipamento().getCorpo());
                gameObjects.jogador.getEquipamento().setCorpo(i);
                addAllBuffs(gameObjects.jogador.getEquipamento().getCorpo());
                break;
            case "Capacete":
                removeAllBuffs(gameObjects.jogador.getEquipamento().getCabeca());
                gameObjects.jogador.getEquipamento().setCabeca(i);
                addAllBuffs(gameObjects.jogador.getEquipamento().getCabeca());
                break;
            case "Sapatos":
                removeAllBuffs(gameObjects.jogador.getEquipamento().getPes());
                gameObjects.jogador.getEquipamento().setPes(i);
                addAllBuffs(gameObjects.jogador.getEquipamento().getPes());
                break;
            case "Mãos":
                removeAllBuffs(gameObjects.jogador.getEquipamento().getMaos());
                gameObjects.jogador.getEquipamento().setMaos(i);
                addAllBuffs(gameObjects.jogador.getEquipamento().getMaos());
                break;
        }
    }

    /**
     * Remove os buffs do item que estava antigamente equipado ao jogador
     *
     * @param i Item do inventário do jogador que está atualmente equipado
     */
    public static void removeAllBuffs(Item i) {
        if (i != null) {
            for (Buff buff : i.getBuff()) {
                buff.removerBuff();
            }
        }
    }

    /**
     * Adiciona os buffs do item que será equipado ao jogador
     *
     * @param i Item do inventário do jogador que será equipado
     */
    public static void addAllBuffs(Item i) {
        if (i != null) {
            for (Buff buff : i.getBuff()) {
                buff.aplicarBuff();
            }
        }
    }

}
