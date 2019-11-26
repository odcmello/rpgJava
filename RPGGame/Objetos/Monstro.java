/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

import RPGGame.gameObjects;
import java.util.Random;

/**
 * Esse objeto contem informações referentes aos monstros criados durante
 * a execução do jogo.
 *
 * @author Otávio
 */
public class Monstro implements State, AtaqueInterface {

    private State estadoMorto = new EstadoMorto();

    private State estado;

    String nome, descricao;
    int nivel;
    int ataque, defesa, magia, precisao;
    int vidaMaxima, vidaMaximaFixo, energiaMaxima;
    int XPdado, fortunaDada;

    /**
     * Construtor padrão da classe Monstro
     *
     * @param nome Nome do monstro.
     * @param descricao Descrição breve sobre o monstro.
     * @param nivel Nivel do monstro.
     * @param ataque Propriedade de ataque do monstro.
     * @param magia Propriedade de magia do monstro.
     * @param defesa Propriedade de defesa do monstro.
     * @param precisao Propriedade de precisao do monstro.
     * @param vidaMaxima Propriedade de vida do monstro.
     * @param energiaMaxima Propriedade de energia do monstro.
     */
    public Monstro(String nome, String descricao, int nivel, int ataque, int defesa, int magia, int precisao, int vidaMaxima, int energiaMaxima) {
        this.nome = nome;
        this.descricao = descricao;
        this.nivel = nivel;
        this.ataque = ataque;
        this.defesa = defesa;
        this.magia = magia;
        this.precisao = precisao;
        this.vidaMaxima = vidaMaxima;
        this.vidaMaximaFixo = this.vidaMaxima;
        this.energiaMaxima = energiaMaxima;
        this.XPdado = (75 + (nivel * 30));
        this.fortunaDada = (nivel * 5);
    }

    public void setState(State estado) {
        this.estado = estado;
    }

    public State getState() {
        return this.estado;
    }

    /**
     * Método chamado quando monstro é atacado por jogador.Realiza os cálculos
     * de dano e diminuí sua vida atual com base no dano.
     *
     * @param jogador Dados sobre o jogador.
     * @return Dano que foi causado pelo jogador.
     */
    public int atacado(Jogador jogador) {
        Visitor visitor = new VisitorImpl();
        int ataqueJogador = jogador.ataque(visitor);
        vidaMaxima = vidaMaxima - ataqueJogador;
        return ataqueJogador;
    }

    /**
     * Método chamado quando jogador utiliza uma habilidade durante
     * batalha.Calcula o dano que será realizado com base nos atributos do
     * jogador e remove o dano de sua vida totall.
     *
     * @param jogador Dados do jogador.
     * @param habilidade Dado númerico acerca da habilidade que foi usada.
     * @return Retorna o dano que foi causado pela habilidade.
     */
    public int atacadoHabilidade(Jogador jogador, int habilidade) {
        int habilidadeAtacado = jogador.usarHabilidade(habilidade);
        vidaMaxima = vidaMaxima - habilidadeAtacado;
        return habilidadeAtacado;
    }

    /**
     * Método chamado quando monstro realiza ação de defesa durante combate. São
     * realizados cálculos para diminuir o dano que é causado pelo jogador.
     *
     * @param jogador Dados do jogador.
     * @return Dano que foi causado pelo jogador, reduzido.
     */
    public int defender(Jogador jogador) {
        Visitor visitor = new VisitorImpl();
        int ataqueJogador = (jogador != null) ? jogador.ataque(visitor) : 0;
        if (ataqueJogador == 0) {
            return 0;
        }
        int dano = (defesa >= jogador.ataque) ? ataqueJogador - ataqueJogador / 4 : ataqueJogador - ataqueJogador / 2;
        vidaMaxima = vidaMaxima - dano;
        return dano;
    }

