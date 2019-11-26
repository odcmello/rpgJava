/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RPGGame.Objetos;

/**
 * Esse objeto contem informações referentes a tipos de buffs que podem ser
 * aplicados a um equipamento.
 *
 * @author Otávio
 */
public class TipoBuff {
    String tipo;

    /**
     * Construtor padrão da classe TipoBuff
     *
     * @param tipo Nome do tipo de buff.
     */
    public TipoBuff(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
