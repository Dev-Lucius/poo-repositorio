package poo_ex17;

public class Tecnico{

    private int id;
    private String nome;
    private int idade;
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Tecnico(int id, String nome, int idade){
        setId(id);
        setNome(nome);
        setIdade(idade);
    }

    public void setId(int id){
        if(id <= 0){
            System.out.println("ID Inválida");
        } else{
            this.id = id;
        }
    }

    public void setNome(String nome){
        if(nome.trim().isEmpty() || nome == null){
            System.out.println("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setIdade(int idade){
        if(idade <= 0){
            System.out.println("Idade Inválida");
        } else{
            this.idade = idade;
        }
    }

    @Override
    public String toString(){
        return  "\nTécnico: " + nome + 
                "\nIdade: " + idade;
    }
}