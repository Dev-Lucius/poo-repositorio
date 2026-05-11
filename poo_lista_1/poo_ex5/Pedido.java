package poo_ex5;

import java.util.ArrayList; // Import da classe ArrayList para usar uma lista dinâmica de itens
import java.util.List; // Import da interface List para declarar a variável de itens como uma lista
public class Pedido {

    // Criação da Lista de Itens
    // Atributo privado do tipo List<ItemPedido> chamado itens, que é uma lista de objetos do tipo ItemPedido.
    // Ou seja...
    /* Pedido
        ├── ItemPedido
        ├── ItemPedido
        └── ItemPedido
    */
   // Aqui temos uma lista de Objetos ItemPedido
   // A classe Pedido tem um atributo privado do tipo List<ItemPedido> chamado itens, que é uma lista de objetos do tipo ItemPedido.
   // Isso significa que um Pedido pode conter vários itens, e cada item é representado por um objeto do tipo ItemPedido.
    private List<ItemPedido> itens;

    // Assim, quando um pedido é criado, a lista de itens é inicializada como uma nova ArrayList, permitindo que os itens sejam adicionados posteriormente.
    public Pedido() {
        itens = new ArrayList<>();
    }

    // Criando um Método para adicionar um item ao pedido
    // O método adicionarItem() recebe um objeto do tipo ItemPedido como parâmetro e o adiciona à lista de itens do pedido.
    public void adicionarItem(ItemPedido item) {
        // Validação
        // Verificando se o item é nulo antes de adicioná-lo à lista. Se for nulo, lança uma exceção indicando que o item não pode ser nulo.
        if (item == null) {
            throw new IllegalArgumentException("item não pode ser nulo");
        }
        // Caso o contrário ... o item é adicionado à lista de itens do pedido usando o método add() da classe ArrayList.
        itens.add(item);
    }

    // Criação do Método quantidadeDeItens() e total()
    // O método quantidadeDeItens() retorna o número de itens presentes na lista de itens do pedido
    public int quantidadeDeItens() {
        return itens.size();
    }

    // O método total() calcula o valor total do pedido somando os subtotais de cada item presente na lista de itens do pedido.
    public double total() {
        double soma = 0;
        // O método subtotal() é chamado para cada item na lista de itens do pedido, e o resultado é acumulado na variável soma. Por fim, o valor total do pedido é retornado.
        for (ItemPedido item : itens) {
            soma += item.subtotal();
        }
        return soma;
    }
}
