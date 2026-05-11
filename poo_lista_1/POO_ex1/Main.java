package POO_ex1;

public class Main {
    public static void main(String[] args) {
        CofreDigital cofre = new CofreDigital();

        cofre.depositar(100);
        cofre.depositar(-10);  // deve ser ignorado
        System.out.println("Saldo esperado = 100 | Saldo atual = " + cofre.getSaldo());

        boolean ok1 = cofre.sacar(30);
        boolean ok2 = cofre.sacar(500); // deve falhar
        System.out.println("Saque 30 ok? " + ok1 + " | Saque 500 ok? " + ok2);

        System.out.println("Saldo esperado = 70 | Saldo atual = " + cofre.getSaldo());
    }
}
