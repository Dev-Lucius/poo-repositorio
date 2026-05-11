package funcionarios;

public class FuncRelacionamentoCliente extends Funcionario {
    
    FuncRelacionamentoCliente() {
        super(3000);
    }

    @Override
    protected float getMultiplicadorSalario() {
        return 1.0f;
    }

    @Override
    public String getNivelHierarquico() {
        return "Funcionário de Relacionamento com Cliente";
    }
}