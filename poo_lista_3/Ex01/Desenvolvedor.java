package Ex01;

public class Desenvolvedor extends Funcionario{
    public Desenvolvedor(String nome, String matricula, double salarioBase){
        super(nome, matricula, salarioBase);
    }

    @Override
    public double calcularSalarioFinal() {
        // +10%
        return salarioBase * 1.10; 
    }
}
