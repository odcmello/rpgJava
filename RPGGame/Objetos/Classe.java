/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

import java.util.ArrayList;

/**
 * Esse objeto contem informações referentes de classes que o jogador
 * pode selecionar durante a criação de personagem
 *
 * @author Otávio
 */
public class Classe {

    String nomeClasse;
    int ataqueBase;
    int defesaBase;
    int magiaBase;
    int precisaoBase;
    int energiaBase, vidaBase;
    ArrayList<Habilidades> habilidadesClasse;

    /**
     * Construtor padrão da classe Classe
     *
     * @param nomeClasse Nome que foi definido para uma classe
     * @param habilidadesClasse Habilidades que estão disponíveis para jogadores desta classe
     * @param ataqueBase Ataque base que jogadores desta classe possuem
     * @param defesaBase Defesa base que jogadores desta classe possuem
     * @param magiaBase Magia base que jogadores desta classe possuem
     * @param precisaoBase Precisão base que jogadores desta classe possuem
     * @param vidaBase Vida base que jogadores desta classe possuem
     * @param energiaBase Energia base que jogadores desta classe possuem
     * 
     */
    public Classe(String nomeClasse, ArrayList<Habilidades> habilidadesClasse, int ataqueBase, int defesaBase, int magiaBase, int precisaoBase, int vidaBase, int energiaBase) {
        this.nomeClasse = nomeClasse;
        this.habilidadesClasse = habilidadesClasse;
        this.ataqueBase = ataqueBase;
        this.defesaBase = defesaBase;
        this.magiaBase = magiaBase;
        this.precisaoBase = precisaoBase;
        this.vidaBase = vidaBase;
        this.energiaBase = energiaBase;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public int getMagiaBase() {
        return magiaBase;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public int getPrecisaoBase() {
        return precisaoBase;
    }

    public int getEnergiaBase() {
        return energiaBase;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public ArrayList<Habilidades> getHabilidadesClasse() {
        return habilidadesClasse;
    }

}
