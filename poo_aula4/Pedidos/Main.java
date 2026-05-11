package Pedidos;

public class Main {
    public static void main(String[] args) {

        Pedido p = new Pedido();
        Produto coca = new Produto("Coca-cola", 5.8f);
        Produto hamburger = new Produto("Hamburguer", 29.9f);
        Produto batata = new Produto("Batata", 9.9f);
        Produto combo = new Produto("COMBO HAMBURGUER + BATATA",35.9f);

        hamburger.addPercentualDesconto(20);

        p.addItem(coca,2);
        p.addItem(hamburger, 2);
        p.addItem(batata, 1);
        p.addItem(coca, 1);

        p.detalhePedido();
    }
}