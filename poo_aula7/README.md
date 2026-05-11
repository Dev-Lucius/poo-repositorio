# 🧩 Interfaces e Enum em Java — POO (Aula 7)

> **Disciplina:** Programação Orientada a Objetos  
> **Tema:** Interfaces e Enumerações (Enum) em Java  
> **Nível:** Intermediário

---

## 📚 Sumário

- [O que é uma Interface?](#-o-que-é-uma-interface)
- [Por que usar Interfaces?](#-por-que-usar-interfaces)
- [Sintaxe básica](#-sintaxe-básica)
- [Exemplo 1 — Interface para Geração de Relatórios](#-exemplo-1--interface-para-geração-de-relatórios)
- [Exemplo 2 — Interface como "Contrato" Genérico](#-exemplo-2--interface-como-contrato-genérico)
- [Exemplo 3 — Implementando Interfaces do Java (MouseMotionListener)](#-exemplo-3--implementando-interfaces-do-java-mousemotionlistener)
- [Exemplo 4 — Interface CRUD](#-exemplo-4--interface-crud)
- [Exemplo 5 — Injeção de Dependência com Interface + Enum](#-exemplo-5--injeção-de-dependência-com-interface--enum)
- [O que é Enum?](#-o-que-é-enum)
- [Boas Práticas com Interfaces](#-boas-práticas-com-interfaces)
- [Comparativo: Interface vs Classe Abstrata](#-comparativo-interface-vs-classe-abstrata)
- [Resumo Visual](#-resumo-visual)

---

## 🔷 O que é uma Interface?

Uma **interface** em Java é um contrato que define **o que** uma classe deve fazer, mas **não como** ela deve fazer. É composta apenas por:

- Assinaturas de métodos (sem implementação, por padrão)
- Constantes (`public static final`)
- A partir do Java 8: métodos `default` e `static` com implementação

```java
public interface IGerarRelatorio {
    public void gerarRelatorio(); // sem corpo — apenas a assinatura
}
```

Quando uma classe **implementa** uma interface, ela assina o contrato e é **obrigada** a implementar todos os seus métodos.

```java
public class BaseFuncionarios implements IGerarRelatorio {
    @Override
    public void gerarRelatorio() {
        System.out.println("RELATÓRIO DE PESSOAL");
    }
}
```

---

## 🎯 Por que usar Interfaces?

| Benefício | Descrição |
|---|---|
| **Polimorfismo** | Objetos de tipos diferentes podem ser tratados pelo mesmo tipo da interface |
| **Desacoplamento** | Reduz a dependência entre classes, facilitando manutenção |
| **Padronização** | Garante que todas as implementações sigam o mesmo contrato |
| **Testabilidade** | Permite criar implementações "falsas" para testes (mocks) |
| **Herança múltipla** | Uma classe pode implementar quantas interfaces quiser |

---

## 🖊️ Sintaxe básica

### Declarando uma interface
```java
public interface NomeDaInterface {
    void meuMetodo();            // implicitamente public e abstract
    int outroMetodo(String s);   // pode ter parâmetros e retorno
}
```

### Implementando em uma classe
```java
public class MinhaClasse implements NomeDaInterface {

    @Override
    public void meuMetodo() {
        System.out.println("Implementação concreta");
    }

    @Override
    public int outroMetodo(String s) {
        return s.length();
    }
}
```

### Implementando múltiplas interfaces
```java
public class OutraClasse implements InterfaceA, InterfaceB, InterfaceC {
    // deve implementar todos os métodos de A, B e C
}
```

---

## 📋 Exemplo 1 — Interface para Geração de Relatórios

**Contexto:** Um sistema possui diferentes bases de dados (`BaseFuncionarios`, `BaseFinanceira`). Ambas precisam gerar relatórios, mas cada uma formata os dados de maneira diferente. A interface `IGerarRelatorio` garante que qualquer base possa ser usada de forma uniforme.

### `IGerarRelatorio.java`
```java
package exemplo1;

public interface IGerarRelatorio {
    public void gerarRelatorio();
}
```

### `BaseFuncionarios.java`
```java
package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class BaseFuncionarios implements IGerarRelatorio {

    private List<Funcionario> base;

    BaseFuncionarios() {
        this.base = new ArrayList<>();
    }

    public void addFuncionario(Funcionario func) {
        this.base.add(func);
    }

    // ✅ A interface eliminou a necessidade de expor getFuncionarios()
    // Menos acoplamento, mais proteção dos dados internos!

    @Override
    public void gerarRelatorio() {
        System.out.println(" RELATORIO DE PESSOAL ");
        for (Funcionario f : base) {
            System.out.println(f);
        }
    }
}
```

### `BaseFinanceira.java`
```java
package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class BaseFinanceira implements IGerarRelatorio {

    private List<RelatorioFinanceiro> base;

    BaseFinanceira() {
        this.base = new ArrayList<>();
    }

    public void addDados(RelatorioFinanceiro dado) {
        this.base.add(dado);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println(" RELATORIO FINANCEIRA ");
        for (RelatorioFinanceiro f : base) {
            System.out.println(f);
        }
    }
}
```

### `Main.java` — O poder do polimorfismo
```java
package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BaseFuncionarios bFunc = new BaseFuncionarios();
        bFunc.addFuncionario(new Funcionario("christian", 10000));
        bFunc.addFuncionario(new Funcionario("janaiton", 8000));
        bFunc.addFuncionario(new Funcionario("tiago", 7000));

        BaseFinanceira bFinanceira = new BaseFinanceira();
        bFinanceira.addDados(new RelatorioFinanceiro("TI", "13/04/2026", 20000));

        // 🔑 Chave do polimorfismo: List do tipo da INTERFACE
        List<IGerarRelatorio> todosRelatorios = new ArrayList<>();
        todosRelatorios.add(bFunc);
        todosRelatorios.add(bFinanceira);

        // Itero sobre objetos completamente diferentes com o MESMO método
        for (IGerarRelatorio rel : todosRelatorios) {
            rel.gerarRelatorio();
        }
    }
}
```

### 💡 O que aprendemos aqui?

Antes de usar a interface, seria necessário um `GeradorRelatorios` com métodos sobrecarregados para cada tipo de base. Com a interface:

- ✅ A `List<IGerarRelatorio>` aceita **qualquer** objeto que implemente o contrato
- ✅ O método `gerarRelatorio()` é chamado **sem saber o tipo real** do objeto
- ✅ Adicionar uma nova base no futuro não muda o código do `Main`

> 🧠 **Princípio aplicado:** *Programe para a interface, não para a implementação.* (Design Patterns — GoF)

---

## 🤝 Exemplo 2 — Interface como "Contrato" Genérico

**Contexto:** Objetos completamente diferentes no mundo real — uma tesoura, um comediante, um programador e um vírus — podem ser agrupados se todos assinam um contrato em comum: a capacidade de **"fazer algo"**.

```java
package exemplo2;

// Qualquer coisa que "faz" algo pode implementar esta interface
public interface IFazivel {
    void faz();
}
```

```java
// Implementações — objetos totalmente diferentes, mesmo contrato
public class Tesoura  implements IFazivel { public void faz() { System.out.println("Corta"); } }
public class Comediante implements IFazivel { public void faz() { System.out.println("Faz piada"); } }
public class Programador implements IFazivel { public void faz() { System.out.println("Programa"); } }
public class Virus implements IFazivel { public void faz() { System.out.println("Faz doença"); } }
```

```java
package exemplo2;

public class Main {
    public static void main(String[] args) {

        List<IFazivel> coisas = new ArrayList<>();

        coisas.add(new Tesoura());
        coisas.add(new Comediante());
        coisas.add(new Programador());
        coisas.add(new Virus());

        // Não importa quem é — todos "fazem" algo
        for (IFazivel coisa : coisas) {
            coisa.faz();
        }
    }
}
```

### 💡 O que aprendemos aqui?

Interfaces não exigem nenhuma relação hierárquica entre as classes. `Tesoura` e `Vírus` não têm nada em comum — exceto o fato de ambas "fazerem" algo. A interface é o elo que permite tratá-las da mesma forma.

---

## 🖱️ Exemplo 3 — Implementando Interfaces do Java (MouseMotionListener)

**Contexto:** O Java já vem com dezenas de interfaces prontas. Ao implementá-las, você conecta sua classe a frameworks e bibliotecas existentes — como o Swing para interfaces gráficas.

```java
package exemplo3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

// ✅ Implementa MouseMotionListener — interface nativa do Java Swing
public class Painel extends JPanel implements MouseMotionListener {

    int x, y;

    public Painel() {
        this.addMouseMotionListener(this); // registra a si mesmo como ouvinte
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x - 10, y - 10, 20, 20); // desenha círculo na posição do mouse
    }

    // Contrato da interface: OBRIGADO a implementar mouseDragged
    @Override
    public void mouseDragged(MouseEvent e) {
        // não utilizado neste exemplo
    }

    // Contrato da interface: OBRIGADO a implementar mouseMoved
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());
        this.x = e.getX();
        this.y = e.getY();
        repaint(); // redesenha o painel com o círculo na nova posição
    }
}
```

### `Main.java`
```java
package exemplo3;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Painel painel = new Painel();

        JFrame janela = new JFrame();
        janela.setSize(600, 600);
        janela.add(painel);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
```

### 💡 O que aprendemos aqui?

- Uma classe pode **estender** uma classe (`extends JPanel`) e **implementar** uma interface (`implements MouseMotionListener`) ao mesmo tempo
- Interfaces do Java definem contratos que o framework usa para chamar os seus métodos em eventos específicos (movimento de mouse, cliques, etc.)
- O método `addMouseMotionListener(this)` funciona porque `this` (o `Painel`) garante implementar a interface esperada

---

## 🗄️ Exemplo 4 — Interface CRUD

**Contexto:** Em sistemas com acesso a banco de dados, é uma boa prática definir uma interface com as operações básicas de persistência: **C**reate, **R**ead, **U**pdate e **D**elete. Qualquer entidade que precise ser gerenciada no banco implementa esse contrato.

### `CRUD.java`
```java
package exemplo4;

public interface CRUD {
    public void create(); // salva no banco
    public void read();   // busca os dados no banco
    public void update(); // atualiza um dado no banco
    public void delete(); // deleta o dado do banco
}
```

### `PessoaDAO.java`
```java
package exemplo4;

public class PessoaDAO implements CRUD {

    @Override
    public void create() {
        // lógica para inserir Pessoa no banco
        System.out.println("Pessoa inserida no banco.");
    }

    @Override
    public void read() {
        // lógica para buscar Pessoa no banco
        System.out.println("Pessoa buscada no banco.");
    }

    @Override
    public void update() {
        // lógica para atualizar Pessoa no banco
        System.out.println("Pessoa atualizada no banco.");
    }

    @Override
    public void delete() {
        // lógica para deletar Pessoa do banco
        System.out.println("Pessoa deletada do banco.");
    }
}
```

### `Passagem.java`
```java
package exemplo4;

public class Passagem implements CRUD {

    @Override
    public void create() {
        System.out.println("Passagem criada no banco.");
    }

    @Override
    public void read() {
        System.out.println("Passagem buscada no banco.");
    }

    @Override
    public void update() {
        System.out.println("Passagem atualizada no banco.");
    }

    @Override
    public void delete() {
        System.out.println("Passagem deletada do banco.");
    }
}
```

### 💡 O que aprendemos aqui?

O padrão **DAO (Data Access Object)** é um dos mais usados no desenvolvimento Java. A interface `CRUD` garante que qualquer DAO do sistema — seja de `Pessoa`, `Passagem` ou qualquer outra entidade — sempre oferecerá as mesmas quatro operações fundamentais.

---

## ⚙️ Exemplo 5 — Injeção de Dependência com Interface + Enum

**Contexto:** Uma aplicação precisa comportar-se diferente em ambiente de **testes** e em **produção** — em testes, usa-se um banco de dados em memória (mais rápido e sem efeitos colaterais); em produção, o banco real. A interface `BancoDeDados` e a injeção de dependência resolvem isso elegantemente.

### `BancoDeDados.java` — A interface
```java
package exemplo5;

public interface BancoDeDados {
    public void inserirPessoa();
}
```

### `BancoDeDadosMemoria.java` — Implementação para testes
```java
package exemplo5;

public class BancoDeDadosMemoria implements BancoDeDados {

    @Override
    public void inserirPessoa() {
        System.out.println("INSERE PESSOA FAKE"); // simula sem tocar no banco real
    }
}
```

### `BancoDeDadosReal.java` — Implementação para produção
```java
package exemplo5;

public class BancoDeDadosReal implements BancoDeDados {

    @Override
    public void inserirPessoa() {
        System.out.println("INSERE PESSOA REAL"); // operação real no banco
    }
}
```

### `Aplicacao.java` — Injeção de dependência
```java
package exemplo5;

public class Aplicacao {

    // ✅ Depende da INTERFACE, não de uma implementação específica
    BancoDeDados bd;

    public Aplicacao(BancoDeDados bd) {
        this.bd = bd; // quem decide é quem cria o objeto
    }

    public void cadastrarPessoa() {
        System.out.println("CADASTRO PESSOA APP");
        this.bd.inserirPessoa(); // chama sem saber quem está por baixo
    }

    public static void main(String[] args) {
        String ambiente = args[0];
        Aplicacao app;

        if (ambiente.equals("teste")) {
            app = new Aplicacao(new BancoDeDadosMemoria());
        } else {
            app = new Aplicacao(new BancoDeDadosReal());
        }

        app.cadastrarPessoa();
    }
}
```

### `Ambiente.java` — O Enum
```java
package exemplo5;

public enum Ambiente {
    DESENVOLVIMENTO,
    HOMOLOGACAO,
    PRODUCAO
}
```

### 💡 O que aprendemos aqui?

- **Injeção de Dependência:** A classe `Aplicacao` não decide qual banco usa — recebe essa decisão de fora (pelo construtor). Isso a torna **testável** e **flexível**
- **Inversão de Dependência:** `Aplicacao` depende da abstração (`BancoDeDados`), não das classes concretas
- **Enum:** Define os possíveis ambientes do sistema como um conjunto finito e nomeado de constantes
- O código da `Aplicacao` **nunca muda** se um novo tipo de banco for adicionado — basta criar uma nova classe que implemente `BancoDeDados`

---

## 🔢 O que é Enum?

Um **Enum** (Enumeração) é um tipo especial em Java que representa um conjunto **fixo e nomeado** de constantes. É ideal para modelar situações onde os valores possíveis são conhecidos em tempo de desenvolvimento.

### Sintaxe básica
```java
public enum DiaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
}
```

### Usando em código
```java
DiaSemana hoje = DiaSemana.SEXTA;

if (hoje == DiaSemana.SEXTA) {
    System.out.println("Sextou! 🎉");
}
```

### Enum em switch
```java
Ambiente env = Ambiente.PRODUCAO;

switch (env) {
    case DESENVOLVIMENTO:
        System.out.println("Modo dev: logs detalhados");
        break;
    case HOMOLOGACAO:
        System.out.println("Modo homologação: dados de teste");
        break;
    case PRODUCAO:
        System.out.println("Modo produção: máxima cautela!");
        break;
}
```

### Por que usar Enum em vez de Strings ou inteiros?

```java
// ❌ Ruim — qualquer valor inválido pode ser passado
String ambiente = "produçao"; // erro de digitação silencioso

// ✅ Bom — o compilador rejeita qualquer valor não previsto
Ambiente ambiente = Ambiente.PRODUCAO;
```

| Situação | String | int | Enum |
|---|---|---|---|
| Tipo seguro | ❌ | ❌ | ✅ |
| Legibilidade | ⚠️ | ❌ | ✅ |
| Autocomplete na IDE | ⚠️ | ❌ | ✅ |
| Erros detectados em compilação | ❌ | ❌ | ✅ |

---

## ✅ Boas Práticas com Interfaces

### 1. Nomeie interfaces com foco no comportamento
```java
// ✅ Nome descreve o que a interface "faz fazer"
public interface IGerarRelatorio { ... }
public interface Comparable { ... }
public interface Runnable { ... }

// ⚠️ Evite nomes genéricos demais
public interface IBase { ... }
```

### 2. Prefira interfaces pequenas e focadas (Princípio da Segregação de Interface)
```java
// ❌ Interface grande demais — uma classe pode não precisar de todos
public interface Tudo {
    void salvar();
    void imprimir();
    void enviarEmail();
    void gerarPDF();
}

// ✅ Interfaces pequenas e específicas
public interface ISalvavel { void salvar(); }
public interface IImprimivel { void imprimir(); }
```

### 3. Use a interface como tipo de variável
```java
// ❌ Dependência na implementação concreta
BaseFuncionarios base = new BaseFuncionarios();

// ✅ Dependência na abstração (interface)
IGerarRelatorio base = new BaseFuncionarios();
```

### 4. Prefira injeção de dependência
```java
// ❌ Instancia internamente — difícil de testar
public class Aplicacao {
    private BancoDeDados bd = new BancoDeDadosReal(); // acoplado!
}

// ✅ Recebe de fora — fácil de trocar e testar
public class Aplicacao {
    private BancoDeDados bd;
    public Aplicacao(BancoDeDados bd) { this.bd = bd; }
}
```

---

## ⚖️ Comparativo: Interface vs Classe Abstrata

| Característica | Interface | Classe Abstrata |
|---|---|---|
| Herança múltipla | ✅ Sim (várias interfaces) | ❌ Não (só uma classe pai) |
| Pode ter atributos de instância | ❌ Não | ✅ Sim |
| Pode ter construtores | ❌ Não | ✅ Sim |
| Implementação de métodos | ⚠️ Só `default`/`static` (Java 8+) | ✅ Sim |
| Quando usar | Contrato de comportamento | Compartilhar código entre subclasses relacionadas |

```java
// Use interface quando as classes NÃO têm relação hierárquica
// mas compartilham um COMPORTAMENTO
public interface Voavel { void voar(); }

class Aviao implements Voavel { public void voar() { ... } }
class Passaro implements Voavel { public void voar() { ... } }
// Avião e Pássaro não herdam de uma mesma classe-pai

// Use classe abstrata quando as classes SÃO relacionadas
// e compartilham CÓDIGO em comum
abstract class Animal {
    String nome;
    abstract void emitirSom(); // obriga subclasses a implementar
    void respirar() { System.out.println("Respirando..."); } // código compartilhado
}
```

---

## 🗺️ Resumo Visual

```
                    ┌─────────────────────────┐
                    │    <<interface>>         │
                    │    IGerarRelatorio       │
                    │  + gerarRelatorio()      │
                    └────────────┬────────────┘
                                 │ implements
               ┌─────────────────┴─────────────────┐
               │                                   │
   ┌───────────▼──────────┐          ┌─────────────▼──────────┐
   │   BaseFuncionarios   │          │     BaseFinanceira      │
   │ + gerarRelatorio()   │          │  + gerarRelatorio()     │
   └──────────────────────┘          └────────────────────────┘

         ↑ ambas podem ser tratadas como IGerarRelatorio ↑

  List<IGerarRelatorio> lista = new ArrayList<>();
  lista.add(new BaseFuncionarios());   // ✅
  lista.add(new BaseFinanceira());     // ✅


                    ┌─────────────────────────┐
                    │    <<interface>>         │
                    │     BancoDeDados         │
                    │  + inserirPessoa()       │
                    └────────────┬────────────┘
                                 │ implements
               ┌─────────────────┴─────────────────┐
               │                                   │
  ┌────────────▼──────────┐         ┌──────────────▼──────────┐
  │  BancoDeDadosMemoria  │         │    BancoDeDadosReal      │
  │  (para testes)        │         │    (para produção)       │
  └───────────────────────┘         └─────────────────────────┘

  Aplicacao recebe qualquer um via construtor (injeção de dependência)


  ┌──────────────────────────────────────────────┐
  │                 enum Ambiente                 │
  │                                              │
  │   DESENVOLVIMENTO | HOMOLOGACAO | PRODUCAO   │
  │                                              │
  │  Conjunto fixo de constantes nomeadas.       │
  │  Seguro em tempo de compilação.              │
  └──────────────────────────────────────────────┘
```

---

## 📖 Referências

- [Java Documentation — Interfaces](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)
- [Java Documentation — Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
- DEITEL, P.; DEITEL, H. **Java: Como Programar**. 10ª ed. Pearson, 2017.
- SIERRA, K.; BATES, B. **Use a Cabeça! Java**. Alta Books, 2005.

---

> 💬 *"Programe para interfaces, não para implementações."*  
> — Gang of Four (GoF), Design Patterns

---

**Aula 7 · POO · © Todos os exemplos produzidos para fins didáticos**