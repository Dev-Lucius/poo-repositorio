package poo_ex3;

public class ItemLivro {
    private String titulo;
    private String autor;
    private int numPaginas;

    public ItemLivro(String titulo, String autor, int numPaginas){
        if(titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("Dado não Poder ser nulo");
        }

        if(autor == null || autor.trim().isEmpty()){
            throw new IllegalArgumentException("Dado não Poder ser nulo");
        }

        if(numPaginas <= 0){
            throw new IllegalArgumentException("Dado não Poder ser Negativo");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public int getNumPaginas(){
        return numPaginas;
    }

    @Override
    public String toString(){
        return "ItemLivro{titulo='" + titulo + "', autor='" + autor + "', numPaginas=" + numPaginas + "}";
    }
}
