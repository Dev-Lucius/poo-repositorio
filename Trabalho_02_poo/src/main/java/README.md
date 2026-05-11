# Sistema de Gestão de Remoções e Transportes Clínicos

> Trabalho II — Programação Orientada a Objetos 2026/1  
> Modelagem de um sistema de operações clínicas de transporte em Java, com foco em herança, polimorfismo, interfaces e encapsulamento.

---

## Sumário

- [Visão Geral](#visão-geral)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Diagrama de Classes](#diagrama-de-classes)
- [Componentes do Sistema](#componentes-do-sistema)
  - [Enums](#enums)
  - [Interfaces](#interfaces)
  - [Veículos](#veículos)
  - [Profissional](#profissional)
  - [Operações Clínicas](#operações-clínicas)
- [Regras de Negócio](#regras-de-negócio)
  - [Cálculo de Custo](#cálculo-de-custo)
  - [Cálculo de Prioridade](#cálculo-de-prioridade)
  - [Validações de Compatibilidade](#validações-de-compatibilidade)
  - [Ciclo de Vida do Status](#ciclo-de-vida-do-status)
- [Como Executar](#como-executar)
- [Simulação no Main](#simulação-no-main)
- [Requisitos Técnicos Atendidos](#requisitos-técnicos-atendidos)

---

## Visão Geral

Uma empresa presta serviços para hospitais, clínicas e laboratórios, realizando diferentes tipos de **operações clínicas de transporte**. Este sistema modela essas operações de forma orientada a objetos, garantindo extensibilidade, validação de regras de negócio e rastreamento completo de cada operação.

---

## Estrutura do Projeto

```
src/main/java/
│
├── Main.java                                  # Ponto de entrada — simulação com 8 operações
│
└── clinico/
    ├── enums/
    │   ├── StatusOperacao.java                # SOLICITADA, APROVADA, EM_EXECUCAO, CONCLUIDA, CANCELADA
    │   ├── NivelUrgencia.java                 # BAIXA, MEDIA, ALTA, CRITICA
    │   ├── NivelClinico.java                  # ESTAVEL, OBSERVACAO, GRAVE, CRITICO
    │   └── TipoProfissional.java              # MOTORISTA, ENFERMEIRO, MEDICO, FARMACEUTICO, TECNICO_EQUIPAMENTO
    │
    ├── interfaces/
    │   ├── Custeavel.java                     # calcularCusto()
    │   ├── Auditavel.java                     # gerarLogAuditoria()
    │   ├── Priorizavel.java                   # calcularPrioridade()
    │   ├── Validavel.java                     # validar()
    │   └── Rastreavel.java                    # obterDescricaoRastreamento()
    │
    └── model/
        ├── Profissional.java                  # nome, registro, tipo
        │
        ├── veiculo/
        │   ├── Veiculo.java                   # ABSTRATA — placa, modelo, capacidade, disponível
        │   ├── AmbulanciaSimples.java          # maca, oxigênio
        │   ├── AmbulanciaUTI.java             # respirador, monitor, equipe fixa
        │   ├── VanRefrigerada.java            # temperatura atual, controle de temp.
        │   └── UtilitarioCarga.java           # volume máximo, rampa de acesso
        │
        └── operacao/
            ├── OperacaoClinica.java           # ABSTRATA — atributos e métodos comuns
            ├── TransporteMedicamentoControlado.java
            ├── TransporteAmostraBiologica.java
            ├── TransporteEquipamentoMedico.java
            └── RemocaoPaciente.java
```

---

## Diagrama de Classes

```
«interfaces»
Custeavel     Auditavel     Priorizavel     Validavel     Rastreavel
    └──────────────────────────┬───────────────────────────────┘
                               │ implementa
                    ┌──────────▼──────────┐
                    │   OperacaoClinica   │  ← classe abstrata
                    │   (classe abstrata) │
                    └──────────┬──────────┘
                               │ herança
           ┌───────────────────┼───────────────────┐
           ▼                   ▼                   ▼                   ▼
TransporteMedicamento  TransporteAmostra  TransporteEquipamento  RemocaoPaciente
  Controlado              Biologica           Medico

                    ┌──────────────────┐
                    │     Veiculo      │  ← classe abstrata
                    └────────┬─────────┘
                             │ herança
           ┌─────────────────┼──────────────────┐
           ▼                 ▼                  ▼                  ▼
  AmbulanciaSimples   AmbulanciaUTI     VanRefrigerada    UtilitarioCarga

                    ┌──────────────────┐
                    │   Profissional   │  ← composição com OperacaoClinica
                    └──────────────────┘
```

---

## Componentes do Sistema

### Enums

| Enum | Valores |
|------|---------|
| `StatusOperacao` | `SOLICITADA`, `APROVADA`, `EM_EXECUCAO`, `CONCLUIDA`, `CANCELADA` |
| `NivelUrgencia` | `BAIXA`, `MEDIA`, `ALTA`, `CRITICA` |
| `NivelClinico` | `ESTAVEL`, `OBSERVACAO`, `GRAVE`, `CRITICO` |
| `TipoProfissional` | `MOTORISTA`, `ENFERMEIRO`, `MEDICO`, `FARMACEUTICO`, `TECNICO_EQUIPAMENTO` |

---

### Interfaces

Todas implementadas pela classe abstrata `OperacaoClinica`, com comportamento sobrescrito em cada subclasse onde necessário.

| Interface | Método | Responsabilidade |
|-----------|--------|-----------------|
| `Custeavel` | `calcularCusto()` | Retorna o custo total da operação em `double` |
| `Auditavel` | `gerarLogAuditoria()` | Gera string detalhada para fins de auditoria |
| `Priorizavel` | `calcularPrioridade()` | Retorna um inteiro de prioridade para ordenação |
| `Validavel` | `validar()` | Verifica se veículo e equipe são compatíveis com a operação |
| `Rastreavel` | `obterDescricaoRastreamento()` | Retorna descrição resumida com origem, destino e status |

---

### Veículos

A classe abstrata `Veiculo` define os atributos comuns: `placa`, `modelo`, `capacidadeMaximaKg` e `disponivel`, além do método `suportaPeso(double)`.

| Classe | Atributos específicos |
|--------|-----------------------|
| `AmbulanciaSimples` | `possuiMaca`, `possuiOxigenio` |
| `AmbulanciaUTI` | `possuiRespirador`, `possuiMonitorCardiaco`, `possuiEquipeMedicaFixa` — oxigênio sempre presente |
| `VanRefrigerada` | `temperaturaAtual`, `suportaControleTemperatura` — método `temperaturaAderenteFaixa(min, max)` |
| `UtilitarioCarga` | `volumeMaximoLitros`, `possuiRampaAcesso` |

---

### Profissional

Representa um profissional da equipe. Cada operação pode conter vários profissionais (composição via `List<Profissional>`).

```java
Profissional(String nome, String registroProfissional, TipoProfissional tipo)
```

---

### Operações Clínicas

A classe abstrata `OperacaoClinica` centraliza os atributos e comportamentos comuns:

**Atributos:** `codigo`, `origem`, `destino`, `distanciaKm`, `solicitante`, `dataHoraSolicitacao`, `status`, `veiculoDesignado`, `equipe`.

**Métodos de transição de status:** `aprovar()`, `iniciar()`, `concluir()`, `cancelar()`.

**Método auxiliar protegido:** `equipeContemTipo(TipoProfissional)` — utilizado pelas subclasses nas validações, sem expor a lista de equipe diretamente.

Cada subclasse implementa obrigatoriamente:

| Método | Implementação |
|--------|---------------|
| `getTipo()` | Retorna o nome legível do tipo de operação |
| `calcularCusto()` | Aplica a fórmula de custo específica |
| `calcularPrioridade()` | Define o peso de prioridade da operação |
| `validar()` | Verifica compatibilidade de veículo e equipe |
| `obterDescricaoRastreamento()` | Sobrescreve o rastreamento base com dados específicos |

---

## Regras de Negócio

### Cálculo de Custo

**Transporte de Medicamento Controlado**

```
custo = 40 + (distância × 2.5)
      + 35  (se exige refrigeração)
      + 20  (se exige autorização farmacêutica)
```

**Transporte de Amostra Biológica**

```
custo = 30 + (distância × 2)
      + 40  (urgência ALTA)
      + 80  (urgência CRÍTICA)
      + 50  (risco biológico)
      + 25  (prazo < 60 minutos)
```

**Transporte de Equipamento Médico**

```
custo = 50 + (distância × 1.2)
      + 60   (peso > 100 kg)
      + 70   (exige técnico acompanhante)
      + 2%   do valor estimado (se exige seguro)
```

**Remoção de Paciente**

```
custo = 100 + (distância × 4)
      + 30   (necessita oxigênio)
      + 150  (necessita UTI móvel)
      + 120  (necessita médico acompanhante)
```

---

### Cálculo de Prioridade

| Operação | Critério | Valor |
|----------|----------|-------|
| Medicamento Controlado | Base + autorização (+2) + refrigeração (+1) | 3–6 |
| Amostra Biológica | BAIXA=2, MÉDIA=4, ALTA=7, CRÍTICA=10 | 2–10 |
| Equipamento Médico | Base + técnico (+2) + peso (+1) | 3–6 |
| Remoção de Paciente | ESTÁVEL=3, OBSERVAÇÃO=5, GRAVE=8, CRÍTICO=10 | 3–10 |

---

### Validações de Compatibilidade

**Medicamento Controlado**

- Se exige refrigeração: veículo deve ser `VanRefrigerada` e temperatura deve estar dentro da faixa informada
- Se exige autorização farmacêutica: equipe deve conter `FARMACEUTICO`
- Temperaturas mínima e máxima são obrigatórias quando há refrigeração

**Amostra Biológica**

- Risco biológico: equipe deve ter `ENFERMEIRO`
- Urgência CRÍTICA: veículo deve estar disponível e equipe deve ter `MOTORISTA`

**Equipamento Médico**

- Peso > 100 kg: veículo deve suportar o peso (`suportaPeso()`)
- Exige técnico acompanhante: equipe deve ter `TECNICO_EQUIPAMENTO`

**Remoção de Paciente**

- Necessita UTI móvel: veículo deve ser `AmbulanciaUTI`
- Necessita oxigênio: veículo deve possuir oxigênio (`AmbulanciaUTI` sempre tem; `AmbulanciaSimples` depende do atributo)
- Nível GRAVE ou CRÍTICO: equipe deve ter `MEDICO`
- Nível CRÍTICO: obrigatório ter UTI móvel **ou** médico acompanhante

---

### Ciclo de Vida do Status

```
SOLICITADA ──aprovar()──► APROVADA ──iniciar()──► EM_EXECUCAO ──concluir()──► CONCLUIDA
     │                        │                        │
     └────cancelar()──►   CANCELADA  ◄──cancelar()────┘
```

Regras de transição implementadas em `OperacaoClinica`:

- `aprovar()` — só executa se status for `SOLICITADA`
- `iniciar()` — só executa se status for `APROVADA` **e** `validar()` retornar `true`
- `concluir()` — só executa se status for `EM_EXECUCAO`
- `cancelar()` — bloqueado apenas se status for `CONCLUIDA`

---

## Como Executar

**Pré-requisito:** Java 17 ou superior.

```bash
# 1. Compilar todos os arquivos
javac -d out $(find src -name "*.java")

# 2. Executar
java -cp out Main
```

A saída exibe, para cada operação: rastreamento, custo, prioridade, log de auditoria e o ciclo completo de status. Ao final, um ranking por prioridade e o custo total da simulação.

---

## Simulação no Main

O `main` cria uma `List<OperacaoClinica>` com **8 operações** de tipos variados e as processa de forma **totalmente polimórfica** — sem nenhum `instanceof` para tratar tipos específicos.

| Código | Tipo | Veículo | Destaque |
|--------|------|---------|----------|
| OP-001 | Medicamento Controlado | VanRefrigerada | Refrigeração + farmacêutico |
| OP-002 | Medicamento Controlado | Utilitário de Carga | Sem refrigeração |
| OP-003 | Amostra Biológica | Ambulância Simples | Urgência CRÍTICA + risco biológico |
| OP-004 | Amostra Biológica | Utilitário de Carga | Urgência BAIXA, prazo confortável |
| OP-005 | Equipamento Médico | Utilitário de Carga | Tomógrafo 180 kg + seguro |
| OP-006 | Equipamento Médico | Utilitário de Carga | Equipamento leve |
| OP-007 | Remoção de Paciente | Ambulância UTI | Paciente CRÍTICO, UTI + médico |
| OP-008 | Remoção de Paciente | Ambulância Simples | Paciente ESTÁVEL |

Além das 8 operações, há um caso de teste (OP-999) que demonstra todas as **violações de regras de status**: tentar iniciar sem aprovação, iniciar operação inválida e concluir fora do estado correto.

---

## Requisitos Técnicos Atendidos

| Requisito | Onde |
|-----------|------|
| Classe abstrata | `OperacaoClinica`, `Veiculo` |
| Herança entre operações | 4 subclasses de `OperacaoClinica` |
| Herança entre veículos | 4 subclasses de `Veiculo` |
| Interfaces | `Custeavel`, `Auditavel`, `Priorizavel`, `Validavel`, `Rastreavel` |
| Polimorfismo | `List<OperacaoClinica>` no `main`, chamadas polimórficas |
| Encapsulamento | Atributos `private` com getters em todas as classes |
| Sobrescrita de métodos | `calcularCusto`, `validar`, `obterDescricaoRastreamento` em cada subclasse |
| Enums | `StatusOperacao`, `NivelUrgencia`, `NivelClinico`, `TipoProfissional` |
| Composição | `OperacaoClinica` possui `List<Profissional>` e `Veiculo` |
| Listas de objetos | `List<OperacaoClinica>`, `List<Profissional>` |
| Validações distribuídas | Cada subclasse implementa seu próprio `validar()` |
| Ausência de `instanceof` no `main` | Confirmado — lógica encapsulada nas classes |