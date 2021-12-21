package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.domain.Embarcacao;

import java.util.Scanner;

public class EmbarcacaoView {
    Scanner scanner;
    private Embarcacao[] embarcacao1 = new Embarcacao[10];
    private Embarcacao[] embarcacao2 = new Embarcacao[10];

    public EmbarcacaoView() {
        this.scanner = new Scanner(System.in);

        for (int i = 0; i < 10 ; i++) {
            int linha = this.askLinha();
            int coluna = this.askColuna();
            this.embarcacao1[i] = new Embarcacao(linha, coluna);
        }
    }

    private int askColuna() {
        System.out.println("Qual indice da linha?");
        System.out.println("#: ");
        int indice = scanner.nextInt();
        if (indice <= 0 && indice >= 9) {
            System.out.println("Indice inválido!");
            indice = askColuna();
        }
        return indice;
    }

    private int askLinha() {
        String[] indicecoluna = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.println("Qual indice do coluna?");
        System.out.println("#: ");
        String letra = scanner.nextLine();
        int indice = 0;
        if (letra.isBlank()) {
            System.out.println("Indice inválido!");
            indice = askLinha();
        }else{
            switch(letra) {
                case "A":
                    indice = 0;
                    break;
                case "B":
                    indice = 1;
                    break;
                case "C":
                    indice = 2;
                    break;
                case "D":
                    indice = 3;
                    break;
                case "E":
                    indice = 4;
                    break;
                case "F":
                    indice = 5;
                    break;
                case "G":
                    indice = 6;
                    break;
                case "H":
                    indice = 7;
                    break;
                case "I":
                    indice = 8;
                    break;
                case "J":
                    indice = 9;
                    break;
            }
        }
        return indice;
    }
}
