package funcionarios;

public class Gerente extends Funcionario {
    
    Gerente() {
        super(5000);
    }

    @Override
    protected float getMultiplicadorSalario() {
        return 1.3f;
    }

    @Override
    public String getNivelHierarquico() {
        return "Gerente";
    }
}