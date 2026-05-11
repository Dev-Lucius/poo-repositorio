package funcionarios;

public class FuncCompras extends Funcionario {
    
    FuncCompras() {
        super(4000);
    }

    @Override
    protected float getMultiplicadorSalario() {
        return 1.1f;
    }

    @Override
    public String getNivelHierarquico() {
        return "Funcionário de Compras";
    }
    
}