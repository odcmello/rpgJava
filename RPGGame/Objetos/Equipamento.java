/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

/**
 * Esse objeto contem informações referentes ao equipamento que está atualmente
 * equipado ao jogador.
 *
 * @author Otávio
 */
public class Equipamento {
    Item cabeca, pes, corpo, maos;

    /**
     * Construtor padrão da classe Equipamento
     *
     * @param cabeca Item que está equipado na cabeça do jogador.
     * @param pes Item que está equipado aos pés do jogador.
     * @param corpo Item que está equipado ao corpo do jogador.
     * @param maos Item que está equipado nas mãos do jogador.
     */
    public Equipamento(Item cabeca, Item pes, Item corpo, Item maos) {
        this.cabeca = cabeca;
        this.pes = pes;
        this.corpo = corpo;
        this.maos = maos;
    }

    public Item getCabeca() {
        return cabeca;
    }

    public void setCabeca(Item cabeca) {
        this.cabeca = cabeca;
    }

    public Item getPes() {
        return pes;
    }

    public void setPes(Item pes) {
        this.pes = pes;
    }

    public Item getCorpo() {
        return corpo;
    }

    public void setCorpo(Item corpo) {
        this.corpo = corpo;
    }

    public Item getMaos() {
        return maos;
    }

    public void setMaos(Item maos) {
        this.maos = maos;
    }
    
    
}
