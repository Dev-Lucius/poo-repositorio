package poo_ex5;

public class Main {
    public static void main(String[] args) {
        Pedido p = new Pedido();

        p.adicionarItem(new ItemPedido("Café", 8.50, 2));
        p.adicionarItem(new ItemPedido("Pão", 1.50, 6));
        p.adicionarItem(new ItemPedido("Leite", 5.60, 12));

        System.out.println("Itens esperados = 3 | Atual = " + p.quantidadeDeItens());
        System.out.println("Total esperado = 93.0 | Atual = " + p.total());
        
        // 8.50 * 2 = 17.0
        // 1.50 * 6 = 9.0
        // 5.60 * 12 = 67.2
        // total = 93
    }
}
