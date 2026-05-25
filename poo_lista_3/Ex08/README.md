# Exercício 8 — Sistema de membros de assinatura

## Contexto

Uma plataforma possui assinantes com diferentes planos:

* básico
* premium
* corporativo

Todos têm:

* nome
* email
* mensalidade base

Mas os benefícios e o valor final mudam.

## Objetivo

Criar uma hierarquia para representar os planos de assinatura.

## Requisitos

Classe abstrata `PlanoAssinatura` com:

* atributos comuns
* método abstrato `calcularMensalidadeFinal()`
* método abstrato `listarBeneficios()`
* método `exibirPlano()`

Subclasses:

* `PlanoBasico`
* `PlanoPremium`
* `PlanoCorporativo`

### Regras

* `PlanoPremium`: inclui desconto anual opcional
* `PlanoCorporativo`: inclui múltiplos usuários e cobrança por quantidade de licenças
* `PlanoBasico`: regras simples

## Desafio

Criar uma simulação com vários assinantes e exibir quem paga mais e quem possui mais benefícios.