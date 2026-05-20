package Ex06;

public abstract class Publicacao {

    protected String titulo;
    protected String autor;
    protected String textoBase;

    public Publicacao(String titulo, String autor, String textoBase){
        this.titulo = titulo;
        this.autor = autor;
        this.textoBase = textoBase;
    }

    public boolean validarPublicacao(){
        if(titulo == null || autor == null || textoBase == null){
            System.out.println("Publicação Inválida");
            return false;
        } else {
            System.out.println("Publicação Válida");
            System.out.println(gerarResumo());
            return true;
        }
    }

    public abstract String gerarResumo();

    public abstract boolean podeSerPublicada();
}
