# ☕ Programação Orientada a Objetos — Java

> Anotações de aula sobre os fundamentos de POO em Java.

---

## 📌 O que é POO?

**Programação Orientada a Objetos (POO)** é um paradigma de programação cujo objetivo é **mapear o comportamento do mundo real** por meio de classes e objetos.

---

## 🧱 Classes e Objetos - Revisão

### Classe
Uma classe é um **modelo/template** que define como os objetos se comportam. Ela é composta por:

- **Atributos** — características/propriedades do objeto
- **Métodos** — comportamentos/ações que o objeto pode realizar

```java
public class Carro {
    // Atributos
    String marca;
    String modelo;
    int ano;

    // Método
    public void acelerar() {
        System.out.println("O carro está acelerando!");
    }
}
```

### Objeto
Um objeto é a **instância concreta de uma classe** — ou seja, é a classe "ganhando vida" na memória do programa.

```java
Carro meuCarro = new Carro(); // meuCarro é um objeto da classe Carro
meuCarro.marca = "Toyota";
meuCarro.acelerar();
```

---

## 🔄 POO vs Entidades de Dados

| | POO | Entidades de Dados |
|---|---|---|
| **O que é** | Paradigma de programação | Modelo de armazenamento de dados |
| **Foco** | Comportamento das classes | Estrutura e persistência de dados |
| **Exemplo** | Classe `Carro` com métodos | Tabela `carros` no banco de dados |

---

## 🔗 Associação de Classes

Associação é o **relacionamento entre classes**. Existem três formas principais:

---

### 1. 🤝 Associação
As classes **existem de forma independente**, mas estão relacionadas entre si.

> Nenhuma depende da existência da outra para existir.

**Exemplos:**
- `Carro` e `Motorista` — o carro existe sem o motorista, mas o motorista pode dirigir o carro
- `Professor` e `Turma` — o professor existe sem a turma, mas pode ensiná-la

```
Motorista ──────── Carro
  (dirige)
```

---

### 2. 🏠 Composição
As classes estão **fortemente ligadas**: uma é parte integrante da outra. Se a classe principal for deletada, as classes que a compõem **também são deletadas**.

> Relação do tipo "todo–parte" com ciclo de vida compartilhado.

**Exemplos:**
- `Casa` e `Cômodos` — se a casa for deletada, os cômodos também serão
- `Empresa` e `Filiais` — se a empresa for deletada, as filiais também serão

```
Casa ◆────── Cômodo
  (contém, ciclo de vida compartilhado)
```

---

### 3. 📦 Agregação
As classes estão **relacionadas**, mas não dependem uma da outra para existir. Se a classe principal for deletada, as classes relacionadas **continuam existindo**.

> Relação do tipo "todo–parte" com ciclo de vida independente.

**Exemplos:**
- `Carro` e `Peças do Carro` — se o carro for deletado, as peças continuam existindo

```
Carro ◇────── Peça
  (utiliza, mas não controla o ciclo de vida)
```

---

## 🗺️ Resumo Visual

```
                    ASSOCIAÇÃO DE CLASSES
                           │
          ┌────────────────┼────────────────┐
          │                │                │
     Associação       Composição        Agregação
   (independentes,  (parte integrante, (relacionadas,
    relacionadas)    ciclos ligados)   ciclos livres)
```

---

## 📚 Referências

- [Documentação oficial Java — Oracle](https://docs.oracle.com/en/java/)
- [OOP Concepts — W3Schools Java](https://www.w3schools.com/java/java_oop.asp)

---

*Anotações feitas durante as aulas de POO em Java* ✏️