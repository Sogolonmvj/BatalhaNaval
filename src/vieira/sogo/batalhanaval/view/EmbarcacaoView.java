package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.domain.Embarcacao;
import vieira.sogo.batalhanaval.enums.Linha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmbarcacaoView {
    Scanner scanner;
    Embarcacao embarcacao;
    private List<Embarcacao> embarcacoes = new ArrayList<>();

    public EmbarcacaoView() {
        this.scanner = new Scanner(System.in);
        System.out.println("Posicione a sua embarcação");

        for (int i = 0; i < 10 ; i++) {
            int linha = this.askLinha();
            int coluna = this.askColuna();
            this.embarcacao = new Embarcacao(linha, coluna);

            embarcacoes.add(embarcacao);
        }

    }

    private int askColuna() {
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

    private int askLinha() {
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
