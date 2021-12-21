package view;

import domain.Jogador;
import enums.TipoJogador;

import java.util.Scanner;

public class JogadorView {
    private Scanner scanner;
    private Jogador jogador1;
    private Jogador jogador2;

    public JogadorView() {
        String name = this.askName();
        this.jogador1 = new Jogador(name, TipoJogador.COMPUTADOR);
        this.jogador2 = new Jogador("COMPUTADOR", TipoJogador.COMPUTADOR);
    }

    private String askName() {
        System.out.println("Qual o nome do joador?");
        System.out.println("#: ");
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
