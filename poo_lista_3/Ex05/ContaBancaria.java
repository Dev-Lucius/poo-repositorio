package Ex05;

public abstract class ContaBancaria {

    protected int numero;
    protected String titular;
    protected double saldo;
    
    // Construtor
    public ContaBancaria(int numero, String titular, double saldo){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    // Método Abstrato
    public abstract void sacar(double valor);

    // Método para Depositar
    public void depositar(double valor){
        if(valor <= 0){
            System.out.println("Não é Possível Depositar um valor igual ou Menor que 0");
        }
        saldo = saldo + valor;
    }

    // Método para Consultar o Saldo
    public void consultarSaldo(){
        System.out.println("Saldo da Conta");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }
}
