# 📦 Sistema de Pedidos em Java (POO)

Este projeto é um exercício de **Programação Orientada a Objetos (POO)** em Java que simula um pequeno sistema de pedidos.
O objetivo é demonstrar conceitos fundamentais da linguagem, como **classes, objetos, encapsulamento, construtores, coleções (`List`) e validação de dados**.

---

# 🎯 Objetivo do Exercício

Implementar um sistema simples onde:

* Um **Pedido** pode conter vários **Itens de Pedido**
* Cada **ItemPedido** possui:

  * nome
  * valor unitário
  * quantidade
* O sistema deve ser capaz de:

  * adicionar itens ao pedido
  * contar quantos itens existem
  * calcular o valor total do pedido

---

# 📂 Estrutura do Projeto

```
poo_ex5
│
├── ItemPedido.java
├── Pedido.java
└── Main.java
```

| Arquivo      | Responsabilidade                               |
| ------------ | ---------------------------------------------- |
| `ItemPedido` | Representa um produto dentro de um pedido      |
| `Pedido`     | Armazena e gerencia uma lista de itens         |
| `Main`       | Executa o programa e demonstra o funcionamento |

---

# 🧠 Conceitos de Programação Orientada a Objetos

Este exercício utiliza diversos conceitos fundamentais de POO.

## 1️⃣ Classe

Uma **classe** define o modelo de um objeto.

Exemplo:

```java
public class ItemPedido
```

Ela descreve quais **atributos** e **comportamentos** o objeto terá.

---

## 2️⃣ Objeto

Um **objeto** é uma instância de uma classe.

Exemplo:

```java
ItemPedido cafe = new ItemPedido("Café", 8.50, 2);
```

Nesse caso criamos um objeto representando um item de pedido.

---

## 3️⃣ Encapsulamento

Encapsulamento consiste em **proteger os atributos do objeto**, permitindo acesso apenas através de métodos.

No código:

```java
private String nome;
private double valor;
private int quantidade;
```

Esses atributos são **privados** e só podem ser acessados através de **getters**:

```java
public String getNome()
public double getValor()
public int getQuantidade()
```

---

## 4️⃣ Construtor

O **construtor** é um método especial responsável por **inicializar o objeto**.

```java
public ItemPedido(String nome, double valor, int quantidade)
```

Ele é executado sempre que criamos um objeto usando:

```java
new ItemPedido(...)
```

---

## 5️⃣ Palavra-chave `this`

`this` refere-se à **instância atual do objeto**.

```java
this.nome = nome;
```

Significa:

```
atributo.nome = parametro.nome
```

---

# ⚠️ Validação de Dados

O construtor do `ItemPedido` valida os dados recebidos.

### Nome inválido

```java
if (nome == null || nome.isBlank())
```

Impede nomes vazios.

---

### Valor inválido

```java
if (valor <= 0)
```

O preço deve ser maior que zero.

---

### Quantidade inválida

```java
if (quantidade < 1)
```

A quantidade deve ser pelo menos 1.

---

## 🚨 Uso de Exceções

Quando um valor inválido é detectado:

```java
throw new IllegalArgumentException("mensagem");
```

Isso significa que o programa **lança uma exceção** indicando que um argumento inválido foi passado.

Exemplo de erro:

```
Exception in thread "main"
java.lang.IllegalArgumentException: nome não pode ser vazio
```

---

# 📚 Estrutura de Dados: `List`

O pedido utiliza uma lista para armazenar os itens.

```java
private List<ItemPedido> itens;
```

Essa lista guarda múltiplos objetos `ItemPedido`.

---

## 🔹 Implementação utilizada

A lista é criada utilizando `ArrayList`.

```java
itens = new ArrayList<>();
```

`ArrayList` é uma implementação de lista baseada em **array dinâmico**.

---

## 🔹 Generics

O tipo da lista é definido com **Generics**.

```java
List<ItemPedido>
```

Isso significa que a lista **aceita apenas objetos do tipo `ItemPedido`**.

---

# 🔁 Estrutura da Lista

Visualmente:

```
Pedido
 │
 ▼
List<ItemPedido>
 │
 ├── ItemPedido("Café", 8.50, 2)
 └── ItemPedido("Pão", 1.50, 6)
```

---

# ➕ Adicionando Itens ao Pedido

Método:

```java
public void adicionarItem(ItemPedido item)
```

Ele adiciona um item à lista:

```java
itens.add(item);
```

Também há uma validação para evitar itens nulos.

---

# 🔢 Contagem de Itens

O método:

```java
public int quantidadeDeItens()
```

retorna a quantidade de itens utilizando:

```java
itens.size();
```

---

# 💰 Cálculo do Total do Pedido

Método:

```java
public double total()
```

Ele percorre todos os itens da lista e soma seus subtotais.

---

## 🔁 Loop utilizado

```java
for (ItemPedido item : itens)
```

Esse é um **for-each**, usado para percorrer coleções.

---

## 🧮 Cálculo

Cada item possui um método:

```java
public double subtotal()
```

que calcula:

```
valor * quantidade
```

Exemplo:

```
Café → 8.50 * 2 = 17
Pão → 1.50 * 6 = 9
```

Total:

```
17 + 9 = 26
```

---

# ▶️ Execução do Programa

Classe principal:

```java
public class Main
```

Ponto de entrada do programa:

```java
public static void main(String[] args)
```

---

## Criando um pedido

```java
Pedido p = new Pedido();
```

---

## Adicionando itens

```java
p.adicionarItem(new ItemPedido("Café", 8.50, 2));
p.adicionarItem(new ItemPedido("Pão", 1.50, 6));
```

---

## Saída esperada

```
Itens esperados = 2 | Atual = 2
Total esperado = 26.0 | Atual = 26.0
```

---

# 📊 Fluxo do Programa

```
Main
 │
 ▼
Cria Pedido
 │
 ▼
Cria ItemPedido
 │
 ▼
Adiciona ItemPedido ao Pedido
 │
 ▼
Pedido calcula total
```

---

# 🏗 Estrutura do Sistema

```
Pedido
 │
 └── List<ItemPedido>
        │
        ├── ItemPedido
        ├── ItemPedido
        └── ItemPedido
```

---

# 🚀 Possíveis Melhorias

Este sistema pode ser expandido com funcionalidades adicionais, como:

* remover itens do pedido
* atualizar quantidade
* calcular desconto
* aplicar impostos
* gerar nota fiscal
* salvar pedidos em banco de dados

---

# 📚 Conceitos Aprendidos

Este exercício aborda:

* Classes
* Objetos
* Construtores
* Encapsulamento
* Validação de parâmetros
* Exceções
* Coleções (`List`)
* Generics
* Loops (`for-each`)
* Estrutura de um programa Java

---

# 🧑‍💻 Autor

Projeto desenvolvido como exercício de **Programação Orientada a Objetos em Java** para fins de aprendizado.

---
