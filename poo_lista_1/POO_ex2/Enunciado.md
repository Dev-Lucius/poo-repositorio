# Exercício 2 — Termômetro (abstração de unidade + coesão)

## O que o aluno deve implementar

Classe ```Termometro```.

## Regras

- Temperatura inicial é 0°C.
- ```aumentar(double delta)``` só aceita delta > 0.
- ```diminuir(double delta)``` só aceita delta > 0.
- ```emCelsius()``` retorna o valor atual.
- ```emFahrenheit()``` retorna conversão (consulta, sem mudar estado).

## Main.java

```java
public class Main {
    public static void main(String[] args) {
        Termometro t = new Termometro();

        t.aumentar(10);
        t.diminuir(3);
        t.diminuir(-2); // ignora

        System.out.println("Celsius esperado = 7.0 | Atual = " + t.emCelsius());
        System.out.println("Fahrenheit esperado ~ 44.6 | Atual = " + t.emFahrenheit());
    }
}
```