package view;

import domain.Embarcacao;

import java.util.Scanner;

public class TabuleiroView {
    int linha;
    int coluna;
    Embarcacao posicaoNavio = new Embarcacao(linha, coluna);
    Scanner scan = new Scanner(System.in);

    public void askPosicao() {
        System.out.println("Qual a linha?");

    }
}
