package poo_ex10;

public class ContaBancaria {
    
    private int id;
    private String titular;
    private double saldo;

    public double getSaldoContaBancaria() {
        return saldo;
    }

    public String getTitularContaBancaria() {
        return titular;
    }

    public int getIdContaBancaria(){
        return id;
    }

    public ContaBancaria(int id, String titular, double saldo){
        setIdContaBancaria(id);
        setTitulatContaBancaria(titular);
        setSaldoContaBancaria(saldo);
    }

    public void setIdContaBancaria(int id){
        if(id <= 0){
            System.out.println("ID inválido para uma Conta Bancária");
        } else{
            this.id = id;
        }
    }

    public void setTitulatContaBancaria(String titular){
        if(titular == null || titular.trim().isEmpty()){
            System.out.println("Nome Inválido para Titular da Conta");
        } else {
            this.titular = titular;
        }
    }

    public void setSaldoContaBancaria(double saldo){
        if(saldo < 0) {
            System.out.println("Saldo Inválido");
        } else {
            this.saldo = saldo;
        }
    }

    public double depositar(double v){
        if(v <= 0){
            System.out.println("Valor Inválido para De");
            return 0;

        } else {
            this.saldo = saldo + v;
        }
        return 0;
    }

    @Override
    public String toString(){
        return  "Conta de: " + titular + 
                "\nSaldo: " + String.format("%.2f", saldo);
    }
}
