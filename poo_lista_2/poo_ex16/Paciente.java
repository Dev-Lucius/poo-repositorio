package poo_ex16;

public class Paciente {
    
    private int id;
    private String nome;
    private int idade;
    private String cpf;

    public int getId() {
        return id;
    }
    public String getNomePaciente() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public String getCpf() {
        return cpf;
    }

    public Paciente(int id, String nome, int idade, String cpf){
        setId(id);
        setNome(nome);
        setIdade(idade);
        setCpf(cpf);
    }

    public void setId(int id){
        if(id <= 0){
            System.out.println("ID inválido");
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

    public void setIdade(int idade){
        if(idade <= 0){
            System.out.println("Idade Inválida");
        } else {
            this.idade = idade;
        }
    }

    public void setCpf(String cpf){
        if(cpf == null || cpf.trim().isEmpty()){
            System.out.println("CPF Inválido");
        } else if(cpf.length() != 11){
            System.out.println("CPF de tamanho Inválido");
        } else {
            this.cpf = cpf;
        }
    }

    @Override
    public String toString(){
        return  "\n=== Paciente ===" + 
                "\nId: " + id + 
                "\nnNome: " + nome + 
                "\nIdade: " + idade + 
                "\nCPF: " + cpf;
    }
}
