package vieira.sogo.batalhanaval.controller;

import vieira.sogo.batalhanaval.domain.Embarcacao;
import vieira.sogo.batalhanaval.domain.Tabuleiro;
import vieira.sogo.batalhanaval.enums.TipoJogador;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String name;
    private TipoJogador tipojogador;
    private Tabuleiro tabuleiro;
    private List<Embarcacao> embarcacoes;

    public Jogador(String name, TipoJogador tipojogador) {
        this.name = name;
        this.tipojogador = tipojogador;
        this.tabuleiro = new Tabuleiro();
        this.embarcacoes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public TipoJogador getTipojogador() {
        return tipojogador;
    }

    public void addEmbarcacao(Embarcacao embarcacao) {
        if(!this.embarcacoes.contains(embarcacao)){
            this.embarcacoes.add(embarcacao);
        }
    }

    public List<Embarcacao> getEmbarcacoes() {
        return embarcacoes;
    }

    public Tabuleiro getTabuleiro(){
        return tabuleiro;
    }
}