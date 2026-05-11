# ♨️ Programação Orientada a Objetos (POO)

## 📖 O que é Associação de Classes em POO

**Associação** ocorre quando uma determinada **classe utiliza ou possui referência a outra classe**.

Em suma:
>**Um objeto precisa de outro objeto para funcionar ou representar uma relação do mundo real.**

Exemplos do Mundo Real:

* Um Carro tem um Motor 
* Um Pedido possui um Cliente 
* Um Professor Ensina um Aluno 

Em java isso ocorre quando uma classe possui um atributo do tipo de outra classe

```java
class Carro {
    Motor motor;
}
```

>Aqui ```Carro``` **Está associado** a ```Motor``` 

## 🎯 Tipos de Associação em POO

Assim, percebe-se que existem 3 principais tipos de associação

- 1️⃣ Associação Simples
- 2️⃣ Agregação
- 3️⃣ Composição

Esses conceitos aparecem muito em:

- UML
- Modelagem de sistemas
- Provas de faculdade
- Entrevistas técnicas

### 🛠 Associação Simples

É a forma **mais básica de relacionamento entre classes.**

>Um objeto conhece ou usa outro objeto, mas não depende totalmente dele para existir.

Exemplo

- Aluno e Curso
- Um aluno pode, ou não, estar matriculado em um curso

Implementação em Java

```java
class Curso {
    String nome;
}

class Aluno {
    String nome;
    Curso curso;
}
```

---

```java
public class Main {
    public static void main(String[] args) {

        Curso curso = new Curso();
        curso.nome = "Análise e Desenvolvimento de Sistemas";

        Aluno aluno = new Aluno();
        aluno.nome = "Lucas";
        aluno.curso = curso;

        System.out.println(aluno.nome + " está no curso " + aluno.curso.nome);
    }
}
```

--- 

```terminal
Lucas está no curso Análise e Desenvolvimento de Sistemas
```
**📌 Ideia central:**
>A classe Aluno possui uma referência para Curso.

**📌 Multiplicidade da Associação**
>Define quantos objetos podem participar da relação.

| Relação | Significado        |
| ------- | ------------------ |
| 1 → 1   | Um para um         |
| 1 → N   | Um para muitos     |
| N → N   | Muitos para muitos |


- Exemplo 1 → N

    - Um Professor Pode ter vários alunos

    ```java
    import java.util.ArrayList;

    class Professor {
        String nome;
        ArrayList<Aluno> alunos = new ArrayList<>();
    }

    class Aluno {
        String nome;
    }
    ```

    ---

    ```java
    Professor prof = new Professor();
    prof.nome = "Carlos";

    Aluno a1 = new Aluno();
    a1.nome = "Lucas";

    Aluno a2 = new Aluno();
    a2.nome = "Ana";

    prof.alunos.add(a1);
    prof.alunos.add(a2);
    ```

### 🛠 Agregação

A agragação é um tipo de associação na qual:

>Uma classe possui outra, mas a parte pode existir separadamente.

Relação **"tem um" (has-a)**

Exemplo:

- Um departamento tem Professores
- Mas, professores podem existir sem o departamento

Implementação em Java

```java
class Professor {
    String nome;
}

class Departamento {

    String nome;
    Professor professor;

}
```

---

```java
Professor prof = new Professor();
prof.nome = "Lucas";

Departamento dep = new Departamento();
dep.nome = "TI";
dep.professor = prof;
```

**📌 O professor não depende do departamento para existir.**


### 🛠 Composição

Composição trata-se de uma **Associação Forte**

Isso significa que:

> A classe **parte não pode existir sem a classe todo**

Em suma, se o objeto principal for excluído, os objetos internos também serão

Exemplo clássico:

- Casa tem Cômodos
- Carro tem Motor

Exemplo em Código:

```java
class Motor {

    int potencia;

    Motor(int potencia){
        this.potencia = potencia;
    }
}

class Carro {

    Motor motor;

    Carro(){
        motor = new Motor(150);
    }
}
```

Aqui 

- O ``Motor`` é criado dentro do Carro`
- Não existe fora dele

Uso:

```java
Carro carro = new Carro();
System.out.println(carro.motor.potencia);
```

### Comparação Visual

| Tipo       | Dependência | Exemplo                  |
| ---------- | ----------- | ------------------------ |
| Associação | fraca       | Aluno → Curso            |
| Agregação  | média       | Departamento → Professor |
| Composição | forte       | Carro → Motor            |


## 🔎 Reconhecendo cada Tipo

### Associação

Objetos **apenas usa outro**

```java
class Pedido {
    Cliente cliente;
}
```

---

### Agregação

Objeto **recebe outro já existente**.

```java
class Time {
    Jogador jogador;
}
```

---

### Composição

Objeto **cria o outro dentro dele**

```java
class Computador {
    Processador processador = new Processador();
}
```

## 📋 Associação na UML

Na UML (Unified Modeling Language):

Associação simples:

```bash
Aluno -------- Curso
```

Agregação:

```bash
Departamento ◇-------- Professor
```

Composição:

```bash
Casa ◆-------- Quarto
```

## 💻 Exemplo Completo

```java
import java.util.ArrayList;

class Produto {

    String nome;
    double preco;

    Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }
}

class Pedido {

    ArrayList<Produto> produtos = new ArrayList<>();

    void adicionarProduto(Produto produto){
        produtos.add(produto);
    }

    void mostrarPedido(){

        double total = 0;

        for(Produto p : produtos){
            System.out.println(p.nome + " - " + p.preco);
            total += p.preco;
        }

        System.out.println("Total: " + total);
    }
}
```

Main

```java
public class Main {

    public static void main(String[] args) {

        Produto p1 = new Produto("Mouse", 80);
        Produto p2 = new Produto("Teclado", 120);

        Pedido pedido = new Pedido();

        pedido.adicionarProduto(p1);
        pedido.adicionarProduto(p2);

        pedido.mostrarPedido();
    }
}
```

