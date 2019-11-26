/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Interface.battleScreen;
import Interface.dungeonScreen;
import Interface.startGame;
import Interface.waitingScreen;
import RPGGame.Objetos.Encontro;
import RPGGame.Objetos.EstadoMorto;
import RPGGame.Objetos.Jogador;
import RPGGame.Objetos.Monstro;
import RPGGame.gameObjects;
import java.util.Random;
import javax.swing.JFrame;

/**
 * Classe para controlar diferentes questões de encontros e batalhas,
 * como ataques e defesas do jogado e do inimigo, e criação de dungeons
 *
 * @author Otávio
 */
public class battleController {

    static boolean escapeStatus, dungeon = false;
    private static Monstro monstroBatalha;
    static int niveis, niveisTotal;
    static String descricaoGeral = "Está escuro e díficil de enxergar muita coisa, mesmo assim você sente que está perto de algo.";

    /**
     * O sistema cria a dungeon quando solicitada pela interface. A partir
     * disso, gerá um dos três tipos diferentes de encontro dentro de cada nível
     * da dungeon.
     *
     * @param frame Atual janela que está executando o jogo
     */
    public static void dungeon(JFrame frame) {
        dungeon = true;
        Random ran = new Random();
        int chances = ran.nextInt(100);
        if (chances
                >= 20) {
            battleScreen battleScreen = new battleScreen(frame);
            battleScreen.startBattle(frame);
            frame.setContentPane(battleScreen);
            frame.validate();
        } else {
            if (chances <= 95) {
                descricaoGeral = Encontro.novoEncontro(2).getDescricao();
            } else {
                descricaoGeral = Encontro.novoEncontro(3).getDescricao();
            }
            if (niveis == 1) {
                dungeon = false;
                waitingScreen waiting = new waitingScreen();
                frame.setContentPane(waiting);
                frame.validate();
            } else {
                niveis--;
                dungeonScreen dungeonScreen = new dungeonScreen();
                frame.setContentPane(dungeonScreen);
                frame.validate();
                return;
            }
        }
        descricaoGeral = "Está escuro e díficil de enxergar muita coisa, mesmo assim você sente que está perto de algo.";
    }

    public static String getDescricaoDungeon() {
        return descricaoGeral;
    }

    /**
     * Quando esse método é chamado, inicia-se um encontro de batalha entre o
     * jogador e o monstro, podendo ser dentro de uma dungeon ou apenas em
     * treinamento.
     *
     * @param frame Atual janela que está executando o jogo
     */
    public static void treinamento(JFrame frame) {
        escapeStatus = false;
        Encontro encontroTreinamento = Encontro.novoEncontro(1);
        monstroBatalha = encontroTreinamento.getMonstro();
        System.out.println(encontroTreinamento.getDescricao());
        batalha(gameObjects.jogador, encontroTreinamento.getMonstro(), frame);
    }

    /**
     * Define o número total de níveis que uma determinada dungeon irá ter.
     */
    public static void defineNiveis() {
        Random ran = new Random();
        niveisTotal = ran.nextInt((((gameObjects.jogador.getNivel() / 2) + 5) - 5) + 1) + 5;
        niveis = niveisTotal;
    }

    public static int getNivelAtual() {
        return niveis;
    }

    public static int getNivelTotal() {
        return niveisTotal;
    }

    /**
     * Nesse método, entra-se em um laço até o fim da batalha (quando o monstro
     * ou o jogador morrer, ou quando o jogador escapar). Ele roda em background
     * enquanto o usuário clica nos itens da interface de batalha. Ao fim, o
     * método redireciona o jogador para a tela inicial, caso tenha morrido, ou
     * o recompensa pela vitória e o redireciona para o menu da cidade (se não
     * estiver em um dungeon).
     *
     * @param jogador O objeto jogador, contendo todas suas informações
     * @param monstro Monstro que atualmente está em combate
     * @param frame Atual janela que está executando o jogo
     */
    private static void batalha(Jogador jogador, Monstro monstro, JFrame frame) {

        while (jogador.vivo() && monstro.vivo() && !escapeStatus) {
            System.out.println("\n" + monstro.getNome() + "HP: " + monstro.getVidaMaxima()
                    + "    " + "Player HP: " + jogador.getVida());
        }

        if (!jogador.vivo()) {
            startGame startGame = new startGame();
            frame.setContentPane(startGame);
            frame.validate();
            return;
        } else if (!monstro.vivo()) {
            monstro.setState(new EstadoMorto());
            monstro.estadoMonstro();
            jogador.setExperiencia(jogador.getExperiencia() + monstro.getXPdado());
            jogador.setDinheiro(jogador.getDinheiro() + monstro.getFortunaDada());
            if (dungeon) {
                if (niveis == 1) {
                    dungeon = false;
                } else {
                    niveis--;
                    dungeonScreen dungeonScreen = new dungeonScreen();
                    frame.setContentPane(dungeonScreen);
                    frame.validate();
                    return;
                }
            }
        }
        waitingScreen waiting = new waitingScreen();
        frame.setContentPane(waiting);
        frame.validate();
    }

