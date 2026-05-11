package Biblioteca;

public class Main {
    public static void main(String[] args) {
        
        Biblioteca bib = new Biblioteca();

        // System.out.println("A BIB FOI CRIADA COM X LIVROS: " + bib.contagemLivros());

        Livro poo = new Livro("POO", "MARCIO");
        bib.addLivro(poo);
        bib.addLivro(new Livro("WEBII", "VINICIUS"));
        bib.addLivro(new Livro("BANCO", "IGOR"));

        // System.out.println("ACERVO: " + bib.contagemLivros());
        // for (Livro livro : bib.getAcervo()) {
        //     System.out.println(livro);
        // }

        Pessoa vini = new Pessoa("vini");
        bib.emprestar(poo, vini);

        System.out.println("ACERVO: " + bib.contagemLivros());
        for (Livro livro : bib.getAcervo()) {
            System.out.println(livro);
        }
    }
}