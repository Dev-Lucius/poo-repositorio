package funcionarios;

// classe abstrata - classe que nao pode ser instanciada
// ela serve apenas para ser herdada por outras classes
abstract class Funcionario {

    // metodos abstratos - sao metodos que obrigatoriamente precisam ser implementados pelas classes filhas / concretas
    public abstract String getNivelHierarquico();
    
    private float salarioBase;

    protected abstract float getMultiplicadorSalario();

    Funcionario(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public float salarioCalculado() {
        return salarioBase * getMultiplicadorSalario();
    }
}