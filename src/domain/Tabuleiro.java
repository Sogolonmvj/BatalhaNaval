package domain;

public class Tabuleiro {
    private char[][] tabuleiro = new char[10][10];
    private String[] coluna = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public void showTabuleiro() {

        System.out.println("---------------------------------------------");
        System.out.println("                   JOGADOR");
        System.out.println("---------------------------------------------");
        System.out.println("|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");

        for (int i = 0; i < tabuleiro.length ; i++) {
            System.out.println("---------------------------------------------");
            for (int j = 0; j < tabuleiro[i].length ; j++) {
                if (j == 0) {
                    System.out.print("| " + coluna[i] + " |");
                }
                System.out.print("   |");
            }
            System.out.println(" ");
        }
        System.out.println("---------------------------------------------");

    }

}
