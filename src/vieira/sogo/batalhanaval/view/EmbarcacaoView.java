package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.enums.Linha;

import java.util.Scanner;

public class EmbarcacaoView {
    Scanner scanner;

    public EmbarcacaoView() {
        this.scanner = new Scanner(System.in);
    }

    public int askColuna() {
        System.out.println("Qual o indice da coluna?");

        for (int coluna = 0; coluna < 10; coluna++) {
            System.out.print(coluna + "   ");
        }

        System.out.println(" ");
        System.out.print("#: ");

        int indice = scanner.nextInt();

        if (indice <= 0 || indice >= 9) {
            System.out.println("Indice inválido!");
            askColuna();
        }

        return indice;
    }

    public int askLinha() {
        System.out.println("Qual o indice da linha?");

        for (Linha linhaUsuario : Linha.values()) {
            System.out.printf("%d - %s %n", linhaUsuario.ordinal(), linhaUsuario.name());
        }

        System.out.print("#: ");

        int indice = scanner.nextInt();

        if (indice < 0 || indice >= Linha.values().length) {
            System.out.println("Indice inválido!");
            askLinha();
        }

        return indice;
    }

}
