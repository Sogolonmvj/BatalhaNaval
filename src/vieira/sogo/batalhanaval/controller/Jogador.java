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
    private List<Integer[]> disparos;

    public Jogador(String name, TipoJogador tipojogador) {
        this.name = name;
        this.tipojogador = tipojogador;
        this.tabuleiro = new Tabuleiro();
        this.embarcacoes = new ArrayList<>();
        this.disparos = new ArrayList<>();
    }

    public List<Integer[]> getDisparos() {
        return disparos;
    }

    public String getName() {
        return name;
    }

    public TipoJogador getTipojogador() {
        return tipojogador;
    }

    public void addEmbarcacao (Embarcacao embarcacao) {
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

    public int embarcacoesRestantes () {
        int remains = 0;

        for (Embarcacao embarcacao : embarcacoes) {
            if (!embarcacao.getAtingida()) remains++;
        }

        return remains;
    }

    public boolean embarcacaoDisponivel () {
        return embarcacoesRestantes() > 0;
    }

    public void realizarDisparo(int linha, int coluna, Jogador adversario) {
        System.out.println("realizando disparo " + name);
    }
}