package vieira.sogo.batalhanaval.domain;

public class Embarcacao {
    private int linha;
    private int coluna;
    private boolean atingida;

    public Embarcacao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.atingida = false;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public boolean getAtingida () { return atingida; }
}
