package poo_ex7;

import java.util.List;
import java.util.ArrayList;

public class Professor {

    private int id;
    private String nome;

    public Professor(int id, String nome){
        setIdProfessor(id);
        setNomeProfessor(nome);
        this.turmas = new ArrayList<>();
    }

    // Um professor pode ter 1 ou várias turmas
    private final List<Turma> turmas;

    // GETTERS
    public int getIdProfessor() {
        return id;
    }

    public String getNomeProfessor() {
        return nome;
    }

    public List<Turma> getTurmasProfessor() {
        return turmas;
    }


    // SETTERS
    public void setIdProfessor(int id){
        if(id <= 0){
            throw new IllegalArgumentException("Id inválido");
        } else {
            this.id = id;
        }
    }

    public void setNomeProfessor(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome inválido");
        } else {
            this.nome = nome;
        }
    }

    public void adicionarTurma(Turma turma){
        if(turma == null){
            throw new IllegalArgumentException("Turma inválida");
        } else {
            turmas.add(turma);
            turma.setProfessorTurma(this);
        }
    }

    public void acessarTurma(){
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Turma " + turmas.size() + "):");

        if(turmas.isEmpty()){
            System.out.println("Nenhuma Turma Encontrada");
        } else{

            for (Turma t : turmas) {
                System.out.println(" - " + t);
            }
        }
    }

    @Override
    public String toString(){
        return "Professor #" + id + " - " + nome;
    }
}
