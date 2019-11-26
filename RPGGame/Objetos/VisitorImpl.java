/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

import java.util.Random;

/**
 * Implementação das classes do padrão Visitor.
 *
 * @author Otávio
 */
public class VisitorImpl implements Visitor {

    /**
     * Ataque causado pelo jogador.
     *
     * @param jogador Dados do jogador.
     * @return Retorna o dano que foi causado pelo ataque do jogador.
     */
    @Override
    public int atacar(Jogador jogador) {
        Random ran = new Random();
        return ran.nextInt(jogador.ataque * jogador.nivel) + 1;
    }

    /**
     * Ataque causado pelo monstro
     *
     * @param monstro Dados do monstro.
     * @return Retorna o dano que foi causado pelo ataque do monstro.
     */
    @Override
    public int atacar(Monstro monstro) {
        Random ran = new Random();
        return ran.nextInt(monstro.ataque * monstro.nivel) + 1;
    }
}
