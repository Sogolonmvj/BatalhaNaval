package vieira.sogo.batalhanaval.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EmbarcacaoView {
    Scanner scanner;
    public int linha;
    public int coluna;
    private List<String> letras = new ArrayList<>();

    public EmbarcacaoView() {
        this.scanner = new Scanner(System.in);

        Collections.addAll(letras, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
    }

    public void askPosicao(String objeto) {
        System.out.printf("Qual a posicao do %s? Ex: A0, B3, G6, ...", objeto);
        System.out.println("As linhas vão de A à J.");
        System.out.println("As colunas vão de 0 à 9.");

        String posicao = scanner.next();

        boolean flagLetter = Character.isDigit(posicao.charAt(0));
        boolean flagNumber = Character.isDigit(posicao.charAt(1));

        if (!(!flagLetter && flagNumber)) {
            System.out.println("Valor inválido! Por favor, insira a linha e coluna nessa ordem.");
            askPosicao(objeto);
        }

        if (posicao.length() != 2) {
            System.out.println("Valor inválido! Por favor, insira a linha e a coluna.");
            askPosicao(objeto);
        }

        int index = letras.indexOf(Character.toString(posicao.charAt(0)).toUpperCase());

        this.coluna = Character.getNumericValue(posicao.charAt(1));

        if (index > -1) {
            this.linha = index;
        } else {
            System.out.println("Digite uma letra de A à J.");

            askPosicao(objeto);
        }
    }
}
