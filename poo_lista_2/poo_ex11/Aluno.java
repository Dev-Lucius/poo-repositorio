package poo_ex11;

public class Aluno {
    
    private int id;
    private String nome;
    private double nota;

    public Aluno(int id, String nome, double nota){
        setId(id);
        setNome(nome);
        setNota(nota);
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

    public void setNota(double nota){
        if(nota <= 0){
            System.out.println("Nota Inválida");
        } else {
            this.nota = nota;
        }
    }
    
    @Override
    public String toString(){
        return  "Aluno: " + nome + 
                "\nID: " + id + 
                "\nNota: " + String.format("%.2f", nota); 
    }
}
