package Ex05;

public class ContaPoupanca extends ContaBancaria{
 
    public ContaPoupanca(int numero, String titular, double saldo){
        super(numero, titular, saldo);
    }

    @Override
    public void sacar(double valor){
        if(valor <= 0 || valor > saldo){
            System.out.println("Erro ao Realizar o Saque!");
            return;
        }

        System.out.println("Saque Aprovado!");
        saldo = saldo - valor;
    }
}
