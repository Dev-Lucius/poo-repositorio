package Pedidos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pedido {
    
    /*
        hashmap é uma estrutura de dados que permite associar dois valores
        no nosso caso, representamos que cada produto tem uma quantidade associada
    */
    // private HashMap<Produto, Integer> itens;
    private List<Produto> itens;
    public Pedido() {
       // this.itens = new HashMap<Produto, Integer>();
       this.itens = new ArrayList<Produto>();
    }

    public void addItem(Produto p, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            itens.add(p);
        }
    }

    public float getTotal() {
        float total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco();
        }
        return total;
    }

    public void detalhePedido() {
        System.out.println("\n-- PEDIDO -- ");
        for (Produto produto : itens) {
            System.out.println(produto);
        }
        System.out.printf("TOTAL R$ %.2f\n", this.getTotal());
        System.out.println("-------------\n");
    }
    

}