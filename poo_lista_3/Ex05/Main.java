package Ex05;

public class Main {
    public static void main(String[] args) {
        // ── Criação das contas ────────────────────────────────────────
        ContaCorrente cc = new ContaCorrente(1, "Ana Lima", 1000.00, 120);
        ContaPoupanca cp = new ContaPoupanca(2, "Bruno Soares", 750.00);
        ContaEmpresarial ce = new ContaEmpresarial(3, "Empresa XYZ", 3000.00, 5000.00);
        

        System.out.println("Conta Poupança");
        System.out.println("\n[1] Saldo inicial:");
        cc.consultarSaldo();

        System.out.println("\n[2] Depósito de R$ 500,00:");
        cc.depositar(500.00);
        cc.consultarSaldo();

        System.out.println("\n[3] Saque de R$ 200,00 (+ R$ 120.00 de tarifa):");
        cc.sacar(200.00);
        cc.consultarSaldo();

        System.out.println("\n[4] Tentativa de saque além do saldo (R$ 2.000,00):");
        cc.sacar(2000.00);

        System.out.println("\n[5] Depósito com valor inválido (R$ -100,00):");
        cc.depositar(-100.00);


        System.out.println("Conta Poupança");
        System.out.println("\n[1] Saldo inicial:");
        cp.consultarSaldo();

        System.out.println("\n[2] Saque de R$ 200,00 (sem tarifa):");
        cp.sacar(200.00);
        cp.consultarSaldo();

        System.out.println("\n[3] Tentativa de saque além do saldo (R$ 400,00):");
        cp.sacar(400.00);

        System.out.println("\n[4] Depósito de R$ 1.000,00:");
        cp.depositar(1000.00);
        cp.consultarSaldo();

        System.out.println("\n[5] Saque com valor inválido (R$ 0):");
        cp.sacar(0);


        System.out.println("Conta Empresarial");
        System.out.println("\n[1] Situação inicial (saldo + limite):");
        ce.consultarSaldo();

        System.out.println("\n[2] Saque de R$ 3.500,00 (usa parte do limite):");
        ce.sacar(3500.00);
        ce.consultarSaldo();

        System.out.println("\n[3] Saque de R$ 4.000,00 (excede o disponível restante):");
        ce.sacar(4000.00);

        System.out.println("\n[4] Depósito de R$ 2.000,00 (recompõe saldo):");
        ce.depositar(2000.00);
        ce.consultarSaldo();

        System.out.println("\n[5] Saque exato do disponível (R$ 3.500,00):");
        ce.sacar(3500.00);
        ce.consultarSaldo();

        ContaBancaria[] contas = { cc, cp, ce };

        System.out.println();
        for (ContaBancaria conta : contas) {
            System.out.println("  Conta [" + conta.numero + "]:");
            conta.consultarSaldo();
        }
    }
}
