/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame.Objetos;

/**
 * Esse objeto contem informações referentes a habilidades que estão
 * presentes no jogo
 *
 * @author Otávio
 */
public class Habilidades {

    String nomeHabilidade, descricao, tipo;
    int nivelMinimo, dano, gastoEnergia;
    Efeito efeito;

    /**
     * Construtor padrão da classe Equipamento
     * 
     * @param nomeHabilidade Nome da habilidade.
     * @param tipo Tipo da habilidade, pode ser ataque ou mágica.
     * @param descricao Breve descrição sobre habilidade.
     * @param nivelMinimo Nível mínimo para um jogador executar essa habilidade.
     * @param dano Dano base que é causado pela habilidade.
     * @param efeito Efeitos que a habilidade pode causar ao inimigo.
     * @param gastoEnergia Quantidade de energia que é gasta para executar.
     */
    public Habilidades(String nomeHabilidade, String tipo, String descricao, int nivelMinimo, int dano, Efeito efeito, int gastoEnergia) {
        this.nomeHabilidade = nomeHabilidade;
        this.tipo = tipo;
        this.descricao = descricao;
        this.nivelMinimo = nivelMinimo;
        this.dano = dano;
        this.efeito = efeito;
        this.gastoEnergia = gastoEnergia;
    }

    public String getNomeHabilidade() {
        return nomeHabilidade;
    }

    public int getNivelMinimo() {
        return nivelMinimo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDano() {
        return dano;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public int getGastoEnergia() {
        return gastoEnergia;
    }

    public void setGastoEnergia(int gastoEnergia) {
        this.gastoEnergia = gastoEnergia;
    }

}
