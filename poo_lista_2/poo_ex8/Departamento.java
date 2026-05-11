package poo_ex8;

import java.util.List;
import java.util.ArrayList;

public class Departamento {

    private int id;
    private String nome;
    // Departamento Pode ter um ou vários funcionários
    private final List<Funcionario> funcionarios;

    public Departamento(int id, String nome){
        setIdDepartamento(id);
        setNomeDepartamento(nome);
        this.funcionarios = new ArrayList<>();
    }

    // === GETTERS ===
    public int getIdDepartamento() {
        return id;
    }

    public String getNomeDepartamento() {
        return nome;
    }

    public List<Funcionario> getListDepartamento() {
        return funcionarios;
    }


    // === SETTERS === 
    public void setIdDepartamento(int id){
        if(id <= 0){
            throw new IllegalArgumentException("ID inválido");
        } else {
            this.id = id;
        }
    }

    public void setNomeDepartamento(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome inválido");
        } else{
            this.nome = nome;
        }
    }

    public void adicionarFuncionario(Funcionario funcionario){
        if(funcionario == null){
            throw new IllegalArgumentException("Funcionario inválido");
        } else {

            funcionarios.add(funcionario);
            funcionario.setDepartamentoFuncionario(this);
        }
    }

    public void acessarDepartamento(){
        System.out.println("ID" + id);
        System.out.println("Nome" + nome);
        System.out.println("Funcionários" + funcionarios.size() + "): ");

        // FOR EACH
        // Percorre cada funcionários da lista e chamar seu toString()
        if(funcionarios.isEmpty()) {
            System.out.println(" Nenhum Funcionário Cadastrado");
        } else {
            for (Funcionario f : funcionarios) {
                System.out.println("  - " + f);
            }
        }
    }

    @Override
    public String toString(){
        return  "Depto #" + id + " - " + nome + 
                "(" + funcionarios.size() + " funcionário(s))";
    }
}
