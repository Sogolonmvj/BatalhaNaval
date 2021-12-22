package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.domain.Jogador;
import vieira.sogo.batalhanaval.enums.TipoJogador;

import java.util.Scanner;

public class JogadorView {
    Scanner scanner;
    private Jogador jogador1;
    private Jogador jogador2;

    public JogadorView() {
        this.scanner = new Scanner(System.in);

        String name = this.askName();
        this.jogador1 = new Jogador(name, TipoJogador.HUMANO);
        this.jogador2 = new Jogador("COMPUTADOR", TipoJogador.COMPUTADOR);
    }

    private String askName() {
        System.out.println("Qual o nome do jogador?");
        System.out.print("#: ");
        String name = scanner.nextLine();
        if (name.isBlank()) {
            System.out.println("Nome inválido!");
            name = askName();
        }
        return name;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }
}
