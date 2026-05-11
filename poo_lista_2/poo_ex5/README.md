# 🚗 Exercício de Programação Orientada a Objetos em Java

## Carro e Motor (Composição)

Este projeto foi desenvolvido como exercício de **Programação Orientada
a Objetos (POO) em Java**.\
O objetivo é praticar conceitos fundamentais da linguagem como:

-   Classes
-   Objetos
-   Construtores
-   Métodos
-   Composição entre classes
-   Encapsulamento básico
-   Organização de código

------------------------------------------------------------------------

# 📚 Enunciado do Exercício

Crie duas classes:

-   `Motor`
-   `Carro`

Requisitos:

1.  A classe **Carro deve possuir um atributo do tipo Motor**.
2.  Deve existir um **método para exibir os dados do carro e do motor**.

------------------------------------------------------------------------

# 🧠 Conceitos de POO abordados

Este exercício trabalha diversos conceitos importantes de **Programação
Orientada a Objetos**.

------------------------------------------------------------------------

# 🧱 1. Classe

Uma **classe** é um modelo ou molde usado para criar objetos.

Ela define:

-   atributos (características)
-   métodos (comportamentos)

Exemplo de classe em Java:

``` java
public class Motor {

}
```

Podemos pensar na classe como uma **planta de construção** de objetos.

------------------------------------------------------------------------

# 📦 2. Objeto

Um **objeto** é uma instância de uma classe.

Ele representa uma entidade real dentro do programa.

Exemplo:

``` java
Motor motor = new Motor("Gasolina", 150, 2000);
```

Aqui:

-   `Motor` → classe\
-   `motor` → objeto criado a partir da classe

------------------------------------------------------------------------

# 🧬 3. Atributos

Atributos representam as **características de um objeto**.

Exemplo na classe `Motor`:

``` java
String tipo;
int potencia;
int cilindradas;
```

Esses atributos descrevem o estado de um motor.

------------------------------------------------------------------------

# ⚙️ 4. Métodos

Métodos representam **ações ou comportamentos do objeto**.

Exemplo:

``` java
public void exibirDados() {
    System.out.println("Tipo do motor: " + tipo);
}
```

Esse método tem a função de **mostrar os dados do motor no console**.

------------------------------------------------------------------------

# 🏗️ 5. Construtores

O **construtor** é um método especial usado para inicializar objetos.

Ele é executado automaticamente quando usamos `new`.

Exemplo:

``` java
public Motor(String tipo, int potencia, int cilindradas) {
    this.tipo = tipo;
    this.potencia = potencia;
    this.cilindradas = cilindradas;
}
```

Função do construtor:

-   atribuir valores iniciais aos atributos
-   garantir que o objeto seja criado corretamente

------------------------------------------------------------------------

# 🔎 6. Palavra-chave `this`

A palavra `this` refere-se ao **objeto atual da classe**.

Ela é usada para diferenciar:

-   atributos da classe
-   parâmetros do construtor

Exemplo:

``` java
this.tipo = tipo;
```

Significa:

atributo da classe = valor recebido no parâmetro

------------------------------------------------------------------------

# 🔗 7. Composição (Relacionamento entre Classes)

Este exercício demonstra **composição**, um tipo de relacionamento entre
classes.

Composição representa uma relação **"tem um" (HAS-A)**.

Exemplo:

Carro tem um Motor

No código isso aparece assim:

``` java
Motor motor;
```

Ou seja:

A classe `Carro` possui um objeto da classe `Motor`.

Representação:

Carro\
└── Motor

------------------------------------------------------------------------

# 🧩 8. Estrutura das Classes

## Classe Motor

Responsável por representar o motor do carro.

Atributos:

-   tipo
-   potência
-   cilindradas

Método principal:

-   `exibirDados()`

------------------------------------------------------------------------

## Classe Carro

Representa o carro e contém um motor.

Atributos:

-   marca
-   modelo
-   ano
-   motor

Método principal:

-   `exibirDados()`

Esse método mostra:

-   dados do carro
-   dados do motor

------------------------------------------------------------------------

# ▶️ Execução do Programa

Classe principal (`Main`):

``` java
public class Main {

    public static void main(String[] args) {

        Motor motor = new Motor("Gasolina", 150, 2000);

        Carro carro = new Carro(
                "Toyota",
                "Corolla",
                2022,
                motor
        );

        carro.exibirDados();
    }
}
```

------------------------------------------------------------------------

# 🖥️ Saída Esperada

    Marca: Toyota
    Modelo: Corolla
    Ano: 2022

    Dados do Motor:
    Tipo do motor: Gasolina
    Potência: 150 cv
    Cilindradas: 2000

------------------------------------------------------------------------

# 📊 Diagrama simples do sistema

    +--------+
    | Carro  |
    +--------+
    | marca  |
    | modelo |
    | ano    |
    | motor  |
    +--------+
         |
         v
    +--------+
    | Motor  |
    +--------+
    | tipo   |
    | potencia |
    | cilindradas |
    +--------+

------------------------------------------------------------------------

# 📁 Estrutura do Projeto

    projeto-poo-carro/

    │
    ├── Main.java
    ├── Carro.java
    └── Motor.java

------------------------------------------------------------------------

# 🎯 Objetivos de Aprendizagem

Após concluir este exercício, espera-se que o estudante compreenda:

-   Como criar **classes em Java**
-   Como instanciar **objetos**
-   Como utilizar **construtores**
-   Como definir **métodos**
-   Como funciona o relacionamento de **composição**
-   Como organizar classes em um projeto Java

------------------------------------------------------------------------

# 📖 Conclusão

Este exercício é uma excelente introdução à **Programação Orientada a
Objetos em Java**, pois demonstra de forma simples:

-   criação de classes
-   manipulação de objetos
-   interação entre objetos
-   organização de código

Esses conceitos são fundamentais para o desenvolvimento de sistemas mais
complexos e para o domínio da programação orientada a objetos.
