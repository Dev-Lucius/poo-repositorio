# ⚔️ Exercício 10 — Jogo com Unidades de Combate

> README técnico com explicação linha a linha de cada arquivo do projeto.
> Ideal para revisão de POO em Java: classes abstratas, herança, polimorfismo,
> sobrescrita e encapsulamento aplicados em um sistema de batalha por turnos.

---

## 📋 Índice

1. [Visão Geral do Projeto](#1-visão-geral-do-projeto)
2. [Estrutura de Arquivos](#2-estrutura-de-arquivos)
3. [Unidade.java — A Superclasse Abstrata](#3-unidadejava--a-superclasse-abstrata)
4. [Soldado.java — Defesa Física](#4-soldadojava--defesa-física)
5. [Arqueiro.java — Dano Crítico](#5-arqueirojava--dano-crítico)
6. [Mago.java — Sistema de Mana](#6-magojava--sistema-de-mana)
7. [Batalha.java — Motor de Turnos](#7-batalhajava--motor-de-turnos)
8. [Main.java — Ponto de Entrada](#8-mainjava--ponto-de-entrada)
9. [Conceitos de POO Aplicados](#9-conceitos-de-poo-aplicados)
10. [Fluxo de Execução — Passo a Passo](#10-fluxo-de-execução--passo-a-passo)
11. [Decisões de Design](#11-decisões-de-design)

---

## 1. Visão Geral do Projeto

O sistema simula batalhas por turnos entre três tipos de unidade de combate.
Cada unidade possui atributos comuns (vida, ataque, defesa), mas cada tipo
implementa suas próprias regras de combate.

### Tabela de unidades

| Unidade   | Diferencial                              | Fraqueza                        |
|-----------|------------------------------------------|---------------------------------|
| Soldado   | Reduz 40% do dano recebido + subtrai defesa | Ataque baixo                 |
| Arqueiro  | 30% de chance de dano crítico (2×)       | Sem proteção especial           |
| Mago      | 2.5× de dano com mana; enfraquece sem ela | Vida e defesa baixas            |

---

## 2. Estrutura de Arquivos

```
Ex10/
├── Unidade.java      ← superclasse abstrata (contrato comum)
├── Soldado.java      ← subclasse com defesa física
├── Arqueiro.java     ← subclasse com chance de crítico
├── Mago.java         ← subclasse com sistema de mana
├── Batalha.java      ← motor de combate por turnos
└── Main.java         ← ponto de entrada com 3 batalhas
```

---

## 3. Unidade.java — A Superclasse Abstrata

```java
package Ex10;
```
> Declara que esta classe pertence ao pacote `Ex10`.
> Pacotes organizam classes relacionadas e evitam conflitos de nomes.

```java
public abstract class Unidade {
```
> `abstract` impede que `Unidade` seja instanciada diretamente (`new Unidade()` não compila).
> É um molde — define o que toda unidade **deve ter e fazer**, sem saber os detalhes.

---

### Atributos

```java
    protected String nome;
    protected int    vidaMaxima;
    protected int    vidaAtual;
    protected int    ataqueBase;
    protected int    defesa;
```
> `protected` significa que esses atributos são visíveis na própria classe
> **e em todas as subclasses** (`Soldado`, `Arqueiro`, `Mago`).
> Usar `private` aqui impediria o acesso nas subclasses sem getters.
>
> `vidaMaxima` guarda o valor original para calcular a barra de vida percentual.
> `vidaAtual` diminui com o tempo — é o HP em tempo real.

---

### Construtor

```java
    public Unidade(String nome, int vida, int ataqueBase, int defesa) {
        this.nome       = nome;
        this.vidaMaxima = vida;
        this.vidaAtual  = vida;    // começa com vida cheia
        this.ataqueBase = ataqueBase;
        this.defesa     = defesa;
    }
```
> `this.campo = parametro` diferencia o atributo da classe do parâmetro de mesmo nome.
> `vidaAtual = vida` garante que toda unidade começa com vida máxima.
> Subclasses chamam este construtor via `super(nome, vida, ataqueBase, defesa)`.

---

### Método abstrato `atacar`

```java
    public abstract void atacar(Unidade alvo);
```
> Sem corpo `{ }` — apenas a assinatura.
> Força cada subclasse a fornecer sua própria implementação.
> O parâmetro é `Unidade` (tipo pai), então qualquer subclasse pode ser o alvo:
> um Soldado pode atacar um Mago, um Arqueiro, ou qualquer outro.

---

### Método concreto `receberDano`

```java
    public void receberDano(int dano) {
        int danoEfetivo = Math.max(0, dano);
        vidaAtual = Math.max(0, vidaAtual - danoEfetivo);
    }
```
> `Math.max(0, dano)` — se por algum cálculo o dano for negativo, trata como 0.
> Sem isso, uma unidade poderia **ganhar vida** ao ser atacada.
>
> `Math.max(0, vidaAtual - danoEfetivo)` — impede que `vidaAtual` fique negativa.
> Sem isso, `estaViva()` retornaria falso mas a vida poderia exibir `-30 HP`.
>
> Este método pode ser **sobrescrito** pelas subclasses (como o `Soldado` faz),
> porque não é `final`. A superclasse oferece o comportamento padrão; as filhas
> podem especializar.

---

### Método concreto `estaViva`

```java
    public boolean estaViva() {
        return vidaAtual > 0;
    }
```
> Retorna `true` enquanto a unidade tiver pelo menos 1 HP.
> Usado pela `Batalha` como condição de parada do loop de turnos.

---

### Método `barraDeVida`

```java
    public String barraDeVida() {
        int total      = 20;
        int preenchido = (int) ((vidaAtual / (double) vidaMaxima) * total);
        String barra   = "█".repeat(preenchido) + "░".repeat(total - preenchido);
        return String.format("[%s] %d/%d HP", barra, vidaAtual, vidaMaxima);
    }
```
> Cria uma barra visual proporcional à vida restante: `[████████████░░░░░░░░] 60/100 HP`
>
> `(double) vidaMaxima` — cast necessário para a divisão ser decimal.
> Sem ele, `vidaAtual / vidaMaxima` seria divisão inteira e o resultado seria
> sempre 0 quando `vidaAtual < vidaMaxima`.
>
> `(int) (... * total)` — converte o resultado decimal em inteiro para
> calcular quantos blocos preencher.
>
> `"█".repeat(n)` — repete o caractere n vezes (disponível desde Java 11).
> `"░".repeat(total - preenchido)` — preenche o restante com blocos vazios.

---

### Método `status`

```java
    public String status() {
        return String.format("%-12s %s", nome, barraDeVida());
    }
```
> `%-12s` — alinha o nome à esquerda em um campo de 12 caracteres,
> garantindo que todas as barras de vida fiquem na mesma coluna.
>
> Este método é `public` e não abstrato — as subclasses herdam esse comportamento.
> O `Mago` o sobrescreve para incluir também a mana.

---

### Getters

```java
    public String getNome()       { return nome; }
    public int    getVidaAtual()  { return vidaAtual; }
    public int    getDefesa()     { return defesa; }
    public int    getAtaqueBase() { return ataqueBase; }
```
> Permitem que classes externas (`Batalha`, `Main`) leiam os atributos
> sem acessá-los diretamente — princípio do encapsulamento.

---

## 4. Soldado.java — Defesa Física

```java
package Ex10;

public class Soldado extends Unidade {
```
> `extends Unidade` — Soldado herda todos os atributos e métodos concretos
> de `Unidade` e se compromete a implementar `atacar()`.

---

```java
    private static final double REDUCAO_FISICA = 0.40;
```
> `static` — pertence à classe, não a cada objeto.
> Todos os Soldados compartilham o mesmo valor de redução.
>
> `final` — não pode ser reatribuído após a inicialização.
> Juntos, `static final` formam uma **constante de classe**.
>
> `0.40` = 40% de redução no dano recebido.
> Extrair esse valor como constante nomeada facilita ajustes futuros
> e documenta a intenção do código.

---

```java
    public Soldado(String nome, int vida, int ataqueBase, int defesa) {
        super(nome, vida, ataqueBase, defesa);
    }
```
> `super(...)` repassa os parâmetros ao construtor de `Unidade`.
> Deve ser a **primeira instrução** do construtor — o Java exige isso.

---

### `atacar` — implementação obrigatória

```java
    @Override
    public void atacar(Unidade alvo) {
        int dano = Math.max(1, ataqueBase - alvo.getDefesa());
        System.out.printf("  ⚔  %s golpeia %s causando %d de dano!%n",
                nome, alvo.getNome(), dano);
        alvo.receberDano(dano);
    }
```
> `@Override` — informa ao compilador que este método substitui o abstrato da superclasse.
> Se o nome estiver errado, o compilador avisa.
>
> `Math.max(1, ataqueBase - alvo.getDefesa())` — o dano nunca cai abaixo de 1.
> Sem isso, um inimigo com muita defesa tornaria o Soldado incapaz de causar qualquer dano,
> gerando uma batalha infinita.
>
> `alvo.getDefesa()` — usa o getter público; o Soldado não acessa a defesa do alvo diretamente.
>
> `alvo.receberDano(dano)` — polimorfismo em ação: se o alvo for um Soldado,
> o método sobrescrito dele será chamado automaticamente.

---

### `receberDano` — sobrescrito

```java
    @Override
    public void receberDano(int dano) {
        int danoReduzido = (int) (dano * (1 - REDUCAO_FISICA));
        int danoEfetivo  = Math.max(0, danoReduzido - defesa);
        System.out.printf("  🛡  %s absorve com armadura! Dano: %d → %d%n",
                nome, dano, danoEfetivo);
        super.receberDano(danoEfetivo);
    }
```
> Aqui está a **decisão de design mais importante** do Soldado:
> em vez de colocar a lógica de defesa dentro do `atacar()` de cada inimigo
> (o que seria impossível — o atacante não sabe o tipo do alvo),
> o Soldado **intercepta o próprio `receberDano()`**.
>
> Não importa quem o ataque — Arqueiro, Mago ou outro Soldado —
> a redução física sempre é aplicada.
>
> `dano * (1 - REDUCAO_FISICA)` → aplica 60% do dano (reduz 40%).
>
> `danoReduzido - defesa` → subtrai ainda a defesa base do Soldado.
>
> `super.receberDano(danoEfetivo)` — chama o método original de `Unidade`
> para de fato subtrair o HP. Sem `super`, entraria em recursão infinita.

---

## 5. Arqueiro.java — Dano Crítico

```java
package Ex10;
import java.util.Random;

public class Arqueiro extends Unidade {
```
> `import java.util.Random` — importa a classe para gerar números aleatórios.
> Necessário para implementar a chance de crítico.

---

```java
    private static final double CHANCE_CRITICO    = 0.30;
    private static final double MULTIPLICADOR_CRIT = 2.0;

    private final Random random = new Random();
```
> `CHANCE_CRITICO = 0.30` — 30% de probabilidade por ataque.
> `MULTIPLICADOR_CRIT = 2.0` — dano dobrado no acerto crítico.
>
> `private final Random random` — instância criada uma vez e reutilizada.
> Criar um `new Random()` a cada chamada seria ineficiente e poderia
> produzir sequências menos aleatórias.

---

```java
    @Override
    public void atacar(Unidade alvo) {
        boolean critico = random.nextDouble() < CHANCE_CRITICO;
```
> `random.nextDouble()` retorna um número entre 0.0 (inclusive) e 1.0 (exclusive).
> Se esse número for menor que 0.30, o ataque é crítico.
> Estatisticamente, isso ocorre em 30% das chamadas.

```java
        int danoBase  = Math.max(1, ataqueBase - alvo.getDefesa());
        int danoFinal = critico ? (int) (danoBase * MULTIPLICADOR_CRIT) : danoBase;
```
> Operador ternário: se `critico` for `true`, aplica o multiplicador; senão, usa o dano base.
> Equivalente a um `if/else` em uma única linha.

```java
        if (critico) {
            System.out.printf("  🏹 %s dispara uma flecha CRÍTICA em %s causando %d de dano! (2x)%n", ...);
        } else {
            System.out.printf("  🏹 %s dispara uma flecha em %s causando %d de dano.%n", ...);
        }
        alvo.receberDano(danoFinal);
    }
```
> Mensagens diferentes para crítico e ataque normal — a saída do programa
> reflete o que aconteceu internamente.

---

## 6. Mago.java — Sistema de Mana

```java
public class Mago extends Unidade {

    private int    manaAtual;
    private int    manaMaxima;
    private static final int    CUSTO_MANA   = 20;
    private static final double BONUS_MAGICO = 2.5;
```
> `manaAtual` e `manaMaxima` são atributos **exclusivos** do Mago.
> `Unidade` não conhece mana — encapsulamento correto.
>
> `CUSTO_MANA = 20` — cada ataque ampliado consome 20 de mana.
> `BONUS_MAGICO = 2.5` — ataque com mana causa 2.5× o ataque base.

---

```java
    public Mago(String nome, int vida, int ataqueBase, int defesa, int mana) {
        super(nome, vida, ataqueBase, defesa);
        this.manaMaxima = mana;
        this.manaAtual  = mana;
    }
```
> O construtor do Mago recebe um parâmetro extra — `mana` — que não existe em `Unidade`.
> Após o `super(...)` inicializar os atributos comuns, o Mago inicializa os seus próprios.

---

```java
    @Override
    public void atacar(Unidade alvo) {
        if (manaAtual >= CUSTO_MANA) {
            manaAtual -= CUSTO_MANA;
            int danoMagico = (int) (ataqueBase * BONUS_MAGICO);
            System.out.printf("  ✨ %s conjura uma TEMPESTADE ARCANA ... (mana restante: %d/%d)%n", ...);
            alvo.receberDano(danoMagico);
```
> **Caminho com mana:** verifica se há mana suficiente antes de gastar.
> `manaAtual -= CUSTO_MANA` — debita antes de atacar (compromisso primeiro).
> O dano mágico ignora metade da defesa do alvo (a divisão ocorre no caminho sem mana).

```java
        } else {
            int danoBasico = Math.max(1, ataqueBase - alvo.getDefesa() / 2);
            System.out.printf("  🔮 %s lança um projétil mágico ... (sem mana)%n", ...);
            alvo.receberDano(danoBasico);
        }
    }
```
> **Caminho sem mana:** ataque básico que ainda ignora metade da defesa (`defesa / 2`).
> Representa o fato de que magia penetra armaduras físicas parcialmente.
> `Math.max(1, ...)` garante dano mínimo de 1.

---

### `status` sobrescrito

```java
    @Override
    public String status() {
        return String.format("%-12s %s | Mana: %d/%d",
                nome, barraDeVida(), manaAtual, manaMaxima);
    }
```
> O Mago **adiciona informação** ao status padrão herdado.
> Em vez de reescrever tudo, chama `barraDeVida()` (herdado de `Unidade`)
> e acrescenta a mana ao final.
> Este é um uso típico de sobrescrita: estender o comportamento, não substituí-lo.

---

## 7. Batalha.java — Motor de Turnos

```java
public class Batalha {

    private Unidade unidadeA;
    private Unidade unidadeB;

    public Batalha(Unidade a, Unidade b) {
        this.unidadeA = a;
        this.unidadeB = b;
    }
```
> `Batalha` recebe dois objetos do tipo `Unidade` — o tipo pai.
> Pode receber qualquer combinação: Soldado vs Mago, Arqueiro vs Arqueiro, etc.
> Isso é possível graças ao polimorfismo — `Unidade` é o contrato comum.

---

```java
    private void exibirStatus() {
        System.out.println("  " + unidadeA.status());
        System.out.println("  " + unidadeB.status());
    }
```
> Chama `status()` em cada unidade.
> Se uma delas for um `Mago`, o `status()` sobrescrito será chamado automaticamente —
> polimorfismo acontecendo sem nenhum `instanceof` ou `if`.

---

### Loop principal

```java
    public void iniciar() {
        // ... cabeçalho da batalha ...

        int turno = 1;

        while (unidadeA.estaViva() && unidadeB.estaViva()) {
```
> O loop continua **enquanto ambas estiverem vivas**.
> Ao menos uma morte encerra o combate.

```java
            // Turno da unidade A
            unidadeA.atacar(unidadeB);

            if (!unidadeB.estaViva()) break;
```
> Verificação imediata após o ataque de A:
> se B morreu, encerra o loop antes que B possa atacar de volta.
> Sem esse `break`, B atacaria mesmo após ser eliminada.

```java
            // Turno da unidade B
            unidadeB.atacar(unidadeA);

            // Status ao fim do turno
            exibirStatus();
            turno++;
        }
```
> Cada turno completo = A ataca → verifica → B ataca → exibe status → incrementa turno.

---

### Resultado

```java
        Unidade vencedor  = unidadeA.estaViva() ? unidadeA : unidadeB;
        Unidade derrotado = unidadeA.estaViva() ? unidadeB : unidadeA;

        System.out.printf("  🏆 %s venceu a batalha!%n", vencedor.getNome());
        System.out.printf("  💀 %s foi derrotado após %d turnos.%n", derrotado.getNome(), turno);
        System.out.printf("  Vida restante de %s: %d HP%n",
                vencedor.getNome(), vencedor.getVidaAtual());
```
> Operador ternário determina quem venceu sem precisar de `instanceof`.
> `turno` registra quantos turnos durou a batalha.

---

## 8. Main.java — Ponto de Entrada

```java
    static void titulo(String texto) {
        System.out.println("\n" + "◆".repeat(3) + " " + texto + " " + "◆".repeat(3));
    }
```
> Método utilitário `static` — chamado direto na classe sem instanciar `Main`.
> Apenas formata a saída; não tem lógica de negócio.

---

### Batalha 1 — Soldado vs Arqueiro

```java
        Unidade soldado  = new Soldado ("Garen",   150, 35, 15);
        Unidade arqueiro = new Arqueiro("Caitlyn",  110, 40,  8);

        new Batalha(soldado, arqueiro).iniciar();
```
> As variáveis são do tipo `Unidade` (não `Soldado` ou `Arqueiro`).
> Isso é possível porque ambos são subclasses de `Unidade`.
> É a forma correta de trabalhar com polimorfismo — programar para a interface,
> não para a implementação.
>
> `new Batalha(...).iniciar()` — cria e usa o objeto na mesma linha.
> Funciona porque não precisamos guardar a referência da `Batalha` depois.

---

### Batalha 2 — Mago vs Soldado

```java
        Unidade mago     = new Mago    ("Lux",    120, 50,  5, 80);
        Unidade soldado2 = new Soldado ("Darius", 160, 38, 18);
```
> O Mago tem 80 de mana inicial: pode usar ataque ampliado 4 vezes (80 ÷ 20 = 4).
> Darius tem defesa alta (18) — mas o dano mágico é calculado diferente,
> o que torna esse matchup interessante.

---

### Batalha 3 — Arqueiro vs Mago

```java
        Unidade arqueiro2 = new Arqueiro("Ashe",   115, 42,  7);
        Unidade mago2     = new Mago    ("Syndra", 105, 52,  4, 60);
```
> Syndra tem mana suficiente para 3 ataques ampliados (60 ÷ 20 = 3).
> Ashe tem chance de crítico mas Syndra tem ataque base altíssimo.
> O resultado depende do RNG do Arqueiro.

---

## 9. Conceitos de POO Aplicados

### Classe Abstrata

`Unidade` define o contrato sem poder ser instanciada.
Concentra tudo que é comum; delega o que é específico.

### Método Abstrato

`atacar(Unidade alvo)` obriga cada subclasse a implementar.
`Batalha` chama `atacar()` sem saber qual subclasse está em uso.

### Herança

```
Unidade
├── Soldado    → herda atributos + receberDano sobrescrito
├── Arqueiro   → herda atributos + atacar com RNG
└── Mago       → herda atributos + mana + status sobrescrito
```

### Polimorfismo

```java
Unidade[] unidades = { new Soldado(...), new Arqueiro(...), new Mago(...) };
for (Unidade u : unidades) {
    u.status();    // cada um responde com sua versão
    u.atacar(...); // cada um aplica sua regra
}
```

### Sobrescrita (`@Override`)

| Classe    | Método sobrescrito  | Motivo                                  |
|-----------|---------------------|-----------------------------------------|
| `Soldado` | `receberDano()`     | Interceptar e reduzir o dano recebido   |
| `Mago`    | `status()`          | Incluir mana no status exibido          |
| Todos     | `atacar()`          | Cada um ataca de forma diferente        |

### Encapsulamento

- `mana` existe apenas em `Mago` — `Unidade` não sabe disso
- `REDUCAO_FISICA` existe apenas em `Soldado`
- `CHANCE_CRITICO` existe apenas em `Arqueiro`
- `Batalha` acessa as unidades só pelos métodos públicos (`atacar`, `estaViva`, `status`)

---

## 10. Fluxo de Execução — Passo a Passo

```
Main.main()
│
├── Cria Soldado("Garen", 150, 35, 15)
│     └── Unidade(nome, vida, ataque, defesa) — vidaAtual = 150
│
├── Cria Arqueiro("Caitlyn", 110, 40, 8)
│     └── Unidade(nome, vida, ataque, defesa) — vidaAtual = 110
│
└── new Batalha(soldado, arqueiro).iniciar()
      │
      └── while(garen.estaViva() && caitlyn.estaViva())
            │
            ├── TURNO 1
            │     ├── garen.atacar(caitlyn)
            │     │     ├── dano = max(1, 35 - 8) = 27
            │     │     └── caitlyn.receberDano(27)  → vidaAtual = 83
            │     │
            │     ├── caitlyn.estaViva()? → true (83 > 0)
            │     │
            │     ├── caitlyn.atacar(garen)
            │     │     ├── random.nextDouble() < 0.30? → false (ataque normal)
            │     │     ├── dano = max(1, 40 - 15) = 25
            │     │     └── garen.receberDano(25)
            │     │           ├── danoReduzido = 25 * 0.60 = 15
            │     │           ├── danoEfetivo  = max(0, 15 - 15) = 0
            │     │           └── super.receberDano(0) → vidaAtual = 150
            │     │
            │     └── exibirStatus() → Garen 150/150 | Caitlyn 83/110
            │
            ├── TURNO 2, 3, 4 ... (mesmo fluxo)
            │
            └── TURNO 5: garen.atacar(caitlyn) → caitlyn.vidaAtual = 0
                  └── !caitlyn.estaViva() → break
                        └── vencedor = garen → exibe resultado
```

---

## 11. Decisões de Design

### Por que sobrescrever `receberDano()` no Soldado e não `atacar()` nos inimigos?

Se a lógica de defesa do Soldado ficasse no `atacar()` dos inimigos:

```java
// ✗ Errado — Arqueiro precisaria saber que o alvo é Soldado
public void atacar(Unidade alvo) {
    if (alvo instanceof Soldado) {    // quebra o polimorfismo
        dano = dano * 0.6;
    }
    alvo.receberDano(dano);
}
```

Ao sobrescrever `receberDano()` no Soldado, o Soldado gerencia sua própria defesa,
e nenhum outro código precisa saber disso:

```java
// ✔ Correto — o Soldado cuida de si mesmo
@Override
public void receberDano(int dano) {
    int reduzido = (int) (dano * 0.6) - defesa;
    super.receberDano(Math.max(0, reduzido));
}
```

### Por que `Batalha` recebe `Unidade` e não os tipos concretos?

```java
// ✗ Rígido — só funciona para Soldado vs Arqueiro
public Batalha(Soldado a, Arqueiro b) { ... }

// ✔ Flexível — funciona para qualquer combinação
public Batalha(Unidade a, Unidade b) { ... }
```

### Por que `Math.max(1, dano)` no cálculo de ataque?

Garante que o atacante sempre cause **no mínimo 1 de dano**, mesmo que a defesa
supere o ataque. Sem isso, batalhas entre unidades com defesa alta poderiam
durar infinitamente (dano = 0 para sempre).

### Por que `static final` para as constantes?

```java
private static final double REDUCAO_FISICA = 0.40;
```

`static` — um único valor na memória, compartilhado por todos os objetos da classe.
`final`  — o valor não muda após a inicialização, comunicando a intenção de constante.
Nome em `MAIÚSCULO_SNAKE_CASE` — convenção Java para constantes; sinaliza ao leitor
que o valor não varia.

---

*Exercício 10 — Jogo com Unidades de Combate | Série de POO em Java*