package vieira.sogo.batalhanaval.domain;

public class Tabuleiro {
    private String[][] tabuleiro = new String[10][10];
    private String[] indicecoluna = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private String[] indicelinha = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public Tabuleiro() {
        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                this.tabuleiro[i][j] = " ";
            }
        }
    }

    public void showTabuleiro() {
        //CABEÇALHO
        System.out.println("---------------------------------------------");
        System.out.println("                   JOGADOR                   ");
        System.out.println("---------------------------------------------");

        //INDEX LINHA
        System.out.print("|   |");
        for (int i = 0; i < indicelinha.length; i++) {
            System.out.print(" " + indicelinha[i] + " |");
        }
        System.out.println("\n---------------------------------------------");

        //INDEX COLUNA + GRID TABULEIRO
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print("| " + indicecoluna[i] + " |");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(" " + tabuleiro[i][j] + " |");
            }
            System.out.print("\n");
        }

        //RODAPE
        System.out.println("---------------------------------------------");

    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
