package poo_ex7;

public class Turma {

    private int id;
    private String nome;
    private Professor professor;

    // GETTERS
    public int getIdTurma() {
        return id;
    }
    public String getNomeTurma() {
        return nome;
    }
    
    // SETTERS
    public void setIdTurma(int id){
        if(id <= 0){
            throw new IllegalArgumentException("Id inválido");
        } else{
            this.id = id;
        }
    }

    public void setNomeTurma(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setProfessorTurma(Professor professor){
        this.professor = professor;
    }

    /**
     * CONSTRUTOR DA TURMA
     * @param id -> Identificador de Turma
     * @param nome -> Nome da Turma
     * professor começa null, porém é modificado via um setter
     */
    public Turma(int id, String nome){
        setIdTurma(id);
        setNomeTurma(nome);
    }

    @Override
    public String toString(){
        return  "Turma #" + id + 
                " | Nome: " + nome + 
                " | Professor: " + (professor != null ? professor : "Sem professor");
    }
}
