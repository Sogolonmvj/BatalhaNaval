package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.domain.Embarcacao;
import vieira.sogo.batalhanaval.domain.Tabuleiro;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JogoView {
    Scanner scan;
    private JogadorView jogadorview;
    private EmbarcacaoView embarcacaoview;
    private TabuleiroView tabuleiroview;
    private TabuleiroView tabuleiroComputador;
    private List<Embarcacao> embarcacoes = new ArrayList<>();
    private List<Embarcacao> embarcacoesComputador = new ArrayList<>();
    private int embarcacoesCount = 10;

    public JogoView() {
        this.scan = new Scanner(System.in);
    }

    public void start() {
        this.jogadorview = new JogadorView();
        this.embarcacaoview = new EmbarcacaoView();
        this.tabuleiroview = new TabuleiroView();

        this.criarEmbarcacoes();
        this.criarTabuleiroComputador();
    }

    private void criarTabuleiroComputador() {

        do {
            int linha = getRandomNumber(0,9);
            int coluna = getRandomNumber(0,9);

            if (embarcacaoPosicionada(linha, coluna)) {
                continue;
            }

            embarcacoesComputador.add(new Embarcacao(linha, coluna));
        } while (embarcacoesComputador.size() < embarcacoesCount);

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void criarEmbarcacoes() {

        do {
            System.out.printf("Posicione o %d° navio. %n", embarcacoes.size() + 1);
            int linha = embarcacaoview.askLinha();
            int coluna = embarcacaoview.askColuna();

            if (embarcacaoPosicionada(linha, coluna)) {
                System.out.println("Já existe uma embarcaçao nessa posição!");
                continue;
            }

            embarcacoes.add(new Embarcacao(linha, coluna));
            this.clearScreen();
            marcaEmbarcacoesTabuleiro();
            tabuleiroview.show();
        } while (embarcacoes.size() < embarcacoesCount);

    }

    private boolean embarcacaoPosicionada(int linha, int coluna) {
        for (Embarcacao navio: embarcacoes) {
            if (navio.getLinha() == linha && navio.getColuna() == coluna) return true;
        }
        return false;
    }

    private void marcaEmbarcacoesTabuleiro(){
        for (Embarcacao navio: embarcacoes) {
            int colunaNavio = navio.getColuna();
            int linhaNavio = navio.getLinha();
            tabuleiroview.tabuleiro.updateTabuleiro(linhaNavio, colunaNavio, "N");
        }
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
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void loop() {
        do {

        } while (true);
    }

}
