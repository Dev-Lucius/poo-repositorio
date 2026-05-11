# ♨️ Programação Orientada a Objetos

## Sumário - Aula
- 1️⃣ Getters
- 2️⃣ Setters
- 3️⃣ Construtores
- 4️⃣ Associação Básica

## Getters e Setters

Em **Programação Orientada a Objetos**, normalmente os atributos de uma class**e não devem ficar totalmente expostos para acesso direto**. Por isso, usamos **encapsulamento**, que **consiste em proteger os dados internos do objeto e controlar a forma como eles são lidos e alterados.**

Em suma, a *prática comum é tornar os atributos private e fornecer acesso controlado* via **getters** (leitura) e **setters** (escrita). 

**Isso protege o estado interno da classe, permite validação e preserva invariantes.**

### Em suma, têm-se que:

- getter: método usado para obter/ler o valor de um atributo
- setter: método usado para alterar o valor de um atributo


### Vantagens:

- Controla quem altera/ler os dados.
- Pode validar antes de alterar (ex.: não aceitar null).
- Permite mudar a implementação interna sem afetar quem usa a classe (API estável).

### Mas Por que usar getters e setters?

Porque eles permitem:

- proteger os dados do objeto
- validar valores antes de alterar atributos
- controlar melhor as regras de negócio
- evitar alterações indevidas

### Exemplo de getters e setters em Java

```java
public class Pessoa {
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }
}
```

Uso...

```java
public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();

        p.setNome("Carlos");
        p.setIdade(25);

        System.out.println("Nome: " + p.getNome());
        System.out.println("Idade: " + p.getIdade());
    }
}
```

## Observação

**No exemplo acima, o atributo idade não pode receber valor negativo, porque o setter faz a validação.**

---

### Exemplo em TypeScript

Em TypeScript, podemos fazer de duas formas:

- com métodos tradicionais (getNome(), setNome())
- com get e set da linguagem


```typescript
class Pessoa {
  private nome: string;
  private idade: number;

  constructor(nome: string, idade: number) {
    this.nome = nome;
    this.idade = idade;
  }

  public getNome(): string {
    return this.nome;
  }

  public setNome(nome: string): void {
    this.nome = nome;
  }

  public getIdade(): number {
    return this.idade;
  }

  public setIdade(idade: number): void {
    if (idade >= 0) {
      this.idade = idade;
    }
  }
}

const p = new Pessoa("Carlos", 25);
console.log(p.getNome());
console.log(p.getIdade());
```

**Usando** ```get``` e ```set```

```typescript
class Pessoa {
  private _nome: string;
  private _idade: number;

  constructor(nome: string, idade: number) {
    this._nome = nome;
    this._idade = idade;
  }

  get nome(): string {
    return this._nome;
  }

  set nome(nome: string) {
    this._nome = nome;
  }

  get idade(): number {
    return this._idade;
  }

  set idade(idade: number) {
    if (idade >= 0) {
      this._idade = idade;
    }
  }
}

const p = new Pessoa("Ana", 30);
console.log(p.nome);
p.idade = 31;
console.log(p.idade);
```

## Construtores

O **construtor** é um **método especial usado para criar e inicializar objetos.**

Ele é executado automaticamente quando usamos ```new```.

### Objetivos de um Construtor

- Definir Valores Iniciais;
- Garantir que o objeto já nasça em estado válido;
- Facilitar a criação de objetos completo.

### Exemplo em Java

```java
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void exibirDados() {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: " + preco);
    }
}
```

**Uso** ...

```java
public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Teclado", 199.90);
        produto.exibirDados();
    }
}
```

---

### Exemplo em TypeScript

```typescript
class Produto {
  private nome: string;
  private preco: number;

  constructor(nome: string, preco: number) {
    this.nome = nome;
    this.preco = preco;
  }

  public exibirDados(): void {
    console.log(`Produto: ${this.nome}`);
    console.log(`Preço: ${this.preco}`);
  }
}

const produto = new Produto("Teclado", 199.9);
produto.exibirDados();
```

## Associação - Quando uma Classe usa Outra

A **associação** acontece quando um objeto de uma classe se relaciona com um objeto de outra classe.

Em termos simples:

> Uma classe **usa**, **conhece** ou **se relaciona** com outra

### Exemplos Conceituais

- Um ```Aluno``` pertence a um ```Curso```
- Um ```Pedido``` pertence a um ```Cliente```
- Um ```Carro``` pertence a um ```Motorista```

### Exemplo em Java

```java
public class Curso {
    private String nome;

    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
```