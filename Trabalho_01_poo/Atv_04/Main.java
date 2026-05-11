package Atv_04;

/**
 * Classe principal para testar Biblioteca e Livro.
 *
 * CONCEITO — AGREGAÇÃO (Biblioteca x Livros):
 * Os Livros são criados fora da Biblioteca e adicionados ao acervo.
 * A Biblioteca gerencia o estado de cada livro (disponível/emprestado)
 * sem controlar o ciclo de vida dos objetos Livro.
 * Se a Biblioteca for removida, os objetos Livro continuam existindo.
 */
public class Main {
    public static void main(String[] args) {


        Biblioteca bib1 = new Biblioteca("Biblioteca Municipal");

        // -------------------------------------------------------
        // ADICIONANDO LIVROS AO ACERVO
        // CONCEITO — AGREGAÇÃO:
        // Cada Livro é criado de forma independente com "new Livro(...)"
        // e depois referenciado pela Biblioteca via AdicionarLivro().
        // O ciclo de vida do Livro não depende da Biblioteca.
        // O ID de cada livro é atribuído automaticamente pelo
        // contador estático "proximoId" da classe Livro.
        // -------------------------------------------------------
        bib1.AdicionarLivro(new Livro(1, "Dom Casmurro",      "Machado de Assis")); // ID 1
        bib1.AdicionarLivro(new Livro(2, "O Cortiço",         "Aluísio Azevedo"));  // ID 2
        bib1.AdicionarLivro(new Livro(3, "Iracema",           "José de Alencar"));  // ID 3
        bib1.AdicionarLivro(new Livro(4, "Memórias Póstumas", "Machado de Assis")); // ID 4

        // Tenta adicionar livro nulo — deve recusar (bug #2 corrigido em Biblioteca)
        bib1.AdicionarLivro(null);

        // Lista o acervo inicial — todos disponíveis
        bib1.listarLivros();

        // -------------------------------------------------------
        // EMPRÉSTIMOS
        // -------------------------------------------------------
        System.out.println("\n--- Realizando empréstimos ---");
        bib1.emprestarLivro("Dom Casmurro");  // ✅ deve emprestar
        bib1.emprestarLivro("Iracema");        // ✅ deve emprestar
        bib1.emprestarLivro("Dom Casmurro");   // ❌ já emprestado — deve recusar
        bib1.emprestarLivro("A Moreninha");    // ❌ não existe no acervo — deve recusar

        // Lista após empréstimos — Dom Casmurro e Iracema indisponíveis
        bib1.listarLivros();

        // -------------------------------------------------------
        // DEVOLUÇÕES
        // -------------------------------------------------------
        System.out.println("\n--- Realizando devoluções ---");
        bib1.devolverLivro("Dom Casmurro");  // ✅ deve devolver (bug #3 corrigido em Biblioteca)
        bib1.devolverLivro("O Cortiço");     // ❌ não estava emprestado — deve recusar

        // Lista após devolução — apenas Iracema ainda indisponível
        bib1.listarLivros();

    
        Biblioteca bib2 = new Biblioteca("Biblioteca Universitária");

        bib2.AdicionarLivro(new Livro(5, "Clean Code",               "Robert C. Martin")); // ID 5
        bib2.AdicionarLivro(new Livro(6, "The Pragmatic Programmer",  "Andrew Hunt"));      // ID 6
        bib2.AdicionarLivro(new Livro(7, "Design Patterns",          "Gang of Four"));      // ID 7

        // Lista o acervo inicial
        bib2.listarLivros();

        // Empréstimos
        System.out.println("\n--- Realizando empréstimos ---");
        bib2.emprestarLivro("Clean Code");
        bib2.emprestarLivro("Design Patterns");

        bib2.listarLivros();

        // Devoluções
        System.out.println("\n--- Devolvendo todos ---");
        bib2.devolverLivro("Clean Code");
        bib2.devolverLivro("Design Patterns");

        // Lista final — todos disponíveis novamente
        bib2.listarLivros();

        System.out.println("\n=== RESUMO FINAL ===");
        System.out.println(bib1); // chama toString() de Biblioteca
        System.out.println(bib2);
    }
}
