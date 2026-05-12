# Exercício 3 — Sistema acadêmico com avaliação diferente por disciplina

## Contexto

Uma instituição possui diferentes tipos de disciplinas:

* disciplina teórica
* disciplina prática
* disciplina de projeto

Todas possuem:

* nome
* carga horária
* professor responsável

Mas a forma de cálculo da média final é diferente.

## Objetivo

Criar uma classe abstrata `Disciplina` e subclasses com regras distintas de avaliação.

## Requisitos

A superclasse deve ter:

* atributos comuns
* método abstrato `calcularMediaFinal()`
* método concreto `verificarAprovacao()`, considerando média mínima 6.0
* método `exibirSituacao()`

Crie as subclasses:

* `DisciplinaTeorica`
* `DisciplinaPratica`
* `DisciplinaProjeto`

### Regras

* `DisciplinaTeorica`: média entre prova 1 e prova 2
* `DisciplinaPratica`: média entre prática e relatório
* `DisciplinaProjeto`: média ponderada entre entrega parcial, entrega final e apresentação

## Desafio

A superclasse deve usar o resultado do método polimórfico para verificar aprovação sem precisar saber o tipo concreto.
