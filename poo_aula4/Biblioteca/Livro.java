package Biblioteca;
public class Livro {

    private String titulo;
    private String autor;

    private Pessoa emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;    
        this.emprestado = null;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    // EXERCICIO - REMOVER O INDICAR EMPRESTIMO DO LIVRO PARA PROTEGER O COMPORTAMENTO.
    public void indicarEmprestimo(Pessoa p) {
        if (this.emprestado == null)
            this.emprestado = p;
    }

    public void indicarDevolucao() {
        this.emprestado = null;
    }

    // sobrescrita
    @Override
    public String toString() {
        return (this.emprestado == null ? "[DISPONIVEL] " : "[EMPRESTADO] ") +
         this.titulo + " - " + this.autor;
    }
}