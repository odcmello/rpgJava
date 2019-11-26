/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame;

import Interface.startGame;
import Interface.windowFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Classe principal, realiza a execução do jogo e as primeiras chamadas de telas
 *
 * @author Otávio
 */
public class mainGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gameObjects.createGameObjects();
        windowFrame windowGame = new windowFrame();
        windowGame.setTitle("Adventure Quest");
        windowGame.add(new startGame(),BorderLayout.CENTER);
        windowGame.setSize(new Dimension(400,300));
        windowGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowGame.setVisible(true);
    }

}
