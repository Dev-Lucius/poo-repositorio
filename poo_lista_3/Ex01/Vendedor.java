package Ex01;

public class Vendedor extends Funcionario{
    private final int vendasTotais;
    
    public Vendedor(String nome, String matricula, double salarioBase, int vendasTotais){
        super(nome, matricula, salarioBase);
        this.vendasTotais = vendasTotais;
    }

    @Override
    public double calcularSalarioFinal(){
        // Comissão de 5% por venda
        return salarioBase + (vendasTotais * 1.05);
    }
}
