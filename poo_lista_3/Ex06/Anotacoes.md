# 📚 Exercício 6 — Plataforma de Conteúdo com Publicações Diferentes

> Anotações completas de orientação a objetos aplicada em Java, cobrindo todos os conceitos
> trabalhados ao longo da série de exercícios (Ex01 ao Ex06).

---

## 📋 Índice

1. [Contexto do Exercício](#1-contexto-do-exercício)
2. [Classe Abstrata](#2-classe-abstrata)
3. [Método Abstrato](#3-método-abstrato)
4. [Herança](#4-herança)
5. [Polimorfismo](#5-polimorfismo)
6. [Encapsulamento](#6-encapsulamento)
7. [Sobrescrita de Método — @Override](#7-sobrescrita-de-método--override)
8. [Guard Clause — Validação como Porteiro](#8-guard-clause--validação-como-porteiro)
9. [Enum](#9-enum)
10. [Separação de Responsabilidades](#10-separação-de-responsabilidades)
11. [Hierarquia de Classes — Mapa Geral](#11-hierarquia-de-classes--mapa-geral)
12. [Erros Comuns e Como Evitá-los](#12-erros-comuns-e-como-evitá-los)
13. [Boas Práticas Aplicadas](#13-boas-práticas-aplicadas)
14. [Resumo dos Exercícios da Série](#14-resumo-dos-exercícios-da-série)

---

## 1. Contexto do Exercício

Uma plataforma de conteúdo possui três tipos de publicação:

| Tipo             | Regra de publicação                        |
|------------------|--------------------------------------------|
| `Noticia`        | Título e texto com tamanho mínimo          |
| `ArtigoTecnico`  | Quantidade mínima de referências (≥ 5)     |
| `Tutorial`       | Quantidade mínima de passos (≥ 3)          |

Todas compartilham: `titulo`, `autor` e `textoBase`.

O **desafio** é percorrer uma lista de publicações e publicar apenas as válidas — sem
saber de antemão qual tipo cada objeto é.

---

## 2. Classe Abstrata

### O que é

Uma classe abstrata é um molde incompleto: define o que os filhos **devem ter**, mas
não pode ser instanciada diretamente.

```java
public abstract class Publicacao {
    protected String titulo;
    protected String autor;
    protected String textoBase;

    // método concreto — implementado aqui mesmo
    public void validarPublicacao() { ... }

    // métodos abstratos — obrigam as subclasses a implementar
    public abstract String gerarResumo();
    public abstract boolean podeSerPublicada();
}
```

### Quando usar

Use uma classe abstrata quando:
- Existe comportamento **comum** a todos os filhos (ex.: `validarPublicacao()`).
- Mas parte do comportamento **varia** por tipo (ex.: `gerarResumo()`).
- Nunca fará sentido criar um objeto do tipo pai sozinho (`new Publicacao()` não existe).

### Diferença: classe abstrata × interface

| Critério              | Classe abstrata            | Interface                    |
|-----------------------|----------------------------|------------------------------|
| Pode ter atributos    | ✔ Sim                      | ✗ Apenas constantes          |
| Pode ter métodos concretos | ✔ Sim                 | ✔ Desde Java 8 (default)     |
| Herança múltipla      | ✗ Só uma por classe        | ✔ Várias interfaces          |
| Quando usar           | Hierarquia com estado comum | Contrato sem implementação   |

---

## 3. Método Abstrato

### O que é

Um método sem corpo na superclasse, que **força** cada subclasse a fornecer sua
própria implementação.

```java
// Na superclasse — só a assinatura, sem corpo
public abstract boolean podeSerPublicada();

// Em Noticia — implementação obrigatória
@Override
public boolean podeSerPublicada() {
    return titulo.length() >= 10 && textoBase.length() >= 100;
}

// Em ArtigoTecnico — implementação diferente
@Override
public boolean podeSerPublicada() {
    return referencias.length >= 5;
}
```

### Por que isso é poderoso

O método `validarPublicacao()` da superclasse pode chamar `podeSerPublicada()` sem
saber qual subclasse está em uso. Cada objeto responde com sua própria lógica:

```java
public void validarPublicacao() {
    if (podeSerPublicada()) {   // ← chama o método do objeto real, não da superclasse
        System.out.println(gerarResumo());
    }
}
```

---

## 4. Herança

### O que é

Herança permite que uma classe **reutilize** atributos e métodos de outra,
estendendo ou especializando o comportamento.

```java
// Subclasse herda tudo de Publicacao
public class Noticia extends Publicacao {

    // Construtor repassa para o pai com super()
    public Noticia(String titulo, String autor, String textoBase) {
        super(titulo, autor, textoBase);
    }
}
```

### O que é herdado automaticamente

```
Publicacao
├── titulo          ← Noticia, ArtigoTecnico e Tutorial recebem isso de graça
├── autor
├── textoBase
└── validarPublicacao()   ← método concreto herdado por todos
```

### `super()` — chamando o construtor pai

Toda subclasse deve chamar `super(...)` na **primeira linha** do construtor para
inicializar os atributos da superclasse:

```java
public ArtigoTecnico(String titulo, String autor, String textoBase, String[] referencias) {
    super(titulo, autor, textoBase);   // inicializa os atributos herdados
    this.referencias = referencias;    // inicializa o atributo próprio
}
```

---

## 5. Polimorfismo

### O que é

Polimorfismo significa "muitas formas": o mesmo código funciona para diferentes tipos,
e cada objeto responde à sua maneira.

### Exemplo do exercício

```java
// Array do tipo pai — pode guardar qualquer subclasse
Publicacao[] publicacoes = {
    new Noticia(...),
    new ArtigoTecnico(...),
    new Tutorial(...)
};

// O loop não sabe (nem precisa saber) qual é o tipo real de cada objeto
for (Publicacao p : publicacoes) {
    p.validarPublicacao();   // cada um executa sua versão de podeSerPublicada()
}
```

### Por que isso resolve o desafio

Sem polimorfismo, seria necessário um `if/else` ou `switch` para cada tipo:

```java
// ✗ Sem polimorfismo — frágil, cresce a cada novo tipo
if (p instanceof Noticia) { ... }
else if (p instanceof ArtigoTecnico) { ... }
else if (p instanceof Tutorial) { ... }

// ✔ Com polimorfismo — funciona para qualquer tipo atual ou futuro
p.validarPublicacao();
```

---

## 6. Encapsulamento

### O que é

Encapsulamento é esconder os detalhes internos de uma classe. Cada subclasse guarda
seus próprios dados sem expor ao restante do sistema.

```java
public class ArtigoTecnico extends Publicacao {
    private String[] referencias;   // ← só ArtigoTecnico conhece esse detalhe

    // Publicacao não sabe que referencias existe
    // Tutorial não sabe que referencias existe
    // Apenas ArtigoTecnico acessa e valida
}

public class Tutorial extends Publicacao {
    private String[] passos;        // ← detalhe exclusivo de Tutorial
}
```

### Modificadores de acesso usados

| Modificador  | Visível em                              |
|--------------|-----------------------------------------|
| `private`    | Somente na própria classe               |
| `protected`  | Na própria classe e nas subclasses      |
| `public`     | Em qualquer lugar                       |

> Atributos da superclasse foram declarados `protected` para que as subclasses
> possam lê-los diretamente (`titulo`, `autor`, `textoBase`).

---

## 7. Sobrescrita de Método — `@Override`

### O que é

`@Override` indica que o método está **substituindo** uma implementação da superclasse
ou cumprindo o contrato de um método abstrato.

```java
@Override
public String gerarResumo() {
    return "[NOTÍCIA] " + titulo + "\nAutor: " + autor;
}
```

### Por que usar a anotação

1. O compilador **verifica** que o método realmente existe na superclasse.
2. Torna o código mais legível — fica claro que é uma sobrescrita.
3. Evita erros de digitação no nome do método.

```java
// Sem @Override — o compilador não avisa se o nome estiver errado
public String gerarresumo() { ... }   // ← bug silencioso (minúsculo errado)

// Com @Override — o compilador avisa imediatamente
@Override
public String gerarresumo() { ... }   // ✗ Erro de compilação: método não encontrado na superclasse
```

---

## 8. Guard Clause — Validação como Porteiro

### O que é

Uma *guard clause* é uma verificação no início de um método que **interrompe a
execução imediatamente** se os dados forem inválidos. Evita blocos `if/else`
aninhados e torna o código mais legível.

### Padrão aplicado no exercício

```java
public void validarPublicacao() {
    if (!podeSerPublicada()) {           // ← porteiro: valida primeiro
        System.out.println("Reprovada.");
        return;                          // ← sai imediatamente
    }
    // só chega aqui se tudo estiver válido
    System.out.println(gerarResumo());
}
```

### Comparação: com e sem guard clause

```java
// ✗ Sem guard clause — aninhamento desnecessário
public void validarPublicacao() {
    if (podeSerPublicada()) {
        if (titulo != null) {
            System.out.println(gerarResumo());
        }
    }
}

// ✔ Com guard clause — linear e direto
public void validarPublicacao() {
    if (!podeSerPublicada()) { return; }
    if (titulo == null) { return; }
    System.out.println(gerarResumo());
}
```

### Onde a guard clause apareceu na série

| Exercício | Método               | O que valida                              |
|-----------|----------------------|-------------------------------------------|
| Ex02      | `gerarResumoEntrega` | peso ≤ 0 ou valor declarado negativo      |
| Ex04      | `exibirResumo`       | preço base ≤ 0                            |
| Ex05      | `sacar`              | valor ≤ 0, saldo insuficiente             |
| Ex06      | `validarPublicacao`  | critérios específicos de cada publicação  |

---

## 9. Enum

### O que é

`enum` é um tipo especial que representa um conjunto fixo de constantes nomeadas.

### Sintaxe correta em Java

```java
// ✗ Errado — "Enum" com maiúscula não é palavra-chave, e "public" em arquivo separado
public Enum Resposta { SIM, NAO; }

// ✔ Correto — "enum" com minúscula
public enum Resposta {
    SIM, NAO
}
```

### Como usar como tipo de campo

```java
public class ArtigoTecnico extends Publicacao {
    private Resposta confirmado;   // ✔ usa o tipo do enum, não "Enum" genérico

    public void confirmar(Resposta r) {
        this.confirmado = r;
    }
}

// Na chamada:
artigo.confirmar(Resposta.SIM);
```

### Quando usar enum

Use quando o campo só pode assumir valores de um conjunto fechado e conhecido:
situação de publicação (`RASCUNHO`, `REVISAO`, `PUBLICADO`), tipo de conta
(`CORRENTE`, `POUPANCA`, `EMPRESARIAL`), tipo de entrega etc.

---

## 10. Separação de Responsabilidades

### O princípio

Cada classe deve ter **uma razão para existir**. Misturar lógica de negócio com
entrada de dados (Scanner) ou saída de tela dentro de classes de domínio é um erro
de design comum.

### Problema identificado no código original

```java
// ✗ ArtigoTecnico lendo entrada do usuário — responsabilidade errada
public void adicionarReferencias(String ref) {
    while (true) {
        Scanner sc = new Scanner(System.in);   // ← classe de domínio não deve fazer isso
        System.out.println("Deseja incluir referência?");
        // ...
    }
}
```

### Solução aplicada

```java
// ✔ Dados entram pelo construtor — ArtigoTecnico só cuida das regras de negócio
public ArtigoTecnico(String titulo, String autor,
                     String textoBase, String[] referencias) {
    super(titulo, autor, textoBase);
    this.referencias = (referencias != null) ? referencias : new String[0];
}
```

Quem coleta os dados do usuário é o `Main` (ou uma camada de apresentação separada).
A classe de domínio apenas recebe e valida.

---

## 11. Hierarquia de Classes — Mapa Geral

```
Publicacao  (abstrata)
│
│   atributos herdados: titulo, autor, textoBase
│   método concreto:    validarPublicacao()
│   métodos abstratos:  gerarResumo(), podeSerPublicada()
│
├── Noticia
│       regra: titulo.length >= 10 && textoBase.length >= 100
│       resumo: trecho do texto
│
├── ArtigoTecnico
│       atributo próprio: String[] referencias
│       regra: referencias.length >= 5
│       resumo: lista de referências
│
└── Tutorial
        atributo próprio: String[] passos
        regra: passos.length >= 3
        resumo: passos numerados
```

---

## 12. Erros Comuns e Como Evitá-los

### `NullPointerException` em arrays

```java
// ✗ Perigoso — referencias pode ser null
this.referencias = referencias;

// ✔ Seguro — garante que nunca será null
this.referencias = (referencias != null) ? referencias : new String[0];
```

### Método abstrato sem `return` em todos os caminhos

```java
// ✗ Não compila — caminho feliz sem return
@Override
public boolean podeSerPublicada() {
    if (referencias.length < 5) {
        return false;
    }
    // ← faltou o return true
}

// ✔ Correto
@Override
public boolean podeSerPublicada() {
    if (referencias.length < 5) {
        return false;
    }
    return true;   // ← ou simplesmente: return referencias.length >= 5;
}
```

### Enum com tipo errado no campo

```java
// ✗ Usa o tipo genérico "Enum" — perde type-safety
private Enum status;

// ✔ Usa o tipo específico do seu enum
private Resposta status;
```

### Campo de contagem que nunca é atualizado

```java
// ✗ refMinimas sempre vale 0 — a checagem nunca funciona
int refMinimas = 0;
if (refMinimas < 5) { return false; }

// ✔ Usa o tamanho real do array
if (referencias.length < 5) { return false; }
```

---

## 13. Boas Práticas Aplicadas

### Constantes nomeadas em vez de números mágicos

```java
// ✗ O que significa 5 aqui?
if (referencias.length < 5) { ... }

// ✔ O nome deixa claro a intenção
private static final int MIN_REFERENCIAS = 5;
if (referencias.length < MIN_REFERENCIAS) { ... }
```

### `static final` para constantes de classe

```java
private static final double TARIFA_OPERACAO = 4.50;  // Ex05 — ContaCorrente
private static final int    MIN_PASSOS       = 3;     // Ex06 — Tutorial
private static final int    MIN_TITULO       = 10;    // Ex06 — Noticia
```

`static` → pertence à classe, não a cada objeto.  
`final`  → não pode ser reatribuído após a inicialização.

### `StringBuilder` para montar strings longas

```java
// ✗ Concatenação em loop — cria muitos objetos String intermediários
String resultado = "";
for (String passo : passos) {
    resultado += "• " + passo + "\n";
}

// ✔ StringBuilder — eficiente e legível
StringBuilder sb = new StringBuilder();
for (int i = 0; i < passos.length; i++) {
    sb.append(i + 1).append(". ").append(passos[i]).append("\n");
}
return sb.toString();
```

### Defesa contra `null` no construtor

```java
this.passos = (passos != null) ? passos : new String[0];
```

Garante que os métodos que operam sobre o array nunca precisam checar `null`
internamente — o objeto nasce em estado válido.

---

## 14. Resumo dos Exercícios da Série

| Exercício | Tema                        | Conceito principal                                  |
|-----------|-----------------------------|-----------------------------------------------------|
| Ex01      | Sistema de funcionários     | Classe abstrata, herança, método abstrato           |
| Ex02      | Sistema de entregas         | Guard clause, validação centralizada                |
| Ex04      | Biblioteca de produtos      | Validação de preço, `static final`, resumo polimórfico |
| Ex05      | Sistema bancário            | Herança com regras distintas, saldo + limite        |
| Ex06      | Plataforma de publicações   | Polimorfismo em coleção, separação de responsabilidades, enum |

### Padrão que se repete em todos

```
SuperclasseAbstrata
├── atributos comuns (protected)
├── método concreto que orquestra → chama o abstrato
└── método(s) abstrato(s) → subclasse decide como

Subclasse
├── super(...) no construtor
├── atributos próprios (private)
└── @Override nos métodos abstratos
```

Esse padrão segue o princípio **"defina o contrato no pai, implemente nos filhos"**,
que é o coração da programação orientada a objetos em Java.

---

*Anotações geradas com base nos Exercícios 01 a 06 da série de POO em Java.*