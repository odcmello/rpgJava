/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

/**
 * Interface utilizada pelo padrão Visitor
 *
 * @author Otávio
 */
public interface Visitor {
    int atacar(Jogador jogador);
    int atacar(Monstro monstro);
}
