# ♨️ TRABALHO DE PROGRAMAÇÃO ORIENTADA A OBJETO


## 📋 Instruções Gerais

Desenvolver os **4 exercícios abaixo**, cada um em **uma pasta
separada** dentro do projeto.

Durante a apresentação, esteja preparado para responder perguntas como:

-   **Como você implementou determinada lógica?**
-   **Como poderia modificar o comportamento de determinado método?**
-   **Por que escolheu determinada estrutura ou abordagem?**

⚠️ **Importante:**\
Os **casos de teste fornecidos não podem ser alterados**, mas **novos
testes podem ser adicionados** para auxiliar na validação da solução.

------------------------------------------------------------------------

# 🧪 Exercício 1 --- Máquina de Água

## 🎯 Objetivo

Implementar uma máquina de água respeitando os fundamentos de
**Programação Orientada a Objetos**.

### 📚 Tópicos abordados

-   Abstrações
-   Classes
-   Objetos
-   Construtores
-   Validação
-   Atributos
-   Estado
-   Comportamento
-   Comandos e consultas
-   Exceções
-   Especificações

------------------------------------------------------------------------

## 📖 Descrição

Considere uma **máquina de água sofisticada** que funciona da seguinte
forma:

-   A máquina é abastecida com uma **bombona de 20 litros (20000 mL)**.
-   Ao pressionar o botão **abastecer água**, o contador é reiniciado
    para **20000 mL**.
-   A máquina possui copos descartáveis com duas capacidades:

  Tipo de Copo   Capacidade   Quantidade ao abastecer
  -------------- ------------ -------------------------
  Copo pequeno   200 mL       100 unidades
  Copo grande    300 mL       100 unidades

Após o abastecimento:

-   Usuários podem pressionar:
    -   botão **servir 200 mL**
    -   botão **servir 300 mL**
-   A máquina:
    -   retira automaticamente um copo
    -   enche com água
    -   atualiza o painel com os valores restantes

### ❌ O pedido **não é atendido** se:

-   não houver água suficiente
-   não houver copos disponíveis

------------------------------------------------------------------------

# 🔥 Exercício 2 --- Forno Inteligente

## 🎯 Objetivo

Modelar um **forno inteligente controlado por aplicativo (Android/iOS)**
utilizando conceitos de **POO**.

------------------------------------------------------------------------

## 📖 Descrição

Os fornos variam conforme:

-   Volume
-   Tensão
-   Potência
-   Dimensões

Dimensões são representadas por:

-   **largura**
-   **altura**
-   **profundidade**

Todas em **centímetros (cm)**.

------------------------------------------------------------------------

## ⚙️ Funcionalidades

O forno deve permitir:

-   ligar
-   desligar
-   aumentar temperatura
-   diminuir temperatura
-   configurar timer

### 🌡️ Temperatura

Faixa de operação:

50°C até 300°C

Com steps:

50 → 100 → 150 → 200 → 220 → 250 → 300

------------------------------------------------------------------------

## ⏱️ Timer

-   Intervalo permitido: **1 a 120 minutos**
-   O método `tick()` representa **1 minuto decorrido**
-   Quando o timer chega a **0**, o forno **desliga automaticamente**

------------------------------------------------------------------------

# 🏦 Exercício 3 --- Conta Bancária e Transações

## 🎯 Objetivo

Implementar um sistema simples de **conta bancária com histórico de
transações**.

------------------------------------------------------------------------

## 🧾 Classe `ContaBancaria`

Métodos:

-   `depositar(double valor)`
-   `sacar(double valor)`
-   `consultarSaldo()`
-   `getHistorico()`

------------------------------------------------------------------------

## 📄 Classe `Transacao`

Atributos:

-   `tipo` (String): "depósito" ou "saque"
-   `valor` (double)
-   `data` (LocalDateTime)

------------------------------------------------------------------------

# 📚 Exercício 4 --- Biblioteca

## 🎯 Objetivo

Criar um sistema simples de **gerenciamento de biblioteca utilizando
listas de objetos**.

------------------------------------------------------------------------

## 📖 Classe `Livro`

Atributos:

-   `titulo` (String)
-   `autor` (String)
-   `disponivel` (boolean)

------------------------------------------------------------------------

## 🏛️ Classe `Biblioteca`

Métodos obrigatórios:

-   `AdicionarLivro(Livro livro)`
-   `EmprestarLivro(String titulo)`
-   `DevolverLivro(String titulo)`
-   `ListarLivros()`

------------------------------------------------------------------------

# ✅ Estrutura Recomendada

    trabalho01
    │
    ├── exercicio1-maquina-agua
    ├── exercicio2-forno
    ├── exercicio3-conta-bancaria
    ├── exercicio4-biblioteca
    └── README.md
