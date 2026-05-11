package poo_ex18;

public class Main {
    public static void main(String[] args){

        Cliente c1 = new Cliente(1, "Pedro Machado");

        Produto p1 = new Produto(1, "Coca-Cola 2L", 9.89);
        Produto p2 = new Produto(2, "Bife do Vazio", 20.99);
        Produto p3 = new Produto(3, "Pão de Queijo", 7.99);

        Venda v1 = new Venda(c1, "Compras para o Churrasco de Domingo");

        v1.adicionarProduto(p1);
        v1.adicionarProduto(p2);
        v1.adicionarProduto(p3);

        System.out.println(v1);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println(c1);

        v1.listarProdutos();
    }
}
