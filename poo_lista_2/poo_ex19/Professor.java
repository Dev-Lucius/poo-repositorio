package poo_ex19;

public class Professor {

    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Professor(int id, String nome){
        setId(id);
        setNome(nome);
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

    @Override
    public String toString(){
        return  "\nProfessor: " + nome + 
                "\nId: " + id;
    }
}
