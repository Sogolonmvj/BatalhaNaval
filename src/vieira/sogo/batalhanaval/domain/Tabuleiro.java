package vieira.sogo.batalhanaval.domain;

import vieira.sogo.batalhanaval.enums.Linha;

import java.util.*;

public class Tabuleiro {
    private String[][] tabuleiro = new String[10][10];
    private List<Linha> indicecoluna = new ArrayList<>();
    private String[] indicelinha = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String name;

    private List<String> possibleItems = new ArrayList<>();

    public Tabuleiro(String name) {
        this.name = name;

        for (String[] strings : this.tabuleiro) {
            Arrays.fill(strings, " ");
        }

        Collections.addAll(indicecoluna, Linha.values());

        Collections.addAll(possibleItems, " ", "N", "n", "X", "-", "*");
    }

    public void showTabuleiro() {
        //CABEÇALHO
        System.out.println("\n---------------------------------------------");
        System.out.printf("|                   %s                       |%n", name);
        System.out.println("---------------------------------------------");

        //INDEX LINHA
        System.out.print("|   |");
        for (String s : indicelinha) {
            System.out.print(" " + s + " |");
        }
        System.out.println("\n---------------------------------------------");

        //INDEX COLUNA + GRID TABULEIRO
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print("| " + indicecoluna.get(i) + " |");

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

    public void updateTabuleiro(int linha, int coluna, String valor) {
        this.tabuleiro[linha][coluna] = valor;
    }

    public String getValueFromPosition (int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    public boolean possuiEmbarcacaoInteira () {
        for (String[] strings : tabuleiro) {
            for (String valorAtual : strings) {
                if (Objects.equals(valorAtual, "X") || Objects.equals(valorAtual, "N") || Objects.equals(valorAtual, "n"))
                    return true;
            }
        }

        return false;
    }
}
