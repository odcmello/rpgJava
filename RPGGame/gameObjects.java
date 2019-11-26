/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPGGame;

import RPGGame.Objetos.*;
import java.util.ArrayList;

/**
 * Essa classe realiza a criação de todos os objetos do jogo, como itens,
 * habilidades, classe, entre outros.
 *
 * @author Otávio
 */
public class gameObjects {

    public static final ArrayList<TipoBuff> tiposBuff = new ArrayList();
    public static final Jogador jogador = Jogador.getInstance();
    public static final ArrayList<Classe> classes = new ArrayList();
    public static final ArrayList<Efeito> efeitos = new ArrayList();
    public static final ArrayList<Habilidades> habilidades = new ArrayList();
    public static final ArrayList<Item> itens = new ArrayList();
    public static final ArrayList<ItemLoja> itensCompráveis = new ArrayList();

    /**
     * Criação dos diversos objetos do jogo
     */
    static void createGameObjects() {

        tiposBuff.add(new TipoBuff("ATK"));
        tiposBuff.add(new TipoBuff("DEF"));
        tiposBuff.add(new TipoBuff("MAG"));
        tiposBuff.add(new TipoBuff("HP"));
        tiposBuff.add(new TipoBuff("ENG"));
        tiposBuff.add(new TipoBuff("ACC"));

        Efeito envenenamento = new Efeito("Envenenamento");
        efeitos.add(envenenamento);

        Efeito sangramento = new Efeito("Sangramento");
        efeitos.add(sangramento);

        Efeito adormecido = new Efeito("Adormecido");
        efeitos.add(adormecido);

        habilidades.add(new Habilidades("Golpe Básico", "ATK", "Ataque simples, não causará muito dano ao inimigo", 1, 10, null, 10));
        habilidades.add(new Habilidades("Investida", "ATK", "O guerreiro se investe contra seu inimigo, causando dano moderado", 3, 25, null, 30));
        habilidades.add(new Habilidades("Estocada", "ATK", "O guerreiro desfere um golpe com a ponta de sua espada, causando um dano letal", 5, 100, null, 75));
        habilidades.add(new Habilidades("Golpe Fatal", "ATK", "O guerreiro ataca consecutivamente, gerando sérias feridas ao inimigo", 10, 150, sangramento, 100));
        habilidades.add(new Habilidades("Precisão", "ATK", "Entrando em estado de concentração, o arqueiro ataca com uma flecha precisa", 3, 20, null, 20));
        habilidades.add(new Habilidades("Flecha Envenenada", "ATK", "O arqueiro utiliza veneno na ponta de uma flecha para envenenar seu alvo", 5, 80, envenenamento, 100));
        habilidades.add(new Habilidades("Ataque Triplo", "ATK", "O arqueiro lança uma sequência de flechas em direção ao inimigo, causando dano letal", 10, 120, null, 110));
        habilidades.add(new Habilidades("Bola de Fogo", "MGK", "Utilizando seus poderes mágicos, o mago conjura uma bola de fogo e a lança em direção ao inimigo", 3, 40, null, 30));
        habilidades.add(new Habilidades("Sonífero", "MGK", "O mago lança uma poção sonífero no inimigo, fazendo-o adormecer por duas rodadas", 5, 0, adormecido, 50));
        habilidades.add(new Habilidades("Trovão", "MGK", "Utilizando a energia da natureza, o mago invoca um trovão sobre o inimigo, causando grandes danos", 10, 200, null, 200));

        ArrayList<Habilidades> guerreiro = new ArrayList();
        guerreiro.add(habilidades.get(0));
        guerreiro.add(habilidades.get(1));
        guerreiro.add(habilidades.get(2));
        guerreiro.add(habilidades.get(3));
        classes.add(new Classe("Guerreiro", guerreiro, 15, 10, 5, 5, 50, 40));

        ArrayList<Habilidades> arqueiro = new ArrayList();
        arqueiro.add(habilidades.get(0));
        arqueiro.add(habilidades.get(4));
        arqueiro.add(habilidades.get(5));
        arqueiro.add(habilidades.get(6));
        classes.add(new Classe("Arqueiro", arqueiro, 10, 5, 5, 15, 40, 50));

        ArrayList<Habilidades> mago = new ArrayList();
        mago.add(habilidades.get(0));
        mago.add(habilidades.get(7));
        mago.add(habilidades.get(8));
        mago.add(habilidades.get(9));
        classes.add(new Classe("Mago", mago, 5, 5, 15, 10, 45, 45));

        itens.add(new Item.ItemBuilder("Poção de Vida", "Elixir que restaura 40 de vida", "Geral", 1, true, 10).build());
        itensCompráveis.add(new ItemLoja(itens.get(0), 5));
        itens.add(new Item.ItemBuilder("Poção de Energia", "Elixir que restaura 40 de energia", "Geral", 1, true, 10).build());
        itensCompráveis.add(new ItemLoja(itens.get(1), 5));

        ArrayList<Buff> tempBuff = new ArrayList();
        tempBuff.add(new Buff(10, tiposBuff.get(1)));
        itens.add(new Item.ItemBuilder("Toga", "Vestes simples, não protegem muito em combate", "Armadura", 1, true, 50).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(2), 25));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(25, tiposBuff.get(1)));
        itens.add(new Item.ItemBuilder("Couraça de Pano", "Vestimenta usado por cavaleiros de baixo nível", "Armadura", 3, true, 90).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(3), 55));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(40, tiposBuff.get(1)));
        itens.add(new Item.ItemBuilder("Armadura de Prata", "Armadura resistente para cavaleiros mais experientes", "Armadura", 6, true, 150).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(4), 75));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(60, tiposBuff.get(1)));
        itens.add(new Item.ItemBuilder("Armadura de Ouro", "Armadura essencial para cavaleiros que precisam de uma defesa inquebrável", "Armadura", 10, true, 250).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(5), 120));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(75, tiposBuff.get(1)));
        tempBuff.add(new Buff(100, tiposBuff.get(3)));
        itens.add(new Item.ItemBuilder("Armadura do Chefe", "Conquistada após derrotar o chefe do calabouço", "Armadura", 10, true, 1000).setBuff(tempBuff).build());

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(10, tiposBuff.get(1)));
        itens.add(new Item.ItemBuilder("Chápeu Simples", "Chápeu simple para proteção da cabeça", "Capacete", 1, true, 50).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(7), 25));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(25, tiposBuff.get(1)));
        itens.add(new Item.ItemBuilder("Capacete Metálico", "Protege contra impactos leves", "Capacete", 3, true, 90).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(8), 55));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(40, tiposBuff.get(1)));
        itens.add(new Item.ItemBuilder("Elmo de Prata", "Proteção para cabeça resistente para cavaleiros mais experientes", "Capacete", 6, true, 150).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(9), 75));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(60, tiposBuff.get(1)));
        itens.add(new Item.ItemBuilder("Elmo de Ouro", "Essencial para cavaleiros que precisam de uma defesa inquebrável", "Capacete", 10, true, 250).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(10), 120));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(15, tiposBuff.get(1)));
        tempBuff.add(new Buff(150, tiposBuff.get(2)));
        itens.add(new Item.ItemBuilder("Chápeu de Bruxo", "Conquistada após derrotar o chefe do calabouço", "Capacete", 10, true, 1000).setBuff(tempBuff).build());

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(10, tiposBuff.get(4)));
        itens.add(new Item.ItemBuilder("Sandálias Antigas", "Sandálias desgastadas pelo tempo", "Sapatos", 1, true, 50).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(12), 25));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(25, tiposBuff.get(4)));
        itens.add(new Item.ItemBuilder("Sapatos Rápidos", "Ótimos para cavaleiros que precisam de mobilidade", "Sapatos", 3, true, 90).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(13), 55));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(40, tiposBuff.get(4)));
        itens.add(new Item.ItemBuilder("Botas de Couro", "São velozes e resistentes", "Sapatos", 6, true, 150).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(14), 75));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(60, tiposBuff.get(4)));
        itens.add(new Item.ItemBuilder("Botas de Metal", "Essenciais para um cavaleiro que busca resistência em um combate", "Sapatos", 10, true, 250).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(15), 120));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(10, tiposBuff.get(0)));
        itens.add(new Item.ItemBuilder("Espada de Madeira", "Espada utilizada pra treino, não causa muito dano", "Mãos", 1, true, 50).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(16), 25));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(25, tiposBuff.get(0)));
        itens.add(new Item.ItemBuilder("Espada de Ferro", "Uma espada comum utilizada por qualquer cavaleiro", "Mãos", 5, true, 50).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(17), 65));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(60, tiposBuff.get(4)));
        itens.add(new Item.ItemBuilder("Espada de Ouro", "Tem um alto poder perfurante", "Mãos", 10, true, 250).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(18), 120));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(90, tiposBuff.get(4)));
        tempBuff.add(new Buff(50, tiposBuff.get(5)));
        itens.add(new Item.ItemBuilder("Espada de Precisão", "Conquistada após derrotar chefe no calabouço. Foi encantada para ser precisa em seus golpes", "Mãos", 10, true, 1000).setBuff(tempBuff).build());

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(10, tiposBuff.get(2)));
        itens.add(new Item.ItemBuilder("Varinha Mágica", "Varinha de madeira capaz de conjurar magias", "Mãos", 1, true, 50).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(20), 25));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(25, tiposBuff.get(2)));
        itens.add(new Item.ItemBuilder("Cetro Encantado", "Arma mágica com grandes poderes", "Mãos", 5, true, 120).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(21), 65));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(60, tiposBuff.get(2)));
        itens.add(new Item.ItemBuilder("Cajado", "Somente para magos mais habilidosos", "Mãos", 10, true, 250).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(22), 120));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(100, tiposBuff.get(2)));
        tempBuff.add(new Buff(30, tiposBuff.get(5)));
        itens.add(new Item.ItemBuilder("Cajado Ancião", "Conquistada após derrotar chefe no calabouço. Pertencia a um grande mago no passado", "Mãos", 10, true, 1000).setBuff(tempBuff).build());

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(10, tiposBuff.get(0)));
        itens.add(new Item.ItemBuilder("Estilingue", "Arma amadora para um arqueiro, pode ser usada para caça de animais pequenos", "Mãos", 1, true, 50).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(24), 25));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(25, tiposBuff.get(0)));
        itens.add(new Item.ItemBuilder("Arco Recurvo", "Arco básico para arqueiros iniciantes", "Mãos", 5, true, 120).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(25), 65));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(60, tiposBuff.get(0)));
        itens.add(new Item.ItemBuilder("Balestra", "Arma avançada para uso de arqueiros experientes", "Mãos", 10, true, 250).setBuff(tempBuff).build());
        itensCompráveis.add(new ItemLoja(itens.get(26), 120));

        tempBuff = new ArrayList();
        tempBuff.add(new Buff(75, tiposBuff.get(2)));
        tempBuff.add(new Buff(95, tiposBuff.get(5)));
        itens.add(new Item.ItemBuilder("Arco Duplo", "Conquistada após derrotar chefe no calabouço. Dobro da precisão de um arco comum", "Mãos", 10, true, 1000).setBuff(tempBuff).build());
    }
}
