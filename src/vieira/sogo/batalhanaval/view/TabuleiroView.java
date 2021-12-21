package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.domain.Embarcacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TabuleiroView {
    int linha;
    int coluna;
    List<Embarcacao> embarcacoes = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public void askPosicao() {
        do {
            if (embarcacoes.size() >= 10) break;

            Embarcacao posicaoNavio = new Embarcacao(linha, coluna);
            System.out.println("Qual a posicao do navio? (Ex: A0, B5, C6)");
            String posicao = scan.next();

            Boolean flagLetter = Character.isDigit(posicao.charAt(0));
            Boolean flagNumber = Character.isDigit(posicao.charAt(1));

            if (!(!flagLetter && flagNumber)) {
                System.out.println("Valor inválido");
                askPosicao();
            }

            if (posicao.length() != 2) {
                System.out.println("Valor inválido");
                askPosicao();
            }

            this.linha = posicao.charAt(0);
            this.coluna = posicao.charAt(1);

            embarcacoes.add(posicaoNavio);

        } while (true);

    }
}