    /**
     * Método chamado no inicio de um combate. Realiza a geração de um monstro
     * aleatório entre uma série de opções pré-definidas. Cada um tem seus
     * próprios atributos.
     *
     * @return Retorna o monstro que foi criado.
     */
    public static Monstro gerarMonstroAleatorio() {
        Random ran = new Random();
        int nivel = ran.nextInt(gameObjects.jogador.nivel + 1) + 1;
        int ataque = ran.nextInt(gameObjects.jogador.ataque) + 1;
        int defesa = ran.nextInt(gameObjects.jogador.defesa) + 1;
        int precisao = ran.nextInt(gameObjects.jogador.precisao) + 1;
        int magia = ran.nextInt(gameObjects.jogador.magia) + 1;

        int randNumber = ran.nextInt(gameObjects.jogador.nivel) + 1;
        Monstro monstro = null;

        switch (randNumber) {
            case 1:
                monstro = new Monstro("Morcego", "Esta criatura ataca em busca de sangue", nivel, ataque, defesa, magia, precisao, (ran.nextInt(15) + 1) * nivel, (ran.nextInt(15) + 1) * nivel);
                break;
            case 2:
                monstro = new Monstro("Goblin", "Uma pequena criatura diabólica", nivel, ataque, defesa, magia, precisao, (ran.nextInt(30) + 1) * nivel, (ran.nextInt(30) + 1) * nivel);
                break;
            case 3:
                monstro = new Monstro("Lobo", "Um feroz canino, tome cuidado com seus dentes", nivel, ataque, defesa, magia, precisao, (ran.nextInt(50) + 1) * nivel, (ran.nextInt(50) + 1) * nivel);
                break;
            case 4:
                monstro = new Monstro("Bandido", "Um malfeitor em busca de ouro", nivel, ataque, defesa, magia, precisao, (ran.nextInt(100) + 1) * nivel, (ran.nextInt(100) + 1) * nivel);
                break;
            case 5:
                monstro = new Monstro("Orc", "Uma grande criatura verde e intimidadora", nivel, ataque, defesa, magia, precisao, (ran.nextInt(125) + 1) * nivel, (ran.nextInt(125) + 1) * nivel);
                break;
            case 6:
                monstro = new Monstro("Assombração", "Um espírito que vaga o mundo em busca de vingança", nivel, ataque, defesa, magia, precisao, (ran.nextInt(150) + 1) * nivel, (ran.nextInt(150) + 1) * nivel);
                break;
            case 7:
                monstro = new Monstro("Golem", "Um enorme monstro rochoso que destrói tudo em seu caminho", nivel, ataque, defesa, magia, precisao, (ran.nextInt(200) + 1) * nivel, (ran.nextInt(200) + 1) * nivel);
                break;
            case 8:
                monstro = new Monstro("Cavaleiro Corrompido", "Um cavaleiro que foi corrompido pelo mau", nivel, ataque, defesa, magia, precisao, (ran.nextInt(210) + 1) * nivel, (ran.nextInt(210) + 1) * nivel);
                break;
            case 9:
                monstro = new Monstro("Dragão Bebê", "Um pequeno dragão que ainda não tem completo controle dos poderes", nivel, ataque, defesa, magia, precisao, (ran.nextInt(230) + 1) * nivel, (ran.nextInt(230) + 1) * nivel);
                break;
            case 10:
                monstro = new Monstro("Ente Ancião", "Uma gigansteca árvore antiga que adquiriu vida", nivel, ataque, defesa, magia, precisao, (ran.nextInt(250) + 1) * nivel, (ran.nextInt(250) + 1) * nivel);
                break;
        }
        return monstro;
    }

    /**
     * Retorna se um monstro está atualmente vivo.
     *
     * @return Retorna estado de vida.
     */
    public boolean vivo() {
        return vidaMaxima > 0;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public String getNome() {
        return nome;
    }

    public int getXPdado() {
        return XPdado;
    }

    public int getFortunaDada() {
        return fortunaDada;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVidaMaximaFixo() {
        return vidaMaximaFixo;
    }

    public void setVidaMaximaFixo(int vidaMaximaFixo) {
        this.vidaMaximaFixo = vidaMaximaFixo;
    }

    @Override
    public void estadoMonstro() {
        estado.estadoMonstro();
    }

    @Override
    public int ataque(Visitor visitor) {
        return visitor.atacar(this);
    }

}
