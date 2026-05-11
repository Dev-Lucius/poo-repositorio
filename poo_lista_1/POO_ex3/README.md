# Exercício 3 — Controle de Estoque

## Objetivo

Implementar uma classe `EstoqueProduto` que gerencia o controle de entrada e saída de produtos em estoque, aplicando conceitos de **coesão por responsabilidade**.

## Requisitos

### Atributos
- `nome`: String que identifica o produto
- `quantidade`: int que armazena a quantidade atual em estoque

### Métodos

#### Construtores
- `EstoqueProduto(String nome, int quantidade)`: Inicializa o produto com nome e quantidade inicial

#### Operações de Estoque
- `entrada(int qtd)`: Adiciona quantidade ao estoque
  - ✓ Aceita apenas valores > 0
  - ✗ Valor inválido: imprime mensagem de erro
  
- `saida(int qtd)`: Remove quantidade do estoque
  - ✓ Aceita apenas valores > 0 e <= quantidade atual
  - ✗ Valor inválido ou insuficiente: imprime mensagem de erro e retorna `false`
  - ✓ Operação bem-sucedida: retorna `true`

#### Consultas
- `nome()`: Retorna o nome do produto
- `quantidadeAtual()`: Retorna a quantidade atual em estoque

## Construtores em Java

### O que é um Construtor?

Um **construtor** é um método especial de uma classe que é executado automaticamente quando um objeto é criado. Ele é responsável por **inicializar os atributos** do objeto.

### Características dos Construtores

1. **Mesmo nome da classe**: O construtor sempre tem o mesmo nome da classe
2. **Sem tipo de retorno**: Não possuem `void` ou qualquer outro tipo de retorno
3. **Executado automaticamente**: É chamado quando você usa `new`
4. **Pode ser sobrecarregado**: A classe pode ter múltiplos construtores com diferentes parâmetros

### Sintaxe Geral

```java
public NomeDaClasse(parâmetros) {
    // Inicialização dos atributos
    this.atributo = parâmetro;
}
```

### Exemplo no Exercício

```java
public EstoqueProduto(String nome, int quantidade) {
    this.nome = nome;
    this.quantidade = quantidade;
}
```

Quando você cria um objeto:
```java
EstoqueProduto e = new EstoqueProduto("Arroz", 10);
```

O construtor é chamado automaticamente e:
- `nome` recebe `"Arroz"`
- `quantidade` recebe `10`

### Por que usar Construtores?

| Aspecto | Descrição |
|---------|-----------|
| **Segurança** | Garante que o objeto esteja em um estado válido desde sua criação |
| **Conveniência** | Evita ter que chamar múltiplos métodos setter manualmente |
| **Clareza** | Deixa explícito quais dados são necessários para criar um objeto |
| **Validação** | Pode validar os parâmetros antes de inicializar os atributos |

### Palavra-chave `this`

A palavra-chave `this` refere-se à instância atual do objeto:

```java
public EstoqueProduto(String nome, int quantidade) {
    this.nome = nome;       // this.nome = atributo da classe
    this.quantidade = quantidade;  // quantidade = parâmetro
}
```

Isso evita ambiguidade quando o nome do parâmetro é igual ao nome do atributo.

## Exemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        EstoqueProduto e = new EstoqueProduto("Arroz", 10);

        e.entrada(5);                    // Estoque: 10 + 5 = 15
        boolean ok = e.saida(12);        // Estoque: 15 - 12 = 3 ✓ (retorna true)
        boolean falha = e.saida(10);     // Falha: só tem 3 em estoque ✗ (retorna false)

        System.out.println("Ok esperado = true | Atual = " + ok);
        System.out.println("Falha esperado = false | Atual = " + falha);
        System.out.println("Qtd esperada = 3 | Atual = " + e.quantidadeAtual());
        System.out.println("Nome esperado = Arroz | Atual = " + e.nome());
    }
}
```

## Conceitos Aplicados

- **Encapsulamento**: Atributos privados com acesso através de métodos públicos
- **Coesão por Responsabilidade**: A classe tem uma única responsabilidade: gerenciar o estoque de um produto
- **Validação de Dados**: Rejeição de operações inválidas com mensagens apropriadas
- **Retorno de Status**: O método `saida()` retorna um booleano para indicar sucesso/falha


