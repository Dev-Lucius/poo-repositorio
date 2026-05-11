# Exercício 1 — Cofre Digital (abstração de regras + coesão)

## O que o aluno deve implementar

Classe CofreDigital (coesa: responsável apenas por guardar um valor e aplicar regras de depósito/saque).
Regras (abstração)

- O cofre tem um saldo (inteiro).
- depositar(int valor) só aceita valor > 0.
- sacar(int valor) só permite se valor > 0 e valor <= saldo.
- saldo() retorna o saldo atual (consulta).

```java
Main.java (forneça pronto)

public class Main {
    public static void main(String[] args) {
        CofreDigital cofre = new CofreDigital();

        cofre.depositar(100);
        cofre.depositar(-10);  // deve ser ignorado
        System.out.println("Saldo esperado = 100 | Saldo atual = " + cofre.saldo());

        boolean ok1 = cofre.sacar(30);
        boolean ok2 = cofre.sacar(500); // deve falhar
        System.out.println("Saque 30 ok? " + ok1 + " | Saque 500 ok? " + ok2);

        System.out.println("Saldo esperado = 70 | Saldo atual = " + cofre.saldo());
    }
}
```