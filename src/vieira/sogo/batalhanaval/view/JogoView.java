package vieira.sogo.batalhanaval.view;

public class JogoView {
    private JogadorView jogadorview;
    private EmbarcacaoView embarcacaoview;
    private TabuleiroView tabuleiroview;

    public void start() {
        this.jogadorview = new JogadorView();
        this.embarcacaoview = new EmbarcacaoView();
        this.tabuleiroview = new TabuleiroView();

    }




}
