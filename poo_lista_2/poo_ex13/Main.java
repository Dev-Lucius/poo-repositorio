package poo_ex13;

public class Main {
    public static void main(String[] args) {

        // Objetos independentes — Associação
        Loja loja = new Loja("Loja Tech");
        Carrinho carrinho = new Carrinho("João");

        System.out.println("Estado inicial:");
        System.out.println(carrinho);

        // Loja recebe o carrinho como parâmetro — não o possui
        loja.adicionarItem(carrinho, new Item("Teclado Mecânico", 350.00));
        loja.adicionarItem(carrinho, new Item("Mouse Gamer", 180.00));
        loja.adicionarItem(carrinho, new Item("Mousepad XL", 89.90));

        System.out.println("\nEstado final:");
        System.out.println(carrinho);
    }
}