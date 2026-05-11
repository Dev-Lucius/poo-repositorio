package poo_ex4;

public class Funcionario {
    private String nome;
    private double salario;

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }

    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Dado Inválido");
        }
        this.nome = nome;
    }

    public void setSalario(double salario){
        if(salario <= 0){
            throw new IllegalArgumentException("Dado Inválido");
        }
        this.salario = salario;
    }

    @Override
    public String toString(){
        return "Funcionario {'nome=" + nome + "', salario='" + salario + "'}";
    }
}
