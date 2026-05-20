package Ex05;

public class ContaCorrente extends ContaBancaria{
    private double tarifaOperacao;
    
    public ContaCorrente(int numero, String titular, double saldo, double tarifaOperacao){
        super(numero, titular, saldo);
        this.tarifaOperacao = tarifaOperacao;
    }

    @Override
    public void sacar(double valor){
        if(valor > saldo){
            System.out.println("Saldo Insuficiente Para Saque");
            return;
        }

        if(tarifaOperacao <= 0){
            System.out.println("Erro. Tarifa de Operação Inválida");
            return;
        }

        System.out.println("Saque Aprovado!");
        System.out.println("Tarifa de Operação = " + tarifaOperacao);
        saldo = saldo - (valor + tarifaOperacao);
    }
}
