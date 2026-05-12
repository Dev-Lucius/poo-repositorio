package Ex01;

public abstract class Funcionario {
    protected String nome;
    protected String matricula;
    protected double salarioBase;

    public Funcionario(String nome, String matricula, double salarioBase){
        this.nome = nome;
        this.matricula = matricula;
        this.salarioBase = salarioBase;
    }

    // Cada Subclasse irá implementar à sua maneira
    public abstract double calcularSalarioFinal();

    // Método Concreto --> exibirResumo
    // Usa-se o resultado de calcularSalarioFinal() sem saber COMO ele foi calculado
    public void exibirResumo(){
        System.out.println("Funcionário: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("Salário Base: " + salarioBase);
        System.out.println("Salário Final: " + calcularSalarioFinal());
    }
}
