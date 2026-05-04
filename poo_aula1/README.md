# ♨️ Programação Orientada a Objetos - Java e TypeScript

## 📑 Sumário

- 1. Conceitos e princípios de programação orientada a objetos
- 2. Abstração
- 3. Classes
- 4. Instâncias
- 5. Estado e Comportamento
- 6. Atributos
- 7. Métodos
- 8. Comandos e Consultas
- 9. Encapuslamento
- 10. Associação
- 11. Agregação
- 12. Composição
- 13. Delegação
- 14. Dependência e Acoplamento
- 15. Heranças e Polimorfismo
- 16. Noções de Princípios e Padrões de Projeto
- 17. Modelagem, Implementação e Testes

---

## 📌 O que é POO?

**A Programação Orientada a Objetos (POO)** é um **paradigma** de desenvolvimento de software **baseado na organização do código em torno de objetos**, 
os quais existem para representar entidades do mundo real ou conceitos abstratos.

Na POO, os programas são estruturados a partir de:

   - **Classes**
   - **Objetos**
   - **Atributos**
   - **Métodos**
   - **Relações entre objetos**

Esse paradigma é amplamente utilizado em linguagens como **Java** e **TypeScript**, 
sendo essencial para o desenvolvimento de sistemas robustos, escaláveis e de fácil manutenção.

---

## 🎯 Objetivos e Finalidade da POO

A POO surgiu para resolver problemas estruturais da programação procedural tradicional.
Principais objetivos:

 - Escrever códigos que perdurem por mais tempo
 - Melhorar a organização do software
 - Reduzir acoplamento
 - Facilitar manutenção e evolução
 - Promover reutilização de código
 - Aproximar o software da modelagem do mundo real

Assim, percebe-se que a POO está diretamente ligada às **boas práticas de engenharia de software**.

---

## 🧠 Princípios Fundamentais da POO

Os quatro pilares clássicos da Programação Orientada a Objetos são:

 - Abstração
 - Encapsulamento
 - Herança
 - Polimorfismo

Esses princípios estruturam a base conceitual do paradigma.

---

## 🧩 Abstração

Em suma, este conceito tratas-se da representação das características essenciais de um Objeto,
na medida em que se oculta detalhes desnecessários a fim de tornar o código **menos suscetível** a erros e mais
**reutilizável**

Exemplo conceitual:

Um ```Carro``` pode possuir:

 - Cor
 - Modelo
 - Velocidade

A abstração permite:

 - Foco no essencial
 - Redução de complexidade
 - Modelagem mais clar

---

## 🏗 Classes e Instâncias

### 📌 Classe

Uma classe trata-se do **modelo** ou **molde** que irá definir toda a estrutura e o comportamento de um objeto qualquer.

- Exemplo em Java: 

```java
public class Pessoa {
    String nome;
    int idade;
}
```

- Exemplo em TypeScript: 

```typescript
class Pessoa{
   nome: String;
   idade: number;
}
```

### 📌 Instância (Objeto)

Uma instância é um objeto que foi criado a partir de uma classe.

- Exemplo em Java

```java
Pessoa p1 = new Pessoa();
```

- Exemplo em TypeScript

```typescript
const p1 = new Pessoa();
```

--- 

## ⚙ Estado e Comportamento

Todo Objeto criado, irá possuir duas características:

- **Estado** --> É a característica definida pelos atributos do Objeto (ou Instância)
- **Comportamento** --> É a característica definida pelos Métodos do Objeto (ou Instância)

- Exemplo Simples em Java

```java
// Definindo uma Classe!
public class Conta {
   // Definindo um Estado da Classe
   double saldo;

   // Definindo um Comportamento da Classe
   void depositar(double valor) {
      saldo += valor;
    }
}
```

--- 

## 🧾 Atributos e Métodos - Resumo

### 📌 Atributos

- São variáveis que **armazenam o estado do objeto**.

### 📌 Métodos

- São funções que **definem ações que o objeto pode executar**.

- Exemplo Simples em Java

```java
public class Produto {
    // Definindo os Atributos 
    String nome;
    double preco;

    // Definindo os Métodos
    void aplicarDesconto(double percentual) {
        preco -= preco * percentual;
    }
}
```

- Além disso, na POO, **métodos podem ser classificados** como:

   * **Comandos** → Alteram o estado do objeto
   * **Consultas** → Apenas retornam informações

- Outro Exemplo Simples em Java

```java
public double getSaldo() {   // Consulta
    return saldo;
}

public void sacar(double valor) {  // Comando
    saldo -= valor;
}
```

- Esse conceito está relacionado ao princípio **CQS (Command Query Separation)**.

---

## 🔐 Encapsulamento

O Encapsulamento consiste na ação de proteger o estado interno de um Objeto, na medida em que controla 
o acesso aos seus atributos

Os principais Benefícios incluem:

 - **Proteção de dados**
 - **Controle de acesso**
 - **Maior segurança e integridade**

Exemplo Simples em Java:

```java
public class Conta {
    private double saldo;

    // Encapsulando o Saldo!
    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
}
```

--- 