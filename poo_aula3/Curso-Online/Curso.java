package poo_aula3;

public class Curso{

    private String slogan;
    private String titulo;
    private float preco;
    private float horas;

    // Criação dos Set's
    public void setSlogan(String slogan) {
        if(slogan == null){
            System.out.println("Inválido");
        }
        this.slogan = slogan;
    }

    public void setTitulo(String titulo) {
        if(titulo.length() < 7){
            System.out.println("Inválido");
        }
        this.titulo = titulo;
    }

    public void setPreco(float preco) {
        if(preco < 0){
            System.out.println("Inválido");
        }
        this.preco = preco;
    }

    public void setHoras(float horas) {
        if(horas < 0){
            System.out.println("Inválido");
        }
        this.horas = horas;
    }

    public void addAula(String titulo, float horas){
        this.titulo = titulo;
        this.horas = horas;
    }

    // Criação dos Get's
    public String getSlogan() {
        return slogan;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getPreco() {
        return preco;
    }

}