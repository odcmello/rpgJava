/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

/**
 * Classe para a implementação do padrão State. Determina quando monstro está morto.
 *
 * @author Otávio
 */
public class EstadoMorto implements State {

    @Override
    public void estadoMonstro() {
        System.out.println("O monstro foi derrotado!");
    }
    
}