    /**
     * Esse método realiza um cálculo com um número aleatório para determinar se
     * o jogador conseguiu ou não escapar da batalha.
     *
     * @param jogador O objeto jogador, contendo todas suas informações
     * @param monstro Monstro que atualmente está em combate
     *
     * @return Retorna uma string para a interface exibir com o resultado da
     * fuga
     */
    public static String tentarEscapar(Jogador jogador, Monstro monstro) {
        int dano;
        String resultado = "";
        if (jogador.escapar(monstro) >= 50) {
            escapeStatus = true;
        } else {
            resultado = "Você tentou fugir, porém não conseguiu!\n";
            if (new Random().nextInt(100) >= 50) {
                dano = jogador.atacado(monstro);
                resultado += monstro.getNome() + " atacou, causando " + dano + " de dano.";
            } else {
                monstro.defender(null);
                resultado += monstro.getNome() + " se defendeu.";
            }
        }
        return resultado;
    }

    /**
     * Quando esse método é chamado pela interface do usuário na batalha, as
     * ações de ataque serão realizadas pelo jogador.Os dados de dano ao montro
     * são calculados e também determinam o quanto de dano o jogador recebeu do
     * monstro.
     *
     * @param jogador O objeto jogador, contendo todas suas informações
     * @param monstro Monstro que atualmente está em combate
     * @return Retorna uma string para a interface exibir com o resultado do
     * round de ataque
     */
    public static String roundAtaque(Jogador jogador, Monstro monstro) {
        int danoJogador, danoMonstro;
        if (new Random().nextInt(100) >= 50) {
            danoJogador = monstro.atacado(jogador);
            if (monstro.vivo()) {
                danoMonstro = jogador.atacado(monstro);
                return "Você atacou e causou " + danoJogador + " de dano.\n" + monstro.getNome() + " atacou e causou " + danoMonstro + " de dano.";
            }
        } else {
            danoJogador = monstro.defender(jogador);
            return monstro.getNome() + " se defendeu!\n Você atacou e causou " + danoJogador + " de dano.";
        }
        return "";
    }

    /**
     * Quando o jogador utiliza uma habilidade, esse método calcula o dano
     * realizado ao monstro com base na habilidade selecionada.
     *
     * @param habilidade Habilidade que foi selecionada pelo jogador
     * @param jogador O objeto jogador, contendo todas suas informações
     * @param monstro Monstro que atualmente está em combate
     */
    public static void roundAtaqueHabilidade(int habilidade, Jogador jogador, Monstro monstro) {
        monstro.atacadoHabilidade(jogador, habilidade);
        if (monstro.vivo()) {
            jogador.atacado(monstro);
        }
    }

    /**
     * Quando o jogador seleciona a opção de defesa, esse método é chamado.Menos
     * dano será recebido do monstro que está atacando.
     *
     * @param jogador O objeto jogador, contendo todas suas informações
     * @param monstro Monstro que atualmente está em combate
     * @return Retorna uma string para a interface exibir com o resultado do
     * round de defesa
     */
    public static String roundDefesa(Jogador jogador, Monstro monstro) {
        return "Você se defendeu!\n" + monstro.getNome() + " atacou e causou " + jogador.defender(monstro) + " de dano.";
    }

    public static Monstro getMonstroBatalha() {
        return monstroBatalha;
    }
}
