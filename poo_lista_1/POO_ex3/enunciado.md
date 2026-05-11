# Exercício 3 — Controle de Estoque (coesão por responsabilidade)
## O que o aluno deve implementar

Classe ```EstoqueProduto```.

## Regras

- Produto tem: ``nome`` e ``quantidade``.
- ``entrada(int qtd)`` só aceita qtd > 0.
- ``saida(int qtd)`` só aceita qtd > 0 e qtd <= quantidade.
- ``quantidadeAtual()`` consulta.
- ``nome()`` consulta.

## Main.java

```java
public class Main {
    public static void main(String[] args) {
        EstoqueProduto e = new EstoqueProduto("Arroz", 10);

        e.entrada(5);
        boolean ok = e.saida(12); // deve ser true (10+5-12=3)
        boolean falha = e.saida(10); // deve ser false (só tem 3)

        System.out.println("Ok esperado = true | Atual = " + ok);
        System.out.println("Falha esperado = false | Atual = " + falha);
        System.out.println("Qtd esperada = 3 | Atual = " + e.quantidadeAtual());
        System.out.println("Nome esperado = Arroz | Atual = " + e.nome());
    }
}
```