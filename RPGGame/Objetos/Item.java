/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

import java.util.ArrayList;

/**
 * Esse objeto contem informações referentes a todos os itens que estão
 * presentes no jogo
 *
 * @author Otávio
 */
public class Item {

    String nomeItem, descricaoItem, tipo;
    int nivelMinimo;
    boolean vendivel;
    double precoVenda;
    ArrayList<Buff> buff;

    /**
     * Construtor padrão da classe Item
     *
     * @param item ItemBuilder, constrói o item com os parâmetros que precisa.
     */
    public Item(ItemBuilder item) {
        this.nomeItem = item.nomeItem;
        this.descricaoItem = item.descricaoItem;
        this.nivelMinimo = item.nivelMinimo;
        this.vendivel = item.vendivel;
        this.tipo = item.tipo;
        this.precoVenda = item.precoVenda;
        this.buff = item.buff;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public int getNivelMinimo() {
        return nivelMinimo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public ArrayList<Buff> getBuff() {
        return buff;
    }

    public static class ItemBuilder {

        //Obrigatórios
        String nomeItem, descricaoItem, tipo;
        int nivelMinimo;
        boolean vendivel;

        //Não Obrigatórios
        double precoVenda;
        ArrayList<Buff> buff;

        /**
         * Construtor padrão da classe ItemBuilder
         *
         * @param nomeItem Nome do item.
         * @param descricaoItem Descrição breve do item.
         * @param vendivel Determina se um item pode ser vendido na loja.
         * @param nivelMinimo Nível mínimo para comprar/utilizar o item.
         * @param tipo Tipo de item, pode ser vestimenta ou geral.
         * @param precoVenda Preço que o jogador pode vender o item na loja,
         */
        public ItemBuilder(String nomeItem, String descricaoItem, String tipo, int nivelMinimo, boolean vendivel, double precoVenda) {
            this.nomeItem = nomeItem;
            this.descricaoItem = descricaoItem;
            this.tipo = tipo;
            this.nivelMinimo = nivelMinimo;
            this.vendivel = vendivel;
            this.precoVenda = precoVenda;
        }

        public ItemBuilder setBuff(ArrayList<Buff> buff) {
            this.buff = buff;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

}
