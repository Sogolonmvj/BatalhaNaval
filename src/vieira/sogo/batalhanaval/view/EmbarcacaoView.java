package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.enums.Linha;

import java.util.List;
import java.util.Scanner;

public class EmbarcacaoView {
    Scanner scanner;
    public int linha;
    public int coluna;

    public EmbarcacaoView() {
        this.scanner = new Scanner(System.in);
    }

    public void askPosicao() {
        System.out.println("Qual a posicao do navio? Ex: A0, B3, G6, ...");
        System.out.println("As linhas vão de A à J.");
        System.out.println("As colunas vão de 0 à 9.");
        String posicao = scanner.next();
        boolean flagLetter = Character.isDigit(posicao.charAt(0));
        boolean flagNumber = Character.isDigit(posicao.charAt(1));

        if (!(!flagLetter && flagNumber)) {
            System.out.println("Valor inválido! Por favor, insira a linha e coluna nessa ordem.");
            askPosicao();
        }

        if (posicao.length() != 2) {
            System.out.println("Valor inválido! Por favor, insira a linha e a coluna.");
            askPosicao();
        }

        String letra = Character.toString(posicao.charAt(0)).toUpperCase();

        this.coluna = Character.getNumericValue(posicao.charAt(1));

        switch (letra) {
            case "A":
                this.linha = 0;
                break;
            case "B":
                this.linha = 1;
                break;
            case "C":
                this.linha = 2;
                break;
            case "D":
                this.linha = 3;
                break;
            case "E":
                this.linha = 4;
                break;
            case "F":
                this.linha = 5;
                break;
            case "G":
                this.linha = 6;
                break;
            case "H":
                this.linha = 7;
                break;
            case "I":
                this.linha = 8;
                break;
            case "J":
                this.linha = 9;
                break;
            default:
                System.out.println("Digite uma letra de A à J.");
                askPosicao();
        };

    }
}
