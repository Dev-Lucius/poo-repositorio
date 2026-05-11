package poo_ex10;

public class Main {
    public static void main(String[] args) {

        // Objetos criados de forma independente — Associação
        ContaBancaria conta = new ContaBancaria(1, "Maria", 500.0);
        CaixaEletronico caixa = new CaixaEletronico("Caixa #01 - Agência Centro");

        System.out.println("Antes: " + conta);

        // CaixaEletronico recebe a conta como parâmetro — não a possui
        caixa.realizarDeposito(conta, 250.0);

        System.out.println("Depois: " + conta);
    }
}
