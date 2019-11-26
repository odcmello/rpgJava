/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

import RPGGame.gameObjects;
import java.util.Random;

/**
 * Esse objeto contem informações referentes a encontros de batalha com inimigos,
 * ou encontros sem batalha
 *
 * @author Otávio
 */
public class Encontro {

    String descricao;
    Monstro monstro;

    /**
     * Construtor padrão da classe Encontro
     * 
     * @param descricao Frase contendo alguma informação sobre o encontro
     * @param monstro Monstro que foi encontrado (null, caso não tenha)
     */
    public Encontro(String descricao, Monstro monstro) {
        this.descricao = descricao;
        this.monstro = monstro;
    }

    /**
     * Realiza a criação de um novo encontro aleatório
     *
     * @param encontroNumber O tipo de encontro, podendo ser encontro de batalha (1), encontro vazio (2) ou encontro com recompensa (3)
     * @return Retorna o encontro que foi criado
     */
    public static Encontro novoEncontro(int encontroNumber) {
        String descricao = null;
        Random ran = new Random();
        switch (encontroNumber) {
            case 1:
                descricao = "Monstro avistado. Prepare-se para o combate.";
                return new Encontro(descricao, Monstro.gerarMonstroAleatorio());
            case 2:
                descricao = "Você pensou ter escutado um barulho, mas não vê nada.";
                return new Encontro(descricao, null);
            case 3:
                descricao = "Enquanto caminhava pela masmorra, você encontrou um ";
                descricao += gameObjects.itensCompráveis.get(ran.nextInt(gameObjects.itensCompráveis.size()));
                return new Encontro(descricao, null);
        }
        return null;
    }

    public String getDescricao() {
        return descricao;
    }

    public Monstro getMonstro() {
        return monstro;
    }
}
