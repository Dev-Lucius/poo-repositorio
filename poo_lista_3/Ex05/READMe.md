# Exercício 5 — Sistema bancário com restrições reais por conta

## Contexto

Um banco oferece diferentes tipos de conta:

* conta corrente
* conta poupança
* conta empresarial

Todas compartilham:

* número
* titular
* saldo

Mas regras de saque, depósito e tarifas variam.

## Objetivo

Criar uma hierarquia útil, com regras de negócio relevantes.

## Requisitos

Crie uma classe abstrata `ContaBancaria` com:

* número
* titular
* saldo
* método `depositar(double valor)`
* método abstrato `sacar(double valor)`
* método `consultarSaldo()`

Crie:

* `ContaCorrente`
* `ContaPoupanca`
* `ContaEmpresarial`

### Regras

* `ContaCorrente`: pode sacar pagando tarifa por operação
* `ContaPoupanca`: não pode sacar além do saldo, sem tarifa
* `ContaEmpresarial`: possui limite de crédito adicional

## Desafio

Modelar corretamente o comportamento da conta empresarial sem duplicar a lógica das demais.