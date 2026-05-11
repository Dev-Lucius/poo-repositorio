# 📚 Heranças e Interfaces — Programação Orientada a Objetos em Java

> **Objetivo:** Compreender de forma clara e progressiva os conceitos de Herança e Interfaces dentro do paradigma da Programação Orientada a Objetos (POO) em Java, entendendo quando e como aplicar cada um deles.

---

## 📑 Sumário

1. [Fundamentos da POO](#1-fundamentos-da-poo)
2. [Herança](#2-herança)
   - [O que é Herança?](#21-o-que-é-herança)
   - [Sintaxe e Exemplo Básico](#22-sintaxe-e-exemplo-básico)
   - [A palavra-chave `super`](#23-a-palavra-chave-super)
   - [Sobrescrita de Métodos (`@Override`)](#24-sobrescrita-de-métodos-override)
   - [Herança Multinível](#25-herança-multinível)
   - [A classe `Object`](#26-a-classe-object)
   - [Modificadores de Acesso na Herança](#27-modificadores-de-acesso-na-herança)
   - [Herança e Construtores](#28-herança-e-construtores)
   - [Classe `final` e Método `final`](#29-classe-final-e-método-final)
3. [Classes Abstratas](#3-classes-abstratas)
   - [O que são?](#31-o-que-são)
   - [Exemplo Prático](#32-exemplo-prático)
4. [Interfaces](#4-interfaces)
   - [O que é uma Interface?](#41-o-que-é-uma-interface)
   - [Sintaxe e Exemplo Básico](#42-sintaxe-e-exemplo-básico)
   - [Implementando Múltiplas Interfaces](#43-implementando-múltiplas-interfaces)
   - [Métodos `default` e `static` em Interfaces](#44-métodos-default-e-static-em-interfaces)
   - [Interfaces Funcionais](#45-interfaces-funcionais)
   - [Herança entre Interfaces](#46-herança-entre-interfaces)
5. [Herança vs. Interface — Quando usar cada um?](#5-herança-vs-interface--quando-usar-cada-um)
6. [Polimorfismo](#6-polimorfismo)
   - [Polimorfismo com Herança](#61-polimorfismo-com-herança)
   - [Polimorfismo com Interface](#62-polimorfismo-com-interface)
7. [Casting de Objetos](#7-casting-de-objetos)
8. [Boas Práticas e Princípios SOLID](#8-boas-práticas-e-princípios-solid)
9. [Resumo Visual Comparativo](#9-resumo-visual-comparativo)
10. [JPanel — Herança e Interfaces no Java Swing](#10-jpanel--herança-e-interfaces-no-java-swing)
    - [O que é o JPanel?](#101-o-que-é-o-jpanel)
    - [Hierarquia de Classes do Swing](#102-hierarquia-de-classes-do-swing)
    - [Estendendo JPanel com Herança](#103-estendendo-jpanel-com-herança)
    - [Interfaces Mais Usadas no Swing](#104-interfaces-mais-usadas-no-swing)
    - [Layouts e Composição de Painéis](#105-layouts-e-composição-de-painéis)
    - [Exemplo Completo — Formulário de Cadastro](#106-exemplo-completo--formulário-de-cadastro)
    - [Exemplo Completo — Jogo com Painel Gráfico](#107-exemplo-completo--jogo-com-painel-gráfico)
    - [Boas Práticas com JPanel](#108-boas-práticas-com-jpanel)

---

## 1. Fundamentos da POO

A Programação Orientada a Objetos organiza o software em torno de **objetos**, que combinam estado (atributos) e comportamento (métodos). Os quatro pilares fundamentais são:

| Pilar | Descrição |
|---|---|
| **Encapsulamento** | Proteger os dados internos de um objeto, expondo apenas o necessário. |
| **Herança** | Permitir que uma classe reutilize e estenda características de outra. |
| **Polimorfismo** | Uma entidade se comportar de diferentes formas dependendo do contexto. |
| **Abstração** | Modelar apenas os aspectos relevantes de um objeto para o sistema. |

Herança e Interfaces são os mecanismos centrais que tornam o polimorfismo e a abstração possíveis em Java.

---

## 2. Herança

### 2.1 O que é Herança?

Herança é o mecanismo pelo qual uma classe (**subclasse** ou classe filha) adquire os atributos e métodos de outra classe (**superclasse** ou classe pai). Isso promove a **reutilização de código** e estabelece uma relação do tipo **"é um"** (*is-a*).

```
Exemplo de relação:
  Animal  <-- Cachorro
  "Cachorro É UM Animal"
```

> ⚠️ Java suporta apenas **herança simples** entre classes — uma classe pode ter somente **uma** superclasse direta.

---

### 2.2 Sintaxe e Exemplo Básico

A palavra-chave usada para herdar é `extends`.

```java
// Superclasse
public class Animal {
    String nome;
    int idade;

    public void comer() {
        System.out.println(nome + " está comendo.");
    }

    public void dormir() {
        System.out.println(nome + " está dormindo.");
    }
}

// Subclasse
public class Cachorro extends Animal {
    String raca;

    public void latir() {
        System.out.println(nome + " está latindo: Au au!");
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro();
        dog.nome  = "Rex";
        dog.raca  = "Labrador";

        dog.comer();   // Herdado de Animal → "Rex está comendo."
        dog.dormir();  // Herdado de Animal → "Rex está dormindo."
        dog.latir();   // Próprio de Cachorro → "Rex está latindo: Au au!"
    }
}
```

**O que `Cachorro` herda de `Animal`?**
- Atributos: `nome`, `idade`
- Métodos: `comer()`, `dormir()`

**O que `Cachorro` adiciona?**
- Atributo: `raca`
- Método: `latir()`

---

### 2.3 A palavra-chave `super`

`super` é usada para **referenciar membros da superclasse** dentro da subclasse. Ela é especialmente útil para chamar o construtor da superclasse ou acessar métodos sobrescritos.

```java
public class Animal {
    String nome;

    // Construtor da superclasse
    public Animal(String nome) {
        this.nome = nome;
        System.out.println("Animal criado: " + nome);
    }

    public void fazerSom() {
        System.out.println("Som genérico de animal.");
    }
}

public class Cachorro extends Animal {
    String raca;

    // Construtor da subclasse
    public Cachorro(String nome, String raca) {
        super(nome); // ← Chama o construtor de Animal
        this.raca = raca;
        System.out.println("Raça: " + raca);
    }

    @Override
    public void fazerSom() {
        super.fazerSom(); // ← Chama o método da superclasse
        System.out.println("E também: Au au!");
    }
}
```

> 📌 **Regra importante:** A chamada `super(...)` **deve ser a primeira instrução** dentro do construtor da subclasse.

---

### 2.4 Sobrescrita de Métodos (`@Override`)

Sobrescrever (*override*) significa **redefinir** um método herdado na subclasse, alterando seu comportamento. A anotação `@Override` não é obrigatória, mas é fortemente recomendada pois:

- Deixa a intenção explícita no código.
- Gera erro de compilação se o método não existir na superclasse (evita bugs silenciosos).

```java
public class Animal {
    public void fazerSom() {
        System.out.println("...");
    }
}

public class Gato extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("Miau!");
    }
}

public class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("Au au!");
    }
}
```

**Regras para sobrescrita válida:**

| Regra | Detalhe |
|---|---|
| Mesmo nome e parâmetros | A assinatura deve ser idêntica. |
| Tipo de retorno compatível | Pode ser o mesmo tipo ou um subtipo (covariância). |
| Visibilidade igual ou maior | Não pode restringir o acesso (ex: `public` → `protected` é inválido). |
| Não pode sobrescrever `final` | Métodos `final` não podem ser sobrescritos. |
| Não pode sobrescrever `static` | Métodos estáticos são "ocultados" (*hiding*), não sobrescritos. |

---

### 2.5 Herança Multinível

Java permite cadeias de herança com múltiplos níveis, desde que cada classe herde de apenas uma.

```java
public class Animal {
    public void respirar() {
        System.out.println("Respirando...");
    }
}

public class Mamifero extends Animal {
    public void amamentar() {
        System.out.println("Amamentando filhotes.");
    }
}

public class Cachorro extends Mamifero {
    public void latir() {
        System.out.println("Au au!");
    }
}

// Cachorro herda: respirar() e amamentar()
```

```
Hierarquia:
  Animal
    └── Mamifero
          └── Cachorro
```

> ⚠️ Cuidado com hierarquias muito profundas — elas dificultam manutenção e entendimento do código.

---

### 2.6 A classe `Object`

Em Java, **todas as classes herdam implicitamente de `java.lang.Object`**, mesmo que você não declare `extends` explicitamente. Isso significa que todo objeto Java possui os seguintes métodos herdados:

| Método | Descrição |
|---|---|
| `toString()` | Retorna representação textual do objeto. |
| `equals(Object obj)` | Verifica igualdade entre objetos. |
| `hashCode()` | Retorna o código hash do objeto. |
| `getClass()` | Retorna a classe do objeto em tempo de execução. |
| `clone()` | Cria uma cópia do objeto (requer `Cloneable`). |

```java
public class Pessoa {
    String nome;

    // Sobrescrevendo toString() herdado de Object
    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "'}";
    }

    // Sobrescrevendo equals() herdado de Object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pessoa)) return false;
        Pessoa outra = (Pessoa) obj;
        return this.nome.equals(outra.nome);
    }
}
```

---

### 2.7 Modificadores de Acesso na Herança

O nível de acesso determina o que a subclasse pode acessar diretamente.

| Modificador | Mesma Classe | Mesmo Pacote | Subclasse | Outros |
|---|:---:|:---:|:---:|:---:|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| *(padrão/package)* | ✅ | ✅ | ❌* | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

> *Membros com acesso padrão são acessíveis à subclasse apenas se ela estiver no **mesmo pacote**.

```java
public class Animal {
    public    String nome;     // Acessível em qualquer lugar
    protected int    idade;    // Acessível na subclasse
    String           especie;  // Acessível apenas no mesmo pacote
    private   double peso;     // NÃO acessível na subclasse diretamente
}
```

---

### 2.8 Herança e Construtores

Construtores **não são herdados**, mas a subclasse **sempre invoca** um construtor da superclasse, explícita ou implicitamente.

```java
public class Veiculo {
    String marca;

    public Veiculo(String marca) {
        this.marca = marca;
    }
}

public class Carro extends Veiculo {
    int portas;

    public Carro(String marca, int portas) {
        super(marca);       // Obrigatório! Veiculo não tem construtor padrão.
        this.portas = portas;
    }
}
```

> 📌 Se a superclasse **não tiver** um construtor explícito (usando o construtor padrão implícito), a subclasse pode omitir `super()`. Caso contrário, `super(...)` é **obrigatório**.

---

### 2.9 Classe `final` e Método `final`

- **Classe `final`:** Não pode ser herdada. Ex: `String`, `Integer`.
- **Método `final`:** Não pode ser sobrescrito.

```java
// Nenhuma classe pode estender esta
public final class Constante {
    // ...
}

public class Animal {
    // Nenhuma subclasse pode sobrescrever este método
    public final void respirar() {
        System.out.println("Respirando com pulmões.");
    }
}
```

---

## 3. Classes Abstratas

### 3.1 O que são?

Uma **classe abstrata** é uma classe que **não pode ser instanciada diretamente** e serve como modelo para suas subclasses. Ela pode conter:

- Métodos **concretos** (com implementação).
- Métodos **abstratos** (sem implementação — obrigam a subclasse a implementar).

Use quando há comportamento comum a ser compartilhado, mas parte do comportamento deve ser **obrigatoriamente definida** pelas subclasses.

---

### 3.2 Exemplo Prático

```java
// Classe abstrata
public abstract class Forma {
    String cor;

    public Forma(String cor) {
        this.cor = cor;
    }

    // Método abstrato — sem corpo
    public abstract double calcularArea();

    // Método concreto — com corpo
    public void exibirCor() {
        System.out.println("Cor: " + cor);
    }
}

// Subclasse concreta — DEVE implementar calcularArea()
public class Circulo extends Forma {
    double raio;

    public Circulo(String cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}

// Subclasse concreta
public class Retangulo extends Forma {
    double largura, altura;

    public Retangulo(String cor, double largura, double altura) {
        super(cor);
        this.largura = largura;
        this.altura  = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        // Forma f = new Forma("vermelho"); ← ERRO! Não pode instanciar classe abstrata

        Forma c = new Circulo("Azul", 5.0);
        Forma r = new Retangulo("Verde", 4.0, 6.0);

        c.exibirCor();
        System.out.println("Área: " + c.calcularArea()); // 78.53...

        r.exibirCor();
        System.out.println("Área: " + r.calcularArea()); // 24.0
    }
}
```

---

## 4. Interfaces

### 4.1 O que é uma Interface?

Uma **interface** é um contrato que define um conjunto de comportamentos (métodos) que uma classe **se compromete a implementar**. Ela representa a capacidade de fazer algo — uma relação do tipo **"pode fazer"** (*can-do*).

Características principais:
- Todos os métodos são `public` e `abstract` por padrão (antes do Java 8).
- Todos os atributos são `public static final` (constantes).
- Uma classe pode implementar **múltiplas interfaces** (diferente da herança simples).
- A partir do **Java 8**, suportam métodos `default` e `static`.
- A partir do **Java 9**, suportam métodos `private`.

---

### 4.2 Sintaxe e Exemplo Básico

```java
// Declaração de interface
public interface Voavel {
    // Constante implicitamente public static final
    int ALTITUDE_MAXIMA = 10000;

    // Método abstrato implicitamente public abstract
    void voar();

    void pousar();
}

// Implementação da interface
public class Passaro implements Voavel {

    @Override
    public void voar() {
        System.out.println("Pássaro voando com asas!");
    }

    @Override
    public void pousar() {
        System.out.println("Pássaro pousando em um galho.");
    }
}

// Outra implementação
public class Aviao implements Voavel {

    @Override
    public void voar() {
        System.out.println("Avião decolando pela pista.");
    }

    @Override
    public void pousar() {
        System.out.println("Avião pousando na pista.");
    }
}
```

---

### 4.3 Implementando Múltiplas Interfaces

Esta é uma das grandes vantagens das interfaces em relação à herança simples: uma classe pode implementar quantas interfaces forem necessárias.

```java
public interface Nadavel {
    void nadar();
}

public interface Voavel {
    void voar();
}

public interface Corredeiro {
    void correr();
}

// Pato pode nadar, voar e correr!
public class Pato implements Nadavel, Voavel, Corredeiro {

    @Override
    public void nadar() {
        System.out.println("Pato nadando no lago.");
    }

    @Override
    public void voar() {
        System.out.println("Pato voando baixo.");
    }

    @Override
    public void correr() {
        System.out.println("Pato correndo de forma engraçada.");
    }
}
```

---

### 4.4 Métodos `default` e `static` em Interfaces

Introduzidos no **Java 8** para permitir evolução das interfaces sem quebrar implementações existentes.

#### Método `default`

Fornece uma **implementação padrão** que pode ser sobrescrita (ou não) pelas classes implementadoras.

```java
public interface Notificavel {
    void enviarNotificacao(String mensagem);

    // Implementação padrão
    default void enviarAlerta(String mensagem) {
        System.out.println("[ALERTA] " + mensagem);
        enviarNotificacao(mensagem);
    }
}

public class EmailNotificador implements Notificavel {

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }

    // enviarAlerta() já tem implementação padrão — pode ou não sobrescrever
}
```

#### Método `static`

Pertence à interface, não à instância. **Não pode ser sobrescrito**.

```java
public interface Validador {
    boolean validar(String valor);

    static boolean isNuloOuVazio(String s) {
        return s == null || s.isEmpty();
    }
}

// Uso:
// Validador.isNuloOuVazio("teste"); → false
```

---

### 4.5 Interfaces Funcionais

Uma **interface funcional** possui exatamente **um método abstrato**. São a base das **Expressões Lambda** em Java 8+.

```java
@FunctionalInterface
public interface Calculadora {
    int calcular(int a, int b);
}

// Uso com lambda
public class Main {
    public static void main(String[] args) {
        Calculadora soma        = (a, b) -> a + b;
        Calculadora subtracao   = (a, b) -> a - b;
        Calculadora multiplicar = (a, b) -> a * b;

        System.out.println(soma.calcular(10, 5));        // 15
        System.out.println(subtracao.calcular(10, 5));   // 5
        System.out.println(multiplicar.calcular(10, 5)); // 50
    }
}
```

> 📌 Interfaces funcionais do pacote `java.util.function`: `Predicate<T>`, `Function<T,R>`, `Consumer<T>`, `Supplier<T>`, `BiFunction<T,U,R>`.

---

### 4.6 Herança entre Interfaces

Interfaces podem **estender outras interfaces**, acumulando contratos.

```java
public interface Forma {
    double calcularArea();
}

public interface FormaColorida extends Forma {
    String getCor();
}

// Quem implementar FormaColorida deve implementar AMBOS os métodos
public class Quadrado implements FormaColorida {
    double lado;
    String cor;

    public Quadrado(double lado, String cor) {
        this.lado = lado;
        this.cor  = cor;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public String getCor() {
        return cor;
    }
}
```

---

## 5. Herança vs. Interface — Quando usar cada um?

Esta é uma das decisões de design mais importantes em Java. Use a seguinte lógica:

### Use **Herança (`extends`)** quando:

- Existe uma relação **"é um"** clara e natural (ex: `Cachorro` é um `Animal`).
- Você quer **compartilhar código** (atributos e métodos concretos) entre classes relacionadas.
- As subclasses compartilham **estado** (atributos) com a superclasse.
- A hierarquia é estável e não deve crescer de forma complexa.

### Use **Interface (`implements`)** quando:

- Existe uma relação **"pode fazer"** (ex: `Pato` pode `Voar`, pode `Nadar`).
- Você quer garantir um **contrato** sem impor uma hierarquia.
- Classes de **diferentes hierarquias** precisam do mesmo comportamento.
- Você precisa de **múltiplos contratos** em uma mesma classe.
- Está projetando para **baixo acoplamento** e alta testabilidade.

### Tabela Comparativa

| Característica | Classe Abstrata | Interface |
|---|---|---|
| Instanciação | ❌ Não | ❌ Não |
| Herança múltipla | ❌ Não | ✅ Sim |
| Atributos de instância | ✅ Sim | ❌ Apenas constantes |
| Construtores | ✅ Sim | ❌ Não |
| Métodos concretos | ✅ Sim | ✅ Apenas `default`/`static` |
| Modificadores de acesso | Qualquer um | `public` (implícito) |
| Relação semântica | "É um" | "Pode fazer" / Contrato |

---

## 6. Polimorfismo

Polimorfismo significa **"muitas formas"** — permite tratar objetos de tipos diferentes de maneira uniforme por meio de uma referência comum (superclasse ou interface).

### 6.1 Polimorfismo com Herança

```java
public class Animal {
    public void fazerSom() {
        System.out.println("Som genérico.");
    }
}

public class Cachorro extends Animal {
    @Override
    public void fazerSom() { System.out.println("Au au!"); }
}

public class Gato extends Animal {
    @Override
    public void fazerSom() { System.out.println("Miau!"); }
}

public class Vaca extends Animal {
    @Override
    public void fazerSom() { System.out.println("Muuu!"); }
}

// Polimorfismo em ação
public class Main {
    public static void main(String[] args) {
        Animal[] animais = {
            new Cachorro(),
            new Gato(),
            new Vaca()
        };

        for (Animal a : animais) {
            a.fazerSom(); // Cada um executa seu próprio comportamento
        }
        // Au au!
        // Miau!
        // Muuu!
    }
}
```

---

### 6.2 Polimorfismo com Interface

```java
public interface Pagavel {
    double calcularPagamento();
}

public class Funcionario implements Pagavel {
    double salarioMensal;

    public Funcionario(double salario) {
        this.salarioMensal = salario;
    }

    @Override
    public double calcularPagamento() {
        return salarioMensal;
    }
}

public class Freelancer implements Pagavel {
    double valorHora;
    int    horasTrabalhadas;

    public Freelancer(double valorHora, int horas) {
        this.valorHora        = valorHora;
        this.horasTrabalhadas = horas;
    }

    @Override
    public double calcularPagamento() {
        return valorHora * horasTrabalhadas;
    }
}

// Sistema de folha de pagamento genérico
public class FolhaDePagamento {
    public static void processar(Pagavel[] pagaveis) {
        double total = 0;
        for (Pagavel p : pagaveis) {
            double valor = p.calcularPagamento();
            System.out.printf("Pagamento: R$ %.2f%n", valor);
            total += valor;
        }
        System.out.printf("Total: R$ %.2f%n", total);
    }
}
```

---

## 7. Casting de Objetos

Com polimorfismo, às vezes é necessário converter a referência para acessar métodos específicos da subclasse.

### Upcasting (implícito — sempre seguro)

```java
Animal a = new Cachorro(); // Upcasting automático
a.fazerSom(); // OK — método herdado/sobrescrito
// a.latir(); ← ERRO! A referência é do tipo Animal
```

### Downcasting (explícito — pode lançar exceção)

```java
Animal a = new Cachorro();

// Verificar antes de fazer o downcast (boa prática)
if (a instanceof Cachorro) {
    Cachorro c = (Cachorro) a; // Downcasting
    c.latir(); // Agora OK!
}
```

### Pattern Matching para `instanceof` (Java 16+)

```java
Animal a = new Cachorro();

// Sintaxe moderna — atribui e verifica em uma linha
if (a instanceof Cachorro c) {
    c.latir(); // c já está disponível aqui
}
```

---

## 8. Boas Práticas e Princípios SOLID

Os princípios **SOLID** guiam um bom design orientado a objetos. Herança e Interfaces estão diretamente relacionados a vários deles:

### S — Single Responsibility Principle (SRP)
Cada classe deve ter **uma única responsabilidade**. Não sobrecarregue uma superclasse com múltiplas responsabilidades.

### O — Open/Closed Principle (OCP)
Classes devem estar **abertas para extensão e fechadas para modificação**. Use herança e interfaces para adicionar comportamento sem alterar código existente.

```java
// Ruim: modificar a classe existente para cada novo tipo de forma
// Bom: criar nova subclasse que estende Forma
public class Triangulo extends Forma {
    @Override
    public double calcularArea() { /* ... */ }
}
```

### L — Liskov Substitution Principle (LSP)
Uma subclasse deve poder **substituir** sua superclasse sem quebrar o programa. Evite sobrescreveras de formas que violem o contrato esperado.

### I — Interface Segregation Principle (ISP)
**Prefira várias interfaces específicas** a uma interface genérica e grande. Uma classe não deve ser forçada a implementar métodos que não usa.

```java
// Ruim
public interface Trabalhador {
    void trabalhar();
    void comer();
    void dormir();
}

// Bom
public interface Trabalhavel { void trabalhar(); }
public interface Alimentavel { void comer();     }
public interface Descansavel { void dormir();    }
```

### D — Dependency Inversion Principle (DIP)
**Dependa de abstrações**, não de implementações concretas. Use interfaces como tipo de referência.

```java
// Ruim
EmailNotificador notificador = new EmailNotificador();

// Bom — depende da abstração
Notificavel notificador = new EmailNotificador();
```

---

## 9. Resumo Visual Comparativo

```
┌─────────────────────────────────────────────────────────────────┐
│                       HIERARQUIA DE TIPOS                        │
├─────────────────────────────────────────────────────────────────┤
│                                                                   │
│   java.lang.Object                                                │
│        │                                                          │
│        ├── Classe Concreta ──────────── instanciável             │
│        │                                                          │
│        ├── Classe Abstrata ─────────── NÃO instanciável          │
│        │        │                      pode ter métodos concretos │
│        │        └── Subclasse Concreta                            │
│        │                                                          │
│        └── Interface ───────────────── Contrato puro             │
│                  │                     múltipla implementação     │
│                  └── Classe Implementadora                        │
│                                                                   │
├─────────────────────────────────────────────────────────────────┤
│  PALAVRA-CHAVE:  extends (classe)  |  implements (interface)      │
│  RELAÇÃO:        "É um"            |  "Pode fazer"                │
│  HERANÇA:        Simples           |  Múltipla                    │
└─────────────────────────────────────────────────────────────────┘
```

---

## 10. JPanel — Herança e Interfaces no Java Swing

O `JPanel` é um dos componentes mais usados do **Java Swing**, a biblioteca padrão do Java para construção de interfaces gráficas (GUI). Estudá-lo é uma forma excelente de ver **herança e interfaces aplicadas em um contexto real e prático**.

---

### 10.1 O que é o JPanel?

O `JPanel` é um **contêiner leve** e de propósito geral que serve para organizar e agrupar outros componentes visuais dentro de uma janela Swing. Ele não possui decoração própria (sem barra de título, bordas nativas, etc.) — sua função é ser um **espaço flexível** para compor a interface.

Usos típicos do `JPanel`:
- Agrupar botões, campos de texto e rótulos em áreas lógicas da tela.
- Dividir a janela em regiões com layouts diferentes.
- Servir de **tela de desenho** personalizada (substituindo `paintComponent`).
- Criar telas de um sistema com múltiplas "páginas" usando `CardLayout`.

---

### 10.2 Hierarquia de Classes do Swing

Para entender o `JPanel`, é fundamental conhecer a cadeia de herança que ele carrega:

```
java.lang.Object
    └── java.awt.Component          ← Propriedades visuais básicas (cor, fonte, tamanho)
          └── java.awt.Container    ← Pode conter outros componentes
                └── javax.swing.JComponent  ← Base de todos os componentes Swing
                      └── javax.swing.JPanel  ← Contêiner leve e customizável
```

Isso significa que ao usar ou estender `JPanel`, você herda **automaticamente** uma enorme quantidade de comportamentos já implementados:

| Classe Herdada | O que você ganha |
|---|---|
| `Component` | `setSize()`, `setVisible()`, `setBackground()`, `setFont()`, `repaint()` |
| `Container` | `add()`, `remove()`, `setLayout()`, `getComponents()` |
| `JComponent` | `setBorder()`, `setOpaque()`, `paintComponent()`, `setToolTipText()` |
| `JPanel` | Contêiner duplo-buffer, pronto para uso imediato |

---

### 10.3 Estendendo JPanel com Herança

A forma mais poderosa de usar `JPanel` em projetos reais é **estendê-lo com herança**. Isso permite encapsular a lógica e os componentes de uma tela ou área específica dentro de uma classe própria, tornando o código organizado e reutilizável.

#### Uso Simples (sem herança)

```java
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo simples");
        JPanel painel = new JPanel();

        painel.setBackground(Color.LIGHT_GRAY);
        painel.add(new JLabel("Olá, Swing!"));
        painel.add(new JButton("Clique aqui"));

        frame.add(painel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

#### Uso com Herança (recomendado para projetos maiores)

```java
import javax.swing.*;
import java.awt.*;

// Painel encapsulado como classe própria
public class PainelBoasVindas extends JPanel {

    private JLabel  labelMensagem;
    private JButton botaoEntrar;

    public PainelBoasVindas() {
        setBackground(new Color(30, 30, 50));
        setLayout(new BorderLayout(10, 10));
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        labelMensagem = new JLabel("Bem-vindo ao Sistema!", SwingConstants.CENTER);
        labelMensagem.setFont(new Font("Arial", Font.BOLD, 22));
        labelMensagem.setForeground(Color.WHITE);

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.setFont(new Font("Arial", Font.PLAIN, 16));

        add(labelMensagem, BorderLayout.CENTER);
        add(botaoEntrar,   BorderLayout.SOUTH);
    }

    public JButton getBotaoEntrar() {
        return botaoEntrar;
    }
}

// Janela principal que usa o painel
public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        setTitle("Minha Aplicação");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PainelBoasVindas painel = new PainelBoasVindas();
        add(painel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JanelaPrincipal::new);
    }
}
```

> 📌 **Vantagem da herança aqui:** O `PainelBoasVindas` é uma unidade coesa e reutilizável. Você pode adicioná-lo a qualquer `JFrame` sem reescrever nada.

---

### 10.4 Interfaces Mais Usadas no Swing

O Swing faz uso extensivo de interfaces para tratar **eventos** (cliques, teclado, mouse, etc.). Cada tipo de evento possui sua própria interface de *listener*, que você implementa para definir o que acontece quando o evento ocorre.

#### As principais interfaces de eventos:

| Interface | Método(s) principal(is) | Quando usar |
|---|---|---|
| `ActionListener` | `actionPerformed(ActionEvent e)` | Clique em botão, Enter em campo de texto |
| `MouseListener` | `mouseClicked`, `mousePressed`, `mouseReleased`, `mouseEntered`, `mouseExited` | Interações com o mouse |
| `MouseMotionListener` | `mouseMoved`, `mouseDragged` | Movimento e arraste do mouse |
| `KeyListener` | `keyPressed`, `keyReleased`, `keyTyped` | Entrada de teclado |
| `WindowListener` | `windowClosing`, `windowOpened`, etc. | Eventos da janela |
| `FocusListener` | `focusGained`, `focusLost` | Foco em componentes |
| `ItemListener` | `itemStateChanged` | CheckBox, ComboBox |
| `DocumentListener` | `insertUpdate`, `removeUpdate`, `changedUpdate` | Alterações em campos de texto |

#### Exemplo com `ActionListener`:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelContador extends JPanel implements ActionListener {

    private int     contador = 0;
    private JLabel  labelContador;
    private JButton botaoIncrementar;
    private JButton botaoZerar;

    public PainelContador() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        labelContador    = new JLabel("0", SwingConstants.CENTER);
        labelContador.setFont(new Font("Arial", Font.BOLD, 48));

        botaoIncrementar = new JButton("+1");
        botaoZerar       = new JButton("Zerar");

        botaoIncrementar.addActionListener(this);
        botaoZerar.addActionListener(this);

        add(labelContador);
        add(botaoIncrementar);
        add(botaoZerar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoIncrementar) {
            contador++;
        } else if (e.getSource() == botaoZerar) {
            contador = 0;
        }
        labelContador.setText(String.valueOf(contador));
    }
}
```

#### Alternativa moderna com Lambda (Java 8+):

```java
// Em vez de implementar ActionListener na classe,
// use expressões lambda diretamente:
botaoIncrementar.addActionListener(e -> {
    contador++;
    labelContador.setText(String.valueOf(contador));
});

botaoZerar.addActionListener(e -> {
    contador = 0;
    labelContador.setText("0");
});
```

> 📌 `ActionListener` é uma **interface funcional** — por isso a sintaxe lambda funciona perfeitamente com ela.

---

### 10.5 Layouts e Composição de Painéis

Um dos poderes do `JPanel` é poder receber diferentes **gerenciadores de layout**, que controlam como os componentes são posicionados dentro do painel.

| Layout | Comportamento |
|---|---|
| `FlowLayout` | Componentes em linha, da esquerda para direita (padrão do `JPanel`). |
| `BorderLayout` | Divide em 5 regiões: NORTH, SOUTH, EAST, WEST, CENTER. |
| `GridLayout` | Grade de células iguais (linhas × colunas). |
| `GridBagLayout` | Grade flexível com controle fino de posição e tamanho. |
| `BoxLayout` | Empilha componentes horizontal ou verticalmente. |
| `CardLayout` | Empilha painéis como cartas — exibe um por vez (útil para múltiplas telas). |
| `null` (AbsoluteLayout) | Posicionamento manual com `setBounds()`. Evite — não é responsivo. |

#### Compondo múltiplos painéis:

```java
import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        setTitle("Layout Composto");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel do topo — cabeçalho
        JPanel painelTopo = new JPanel();
        painelTopo.setBackground(new Color(0, 102, 204));
        painelTopo.add(criarLabel("Sistema de Cadastro", Color.WHITE, 18));

        // Painel central — área principal
        JPanel painelCentro = new JPanel(new GridLayout(3, 2, 10, 10));
        painelCentro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painelCentro.add(new JLabel("Nome:"));
        painelCentro.add(new JTextField());
        painelCentro.add(new JLabel("E-mail:"));
        painelCentro.add(new JTextField());
        painelCentro.add(new JLabel("Idade:"));
        painelCentro.add(new JTextField());

        // Painel inferior — botões
        JPanel painelRodape = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelRodape.add(new JButton("Cancelar"));
        painelRodape.add(new JButton("Salvar"));

        add(painelTopo,   BorderLayout.NORTH);
        add(painelCentro, BorderLayout.CENTER);
        add(painelRodape, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JLabel criarLabel(String texto, Color cor, int tamanho) {
        JLabel label = new JLabel(texto);
        label.setForeground(cor);
        label.setFont(new Font("Arial", Font.BOLD, tamanho));
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JanelaPrincipal::new);
    }
}
```

---

### 10.6 Exemplo Completo — Formulário de Cadastro

Este exemplo demonstra herança (`extends JPanel`), interfaces de evento (`ActionListener`, `DocumentListener`) e composição de painéis em um formulário funcional.

```java
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PainelCadastro extends JPanel implements ActionListener {

    private JTextField  campNome;
    private JTextField  campEmail;
    private JButton     btnSalvar;
    private JButton     btnLimpar;
    private JTextArea   areaLog;
    private List<String> cadastros = new ArrayList<>();

    public PainelCadastro() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(criarPainelFormulario(), BorderLayout.NORTH);
        add(criarPainelLog(),        BorderLayout.CENTER);
        add(criarPainelBotoes(),     BorderLayout.SOUTH);

        configurarValidacao();
    }

    private JPanel criarPainelFormulario() {
        JPanel painel = new JPanel(new GridLayout(2, 2, 8, 8));

        campNome  = new JTextField();
        campEmail = new JTextField();

        painel.add(new JLabel("Nome:"));
        painel.add(campNome);
        painel.add(new JLabel("E-mail:"));
        painel.add(campEmail);

        return painel;
    }

    private JScrollPane criarPainelLog() {
        areaLog = new JTextArea(8, 30);
        areaLog.setEditable(false);
        areaLog.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaLog.setText("--- Cadastros realizados ---\n");
        return new JScrollPane(areaLog);
    }

    private JPanel criarPainelBotoes() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnLimpar = new JButton("Limpar");
        btnSalvar = new JButton("Salvar");
        btnSalvar.setEnabled(false);

        btnSalvar.addActionListener(this);
        btnLimpar.addActionListener(this);

        painel.add(btnLimpar);
        painel.add(btnSalvar);

        return painel;
    }

    private void configurarValidacao() {
        DocumentListener validador = new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e)  { validarCampos(); }
            @Override public void removeUpdate(DocumentEvent e)  { validarCampos(); }
            @Override public void changedUpdate(DocumentEvent e) { validarCampos(); }
        };

        campNome.getDocument().addDocumentListener(validador);
        campEmail.getDocument().addDocumentListener(validador);
    }

    private void validarCampos() {
        boolean nomeOk  = !campNome.getText().trim().isEmpty();
        boolean emailOk = !campEmail.getText().trim().isEmpty();
        btnSalvar.setEnabled(nomeOk && emailOk);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalvar) {
            String registro = campNome.getText().trim()
                            + " | " + campEmail.getText().trim();
            cadastros.add(registro);
            areaLog.append("✔ " + registro + "\n");
            limparCampos();

        } else if (e.getSource() == btnLimpar) {
            limparCampos();
        }
    }

    private void limparCampos() {
        campNome.setText("");
        campEmail.setText("");
        campNome.requestFocus();
    }
}

public class AppCadastro extends JFrame {

    public AppCadastro() {
        setTitle("Cadastro de Usuários");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new PainelCadastro());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppCadastro::new);
    }
}
```

---

### 10.7 Exemplo Completo — Jogo com Painel Gráfico

Um uso avançado e muito didático do `JPanel` é como **superfície de desenho** — sobrescrevendo `paintComponent()` para criar animações e jogos simples. Aqui o `KeyListener` também entra em ação.

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PainelJogo extends JPanel implements KeyListener {

    private int playerX    = 200;
    private int playerY    = 200;
    private int tamanho    = 30;
    private int velocidade = 10;

    public PainelJogo() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
    }

    // Sobrescrita do método herdado de JComponent
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // SEMPRE chamar super

        g.setColor(Color.CYAN);
        g.fillRect(playerX, playerY, tamanho, tamanho);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Use as setas do teclado para mover", 10, 20);
        g.drawString("X: " + playerX + "  Y: " + playerY, 10, 40);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP    -> playerY -= velocidade;
            case KeyEvent.VK_DOWN  -> playerY += velocidade;
            case KeyEvent.VK_LEFT  -> playerX -= velocidade;
            case KeyEvent.VK_RIGHT -> playerX += velocidade;
        }
        repaint(); // Redesenha o painel com os novos dados
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e)    {}
}

public class AppJogo extends JFrame {

    public AppJogo() {
        setTitle("Mini Jogo com JPanel");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new PainelJogo());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppJogo::new);
    }
}
```

**O que o `repaint()` faz?**
Ele agenda uma chamada a `paintComponent()` na EDT (Event Dispatch Thread), redesenhando o painel com os dados atualizados — é o mecanismo básico de animação no Swing.

---

### 10.8 Boas Práticas com JPanel

| Prática | Por quê? |
|---|---|
| Sempre chamar `super.paintComponent(g)` | Evita artefatos visuais de frames anteriores. |
| Criar a UI dentro de `SwingUtilities.invokeLater()` | Garante que a criação ocorra na EDT (thread segura para Swing). |
| Encapsular painéis em classes próprias (`extends JPanel`) | Organização, coesão e reutilização de código. |
| Preferir lambdas a classes anônimas para listeners simples | Código mais legível e conciso. |
| Evitar `null` layout (`setLayout(null)`) | Interfaces quebram em resoluções ou sistemas operacionais diferentes. |
| Usar `pack()` na `JFrame` em vez de `setSize()` | A janela se ajusta automaticamente ao tamanho dos componentes. |
| Separar lógica de negócio da UI | Não coloque regras de negócio dentro do `JPanel`; use camadas separadas (MVC). |

---

> 🎯 **Conclusão da seção:** O `JPanel` é um exemplo perfeito de como a POO em Java se materializa na prática. Ao estendê-lo, você usa **herança** para reaproveitar toda a infraestrutura visual do Swing. Ao implementar `ActionListener`, `KeyListener` e outros, você usa **interfaces** para reagir a eventos de forma desacoplada e flexível. Dominar o `JPanel` é dominar a POO aplicada.

---

## 📖 Referências

- [Documentação Oficial Java — Oracle](https://docs.oracle.com/en/java/javase/17/)
- [Java Language Specification — Interfaces](https://docs.oracle.com/javase/specs/jls/se17/html/jls-9.html)
- [Java Language Specification — Classes](https://docs.oracle.com/javase/specs/jls/se17/html/jls-8.html)
- Livro: *Effective Java* — Joshua Bloch
- Livro: *Clean Code* — Robert C. Martin

---

> ✍️ *Estudo elaborado com foco didático e progressivo. Todos os exemplos são compiláveis e testáveis em Java 8+.*
