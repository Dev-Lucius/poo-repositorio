# Exercício 5 — Modelagem mais real: Pedido e Item (coesão entre classes)
## O que o aluno deve implementar

ItemPedido (representa item: nome, precoUnitario, quantidade)
Pedido (agrega itens e calcula total)

## Regras

- ItemPedido:
    * quantidade >= 1
    * precoUnitario > 0
    * subtotal() = precoUnitario * quantidade

- Pedido:
    * adicionarItem(ItemPedido item)
    * total() soma subtotais
    * quantidadeDeItens() (quantos itens diferentes)

Main.java

```java
public class Main {
    public static void main(String[] args) {
        Pedido p = new Pedido();

        p.adicionarItem(new ItemPedido("Café", 8.50, 2));
        p.adicionarItem(new ItemPedido("Pão", 1.50, 6));

        System.out.println("Itens esperados = 2 | Atual = " + p.quantidadeDeItens());
        System.out.println("Total esperado = 26.0 | Atual = " + p.total());
        // 8.50*2 = 17.0
        // 1.50*6 = 9.0
        // total = 26.0
    }
}
```