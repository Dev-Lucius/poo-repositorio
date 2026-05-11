public class Pessoa{
    private String nome = "";
    private int idade = 0;
    
    // Construtor
    public Pessoa(String nome, int idade){
        setNome(nome);
        setIdade(idade);
    }
    
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome Inválido");
        } else{
            this.nome = nome;
        }
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        if(idade <= 0){
            System.out.println("Idade Inválida");
        } else {
            this.idade = idade;
        }
    }
}