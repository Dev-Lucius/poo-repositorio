public class Main{
    public static void main(String[] args) {
        CofreDigital cofre = new CofreDigital();
        System.out.println(cofre); 

        // Testando um Método
        // int value = cofre.Saldo();
        // value = value + 200;
        // System.out.println(value);
        
        cofre.Depositar(100);
        cofre.Depositar(-10);
        System.out.println("Saldo Esperado = 100 | Saldo Atual = " + cofre.Saldo());

        boolean ok1 = cofre.Sacar(30);
        boolean ok2 = cofre.Sacar(500); // Deve Falhar
        System.out.println("Saque 3 ok? " + ok1 + " | Saque 500 ok? " + ok2);

        System.out.println("Saldo Esperado = 70 | Saldo Atual = " + cofre.Saldo());

    }
}