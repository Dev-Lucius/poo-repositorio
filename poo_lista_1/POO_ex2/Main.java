package POO_ex2;

public class Main {
    public static void main(String[] args) {
        Termometro t = new Termometro();
        Termometro t2 = new Termometro();

        t.aumentar(10);
        t.diminuir(3);
        t.diminuir(-2); // ignora
        
        t2.aumentar(50);
        t2.diminuir(25);
        System.out.println("Celsius esperado = 25.0 | Atual = " + t2.emCelsius());
        System.out.println("Fahrenheit esperado ~ 77.0 | Atual = " + t2.emFahrenheit());

        System.out.println("-----------------------------");

        System.out.println("Celsius esperado = 7.0 | Atual = " + t.emCelsius());
        System.out.println("Fahrenheit esperado ~ 44.6 | Atual = " + t.emFahrenheit());
    }
}