package exemplo3;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        Painel painel = new Painel();

        JFrame janela = new JFrame();
        janela.setSize(600, 600);

        janela.add(painel);

        janela.setVisible(true);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
