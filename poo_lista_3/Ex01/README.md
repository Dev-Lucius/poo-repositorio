# Exercício 1 — Sistema de funcionários com regras salariais reais

## Contexto

Uma empresa possui diferentes tipos de funcionários, mas todos possuem:

* nome
* matrícula
* salário base

Entretanto, o cálculo do salário final varia conforme o cargo.

## Objetivo

Criar uma hierarquia de funcionários em que a superclasse represente o conceito comum, mas as subclasses implementem regras específicas.

## Regras

Crie uma superclasse abstrata `Funcionario` com:

* `nome`
* `matricula`
* `salarioBase`
* método abstrato `calcularSalarioFinal()`
* método concreto `exibirResumo()`

Crie as subclasses:

* `Desenvolvedor`
* `Gerente`
* `AnalistaSuporte`

### Regras específicas

* `Desenvolvedor`: recebe bônus de 10% sobre o salário base
* `Gerente`: recebe bônus de 20% + auxílio gestão fixo
* `AnalistaSuporte`: recebe adicional por plantão, baseado em quantidade de plantões

## Desafio

A classe base deve concentrar o que é comum, mas sem conhecer detalhes indevidos das subclasses