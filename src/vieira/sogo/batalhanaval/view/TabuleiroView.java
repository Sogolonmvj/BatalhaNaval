package vieira.sogo.batalhanaval.view;

import vieira.sogo.batalhanaval.domain.Embarcacao;
import vieira.sogo.batalhanaval.domain.Tabuleiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TabuleiroView {
    public Tabuleiro tabuleiro = new Tabuleiro();

    public void show(){
        tabuleiro.showTabuleiro();
    }

}
