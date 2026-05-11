package Atv_03;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria(1, "Lucas", "123.456.789-00", 0);

        System.out.println("");

        conta1.depositar(1000); // Seu Depósito de 1000.0 foi realizado com sucesso
        conta1.depositar(500); // Seu Depósito de 500.0 foi realizado com sucesso
        conta1.sacar(200); // Seu Saque de 200.0 foi realizado com sucesso

        System.out.println(conta1.consultarSaldo()); // 1300)

        System.out.println("Histórico");
        for (Transacao t : conta1.getHistorico()) {
            System.out.println(t);
        }
    }
}
