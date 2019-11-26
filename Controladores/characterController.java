/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import RPGGame.Objetos.*;
import RPGGame.gameObjects;
import java.util.ArrayList;

/**
 * Essa classe basicamente realiza operações relacionadas a criação de personagem
 *
 * @author Otávio
 */
public class characterController {

    /**
     * Após a tela de criação do personagem, o sistema recupera as informações inseridas pelo usuário
     * e cria um novo objeto jogador.
     *
     * @param nome Nome definido pelo jogador na tela de criação
     * @param indexClasse Index da classe selecionada pelo jogador na lista de classes
     */
    public static void criaPersonagem(String nome, int indexClasse){
        gameObjects.jogador.setNome(nome);
        gameObjects.jogador.setNivel(1);
        gameObjects.jogador.setExperiencia(0);
        gameObjects.jogador.setDinheiro(30.0);
        gameObjects.jogador.setItensJogador(new ArrayList());
        gameObjects.jogador.setEquipamento(new Equipamento(null, null, null, null));
        gameObjects.jogador.setClasse(gameObjects.classes.get(indexClasse));
        gameObjects.jogador.setAtaque(gameObjects.jogador.getClasse().getAtaqueBase());
        gameObjects.jogador.setDefesa(gameObjects.jogador.getClasse().getDefesaBase());
        gameObjects.jogador.setEnergiaMaxima(gameObjects.jogador.getClasse().getEnergiaBase());
        gameObjects.jogador.setMagia(gameObjects.jogador.getClasse().getMagiaBase());
        gameObjects.jogador.setPrecisao(gameObjects.jogador.getClasse().getPrecisaoBase());
        gameObjects.jogador.setVidaMaxima(gameObjects.jogador.getClasse().getVidaBase());
        gameObjects.jogador.setVida(gameObjects.jogador.getClasse().getVidaBase());
        gameObjects.jogador.setEnergia(gameObjects.jogador.getClasse().getEnergiaBase());
    }
    
}
