package Atv_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa uma Biblioteca que gerencia um acervo de Livros.
 *
 * CONCEITO — AGREGAÇÃO (Biblioteca x Livros):
 * Os Livros são criados fora da Biblioteca e apenas referenciados
 * por ela. Se a Biblioteca for removida, os objetos Livro continuam
 * existindo — ciclos de vida independentes.
 *
 * CONCEITO — ENCAPSULAMENTO:
 * A lista de livros é privada. Todas as operações sobre o acervo
 * passam pelos métodos desta classe, que garantem consistência.
 */
public class Biblioteca {

    private String nome;
    private final List<Livro> livros;
    
    /**
     * Construtor da Biblioteca.
     *
     * @param nome Nome da biblioteca. Não pode ser nulo ou vazio.
     */
    public Biblioteca(String nome) {
        setNomeBiblioteca(nome);
        this.livros = new ArrayList<>();
    }

    public void setNomeBiblioteca(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da biblioteca inválido.");
        }
        this.nome = nome.trim();
    }

    // -------------------------------------------------------
    // MÉTODOS DE GERENCIAMENTO
    // -------------------------------------------------------

    /**
     * Adiciona um Livro ao acervo.
     * @param livro Livro a ser adicionado. Não pode ser nulo.
     */
    public void AdicionarLivro(Livro livro) {
        if (livro == null) {
            System.out.println("Livro inválido: não pode ser adicionado.");
            return; /
        }

        // Evita duplicatas no acervo
        if (livros.contains(livro)) {
            System.out.println("O livro \"" + livro.getTituloLivro() + "\" já está no acervo.");
            return;
        }

        livros.add(livro);
        System.out.println("O livro \"" + livro.getTituloLivro() + "\" foi adicionado ao acervo.");
    }

    /**
     * @param titulo Título do livro a emprestar.
     */
    public void emprestarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTituloLivro().equalsIgnoreCase(titulo)) {

                // Livro encontrado — verifica se está disponível
                if (!livro.isDisponivel()) {
                    System.out.println("\"" + titulo + "\" já está emprestado.");
                    return;
                }

                livro.setDisponivel(false);
                System.out.println("\"" + titulo + "\" emprestado com sucesso.");
                return;
            }
        }
        System.out.println("\"" + titulo + "\" não foi encontrado no acervo.");
    }

    /**
     * Marca um livro como disponível (devolvido).
     * "isDisponivel() == false" significa que o livro ESTÁ emprestado
     * — ou seja, a condição bloqueava a devolução quando devia permitir.
     * A condição correta verifica se o livro JÁ está disponível,
     * pois nesse caso não há nada a devolver.
     *
     * @param titulo Título do livro a devolver.
     */
    public void devolverLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTituloLivro().equalsIgnoreCase(titulo)) {
                // Se isDisponivel() é true, o livro NÃO está emprestado — não há o que devolver
                if (livro.isDisponivel()) {
                    System.out.println("\"" + titulo + "\" não estava emprestado.");
                    return;
                }

                livro.setDisponivel(true);
                System.out.println("\"" + titulo + "\" devolvido com sucesso.");
                return;
            }
        }
        System.out.println("\"" + titulo + "\" não foi encontrado no acervo.");
    }

    /**
     * Lista todos os livros do acervo com seus status.
     */
    public void listarLivros() {
        // Variáveis locais — reiniciam a cada chamada do método
        int disponivel = 0;
        int emprestado = 0;

        System.out.println("\n=== ACERVO: " + nome + " ===");

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro presente no acervo.");
            return;
        }

        // CONCEITO — FOR-EACH:
        // Percorre cada Livro e chama seu toString() automaticamente
        for (Livro livro : livros) {
            System.out.println(livro);
            if (livro.isDisponivel()) {
                disponivel++;
            } else {
                emprestado++;
            }
        }

        System.out.println("─".repeat(60));
        System.out.println("Total: "        + livros.size());
        System.out.println("Disponíveis: "  + disponivel);
        System.out.println("Emprestados: "  + emprestado);
    }

    /**
     * Getter da lista — protegida contra modificações externas.
     *
     * CONCEITO — DEFENSIVE COPY:
     * Collections.unmodifiableList() impede que código externo
     * chame livros.add() ou livros.remove() diretamente.
     */
    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
    }


    @Override
    public String toString() {
        return "Biblioteca: "     + nome +
               " | Acervo: "      + livros.size() + " livro(s)";
    }
}
