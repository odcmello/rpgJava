/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

import RPGGame.gameObjects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator;

/**
 * Esse objeto contém todas as informações sobre o jogador.
 *
 * @author Otávio
 */
public class Jogador implements Iterable<Item>, AtaqueInterface {

    private static Jogador instance;
    String nome;
    double dinheiro;
    int nivel, experiencia;
    int ataque, defesa, magia, precisao;
    int vida, vidaMaxima, energia, energiaMaxima;
    Classe classe;
    ArrayList<Item> itensJogador;
    Equipamento equipamento;

    private Jogador() {
    }

    /**
     * Implementa padrão Singleton.Garante que só uma instância de jogador é
     * criada.
     *
     * @return
     */
    public static synchronized Jogador getInstance() {
        if (instance == null) {
            instance = new Jogador();
        }
        return instance;
    }

    /**
     * Método chamado quando jogador utiliza uma habilidade durante batalha.
     * Calcula o dano que será realizado com base nos atributos do jogador.
     *
     * @param habilidade Dado númerico acerca da habilidade que foi usada.
     * @return Retorna o dano que foi causado pela habilidade.
     */
    public int usarHabilidade(int habilidade) {
        Random ran = new Random();
        Habilidades habilidadeUsada = classe.habilidadesClasse.get(habilidade);
        this.energia = this.energia - habilidadeUsada.gastoEnergia;
        switch (habilidadeUsada.tipo) {
            case "ATK":
                return habilidadeUsada.dano + (ran.nextInt(habilidadeUsada.dano) + (ataque / 3));
            case "MGK":
                return habilidadeUsada.dano + (ran.nextInt(habilidadeUsada.dano) + (magia / 3));
        }
        return habilidadeUsada.dano;
    }

    /**
     * Método chamado quando jogador utiliza uma poção de vida. Sua vida é
     * recuperada e uma poção é removida do seu inventário.
     */
    public void recuperarVida() {
        this.vida = this.vida + 40;
        this.vida = (this.vida > this.vidaMaxima) ? this.vidaMaxima : this.vida;
        itensJogador.remove(gameObjects.itens.get(0));
    }

    /**
     * Método chamado quando jogador utiliza uma poção de energia. Sua energia é
     * recuperada e uma poção é removida do seu inventário.
     */
    public void recuperarEnergia() {
        this.energia = this.energia + 40;
        this.energia = (this.energia > this.energiaMaxima) ? this.energiaMaxima : this.energia;
        itensJogador.remove(gameObjects.itens.get(1));
    }

    /**
     * Método para gerar a probabilidade do jogador escapar do monstro que está
     * batalhando atualmente com base no nível de ambos.
     *
     * @param monstro Monstro que está em batalha atualmente.
     * @return Retorna um número aleatório gerado, sendo a probabilidade de ter
     * escapado.
     */
    public int escapar(Monstro monstro) {
        Random ran = new Random();
        int auxiliar = (this.nivel > monstro.nivel) ? this.nivel - monstro.nivel : 0;
        auxiliar = auxiliar * 10;
        return ran.nextInt((100 - auxiliar) + 1) + auxiliar;
    }

    /**
     * Método chamado quando jogador é atacado por monstro. Realiza os cálculos
     * de dano e diminuí sua vida atual com base no dano.
     *
     * @param monstro Monstro que está em batalha atualmente.
     * @return Dano que foi causado pelo monstro.
     */
    public int atacado(Monstro monstro) {
        Visitor visitor = new VisitorImpl();
        int ataqueMonstro = monstro.ataque(visitor);
        vida = vida - ataqueMonstro;
        return ataqueMonstro;
    }

    /**
     * Método chamado quando jogador seleciona a opção para se defender de golpe
     * de um monstro. São realizados cálculos para diminuir o dano que é causado
     * por um monstro.
     *
     * @param monstro Monstro que está em batalha atualmente.
     * @return Dano que foi causado pelo monstro, reduzido.
     */
    public int defender(Monstro monstro) {
        Visitor visitor = new VisitorImpl();
        int ataqueMonstro = monstro.ataque(visitor);
        int dano = (defesa >= monstro.ataque) ? ataqueMonstro - ataqueMonstro / 4 : ataqueMonstro - ataqueMonstro / 2;
        vida = vida - dano;
        return dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Determina o quanto de experiência o jogador tem no momento. Quando
     * experiência atinge o máximo do nível, soma-se um nível a mais ao jogador
     * e se aprimoram todos os atributos.
     *
     * @param experiencia
     */
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
        if (this.experiencia >= (nivel * 500)) {
            this.nivel++;
            this.experiencia = this.experiencia - (nivel * 500);
            this.vidaMaxima = this.vidaMaxima + this.vidaMaxima / 2;
            this.energiaMaxima = this.energiaMaxima + this.energiaMaxima / 2;
            this.ataque = this.ataque + this.ataque / 2;
            this.defesa = this.defesa + this.defesa / 2;
            this.magia = this.magia + this.magia / 2;
            this.precisao = this.precisao + this.precisao / 2;
            this.vida = this.vidaMaxima;
            this.energia = this.energiaMaxima;
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getPrecisao() {
        return precisao;
    }

    public void setPrecisao(int precisao) {
        this.precisao = precisao;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEnergiaMaxima() {
        return energiaMaxima;
    }

    public void setEnergiaMaxima(int energiaMaxima) {
        this.energiaMaxima = energiaMaxima;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public ArrayList<Item> getItensJogador() {
        return itensJogador;
    }

    public void addItensJogador(Item item) {
        this.itensJogador.add(item);
    }

    public void removeItensJogador(Item item) {
        this.itensJogador.remove(item);
    }

    public void setItensJogador(ArrayList<Item> itensJogador) {
        this.itensJogador = itensJogador;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    /**
     * Retorna se um jogador está atualmente vivo.
     *
     * @return Retorna estado de vida.
     */
    public boolean vivo() {
        return vida > 0;
    }

    /**
     * Recupera número de poções de vida atualmente disponíveis ao usuário.
     *
     * @return Número de poções que usuário possuí.
     */
    public int getNumeroPocoesVida() {
        return Collections.frequency(this.itensJogador, gameObjects.itens.get(0));
    }

    /**
     * Recupera número de poções de energia atualmente disponíveis ao usuário.
     *
     * @return Número de poções que usuário possuí.
     */
    public int getNumeroPocoesEnergia() {
        return Collections.frequency(this.itensJogador, gameObjects.itens.get(1));
    }

    @Override
    public Iterator<Item> iterator() {
        return new DataSetIterator();
    }

    @Override
    public int ataque(Visitor visitor) {
        return visitor.atacar(this);
    }

    private class DataSetIterator implements Iterator {

        private int position = 0;

        @Override
        public boolean hasNext() {
            if (position < itensJogador.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Item next() {
            if (this.hasNext()) {
                return itensJogador.get(position++);
            } else {
                return null;
            }
        }
    }
}
