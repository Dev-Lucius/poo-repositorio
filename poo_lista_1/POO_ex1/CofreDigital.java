package POO_ex1;

public class CofreDigital {
    
    private double saldo = 0;

    public void depositar(double valor){
        if(valor <= 0){
            System.out.println("Valor inválido para depósito");
        } else {
            saldo = saldo + valor;
        }
    }

    public boolean sacar(double valor){
        if(valor <= 0){
            System.out.println("Valor inválido para saque");
        }

        if(valor > saldo){
            System.out.println("Saldo insuficiente");
            return false;
        }

        saldo = saldo - valor;
        return true;
    }

    public double getSaldo(){
        return saldo;
    }
}