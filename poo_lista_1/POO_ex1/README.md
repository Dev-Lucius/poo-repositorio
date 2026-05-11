# 💰 CofreDigital - Exercício de Programação Orientada a Objetos (Java)

## 📚 Descrição

Este exercício tem como objetivo aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** em Java através da implementação de um **cofre digital simples**.

O sistema permite realizar operações básicas como:

* Depositar valores
* Sacar valores
* Consultar saldo

Além disso, são aplicadas **validações de regras de negócio**, como impedir depósitos ou saques com valores inválidos.

---

# 🧠 Conceitos de POO Utilizados

Este exercício trabalha diversos conceitos importantes:

### Encapsulamento

O saldo do cofre é um atributo **privado**, impedindo acesso direto externo.

```java
private double saldo = 0;
```

O acesso ao saldo ocorre apenas através de métodos públicos.

---

### Métodos

A classe possui três métodos principais:

| Método                    | Função                  |
| ------------------------- | ----------------------- |
| `depositar(double valor)` | Adiciona valor ao saldo |
| `sacar(double valor)`     | Retira valor do saldo   |
| `getSaldo()`              | Retorna o saldo atual   |

---

### Validação de Dados

O sistema impede valores inválidos utilizando **exceções**:

```java
throw new IllegalArgumentException("Valor Inválido");
```

Isso evita que operações incorretas sejam realizadas.

---

# 🏗 Estrutura do Projeto

```
POO_ex1
│
├── CofreDigital.java
└── Main.java
```

---

# 📦 Classe CofreDigital

Responsável por representar o **cofre digital** e suas operações.

## Atributo

```java
private double saldo = 0;
```

Armazena o valor atual disponível no cofre.

---

## Método `depositar`

Realiza depósitos no cofre.

```java
public void depositar(double valor)
```

### Regras

* O valor deve ser **maior que 0**
* Caso contrário, uma exceção é lançada

```java
if(valor <= 0){
    throw new IllegalArgumentException("Valor Inválido para Depósitos");
}
```

---

## Método `sacar`

Permite retirar dinheiro do cofre.

```java
public boolean sacar(double valor)
```

### Regras

* O valor deve ser maior que **0**
* O valor **não pode ser maior que o saldo**

Se o saque não for possível, o método retorna:

```java
false
```

Se o saque for realizado:

```java
true
```

---

## Método `getSaldo`

Retorna o saldo atual armazenado no cofre.

```java
public double getSaldo()
```

---

# 🚀 Classe Main

A classe `Main` é responsável por **testar o funcionamento do cofre digital**.

## Código

```java
public class Main {
    public static void main(String[] args) {
        CofreDigital cofre = new CofreDigital();

        cofre.depositar(100);
        cofre.depositar(-10);

        System.out.println("Saldo esperado = 100 | Saldo atual = " + cofre.getSaldo());

        boolean ok1 = cofre.sacar(30);
        boolean ok2 = cofre.sacar(500);

        System.out.println("Saque 30 ok? " + ok1 + " | Saque 500 ok? " + ok2);

        System.out.println("Saldo esperado = 70 | Saldo atual = " + cofre.getSaldo());
    }
}
```

---

# ⚠️ Observação Importante

Ao tentar executar:

```java
cofre.depositar(-10);
```

O método **lançará uma exceção**, pois valores negativos não são permitidos.

Isso interrompe a execução do programa se a exceção não for tratada.

Uma forma de tratar isso seria utilizando:

```java
try {
    cofre.depositar(-10);
} catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
}
```

---

# ▶️ Exemplo de Saída

```
Saldo esperado = 100 | Saldo atual = 100
Saque 30 ok? true | Saque 500 ok? false
Saldo esperado = 70 | Saldo atual = 70
```

---

# 📈 Possíveis Melhorias

Algumas melhorias que poderiam ser aplicadas ao projeto:

* Utilizar **BigDecimal** para evitar problemas de precisão com dinheiro
* Criar **testes automatizados**
* Implementar histórico de transações
* Criar interface gráfica ou API
* Adicionar limite de saque

---

# 🎯 Objetivo do Exercício

Este exercício ajuda a praticar:

* Encapsulamento
* Criação de classes
* Manipulação de atributos
* Validação de regras de negócio
* Uso de exceções
* Estrutura básica de um programa Java

---

# 👨‍💻 Autor

Projeto desenvolvido para fins de estudo em **Programação Orientada a Objetos com Java**.
