package domain;

import enums.TipoJogador;

public class Jogador {
    private String name;
    private TipoJogador tipojogador;
    private int shots = 0;
    private int hits = 0;

    public Jogador(String name, TipoJogador tipojogador) {
        this.name = name;
        this.tipojogador = tipojogador;
    }

    public String getName() {
        return name;
    }

    public TipoJogador getTipojogador() {
        return tipojogador;
    }

    public int getShots() {
        return shots;
    }

    public int getHits() {
        return hits;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
