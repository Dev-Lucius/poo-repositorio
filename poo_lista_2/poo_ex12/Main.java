package poo_ex12;

public class Main {
    public static void main(String[] args) {

        // Objetos independentes — nenhum cria ou depende do outro
        Lampada lampada    = new Lampada("Lâmpada da Sala");
        Interruptor inter  = new Interruptor("Interruptor #1");

        System.out.println("Estado inicial: " + lampada);

        inter.acionar(lampada); // desligada → ligada
        inter.acionar(lampada); // ligada    → desligada
        inter.acionar(lampada); // desligada → ligada

        System.out.println("\nEstado final: " + lampada);
    }
}
