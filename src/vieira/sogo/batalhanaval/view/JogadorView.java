package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.controller.Jogador;
import vieira.sogo.batalhanaval.domain.Embarcacao;
import vieira.sogo.batalhanaval.enums.TipoJogador;

import java.util.*;

public class JogadorView {
    Scanner scanner;
    private EmbarcacaoView embarcacaoview = new EmbarcacaoView();
    private List<Jogador> jogadores;
    private int quantidadeEmbarcacoes = 10;
    private int quantidadeJogadores = 2;

    public JogadorView() {
        this.scanner = new Scanner(System.in);
        this.jogadores = new ArrayList<>();

        TipoJogador tipoJogador = TipoJogador.HUMANO;

        String name = this.askName();

        this.jogadores.add(new Jogador(name, tipoJogador));

        this.jogadores.add(new Jogador("Computador", TipoJogador.COMPUTADOR));
    }

    public Jogador getJogador(int indice) {
        return jogadores.get(indice);
    }

    private String askName() {
        String name = "";

        System.out.printf("\nQual o nome do jogador?%n");
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
            boolean automatico = jogadores.get(i).getTipojogador() == TipoJogador.COMPUTADOR || askCriarEmbarcacoesAutomaticamente("Deseja criar embarcações automaticamente?");

            do {
                int linha;
                int coluna;

                if (jogadores.get(i).getTipojogador() != TipoJogador.COMPUTADOR)
                    System.out.printf("\n Posicione o %d° navio. %n", jogadores.get(i).getEmbarcacoes().size() + 1);

                if (automatico) {
                    linha = getRandomNumber(0, 10);
                    coluna = getRandomNumber(0, 10);
                } else {
                    embarcacaoview.askPosicao("navio");

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

    private boolean askCriarEmbarcacoesAutomaticamente (String texto) {
        int entrada = 0;

        System.out.println("  __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ");
        System.out.printf(" |%s|\n", texto);
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
            if (embarcacao.getLinha() == linha && embarcacao.getColuna() == coluna) return false;
        }

        return true;
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

        boolean playsAuto = askCriarEmbarcacoesAutomaticamente("Deseja realizar disparos automaticamente?");
        boolean automatico = false;

        do {
            for (int i = 0; i < jogadores.size() ; i++) {
                int inverter = i == 0 ? 1 : 0;

                Jogador jogadorAtual = jogadores.get(i), adversario = jogadores.get(inverter);

                if (jogadorAtual.getTipojogador() == TipoJogador.COMPUTADOR) {
                    automatico = true;
                } else {
                    automatico = playsAuto;
                }

                do {
                    int linha;
                    int coluna;

                    if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR)
                        System.out.println("Realize um disparo");

                    if (automatico) {
                        linha = getRandomNumber(0, 10);
                        coluna = getRandomNumber(0, 10);
                    } else {
                        embarcacaoview.askPosicao("disparo");

                        linha = embarcacaoview.linha;
                        coluna = embarcacaoview.coluna;
                    }

                    String jogadorValue    = jogadorAtual.getTabuleiro().getValueFromPosition(linha, coluna);
                    String adversarioValue = adversario.getTabuleiro().getValueFromPosition(linha, coluna);

                    if (
                            Objects.equals(jogadorValue, "X") ||
                            Objects.equals(jogadorValue, "n") ||
                            Objects.equals(jogadorValue, "-") ||
                            Objects.equals(jogadorValue, "*")) {
                        if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR)
                            System.out.println("Disparo já realizado nesta posição, tente novamente.");
                        continue;
                    }

                    if (Objects.equals(adversarioValue, "N") && Objects.equals(jogadorValue, "N")) {
                        if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR)
                            System.out.println("Você atingiu uma embarcação do adversário");
                        adversario.getTabuleiro().updateTabuleiro(linha, coluna, " ");
                        jogadorAtual.getTabuleiro().updateTabuleiro(linha, coluna, "X");
                        break;
                    }

                    if (Objects.equals(adversarioValue, "N")) {
                        if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR)
                            System.out.println("Você atingiu uma embarcação do adversário");
                        adversario.getTabuleiro().updateTabuleiro(linha, coluna, " ");
                        jogadorAtual.getTabuleiro().updateTabuleiro(linha, coluna, "*");
                        break;
                    }

                    if (Objects.equals(jogadorValue, "N") && Objects.equals(adversarioValue, " ")) {
                        if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR)
                            System.out.println("Nenhuma embarcação atingida");
                        jogadorAtual.getTabuleiro().updateTabuleiro(linha, coluna, "n");
                        break;
                    }

                    if (
                            Objects.equals(adversarioValue, "X") ||
                            Objects.equals(adversarioValue, "n")
                    ) {
                        if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR)
                            System.out.println("Você atingiu uma embarcação adversária");
                        adversario.getTabuleiro().updateTabuleiro(linha, coluna, " ");
                        jogadorAtual.getTabuleiro().updateTabuleiro(linha, coluna, "*");
                        break;
                    }

                    jogadorAtual.getTabuleiro().updateTabuleiro(linha, coluna, "-");

                    break;
                } while (true);

                if (jogadorAtual.getTipojogador() != TipoJogador.COMPUTADOR) {
                    jogadorAtual.getTabuleiro().showTabuleiro();
                }
            }
        } while (!existePerdedor());
    }

    private boolean existePerdedor () {
        // verificar consistência
            for (int i = 0; i < jogadores.size() ; i++) {
                int inverter = i == 0 ? 1 : 0;

                Jogador jogadorAtual = jogadores.get(i), adversario = jogadores.get(inverter);

                if (!jogadorAtual.getTabuleiro().possuiEmbarcacaoInteira()) {

                    if (jogadorAtual.getTipojogador() == TipoJogador.COMPUTADOR) {
                        jogadorAtual.getTabuleiro().showTabuleiro();
                    }

                    if (adversario.getTipojogador() == TipoJogador.COMPUTADOR) {
                        adversario.getTabuleiro().showTabuleiro();
                    }

                    System.out.printf("%s é o ganhador! %n", adversario.getName() );
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
