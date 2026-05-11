package funcionarios;

public class Diretor extends Funcionario{
    
    Diretor(){
        super(9000);
    }

    @Override
    public float getMultiplicadorSalario(){
        return 1.5f;
    }

    @Override
    public String getNivelHierarquico(){
        return "Diretor";
    }
}