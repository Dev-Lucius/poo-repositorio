package poo_ex19;

public class Aluno{

    private int id;
    private String nome;
    private Disciplina disciplina;
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Aluno(int id, String nome, Disciplina disciplina){
        setId(id);
        setNome(nome);
        setDisciplina(disciplina);
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

    public void setDisciplina(Disciplina disciplina){
        if(disciplina == null){
            System.out.println("Disciplina Inválida");
        } else {
            this.disciplina = disciplina;
        }
    }

    @Override
    public String toString(){
        return  "\nAluno: " + nome + 
                "\nId: " + id + 
                "\nDisciplina: " + disciplina.getNome();
    }
}