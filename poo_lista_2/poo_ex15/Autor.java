package poo_ex15;

public class Autor {

    private int id;
    private String nome;
    private String nacionalidade;
    private int anoNascimento;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public Autor(int id, String nome, String nacionalidade, int anoNascimento){
        setId(id);
        setNome(nome);
        setNacionalidade(nacionalidade);
        setAnoNascimento(anoNascimento);
    }

    public void setId(int id){
        if(id <= 0){
            System.out.println("Id Inválido");
        } else {
            this.id = id;
        }
    }

    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setNacionalidade(String nacionalidade){
        if(nacionalidade == null || nacionalidade.trim().isEmpty()){
            System.out.println("nacionalidade Inválida");
        } else {
            this.nacionalidade = nacionalidade;
        }
    }

    public void setAnoNascimento(int anoNascimento){
        if(anoNascimento <= 0){
            System.out.println("Ano Inválido");
        } else {
            this.anoNascimento = anoNascimento;
        }
    }
}
