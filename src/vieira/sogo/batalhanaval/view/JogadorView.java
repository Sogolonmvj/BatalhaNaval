package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.controller.Jogador;
import vieira.sogo.batalhanaval.domain.Embarcacao;
import vieira.sogo.batalhanaval.enums.TipoJogador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JogadorView {
    Scanner scanner;
    private EmbarcacaoView embarcacaoview = new EmbarcacaoView();
    private List<Jogador> jogadores;
    private int quantidadeEmbarcacoes = 10;
    private int quantidadeJogadores = 2;

    public JogadorView() {
        this.scanner = new Scanner(System.in);
        this.jogadores = new ArrayList<>();

        System.out.println("  __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ");
        System.out.println(" |              Dados dos jogadores              |");
        System.out.println(" |__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|\n");

        for (int i = 0; i < quantidadeJogadores ; i++) {
            TipoJogador tipoJogador = this.askTipoJogador(i);

            String name = tipoJogador == TipoJogador.COMPUTADOR ? "COMPUTADOR" : this.askName(i);

            this.jogadores.add(new Jogador(name, tipoJogador));
        }
    }

    public Jogador getJogador(int indice) {
        return jogadores.get(indice);
    }

    private String askName(int i) {
        String name = "";

        System.out.printf("\nQual o nome do %d° jogador?%n", i+1);
        System.out.print("#: ");

        do {
            try {
                name = scanner.next();
                if(name.isBlank()){
                    System.out.println("#: Nome inválido, tente novamente.");
                    System.out.print("#: ");
                    name = "";
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Precisamos que digite um nome, tente novamente.");
                System.out.print("#: ");
            }
            scanner.nextLine();
        } while (name == "");
        System.out.println(" ");
        return name;
    }

    private TipoJogador askTipoJogador(int i) {
        TipoJogador retornoTipoJogador;
        int indice = -1;
        System.out.printf("\nInforme o tipo do  %d° jogador%n", i+1);
        for (TipoJogador tipoJogador : TipoJogador.values()) {
            System.out.printf("%d - %s %n", tipoJogador.ordinal(), tipoJogador.name());
        }
        System.out.print("#: ");

        do {
            try {
                indice = scanner.nextInt();
                if (indice < 0 || indice >= TipoJogador.values().length) {
                    System.out.println("Indice inválido, tente novamente.");
                    System.out.print("#: ");
                    continue;
                }
                for (TipoJogador tipoJogador : TipoJogador.values()) {
                    if (indice == tipoJogador.ordinal() ) {
                        return TipoJogador.valueOf(tipoJogador.name());
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Precisamos que digite um numero, tente novamente.");
                System.out.print("#: ");
            }
            scanner.nextLine();
        } while (indice < 0);

        return null;
    }

     public void criarEmbarcacoes() {
         System.out.println("  __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ");
         System.out.println(" |         Posicionamento das embarcações        |");
         System.out.println(" |__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|\n");

        for (int i = 0; i < jogadores.size() ; i++) {
            boolean automatico = jogadores.get(i).getTipojogador() == TipoJogador.COMPUTADOR || askCriarEmbarcacoesAutomaticamente(i);

            do {
                int linha;
                int coluna;

                if (jogadores.get(i).getTipojogador() != TipoJogador.COMPUTADOR)
                    System.out.printf("\n Posicione o %d° navio. %n", jogadores.get(i).getEmbarcacoes().size() + 1);

                if (automatico) {
                    linha = getRandomNumber(0, 10);
                    coluna = getRandomNumber(0, 10);
                } else {
                    embarcacaoview.askPosicao();

                    linha = embarcacaoview.linha;
                    coluna = embarcacaoview.coluna;
                }

                if (!verificarPosicaoDisponivel(linha, coluna, jogadores.get(i))) {
                    if (jogadores.get(i).getTipojogador() != TipoJogador.COMPUTADOR)
                        System.out.println("Já existe uma embarcação nessa posição!");
                    continue;
                }

                jogadores.get(i).addEmbarcacao(new Embarcacao(linha, coluna));

                marcaEmbarcacoesTabuleiro();

                if (jogadores.get(i).getTipojogador() != TipoJogador.COMPUTADOR)
                    jogadores.get(i).getTabuleiro().showTabuleiro();
            } while (jogadores.get(i).getEmbarcacoes().size() < quantidadeEmbarcacoes);

        }

    }

    private boolean askCriarEmbarcacoesAutomaticamente (int i) {
        int entrada = 0;

        System.out.println("  __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ");
        System.out.println(" |       Deseja posicionar as embarcações        |");
        System.out.printf("  |        do %d° jogador automaticamente?        |%n", i + 1);
        System.out.println(" |           1 - SIM          2 - NÃO            |");
        System.out.println(" |__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
        System.out.print("#: ");

        do {
            try {
                entrada = scanner.nextInt();

                if (entrada != 1 && entrada != 2) {
                    System.out.println("#: Opção inválida, tente novamente.");
                    System.out.print("#: ");
                    entrada = 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Precisamos que digite apenas números, tente novamente.");
                System.out.print("#: ");
            }

            scanner.nextLine();
        } while (entrada == 0);

        return entrada == 1;
    }

    private boolean verificarPosicaoDisponivel(int linha, int coluna, Jogador jogador) {
        for (Embarcacao embarcacao: jogador.getEmbarcacoes()) {
            System.out.println("verificarPosicaoDisponivel => param: linha => " + linha + " - coluna => " + coluna);
            System.out.println("verificarPosicaoDisponivel => object: linha => " + embarcacao.getLinha() + " - coluna => " + embarcacao.getColuna());
            if (embarcacao.getLinha() == linha && embarcacao.getColuna() == coluna) return false;
        }

        return true;
    }

    private boolean verificarDisparoEfetuado (int linha, int coluna, Jogador jogador) {
        for (Integer[] disparo : jogador.getDisparos()) {
            if (disparo[0] == linha && disparo[1] == coluna) return true;
        }

        return false;
    }

    private void marcaEmbarcacoesTabuleiro(){
        for (Jogador jogadore : jogadores) {
            for (Embarcacao navio : jogadore.getEmbarcacoes()) {
                jogadore.getTabuleiro().updateTabuleiro(navio.getLinha(), navio.getColuna(), "N");
            }
        }
    }

    public void jogar(){
        System.out.println("\n  __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ");
        System.out.println(" |                    Jogadas                    |");
        System.out.println(" |__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|\n");

        do {
            for (int i = 0; i < jogadores.size() ; i++) {
                int inverter = i == 0 ? 1 : 0;

                Jogador jogadorAtual = jogadores.get(i), adversario = jogadores.get(inverter);

                boolean automatico = jogadorAtual.getTipojogador() == TipoJogador.COMPUTADOR || askCriarEmbarcacoesAutomaticamente(i);

                boolean controle = true;

                do {
                    int linha;
                    int coluna;

                    if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR)
                        System.out.printf("\n Posicione o %d° navio. %n", jogadorAtual.getEmbarcacoes().size() + 1);

                    if (automatico) {
                        linha = getRandomNumber(0, 10);
                        coluna = getRandomNumber(0, 10);
                    } else {
                        embarcacaoview.askPosicao();

                        linha = embarcacaoview.linha;
                        coluna = embarcacaoview.coluna;
                    }

                    if (!verificarPosicaoDisponivel(linha, coluna, jogadorAtual)) {
                        if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR)
                            System.out.println("Já existe uma embarcação nessa posição!");
                        continue;
                    }

                    if (verificarDisparoEfetuado(linha, coluna, jogadorAtual)) {
                        if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR)
                            System.out.println("Já foi realizado um disparo nessa posição. Informe outra.");
                        continue;
                    }

                    jogadorAtual.realizarDisparo(linha, coluna, adversario);

                    //marcaEmbarcacoesTabuleiro();
                    if (jogadores.get(i).getTipojogador() != TipoJogador.COMPUTADOR)
                        jogadores.get(i).getTabuleiro().showTabuleiro();
                } while (controle);

                System.out.println("Digite a coordenada do tiro!");
            }
        } while (!existePerdedor());
    }

    private boolean existePerdedor () {
        for (Jogador jogador : jogadores) {
            if (!jogador.embarcacaoDisponivel()) {
                return true;
            }
        }

        return false;
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void embarcacoesRestantes () {
        for (Jogador jogador : jogadores) {
            jogador.embarcacaoDisponivel();
        }
    }
}
