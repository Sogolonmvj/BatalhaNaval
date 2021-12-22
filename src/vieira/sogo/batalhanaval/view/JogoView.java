package vieira.sogo.batalhanaval.view;

import java.util.Scanner;

public class JogoView {
    private JogadorView jogadorview;
    private EmbarcacaoView embarcacaoview;
    private TabuleiroView tabuleiroview;

    public void start() {
        this.menu();
    }

    public void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bem vindo ao Batalha Naval!");
        System.out.println("Deseja iniciar o jogo?");
        System.out.println("1 - SIM");
        System.out.println("2 - NÃO");
        System.out.print("#: ");

        int entrada = scan.nextInt();

        if (entrada == 1) {
            this.jogadorview = new JogadorView();
            this.embarcacaoview = new EmbarcacaoView();
            this.tabuleiroview = new TabuleiroView();
        } else if (entrada == 2) {
            System.out.println("Jogo será reiniciado!");
            menu();
        } else {
            System.out.println("Entrada inválida!");
            menu();
        }

    }

}
