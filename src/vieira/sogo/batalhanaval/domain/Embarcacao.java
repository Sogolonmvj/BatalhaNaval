package vieira.sogo.batalhanaval.domain;

public class Embarcacao {
    private int linha;
    private int coluna;

    public Embarcacao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}
