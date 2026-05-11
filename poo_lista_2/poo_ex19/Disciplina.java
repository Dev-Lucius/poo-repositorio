package poo_ex19;

public class Disciplina {

    private String nome;
    private Professor professor;

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina(String nome, Professor professor){
        setNome(nome);
        setProfessor(professor);
    }

    public void setNome(String nome){
        if(nome.trim().isEmpty() || nome == null){
            System.out.println("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setProfessor(Professor professor){
        if(professor == null){
            System.out.println("Professor Inválido");
        } else {
            this.professor = professor;
        }
    }

    @Override
    public String toString(){
        return  "\nDisciplina: " + nome + 
                "\nProfessor: " + professor.getNome();
    }
}
