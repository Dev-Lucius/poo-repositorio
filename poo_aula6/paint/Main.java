package paint;

import java.util.List;

import javax.swing.JFrame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        List<Forma> formas = new ArrayList<>();
        formas.add(new Quadrado(java.awt.Color.RED, 100, 100, 50));
        formas.add(new Quadrado(java.awt.Color.GREEN, 180, 100, 50));
        formas.add(new Quadrado(java.awt.Color.BLUE, 260, 100, 50));

        formas.add(new Circulo(205, 200, 25));

        JFrame tela = new JFrame();
        tela.setTitle("Paint");
        tela.setSize(400, 400);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tela.add(new Painel(formas));
        
        tela.setVisible(true);
    }
}