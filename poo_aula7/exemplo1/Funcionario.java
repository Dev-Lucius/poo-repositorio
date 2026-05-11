package exemplo1;

// DATA - ENTITIES
public class Funcionario {
    private String nome;
    private float salario;

    public Funcionario(String nome, float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Func " + this.nome + "  R$ " + this.salario;
    }
}
