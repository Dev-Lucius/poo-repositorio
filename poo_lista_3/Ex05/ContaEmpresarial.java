package Ex05;

public class ContaEmpresarial extends ContaBancaria{

    private double limiteCreditoAdic;
    
    public ContaEmpresarial(int numero, String titular, double saldo, double limiteCreditoAdic){
        super(numero, titular, saldo);
        this.limiteCreditoAdic = limiteCreditoAdic;
    }

    @Override
    public void sacar(double valor){
        if(valor <= 0){
            System.out.println("Erro. Valor Inválido");
            return;
        }
        
        if(valor > limiteCreditoAdic){
            System.out.println("Erro. Valor de Saque Excede o Limite de Crédito");
            return;
        }

        System.out.println("Saque Aprovado");
        limiteCreditoAdic = limiteCreditoAdic - valor;
        saldo = saldo - valor;
    }
}
