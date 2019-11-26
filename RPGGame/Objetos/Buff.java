/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

import RPGGame.gameObjects;

/**
 * Esse objeto contem informações referentes aos buffs que são aplicados
 * em equipamentos.
 *
 * @author Otávio
 */
public class Buff {

    int buff;
    TipoBuff tipoBuff;

    /**
     * Construtor padrão da classe buff
     *
     * @param buff Dado quantificado do buff que será aplicado ao jogador
     * @param tipoBuff Tipo de buff que será aplicado. Pode ser ataque, defesa,
     * mágica, vida, energia ou precisão
     */
    public Buff(int buff, TipoBuff tipoBuff) {
        this.buff = buff;
        this.tipoBuff = tipoBuff;
    }

    /**
     * Aplica o buff de um determinado item aos atributos do jogador
     */
    public void aplicarBuff() {
        switch (tipoBuff.getTipo()) {
            case "ATK":
                gameObjects.jogador.ataque += buff;
                break;
            case "DEF":
                gameObjects.jogador.defesa += buff;
                break;
            case "MAG":
                gameObjects.jogador.magia += buff;
                break;
            case "HP":
                gameObjects.jogador.vidaMaxima += buff;
                break;
            case "ENG":
                gameObjects.jogador.energiaMaxima += buff;
                break;
            case "ACC":
                gameObjects.jogador.precisao += buff;
                break;
        }
    }

    /**
     * Remove o buff de um determinado item aos atributos do jogador
     */
    public void removerBuff() {
        switch (tipoBuff.getTipo()) {
            case "ATK":
                gameObjects.jogador.ataque = gameObjects.jogador.ataque - (buff * gameObjects.jogador.nivel);
                break;
            case "DEF":
                gameObjects.jogador.defesa = gameObjects.jogador.defesa - (buff * gameObjects.jogador.nivel);
                break;
            case "MAG":
                gameObjects.jogador.magia = gameObjects.jogador.magia - (buff * gameObjects.jogador.nivel);
                break;
            case "HP":
                gameObjects.jogador.vidaMaxima = gameObjects.jogador.vidaMaxima - (buff * gameObjects.jogador.nivel);
                break;
            case "ENG":
                gameObjects.jogador.energiaMaxima = gameObjects.jogador.energiaMaxima - (buff * gameObjects.jogador.nivel);
                break;
            case "ACC":
                gameObjects.jogador.precisao = gameObjects.jogador.precisao - (buff * gameObjects.jogador.nivel);
                break;
        }
    }

    public int getBuff() {
        return buff;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public TipoBuff getTipoBuff() {
        return tipoBuff;
    }

    public void setTipoBuff(TipoBuff tipoBuff) {
        this.tipoBuff = tipoBuff;
    }

}
