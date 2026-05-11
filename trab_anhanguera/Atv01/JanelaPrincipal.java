package Atv01;

import javax.swing.*;
import java.awt.FlowLayout;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {

        // Título da janela
        setTitle("Aplicação Swing");

        // Tamanho da janela
        setSize(400, 200);

        // Fechar o programa ao clicar no X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout FlowLayout (componentes em linha)
        setLayout(new FlowLayout());

        // ===== COMPONENTES =====

        // JComboBox com três opções
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);

        // JCheckBox (desmarcado por padrão)
        JCheckBox checkBox = new JCheckBox("Aceitar termos");

        // JTextField com tamanho adequado
        JTextField campoTexto = new JTextField(15);

        // Botões (sem funcionalidade)
        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoSair = new JButton("Sair");

        // ===== ADICIONANDO COMPONENTES =====
        add(comboBox);
        add(checkBox);
        add(campoTexto);
        add(botaoSalvar);
        add(botaoSair);

        // Centralizar janela
        setLocationRelativeTo(null);

        // Tornar visível
        setVisible(true);
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }
}