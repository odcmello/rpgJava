/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RPGGame.Objetos;

/**
 * Esse objeto contem informações referentes de efeitos que habilidades podem
 * causar ao inimigo
 *
 * @author Otávio
 */
public class Efeito {
    String nomeEfeito;

    /**
     * Construtor padrão da classe Efeito
     *
     * @param nomeEfeito Nome do Efeito que o inimigo sofrerá.
     */
    public Efeito(String nomeEfeito) {
        this.nomeEfeito = nomeEfeito;
    }

    public String getNomeEfeito() {
        return nomeEfeito;
    }
 
    
}
