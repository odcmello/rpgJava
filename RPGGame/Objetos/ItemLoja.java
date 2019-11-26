/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

/**
 * Esse objeto contem informações referentes aos itens que são vendidos
 * na loja do jogo.
 *
 * @author Otávio
 */
public class ItemLoja {

    Item item;
    double precoCompra;

    /**
     * Construtor padrão da classe Equipamento
     * 
     * @param item Item do jogo que está sendo vendido na loja.
     * @param precoCompra Preço que é exigido que o jogador pague para comprar o item.
     */
    public ItemLoja(Item item, double precoCompra) {
        this.item = item;
        this.precoCompra = precoCompra;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

}
