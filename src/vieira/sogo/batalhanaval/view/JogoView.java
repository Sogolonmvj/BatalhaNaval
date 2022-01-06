package vieira.sogo.batalhanaval.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoView {
    Scanner scan;
    private JogadorView jogadorview;

    public JogoView() {
        this.scan = new Scanner(System.in);
    }

    public void start() {
        this.jogadorview = new JogadorView();

        this.jogadorview.criarEmbarcacoes();

        loop();
    }

    public void templateInicial(){
        this.clearScreen();
        System.out.println("  __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ");
        System.out.println(" |                 BATALHA NAVAL                 |");
        System.out.println(" |__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
        System.out.println(" |                    GRUPO 13                   |");
        System.out.println(" |           SOGOLON, PAULO E WANDERSON          |");
        System.out.println(" |__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
        System.out.println(" ");
        this.menu();
    }

    private void menu() {
        int entrada = 0;

        System.out.println("  __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ");
        System.out.println(" |          Deseja iniciar um novo jogo?         |");
        System.out.println(" |           1 - SIM          2 - NÃO            |");
        System.out.println(" |__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
        System.out.print("#: ");

        do {
            try {
                entrada = scan.nextInt();
                if(entrada != 1 && entrada != 2){
                    System.out.println("#: Opção inválida, tente novamente.");
                    System.out.print("#: ");
                    entrada = 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Precisamos que digite apenas números, tente novamente.");
                System.out.print("#: ");
            }
            scan.nextLine();
        } while (entrada == 0);

        System.out.println(" ");

        if (entrada == 1) {
            this.start();
        } else if (entrada == 2) {
            System.out.println("Ok, bye bye!");
        }
    }

    private void clearScreen() {
        // fazer funcionar
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void loop() {
        clearScreen();

        jogadorview.jogar();


    }

    private boolean checarEmbacarcoes () {
        return false;
    }

}
